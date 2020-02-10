package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.FollowVo;
import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.service.FollowService;

@RestController
@RequestMapping("/*")
public class FollowController {

	static Logger logger = LoggerFactory.getLogger(FollowController.class);

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public FollowVo followVo;

	@Autowired
	public FollowService followService;

	// 팔로워-팔로이 한 쌍 삽입
	@RequestMapping(value = "/follow", method = RequestMethod.POST)
	public ResponseVo insertOneFollow(@CookieValue("accesstoken") String token, @RequestBody FollowVo followVo)
			throws Exception {
		return followService.insertOneFollow(followVo, token);
	}

	// 팔로워-팔로이 한 쌍 삭제
	@RequestMapping(value = "/follow", method = RequestMethod.DELETE)
	public ResponseVo deleteOneFollow(@CookieValue("accesstoken") String token, @RequestBody FollowVo followVo)
			throws Exception {
		return followService.deleteOneFollow(followVo, token);
	}

}
