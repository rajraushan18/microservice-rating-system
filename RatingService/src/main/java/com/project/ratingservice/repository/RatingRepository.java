package com.project.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ratingservice.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	//custom finder methods
	List<Rating> findByUserId(String UserId);
	List<Rating> findByHotelId(String HotelId);
	
	
}
