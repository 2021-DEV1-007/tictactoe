package com.kata.tictactoe.service;

import com.kata.tictactoe.model.TicTacToeGame;
import com.kata.tictactoe.model.TicTacToePlayer;
import com.kata.tictactoe.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicTacToeGameService implements GameService {

    private List<TicTacToePlayer> playerList;
    private TicTacToeGame game;

    @Autowired
    private ScannerUtil scan;

    @Override
    public void setUpGame(){
        game = new TicTacToeGame();
        try {
            createPlayers(game.getNumberOfPlayers());
            addPlayersToGame();
        } catch (IllegalArgumentException ie){
            scan.sayToPlayer(ie.getMessage());
        } catch (NullPointerException np){
            scan.sayToPlayer("There seems to be a problem while setting up the game, playerList is empty");
        }
    }

    public void displayTheBoard(){
        scan.sayToPlayer("\n-------------");
        for(String[] line: game.getBoard()) {
            scan.sayToPlayer("| " + line[0] + " | " + line[1] + " | " + line[2] + " |");
            scan.sayToPlayer("-------------");
        }
    }

    public void showRules(){
        scan.sayToPlayer("\nThese are the rules:");
        for(String rule : game.getRules())
            scan.sayToPlayer(rule);
    }

    @Override
    public void addPlayersToGame(){
        game.addPlayers(playerList);
    }

    @Override
    public void createPlayers(int numberToCreate) {
        TicTacToePlayer createdPlayer;
        playerList = new ArrayList<>(numberToCreate);
        int index = 0;

        while(index < numberToCreate){
            createdPlayer = new TicTacToePlayer(index);
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
