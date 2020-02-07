package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.PostVo;
import com.mycompany.myapp.domain.ResponseVo;

@Repository
public class PostDao {

	static Logger logger = LoggerFactory.getLogger(PostDao.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVo postVo;

	@Autowired
	public ResponseVo responseVo;

	// 글 저장
	public int insertOnePost(PostVo postVo) {
		return sqlSession.insert("mapper.post.insertOnePost", postVo);
	}

	// 전체 글 조회
	public List<PostVo> selectAllPostsDescending() {
		return sqlSession.selectList("mapper.post.selectAllPostsDescending");
	}

	// 내 글 조회
	public List<PostVo> selectMyPosts(long userId) {
		return sqlSession.selectList("mapper.post.selectMyPosts", userId);
	}

	// ID로 글 하나 조회
	public PostVo selectOnePostById(long id) throws DataAccessException {
		return sqlSession.selectOne("mapper.post.selectOnePostById", id);
	}

	// 글 삭제
	public int deleteOnePost(long id) throws DataAccessException {
		return sqlSession.delete("mapper.post.deleteOnePost", id);
	}

}
