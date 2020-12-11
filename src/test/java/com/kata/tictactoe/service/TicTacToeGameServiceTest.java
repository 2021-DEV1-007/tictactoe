package com.kata.tictactoe.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeGameServiceTest {

    private TicTacToeGameService service;

    @BeforeEach
    public void setUp(){
        this.service = new TicTacToeGameService();
    }

    @Test
    public void shouldCreateTheCorrectAmountOfPlayers(){
        int numberOfPlayersToCreate = 2;

        service.createPlayers(numberOfPlayersToCreate);

        assertEquals(2,service.getPlayers().size());
    }

    @Test
    public void settingUpGameShouldReturnTwoPlayers(){
        service.setUpGame();

        assertEquals(2, service.getPlayers().size());
    }
}
