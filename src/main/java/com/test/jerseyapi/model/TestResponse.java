package com.test.jerseyapi.model;

import java.util.Map;

public class TestResponse {
	
	private Map<String, String> body;
	
	private Integer status;
	
	public Map<String, String> getBody() {
		return body;
	}

	public void setBody(Map<String, String> body) {
		this.body = body;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
