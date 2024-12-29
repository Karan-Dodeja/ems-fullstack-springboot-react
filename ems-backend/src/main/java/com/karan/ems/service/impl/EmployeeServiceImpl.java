package com.karan.ems.service.impl;

import com.karan.ems.dto.EmployeeDto;
import com.karan.ems.entity.Employee;
import com.karan.ems.exception.ResourceNotFoundException;
import com.karan.ems.mapper.EmployeeMapper;
import com.karan.ems.repository.EmployeeRepository;
import com.karan.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList=employeeRepository.findAll();
        return employeeList.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given ID")
        );
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        Employee updatedEmployee =employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given ID")
        );
        employeeRepository.deleteById(employeeId);
    }


}