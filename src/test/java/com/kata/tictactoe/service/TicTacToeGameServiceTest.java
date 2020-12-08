package com.kata.tictactoe.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeGameServiceTest {

    @Test
    public void shouldCreateTheCorrectAmountOfPlayers(){
        int numberOfPlayersToCreate = 2;
        TicTacToeGameService service = new TicTacToeGameService();

        service.createPlayers(numberOfPlayersToCreate);

        assertEquals(2,service.getPlayers().size());
    }


}
