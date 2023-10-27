package com.bfp.employeesmanagementsystem.controller;

import com.bfp.employeesmanagementsystem.dto.EmployeeDto;
import com.bfp.employeesmanagementsystem.response.HttpResponse;
import com.bfp.employeesmanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public HttpResponse getEmployees(){
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(200)
                .status(HttpStatus.OK)
                .data(Map.of("employees", employeeService.getEmployees()))
                .build();
    }

    @GetMapping("{id}")
    public HttpResponse getEmployeeById(@PathVariable("id") Long id){
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(200)
                .status(HttpStatus.OK)
                .data(Map.of("employee", employeeService.getEmployeeById(id)))
                .build();
    }

    @PostMapping
    public HttpResponse createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(200)
                .status(HttpStatus.CREATED)
                .message("User created!")
                .data(Map.of("employee", employeeService.createEmployee(employeeDto)))
                .build();
    }

    @PutMapping("{id}")
    public HttpResponse updateEmployee(@PathVariable("id") Long id, @RequestBody @Valid EmployeeDto employeeDto){
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(200)
                .status(HttpStatus.OK)
                .message("User updated!")
                .data(Map.of("employee", employeeService.updateEmployee(id,employeeDto)))
                .build();
    }

    @DeleteMapping("{id}")
    public HttpResponse deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return HttpResponse.builder()
                .timestamp(now().toString())
                .statusCode(204)
                .status(HttpStatus.NO_CONTENT)
                .message("User deleted successfully!")
                .build();
    }

}
