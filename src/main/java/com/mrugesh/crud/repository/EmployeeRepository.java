package com.mrugesh.crud.repository;

import com.mrugesh.crud.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Repository interface for {@link Employee} entities.
 * Provides CRUD operation for managing employees in the database.
 *
 * <p>This interface extends {@link JpaRepository},
 * allowing the use of JPA methods for persistence operations
 * such as saving, deleting, and finding and updating entities.</p>
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    List<Employee> findAll(Specification<Employee>specification);

}
