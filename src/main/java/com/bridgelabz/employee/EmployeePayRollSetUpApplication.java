package com.bridgelabz.employee;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@EnableJpaRepositories
//@Slf4j
public class EmployeePayRollSetUpApplication {


	public static void main(String[] args) {
		SpringApplication.run(EmployeePayRollSetUpApplication.class, args);
		
	}

}
