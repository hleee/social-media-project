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
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/*")
public class ControllerToPostOneUser {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<String> insertUser(@RequestBody UserVO vo) {
		ResponseEntity<String> resEntity = null;
		try {
			System.out.println("=====POST method called=====");
			logger.info("insertUser method called");
			logger.info(vo.toString());
			// service의 insert 메서드를 호출
			int resSignUp = userService.insertUser(vo); // vo 객체를 insert로 전달한 것의 반환값을 resSignUp에 담음
			System.out.println("DB에 추가됐으면 정수 1 반환; resSignUp: " + resSignUp);
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
			System.out.println("resEntity : " + resEntity);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}

}
