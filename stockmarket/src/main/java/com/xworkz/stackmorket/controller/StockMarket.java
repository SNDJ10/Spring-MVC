package com.xworkz.stackmorket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StockMarket {

    public StockMarket() {
        System.out.println("this is controller");
    }

    @PostMapping("/submitone")
    public String submitStock() {
        System.out.println("submit stock called");
        return "success";
    }

    @PostMapping("/detailstwo")
    public String stockDetails() {
        return "details";
    }

    @PostMapping("/analysisthree")
    public String stockAnalysis() {
        return "analysis";
    }

    @PostMapping("/newsfour")
    public String stockNews() {
        return "news";
    }

    @PostMapping("/summaryfive")
    public String stockSummary() {
        return "summary";
    }
}

