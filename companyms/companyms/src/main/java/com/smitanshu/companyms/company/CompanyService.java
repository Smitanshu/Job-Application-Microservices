package com.smitanshu.companyms.company;


import java.util.List;

public interface CompanyService{

   List<Company>getAllCompanies();

   boolean updateCompany(Company company, Long id);

   void createCompany(Company company);

   Company getCompanyById(Long id);

   Boolean deleteCompanyById(Long id);
}
