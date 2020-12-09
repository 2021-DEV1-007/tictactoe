package com.kata.tictactoe.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeBoard {

    private List<String[]> gameBoardMatrix;
    private final int maxNumberOfLines = 3;
    private final int maxNumberOfColumns = 3;

    public TicTacToeBoard() {
        gameBoardMatrix = new ArrayList<>(3);

        for (int i = 0; i < maxNumberOfLines; i++){
            String[] emptyLine = {" ", " ", " "};
            gameBoardMatrix.add(emptyLine);
        }
    }

    public List<String[]> getGameBoardMatrix(){
        return gameBoardMatrix;
    }


    public int calculateLineOfPosition(int position){
        return position <= 3 ? 1 : position <= 6 ? 2 : 3;
    }

    public String getValueOfPos(int position){
        String valueOfPosition = null;
        int lineOfPos = calculateLineOfPosition(position);
        int indexOfListToGet = lineOfPos-1;
        int indexOfPosition = position-1;

        if (indexOfListToGet < 1){
            valueOfPosition = gameBoardMatrix.get(indexOfListToGet)[indexOfPosition];
        } else if (indexOfListToGet == 1){
            indexOfPosition = indexOfPosition - 3;
            valueOfPosition = gameBoardMatrix.get(indexOfListToGet)[indexOfPosition];
        } else {
            indexOfPosition = indexOfPosition - 6;
            valueOfPosition = gameBoardMatrix.get(indexOfListToGet)[indexOfPosition];
        }

        return valueOfPosition;
    }

    public void addValueOnPosition(String value, int position){
        int lineOfPos = calculateLineOfPosition(position);
        int indexOfListToGet = lineOfPos-1;
        int indexOfPosition = position-1;

        String[] line = gameBoardMatrix.get(indexOfListToGet);

        // TODO ==> Add check ? ==> positionAlreadyTaken

        if (indexOfListToGet < 1){
            line[indexOfPosition] = value;
        } else if (indexOfListToGet == 1){
            indexOfPosition = indexOfPosition - 3;
            line[indexOfPosition] = value;
        } else {
            indexOfPosition = indexOfPosition - 6;
            line[indexOfPosition] = value;
        }
    }

}
