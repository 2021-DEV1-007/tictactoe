package com.kata.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private final int maxNumberOfPlayers = 2;
    private List<TicTacToePlayer> playerList = new ArrayList<>(2);


    public TicTacToeGame(){

    }


    public void addPlayers(List<TicTacToePlayer> playersToAdd) {
        for(TicTacToePlayer player : playersToAdd)
            playerList.add(player);
    }

    public int getNumberOfPlayers(){
        return playerList.size();
    }

}
