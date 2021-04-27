package com.kata.tictactoe.controller;

import com.kata.tictactoe.enums.GameStatus;
import com.kata.tictactoe.enums.PlayerType;
import com.kata.tictactoe.util.Cell;
import com.kata.tictactoe.util.GameInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = IndexController.class)
public class IndexControllerTest {

    List<List<Cell>> grid=new ArrayList<>();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        grid= GameInitializer.getGameGrid(3);

    }

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(request().sessionAttribute("welcome_msg", equalTo("Welcome To Tic Tac Toe Game")))
                .andExpect(request().sessionAttribute("grid",grid));
    }

    @Test
    public void testPlayingGamePage() throws Exception {

        grid.get(1).get(1).setPlayer(PlayerType.X.toString());

        MockHttpSession session = new MockHttpSession();
        session.setAttribute("grid",grid);

        mockMvc.perform(get("/playing?row=1&col=1")
                .session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(request().sessionAttribute("grid",grid))
                .andExpect(request().sessionAttribute("game_status",GameStatus.CELL_BUSY.toString()));
    }
}
