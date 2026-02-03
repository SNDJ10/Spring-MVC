package com.xworkz.automobilecontroller.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AutomobileController {

    @PostMapping("/submitted")
    public String submit() { return "success"; }

    @PostMapping("/detailstwo")
    public String details() { return "details"; }

    @PostMapping("/analysisthree")
    public String analysis() { return "analysis"; }

    @PostMapping("/newsfour")
    public String news() { return "news"; }

    @PostMapping("/summaryfive")
    public String summary() { return "summary"; }
}

