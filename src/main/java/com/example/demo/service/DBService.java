package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@Lazy
public class DBService {

    String user;
    String pass;
    String ip;
    String port;
    String name;
    @Autowired
    public DBService(@Value("${database-user:}") String user
                    ,@Value("${database-pass:}") String pass
                    ,@Value("${database-ip:}") String ip
                     ,@Value("${database-port:}") String port
                     ,@Value("${database-name:}") String name) {
        this.user=user;
        this.pass=pass;
        this.ip=ip;
        this.port=port;
        this.name=name;
    }

    public void insert(String query) {
        try (Connection conn = DriverManager.getConnection
                ("jdbc:mysql://"+ip+":"+port+"/"+name, user, pass);
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectStdent() {
        try (Connection conn = DriverManager.getConnection
                ("jdbc:mysql://"+ip+":"+port+"/"+name, user, pass);
             Statement stmt = conn.createStatement();
        ) {
            ResultSet rst = stmt.executeQuery("SELECT * from student");
            String list = "";
            while(rst.next()){
                String name = rst.getString(1);
                String family = rst.getString(2);
                String ssd = rst.getString(3);
                list = list+"("+name+","+family+","+ssd+")";
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
