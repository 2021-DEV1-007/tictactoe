package com.kata.tictactoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeBoardTest {

    @Test
    public void shouldMakeANewEmptyGameBoard() {
        TicTacToeBoard gameBoard = new TicTacToeBoard();

        assertNotNull(gameBoard);
        assertEquals(" ", gameBoard.getValueOfPos(1));
        assertEquals(" ", gameBoard.getValueOfPos(4));
        assertEquals(" ", gameBoard.getValueOfPos(8));
    }

    @Test
    public void shouldGiveTheCorrectLineInTheBoardmatrixOfTheGivenPosition() {
        TicTacToeBoard gameBoard = new TicTacToeBoard();

        int positionToCheck = 9;
        assertEquals(3, gameBoard.calculateLineOfPosition(positionToCheck));

        positionToCheck = 4;
        assertEquals(2, gameBoard.calculateLineOfPosition(positionToCheck));

        positionToCheck = 2;
        assertEquals(1, gameBoard.calculateLineOfPosition(positionToCheck));
    }

    @Test
    public void shouldAddAValueToTheBoardOnGivenPosition() {
        TicTacToeBoard emptyBoard = new TicTacToeBoard();
        String xValue = "X";
        String oValue = "O";

        emptyBoard.addValueOnPosition(xValue, 5);
        emptyBoard.addValueOnPosition(oValue, 9);

        assertEquals("X", emptyBoard.getValueOfPos(5));
        assertEquals("O", emptyBoard.getValueOfPos(9));
    }

    @Test
    public void shouldGetAValueOfAGivenPosition() {
        TicTacToeBoard emptyBoard = new TicTacToeBoard();
        String xValue = "X";

        assertEquals(" ", emptyBoard.getValueOfPos(5));
        emptyBoard.addValueOnPosition(xValue, 5);
        assertEquals("X", emptyBoard.getValueOfPos(5));
    }

}
