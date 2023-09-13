package com.bfp.employeesmanagementsystem.service;

import com.bfp.employeesmanagementsystem.dto.EmployeeDto;
import com.bfp.employeesmanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(Long id);

    List<Employee> getEmployees();

    Employee createEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    Employee updateEmployee(Long id);

}
