package com.kata.tictactoe.util;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayGameTest {

    @Test
    public void testPlayerMoveGame() {
        // Initialize grid
        int nbOfRowsAndCols=3;
        List<List<Cell>> grid = GameInitializer.getGameGrid(nbOfRowsAndCols);

        int playedRow=0;
        int playedCol=0;

        // Play a move
        PlayGame playGame=new PlayGame();
        playGame.playMove(grid, playedRow, playedCol, PlayerType.O);


        // Assert grid is not null
        assertNotNull(grid);

        // Assert
        assertEquals("O",grid.get(playedRow).get(playedCol).getPlayer());
    }

    @Test
    public void testIfCellBankAfterPlayerMove() {

        // Initialize grid
        int nbOfRowsAndCols=3;
        List<List<Cell>> grid = GameInitializer.getGameGrid(nbOfRowsAndCols);

        int playedRow=0;
        int playedCol=0;

        // Play a move
        PlayGame playGame=new PlayGame();
        playGame.playMove(grid, playedRow, playedCol,PlayerType.O);

        // Assert grid is not null
        assertNotNull(grid);

        // Assert the cell is not empty
        assertFalse(playGame.isCellBlank(grid,playedRow, playedCol));
    }



}
