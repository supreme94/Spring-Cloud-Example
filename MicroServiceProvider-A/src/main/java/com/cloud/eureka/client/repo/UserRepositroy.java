package com.cloud.eureka.client.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloud.eureka.client.entity.User;

public interface  UserRepositroy extends PagingAndSortingRepository<User, String>{

}
