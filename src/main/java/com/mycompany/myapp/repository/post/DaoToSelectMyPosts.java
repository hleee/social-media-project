package com.mycompany.myapp.repository.post;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.domain.post.PostVo;

@Component
public class DaoToSelectMyPosts {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectMyPosts.class);

	@Autowired
	public SqlSession sqlSession;

	@Autowired
	public PostVo postVo;

	public List<PostVo> selectMyPosts(long userId) {
		
		logger.info("DAO: selectMyPosts() called.");
		
		List<PostVo> myPostsList = null;
		myPostsList = sqlSession.selectList("mapper.post.selectMyPosts", userId);
		return myPostsList;

	}

}
