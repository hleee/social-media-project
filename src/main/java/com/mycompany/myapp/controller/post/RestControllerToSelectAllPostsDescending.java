package com.mycompany.myapp.controller.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.post.PostVo;
import com.mycompany.myapp.domain.post.PostVoWithUser;
import com.mycompany.myapp.domain.user.UserVo;
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
	public PostVoWithUser postVoWithUser;

	@Autowired
	public PostVo postVo;

	@Autowired
	public UserVo userVo;

	@Autowired
	public ResponseVo responseVo;

	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public ResponseVo selectAllPostsDescending() {

		logger.info("REST_CONTROLLER: selectAllPostsDescending() called.");

		PostVoWithUser[] allPostsListWithUsers = serviceToSelectAllPostsDescending.selectAllPostsDescending();

		// responseVO에 code, message, data 설정
		// 여기서 data는 전체 글을 역순으로 담은 목록 객체
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allPostsListWithUsers);
		logger.info("REST_CONTROLLER: code, message, and data set in responseVo.");

		return responseVo;
	}
}
