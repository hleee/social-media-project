package com.mycompany.myapp.repository.post;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.post.PostVo;

@Repository
public class DaoToSelectAllPostsDescending {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectAllPostsDescending.class);

	@Autowired
	public SqlSession sqlSession;

	@Autowired
	public PostVo postVo;

	public List<PostVo> selectAllPostsDescending() {
		List<PostVo> allPostsList = null;
		allPostsList = sqlSession.selectList("mapper.post.selectAllPostsDescending");
		logger.info("DAO: selectAllPostsDescending() called.");
		return allPostsList;

	}

}
