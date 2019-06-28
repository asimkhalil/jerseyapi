package com.test.jerseyapi;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.test.jerseyapi.model.Response;

@Path("/resetrates")
public class MyResource {

	Logger logger = Logger.getLogger("MyResource");

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/edit")
	public String editScanRange(String request, @Context SecurityContext securityContext) throws IOException {
		return new Response().buildResponse();
	}
}
