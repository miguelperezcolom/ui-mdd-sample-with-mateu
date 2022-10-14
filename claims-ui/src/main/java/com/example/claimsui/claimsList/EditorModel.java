package com.example.claimsui.claimsList;

import com.example.claimsui.shared.dtos.ClaimStatus;
import com.example.claimsui.shared.dtos.ClaimType;
import io.mateu.mdd.shared.annotations.Output;
import io.mateu.mdd.shared.annotations.TextArea;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EditorModel {

    @Output
    String id;

    ClaimType type;

    ClaimStatus status;

    @TextArea
    String description;



}
