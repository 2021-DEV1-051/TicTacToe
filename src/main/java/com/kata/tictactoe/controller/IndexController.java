package com.kata.tictactoe.controller;

import com.kata.tictactoe.enums.AppConstant;
import com.kata.tictactoe.enums.GameStatus;
import com.kata.tictactoe.util.Cell;
import com.kata.tictactoe.util.GameInitializer;
import com.kata.tictactoe.util.PlayGame;
import com.kata.tictactoe.enums.PlayerType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    public String getIndex(Model model, HttpSession session) {

        // Set game grid
        grid= GameInitializer.getGameGrid(3);

        // Initialize session attributes
        // Setting the Session attributes that will be used by the View to display data
        session.setAttribute("welcome_msg", AppConstant.WELCOME_MSG.toString());
        session.setAttribute("current_player", playerType+"'s Turn");
        session.setAttribute("grid", grid);
        session.setAttribute("game_status", "");
        session.setAttribute("win", false);

        return "index";
    }

    /**
     * Method called when users start playing
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/playing")
    public String startGame(HttpSession session, @RequestParam(name = "row") int row, @RequestParam(name = "col") int col) {

        // Get grid from session
        grid=(List<List<Cell>>) session.getAttribute("grid");

        // If Game grid is not set (grid with 0 row and 0 col), redirect to index to reinitialize game
        if(grid.size()==0) {
            return "redirect:/";
        }

        // Evaluate played cell is empty before it is marked
        if(!playGame.isCellBlank(grid,row,col)){
            session.setAttribute("game_status", GameStatus.CELL_BUSY.toString());
            return "index";
        }

        // Player marks in the specified cell
        playGame.playMove(grid,row,col,playerType);

        // Set grid in session that will be used by the View to display data
        session.setAttribute("grid", grid);

        // Evaluate if player wins and return current player wins
        if(hasPlayerWon()){
            session.setAttribute("game_status", "Player "+playerType+" won");
            session.setAttribute("win", true);
            return "index";
        }

        // Switch to the next player
        playerType=playGame.switchPlayers(playerType);
        session.setAttribute("current_player", playerType+"'s Turn");
        return "index";
    }

    private boolean hasPlayerWon(){
        return playGame.isWinnerHorizontally(grid,playerType) ||
                playGame.isWinnerVertically(grid,playerType )||
                playGame.isWinnerDiagonalBottomLeftToTopRight(grid,playerType) ||
                playGame.isWinnerDiagonalTopLeftToBottomRight(grid,playerType);

    }

}