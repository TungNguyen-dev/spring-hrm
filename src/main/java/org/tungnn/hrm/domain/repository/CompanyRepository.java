package org.tungnn.hrm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tungnn.hrm.domain.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
