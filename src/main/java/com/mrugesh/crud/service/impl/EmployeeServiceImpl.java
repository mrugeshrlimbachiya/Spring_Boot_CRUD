package com.mrugesh.crud.service.impl;

import com.mrugesh.crud.dto.EmployeeDto;
import com.mrugesh.crud.entity.Employee;
import com.mrugesh.crud.exception.ResourceNotFoundException;
import com.mrugesh.crud.mapper.EmployeeMapper;
import com.mrugesh.crud.repository.EmployeeRepository;
import com.mrugesh.crud.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with given id: "+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

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

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee not exists with given id: "+ employeeId)
        );

        employeeRepository.deleteById(employeeId);

    }
}
