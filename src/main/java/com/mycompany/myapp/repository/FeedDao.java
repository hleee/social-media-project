package com.mycompany.myapp.repository;

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

	// 팔로이 ID로 피드 정보 조회
	// 자기 자신이 피드 테이블에 들어있는지 중복 확인
	public FeedVo selectOneFeedWrittenByTheSamePerson(long followeeId) {
		return sqlSession.selectOne("mapper.feed.selectOneFeedWrittenByTheSamePerson", followeeId);
	}
}
