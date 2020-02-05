package com.mycompany.myapp.repository.user;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.user.UserVO;

@Repository
public class DaoToInsertOneUser {

	static Logger logger = LoggerFactory.getLogger(DaoToInsertOneUser.class);

	@Autowired
	private SqlSession sqlSession;

	/* 회원 가입 기능 구현
	insert 메서드는 DB에서 작업한 줄 개수를 정수 형태로 반환
	사용자 표에 한 줄을 성공적으로 추가했으면 정수 1 반환
	DB쪽으로 전달 중인 객체는 userVO
	매퍼에서 id가 insertOneUser인 SQL문을 찾아서 userVO 객체를 전달 */
	public int insertOneUser(UserVO userVO) throws DataAccessException {
		int integerOneIfInserted = sqlSession.insert("mapper.user.insertOneUser", userVO);
		return integerOneIfInserted;
	}

}
