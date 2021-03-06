package com.clairgustafson.socialMediaApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairgustafson.socialMediaApi.entity.User;
import com.clairgustafson.socialMediaApi.repository.UserRepo;
import com.clairgustafson.socialMediaApi.view.Following;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public User login(User user) throws Exception{
		User foundUser = repo.findByUsername(user.getUsername());
		if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		} else {
			throw new Exception("Invalid username or password");
		}
	}
	
	public Following follow(Long userId, Long followId) throws Exception {
		User user = repo.findById(userId).orElseThrow();
		User follow = repo.findById(followId).orElseThrow();
		if (user == null || follow ==null) {
			throw new Exception("User does not exist.");
	}
		user.getFollowing().add(follow);
		repo.save(user);
		return new Following(user);
}
	
	public Following getFollowedUsers(Long userId) throws Exception {
		User user = repo.findById(userId).orElseThrow();
		if (user == null) {
			throw new Exception("User does not exist.");
		}
		return new Following(user);	
	}
	
	public User updateProfilePicture(Long userId, String url) throws Exception {
		User user = repo.findById(userId).orElseThrow();
		if (user == null) {
			throw new Exception("User does not exist.");
		}
		user.setProfilePictureUrl(url);
		return repo.save(user);
	}
}
