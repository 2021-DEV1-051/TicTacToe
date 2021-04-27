package com.kata.tictactoe.controller;

import com.kata.tictactoe.util.Cell;
import com.kata.tictactoe.util.GameInitializer;
import com.kata.tictactoe.util.PlayGame;
import com.kata.tictactoe.util.PlayerType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
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
                .andExpect(model().attribute("welcome_msg", equalTo("Welcome To Tic Tac Toe Game")))
                .andExpect(model().attribute("grid",grid));
    }

    @Test
    public void testPlayingGamePage() throws Exception {

        mockMvc.perform(get("/playing?row=1&col=1")
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }
}
