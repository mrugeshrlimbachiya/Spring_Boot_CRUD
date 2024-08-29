package com.mrugesh.crud.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents an employee entity in the system.
 * Maps to the 'employees' table in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * The unique identifier for an employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the employee.
     */
    @Column(name = "first_name")
    private String firstname;

    /**
     * The last name of the employee.
     */
    @Column(name = "last_name")
    private String lastname;

    /**
     * The email id of the employee.
     */
    @Column(name = "email_id", nullable = false, unique = true)
    private String email;
}
