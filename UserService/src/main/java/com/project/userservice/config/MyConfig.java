package com.project.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

	@Bean
	@LoadBalanced	//this is used to load the url using the service name i.e HOTEL-SERVICE, RATING-SERVICE
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
