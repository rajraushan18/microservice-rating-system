package com.project.ratingservice.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ratingservice.entities.Rating;
import com.project.ratingservice.repository.RatingRepository;
import com.project.ratingservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		String randomUUID = UUID.randomUUID().toString();
		rating.setRatingId(randomUUID);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String UserId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(UserId);
	}

	@Override
	public List<Rating> getRatingByHotelID(String HotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(HotelId);
	}

}
