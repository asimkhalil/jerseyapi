package com.test.jerseyapi.model;

public class Configurations {
	
	private String serverHost;
	
	private int port;

	private String requestBody;

	private int successStatusCode;

	private int failStatusCode;
	
	private String apiBaseUrl;
	
	private String apiMethodURL;
	
	private String contractLevelParamDate;
	
	private String contractlevelParamRequestId;
	
	private String contractLevelMethod;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public int getSuccessStatusCode() {
		return successStatusCode;
	}

	public void setSuccessStatusCode(int successStatusCode) {
		this.successStatusCode = successStatusCode;
	}

	public int getFailStatusCode() {
		return failStatusCode;
	}

	public void setFailStatusCode(int failStatusCode) {
		this.failStatusCode = failStatusCode;
	}

	public String getApiBaseUrl() {
		return apiBaseUrl;
	}

	public void setApiBaseUrl(String apiBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
	}

	public String getApiMethodURL() {
		return apiMethodURL;
	}

	public void setApiMethodURL(String apiMethodURL) {
		this.apiMethodURL = apiMethodURL;
	}

	public String getContractLevelParamDate() {
		return contractLevelParamDate;
	}

	public void setContractLevelParamDate(String contractLevelParamDate) {
		this.contractLevelParamDate = contractLevelParamDate;
	}

	public String getContractlevelParamRequestId() {
		return contractlevelParamRequestId;
	}

	public void setContractlevelParamRequestId(String contractlevelParamRequestId) {
		this.contractlevelParamRequestId = contractlevelParamRequestId;
	}

	public String getContractLevelMethod() {
		return contractLevelMethod;
	}

	public void setContractLevelMethod(String contractLevelMethod) {
		this.contractLevelMethod = contractLevelMethod;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
}
