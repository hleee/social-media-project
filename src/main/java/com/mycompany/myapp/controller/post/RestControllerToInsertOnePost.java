package com.mycompany.myapp.controller.post;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.post.PostVo;
import com.mycompany.myapp.domain.token.TokenVo;
import com.mycompany.myapp.service.post.ServiceToInsertOnePost;
import com.mycompany.myapp.service.post.ServiceToSelectOnePostById;
import com.mycompany.myapp.service.token.ServiceToSelectOneTokenRowByToken;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOnePost.class);

	@Autowired
	public ServiceToSelectOneTokenRowByToken serviceToSelectOneTokenRowByToken;

	@Autowired
	public ServiceToInsertOnePost serviceToInsertOnePost;

	@Autowired
	public ServiceToSelectOnePostById serviceToSelectOnePostById;

	@Autowired
	public PostVo postVo;

	@Autowired
	public ResponseVo responseVo;

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

		// 1. 쿠키에 담긴 토큰 문자열을 이용해서 DB내의 토큰 데이터 행을 조회해 가져오기 (token, user_id, created_at)
		String token = request.getHeader("accesstoken");
		TokenVo tokenVo = serviceToSelectOneTokenRowByToken.selectOneTokenRowByToken(token);
		logger.info("accesstoken extracted and row retrieved.");

		// 2. tokenVO.getUserId() 통해서 userId값 추출
		Long userId = tokenVo.getUserId();
		logger.info("userId extracted.");

		// 3. postVO.setUserId(추출한 userID값)를 통해서 postVO에 userId를 담아줌
		postVo.setUserId(userId);
		logger.info("userId attributed to postVO.");

		// 4. postVO : userId, title, content --> insert
		int IntegerOneIfInserted = serviceToInsertOnePost.insertOnePost(postVo);
		logger.info("Integer 1 if new post inserted: " + IntegerOneIfInserted);

		// 5. postVO를 다시 가져와서 글 id와 createdAt을 responseVO에 담음
		long id = postVo.getId();
		logger.info("id: " + id);
		postVo = serviceToSelectOnePostById.selectOnePostById(id);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(postVo);
		logger.info("code, message, and data set to responseVO.");

		return responseVo;
	}

}
