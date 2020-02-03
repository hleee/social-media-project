package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToInsertOneToken;
import com.mycompany.myapp.service.ServiceToSelectOneUserByUsernameAndPassword;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOneToken.class);

	@Autowired
	ServiceToInsertOneToken serviceToInsertOneToken;

	@Autowired
	ServiceToSelectOneUserByUsernameAndPassword serviceToSelectOneUserByUsernameAndPassword;

	@Autowired
	UserVO userVO;

	@Autowired
	TokenVO tokenVO;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public UserVO insertOneToken(@RequestBody UserVO userVO) throws Exception {

		UserVO userVOWithToken = serviceToSelectOneUserByUsernameAndPassword.selectOneUserByUsernameAndPassword(userVO);

		return 0;

	}

}
