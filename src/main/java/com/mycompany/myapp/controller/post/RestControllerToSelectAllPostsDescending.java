package com.mycompany.myapp.controller.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
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
	public UserVo userVo;

	@Autowired
	public ResponseVo responseVo;

	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public ResponseVo selectAllPostsDescending() {

		logger.info("REST_CONTROLLER: selectAllPostsDescending() called.");

		// 전체 글을 역순으로 담은 목록 객체 생성
		List<PostVoWithUser> allPostsList = serviceToSelectAllPostsDescending.selectAllPostsDescending();

		// allPostsList를 돌며 사용자 userId를 추출해 변수에 담음
		for (PostVoWithUser postVoWithUser : allPostsList) {

			logger.info("REST_CONTROLLER: For loop entered to extract userId.");

			long userId = postVoWithUser.getUserId();
			logger.info("REST_CONTROLLER: userId retrieved.");

			// 추출한 id 번호를 이용해 DB의 user 테이블에서 글쓴이의 정보 (id, username, created_at) 조회
			// 그 정보를 userVo 객체에 넣어 postVO에 담음
			UserVo userVo = serviceToSelectOneUserById.selectOneUserById(userId);
			logger.info("REST_CONTROLLER: user info contained in userVo " + userVo);

			postVoWithUser.setUser(userVo);
		}

		// responseVO에 code, message, data 설정
		// 여기서 data는 전체 글을 역순으로 담은 목록 객체
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allPostsList);
		logger.info("REST_CONTROLLER: code, message, and data set in responseVo.");

		return responseVo;
	}
}
