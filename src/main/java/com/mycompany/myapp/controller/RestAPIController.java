package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.service.UserService;

@RestController
public class RestAPIController {

	private static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserVO selectByID(@RequestParam("id") int id) throws Exception {
		UserVO userVO = userService.selectByID(id);
		System.out.println(userVO);
		return userVO;
	}
}
