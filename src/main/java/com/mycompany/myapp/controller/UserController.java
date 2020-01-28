package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserVO>> listArticles() {
		logger.info("listArticles 메서드로 모든 글 정보 조회");
		List<UserVO> list = new ArrayList<UserVO>();
		for (int i = 0; i < 10; i++) {
			UserVO vo = new UserVO();
			vo.setArticleNO(i);
			vo.setWriter("이율곡" + i);
			vo.setTitle("안녕하세요" + i);
			vo.setContent("새 상품을 소개합니다." + i);
			list.add(vo);
		}

		return new ResponseEntity<List<UserVO>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/{articleNO}", method = RequestMethod.GET)
	public ResponseEntity<UserVO> findArticle(@PathVariable("articleNO") Integer articleNO) {
		logger.info("findArticle 메서드로 해당 번호의 글만 조회");
		UserVO vo = new UserVO();
		vo.setArticleNO(articleNO);
		vo.setWriter("홍길동");
		vo.setTitle("안뇽하세요");
		vo.setContent("홍길동의 글입니다.");
		return new ResponseEntity<UserVO>(vo, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addArticle(@RequestBody UserVO userVO) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("addArticle 메서드로 JSON으로 전달되는 객체를 새 글로 게시");
			logger.info(userVO.toString());
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return resEntity;
	}

	@RequestMapping(value = "/{articleNO}", method = RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO,
			@RequestBody UserVO userVO) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("modArticle 메서드로 글 번호에 해당하는 글을 JSON 정보로 수정");
			logger.info(userVO.toString());
			resEntity = new ResponseEntity<String>("MOD_SUCCEEDED", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return resEntity;
	}

	@RequestMapping(value = "/{articleNO}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeArticle(@PathVariable("articleNO") Integer articleNO) {
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("removeArticle 메서드로 글 번호에 해당하는 글 삭제");
			logger.info(articleNO.toString());
			resEntity = new ResponseEntity<String>("REMOVE_SUCCEEDED", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return resEntity;
	}

}
