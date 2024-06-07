package com.example.jobListing.company.impl;

import com.example.jobListing.company.Company;
import com.example.jobListing.company.CompanyRepository;
import com.example.jobListing.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean UpdateCompany(Long id, Company company) {
        Optional <Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company comp = companyOptional.get();
            comp.setName(company.getName());
            comp.setDescription(company.getDescription());
            companyRepository.save(comp);
            return true;
        }
        return false;
    }

    @Override
    public boolean createCompany(Company company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
