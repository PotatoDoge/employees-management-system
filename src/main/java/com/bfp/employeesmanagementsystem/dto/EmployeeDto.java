package com.bfp.employeesmanagementsystem.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String role;

}
