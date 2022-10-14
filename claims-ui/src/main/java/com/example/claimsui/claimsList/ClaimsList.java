package com.example.claimsui.claimsList;

import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.icons.VaadinIcons;
import io.mateu.mdd.core.interfaces.RpcCrudView;
import io.mateu.mdd.shared.annotations.Action;
import io.mateu.mdd.shared.annotations.Ignored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClaimsList implements RpcCrudView<ClaimsList, Row, Editor> {

    @Autowired@Ignored
    private ClaimsListService service;

    @Override
    public Object deserializeId(String sid) {
        return sid;
    }

    @Override
    public boolean isAddEnabled() {
        return true;
    }

    @Override
    public List<Row> rpc(ClaimsList filters, List<QuerySortOrder> sortOrders, int offset, int limit) throws Throwable {
        return service.getAll(filters, sortOrders, offset, limit);
    }

    @Override
    public int gatherCount(ClaimsList filters) throws Throwable {
        return service.getAll(filters, null, 0, 300).size();
    }

    @Override
    public Object onEdit(Row row) throws Throwable {
        return new Editor(service.get(row.getId()));
    }

    @Action(icon = VaadinIcons.CHECK)
    public void markSelectedAsDone() {
        service.markAsDone(getSelectedRows().stream().map(row -> row.getId()).collect(Collectors.toList()));
    }
}
