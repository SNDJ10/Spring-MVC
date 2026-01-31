package com.xworkz.signin.service;

import com.xworkz.signin.repository.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInValidation {

    @Autowired
    Database database;

    public boolean validate(String username, String password) {

        String dbPassword = database.getPasswordByUsername(username);

        if (dbPassword == null) {
            return false; // username not found
        }

        return dbPassword.equals(password);
    }
}