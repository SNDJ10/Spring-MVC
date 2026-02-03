package com.xworkz.bankingcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BankingController {

    @PostMapping("/submit")
    public String submit() { return "index"; }

    @PostMapping("/details")
    public String details() { return "details"; }

    @PostMapping("/analysis")
    public String analysis() { return "analysis"; }

    @PostMapping("/news")
    public String news() { return "news"; }
}
