package com.example.claimsui.claimsList;

import com.example.claimsui.shared.dtos.Claim;
import com.vaadin.data.provider.QuerySortOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimsListService {

    @Value("${claims.baseurl}")
    String baseResourceUrl;

    RestTemplate restTemplate = new RestTemplate();

    public List<Row> getAll(ClaimsList filters, List<QuerySortOrder> sortOrders, int offset, int limit) {
//        Sort sort = new Sort();
//        Pageable pageable = new PageRequest(offset, limit, sort);
        Page res = restTemplate.getForObject(baseResourceUrl, Page.class);
        return res.getContent().stream()
                .map(c -> new Row(c.getId(), c.getType(), c.getDescription(), c.getStatus()))
                .collect(Collectors.toList());
    }

    public Claim get(String id) {
        return restTemplate.getForObject(baseResourceUrl + id, Claim.class);
    }

    public void save(Claim claim) {
        restTemplate.put(baseResourceUrl + claim.getId(), claim);
    }

    public void markAsDone(List<String> claimIds) {
        restTemplate.postForEntity(baseResourceUrl + "mark-as-done", claimIds.toArray(), Void.class);
    }

}
