package com.hackathon.agenda.analysis.dao;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

@Component("agendaDao")
public class AgendaDao {
	
	
   public List<String> getContext(String keyword, String url_){
	   
	// File pdfFile = new File(pdf_file);

			PDDocument document = null;
			String pattern = "((\\w+ ){1,3}|^)(\\W)*" + keyword + "(\\W)*(( \\w+){1,3}|$)";
			// String result="";
			List<String> result = new ArrayList<String>();
			Pattern p = Pattern.compile(pattern);
			try {
				
				//System.out.println("------"+nUrl);
				URL url = new URL(url_);
				// document=PDDocument.load(pdfFile);
				InputStream urlStream = url.openStream();
				document = PDDocument.load(urlStream);

				// get page number
				int pages = document.getNumberOfPages();
				PDFTextStripper stripper = new PDFTextStripper();
				stripper.setSortByPosition(true);
				// read text content page by page
				for (int i = 0; i <= pages; i++) {
					stripper.setStartPage(i);
					stripper.setEndPage(i);
					String content = stripper.getText(document);
					System.out.println(content);
					String[] strs = content.split("\n");
					int line_number = 0;
					for (String str : strs) {
						Matcher match = p.matcher(str);
						while (match.find()) {
						//	System.out.println("Found keyword: " + match.group(0) + " in line: " + line_number + " page: "
						//			+ i + " at position " + match.start(0));

							result.add(match.group(0) + "(page: " + i + " line: " + line_number + ")");
							// result=result+strs[line_number]+"(page: "+i+" line:
							// "+line_number+")"+"\n";
						//	System.out.println(str);

						}
						line_number++;

					}
				}

				document.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				return result;
			}

		}
}
