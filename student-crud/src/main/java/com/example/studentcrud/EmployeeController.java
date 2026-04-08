package com.example.studentcrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("salary") double salary) {

        return "display";
    }
}