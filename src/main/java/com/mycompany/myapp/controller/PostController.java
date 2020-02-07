package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.PostVo;
import com.mycompany.myapp.domain.PostVoWithUser;
import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.service.PostService;
import com.mycompany.myapp.service.TokenService;
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/post/**")
public class PostController {

	static Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	public PostService postService;

	@Autowired
	public PostVo postVo;

	@Autowired
	public UserVo userVo;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public TokenService tokenService;

	@Autowired
	public UserService userService;

	@Autowired
	public PostVoWithUser postVoWithUser;

	// 글 저장
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseVo insertOnePost(@RequestBody PostVo postVo, @CookieValue("accesstoken") String token)
			throws Exception {
		return postService.insertOnePost(postVo, token);
	}

	// 전체 글 조회
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseVo selectAllPostsDescending() {
		return postService.selectAllPostsDescending();
	}

	// 내 글 조회
	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public ResponseVo selectMyPosts(@CookieValue("accesstoken") String token) throws Exception {
		TokenVo tokenVo = tokenService.selectOneTokenRowByToken(token);
		Long userId = tokenVo.getUserId();
		return postService.selectMyPosts(userId);
	}

	// 글 상세 조회
	@RequestMapping(value = "/{postId}", method = RequestMethod.GET)
	public ResponseVo selectOnePostDetailedView(@PathVariable("postId") long postId) {
		return postService.selectOnePostById(postId);
	}

	// 글 삭제
	@RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
	public ResponseVo deleteOnePost(@PathVariable("postId") long postId) {
		return postService.deleteOnePost(postId);
	}

}
