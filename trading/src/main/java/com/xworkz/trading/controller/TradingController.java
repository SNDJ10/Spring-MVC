package com.xworkz.trading.controller;

import com.xworkz.trading.dto.TradingDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class TradingController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping ("/electionDetails")
    public String electionDetails(TradingDto dto) {

        System.out.println("Party: " + dto.getPartiName());
        System.out.println("Age: " + dto.getAge());
        System.out.println("Email: " + dto.getEmail());
        System.out.println("Phone: " + dto.getPhoneNumber());

        return "success";
    }

    @GetMapping("/preview")
    public String preview() {
        return "preview";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/election")
    public String election() {
        return "election";
    }
}
