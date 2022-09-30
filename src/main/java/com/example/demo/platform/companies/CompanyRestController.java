package com.example.demo.platform.companies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyRestController {

    @Autowired
    CompanyRepository repo;

    @GetMapping("/api/companies")
    public List<Company> getAll() {
        return repo.findAll();
    }

    @GetMapping("/api/companies/{id}")
    public Company get(String id) {
        return repo.findById(id).get();
    }

    @PutMapping("/api/companies/{id}")
    public Company save(@RequestBody Company broker) {
        return repo.save(broker);
    }

    @DeleteMapping("/api/companies/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

}
