package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.repository.DaoToInsertOnePost;
import com.mycompany.myapp.service.ServiceToInsertOnePost;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOnePost.class);

	@Autowired
	public ServiceToInsertOnePost serviceToInsertOnePost;

	@Autowired
	public DaoToInsertOnePost daoToInsertOnePost;

	@Autowired
	public PostVO postVO;

	@Autowired
	public ResponseVO responseVO;

	// @RequestBody를 써줘야 프런트에서 입력받은 값을 인식함
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseVO insertOnePost(@RequestBody PostVO postVO) throws Exception {
		
		logger.info("insertOnePost() called");
		
		int IntegerOneIfInserted = serviceToInsertOnePost.insertOnePost(postVO);
		logger.info("Integer 1 if new post inserted: " + IntegerOneIfInserted);
		
		
		
		
		return responseVO;
	}

}
