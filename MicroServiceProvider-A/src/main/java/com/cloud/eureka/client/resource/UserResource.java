package com.cloud.eureka.client.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.cloud.eureka.client.entity.User;
import com.cloud.eureka.client.repo.UserRepositroy;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	@Autowired
	UserRepositroy userRepositroy;
	
	@GET
	@Path("/{pageNumber}/{pageSize}")
	public Response findAll(@PathParam("pageNumber") Integer pageNumber, @PathParam("pageSize") Integer pageSize) {
		return Response.ok(userRepositroy.findAll(new PageRequest(pageNumber-1, pageSize))).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") String id) {
		return Response.ok(userRepositroy.findOne(id)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		userRepositroy.delete(id);
		return Response.ok().build();
	}
	
	@PUT
	public Response update(User user) {
		return Response.ok(userRepositroy.save(user)).build();
	}
	
	@POST
	public Response save(User user) {
		return Response.ok(userRepositroy.save(user)).build();
	}
}
