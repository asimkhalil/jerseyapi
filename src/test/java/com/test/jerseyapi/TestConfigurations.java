package com.test.jerseyapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;

//@Configuration
//@PropertySource("classpath:testconfig.properties")
public class TestConfigurations {

	private static final String SERVER_HOST = "server.host";
	private static final String SERVER_PORT = "server.port";
	private static final String REQUEST_BODY = "test.api.request.body";
	private static final String SUCCESS_STATUS_CODE = "test.api.request.success.status.code";
	private static final String FAIL_STATUS_CODE = "test.api.request.fail.status.code";
	private static final String API_BASE_URL = "test.api.base.url";
	private static final String API_METHOD_TO_TEST = "test.api.method";
	
	private static final String CONTRACT_LEVEL_PARAM_DATE = "test.api.get.contractlevel.param.date";
	private static final String CONTRACT_LEVEL_PARAM_REQUEST_ID = "test.api.get.contractlevel.param.requestId";
	private static final String CONTRACT_LEVEL_METHOD = "test.api.get.contractlevel.method";

//	@Value("${server.host}")
	private String serverHost;

//	@Value("${server.port}")
	private int port;

//	@Value("${test.api.request.body}")
	private String requestBody;

//	@Value("${test.api.request.success.status.code}")
	private int successStatusCode;

//	@Value("${test.api.request.fail.status.code}")
	private int failStatusCode;
	
//	@Value("${test.api.base.url}")
	private String apiBaseUrl;
	
//	@Value("${test.api.method}")
	private String apiMethodURL;
	
//	@Value("${test.api.get.contractlevel.param.date}")
	private String contractLevelParamDate;
	
//	@Value("${test.api.get.contractlevel.param.requestId}")
	private String contractlevelParamRequestId;
	
//	@Value("${test.api.get.contractlevel.method}")
	private String contractLevelMethod;

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
		
		//Contract Level
		this.contractLevelMethod = props.getProperty(CONTRACT_LEVEL_METHOD);
		this.contractLevelParamDate = props.getProperty(CONTRACT_LEVEL_PARAM_DATE);
		this.contractlevelParamRequestId = props.getProperty(CONTRACT_LEVEL_PARAM_REQUEST_ID);
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

	public String getContractLevelParamDate() {
		return contractLevelParamDate;
	}

	public String getContractlevelParamRequestId() {
		return contractlevelParamRequestId;
	}

	public String getContractLevelMethod() {
		return contractLevelMethod;
	}
}