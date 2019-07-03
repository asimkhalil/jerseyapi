package com.test.jerseyapi;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.jerseyapi.model.Response;

@Service
@RestController
@RequestMapping("/resetrates")
public class MyResource {

	Logger logger = Logger.getLogger("MyResource");

	@PostMapping("/edit")
	public Response editScanRange(@RequestBody(required=false) String request) throws IOException {
		Response response;
		if (request.equalsIgnoreCase("null")) {
			String badRequestResponse = "Request body missing";
			response = new Response();
			response.setStatus(400);
			response.setResponseBody(badRequestResponse);
			return response;
		}
		response = new Response();
		response.setStatus(200);
		return response;
	}

	@GetMapping("/contract")
	public Response getResetRatesAtContractLevel(@RequestParam(required=false) String date,
			@RequestParam(required=false) String requestId) throws IOException {
		Response response;
		if (requestId == null) {
			String badRequestResponse = "Query param requestId missing";
			response = new Response();
			response.setStatus(400);
			response.setResponseBody(badRequestResponse);
			return response;
		}
		response = new Response();
		response.setStatus(200);
		return response;
	}
}
