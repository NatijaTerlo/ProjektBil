package org.example.controllers;
import org.example.models.Contract;
import org.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController{
    @Autowired
    private ContractService contractService;

    @GetMapping("/")
    public String login(Model model) {
        return "home/index";
    }

     @GetMapping("/user_overview")
     public String service(Model model){
     return "home/user_overview";

    }
}
