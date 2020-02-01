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
public class DaoToInsertOneUser {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	private SqlSession sqlSession;

	// 회원 가입
	// 반환형은 int, 전달 중인 객체는 UserVO, mapper를 찾아서 id가 insertUser인 걸 찾아서 vo 객체를 전달
	// DB에 잘 들어가면 DB에서 작업한 줄의 개수 반환 -- 한 줄 작업했으니 1 반환
	public int insertUser(UserVO userVO) throws DataAccessException {
		int integerOneIfInserted = sqlSession.insert("mapper.userMapper.insertUser", userVO);
		return integerOneIfInserted;
	}

}
