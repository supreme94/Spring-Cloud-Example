package com.cloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	DiscoveryClient client;
	
	@RequestMapping("/hello")
	public String helloWorld() {
		System.out.println("-----------------------------------------------------");
		ServiceInstance localInstance = client.getLocalServiceInstance();
		System.out.println(localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort());
		return "Hello World: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}
}
