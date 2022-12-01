package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    String name;
    String family;
    String ssd;

    public Student(String name, String family, String ssd) {
        this.name = name;
        this.family = family;
        this.ssd = ssd;
    }

    public String getInsertQuery() {
        return "INSERT INTO STUDENT (name,family,stuid) " +
                "values ('"+name+"','"+family+"','"+ssd+"')";
    }
}
