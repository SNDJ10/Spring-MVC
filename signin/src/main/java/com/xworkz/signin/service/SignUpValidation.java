package com.xworkz.signin.service;

import com.xworkz.signin.dto.SignUpDto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

            // 🔐 Encrypt Password Here
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encryptedPassword = encoder.encode(password);

            dto.setPassword(encryptedPassword); // set encrypted password
            dto.setConfirmPassword(null); // optional: remove confirm password

            System.out.println("Data valid and password encrypted");
            return true;

        } else {
            System.out.println("Invalid data");
            return false;
        }
    }
}
