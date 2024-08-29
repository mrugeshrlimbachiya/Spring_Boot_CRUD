package com.mrugesh.crud.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for Employee.
 * Used for transferring data between layers without exposing the entity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    /**
     * The unique identifier of the employee.
     */
    private Long id;
    /**
     * The first name of the employee.
     */
    private String firstName;
    /**
     * The last name of the employee.
     */
    private String lastName;
    /**
     * The email id of the employee.
     */
    private String email;
}
