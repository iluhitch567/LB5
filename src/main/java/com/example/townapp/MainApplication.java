package com.example.townapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to TownApp!");
		SpringApplication.run(MainApplication.class, args);
	}
}