package com.mycompany.myapp.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/*")
public class ControllerToGetOneUser {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public HashMap<String, Object> selectByID(@RequestParam("id") Long id) throws Exception {
		UserVO userVO = userService.selectByID(id);
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", HttpStatus.OK.value());
		map.put("message", "Success");
		map.put("data", userVO);

		return map;
	}

}
