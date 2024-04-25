package org.tungnn.hrm.domain.service.impl;

import org.springframework.stereotype.Service;
import org.tungnn.hrm.api.dto.CompanyDTO;
import org.tungnn.hrm.api.dto.CompanyRequestDTO;
import org.tungnn.hrm.domain.entity.Company;
import org.tungnn.hrm.domain.exception.EntityNotFoundException;
import org.tungnn.hrm.domain.repository.CompanyRepository;
import org.tungnn.hrm.domain.service.CompanyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<CompanyDTO> companyDTOList = new ArrayList<>();

        List<Company> companies = companyRepository.findAll();
        companies.forEach(company -> companyDTOList.add(convertToDTO(company)));

        return companyDTOList;
    }

    @Override
    public CompanyDTO getCompanyById(Integer id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return convertToDTO(company);
    }

    @Override
    public CompanyDTO createCompany(CompanyRequestDTO companyRequestDTO) {
        Company company = new Company(companyRequestDTO.getName());
        company = companyRepository.save(company);

        return convertToDTO(company);
    }

    @Override
    public CompanyDTO updateCompany(Integer id, CompanyRequestDTO companyRequestDTO) {
        Company company = companyRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        company.setName(companyRequestDTO.getName());
        company = companyRepository.save(company);

        return convertToDTO(company);
    }

    @Override
    public Boolean deleteCompany(Integer id) {
        companyRepository.deleteById(id);
        return true;
    }

    private CompanyDTO convertToDTO(Company company) {
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getCreatedAt(),
                company.getUpdatedAt()
        );
    }
}
