package com.cloud.eureka.client.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.cloud.eureka.client.pojo.Configs;


@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
	
	@Autowired
	Environment env;
	
	@Autowired
	Configs config;
	

	@GET
	@Path("/config")
	public Response getconfig() {
		System.out.println(env.getProperty("age"));
		config.set();
		return  Response.ok(config).build();
	}

	
}
