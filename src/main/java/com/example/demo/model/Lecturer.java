package com.example.demo.model;

public class Lecturer {
    private String name;
    private String family;

    public Lecturer(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getInsertQuery(){
        return "INSERT into lecturer(name,family) VALUES ('"+name+"','"+family+"')";
    }


}
