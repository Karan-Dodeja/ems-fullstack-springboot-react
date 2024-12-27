package com.karan.ems.service.impl;

import com.karan.ems.dto.EmployeeDto;
import com.karan.ems.entity.Employee;
import com.karan.ems.exception.ResourceNotFoundException;
import com.karan.ems.mapper.EmployeeMapper;
import com.karan.ems.repository.EmployeeRepository;
import com.karan.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saved);
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(("Employee not found" + employeeId)));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}