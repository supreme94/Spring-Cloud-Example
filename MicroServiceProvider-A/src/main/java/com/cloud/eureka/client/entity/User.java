package com.cloud.eureka.client.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection="users")
public class User {
	@Id
	@Indexed
	private String id;
	
	private String name;
	
	private Integer age;
	
	@Field("update_at")
	@JsonFormat(shape =Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@LastModifiedDate
	private DateTime updatedAt;
	
	@Field("create_at")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape =Shape.STRING)
	@CreatedDate
	private DateTime createdAt;
	
	public User() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
