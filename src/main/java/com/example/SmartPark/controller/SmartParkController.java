package com.example.SmartPark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartParkController {

    @GetMapping("/test")
    public String test() {
        return "Spring Boot is working!";
    }
}
