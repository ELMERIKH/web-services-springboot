package com.example.custumerservice;


import com.example.custumerservice.entities.Customer;

import com.example.custumerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustumerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("moncef").email("moncef@gmail.com").build(),
					Customer.builder().name("kop").email("kop@gmail.com").build(),
					Customer.builder().name("yolo").email("yolo@gmail.com").build()
			));
				customerRepository.findAll().forEach(System.out::println);
		};
	}
}
