package com.test.jerseyapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.Socket;
import java.net.URI;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.Uri;
import org.glassfish.jersey.test.JerseyTest;

import com.test.jerseyapi.model.Request;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetContractAndTierLevelTestStepsDef extends JerseyTest {

	Response response;

	TestConfigurations testConfigurations;

	@Before
	@Override
	public void setUp() throws Exception {
		ClientConfig clientConfig = new ClientConfig();
		super.configureClient(clientConfig);
		super.setUp();

		testConfigurations = new TestConfigurations();
		testConfigurations.load();
	}

	@Override
	protected Application configure() {
		return new ResourceConfig(Request.class);
	}

	@Given("^User has sample request for get contract service$")
	public void user_has_sample_request_for_get_contract_service() throws Throwable {
		Socket socket = new Socket(testConfigurations.getServerHost(), testConfigurations.getPort());
		assertTrue(socket.isConnected());
	}

	@When("^get contract edit service called via postman$")
	public void get_contract_edit_service_called_via_postman() throws Throwable {

		WebTarget webTarget = getClient().target(testConfigurations.getApiBaseUrl());

		webTarget = webTarget.path(testConfigurations.getContractLevelMethod())
				.queryParam("date", testConfigurations.getContractLevelParamDate())
				.queryParam("requestId", testConfigurations.getContractlevelParamRequestId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);

		response = invocationBuilder.get();
	}

	@Then("^the get contract service call should be successful$")
	public void get_contract_receives_status_code_of_200() throws Throwable {
		assertEquals("Http Response should be 200 ", testConfigurations.getSuccessStatusCode(), response.getStatus());
	}
	
	@When("^get contract service called via postman no params$")
	public void get_contract_service_called_via_postman_no_params() throws Throwable {
		WebTarget webTarget = getClient().target(testConfigurations.getApiBaseUrl());

		webTarget = webTarget.path(testConfigurations.getContractLevelMethod())
				.queryParam("date", testConfigurations.getContractLevelParamDate());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);

		response = invocationBuilder.get();
	}

	@Then("^the service call should be unsuccessful$")
	public void the_service_call_should_be_unsuccessful() throws Throwable {
		assertEquals("Http Response should be 400 ", testConfigurations.getFailStatusCode(), response.getStatus());
	}
}
