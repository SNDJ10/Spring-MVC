package com.xworkz.signin.controller;


import com.xworkz.signin.dto.SignUpDto;
import com.xworkz.signin.repository.Database;
import com.xworkz.signin.service.SignInValidation;
import com.xworkz.signin.service.SignUpValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FormController {

    @Autowired
    Database database;

    @Autowired
    SignUpValidation signUpValidation;

    @Autowired
    SignInValidation signInValidation;

    public FormController(){
        System.out.println("FormController....");
    }

    @PostMapping("/signup")
    public String signup(SignUpDto dto) {

        boolean valid = signUpValidation.formValidation(dto);

        if (!valid) {
            return "signup";
        }

        boolean saved = database.save(dto);

        if (saved) {
            return "signUpResponse";
        } else {
            return "signup";
        }
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String username,
                         @RequestParam String password) {

        boolean valid = signInValidation.validate(username, password);

        if (valid) {
            return "signInResponse";
        } else {
            return "signin";
        }
    }


}
