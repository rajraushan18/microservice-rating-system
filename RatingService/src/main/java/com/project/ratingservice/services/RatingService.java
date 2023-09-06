package com.project.ratingservice.services;

import java.util.List;


import com.project.ratingservice.entities.Rating;

public interface RatingService {

	//create
	Rating createRating(Rating rating);
	
	//get all rating
	List<Rating> getAllRating();
	
	//get all by userID
	List<Rating> getRatingByUserId(String UserId);
	
	//get all by hotel ID
	List<Rating> getRatingByHotelID(String HotelId);
	
}
