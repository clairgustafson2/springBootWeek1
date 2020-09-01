package com.clairgustafson.socialMediaApi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.socialMediaApi.entity.Comment;
import com.clairgustafson.socialMediaApi.entity.Post;
import com.clairgustafson.socialMediaApi.entity.User;
import com.clairgustafson.socialMediaApi.repository.CommentRepo;
import com.clairgustafson.socialMediaApi.repository.PostRepo;
import com.clairgustafson.socialMediaApi.repository.UserRepo;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepo repo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Comment createComment(Comment comment, Long userId, Long postId) throws Exception {
		User user = userRepo.findById(userId).orElseThrow();
		Post post = postRepo.findById(postId).orElseThrow();
		if (user == null || post == null) {
			throw new Exception("User or post does not exists");
		}
		comment.setDate(new Date());
		comment.setUser(user);
		comment.setPost(post);
		return repo.save(comment);
	}
	
	public void deleteComment(Long commentId) {
		repo.deleteById(commentId);;
	}

}
