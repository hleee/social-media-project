package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.service.ServiceToInsertOneToken;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOneUser.class);

	@Autowired
	ServiceToInsertOneToken serviceToInsertOneToken;
	
	@Autowired
	TokenVO tokenVO;
	
	public int insertOneToken(TokenVO tokenVO) {
		return 0;
		
	}
	
}
