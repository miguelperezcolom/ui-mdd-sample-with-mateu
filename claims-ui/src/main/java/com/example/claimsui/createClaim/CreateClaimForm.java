package com.example.claimsui.createClaim;

import com.example.claimsui.shared.dtos.ClaimType;
import io.mateu.mdd.shared.annotations.Ignored;
import io.mateu.mdd.shared.annotations.TextArea;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter@Setter
public class CreateClaimForm implements Runnable {

    @Autowired@Ignored
    transient ClaimCreationService service;


    private ClaimType type;

    @TextArea
    private String description;

    @Override
    public void run() {
        service.createClaim(type, description);
    }
}
