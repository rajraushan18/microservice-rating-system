package com.project.hotelservice.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelservice.entities.Hotel;
import com.project.hotelservice.exceptions.ResourceNotFoundException;
import com.project.hotelservice.repository.HotelRepository;
import com.project.hotelservice.services.HotelService;

@Service
public class hotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id)
				.orElseThrow(
						()-> new ResourceNotFoundException("hotel with given id not found!!"));
	}
	
	
	
}
