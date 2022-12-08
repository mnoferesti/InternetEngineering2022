package com.example.demo;

import com.example.demo.model.Lecturer;
import com.example.demo.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo6ApplicationTests {

    @Test
    void contextLoads() {
        Lecturer test = new Lecturer("ali","alavi");
        String insertquery = test.getInsertQuery();
        Assertions.assertEquals(insertquery,
                "INSERT into lecturer(name,family) VALUES ('ali','alavi')");
    }
    @Test
    void testInsertQueryStudent() {
        Student test = new Student("ali","alavi","123");
        String insertquery = test.getInsertQuery();
        Assertions.assertEquals(insertquery.toLowerCase(),
                "INSERT INTO STUDENT (name,family,stuid) VALUES ('ali','alavi','123')".toLowerCase());
    }
}
