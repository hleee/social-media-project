package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToInsertOneUser;

@RestController
@RequestMapping("/*")
public class ControllerToPostOneUser {

	static Logger logger = LoggerFactory.getLogger(ControllerToPostOneUser.class);

	@Autowired
	ServiceToInsertOneUser serviceToInsertOneUser;

	@Autowired
	UserVO userVO;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> insertOneUser(@RequestBody UserVO userVO) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("Try loop entered");
			logger.info(userVO.toString());
			// service의 insert 메서드를 호출
			// vo 객체를 insert로 전달한 것의 반환값을 resSignUp에 담음
			int integerOneIfInserted = serviceToInsertOneUser.insertOneUser(userVO);
			logger.info("DB에 추가됐으면 정수 1 반환: " + integerOneIfInserted);
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
			// 응답 객체 출력해보기
			logger.info("resEntity : " + resEntity);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}

}
