package com.mycompany.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class FollowVo {

	private Long followeeId;
	private Long followerId;
	private String createdAt;

	public FollowVo() {
		super();
	}

	public Long getFolloweeId() {
		return followeeId;
	}

	public void setFolloweeId(Long followeeId) {
		this.followeeId = followeeId;
	}

	public Long getFollowerId() {
		return followerId;
	}

	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		String info = "FollowVo: followeeId: " + followeeId + ", followerId: " + followerId + ", createdAt: "
				+ createdAt;
		return info;
	}

}
