package com.mycompany.myapp.controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.mycompany.myapp.domain.token.TokenVo;
import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.repository.user.DaoToSelectOneUserById;
import com.mycompany.myapp.service.post.ServiceToSelectMyPosts;
import com.mycompany.myapp.service.token.ServiceToSelectOneTokenRowByToken;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectMyPosts {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectMyPosts.class);

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public ServiceToSelectMyPosts serviceToSelectMyPosts;

	@Autowired
	public TokenVo tokenVo;

	@Autowired
	public PostVoWithUser postVoWithUser;

	@Autowired
	public ServiceToSelectOneTokenRowByToken serviceToSelectOneTokenRowByToken;

	@Autowired
	public DaoToSelectOneUserById daoToSelectOneUserById;

	@RequestMapping(value = "/post/my", method = RequestMethod.GET)
	public ResponseVo selectMyPosts(HttpServletRequest request) throws Exception {

		logger.info("REST_CONTROLLER: selectMyPosts() called.");

		String token = request.getHeader("accesstoken");
		TokenVo tokenVo = serviceToSelectOneTokenRowByToken.selectOneTokenRowByToken(token);
		logger.info("tokenVo retrieved: " + tokenVo);

		Long userId = tokenVo.getUserId();
		logger.info("userId extracted: " + userId);

		List<PostVo> myPostsList = serviceToSelectMyPosts.selectMyPosts(userId);

		PostVoWithUser[] myPostsListWithUser = new PostVoWithUser[myPostsList.size()];

		for (int i = 0; i < myPostsListWithUser.length; i++) {

			logger.info("For loop entered to fill in myPostsListWithUser.");

			// id로 회원 정보를 조회해 가져옴
			UserVo userVo = daoToSelectOneUserById.selectOneUserByID(userId);
			logger.info("userVo: " + userVo);

			// 두 VO 객체로부터 정보를 받아 한 군데로 모을 VO 객체 껍데기 생성
			PostVoWithUser postVoWithUser = new PostVoWithUser();

			// 회원 정보가 담긴 userVo를 user에 set
			postVoWithUser.setUser(userVo);
			logger.info("userVo set to postVoWithUser.");

			// 나머지 항목들도 손수 넣어줘야 함
			// allPostsList에 담긴 i 번째 PostVo 객체에서 getId()
			// 이후 새로 만든 껍데기인 postVoWithUser에 setId()
			long id = myPostsList.get(i).getId();
			postVoWithUser.setId(id);
			logger.info("id: " + id);

			long userId1 = myPostsList.get(i).getUserId();
			postVoWithUser.setUserId(userId1);
			logger.info("userId: " + userId1);

			String title = myPostsList.get(i).getTitle();
			postVoWithUser.setTitle(title);
			logger.info("title: " + title);

			String content = myPostsList.get(i).getContent();
			postVoWithUser.setContent(content);
			logger.info("content: " + content);

			String createdAt = myPostsList.get(i).getCreatedAt();
			postVoWithUser.setCreatedAt(createdAt);
			logger.info("createdAt: " + createdAt);

			myPostsListWithUser[i] = postVoWithUser;
		}

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(myPostsListWithUser);

		return responseVo;
	}

}
