package com.hackathon.agenda.analysis.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackathon.agenda.analysis.service.AgendaService;
import com.hackathon.agenda.analysis.service.UrlService;
import com.sun.org.apache.xpath.internal.compiler.Keywords;

@Controller
public class AgendaController {

	private AgendaService agendaService;
	private UrlService urlService;
	private String url_;

	@Autowired
	public void setUrlService(UrlService urlService) {
		this.urlService = urlService;
	}

	@Autowired
	public void setAgendaService(AgendaService agendaService) {
		this.agendaService = agendaService;
	}

	@RequestMapping("/")
	public String showAgenda(Model model) throws UnsupportedEncodingException {
		Map<String, String> urlInfo = urlService.getLastInfo();
		// url_ = urlInfo.get("url");
		//url_ = "http://www.citywindsor.ca/cityhall/City-Council-Meetings/Meetings-This-Week/Documents/public%20agenda%20feb%206%202017%20with%20items%20page%20numbers.pdf";
		//String enUrl = URLEncoder.encode(url_, "UTF-8");
		//System.out.println(enUrl);
		
		url_ = urlInfo.get("url").replace(" ", "%20");
		model.addAttribute("urlInfo", urlInfo);

		return "agenda";
	}

	@RequestMapping("/contextlist")
	public String getKeyword(Model model, @RequestParam("keyword") String keyword) throws UnsupportedEncodingException {
		
		List<String> list = agendaService.showContext(keyword, url_);
		model.addAttribute("keyword", keyword);
		model.addAttribute("ctList", list);
		System.out.println("1111111111---"+"http://www.citywindsor.ca/cityhall/City-Council-Meetings/Meetings-This-Week/Documents/public%20agenda%20feb%206%202017%20with%20items%20page%20numbers.pdf");
		System.out.println("2222222222---"+url_);
		String enUrl = URLEncoder.encode(url_, "UTF-8");
		//enUrl = enUrl.replace("+", "%20");
		System.out.println(enUrl);
		
		model.addAttribute("enUrl", enUrl);
		// System.out.println(keyword);
		return "contextlist";
	}
}
