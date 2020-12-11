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

    @Override
    public void startGame() {
        try {
            showRules();
            boolean doAnotherTurn = true;
            String lastPlayer = "";

            while (doAnotherTurn) {
                for (TicTacToePlayer player : playerList) {
                    lastPlayer = player.getName();
                    playerDoesATurn(player);
                    if (game.winnerFoundOrBoardFull()) {
                        doAnotherTurn = false;
                        break;
                    }
                }
            }
            scan.sayToPlayer(game.declareResult(lastPlayer));
        } catch (IllegalArgumentException ie){
            scan.sayToPlayer("Cannot declare the winner when game has not finished");
        } catch (Exception e) {
            scan.sayToPlayer("The game will end. Server error: CheckDiagonalWinner:" + e.getMessage());
        }
    }

    public void playerDoesATurn(TicTacToePlayer player) {
        boolean askForChoice = true;
        int playersChoice = -1;

        while (askForChoice){
            try {
                scan.sayToPlayer("\n" + player.getName() + ", what position on the board do you choose?");
                playersChoice = Integer.parseInt(scan.getInputFromUser());

                if (game.isChosenPositionValid(playersChoice)) {
                    game.addValueOnPosition(player.getSymbol(), playersChoice);
                    askForChoice = false;
                } else {
                    scan.sayToPlayer("You chose an invalid square, try again");
                }
            } catch (NumberFormatException ne) {
                scan.sayToPlayer("Don't use text, try again?");
            } catch (IllegalArgumentException ie){
                scan.sayToPlayer("Your position has to be between 1 and 9, try again");
            }
        }
        displayTheBoard();
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
