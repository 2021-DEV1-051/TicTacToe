package com.kata.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/"})
public class IndexController {

    /**
     * Index page that set game grid
     */
    @GetMapping
    public String getIndex(Model model) {

        // Setting the Model that will be used by the View to display data
        model.addAttribute("welcome_msg", "Welcome To Tic Tac Toe Game");

        return "index";
    }
}
