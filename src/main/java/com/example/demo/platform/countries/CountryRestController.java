package com.example.demo.platform.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    CountryRepository repo;

    @GetMapping("/api/countries")
    public List<Country> getAll() {
        return repo.findAll();
    }

    @GetMapping("/api/countries/{id}")
    public Country get(String id) {
        return repo.findById(id).get();
    }

    @PutMapping("/api/countries/{id}")
    public Country save(@RequestBody Country broker) {
        return repo.save(broker);
    }

    @DeleteMapping("/api/countries/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

}
