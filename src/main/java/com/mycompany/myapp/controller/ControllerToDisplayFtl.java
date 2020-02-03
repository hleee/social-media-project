package com.mycompany.myapp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


// 여기는 페이지 이동용 컨트롤러, RestController는 json 값을 주고 받을 떄
@Controller
public class ControllerToDisplayFtl {

	static Logger logger = LoggerFactory.getLogger(ControllerToDisplayFtl.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {

		logger.info("ModelAndView called for index.");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView signup() {

		logger.info("ModelAndView called for signup.");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup");
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("login.ftl called.");
		return "login";
	}

}
