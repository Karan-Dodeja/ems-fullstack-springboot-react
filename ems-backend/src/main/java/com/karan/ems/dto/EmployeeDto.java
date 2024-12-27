package com.karan.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
