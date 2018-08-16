package com.ssu.miso.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FaqController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/faqUpdate", method = RequestMethod.GET)
	public String faqUpdatePage(Locale locale, Model model) {

		return "faqUpdate";
	}
	@RequestMapping(value = "/faqUpdate", method = RequestMethod.POST)
	public String faqUpdate(Locale locale, Model model) {

		return "faq";
	}
}
