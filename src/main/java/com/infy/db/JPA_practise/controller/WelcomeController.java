package com.infy.db.JPA_practise.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("api/welcome")
public class WelcomeController {
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/home")
    public String home() {
        logger.info("Home page accessed");
        return "Welcome to the JPA Practise Management System!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        logger.info("Welcome page accessed");
        return "<h1> FLAIR PEN TESTING </h1>";
    }
}
