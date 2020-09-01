package com.clairgustafson.socialMediaApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.socialMediaApi.entity.User;

public interface UserRepo extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
