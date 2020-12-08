package com.kata.tictactoe.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeGameTest {

    @Test
    public void shouldAddTwoPlayersToTheGame(){
       TicTacToeGame game = new TicTacToeGame();
       TicTacToePlayer player1 = new TicTacToePlayer();
       TicTacToePlayer player2 = new TicTacToePlayer();
       List<TicTacToePlayer> playerList = new ArrayList<>();

       playerList.add(player1);
       playerList.add(player2);
       game.addPlayers(playerList);

       assertEquals(2,game.getNumberOfPlayers());
    }
}
