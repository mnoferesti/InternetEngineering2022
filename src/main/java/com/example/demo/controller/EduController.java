package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@RestController
public class EduController {

    @GetMapping("/register")
    public String registerStudent(@RequestParam(value = "name") String stdName
            , @RequestParam(value = "family") String stdFamily
            , @RequestParam(value = "ssd") String stdNumber){
        try (Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/edudb", "root", "");
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("INSERT INTO STUDENT (name,family,stuid) values ('"+stdName+"','"+stdFamily+"','"+stdNumber+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("We are going to reg "+stdName+stdFamily+stdNumber);
        return "OK";
    }
}
