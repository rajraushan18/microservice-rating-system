package com.project.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;	//it is used for creating getters and setters

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

	@Id
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, length = 10)
	private long contact;
	
	
	//rating by users
	@Transient		//this will ignore by the database
	private List<Rating> ratings = new ArrayList<>(); 
	
	
}