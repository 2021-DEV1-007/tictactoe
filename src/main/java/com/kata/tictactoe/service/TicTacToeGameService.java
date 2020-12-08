package com.kata.tictactoe.service;

import com.kata.tictactoe.model.TicTacToePlayer;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGameService {

    private List<TicTacToePlayer> playerList;

    public TicTacToeGameService(){

    }

    public void createPlayers(int numberToCreate) {
        TicTacToePlayer createdPlayer;
        playerList = new ArrayList<>(numberToCreate);
        int index = 0;

        while(index < numberToCreate){
            createdPlayer = new TicTacToePlayer();
            playerList.add(createdPlayer);
            index++;
        }
    }

    public List<TicTacToePlayer> getPlayers(){
        List<TicTacToePlayer> copiedPlayers = new ArrayList<>();

        playerList.forEach(player -> copiedPlayers.add(player));

        return copiedPlayers;
    }
}
