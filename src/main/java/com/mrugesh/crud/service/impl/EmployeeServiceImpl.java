package com.mrugesh.crud.service.impl;

import com.mrugesh.crud.dto.EmployeeDto;
import com.mrugesh.crud.entity.Employee;
import com.mrugesh.crud.exception.ResourceNotFoundException;
import com.mrugesh.crud.mapper.EmployeeMapper;
import com.mrugesh.crud.repository.EmployeeRepository;
import com.mrugesh.crud.repository.specification.EmployeeSpecification;
import com.mrugesh.crud.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link EmployeeService} interface for managing Employee entities.
 *
 * <p>This class provides the service layer functionality for creating and managing employees
 * by interacting with the {@link EmployeeRepository}.</p>
 *
 * <p>It uses the {@link EmployeeMapper} to convert between {@link EmployeeDto} and
 * {@link Employee} entities.</p>
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    /**
     * Creates a new employee in the repository.
     *
     * <p>This method converts the provided {@link EmployeeDto} to an {@link Employee} entity,
     * persists it to the database, and then converts the saved entity back to a {@link EmployeeDto}.</p>
     *
     * @param employeeDto the data transfer object containing employee details
     * @return the created {@link EmployeeDto} with the assigned ID
     */
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    /**
     * Retrieves an employee by their ID.
     *
     * <p>This method fetches an {@link Employee} entity from the repository by its ID. If the
     * employee is not found, a {@link ResourceNotFoundException} is thrown with a message indicating
     * that no employee exists with the provided ID.</p>
     *
     * @param employeeId the ID of the employee to retrieve
     * @return the {@link EmployeeDto} corresponding to the employee with the given ID
     * @throws ResourceNotFoundException if no employee is found with the specified ID
     */
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with given id: "+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    /**
     * Retrieves a list of all employees.
     *
     * <p>This method fetches all {@link Employee} entities from the repository,
     * maps them to {@link EmployeeDto} objects, and returns them as a list.</p>
     *
     * @return a list of {@link EmployeeDto} representing all employees in the system
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    /**
     * Update an employee by their id
     *
     * <p>This method updates {@link Employee} entity from the repository by its ID.</p>
     * @param employeeId Unique id to update employee
     * @param updatedEmployee Employee DTO containing updated information
     * @return Updated Employee DTO
     */
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee not exists with given id: "+ employeeId)
        );
        employee.setFirstname(updatedEmployee.getFirstName());
        employee.setLastname(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    /**
     * Delete Employee by id
     * @param employeeId unique id to delete employee
     */
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee not exists with given id: "+ employeeId)
        );

        employeeRepository.deleteById(employeeId);

    }

    /**
     * Return employees by page size
     * @param offset page number we want
     * @param pageSize size of pages
     * @return page with content
     */
    @Override
    public Page<EmployeeDto> getAllEmployeesWithPagination(int offset, int pageSize){
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offset, pageSize));
        return employees.map(EmployeeMapper::mapToEmployeeDto);
    }

    /**
     * Return sorted List of employees
     * @param field method use for sorting
     * @return sorted elements
     */
    @Override
    public List<EmployeeDto> getAllEmployeesWithSorting(String field) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    /**
     * @param email
     * @return
     */
    @Override
    public List<EmployeeDto> getAllEmployeesWithFilter(String email) {
        Specification<Employee> specification = EmployeeSpecification.filterEmployee(email);
        List<Employee> employees = this.employeeRepository.findAll(specification);
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }
}
