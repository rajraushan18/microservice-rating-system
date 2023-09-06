package com.project.hotelservice.services;

import java.util.List;

import com.project.hotelservice.entities.Hotel;

public interface HotelService {

	//create hotel
	Hotel createHotel(Hotel hotel); 
	
	
	//get all hotels
	List<Hotel> getAllHotels();
	
	//get single hotel
	Hotel getHotel(String id);
	
}
