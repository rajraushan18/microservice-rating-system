package com.project.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.userservice.entities.User;
import com.project.userservice.services.UserService;

@RestController		//used for API calling
@RequestMapping("/users")
public class UserControllers {

	@Autowired
	private UserService userService;
	
	//how can i take multiple json input at once
	//create
	@PostMapping
	public ResponseEntity<User>createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//get single user
	@GetMapping("/{id}")
	public ResponseEntity<User>getSingleUser(@PathVariable String id){
		User user = userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	//get all user
	@GetMapping
	public ResponseEntity<List<User>>getAllUser(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
}
