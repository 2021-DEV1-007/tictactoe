package com.kata.tictactoe.model;

public class TicTacToePlayer implements Player {

    private int id;
    private String name;
    private String symbol;

    public TicTacToePlayer(int id) {
        this.id = id;
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
