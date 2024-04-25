package org.tungnn.hrm.domain.service;

import org.tungnn.hrm.api.dto.CompanyDTO;
import org.tungnn.hrm.api.dto.CompanyRequestDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompanyById(Integer id);

    CompanyDTO createCompany(CompanyRequestDTO companyRequestDTO);

    CompanyDTO updateCompany(Integer id, CompanyRequestDTO companyRequestDTO);

    Boolean deleteCompany(Integer id);
}
