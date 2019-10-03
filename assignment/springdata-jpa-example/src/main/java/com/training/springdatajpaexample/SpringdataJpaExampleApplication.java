package com.training.springdatajpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@EnableEurekaClient
@SpringBootApplication
@EnableResourceServer
public class SpringdataJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataJpaExampleApplication.class, args);
	}

}
