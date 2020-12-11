package com.kata.tictactoe.model.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeRules {
    private List<String> rules = new ArrayList<>(Arrays.asList(
            "Player-X always starts.",
            "Players alternate turns when picking a position.",
            "Choose a position on the board (between 1 and 9).",
            "Players cannot play a played position.",
            "A player wins when he/she has 3 of his/her symbols in a row.",
            "If all nine squares all filled without having a winner, the game will be a draw."));

    public List<String> getRules(){
        return rules;
    }
}
