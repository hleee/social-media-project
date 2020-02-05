package com.mycompany.myapp.controller.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.service.post.ServiceToSelectAllPostsDescending;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectAllPostsDescending {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectAllPostsDescending.class);

	@Autowired
	public ServiceToSelectAllPostsDescending serviceToSelectAllPostsDescending;

	@Autowired
	public PostVO postVO;

	@Autowired
	public ResponseVO responseVO;

	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public ResponseVO selectAllPostsDescending() {
		
		logger.info("RESTCONTROLLER: selectAllPostsDescending() called.");
		
		List<PostVO> allPostsList = serviceToSelectAllPostsDescending.selectAllPostsDescending();

		// responseVO에 code, message, data 설정
		// 여기서 data는 전체 글을 역순으로 담은 목록 객체
		responseVO.setCode(HttpStatus.OK);
		responseVO.setMessage("Success");
		responseVO.setData(allPostsList);
		logger.info("code, message, and data set in responseVO.");

		return responseVO;
	}
}
