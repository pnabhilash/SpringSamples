package com.pabs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class GlobalSpringCloudConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalSpringCloudConfigurationApplication.class, args);
	}

}

