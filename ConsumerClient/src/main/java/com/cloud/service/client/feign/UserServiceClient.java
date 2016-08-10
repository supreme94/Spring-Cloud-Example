package com.cloud.service.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("MICRO-SERVICE-A")
public interface UserServiceClient {
	
//	@RequestMapping(value="/userlist", method=RequestMethod.GET)
//	String getUserList(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize);
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	String hello();
}
