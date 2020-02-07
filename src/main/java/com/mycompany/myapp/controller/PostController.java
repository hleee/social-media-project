package com.mycompany.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/*")
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
		
		String token = request.getHeader("accesstoken");
		postVo = postService.insertOnePost(postVo, token);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(postVo);

		return responseVo;
	}

	// 2. 전체 글 목록 조회 API
	@RequestMapping(value = "/allPosts", method = RequestMethod.GET)
	public ResponseVo selectAllPostsDescending() {

		logger.info("selectAllPostsDescending() called.");

		PostVoWithUser[] allPostsListWithUsers = postService.selectAllPostsDescending();

		// responseVO에 code, message, data 설정
		// 여기서 data는 전체 글을 역순으로 담은 목록 객체
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allPostsListWithUsers);

		return responseVo;
	}

	// 3. 내가 쓴 글 목록 조회 API
	@RequestMapping(value = "/post/my", method = RequestMethod.GET)
	public ResponseVo selectMyPosts(HttpServletRequest request) throws Exception {

		logger.info("selectMyPosts() called.");

		String token = request.getHeader("accesstoken");
		logger.info("accesstoken: " + token);

		TokenVo tokenVo = tokenService.selectOneTokenRowByToken(token);
		logger.info("tokenVo: " + tokenVo);

		Long userId = tokenVo.getUserId();
		logger.info("userId: " + userId);

		PostVoWithUser[] myPostsListWithUser = postService.selectMyPosts(userId);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(myPostsListWithUser);

		return responseVo;
	}

	// 4. 글 상세 조회 API
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public ResponseVo selectOnePostDetailedView(@PathVariable("postId") long postId) {

		PostVo postVo = postService.selectOnePostById(postId);
		long id = postVo.getId();
		long userId = postVo.getUserId();
		String title = postVo.getTitle();
		String content = postVo.getContent();
		String createdAt = postVo.getCreatedAt();

		postVoWithUser.setId(id);
		postVoWithUser.setUserId(userId);
		postVoWithUser.setTitle(title);
		postVoWithUser.setContent(content);
		postVoWithUser.setCreatedAt(createdAt);

		UserVo userVo = userService.selectOneUserById(userId);
		postVoWithUser.setUser(userVo);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(postVoWithUser);

		return responseVo;
	}

	// 5. 글 삭제 API
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.DELETE)
	public ResponseVo deleteOnePost(@PathVariable("postId") long postId) {

		int integerOneIfDeleted = postService.deleteOnePost(postId);
		logger.info("Integer 1 if deleted: " + integerOneIfDeleted);

		if (integerOneIfDeleted == 1) {
			logger.info("If statement entered.");
			
			// . 뒤가 null이면 null조차 반환을 못 함
			// long id = postVo.getId();

			// SELECT를 하면 null 값은 반환할 수 있음
			// 그 null을 postVo 객체에 담아 출력
			postVo = postService.selectOnePostById(postId);
			
			responseVo.setCode(HttpStatus.OK);
			responseVo.setMessage("Success");
			responseVo.setData(postVo);

			return responseVo;

		} else {
			logger.info("Else statement entered.");

			responseVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseVo.setMessage("Error");
			responseVo.setData(null);

			return responseVo;
		}

	}

}
