package com.example.claimsui;


import com.example.claimsui.createClaim.CreateClaimForm;
import com.example.claimsui.claimsList.ClaimsList;
import io.mateu.mdd.shared.annotations.MenuOption;

public class ClaimsMenu {

    @MenuOption
    CreateClaimForm createClaim;

    @MenuOption
    ClaimsList claims;

    @MenuOption
    String helloClaims() {
        return "Hello from claims!";
    }

}
