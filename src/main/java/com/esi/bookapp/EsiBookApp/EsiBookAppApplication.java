package com.esi.bookapp.EsiBookApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsiBookAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EsiBookAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello book app");
	}
}
