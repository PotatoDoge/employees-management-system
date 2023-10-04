package com.bfp.employeesmanagementsystem.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    @NotBlank(message = "First name field must not be empty")
    private String firstName;
    @NotBlank(message = "Last name field must not be empty")
    private String lastName;
    @NotBlank(message = "Role field must not be empty")
    private String role;

}
