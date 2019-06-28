package com.test.jerseyapi.model;

public class Response {
	private String response = "{\r\n" + 
			"	\"requestId\" : \"1234567abcd1234567\",\r\n" + 
			"	\"args\" : {\r\n" + 
			"		\"businessDate\" : \"2018-10-16\",\r\n" + 
			"		\"proposedRates\" : [\r\n" + 
			"			{\r\n" + 
			"				\"commodityId\" : \"4229226\",\r\n" + 
			"				\"productId\" : \"8229478\",\r\n" + 
			"				\"tier\" : \"5\",\r\n" + 
			"				\"proposedRate\" : \"194\",\r\n" + 
			"				\"exchange\" : \"NFX\",\r\n" + 
			"				\"proposedDate\" : \"2018-02-10\",\r\n" + 
			"				\"editedBy\" \": \"null\",\r\n" + 
			"				\"editedTimestamp\" : \"2019-06-20\",\r\n" + 
			"				\"reviewedBy\" : \"null\",\r\n" + 
			"				\"reviewedTimestamp\" : \"null\",\r\n" + 
			"				\"key\" : \"8229478\",\r\n" + 
			"				\r\n" + 
			"			}\r\n" + 
			"		]\r\n" + 
			"	}\r\n" + 
			"	\"errors\" : \"null\"\r\n" + 
			"}";
	
	public String buildResponse() {
		return response;
	}
}
