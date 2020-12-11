package com.kata.tictactoe.model;

import com.kata.tictactoe.utils.TicTacToeBoardValues;

import java.util.Arrays;
import java.util.List;

public class TicTacToeBoard {

    private String[][] gameBoardMatrix;
    private final int maxNumberOfLines = 3;
    private final int maxNumberOfColumns = 3;

    public TicTacToeBoard() {
        gameBoardMatrix = new String[maxNumberOfLines][maxNumberOfColumns];
        for (int i = 0; i < maxNumberOfLines; i++){
            for(int j = 0; j < maxNumberOfColumns; j++)
                gameBoardMatrix[i][j] = TicTacToeBoardValues.EMPTY.getValue();
        }
    }

    public String[][] getGameBoardMatrix(){
        return gameBoardMatrix;
    }

    public int calculateLineOfPosition(int position) {
        if (position < 0 || position > 9)
            throw new IllegalArgumentException("The given position has to be between 1 and 9");
        return position <= 3 ? 1 : position <= 6 ? 2 : 3;
    }

    public String getValueOfPos(int position) {
        int lineOfPos = calculateLineOfPosition(position);
        int indexOfListToGet = lineOfPos;

        int indexOfPosition = (position > 6 ? position - 6 : position > 3 ? position - 3 : position);

        String value = gameBoardMatrix[indexOfListToGet-1][indexOfPosition-1];

        return value;
    }

    public void addValueOnPosition(String value, int position) {
        if (!(value.equals(TicTacToeBoardValues.X.getValue()) | (value.equals(TicTacToeBoardValues.O.getValue()))))
           throw new IllegalArgumentException("Something went wrong, wrong player symbol is being added to the board");

        int lineOfPos = calculateLineOfPosition(position);
        int indexOfListToGet = lineOfPos;

        int indexOfPosition = (position > 6 ? position - 6 : position > 3 ? position - 3 : position);

        gameBoardMatrix[indexOfListToGet-1][indexOfPosition-1] = value;
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
        String currentValue = null;
        String lastValue = null;

        for (int column = 0; column < maxNumberOfColumns; column++) {
            for (int line = 0; line < maxNumberOfLines; line++) {

                currentValue = gameBoardMatrix[line][column];
                if (currentValue.trim().isEmpty())
                    break;

                if (lastValue != null && !currentValue.trim().equals(lastValue.trim()))
                    break;

                lastValue = currentValue;

                if (line == maxNumberOfColumns - 1)
                    return true;
            }
            lastValue = null;
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

    public boolean isThereAnyWinningLine(){
        if (isThereAHorizontalWinner() || isThereAVerticalWinner() || isThereADiagonalWinner())
            return true;
        return false;
    }
}
