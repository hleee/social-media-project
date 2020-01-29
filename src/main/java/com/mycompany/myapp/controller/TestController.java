package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	static Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/http")
	public ResponseEntity<UserVO> userResponse() {
		List<UserVO> list = new ArrayList<UserVO>();
		for (int i = 0; i < 10; i++) {
			UserVO vo = new UserVO();
			vo.setId(3 + i);
			vo.setUsername("user001" + i);
			vo.setPassword("qwer1234" + i);
			vo.setCreatedAt("lee" + i + "asdf");
			list.add(vo);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

}
