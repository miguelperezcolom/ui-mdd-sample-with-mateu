package com.example.claimsplatform.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter@Setter
public class Claim {

    @Id
    private String id = UUID.randomUUID().toString();

    private LocalDateTime created = LocalDateTime.now();

    private String who;

    private ClaimType type;

    private String description;

    private ClaimStatus status;

    private double amount;

}
