package com.mrugesh.crud.service;

import com.mrugesh.crud.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    /**
     * create employee service
     * @param employeeDto
     * @return
     */
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    /**
     * get employee by id service
     * @param employeeId
     * @return
     */
    EmployeeDto getEmployeeById(Long employeeId);

    /**
     * get all employee service
     * @return
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * update employee by id service
     * @param employeeId
     * @param updatedEmployee
     * @return
     */
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    /**
     * delete employee by id service
     * @param employeeId
     */
    void deleteEmployee(Long employeeId);

}

