package com.example.demo.controller;

import com.example.demo.model.Lecturer;
import com.example.demo.model.Student;
import com.example.demo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@RestController
public class EduController {

    DBService dbs;

    @Autowired
    public EduController(DBService dbst) {
        this.dbs = dbst;
    }

    @GetMapping("/register")
    public String registerStudent(@RequestParam(value = "name") String stdName
            , @RequestParam(value = "family") String stdFamily
            , @RequestParam(value = "ssd") String stdNumber){

        Student tmp = new Student(stdName,stdFamily,stdNumber);
        dbs.insert(tmp.getInsertQuery());
        System.out.println("We are going to reg "+stdName+stdFamily+stdNumber);
        return "OK";
    }

    @GetMapping("/registerlecturer")
    public String registerLecturer(@RequestParam(value = "name") String stdName
            , @RequestParam(value = "family") String stdFamily){

        Lecturer tmp = new Lecturer(stdName,stdFamily);
        dbs.insert(tmp.getInsertQuery());
        System.out.println("We are going to reg "+stdName+stdFamily);
        return "OK";
    }
}
