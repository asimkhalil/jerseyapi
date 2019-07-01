package com.test.jerseyapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.Socket;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import com.test.jerseyapi.model.Request;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTestStepsDef extends JerseyTest {

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

	@Given("^User has sample request for proposed scan range edit service$")
	public void user_has_sample_request_for_proposed_scan_range_edit_service() throws Throwable {
		Socket socket = new Socket(testConfigurations.getServerHost(), testConfigurations.getPort());
		assertTrue(socket.isConnected());
	}

	@When("^scan range edit service called via postman$")
	public void the_client_calls_resetrates() throws Throwable {

		WebTarget webTarget = getClient().target("http://localhost:8080/jerseyapi");

		WebTarget userWebTarget = webTarget.path("/resetrates/edit");

		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.TEXT_PLAIN);

		response = invocationBuilder.post(Entity.text(testConfigurations.getRequestBody()));

	}

	@Then("^the service call should be successful$")
	public void the_user_receives_status_code_of() throws Throwable {
		assertEquals("Http Response should be 200 ", testConfigurations.getSuccessStatusCode(), response.getStatus());
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
}
