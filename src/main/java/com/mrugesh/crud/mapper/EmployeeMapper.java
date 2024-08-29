package com.mrugesh.crud.mapper;

import com.mrugesh.crud.dto.EmployeeDto;
import com.mrugesh.crud.entity.Employee;

/**
 * Utility class for mapping between {@link Employee} entities and {@link EmployeeDto} Objects.
 *
 * <p>This class provides static method to convert an {@link Employee} entity to a
 * {@link EmployeeDto} and vice versa. It helps in separating the entity model from the data transfer object (DTO) used in the service and controller layers.</p>
 */
public class EmployeeMapper {

    /**
     * Maps an {@link Employee} entity to an {@link EmployeeDto}.
     *
     * <p>This method extracts relevant fields from the given {@code Employee} and creates a corresponding {@code EmployeeDto} object.</p>
     *
     * @param employee the employee entity to be mapped
     * @return the mapped {@code EmployeeDto} containing the employee's data
     */
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
                );
    }

    /**
     * Maps an {@link EmployeeDto} to an {@link Employee} entity.
     *
     * <p>This method creates an {@code Employee} entity from the given {@code EmployeeDto},
     * allowing the DTO data to be persisted in the database.</p>
     *
     * @param employeeDto the data transfer object containing employee information
     * @return the mapped {@code Employee} entity ready to be persisted
     */
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
                );
    }
}
