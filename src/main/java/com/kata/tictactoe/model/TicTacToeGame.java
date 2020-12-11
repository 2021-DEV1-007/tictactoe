package com.kata.tictactoe.model;

import com.kata.tictactoe.utils.WinnerStatus;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements Game {

    private final int numberOfPlayers = 2;

    private List<TicTacToePlayer> playerList = new ArrayList<>(2);
    private TicTacToeBoard gameBoard;


    public TicTacToeGame(){
        this.gameBoard = new TicTacToeBoard();
    }

    public void addPlayers(List<TicTacToePlayer> playersToAdd) {
        if(playersToAdd.size() > numberOfPlayers)
            throw new IllegalArgumentException("Trying to add too much players to the game");
        for(TicTacToePlayer player : playersToAdd)
            playerList.add(player);
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

}
