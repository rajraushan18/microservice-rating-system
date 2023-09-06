package com.project.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hotelservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
