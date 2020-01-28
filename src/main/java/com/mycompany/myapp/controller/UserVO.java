package com.mycompany.myapp.controller;

import java.sql.Date;

public class UserVO {
	private String id;
	private String username;
	private String password;
	private Date createdAt;

	public UserVO() {
		System.out.println("MemberVO constructor");
	}

	public UserVO(String id, String username, String password, Date createdAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
