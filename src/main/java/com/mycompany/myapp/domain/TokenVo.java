package com.mycompany.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class TokenVo {
	
	private String token;
	private long userId;
	private String createdAt;

	public TokenVo() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "TokenVo [token=" + token + ", userId=" + userId + ", createdAt=" + createdAt + "]";
	}

}
