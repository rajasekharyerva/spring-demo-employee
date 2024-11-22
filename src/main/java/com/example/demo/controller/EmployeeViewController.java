package com.example.demo.controller;

import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeViewController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-list")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list"; // Renders src/main/resources/templates/employee-list.html
    }
}

