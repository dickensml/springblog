package com.example.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/rolldice")
        public String pickNumber() {
            return "roll-dice";
    }

    @GetMapping("/diceresult")
        public String rollResult(@PathVariable int number, Model vModel) {
        Random ranNum = new Random();
        int roll = ranNum.nextInt(6) + 1;
        vModel.addAttribute("roll", roll);
        vModel.addAttribute("number", number);

        return "dice-results";
    }


}