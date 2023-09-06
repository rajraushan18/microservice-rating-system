package com.project.ratingservice.controllers;

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

import com.project.ratingservice.entities.Rating;
import com.project.ratingservice.services.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		Rating rating1 = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	
	//get all
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		List<Rating> allRating = ratingService.getAllRating();
		return ResponseEntity.ok(allRating);
	}
	
	//get rating by user id
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingByUserId);
	}
	
	//get rating by hotel id
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratingByHotelID = ratingService.getRatingByHotelID(hotelId);
		return ResponseEntity.ok(ratingByHotelID);
	}
	
	
}
