package com.kata.tictactoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToePlayerTest {

    @Test
    public void shouldPassWhenMakingTwoPlayers(){
        TicTacToePlayer player1 = new TicTacToePlayer(0);
        TicTacToePlayer player2 = new TicTacToePlayer(1);
        assertEquals(0, player1.getId());
        assertEquals(1, player2.getId());
    }

    @Test
    public void makingPlayersWithHighId_ShouldThrowException(){
        fail("shouldFail");
    }

}
