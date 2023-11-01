package com.bfp.employeesmanagementsystem.service.impl;

import com.bfp.employeesmanagementsystem.dto.EmployeeDto;
import com.bfp.employeesmanagementsystem.entity.Employee;
import com.bfp.employeesmanagementsystem.repository.impl.EmployeeRepositoryImpl;
import com.bfp.employeesmanagementsystem.response.exception.EmployeeNotFoundException;
import com.bfp.employeesmanagementsystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepositoryImpl employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .id(null)
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .role(employeeDto.getRole())
                .build();
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .id(id)
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .role(employeeDto.getRole())
                .build();
        return employeeRepository.updateEmployee(employee);
    }
}
