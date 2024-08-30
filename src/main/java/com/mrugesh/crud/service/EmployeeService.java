package com.mrugesh.crud.service;

import com.mrugesh.crud.dto.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    /**
     * create employee service
     * @param employeeDto the data transfer object containing employee details
     * @return the created {@link EmployeeDto} with the assigned ID
     */
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    /**
     * get employee by id service
     * @param employeeId the ID of the employee to retrieve
     * @return the {@link EmployeeDto} corresponding to the employee with the given ID
     */
    EmployeeDto getEmployeeById(Long employeeId);

    /**
     * get all employee service
     * @return a list of {@link EmployeeDto} representing all employees in the system
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * update employee by id service
     * @param employeeId Unique id to update employee
     * @param updatedEmployee Employee DTO containing updated information
     * @return Updated Employee DTO
     */
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    /**
     * Delete Employee by id
     * @param employeeId unique id to delete employee
     */
    void deleteEmployee(Long employeeId);

    /**
     * Return employees by page size
     * @param offset page number we want
     * @param pageSize size of pages
     * @return page with content
     */
    Page<EmployeeDto> getAllEmployeesWithPagination(int offset, int pageSize);

    /**
     * Return sorted List of employees
     * @param field method use for sorting
     * @return sorted elements
     */
    List<EmployeeDto> getAllEmployeesWithSorting(String field);

    List<EmployeeDto> getAllEmployeesWithFilter(String email);

}

