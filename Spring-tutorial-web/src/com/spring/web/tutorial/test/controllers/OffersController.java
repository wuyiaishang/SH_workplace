package com.spring.web.tutorial.test.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.tutorial.test.dao.Offer;
import com.spring.web.tutorial.test.service.OffersService;

@Controller
public class OffersController {

	/*
	 * @RequestMapping("/") public ModelAndView showHome(HttpSession session){
	 * 
	 * session.setAttribute("name", "Roy");
	 * 
	 * ModelAndView mv = new ModelAndView("home"); Map<String, Object> map =
	 * mv.getModel(); map.put("name", "Bob");
	 * 
	 * return mv; }
	 */

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offer> list = offersService.getCurrent();

		model.addAttribute("offers", list);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model) {

		return "createoffer";
	}

}
