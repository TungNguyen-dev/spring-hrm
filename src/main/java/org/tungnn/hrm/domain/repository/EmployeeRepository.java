package org.tungnn.hrm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tungnn.hrm.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
