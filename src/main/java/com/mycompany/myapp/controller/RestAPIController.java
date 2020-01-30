package com.mycompany.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/myapp/*")
public class RestAPIController {

	@Autowired
	UserService service;
	ResponseVO vo;

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	// 단일 회원 조회
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public HashMap<String, Object> selectByID(@RequestParam("id") Long id) throws Exception {
		UserVO vo = service.selectByID(id);
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", HttpStatus.OK.value());
		map.put("message", "Success");
		map.put("data", vo);

		return map;
	}

	// 전체 회원 조회
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HashMap<String, Object> listAll() throws Exception {
		List<UserVO> userList = service.selectAll();
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", HttpStatus.OK.value());
		map.put("message", "Success");
		map.put("data", userList);

		return map;
	}

	// 회원 가입
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> insertUser(@RequestBody UserVO vo) {
		ResponseEntity<String> resEntity = null;
		try {
			System.out.println("=====POST method called=====");
			logger.info("insertUser method called");
			logger.info(vo.toString());
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return resEntity;
	}
}
