package com.karan.ems.controller;

import com.karan.ems.dto.EmployeeDto;
import com.karan.ems.entity.Employee;
import com.karan.ems.repository.EmployeeRepository;
import com.karan.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmp = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId){
        EmployeeDto employeeDto= employeeService.getEmployeeByID(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeDto employeeDetails){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, employeeDetails);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!.");
    }
}