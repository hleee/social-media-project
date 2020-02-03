package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.PostVO;

import freemarker.log.Logger;

@Repository
public class DaoToSelectOnePostByTitleAndContent {

	static Logger logger = (Logger) LoggerFactory.getLogger(DaoToSelectOnePostByTitleAndContent.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVO postVO;

	public PostVO selectOnePostByTitleAndContent(PostVO postVoToDb) throws DataAccessException {
		PostVO postVoFromDb = sqlSession.selectOne("mapper.post.selectOnePostById", postVoToDb);
		return postVoFromDb;
	}

}