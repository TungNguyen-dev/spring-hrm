package org.tungnn.hrm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tungnn.hrm.domain.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
