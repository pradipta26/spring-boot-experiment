package org.basupr7.springboot.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class EmployeeApplication {
	//@Value("${databaseType}")
	//private static String dbType;

	public static void main(String[] args) {

		SpringApplication.run(EmployeeApplication.class, args);
		//System.out.println("Database Type: " + dbType);
	}

	//Disable default security for Post/Put request
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		return http.build();
	}
}
