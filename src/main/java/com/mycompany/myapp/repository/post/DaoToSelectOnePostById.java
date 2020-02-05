package com.mycompany.myapp.repository.post;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.post.PostVo;

@Repository
public class DaoToSelectOnePostById {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectOnePostById.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVo postVo;

	public PostVo selectOnePostById(long id) throws DataAccessException {
		PostVo postVoFromDb = sqlSession.selectOne("mapper.post.selectOnePostById", id);
		return postVoFromDb;
	}

}