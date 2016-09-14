package com.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {
	@Value("${name.world}")
	String world;

	@RequestMapping("/")
	public String index(){
		return "Hello "+world;
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String hooks(){
		System.out.println("1111111110");
		return "Hello "+world;
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
	}

}
