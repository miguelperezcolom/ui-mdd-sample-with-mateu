package com.example.demo.platform.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleRestController {

    @Autowired
    VehicleRepository repo;

    @GetMapping("/api/vehicles")
    public List<Vehicle> getAll() {
        return repo.findAll();
    }

    @GetMapping("/api/vehicles/{id}")
    public Vehicle get(String id) {
        return repo.findById(id).get();
    }

    @PutMapping("/api/vehicles/{id}")
    public Vehicle save(@RequestBody Vehicle broker) {
        return repo.save(broker);
    }

    @DeleteMapping("/api/vehicles/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

}
