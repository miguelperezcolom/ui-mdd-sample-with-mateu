package com.example.claimsui.shared.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter@Setter
public class Claim {

    private String id = UUID.randomUUID().toString();

    private LocalDateTime created = LocalDateTime.now();

    private String who;

    private ClaimType type;

    private String description;

    private ClaimStatus status;

    private double amount;

}
