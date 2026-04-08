package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String getEmployee(Model model) {

        model.addAttribute("id", 101);
        model.addAttribute("name", "Alice");
        model.addAttribute("salary", 50000);

        return "employee";
    }
}
