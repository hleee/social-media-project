package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FtlController {

	static Logger logger = LoggerFactory.getLogger(FtlController.class);

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(@CookieValue(value = "accesstoken", required = false) String token) { // 토큰이 있을 필요는 없으니 에러가 나지 않게
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("user", token); // 토큰이 있는 상태를 'user'라고 부르기로 --> ftl에서 조건문에 <#if user??>
		return mav;
	}

	@RequestMapping(value = "/post/detail/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetail(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		return mav;
	}
	
}
