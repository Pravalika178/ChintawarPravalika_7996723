package com.example.auth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public Object user(Principal principal) {

        if (principal == null) {
            return "No user logged in";
        }

        return principal;
    }
}