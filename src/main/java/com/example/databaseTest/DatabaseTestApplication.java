package com.example.databaseTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class DatabaseTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseTestApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode("3180013");
			String encodedPassword2 = passwordEncoder.encode("admin");
			User user1 = new User("3180013", encodedPassword, "student",0, false, new Date());
			User user2 = new User("admin", encodedPassword2,"teacher",0,false,new Date());
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}


