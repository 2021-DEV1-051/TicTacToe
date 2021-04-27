package com.kata.tictactoe.enums;

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
