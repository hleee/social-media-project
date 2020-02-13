package com.mycompany.myapp.domain;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
public class UserVo {

	private Long id;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String createdAt;
	private Boolean isFollow;

	public UserVo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(int i) {
		this.id = (long) i;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(Boolean isFollow) {
		this.isFollow = isFollow;
	}

	// 콘솔창에 출력
	@Override
	public String toString() {
		String info = "UserVo: id: " + id + ", username: " + username + ", password: " + password + ", createdAt: "
				+ createdAt + ", isFollow: " + isFollow;
		return info;
	}

}