package com.bfp.employeesmanagementsystem.repository;

import com.bfp.employeesmanagementsystem.dto.EmployeeDto;
import com.bfp.employeesmanagementsystem.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);

    Collection<Employee> getEmployees();

    Employee updateEmployee(Employee employee);

}
