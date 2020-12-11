package com.kata.tictactoe.utils;

public enum TicTacToeBoardValues {

    X("X"), O("O"), EMPTY(" ");

    private String value;

    TicTacToeBoardValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
