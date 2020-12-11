package com.kata.tictactoe;

import com.kata.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TictactoeApplication implements CommandLineRunner {

	@Autowired
	private GameService gameService;

	public static void main(String[] args) {
		SpringApplication.run(TictactoeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gameService.setUpGame();
		gameService.startGame();
	}
}
