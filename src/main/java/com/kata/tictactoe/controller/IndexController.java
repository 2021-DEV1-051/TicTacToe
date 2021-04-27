package com.kata.tictactoe.controller;

import com.kata.tictactoe.util.Cell;
import com.kata.tictactoe.util.GameInitializer;
import com.kata.tictactoe.util.PlayGame;
import com.kata.tictactoe.util.PlayerType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({ "/"})
public class IndexController {

    // Initialization of the game grid
    List<List<Cell>> grid=new ArrayList<>();
    PlayGame playGame=new PlayGame();
    PlayerType playerType=PlayerType.X;

    /**
     * Index page that initializes game grid
     */
    @GetMapping
    public String getIndex(Model model) {

        // Set game grid
        grid= GameInitializer.getGameGrid(3);

        // Setting the Model that will be used by the View to display data
        model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");
        model.addAttribute("current_player", playerType+"'s Turn");
        model.addAttribute("grid", grid);

        return "index";
    }

    /**
     * Method called when users start playing
     */
    @GetMapping("/playing")
    public String startGame(Model model, @RequestParam(name = "row") int row, @RequestParam(name = "col") int col) {


        // If Game grid is not set (grid with 0 row and 0 col), redirect to index to reinitialize game
        if(grid.size()==0) {
            return "redirect:/";
        }

        playGame.playMove(grid,row,col,playerType);

        // Setting the Model that will be used by the View to display data
        model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");
        model.addAttribute("grid", grid);


        playerType=playGame.switchPlayers(playerType);
        model.addAttribute("current_player", playerType+"'s Turn");
        return "index";
    }


}
