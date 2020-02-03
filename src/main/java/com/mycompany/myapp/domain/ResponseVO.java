package com.mycompany.myapp.domain;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseVO {
	private int code;
	private String message;
	private Object data;

	public ResponseVO() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(HttpStatus httpStatus) {
		this.code = httpStatus.value();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	// 콘솔창에 출력
	@Override
	public String toString() {
		String info = "ResponseVO: code: " + code + ", message: " + message + ", data: " + data;
		return info;
	}

}
