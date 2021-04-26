package com.kata.tictactoe.util;

import java.util.List;

public class PlayGame {

    /**
     * This method is called when a player draw in a cell with coordinates passed as parameters
     *
     * @param grid -
     * @param playedRow -
     * @param playedCol -
     * @param playerType -
     * @return updated grid
     */
    public List<List<Cell>> playMove(List<List<Cell>> grid, int playedRow, int playedCol, PlayerType playerType) {
        grid.get(playedRow).get(playedCol).setPlayer(playerType.toString());
        return grid;
    }



}
