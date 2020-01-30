package com.mycompany.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.UserService;

@RestController
public class RestAPIController {

	@Autowired
	UserService uService;
	ResponseVO rVO;

	// 단일 회원 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public HashMap<String, Object> selectByID(@RequestParam("id") Long id) throws Exception {
		UserVO uVO = uService.selectByID(id);
		HashMap<String, Object> singleMap = new HashMap<String, Object>();

		singleMap.put("code", HttpStatus.OK.value());
		singleMap.put("message", "Success");
		singleMap.put("data", uVO);

		return singleMap;
	}

	// 전체 회원 조회
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HashMap<String, Object> listAll() throws Exception {
		List<UserVO> userList = uService.selectAll();
		HashMap<String, Object> allMap = new HashMap<String, Object>();

		allMap.put("code", HttpStatus.OK.value());
		allMap.put("message", "Success");
		allMap.put("data", userList);

		return allMap;
	}

//	// 회원 가입
//	@PostMapping("/user")
//	public 

}
