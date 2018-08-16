package com.ssu.miso.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssu.miso.service.UserService;
import com.ssu.miso.vo.MemberVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String userid, @RequestParam("pwd") String userpwd, Model model,
			HttpSession session) throws Exception {
		// db저장 ->성공페이지 이동

		logger.info("login post...");
		logger.info(userid);
		session.removeAttribute("member");

		MemberVO userInfo = service.login(userid, userpwd);

		if (userInfo == null) {
			// model.addAttribute("login_result", "fail");
		} else {
			logger.info("login... " + userInfo.toString());
			userInfo.setPassword("");
			session.setAttribute("member", userInfo);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) throws Exception {
		// db저장 ->성공페이지 이동

		logger.info("logout post...");
		session.removeAttribute("member");

		return "redirect:/";
	}
}
