package com.gfg.jbdll.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GreetService {


    public GreetService(){
        System.out.println("I am from greet Service");
    }
    public String greetUser(String name){
        return "Hi! "+name;
    }
    public String greetUser(){
        return "Hi!!";

    }
}
