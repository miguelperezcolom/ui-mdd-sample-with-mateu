package com.example.claimsplatform.application;

import com.example.claimsplatform.domain.Claim;
import com.example.claimsplatform.domain.ClaimStatus;
import com.example.claimsplatform.domain.ClaimsRepository;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ClaimsController {

    @Autowired
    private ClaimsRepository repo;

    @GetMapping("/api/claims")
    public Page<Claim> getAll(@ParameterObject Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/api/claims/{id}")
    public Claim get(@PathVariable String id) {
        return repo.findById(id).get();
    }

    @PutMapping("/api/claims/{id}")
    public Claim save(@RequestBody Claim broker) {
        return repo.save(broker);
    }

    @PostMapping("/api/claims/mark-as-done")
    public void save(@RequestBody String[] claimIds) {
        if (claimIds != null) {
            for (String id : claimIds) {
                repo.findById(id).ifPresent(claim -> {
                    claim.setStatus(ClaimStatus.Closed);
                    repo.save(claim);
                });
            }
        }
    }

    @DeleteMapping("/api/claims/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

}
