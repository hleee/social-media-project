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
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.post.ServiceToSelectAllPostsDescending;
import com.mycompany.myapp.service.user.ServiceToSelectOneUserById;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectAllPostsDescending {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectAllPostsDescending.class);

	@Autowired
	public ServiceToSelectAllPostsDescending serviceToSelectAllPostsDescending;

	@Autowired
	public ServiceToSelectOneUserById serviceToSelectOneUserById;

	@Autowired
	public PostVO postVO;

	@Autowired
	public UserVO userVO;

	@Autowired
	public ResponseVO responseVO;

	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public ResponseVO selectAllPostsDescending() {

		logger.info("RESTCONTROLLER: selectAllPostsDescending() called.");

		// 전체 글을 역순으로 담은 목록 객체 생성
		List<PostVO> allPostsList = serviceToSelectAllPostsDescending.selectAllPostsDescending();

		// user의 id를 이용해 각 글의 작성자 정보도 PostVO에 담아 반환
		// 글 정보 객체에서 사용자 id를 추출해 id라는 변수에 담음
		long id = postVO.getUserId();

		// 추출한 id 번호를 이용해 DB의 user 테이블에서 사용자 정보 (id, username, created_at) 조회
		UserVO userVO = serviceToSelectOneUserById.selectOneUserById(id);
		postVO.setUser(userVO);

		// responseVO에 code, message, data 설정
		// 여기서 data는 전체 글을 역순으로 담은 목록 객체
		responseVO.setCode(HttpStatus.OK);
		responseVO.setMessage("Success");
		responseVO.setData(allPostsList);
		logger.info("code, message, and data set in responseVO.");

		return responseVO;
	}
}
