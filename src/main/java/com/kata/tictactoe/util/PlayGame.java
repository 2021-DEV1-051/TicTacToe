package com.kata.tictactoe.util;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public boolean isWinnerHorizontally(List<List<Cell>> grid,PlayerType playerType){
        boolean allMatch=false;
        for (List<Cell> cells : grid) {
            allMatch = cells.stream().allMatch((value) -> Objects.equals(value.getPlayer(), playerType.toString()));
            if (allMatch) break;
        }
        return allMatch;
    }

    /**
     * This method evaluates if player wins vertically
     *
     * @param grid - Game grid
     * @param playerType - Player X or O
     * @return true if all cells in a column are played by a player
     */
    public boolean isWinnerVertically(List<List<Cell>> grid,PlayerType playerType){
        boolean allMatch=false;
        for(int i=0;i<grid.size();i++){
            allMatch = grid.stream().flatMap(Collection::stream).collect(Collectors.groupingBy(Cell::getCol)).get(i)
                    .stream().allMatch((value) -> Objects.equals(value.getPlayer(), playerType.toString()));
            if (allMatch) break;
        }
        return allMatch;
    }

    /**
     * This method evaluates if player wins diagonally from the top left to the bottom right
     *
     * @param grid - Game grid
     * @param playerType - Player X or O
     * @return true if all cells in diagonal are played by a player
     */
    public boolean isWinnerDiagonalTopLeftToBottomRight(List<List<Cell>> grid,PlayerType playerType){
        return grid.stream().flatMap(Collection::stream)
                .filter(cells -> Objects.equals(cells.getRow(),cells.getCol()))
                .allMatch(cell -> Objects.equals(cell.getPlayer(), playerType.toString()));
    }

    /**
     * This method evaluates if player wins diagonally from the bottom left to the top right
     *
     * @param grid - Game grid
     * @param playerType - Player X or O
     * @return true if all cells in diagonal are played by a player
     */
    public boolean isWinnerDiagonalBottomLeftToTopRight(List<List<Cell>> grid,PlayerType playerType){
        return grid.stream().flatMap(Collection::stream)
                .filter(cells -> (cells.getRow()+cells.getCol())==(grid.size()-1))
                .allMatch(cell -> Objects.equals(cell.getPlayer(), playerType.toString()));
    }

    /**
     * This method evaluates if game grid is full
     *
     * @param grid - Game grid
     * @return true if all cells are placed
     */
    public boolean isGridFull(List<List<Cell>> grid){
        return grid.stream().flatMap(Collection::stream)
                .noneMatch(cell-> Objects.equals(cell.getPlayer(), PlayerType.BLANK.toString()));
    }



}
