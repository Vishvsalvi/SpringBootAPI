package com.example.jobListing.company;

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

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean updated = companyService.UpdateCompany(id, company);
        if(updated){
            return new ResponseEntity<>( "Company data updated successfully!", HttpStatus.OK);

        }
        return new ResponseEntity<>("Company not found! Or something went wrong", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        boolean createdCompany = companyService.createCompany(company);
        if(createdCompany){
            return new ResponseEntity<>("Company created successfully!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong while creating company, please try again!", HttpStatus.BAD_GATEWAY);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        if(companyService.deleteCompanyById(id)){
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company doesn't exists!", HttpStatus.NOT_FOUND);
    }
}
