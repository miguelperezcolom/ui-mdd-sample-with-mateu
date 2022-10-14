package com.example.claimsui.claimsList;

import com.example.claimsui.shared.dtos.Claim;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class Page {

    private int totalElements;

    private List<Claim> content;

}
