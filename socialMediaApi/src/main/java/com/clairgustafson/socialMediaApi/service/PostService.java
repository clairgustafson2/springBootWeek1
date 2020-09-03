package com.clairgustafson.socialMediaApi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.socialMediaApi.entity.Post;
import com.clairgustafson.socialMediaApi.entity.User;
import com.clairgustafson.socialMediaApi.repository.PostRepo;
import com.clairgustafson.socialMediaApi.repository.UserRepo;

@Service
public class PostService {
	
	@Autowired
	private PostRepo repo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Iterable<Post> getAllPosts(){
		return repo.findAll();
	}
	
	public Post getPost(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public Post updatePost(Post post, Long id) throws Exception {
		Post foundPost = repo.findById(id).orElseThrow();
		if (foundPost == null) {
			throw new Exception("Post not found.");
		}
		foundPost.setContent(post.getContent());
		return repo.save(foundPost);
	}
	
	public Post createPost(Post post, Long userId) throws Exception {
		User user = userRepo.findById(userId).orElseThrow();
		if (user == null) {
			throw new Exception("User not found.");
		}
		post.setDate(new Date());
		post.setUser(user);
		return repo.save(post);
	}
}
