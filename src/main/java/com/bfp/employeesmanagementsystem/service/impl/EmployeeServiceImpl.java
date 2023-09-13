package com.bfp.employeesmanagementsystem.service.impl;

import com.bfp.employeesmanagementsystem.dto.EmployeeDto;
import com.bfp.employeesmanagementsystem.entity.Employee;
import com.bfp.employeesmanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = Employee.builder().id(1L).firstName("Get").lastName("single Prado").build();
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        Employee employee = Employee.builder().id(1L).firstName("Get").lastName("Prados").build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        return employees;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.builder().id(1L).firstName("Create").lastName("Prado").build();
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        System.out.println("Employee deleted!");
    }

    @Override
    public Employee updateEmployee(Long id) {
        Employee employee = Employee.builder().id(1L).firstName("Update").lastName("Prado").build();
        return employee;
    }
}
