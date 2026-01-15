package com.xworkz.games.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PlayingController {
    public PlayingController(){
        System.out.println("this is controller");
    }
    @GetMapping("/playingStation")
    public String railWayStation(){
        System.out.println(" this is controller method");
        return "play";
    }

}
