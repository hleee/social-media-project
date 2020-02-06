package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.PostVo;
import com.mycompany.myapp.domain.PostVoWithUser;
import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.repository.UserDao;
import com.mycompany.myapp.service.PostService;
import com.mycompany.myapp.service.TokenService;

@RestController
@RequestMapping("/*")
public class PostController {

	static Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	public PostService postService;

	@Autowired
	public PostVo postVo;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public TokenService tokenService;

	@Autowired
	public UserDao userDao;

	// 1. 글 저장 API
	// @RequestBody를 써줘야 컨트롤러가 프런트에서 입력받은 값을 인식함 (title과 content를 가져옴)
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseVo insertOnePost(@RequestBody PostVo postVo, HttpServletRequest request) throws Exception {
		// 로그인 시 발행된 토큰 값은 쿠키에 담겨있으므로 그곳에서 가져옴
		// HttpServletRequest request.getHeader("가져올 값의 이름")이나 request.getCookie() (모든
		// 쿠킷값을 배열로 반환)
		// 혹은 애너테이션 이용 : @CookieValue("foo") String fooCookie --> foo 이름의 쿠킷값을
		// fooCookie라는 문자열로 저장
		// @RequestHeader("accesstoken") String token도 가능

		logger.info("insertOnePost() called.");

		// (i) 쿠키에 담긴 토큰 문자열을 이용해서 DB내의 토큰 데이터 행을 조회해 가져오기 (token, user_id, created_at)
		String token = request.getHeader("accesstoken");
		TokenVo tokenVo = tokenService.selectOneTokenRowByToken(token);
		logger.info("accesstoken extracted and row retrieved.");

		// (ii) tokenVO.getUserId() 통해서 userId값 추출
		Long userId = tokenVo.getUserId();
		logger.info("userId extracted.");

		// (iii) postVO.setUserId(추출한 userID값)를 통해서 postVO에 userId를 담아줌
		postVo.setUserId(userId);
		logger.info("userId attributed to postVO.");

		// (iv) postVO : userId, title, content --> insert
		int IntegerOneIfInserted = postService.insertOnePost(postVo);
		logger.info("Integer 1 if new post inserted: " + IntegerOneIfInserted);

		// (v) postVO를 다시 가져와서 글 id와 createdAt을 responseVO에 담음
		long id = postVo.getId();
		logger.info("id: " + id);
		postVo = postService.selectOnePostById(id);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(postVo);
		logger.info("code, message, and data set to responseVO.");

		return responseVo;
	}

	// 2. 전체 글 목록 조회 API
	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public ResponseVo selectAllPostsDescending() {

		logger.info("REST_CONTROLLER: selectAllPostsDescending() called.");

		PostVoWithUser[] allPostsListWithUsers = postService.selectAllPostsDescending();

		// responseVO에 code, message, data 설정
		// 여기서 data는 전체 글을 역순으로 담은 목록 객체
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allPostsListWithUsers);
		logger.info("REST_CONTROLLER: code, message, and data set in responseVo.");

		return responseVo;
	}

	// 3. 내가 쓴 글 목록 조회 API
	@RequestMapping(value = "/post/my", method = RequestMethod.GET)
	public ResponseVo selectMyPosts(HttpServletRequest request) throws Exception {

		logger.info("REST_CONTROLLER: selectMyPosts() called.");

		String token = request.getHeader("accesstoken");
		TokenVo tokenVo = tokenService.selectOneTokenRowByToken(token);
		logger.info("tokenVo retrieved: " + tokenVo);

		Long userId = tokenVo.getUserId();
		logger.info("userId extracted: " + userId);

		List<PostVo> myPostsList = postService.selectMyPosts(userId);

		PostVoWithUser[] myPostsListWithUser = new PostVoWithUser[myPostsList.size()];

		for (int i = 0; i < myPostsListWithUser.length; i++) {

			logger.info("For loop entered to fill in myPostsListWithUser.");

			// id로 회원 정보를 조회해 가져옴
			UserVo userVo = userDao.selectOneUserByID(userId);
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
