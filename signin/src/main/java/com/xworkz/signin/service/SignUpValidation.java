package com.xworkz.signin.service;

import com.xworkz.signin.dto.SignUpDto;
import org.springframework.stereotype.Service;

@Service
public class SignUpValidation {

    public boolean formValidation(SignUpDto dto) {

        String name = dto.getName();
        String surname = dto.getSurname();
        long phoneNumber = dto.getPhoneNumber();
        String email = dto.getEmail();
        String username = dto.getUsername();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();

        if (name.length() >= 3
                && surname.length() >= 3
                && phoneNumber > 0
                && email.contains("@")
                && username.length() >= 4
                && password.equals(confirmPassword)) {

            System.out.println("The entered data is valid");
            return true;

        } else {
            System.out.println("The entered data is invalid");
            return false;
        }

    }

}
