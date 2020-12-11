package com.kata.tictactoe.model;

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

    public int calculateLineOfPosition(int position) {
        if (position < 0 || position > 9)
            throw new IllegalArgumentException("The given position has to be between 1 and 9");
        return position <= 3 ? 1 : position <= 6 ? 2 : 3;
    }

    public String getValueOfPos(int position) {
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

    public void addValueOnPosition(String value, int position) {
        if (!((value.equals("X")) | (value.equals("O"))))
           throw new IllegalArgumentException("Something went wrong, wrong player symbol is being added to the board");

        int lineOfPos = calculateLineOfPosition(position);
        int indexOfListToGet = lineOfPos-1;
        int indexOfPosition = position-1;

        String[] line = gameBoardMatrix.get(indexOfListToGet);

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

    public boolean isEveryElementOfLineFilledIn(String[] line){
        for(String element : line)
            if (element.trim().isEmpty())
                return false;
        return true;
    }

    public boolean isBoardFull(){
        int lineCounter = 0;

        for (String[] line : gameBoardMatrix)
            if(isEveryElementOfLineFilledIn(line))
                lineCounter++;

        return lineCounter == maxNumberOfLines;
    }

    public boolean isThereAHorizontalWinner(){
        for(String[] line : gameBoardMatrix) {
            if (!line[0].trim().isEmpty())
                if (line[0].equals(line[1]) && line[0].equals(line[2]))
                    return true;
        }
        return false;
    }

    public boolean isThereAVerticalWinner(){
        int elementPosToCheckInLine = 0;

        while(elementPosToCheckInLine < maxNumberOfColumns) {

            String currentValue = null;
            String lastValue = null;

            for (int i = 0; i < maxNumberOfLines; i++) {
                String[] line = gameBoardMatrix.get(i);
                currentValue = line[elementPosToCheckInLine];

                if (currentValue.trim().isEmpty())
                    break;

                if (lastValue != null && !currentValue.trim().equals(lastValue.trim()))
                    break;

                lastValue = currentValue;

                if (i == maxNumberOfLines-1)
                    return true;
            }

            lastValue = null;
            elementPosToCheckInLine++;
        }

        return false;
    }

    public boolean isThereADiagonalWinner(){
        return checkIfDiagonalWinnerForPositions(Arrays.asList(1,5,9)) | checkIfDiagonalWinnerForPositions(Arrays.asList(3,5,7));
    }


    private boolean checkIfDiagonalWinnerForPositions(List<Integer> posToCheck){
        String currentValue = null;
        String lastValue = null;

        for(int pos : posToCheck) {
            currentValue = getValueOfPos(pos);

            if (currentValue.trim().isEmpty())
                return false;

            if (lastValue != null && lastValue != currentValue)
                return false;

            lastValue = currentValue;
        }
        return true;
    }
}
