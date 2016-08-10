package com.cloud.service.client.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClient {
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		System.out.println(restTemplate + "-------");
		return restTemplate.getForEntity("http://MICROSERVICEPROVIDER-A/hello", String.class).getBody();
	}
}
