package com.xworkz.airlines.controller;


import com.xworkz.airlines.dto.AirlinesBookingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@RequestMapping("/")
@Controller
public class AirLinesController {
@PostMapping("/studentDetails")
    public String bookingDetails(AirlinesBookingDTO bookingDTO) {

        System.out.println("Booking ID==" + bookingDTO.getStudentId());
        System.out.println("Passenger Name==" + bookingDTO.getStudentName());
        System.out.println("Airline Name==" + bookingDTO.getCllgName());
        System.out.println("Mobile number==" + bookingDTO.getStudentPhoneNumber());
        System.out.println("Email==" + bookingDTO.getStudentEmail());

        return "response";
    }
}

