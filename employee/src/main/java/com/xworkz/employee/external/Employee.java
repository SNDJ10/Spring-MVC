package com.xworkz.employee.external;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee {

    public static void main(String[] args) {

        String excelPath = "C:\\Users\\sanja\\OneDrive\\Documents\\Employee_db.xlsx";
        String jdbcUrl = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = "root";

        String sql = "INSERT INTO employee_tb (id, name, email, salary, department) VALUES (?, ?, ?, ?, ?)";

        try (
                FileInputStream fis = new FileInputStream(excelPath);
                Workbook workbook = new XSSFWorkbook(fis);
                Connection con = DriverManager.getConnection(jdbcUrl, username, password);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue;

                int id = (int) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String email = row.getCell(2).getStringCellValue();
                double salary = row.getCell(3).getNumericCellValue();
                String department = row.getCell(4).getStringCellValue();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setDouble(4, salary);
                ps.setString(5, department);

                ps.executeUpdate(department);
            }

            System.out.println("All employee records inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}