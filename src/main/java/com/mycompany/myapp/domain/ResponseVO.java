package com.mycompany.myapp.domain;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ResponseVO {
	private int code;
	private String message;
	private HashMap<String, Object> data;

	public ResponseVO() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int i) {
		this.code = i;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	// 콘솔창에 출력
	@Override
	public String toString() {
		String info = "ResponseVO: code: " + code + ", message: " + message + ", data: " + data;
		return info;
	}

}
