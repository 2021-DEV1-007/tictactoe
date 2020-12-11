package com.kata.tictactoe.model;

import com.kata.tictactoe.model.rules.TicTacToeRules;
import com.kata.tictactoe.utils.WinnerStatus;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements Game {

    private WinnerStatus winningMethod = WinnerStatus.NOT_FOUND;
    private final int numberOfPlayers = 2;

    private List<TicTacToePlayer> playerList = new ArrayList<>(2);
    private TicTacToeBoard gameBoard;

    private TicTacToeRules rules;

    public TicTacToeGame() {
        this.gameBoard = new TicTacToeBoard();
        this.rules = new TicTacToeRules();
    }

    public void addPlayers(List<TicTacToePlayer> playersToAdd) {
        if (playersToAdd.size() > numberOfPlayers)
            throw new IllegalArgumentException("Trying to add too much players to the game");
        for (TicTacToePlayer player : playersToAdd)
            playerList.add(player);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void addValueOnPosition(String playerSymbol, int playersPosChoice) {
        gameBoard.addValueOnPosition(playerSymbol, playersPosChoice);
    }

    public boolean isChosenPositionValid(int position) {
        return gameBoard.getValueOfPos(position).trim().isEmpty();
    }

    public boolean winnerFoundOrBoardFull() {
        if (gameBoard.isThereAnyWinningLine()) {
            winningMethod = WinnerStatus.PLAYER;
            return true;
        } else if (gameBoard.isBoardFull()) {
            winningMethod = WinnerStatus.FULL;
            return true;
        }
        return false;
    }

    public String declareResult(String playerName) {
        if (winningMethod == WinnerStatus.FULL)
            return "It's a draw! the board is full !";
        else if(winningMethod == WinnerStatus.PLAYER)
            return "Congratulations: " + playerName + " You have won !";
        else
            throw new IllegalArgumentException("declaring a winner is not possible when the game has not ended");
    }

    public List<String> getRules(){
        return rules.getRules();
    }

    public List<String[]> getBoard(){
        return gameBoard.getGameBoardMatrix();
    }
}