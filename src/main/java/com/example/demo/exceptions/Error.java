package com.example.demo.exceptions;

import java.time.LocalDateTime;

public class Error {
	
	private LocalDateTime timestamp;
	private String code;
	private String detail;
	
	public Error(LocalDateTime timestamp, String code, String detail) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.detail = detail;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
