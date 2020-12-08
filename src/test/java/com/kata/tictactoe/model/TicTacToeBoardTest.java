package com.kata.tictactoe.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TicTacToeBoardTest {

    @Test
    public void shouldMakeANewEmptyGameBoard(){

        TicTacToeBoard gameBoard = new TicTacToeBoard();

        List<String[]> board = gameBoard.getGameBoardMatrix();

        assertNotNull(board);
    }

}
