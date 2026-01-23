package com.xworkz.election.controller;

import com.xworkz.election.dto.ElectionDto;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ElectionController {

    @PostMapping ("/electionDetails")
    public String electionDetails(ElectionDto electionDto){

        System.out.println("this is electionDetails "+electionDto.getPartiName()+ " " +
                "=="+electionDto.getAge()+"eemail=="+electionDto.getEmail() +" ph=="+electionDto.getPhoneNumber());
        return "election";

    }

}
