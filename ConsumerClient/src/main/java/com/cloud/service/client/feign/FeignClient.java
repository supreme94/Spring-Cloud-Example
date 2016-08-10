package com.cloud.service.client.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClient implements UserServiceClient{
	@Autowired
	UserServiceClient userServiceClient;
	
//	@RequestMapping(value="/{pageNumber}/{pageSize}",method=RequestMethod.GET)
//	public String getUserList(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
//		return userServiceClient.getUserList(pageNumber, pageSize);
//	}
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		return userServiceClient.hello();
	}

}
