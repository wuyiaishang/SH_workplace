package com.hackathon.agenda.analysis.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


@Component("urlDao")
public class UrlDao {


	public Map<String, String> grabUrl( String url ) throws IOException {
		// try connecting
         Map<String, String> urlInfoMap = new HashMap<>();
		Connection.Response response = Jsoup.connect(url)
				.userAgent(
						"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
				.timeout(20000).ignoreHttpErrors(true).ignoreContentType(true).execute();
		// get status

		int statusCode = response.statusCode();
		if (statusCode == 200) {
			// connect successfully
			org.jsoup.nodes.Document doc = Jsoup.connect(url).timeout(20000).ignoreHttpErrors(true)
					.ignoreContentType(true).get();
			Elements links = doc.getElementsByTag("a");
			for (org.jsoup.nodes.Element link : links) {
				String sLink = link.attr("href");
				if (sLink.endsWith(".pdf")) {
					sLink = "http://www.citywindsor.ca"+sLink;
					System.out.println("1---" + sLink);
					String text = link.text();
					System.out.println(text);
					urlInfoMap.put("url", sLink);
					urlInfoMap.put("text", text);
					break;
				}
			}
		} else {
			System.out.println("received error code : " + statusCode);
		}
          return urlInfoMap;
	}

}
