package com.test.jerseyapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.test.jerseyapi.model.User;

@Path("/manageusers")
public class MyResource {
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createuser")
    public User add(User user) {
    	User usr = new User(user);
    	return usr;
    }
}
