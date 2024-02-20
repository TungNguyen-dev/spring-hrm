package com.example.hrm.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        String msg = "Hello, World!";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
