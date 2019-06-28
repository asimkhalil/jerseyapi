package com.test.jerseyapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Request {

	private String requestId;

	private RequestArgs args;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public RequestArgs getArgs() {
		return args;
	}

	public void setArgs(RequestArgs args) {
		this.args = args;
	}

}
