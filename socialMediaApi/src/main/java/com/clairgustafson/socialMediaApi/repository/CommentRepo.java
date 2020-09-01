package com.clairgustafson.socialMediaApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.socialMediaApi.entity.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
