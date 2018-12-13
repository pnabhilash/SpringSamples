package com.pabs.app;

import com.pabs.app.entities.Course;
import com.pabs.app.entityManagers.CourseEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaExperimentsApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private  CourseEntityManager courseEntityManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaExperimentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course=courseEntityManager.findById(101L);

		logger.info("Course find by id  {} ",course.toString());
		logger.info("Testing Save / Update / Insert / Detach on same session  ");

		//enable only if needed !

		//courseEntityManager.saveAndUpdateInSameSession();
		//courseEntityManager.saveAndUpdateInSameSessionButFlush();
		//courseEntityManager.saveAndUpdateWithDetachedObjectInSameSession();

	}
}

