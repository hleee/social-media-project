package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToSelectOneUserByUsernameAndPassword;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectOneUserByUsernameAndPassword {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectOneUserByUsernameAndPassword.class);

	@Autowired
	ServiceToSelectOneUserByUsernameAndPassword service;
	
	@Autowired
	UserVO userVO;
	
	
	
}
