package com.xworkz.airlines.service;


import com.xworkz.airlines.dto.AirlinesBookingDTO;

public class AirlinesBookingService {

    public boolean studentValidationSave(AirlinesBookingDTO bookingDTO) {

        if (bookingDTO.getStudentId().length() == 5
                && bookingDTO.getStudentName() != null && bookingDTO.getStudentName().length() > 3
                && bookingDTO.getCllgName() != null && bookingDTO.getCllgName().length() > 5
                && bookingDTO.getStudentPhoneNumber().length() == 10
                && bookingDTO.getStudentEmail().contains("@gmail.com")) {

            return true;
        } else {
            return false;
        }
    }
}

