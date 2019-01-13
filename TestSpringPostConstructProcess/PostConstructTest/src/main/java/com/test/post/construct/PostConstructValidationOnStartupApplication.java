package com.test.post.construct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PostConstructValidationOnStartupApplication {

	Logger logger = LoggerFactory.getLogger(PostConstructValidationOnStartupApplication.class);

	@Autowired
	GlobalConfiguratioin configuration;

	public static void main(String[] args) {
		SpringApplication.run(PostConstructValidationOnStartupApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		logger.info("Global Configuration Values Set {} ",configuration.toString());

	}

}

