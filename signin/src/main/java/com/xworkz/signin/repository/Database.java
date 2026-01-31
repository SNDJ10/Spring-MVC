package com.xworkz.signin.repository;

import com.xworkz.signin.dto.SignUpDto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class Database {

    public boolean save(SignUpDto dto) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loginpage_db";
            String username = "root";
            String password = "root";
            String query = "insert into signup_tb values (?,?,?,?,?,?)";

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, dto.getName());
            statement.setString(2, dto.getSurname());
            statement.setLong(3, dto.getPhoneNumber());
            statement.setString(4, dto.getEmail());
            statement.setString(5, dto.getUsername());
            statement.setString(6, dto.getPassword());

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getPasswordByUsername(String username) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loginpage_db";
            String user = "root";
            String pass = "root";

            String query = "SELECT password FROM signup_tb WHERE username = ?";

            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "user not found";
    }


}
