package com.meera.journalApp.controller;

import com.meera.journalApp.entity.User;
import com.meera.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck () {
        return "Hello World!";
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        userService.saveUserEntry(user);
        return user;
    }
}
