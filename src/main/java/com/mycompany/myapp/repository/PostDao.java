package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.PostVo;

@Repository
public class PostDao {

	static Logger logger = LoggerFactory.getLogger(PostDao.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVo postVo;

	// 1. 글 저장 API
	public int insertOnePost(PostVo postVo) {
		logger.info("insertOnePost() called.");

		int integerOneIfInserted = sqlSession.insert("mapper.post.insertOnePost", postVo);
		logger.info("Integer 1 if post inserted: " + integerOneIfInserted);

		return integerOneIfInserted;
	}

	// 2. 글 전체 목록 조회 API
	public List<PostVo> selectAllPostsDescending() {
		logger.info("selectAllPostsDescending() called.");

		List<PostVo> allPostsList = null;
		allPostsList = sqlSession.selectList("mapper.post.selectAllPostsDescending");
		logger.info("allPostsList: " + allPostsList);

		return allPostsList;
	}

	// 3. 내 글 조회 API
	public List<PostVo> selectMyPosts(long userId) {
		logger.info("selectMyPosts() called.");

		List<PostVo> myPostsList = null;
		myPostsList = sqlSession.selectList("mapper.post.selectMyPosts", userId);
		logger.info("myPostsList: " + myPostsList);

		return myPostsList;
	}

	// 4. ID로 글 하나 조회
	public PostVo selectOnePostById(long id) throws DataAccessException {
		logger.info("selectOnePostById() called.");

		PostVo postVo = sqlSession.selectOne("mapper.post.selectOnePostById", id);
		logger.info("postVo: " + postVo);

		return postVo;
	}
	
	// 5. 글 삭제
	public int deleteOnePost(long id) throws DataAccessException {
		logger.info("deleteOnePost() called.");
		
		int integerOneIfDeleted = sqlSession.delete("mapper.post.deleteOnePost", id);
		logger.info("Integer 1 if deleted: " + integerOneIfDeleted);
		
		return integerOneIfDeleted;
	}


}
