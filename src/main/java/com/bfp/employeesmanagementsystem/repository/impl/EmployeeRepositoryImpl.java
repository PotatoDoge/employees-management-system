package com.bfp.employeesmanagementsystem.repository.impl;

import com.bfp.employeesmanagementsystem.entity.Employee;
import com.bfp.employeesmanagementsystem.repository.EmployeeRepository;
import com.bfp.employeesmanagementsystem.response.exception.EmployeeNotFoundException;
import com.bfp.employeesmanagementsystem.response.exception.InternalServerException;
import com.bfp.employeesmanagementsystem.rowmapper.EmployeeRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bfp.employeesmanagementsystem.query.EmployeeQuery.*;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final NamedParameterJdbcTemplate jdbc;
    @Override
    public Employee createEmployee(Employee employee) {
        try{
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParametersSource(employee);
            jdbc.update(CREATE_EMPLOYEE, parameters, holder);
            employee.setId(requireNonNull(holder.getKey()).longValue());
            return employee;
        }
        catch (Exception e){
            log.error("Error while inserting the user into the database: " + e);
            throw new InternalServerException("Error while inserting the user into the database");
        }
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        try{
            SqlParameterSource parameters = new MapSqlParameterSource().addValue("id",employeeId);
            return jdbc.queryForObject(GET_EMPLOYEE_BY_ID, parameters, new EmployeeRowMapper());
        }
        catch (Exception e){
            log.error("Error while fetching user: " + e);
            throw new EmployeeNotFoundException("No employee was found with the given id");
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try{
            return jdbc.query(GET_EMPLOYEES, new EmployeeRowMapper());
        }
        catch (Exception e){
            log.error("Error while fetching user: " + e);
            throw new InternalServerException("Error while fetching users from database");
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try{
            SqlParameterSource parameters = getSqlParametersSourceWithId(employee);
            int updatedEmployee = jdbc.update(UPDATE_EMPLOYEE, parameters);
            if(updatedEmployee == 0){
                log.error("User not found. (UPDATE User)");
                throw new EmployeeNotFoundException(null);
            }
            return employee;
        }
        catch (EmployeeNotFoundException ex){
            throw new EmployeeNotFoundException("No employee found with the given id");
        }
        catch (Exception e){
            log.error("Error while fetching user: " + e);
            throw new InternalServerException("Error while updating user in database");
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        try{
            SqlParameterSource parameters = new MapSqlParameterSource().addValue("id",employeeId);
            int id = jdbc.update(DELETE_EMPLOYEE, parameters);
            if(id == 0){
                log.error("No employee found with ID = {}", employeeId);
                throw new EmployeeNotFoundException(null);
            }
        }
        catch (EmployeeNotFoundException ex){
            throw new EmployeeNotFoundException("No employee found with the given id");
        }
        catch (Exception e){
            log.error("Error while deleting user: " + e);
            throw new InternalServerException("Error while deleting user in database");
        }
    }

    private SqlParameterSource getSqlParametersSource(Employee employee) {
        return new MapSqlParameterSource()
                .addValue("firstName", employee.getFirstName())
                .addValue("lastName", employee.getLastName())
                .addValue("role", employee.getRole());
    }

    private SqlParameterSource getSqlParametersSourceWithId(Employee employee) {
        return new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("firstName", employee.getFirstName())
                .addValue("lastName", employee.getLastName())
                .addValue("role", employee.getRole());
    }

}
