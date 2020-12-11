package com.kata.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeBoardTest {

    private TicTacToeBoard gameBoard;

    @BeforeEach
    public void setUp(){
        gameBoard = new TicTacToeBoard();
    }

    @Test
    public void shouldMakeANewEmptyGameBoard() {
        assertNotNull(gameBoard);
        assertEquals(" ", gameBoard.getValueOfPos(1));
        assertEquals(" ", gameBoard.getValueOfPos(4));
        assertEquals(" ", gameBoard.getValueOfPos(8));
    }

    @Test
    public void shouldGiveTheCorrectLineInTheBoardmatrixOfTheGivenPosition() {
        int positionToCheck = 9;
        assertEquals(3, gameBoard.calculateLineOfPosition(positionToCheck));

        positionToCheck = 4;
        assertEquals(2, gameBoard.calculateLineOfPosition(positionToCheck));

        positionToCheck = 2;
        assertEquals(1, gameBoard.calculateLineOfPosition(positionToCheck));
    }

    @Test
    public void calculatingLineForWrongPosition_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                ()->gameBoard.calculateLineOfPosition(-1));
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->gameBoard.calculateLineOfPosition(10));

        String expectedMessage = "The given position has to be between 1 and 9";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void gettingValueOfWrongPosition_ShouldThrowAnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                ()->gameBoard.getValueOfPos(-1));
        Exception ex = assertThrows(IllegalArgumentException.class,
                ()->gameBoard.getValueOfPos(10));

        String expectedMessage = "The given position has to be between 1 and 9";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldAddAValueToTheBoardOnGivenPosition() {
        String xValue = "X";
        String oValue = "O";

        gameBoard.addValueOnPosition(xValue, 5);
        gameBoard.addValueOnPosition(oValue, 9);

        assertEquals("X", gameBoard.getValueOfPos(5));
        assertEquals("O", gameBoard.getValueOfPos(9));
    }

    @Test
    public void shouldGetAValueOfAGivenPosition() {
        String xValue = "X";
        assertEquals(" ", gameBoard.getValueOfPos(5));
        gameBoard.addValueOnPosition(xValue, 5);
        assertEquals("X", gameBoard.getValueOfPos(5));
    }

    @Test
    public void addingValueOnWrongPosition_ShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class,() -> gameBoard.addValueOnPosition("X", -1));
        String expectedMessage = "The given position has to be between 1 and 9";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void addingWrongValueOnPosition_ShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class,() -> gameBoard.addValueOnPosition("K", 3));

        String expectedMessage = "Something went wrong, wrong player symbol is being added to the board";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void checksIfAListIsFilledInCompletely_ReturnsFalseWhenItIsNot() {
        String[] list = {" ", " ", "X"};
        assertFalse(gameBoard.isEveryElementOfLineFilledIn(list));
    }

    @Test
    public void checksIfAListIsFilledInCompletely_ReturnsTrue() {
        String[] list = {"O", "O", "X"};
        assertTrue(gameBoard.isEveryElementOfLineFilledIn(list));
    }

    @Test
    public void shouldPassIfBoardIsFull() {
        TicTacToeBoard board = new TicTacToeBoard();
        board.addValueOnPosition("X", 1);
        board.addValueOnPosition("O", 2);
        board.addValueOnPosition("O", 3);
        board.addValueOnPosition("X", 4);
        board.addValueOnPosition("X", 5);
        board.addValueOnPosition("O", 6);
        board.addValueOnPosition("X", 7);
        board.addValueOnPosition("O", 8);
        board.addValueOnPosition("X", 9);
        assertTrue(board.isBoardFull());
    }
}
