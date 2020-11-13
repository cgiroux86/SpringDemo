package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;



public class User {
    private final int id;
    private final String name;

    public User(@JsonProperty int id, @JsonProperty String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {return this.id;}
    public String getName() {return this.name;}
    public String sayHello() {return "Hello" + getName();}
}
