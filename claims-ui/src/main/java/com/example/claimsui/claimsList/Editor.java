package com.example.claimsui.claimsList;

import com.example.claimsui.shared.dtos.Claim;
import io.mateu.mdd.core.interfaces.PersistentPojo;
import io.mateu.mdd.shared.annotations.Ignored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Editor extends EditorModel implements PersistentPojo {


    @Autowired
    @Ignored
    private ClaimsListService service;

    @Ignored
    private Claim claim;

    public Editor() {
        claim = new Claim();
    }

    public Editor(ClaimsListService service, Claim claim) {
        this.service = service;
        init(claim);
    }

    private void init(Claim claim) {
        this.claim = claim;
        id = claim.getId();
        type = claim.getType();
        status = claim.getStatus();
        description = claim.getDescription();
    }

    @Override
    public void save() throws IOException, Throwable {
        claim.setType(type);
        claim.setDescription(description);
        claim.setStatus(status);
        service.save(claim);
    }

    @Override
    public void load(Object id) throws Throwable {
        init(service.get((String) id));
    }

    @Override
    public String toString() {
        return id;
    }
}
