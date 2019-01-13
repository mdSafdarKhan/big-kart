package com.example.basicsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/hi")
    public String hi(){
        System.out.println("hi controller");
        return "Hi";
    }

    @GetMapping
    public Principal principal(Principal principal){
        return principal;
    }
}
