package com.jobApp.JobApp.company;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long Id);

    Company getCompanyById(Long Id);
}
