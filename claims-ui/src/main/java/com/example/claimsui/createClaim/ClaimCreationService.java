package com.example.claimsui.createClaim;

import com.example.claimsui.shared.dtos.Claim;
import com.example.claimsui.shared.dtos.ClaimType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClaimCreationService {

    String baseResourceUrl = "http://localhost:8081/api/claims/";
    RestTemplate restTemplate = new RestTemplate();

    public void createClaim(ClaimType type, String description) {
        Claim claim = new Claim();
        claim.setType(type);
        claim.setDescription(description);
        restTemplate.put(baseResourceUrl + claim.getId(), claim);
    }

}
