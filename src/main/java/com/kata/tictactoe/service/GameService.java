package com.kata.tictactoe.service;

public interface GameService {
    void setUpGame();
    void startGame();
    void createPlayers(int numberToCreate);
    void addPlayersToGame();
}
