package com.mrugesh.crud.controller;

import com.mrugesh.crud.dto.EmployeeDto;
import com.mrugesh.crud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller provides CRUD operations for managing employees.
 */
@Tag(name= "Employee", description = "Employee Management APIs")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Operation(
            summary = "Create Employee",
            description = "Create a new employee record with the provided first name, last name, and email ID.",
            tags = { "employee", "post" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee created successfully", content = {@Content(schema = @Schema(implementation = EmployeeDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Server error", content = {@Content(schema = @Schema())})
    })

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Employee by ID",
            description = "Retrieve an employee's first name, last name, and email ID by their unique identifier (ID).",
            tags = { "employee", "getById"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee information retrieved Successfully", content = {@Content(schema = @Schema(implementation = EmployeeDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Server Error", content = {@Content(schema = @Schema())})
    })
    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }


    @Operation(
            summary = "Get All Employees",
            description = "Retrieve the first name, last name, and email ID of all employees.",
            tags = { "employee", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee information retrieved successfully", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = EmployeeDto.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "No employees found", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Server error", content = {@Content(schema = @Schema())})
    })
    //Build Get All Employee REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<EmployeeDto>>getAllEmployeesWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<EmployeeDto> employees = employeeService.getAllEmployeesWithPagination(offset, pageSize);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/sort/{field}")
    public ResponseEntity<List<EmployeeDto>>getAllEmployeesWithSorting(@PathVariable String field){
        List<EmployeeDto> employees = employeeService.getAllEmployeesWithSorting(field);
        return ResponseEntity.ok(employees);
    }


    @Operation(
            summary = "Update Employee by ID",
            description = "Updates an employee's information, including first name, last name, and email ID, by their unique identifier (ID).",
            tags = { "employee", "update"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee information updated successfully", content = {@Content(schema = @Schema(implementation = EmployeeDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Server error", content = {@Content(schema = @Schema())})
    })
    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeid,
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeid, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }


    @Operation(
            summary = "Delete Employee by ID",
            description = "Deletes an employee's information, including first name, last name, and email ID, by their unique identifier (ID).",
            tags = { "employee", "delete"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee deleted successfully", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = " Server error", content = {@Content(schema = @Schema())})
    })
    //Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");

    }



}
