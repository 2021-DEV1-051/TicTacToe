package com.kata.tictactoe.enums;

public enum AppConstant {
    WELCOME_MSG("Welcome To Tic Tac Toe Game");

    private final String text;

    AppConstant(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
