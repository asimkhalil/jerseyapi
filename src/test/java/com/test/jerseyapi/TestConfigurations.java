package com.test.jerseyapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfigurations {

	private static final String SERVER_HOST = "server.host";
	private static final String SERVER_PORT = "server.port";
	private static final String REQUEST_BODY = "test.api.request.body";
	private static final String SUCCESS_STATUS_CODE = "test.api.request.success.status.code";
	private static final String FAIL_STATUS_CODE = "test.api.request.fail.status.code";
	private static final String API_BASE_URL = "test.api.base.url";
	private static final String API_METHOD_TO_TEST = "test.api.method";

	private String serverHost;

	private int port;

	private String requestBody;

	private int successStatusCode;

	private int failStatusCode;
	
	private String apiBaseUrl;
	
	private String apiMethodURL;

	public void load() throws IOException {
		Properties props = new Properties();
		String resourceName = "testconfig.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream resourceStream = loader.getResourceAsStream(resourceName);
		props.load(resourceStream);
		this.serverHost = props.getProperty(SERVER_HOST);
		this.port = Integer.parseInt(props.getProperty(SERVER_PORT));
		this.requestBody = props.getProperty(REQUEST_BODY);
		this.successStatusCode = Integer.parseInt(props.getProperty(SUCCESS_STATUS_CODE));
		this.failStatusCode = Integer.parseInt(props.getProperty(FAIL_STATUS_CODE));
		this.apiBaseUrl = props.getProperty(API_BASE_URL);
		this.apiMethodURL = props.getProperty(API_METHOD_TO_TEST);
	}

	public String getServerHost() {
		return serverHost;
	}

	public int getPort() {
		return port;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public int getSuccessStatusCode() {
		return successStatusCode;
	}

	public int getFailStatusCode() {
		return failStatusCode;
	}

	public String getApiBaseUrl() {
		return apiBaseUrl;
	}

	public String getApiMethodURL() {
		return apiMethodURL;
	}
}