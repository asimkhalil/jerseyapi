package com.test.jerseyapi;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;

public class CucumberTestStepsDef extends JerseyTest {

	Response response;
	
	TestConfigurations testConfigurations;
	
//	@Before
//	@Override
//	public void setUp() throws Exception {
//		if(getClient() == null) {
//			ClientConfig clientConfig = new ClientConfig();
//			super.configureClient(clientConfig);
//			super.setUp();
//		}
//		
//		testConfigurations = new TestConfigurations();
//		testConfigurations.load();
//	}
//
//	@Override
//	protected Application configure() {
//		return new ResourceConfig(Request.class);
//	}
//
//	@Given("^User has sample request for proposed scan range edit service$")
//	public void user_has_sample_request_for_proposed_scan_range_edit_service() throws Throwable {
//		Socket socket = new Socket(testConfigurations.getServerHost(), testConfigurations.getPort());
//		assertTrue(socket.isConnected());
//	}
//
//	@When("^scan range edit service called via postman$")
//	public void the_client_calls_resetrates() throws Throwable {
//
//		WebTarget webTarget = getClient().target(testConfigurations.getApiBaseUrl());
//
//		WebTarget userWebTarget = webTarget.path(testConfigurations.getApiMethodURL());
//
//		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.TEXT_PLAIN);
//
//		response = invocationBuilder.post(Entity.text(testConfigurations.getRequestBody()));
//
//	}
//
//	@Then("^the service call should be successful$")
//	public void the_user_receives_status_code_of() throws Throwable {
//		assertEquals("Http Response should be 200 ", testConfigurations.getSuccessStatusCode(), response.getStatus());
//	}
//	
//	@And("^update record should be written to ScanRangeUpdate\\.txt & activePSIData\\.txt files$")
//	public void update_record_should_be_written_to_ScanRangeUpdate_txt_activePSIData_txt_files() throws Throwable {
//		
//		System.out.println("@And test case condition executed");
//
//	}
//
//	@When("^scan range edit service called via postman with empty request body$")
//	public void scan_range_edit_service_called_via_postman_with_empty_request_body() throws Throwable {
//		WebTarget webTarget = getClient().target("http://localhost:8080/jerseyapi");
//
//		WebTarget userWebTarget = webTarget.path("/resetrates/edit");
//
//		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.TEXT_PLAIN);
//
//		response = invocationBuilder.post(Entity.text(""));
//	}
//
//	@Then("^the service call should be unsuccessful$")
//	public void the_service_call_should_be_unsuccessful() throws Throwable {
//		assertEquals("Http Response should be 400 ", testConfigurations.getFailStatusCode(), response.getStatus());
//	}
//	
//	@And("^update record should not be written to ScanRangeUpdate\\.txt & activePSIData\\.txt files$")
//	public void update_record_should_not_be_written_to_ScanRangeUpdate_txt_activePSIData_txt_files() throws Throwable {
//		System.out.print("@And Negative part executed");
//	}
}
