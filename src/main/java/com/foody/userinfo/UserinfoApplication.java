package com.foody.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserinfoApplication.class, args);
	}

}
