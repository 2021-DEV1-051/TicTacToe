package com.kata.tictactoe.util;

import java.util.List;
import java.util.Objects;

public class PlayGame {

    /**
     * This method is called when a player draw in a cell with coordinates passed as parameters
     *
     * @param grid - Game grid
     * @param playedRow - Row index
     * @param playedCol - Column index
     * @param playerType - Player X or O
     * @return updated grid
     */
    public List<List<Cell>> playMove(List<List<Cell>> grid, int playedRow, int playedCol, PlayerType playerType) {
        grid.get(playedRow).get(playedCol).setPlayer(playerType.toString());
        return grid;
    }

    /**
     * Check if a given cell is Blank.
     *
     * @param grid - Game grid
     * @param playedRow - Row index
     * @param playedCol - Column index
     * @return true if the given box is Blank.
     */
    public boolean isCellBlank(List<List<Cell>> grid, int playedRow, int playedCol) {
        return Objects.equals(grid.get(playedRow).get(playedCol).getPlayer(), PlayerType.BLANK.toString());
    }

    /**
     * This method evaluates if player wins horizontally
     *
     * @param grid - Game grid
     * @param playerType - Player X or O
     * @return true if all cells in a row are played by a player
     */
    public boolean isWinnerInRow(List<List<Cell>> grid,PlayerType playerType){
        boolean allMatch=false;
        for (List<Cell> cells : grid) {
            allMatch = cells.stream().allMatch((value) -> Objects.equals(value.getPlayer(), playerType.toString()));
            if (allMatch) break;
        }
        return allMatch;
    }



}
