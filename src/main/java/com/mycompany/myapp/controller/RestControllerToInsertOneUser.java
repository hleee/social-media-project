package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToInsertOneUser;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOneUser {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOneUser.class);

	@Autowired
	private ServiceToInsertOneUser serviceToInsertOneUser;

	@Autowired
	public UserVO userVO;

	@Autowired
	public ResponseVO responseVO;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseVO insertOneUser(@RequestBody UserVO userVO) throws Exception {

		logger.info("insertOneUser() initialised.");

		// 회원이 성공적으로 추가됐으면 정수 1 출력
		int integerOneIfInserted = serviceToInsertOneUser.insertOneUser(userVO);
		logger.info("Integer 1 if inserted: " + integerOneIfInserted);

		responseVO.setCode(HttpStatus.OK);
		responseVO.setMessage("Success");
		responseVO.setData(userVO);
		logger.info("code, message, and data set to responseVO.");

		return responseVO;

	}

}
