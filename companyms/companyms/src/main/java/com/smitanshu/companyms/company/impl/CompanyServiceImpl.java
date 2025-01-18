package com.smitanshu.companyms.company.impl;


import com.smitanshu.companyms.company.Company;
import com.smitanshu.companyms.company.CompanyRepository;
import com.smitanshu.companyms.company.CompanyService;
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
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {

        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());

            companyRepository.save(company);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Company company) {

        companyRepository.save(company);

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);

        if (company.isPresent()) {
            companyRepository.deleteById(id);
            return true;
        }

        return false;
    }


}


