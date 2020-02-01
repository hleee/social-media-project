package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.RestAPIController;
import com.mycompany.myapp.domain.UserVO;

@Repository
public class DaoToSelectOneUserbyUsernameAndPassword {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	private SqlSession sqlSession;

	// username과 password로 단일 회원 조회
	// 로그인에 사용
	public UserVO selectOneUserbyUsernameAndPassword(UserVO userVO) throws DataAccessException {
		UserVO OneUserByUsernameAndPassword = sqlSession.selectOne("mapper.user.selectOneUserByUsernameAndPassword",
				userVO);
		return OneUserByUsernameAndPassword;
	}
}
