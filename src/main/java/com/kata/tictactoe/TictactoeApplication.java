package com.kata.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		System.out.println("SpringBootRunner start");
		SpringApplication.run(TictactoeApplication.class, args);
	}

}
