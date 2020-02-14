package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.FeedVo;
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
	public FeedVo feedVo;

	@Autowired
	public ResponseVo responseVo;

	// 글 저장
	public int insertOnePost(PostVo postVo) {
		return sqlSession.insert("mapper.post.insertOnePost", postVo);
	}

	// 전체 글 조회
	public List<PostVo> selectAllPosts() {
		return sqlSession.selectList("mapper.post.selectAllPosts");
	}

	// 내 글 조회, 내 글과 팔로이의 글 조회 (피드)
	public List<PostVo> selectPostsByUserId(long userId) {
		return sqlSession.selectList("mapper.post.selectPostsByUserId", userId);
	}

	// ID로 글 하나 조회
	public PostVo selectOnePostById(long id) throws DataAccessException {
		return sqlSession.selectOne("mapper.post.selectOnePostById", id);
	}

	// 글 삭제
	public int deleteOnePost(long id) throws DataAccessException {
		return sqlSession.delete("mapper.post.deleteOnePost", id);
	}

	// 피드 테이블에 피드 추가
	public int insertOneFeed(FeedVo feedVo) throws DataAccessException {
		return sqlSession.insert("mapper.feed.insertOneFeed", feedVo);
	}

	// 사용자 ID로 가장 최근 글 하나 조회
	public PostVo selectOnePostByUserId(long userId) throws DataAccessException {
		return sqlSession.selectOne("mapper.post.selectOnePostByUserId", userId);
	}
	
	// 글 수정
	public int updateOnePost (PostVo postVo) throws DataAccessException {
		return sqlSession.update("mapper.post.updateOnePost", postVo);
	}

}
