package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;

	// 단일 회원 조회
	// 매개변수를 지정했으면 selectOne()에서 인자로 반복 설정해주어야 (id)
	public UserVO selectByID(Long id) throws DataAccessException {
		UserVO vo = sqlSession.selectOne("mapper.userMapper.selectUser", id);
		return vo;
	}

	// 전체 회원 조회
	public List<UserVO> selectAll() throws DataAccessException {
		List<UserVO> userList = null;
		userList = sqlSession.selectList("mapper.userMapper.selectAll");
		return userList;
	}

	// 회원 가입
	public int insertUser(UserVO vo) throws DataAccessException {
		int newUser = sqlSession.insert("mapper.userMapper.insertUser", vo);
		return newUser;
	}
	
//	// 로그인
//	public UserVO loginByUsername(UserVO userVO) throws DataAccessException {
//		UserVO uVO = sqlSession.selectOne("mapper.userMapper.loginByUsername", userVO);
//		return uVO;
//	}
}
