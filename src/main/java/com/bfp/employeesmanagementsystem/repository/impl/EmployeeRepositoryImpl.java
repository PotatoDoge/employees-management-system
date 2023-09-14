package com.bfp.employeesmanagementsystem.repository.impl;

import com.bfp.employeesmanagementsystem.dto.EmployeeDto;
import com.bfp.employeesmanagementsystem.entity.Employee;
import com.bfp.employeesmanagementsystem.repository.EmployeeRepository;
import com.bfp.employeesmanagementsystem.rowmapper.EmployeeRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
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
            log.error("Error while creating user: " + e);
            //throw new ApiException("An error occurred. Please try again");
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        try{
            SqlParameterSource parameters = new MapSqlParameterSource().addValue("id",employeeId);
            return jdbc.queryForObject(GET_EMPLOYEE_BY_ID, parameters, new EmployeeRowMapper());
        }
        catch (Exception e){
            log.error("Error while fetching user: " + e);
        }
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        try{
            return jdbc.query(GET_EMPLOYEES, new EmployeeRowMapper());
        }
        catch (Exception e){
            log.error("Error while fetching user: " + e);
        }

        return null;
    }

    private SqlParameterSource getSqlParametersSource(Employee employee) {

        return new MapSqlParameterSource()
                .addValue("firstName", employee.getFirstName())
                .addValue("lastName", employee.getLastName())
                .addValue("role", employee.getRole());
    }

}
