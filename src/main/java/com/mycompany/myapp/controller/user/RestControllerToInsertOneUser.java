package com.mycompany.myapp.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.service.user.ServiceToInsertOneUser;
import com.mycompany.myapp.service.user.ServiceToSelectOneUserByUsernameAndPassword;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOneUser {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOneUser.class);

	@Autowired
	private ServiceToInsertOneUser serviceToInsertOneUser;

	@Autowired
	private ServiceToSelectOneUserByUsernameAndPassword serviceToSelectOneUserByUsernameAndPassword;

	@Autowired
	public UserVo userVo;

	@Autowired
	public ResponseVo responseVo;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseVo insertOneUser(@RequestBody UserVo userVo) throws Exception {

		logger.info("insertOneUser() initialised.");

		// 회원이 성공적으로 추가됐으면 정수 1 출력
		int integerOneIfInserted = serviceToInsertOneUser.insertOneUser(userVo);
		logger.info("Integer 1 if new user inserted: " + integerOneIfInserted);

		// id와 createdAt을 responseVO에 담아주기 위해 가입 후 다시 한 번 조회
		// 그렇지 않고 그대로 반환하면 null 반환
		userVo = serviceToSelectOneUserByUsernameAndPassword.selectOneUserByUsernameAndPassword(userVo);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(userVo);
		logger.info("code, message, and data set to responseVo.");

		return responseVo;

	}

}
