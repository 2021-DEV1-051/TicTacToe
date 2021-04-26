package com.kata.tictactoe.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import java.util.List;

public class GameInitializerTest {


    @Test
    public void testGetGameGrid() {
        int nbOfRowsAndCols=3;
        List<List<Cell>> grid = GameInitializer.getGameGrid(nbOfRowsAndCols);
        assertNotNull(grid);
        assertEquals(nbOfRowsAndCols,grid.size());
    }


}
