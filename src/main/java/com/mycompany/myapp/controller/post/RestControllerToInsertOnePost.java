package com.mycompany.myapp.controller.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.repository.post.DaoToInsertOnePost;
import com.mycompany.myapp.repository.post.DaoToSelectOnePostById;
import com.mycompany.myapp.service.post.ServiceToInsertOnePost;
import com.mycompany.myapp.service.post.ServiceToSelectOnePostById;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOnePost.class);

	@Autowired
	public ServiceToInsertOnePost serviceToInsertOnePost;

	@Autowired
	public DaoToInsertOnePost daoToInsertOnePost;

	@Autowired
	public DaoToSelectOnePostById daoToSelectOnePostById;

	@Autowired
	public ServiceToSelectOnePostById serviceToSelectOnePostById;

	@Autowired
	public PostVO postVO;

	@Autowired
	public ResponseVO responseVO;

	// @RequestBody를 써줘야 컨트롤러가 프런트에서 입력받은 값을 인식함
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseVO insertOnePost(@RequestBody PostVO postVO) throws Exception {

		logger.info("insertOnePost() called");

		// 1. token을 이용해서 selectTokenVOBytoken //where token = 토큰값
		
		
		// 2. tokenVO.getUserId() 통해서 userId값 추출
		
		
		// 3. postVO.setUserId(추출한 userID값)을 통해서 postVO의 userId를 담아준다.
		
		
		// 4. postVO : userId, title, content --> insert
		
		
		int IntegerOneIfInserted = serviceToInsertOnePost.insertOnePost(postVO);
		logger.info("Integer 1 if new post inserted: " + IntegerOneIfInserted);

		postVO = serviceToSelectOnePostById.selectOnePostById(postVO);
		
		responseVO.setCode(HttpStatus.OK);
		responseVO.setMessage("Success");
		responseVO.setData(postVO);
		logger.info("code, message, and data set to responseVO.");

		return responseVO;
	}

}
