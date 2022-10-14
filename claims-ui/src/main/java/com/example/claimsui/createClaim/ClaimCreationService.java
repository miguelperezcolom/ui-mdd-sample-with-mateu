package com.example.claimsui.createClaim;

import com.example.claimsui.shared.dtos.Claim;
import com.example.claimsui.shared.dtos.ClaimType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClaimCreationService {

    @Value("${claims.baseurl}")
    String baseResourceUrl;

    RestTemplate restTemplate = new RestTemplate();

    public void createClaim(ClaimType type, String description) {
        Claim claim = new Claim();
        claim.setType(type);
        claim.setDescription(description);
        restTemplate.put(baseResourceUrl + claim.getId(), claim);
    }

}
