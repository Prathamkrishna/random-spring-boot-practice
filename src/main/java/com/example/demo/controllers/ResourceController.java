package com.example.demo.controllers;

import com.example.demo.data.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    private final resource r1;

    @Autowired
    public ResourceController(resource r1) {
        this.r1 = r1;
    }

    @GetMapping("/")
    public String HelloWorldController() {
        try {
            r1.updateDatabase();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "hello world";
    }
}
