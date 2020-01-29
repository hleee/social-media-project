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

	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!!";
	}

	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId(207);
		vo.setUsername("test333");
		vo.setPassword("qwer1234");
		vo.setCreatedAt("2019-11-22T09:30:58.941+0000");
		return vo;
	}

	@RequestMapping("/membersList")
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId(207 + i);
			vo.setUsername("test333" + i);
			vo.setPassword("qwer1234" + i);
			vo.setCreatedAt("2019-11-22 +" + i + " T09:30:58.941+0000");
			list.add(vo);
		}
		return list;
	}

	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap() {
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId(207 + i);
			vo.setUsername("test333" + i);
			vo.setPassword("qwer1234" + i);
			vo.setCreatedAt("2019-11-22 + " + i + " T09:30:58.941+0000");
			map.put(i, vo);
		}
		return map;
	}

	@RequestMapping(value = "/notice/{num}", method = RequestMethod.GET)
	public int notice(@PathVariable("num") int num) throws Exception {
		return num;
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void modify(@RequestBody MemberVO vo) {
		logger.info(vo.toString());
	}

	@RequestMapping("/membersList2")
	public ResponseEntity<List<MemberVO>> listMembers2() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId(207 + i);
			vo.setUsername("test333" + i);
			vo.setPassword("qwer1234" + i);
			vo.setCreatedAt("2019-11-22 + " + i + " T09:30:58.941+0000");
			list.add(vo);
		}
		return new ResponseEntity<List<MemberVO>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/res3")
	public ResponseEntity<String> res3() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset = utf-8");
		String message = "<script>";
		message += " alert('새 회원을 등록했습니다.');";
		message += " location.href='/myapp/test/membersList2'; ";
		message += " </script>";
		return new ResponseEntity<String>(message, responseHeaders, HttpStatus.CREATED);
	}

}