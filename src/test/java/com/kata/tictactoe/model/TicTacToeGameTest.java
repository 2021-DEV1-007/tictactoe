package com.kata.tictactoe.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

    private TicTacToeGame game;
    private TicTacToePlayer player1;
    private TicTacToePlayer player2;

    @BeforeEach
    public void setUp(){
        game = new TicTacToeGame();
        player1 = new TicTacToePlayer(0);
        player2 = new TicTacToePlayer(1);
    }

    @Test
    public void shouldAlwaysReturnTwoMaxPlayers(){
        assertEquals(2,game.getNumberOfPlayers());
    }

    @Test
    public void shouldAddTwoPlayersToTheGame(){
       List<TicTacToePlayer> playerList = new ArrayList<>();

       playerList.add(player1);
       playerList.add(player2);
       game.addPlayers(playerList);

       assertEquals(2,game.getNumberOfPlayers());
    }

    @Test
    public void addingEmptyPlayerList_ShouldThrowException(){
        List<TicTacToePlayer> playerList = null;

        Exception ex = assertThrows(NullPointerException.class, () ->
            game.addPlayers(playerList));
    }

    @Test
    public void addingTooMuchPlayers_ShouldThrowException() {
        TicTacToePlayer player3 = new TicTacToePlayer(1);
        List<TicTacToePlayer> playerList = new ArrayList<>();

        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        assertThrows(IllegalArgumentException.class, () ->
            game.addPlayers(playerList));
    }
}
