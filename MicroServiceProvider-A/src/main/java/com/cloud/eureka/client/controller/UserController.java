package com.cloud.eureka.client.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.eureka.client.entity.User;
import com.cloud.eureka.client.repo.UserRepositroy;

//@RequestMapping(value="/users", produces="application/json")
//@RestController
public class UserController {
	@Autowired
	UserRepositroy userRepositroy;
	
	@Autowired
	DiscoveryClient client;
	
	@RequestMapping(value="/{pageNumber}/{pageSize}",method=RequestMethod.GET)
	public Response findAll(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
		ServiceInstance localInstance = client.getLocalServiceInstance();
		System.out.println(localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort());
		return Response.ok(userRepositroy.findAll(new PageRequest(pageNumber-1, pageSize))).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Response findOne(@PathVariable("id") String id) {
		return Response.ok(userRepositroy.findOne(id)).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Response delete(@PathVariable("id") String id) {
		userRepositroy.delete(id);
		return Response.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Response update(@RequestBody User user) {
		return Response.ok(userRepositroy.save(user)).build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Response save(@RequestBody User user) {
		return Response.ok(userRepositroy.save(user)).build();
	}
}
