package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
@Lazy
public class DBService {

    @Autowired
    public DBService() {
    }

    public void insert(String query) {
        try (Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/edudb", "class", "123");
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
