package com.example.demo;

import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(DemoApplication.class, args);
		RegistrationRepository registrationRepository = configurableApplicationContext.getBean(RegistrationRepository.class);

	}

}