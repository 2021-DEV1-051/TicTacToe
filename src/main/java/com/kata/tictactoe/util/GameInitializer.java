package com.kata.tictactoe.util;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    /**
     * This method return list of cells as the game grid. It is based on a parameter passed as number of rows and columns
     * @param nbOfRowsAndCols - Number of row and column
     * @return grid
     */
    public static List<List<Cell>> getGameGrid(int nbOfRowsAndCols) {
        List<List<Cell>> grid=new ArrayList<>();

        // This for loop is for rows
        for(int row = 0; row< nbOfRowsAndCols; row++){
            List<Cell> listCells=new ArrayList<>();

            // This for loop is for columns
            for(int col = 0; col< nbOfRowsAndCols; col++){
                // Set default values for a cell
                listCells.add(new Cell(row,col, PlayerType.BLANK.toString()));
            }
            grid.add(listCells);
        }
        return grid;
    }
}
