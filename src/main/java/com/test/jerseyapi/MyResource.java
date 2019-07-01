package com.test.jerseyapi;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/resetrates")
public class MyResource {

	Logger logger = Logger.getLogger("MyResource");

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/edit")
	public Response editScanRange(String request) throws IOException {
		if (request.isEmpty()) {
			String badRequestResponse = "Request body missing";
			return Response.status(400).entity(badRequestResponse.getBytes()).build();
		}
		ObjectMapper mapper = new ObjectMapper();
		byte[] entity = mapper.writeValueAsBytes(new com.test.jerseyapi.model.Response().buildResponse());
		return Response.status(200).entity(entity).build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/contract")
	public Response getResetRatesAtContractLevel(@QueryParam("date") String date,
			@QueryParam("requestId") String requestId) throws IOException {
		if(requestId == null) {
			String badRequestResponse = "Query param requestId missing";
			return Response.status(400).entity(badRequestResponse.getBytes()).build();
		}
		ObjectMapper mapper = new ObjectMapper();
		byte[] entity = mapper.writeValueAsBytes(new com.test.jerseyapi.model.Response().buildResponse());
		return Response.status(200).entity(entity).build();
	}
}
