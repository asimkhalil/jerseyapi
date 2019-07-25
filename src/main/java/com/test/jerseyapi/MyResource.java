package com.test.jerseyapi;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public Response editScanRange(@RequestBody(required = false) String request) throws IOException {
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
	public Response getResetRatesAtContractLevel(@RequestParam(required = false) String date,
			@RequestParam(required = false) String requestId) throws IOException, ParseException {
		Response response;
		if (requestId == null || requestId.isEmpty() || !isInteger(requestId) || requestId.equals("0")) {
			String badRequestResponse = "Query param requestId missing";
			response = new Response();
			response.setStatus(400);
			response.setResponseBody(badRequestResponse);
			return response;
		}

		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date dt = sdf.parse(date);
			if (!sdf.format(dt).equals(date)) {
				response = new Response();
				response.setStatus(400);
				response.setResponseBody("Invalid date format, The should be in DD-MM-YYYY format");
				return response;
			}
		}
		response = new Response();
		response.setStatus(200);
		return response;
	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
}
