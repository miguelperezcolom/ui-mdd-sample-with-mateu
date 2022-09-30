package com.example.demo.platform.brokers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrokerRestController {

    @Autowired
    BrokerRepository repo;

    @GetMapping("/api/brokers")
    public List<Broker> getAll() {
        return repo.findAll();
    }

    @GetMapping("/api/brokers/{id}")
    public Broker get(String id) {
        return repo.findById(id).get();
    }

    @PutMapping("/api/brokers/{id}")
    public Broker save(@RequestBody Broker broker) {
        return repo.save(broker);
    }

    @DeleteMapping("/api/brokers/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

}
