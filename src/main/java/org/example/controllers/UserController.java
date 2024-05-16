package org.example.controllers;
import org.example.models.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create_user")
    public String createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        userService.createUser(name, email, password);
        return "home/index";
    }
    @GetMapping("/validate_user")
    public String validateUser(@RequestParam String email, @RequestParam String password){
        User user = userService.validateUser(email, password);
        if (user == null)
            return "home/index";
        else
            return "home/user_overview";
    }

}
