package com.kata.tictactoe.util;

public enum Player {

    BLANK(" "),
    X("X"),
    O("O");


    private final String text;

    Player(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
