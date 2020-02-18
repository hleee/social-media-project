package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.FollowVo;

@Repository
public class FollowDao {

	static Logger logger = LoggerFactory.getLogger(FollowDao.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public FollowVo followVo;

	// 팔로워-팔로이 한 쌍 삽입
	public int insertOneFollow(FollowVo followVo) {
		return sqlSession.insert("mapper.follow.insertOneFollow", followVo);
	}

	// 팔로워-팔로이 한 쌍 삭제
	public int deleteOneFollow(FollowVo followVo) {
		return sqlSession.delete("mapper.follow.deleteOneFollow", followVo);
	}

	// 팔로이 ID로 팔로워-팔로이 쌍 모두 조회
	public List<FollowVo> selectAllFollowersByFolloweeId(Long followeeId) {
		return sqlSession.selectList("mapper.follow.selectAllFollowersByFolloweeId", followeeId);
	}
	
	// 팔로워 ID로 팔로워-팔로이 쌍 모두 조회
		public List<FollowVo> selectAllFolloweesByFollowerId(Long followerId) {
			return sqlSession.selectList("mapper.follow.selectAllFolloweesByFollowerId", followerId);
		}

	// 팔로이 ID로 팔로워-팔로이 쌍 모두 조회
	public FollowVo selectOneFollowByFollowerIdAndFolloweeId(FollowVo followVo) {
		return sqlSession.selectOne("mapper.follow.selectOneFollowByFollowerIdAndFolloweeId", followVo);
	}

}
