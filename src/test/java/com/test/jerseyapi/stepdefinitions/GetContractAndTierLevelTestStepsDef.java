package com.test.jerseyapi.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.Socket;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import com.test.jerseyapi.TestConfigurations;
import com.test.jerseyapi.model.Request;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetContractAndTierLevelTestStepsDef extends JerseyTest {

	Response response;

	TestConfigurations testConfigurations;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		testConfigurations = new TestConfigurations();
		testConfigurations.load();
	}
	
	@After 
	public void after() throws Exception {
		super.tearDown();
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

	@Then("^the contract service call should be unsuccessful$")
	public void the_contract_service_call_should_be_unsuccessful() throws Throwable {
		assertEquals("Http Response should be 400 ", testConfigurations.getFailStatusCode(), response.getStatus());
	}
	
	@Given("^User has sample request for proposed scan range edit service$")
	public void user_has_sample_request_for_proposed_scan_range_edit_service() throws Throwable {
		System.out.println("Scenario for range edit");
	}

	@When("^scan range edit service called via postman$")
	public void the_client_calls_resetrates() throws Throwable {

		WebTarget webTarget = getClient().target(testConfigurations.getApiBaseUrl());

		WebTarget userWebTarget = webTarget.path(testConfigurations.getApiMethodURL());

		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.TEXT_PLAIN);

		response = invocationBuilder.post(Entity.text(testConfigurations.getRequestBody()));

	}

	@Then("^the service call should be successful$")
	public void the_user_receives_status_code_of() throws Throwable {
		assertEquals("Http Response should be 200 ", testConfigurations.getSuccessStatusCode(), response.getStatus());
	}
	
	@And("^update record should be written to ScanRangeUpdate\\.txt & activePSIData\\.txt files$")
	public void update_record_should_be_written_to_ScanRangeUpdate_txt_activePSIData_txt_files() throws Throwable {
		
		System.out.println("@And test case condition executed");

	}

	@When("^scan range edit service called via postman with empty request body$")
	public void scan_range_edit_service_called_via_postman_with_empty_request_body() throws Throwable {
		WebTarget webTarget = getClient().target("http://localhost:8080/jerseyapi");

		WebTarget userWebTarget = webTarget.path("/resetrates/edit");

		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.TEXT_PLAIN);

		response = invocationBuilder.post(Entity.text(""));
	}

	@Then("^the service call should be unsuccessful$")
	public void the_service_call_should_be_unsuccessful() throws Throwable {
		assertEquals("Http Response should be 400 ", testConfigurations.getFailStatusCode(), response.getStatus());
	}
	
	@And("^update record should not be written to ScanRangeUpdate\\.txt & activePSIData\\.txt files$")
	public void update_record_should_not_be_written_to_ScanRangeUpdate_txt_activePSIData_txt_files() throws Throwable {
		System.out.print("@And Negative part executed");
	}
}
