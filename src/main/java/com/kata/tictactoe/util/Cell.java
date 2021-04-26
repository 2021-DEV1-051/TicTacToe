package com.kata.tictactoe.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    private int row;
    private int col;
    private String player;
}
