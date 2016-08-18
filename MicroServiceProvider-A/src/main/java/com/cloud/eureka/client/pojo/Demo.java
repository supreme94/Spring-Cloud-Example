package com.cloud.eureka.client.pojo;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Service
public class Demo {
	
	@Value("demo")
	private String demo;

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}
	
	
}
