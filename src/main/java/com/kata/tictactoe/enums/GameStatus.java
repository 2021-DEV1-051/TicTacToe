package com.kata.tictactoe.enums;

public enum GameStatus {
    CELL_BUSY("YOU COULD NOT PLAY IN THIS CELL"),
    GAME_DRAW("DRAW. NO WINNER");


    private final String text;

    GameStatus(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
