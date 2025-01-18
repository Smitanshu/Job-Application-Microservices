package com.smitanshu.companyms.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;

    }

    @GetMapping()
    public ResponseEntity<List<Company>> getAllCompanies() {
        // return ResponseEntity.ok(companyService.getAllCompanies());
         //Same as above
        //B
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestBody Company company) {

        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added Successfully", HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {

        Boolean deleted = companyService.deleteCompanyById(id);

        if (deleted) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        //return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Company not found with id: " + id, HttpStatus.NOT_FOUND);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
        boolean updated = companyService.updateCompany(updatedCompany, id);
        if (updated) {
            return new ResponseEntity<>("Updated Successfully!!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
