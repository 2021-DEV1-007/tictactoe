package com.kata.tictactoe.model;

public class TicTacToePlayer implements Player {

    private int id;
    private String name;
    private String symbol;

    public TicTacToePlayer(int id) {
        if (id > 1)
            throw new IllegalArgumentException("Id of players should be smaller than 2");

        this.id = id;
        if (id == 0) {
            this.name = "Player-X";
            this.symbol = "X";
        } else {
            this.name = "Player-O";
            this.symbol = "O";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

}
