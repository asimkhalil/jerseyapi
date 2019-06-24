package com.test.jerseyapi;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import com.test.jerseyapi.model.User;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberTestStepsDef extends JerseyTest {

	Response response;

	@Before
	@Override
	public void setUp() throws Exception {
		ClientConfig clientConfig = new ClientConfig();
		super.configureClient(clientConfig);
		super.setUp();

	}

	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	protected Application configure() {
		return new ResourceConfig(User.class);
	}

	@When("^the client calls /createuser$")
	public void the_client_calls_createuser() throws Throwable {

		WebTarget webTarget = getClient().target("http://localhost:8080/jerseyapi");

		WebTarget userWebTarget = webTarget.path("/webapi/manageusers/createuser");

		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.APPLICATION_JSON);

		response = invocationBuilder.post(Entity.json("{\"first_name\":\"asim\"}"));

	}

	@Then("^the user receives status code of (\\d+)$")
	public void the_user_receives_status_code_of(int arg1) throws Throwable {
		assertEquals("Http Response should be 200 ", Status.OK.getStatusCode(), response.getStatus());
	}

	@And("^the response should contain:$")
	public void the_response_should_contain(String body) throws Throwable {
		assertEquals("The response should be " + body, body, response.readEntity(String.class));
	}
}
