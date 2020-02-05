package com.mycompany.myapp.repository.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.user.UserVO;

@Repository
public class DaoToSelectAllUsers {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectAllUsers.class);

	@Autowired
	private SqlSession sqlSession;

	// 반환되는 자료는 목록 형태
	public List<UserVO> selectAllUsers() throws DataAccessException {
		List<UserVO> allUsersList = null;
		allUsersList = sqlSession.selectList("mapper.user.selectAllUsers");
		return allUsersList;
	}

}
