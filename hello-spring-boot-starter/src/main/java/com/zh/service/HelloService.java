package com.zh.service;

public class HelloService {

    private String name;
    private String address;

    public HelloService(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String sayHello(){
        return "my name is " + name + ", I live in " + address;
    }

}
