package org.example.controllers;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create_user")
    public String createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        userService.createUser(name, email, password);
        return "home/index";
    }

    @GetMapping("/validate_user")
    public String validateUser(@RequestParam String email, @RequestParam String password) {
        try {
            userService.validateUser(email, password);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
            return "home/user_overview";
        }
    }


