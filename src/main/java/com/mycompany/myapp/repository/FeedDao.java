package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.FeedVo;
import com.mycompany.myapp.domain.PostVo;
import com.mycompany.myapp.domain.ResponseVo;

@Repository
public class FeedDao {

	static Logger logger = LoggerFactory.getLogger(FeedDao.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVo postVo;

	@Autowired
	public FeedVo feedVo;

	@Autowired
	public ResponseVo responseVo;

	// 팔로워 ID와 팔로이 ID가 동일한 피드 기록 조회
	public FeedVo selectOneFeedWhereFollowerIdIsFolloweeId(long followeeId) {
		return sqlSession.selectOne("mapper.feed.selectOneFeedWhereFollowerIdIsFolloweeId", followeeId);
	}

	// 같은 팔로워 ID의 모든 피드 기록 조회
	public List<FeedVo> selectAllFeedByUserId(long userId) {
		return sqlSession.selectList("mapper.feed.selectAllFeedByUserId", userId);
	}

}
