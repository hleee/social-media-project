package com.mycompany.myapp.repository.post;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.PostVO;

@Repository
public class DaoToSelectOnePostById {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectOnePostById.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVO postVO;

	public PostVO selectOnePostById(PostVO postVoToDb) throws DataAccessException {
		PostVO postVoFromDb = sqlSession.selectOne("mapper.post.selectOnePostById", postVoToDb);
		return postVoFromDb;
	}

}