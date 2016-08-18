package com.cloud.eureka.client.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan("com.cloud.eureka.client.pojo")
@PropertySource("classpath:config.properties")
public class Configs {
	@Value("${name}")
	String name;
	
	@Value("${age}")
	Integer age;
	
	@Value("dddd")
	String china;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void set() {
		System.out.println(new String(china));
	}
	
}
