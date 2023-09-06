//it is a service which will store the url of all the services e.g. hotel, user and rating service
//and it will also show the details of every particular service that they are running or not
//using this, we can use service name in the url instead of that particular service url

package com.project.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
