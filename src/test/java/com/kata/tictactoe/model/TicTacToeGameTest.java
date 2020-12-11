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

    @Test
    public void aVerticalWinnerShouldBeFound() {
        List<TicTacToePlayer> playerList = new ArrayList<>();

        playerList.add(player1);
        playerList.add(player2);

        game.addValueOnPosition("X", 1);
        game.addValueOnPosition("X", 4);
        game.addValueOnPosition("X", 7);

        assertTrue(game.winnerFoundOrBoardFull());
    }

    @Test
    public void noWinnerShouldBeFound_WhenThereIsNoWinnerAndBoardIsNotFull() {
        List<TicTacToePlayer> playerList = new ArrayList<>();

        playerList.add(player1);
        playerList.add(player2);

        game.addValueOnPosition("X", 1);
        game.addValueOnPosition("O", 4);
        game.addValueOnPosition("X", 7);

        assertFalse(game.winnerFoundOrBoardFull());
    }

    @Test
    public void shouldPassWhenBoardIsFullAndNoLineWinnerIsFound() {
        List<TicTacToePlayer> playerList = new ArrayList<>();

        playerList.add(player1);
        playerList.add(player2);

        game.addValueOnPosition("X", 1);
        game.addValueOnPosition("O", 2);
        game.addValueOnPosition("X", 3);

        assertFalse(game.winnerFoundOrBoardFull());

        game.addValueOnPosition("O",5);
        game.addValueOnPosition("X",4);
        game.addValueOnPosition("O",6);
        game.addValueOnPosition("X",8);
        game.addValueOnPosition("O",7);
        game.addValueOnPosition("X",9);

        assertTrue(game.winnerFoundOrBoardFull());
    }

    @Test
    public void addingWrongValue_ShouldThrowException(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> game.addValueOnPosition("X",90));
        String expectedMessage = "between 1 and 9";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checkingIfCorrectGivenPositionIsValid_ShouldPass(){
        assertTrue(game.isChosenPositionValid(4));
    }

    @Test
    public void checkingIfCorrectGivenPositionIsValidShouldPass_WhenFieldIsNotEmpty(){
        game.addValueOnPosition("X", 4);
        assertFalse(game.isChosenPositionValid(4));
    }

    @Test
    public void checkingIfGivenPositionIsValidWithWrongPosition_ShouldThrowException(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> game.isChosenPositionValid(10));
        String expectedMessage = "between 1 and 9";
        String actualMessage = ex.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void declaringWinnerWithoutWinnerHasBeenFound_ShouldThrowException(){
        assertThrows(IllegalArgumentException.class, () -> game.declareResult(player1.getSymbol()));
    }
}
