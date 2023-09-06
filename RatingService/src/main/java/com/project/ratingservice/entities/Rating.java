package com.project.ratingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	@Id
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
	
}
