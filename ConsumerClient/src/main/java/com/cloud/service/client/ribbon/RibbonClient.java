package com.cloud.service.client.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RestController
public class RibbonClient {
	@Autowired
	RestTemplate restTemplate;
	 
	@RequestMapping(value="/users",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="error")
	public String hello() { 
		return restTemplate.getForEntity("http://MICRO-SERVICE-A/users/1/2", String.class).getBody();
	}
	
	public String error() {
        return "error";
    }
}
