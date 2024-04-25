package org.tungnn.hrm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tungnn.hrm.domain.entity.EmployeePosition;

public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
}
