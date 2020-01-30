package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.UserService;

@RestController
public class RestAPIController {

	private static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	UserService userService;

	// 한 명 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserVO selectByID(@RequestParam("id") Long id) throws Exception {
		UserVO userVO = userService.selectByID(id);
		System.out.println(userVO);
		return userVO;
	}
	
	// 전체 회원 조회
//	@RequestMapping(value = "/all", method = RequestMethod.GET)
//	public ResponseVO listUsers() {
//		List<UserVO> userList = userService.listUsers();
//		for (UserVO user : userList) {
//			System.out.println(user);
//		}
//		
//		responseData.setCode(HttpStatus.OK);
//		responseData.setMessage("Success");
//		responseData.setData(userList);
//	
//		return responseData;
//	
//	}
	
//	// 회원 가입
//	@PostMapping("/user")
//	public 
	
	
}
