package com.xworkz.games.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GamesController {
    public GamesController(){
        System.out.println("this is GamesController");
    }
    @GetMapping("/games")
    public String gameController(){
        System.out.println("this is game controller");
        return "games.jsp";
    }
}
