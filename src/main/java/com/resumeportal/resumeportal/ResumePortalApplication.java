package com.resumeportal.resumeportal;

import com.resumeportal.resumeportal.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class ResumePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumePortalApplication.class, args);
	}

}
