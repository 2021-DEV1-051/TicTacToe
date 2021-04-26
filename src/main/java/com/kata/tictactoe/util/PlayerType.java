package com.kata.tictactoe.util;

public enum PlayerType {

    BLANK(" "),
    X("X"),
    O("O");


    private final String text;

    PlayerType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
