package com.clairgustafson.socialMediaApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.socialMediaApi.entity.Post;

public interface PostRepo extends CrudRepository<Post, Long> {

}
