package com.example.claimsui.claimsList;

import com.example.claimsui.shared.dtos.ClaimStatus;
import com.example.claimsui.shared.dtos.ClaimType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Row {

    private String id;

    private ClaimType type;

    private String description;

    private ClaimStatus status;

    @Override
    public String toString() {
        return id;
    }
}
