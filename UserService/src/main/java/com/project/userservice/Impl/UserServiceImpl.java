//this class is to reduce the complexity of the database code.
//so that in service class only methods will be there and implementation will be here
//to reduce complexity

package com.project.userservice.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.userservice.entities.Hotel;
import com.project.userservice.entities.Rating;
import com.project.userservice.entities.User;
import com.project.userservice.exceptions.ResourceNotFoundException;
import com.project.userservice.external.services.HotelService;
import com.project.userservice.repository.UserRepository;
import com.project.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User saveUser(User user) {
		// generate unique user id
		String randomUserId = UUID.randomUUID().toString();
		user.setId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// Implement rating option for all users also
		return userRepository.findAll();
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("User with given id doesn't found!!"));
		
		//fetch all rating of the above user using rating service
		//using service name instead of localhost:8083 as it will not affect the url even if the port number is changed
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getId(), Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		//fetch the hotels from the ratings we get above
		List<Rating> ratingList = ratings.stream().map(rating -> {
			//api call to hotel service to get the hotel
			//using here feign client to make the http request
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			//can also be used getForObject to get direct hotel details
			//getForEntity will provide more details
			//commented because using feign client 
//			Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			//set the hotel to rating
			rating.setHotel(hotel);
			
			//return the rating
			
			return rating;
		}).collect(Collectors.toList());		
		
		user.setRatings(ratingList);
		
		return user;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
