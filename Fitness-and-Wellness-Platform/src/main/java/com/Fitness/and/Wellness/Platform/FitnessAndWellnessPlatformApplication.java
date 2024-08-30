package com.Fitness.and.Wellness.Platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.Fitness.and.Wellness.Platform.model")
@EnableJpaRepositories(basePackages = "com.Fitness.and.Wellness.Platform.repository")
@ComponentScan(basePackages = "com.Fitness.and.Wellness.Platform")
public class FitnessAndWellnessPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessAndWellnessPlatformApplication.class, args);
	}

}
