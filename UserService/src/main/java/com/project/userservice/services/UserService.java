package com.project.userservice.services;

import java.util.List;

import com.project.userservice.entities.User;

public interface UserService {

	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get user by user Id
	User getUser(String id);
	
	//delete user
	void deleteUser(String id);
	
	//update User
	User updateUser(User user);
	
}
