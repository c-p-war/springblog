package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

//Create a page at /roll-dice that asks the user to guess a number. There should be links on this page for 1 through 6 that should make a GET request to /roll-dice/n where n is the number guessed. This page should display a random number (the dice roll), the user's guess and a message based on whether or not they guessed the correct number.

@Controller
public class RollController {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

//    @GetMapping("/roll-dice/{n}")

}
