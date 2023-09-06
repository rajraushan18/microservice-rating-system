package com.project.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
	
	//this config server is used to save repeating configuration code to the github
	//so that it could be used whenever needed and will be saved in external instead of internal
	//If anything needed to be changed can be changed at one place only
	
	//created a config server repo on github which will be storing all the required configurations

}
