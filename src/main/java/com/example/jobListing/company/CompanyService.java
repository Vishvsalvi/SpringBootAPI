package com.example.jobListing.company;

import java.util.List;

public interface CompanyService {
     List<Company> getAllCompany();
     boolean UpdateCompany(Long id, Company company);
     boolean createCompany(Company company);
     boolean deleteCompanyById(Long id);
     Company getCompanyById(Long id);
}
