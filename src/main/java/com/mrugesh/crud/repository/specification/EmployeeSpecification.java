package com.mrugesh.crud.repository.specification;

import com.mrugesh.crud.entity.Employee;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    public static Specification<Employee> filterEmployee(String email){
        return ((root, query, criteriaBuilder) -> {

            Predicate emailPredicate = criteriaBuilder.like(root.get("email"), StringUtils.isBlank(email) ? likePattern(""): email);

            return criteriaBuilder.and(emailPredicate);
        });

    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}
