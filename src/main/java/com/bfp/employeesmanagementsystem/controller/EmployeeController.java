package com.bfp.employeesmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController {

    @GetMapping("employees")
    public String getEmployees(){
        return "welcome from employees";
    }

    @GetMapping("employees/{id}")
    public String getEmployeeById(@PathVariable("id") Long id){
        return "welcome from employees: " + id;
    }

    @PostMapping("employees")
    public String createEmployee(){
        return "Create employee";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(){
        return "Update employee";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(){
        return "Delete employee";
    }

}
