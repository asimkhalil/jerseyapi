package com.test.jerseyapi.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.Socket;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.jerseyapi.TestConfigurations;
import com.test.jerseyapi.model.Configurations;
import com.test.jerseyapi.model.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetContractAndTierLevelTestStepsDef {

	HttpEntity<Response> response;

	Configurations configs;

	private RestTemplate restTemplate;

	public GetContractAndTierLevelTestStepsDef() throws IOException {
		super();
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(TestConfigurations.class);
		configs = (Configurations) context.getBean("configurations");
		restTemplate = new RestTemplate();
	}

	@Given("^User has sample request for get contract service$")
	public void user_has_sample_request_for_get_contract_service() throws Throwable {
		Socket socket = new Socket(configs.getServerHost(), configs.getPort());
		assertTrue(socket.isConnected());
	}

	@When("^get contract levels service called via postman$")
	public void get_contract_edit_service_called_via_postman() throws Throwable {

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(configs.getApiBaseUrl() + configs.getContractLevelMethod())
				.queryParam("date", configs.getContractLevelParamDate())
				.queryParam("requestId", configs.getContractlevelParamRequestId());

		response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Response.class);
	}

	@Then("^the get contract service call should be successful$")
	public void get_contract_receives_status_code_of_200() throws Throwable {
		assertEquals("Http Response should be 200 ", configs.getSuccessStatusCode(),
				response.getBody().getStatus());
	}

	@When("^get contract service called via postman no params$")
	public void get_contract_service_called_via_postman_no_params() throws Throwable {

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(configs.getApiBaseUrl() + configs.getContractLevelMethod())
				.queryParam("date", configs.getContractLevelParamDate());

		response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Response.class);
	}

	@Then("^the contract service call should be unsuccessful$")
	public void the_contract_service_call_should_be_unsuccessful() throws Throwable {
		assertEquals("Http Response should be 400 ", configs.getFailStatusCode(),
				response.getBody().getStatus());
	}

	@Given("^User has sample request for proposed scan range edit service$")
	public void user_has_sample_request_for_proposed_scan_range_edit_service() throws Throwable {
		System.out.println("Scenario for range edit");
	}

	@When("^scan range edit service called via postman$")
	public void the_client_calls_resetrates() throws Throwable {

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(configs.getApiBaseUrl() + configs.getApiMethodURL());

		HttpEntity<String> entity = new HttpEntity<String>(configs.getRequestBody());

		response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Response.class);

	}

	@Then("^the service call should be successful$")
	public void the_user_receives_status_code_of() throws Throwable {
		assertEquals("Http Response should be 200 ", configs.getSuccessStatusCode(),
				response.getBody().getStatus());
	}

	@And("^update record should be written to ScanRangeUpdate\\.txt & activePSIData\\.txt files$")
	public void update_record_should_be_written_to_ScanRangeUpdate_txt_activePSIData_txt_files() throws Throwable {
		System.out.println("@And test case condition executed");
	}

	@When("^scan range edit service called via postman with empty request body$")
	public void scan_range_edit_service_called_via_postman_with_empty_request_body() throws Throwable {

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(configs.getApiBaseUrl() + configs.getApiMethodURL());

		HttpEntity<String> entity = new HttpEntity<String>("null");

		response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Response.class);
	}

	@Then("^the service call should be unsuccessful$")
	public void the_service_call_should_be_unsuccessful() throws Throwable {
		assertEquals("Http Response should be 400 ", configs.getFailStatusCode(),
				response.getBody().getStatus());
	}

	@And("^update record should not be written to ScanRangeUpdate\\.txt & activePSIData\\.txt files$")
	public void update_record_should_not_be_written_to_ScanRangeUpdate_txt_activePSIData_txt_files() throws Throwable {
		System.out.print("@And Negative part executed");
	}

	@Given("User has request for get contract service with no params")
	public void user_has_request_for_get_contract_service_with_no_params() {
		System.out.println("@Given calling get contract service with no params");
	}

	@Given("User has empty request for proposed scan range edit service")
	public void user_has_empty_request_for_proposed_scan_range_edit_service() {
		System.out.println("Calling edit scan range service with empty request body");
	}

	@Given("User has sample request for get contract service with valid date params")
	public void user_has_sample_request_for_get_contract_service_with_valid_date_params() {
		System.out.println("@Given, get get reset rates for contract service called with valid date param");
	}

	@When("get contract levels service called via postman with correct date format MM\\/DD\\/YYYY")
	public void get_contract_levels_service_called_via_postman_with_correct_date_format_MM_DD_YYYY() {
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(configs.getApiBaseUrl() + configs.getContractLevelMethod())
				.queryParam("date", configs.getContractLevelParamDate())
				.queryParam("requestId", configs.getContractlevelParamRequestId());

		response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Response.class);
	}

	@Then("the get contract service call should return the success response")
	public void the_get_contract_service_call_should_return_the_success_response() {
		assertEquals("Http Response should be 200 ", configs.getSuccessStatusCode(), response.getBody().getStatus());
	}
	
	@Given("User has sample request for get contract service with valid request id params")
	public void user_has_sample_request_for_get_contract_service_with_valid_request_id_params() {
		System.out.println("@Given, get get reset rates for contract service called with valid request id param > 0");
	    throw new cucumber.api.PendingException();
	}

	@When("get contract levels service called via postman with valid request id > {int}")
	public void get_contract_levels_service_called_via_postman_with_valid_request_id(Integer int1) {
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(configs.getApiBaseUrl() + configs.getContractLevelMethod())
				.queryParam("date", configs.getContractLevelParamDate())
				.queryParam("requestId", configs.getContractlevelParamRequestId());

		response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Response.class);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
