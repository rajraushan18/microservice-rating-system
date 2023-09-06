package com.project.hotelservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {

	@Id
	private String Id;
	private String name;
	private String city;
	private String about;
	
}
