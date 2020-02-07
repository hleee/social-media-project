package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.UserVo;

@Repository
public class UserDao {

	static Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	private SqlSession sqlSession;

	// 회원 가입
	public int insertOneUser(UserVo userVo) throws DataAccessException {
		return sqlSession.insert("mapper.user.insertOneUser", userVo);
	}

	// 전체 회원 조회
	public List<UserVo> selectAllUsers() throws DataAccessException {
		return sqlSession.selectList("mapper.user.selectAllUsers");
	}

	// ID로 단일 회원 조회
	public UserVo selectOneUserById(Long id) throws DataAccessException {
		return sqlSession.selectOne("mapper.user.selectOneUserById", id);
	}

	// username과 password로 단일 회원 조회
	public UserVo selectOneUserByUsernameAndPassword(UserVo userVo) throws DataAccessException {
		return sqlSession.selectOne("mapper.user.selectOneUserByUsernameAndPassword", userVo);
	}

}
