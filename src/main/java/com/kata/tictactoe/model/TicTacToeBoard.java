package com.kata.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

    private List<String[]> gameBoardMatrix;

    public TicTacToeBoard(){
        gameBoardMatrix = new ArrayList<>(3);
        String[] emptyLine = {" ", " ", " "};
        for (int i = 1; i<=3 ; i++)
            gameBoardMatrix.add(emptyLine);
    }

    public List<String[]> getGameBoardMatrix(){
        return gameBoardMatrix;
    }

}
