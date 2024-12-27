package com.karan.ems.service;

import com.karan.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeByID(Long employeeId);
}
