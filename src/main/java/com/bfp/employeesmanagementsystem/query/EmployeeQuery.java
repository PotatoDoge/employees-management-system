package com.bfp.employeesmanagementsystem.query;

public class EmployeeQuery {

    public static final String GET_EMPLOYEE_BY_ID = "SELECT id, first_name, last_name, role FROM employees WHERE id=:id";
    public static final String GET_EMPLOYEES = "SELECT id, first_name, last_name, role from employees";
    public static final String CREATE_EMPLOYEE = "INSERT INTO employees (first_name, last_name, role) values (:firstName, :lastName, :role)";

}
