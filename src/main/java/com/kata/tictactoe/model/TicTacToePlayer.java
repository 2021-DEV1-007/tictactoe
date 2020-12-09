package com.kata.tictactoe.model;

public class TicTacToePlayer {

    private int id;
    private String name;
    private boolean isFirstToPlay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFirstToPlay() {
        return isFirstToPlay;
    }

    public void setFirstToPlay(boolean firstToPlay) {
        isFirstToPlay = firstToPlay;
    }
}
