package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.service.TokenService;
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/*")
public class TokenController {

	static Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	public TokenVo tokenVo;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public TokenService tokenService;

	@Autowired
	public UserService userService;

	// 토큰 등록
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseVo insertOneToken(@RequestBody UserVo userVo) throws Exception {
		return userService.insertOneUser(userVo);
	}
}
