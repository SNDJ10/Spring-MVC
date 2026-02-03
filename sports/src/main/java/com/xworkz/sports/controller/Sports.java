package com.xworkz.sports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class Sports {

    public Sports() {
        System.out.println("this is GamesController");
    }

    @GetMapping("/games")
    public String games() {
        return "games";
    }

    @GetMapping("/cricket")
    public String cricket() {
        return "cricket";
    }

    @GetMapping("/football")
    public String football() {
        return "football";
    }

    @GetMapping("/kabaddi")
    public String kabaddi() {
        return "kabaddi";
    }

    @GetMapping("/chess")
    public String chess() {
        return "chess";
    }
}
