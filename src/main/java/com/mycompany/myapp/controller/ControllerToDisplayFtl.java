package com.mycompany.myapp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// 여기는 페이지 이동용 컨트롤러 (ModelAndView), RestController는 json 값을 주고 받을 떄
@Controller
public class ControllerToDisplayFtl {

	static Logger logger = LoggerFactory.getLogger(ControllerToDisplayFtl.class);

	// signup.ftl로 가서 ftl에 포함되어 있는 signup.js가 실행이 되고 거기 써있는 대로 /login으로 이동
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {

		logger.info("ModelAndView called for signup.");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup");
		return mav;
	}

	// signup.js에서 href를 타고 들어와서 login.ftl로 가서 login.js가 실행이 됨
	// 그러면 또 거기 써있는 대로 루트로 이동 (index.ftl)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		logger.info("ModelAndView called for login.");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	// index.js에서
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {

		logger.info("ModelAndView called for index.");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

}
