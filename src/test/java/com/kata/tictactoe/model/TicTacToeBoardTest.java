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
        gameBoard.addValueOnPosition("X", 1);
        gameBoard.addValueOnPosition("O", 2);
        gameBoard.addValueOnPosition("O", 3);
        gameBoard.addValueOnPosition("X", 4);
        gameBoard.addValueOnPosition("X", 5);
        gameBoard.addValueOnPosition("O", 6);
        gameBoard.addValueOnPosition("X", 7);
        gameBoard.addValueOnPosition("O", 8);
        gameBoard.addValueOnPosition("X", 9);
        assertTrue(gameBoard.isBoardFull());
    }

    @Test
    public void shouldPassWhenBoardIsNotFull() {
        gameBoard.addValueOnPosition("X",4);
        gameBoard.addValueOnPosition("X",2);
        assertFalse(gameBoard.isBoardFull());
    }

    @Test
    public void shouldPassWhenThereIsAWinningHorizontalLine() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",2);
        gameBoard.addValueOnPosition("X",4);
        assertFalse(gameBoard.isThereAHorizontalWinner());

        gameBoard.addValueOnPosition("X",3);
        assertTrue(gameBoard.isThereAHorizontalWinner());
    }

    @Test
    public void shouldReturnFalseWhenThereIsNoHorizontalWinner() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",2);
        gameBoard.addValueOnPosition("O",3);
        assertFalse(gameBoard.isThereAHorizontalWinner());
    }

    @Test
    public void shouldPassWhenThereIsAVerticalWinner() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",4);
        gameBoard.addValueOnPosition("X",7);
        assertTrue(gameBoard.isThereAVerticalWinner());
    }

    @Test
    public void shouldPassWhenThereIsNoVerticalWinner() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",3);
        gameBoard.addValueOnPosition("O",4);
        gameBoard.addValueOnPosition("X",7);
        assertFalse(gameBoard.isThereAVerticalWinner());
    }

    @Test
    public void shouldPassWhenThereIsNoVerticalWinner_WithDifferentInput() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("O",3);
        gameBoard.addValueOnPosition("X",7);
        assertFalse(gameBoard.isThereAVerticalWinner());
    }

    @Test
    public void shouldPassWhenThereIsNoVerticalButOnlyHorizontalWinner() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",2);
        gameBoard.addValueOnPosition("X",3);
        assertFalse(gameBoard.isThereAVerticalWinner());
    }

    @Test
    public void shouldNotFindVeritcalWinner_WithDifferentInput() {
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("O",4);
        gameBoard.addValueOnPosition("X",7);
        assertFalse(gameBoard.isThereAVerticalWinner());
    }

    @Test
    public void shouldNotFindADiagonalWinnerWhenThereIsNone(){
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("O",2);
        gameBoard.addValueOnPosition("X",9);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("X",3);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("O",5);
        assertFalse(gameBoard.isThereADiagonalWinner());
    }

    @Test
    public void shouldFindADiagonalWinnerWhenThereIsOne(){
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("O",2);
        gameBoard.addValueOnPosition("X",9);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("O",3);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("O",5);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("X",5);
        assertTrue(gameBoard.isThereADiagonalWinner());
    }

    @Test
    public void shouldFindADiagonalWinnerWhenThereIsAnother(){
        gameBoard.addValueOnPosition("O",2);
        gameBoard.addValueOnPosition("X",7);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("O",3);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("X",3);
        assertFalse(gameBoard.isThereADiagonalWinner());
        gameBoard.addValueOnPosition("X",5);
        assertTrue(gameBoard.isThereADiagonalWinner());
    }

    @Test
    public void passWhenAHorizontalWinnerIsPresent() {
        assertFalse(gameBoard.isThereAnyWinningLine());
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",2);
        assertFalse(gameBoard.isThereAnyWinningLine());
        gameBoard.addValueOnPosition("X",3);
        assertTrue(gameBoard.isThereAnyWinningLine());
    }

    @Test
    public void checksIfAVerticalWinner_returnsTrueForCheckingWinner() {
        assertFalse(gameBoard.isThereAnyWinningLine());
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",4);
        assertFalse(gameBoard.isThereAnyWinningLine());
        gameBoard.addValueOnPosition("X",7);
        assertTrue(gameBoard.isThereAnyWinningLine());
    }

    @Test
    public void checksIfADiagonalWinner_returnsTrueForCheckingWinner() {
        assertFalse(gameBoard.isThereAnyWinningLine());
        gameBoard.addValueOnPosition("X",1);
        gameBoard.addValueOnPosition("X",5);
        assertFalse(gameBoard.isThereAnyWinningLine());
        gameBoard.addValueOnPosition("X",9);
        assertTrue(gameBoard.isThereAnyWinningLine());
    }
}
