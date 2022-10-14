package com.example.demo.bowie.brokersUsingSwapi;

import com.example.demo.bowie.brokersUsingSwapi.service.BrokersService;
import com.vaadin.data.provider.QuerySortOrder;
import io.mateu.mdd.core.interfaces.RpcCrudView;
import io.mateu.mdd.shared.annotations.Caption;
import io.mateu.mdd.shared.annotations.MainSearchFilter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Caption("Brokers")
@Component
public class BrokersView
        implements
        RpcCrudView<BrokersView, Row, Broker> {

    @Autowired
    private BrokersService brokerService;

    @MainSearchFilter
    private String name;

    @Override
    public Object deserializeId(String sid) {
        return sid;
    }

    @Override
    public boolean isAddEnabled() {
        return false;
    }


    @Override
    public List<Row> rpc(BrokersView filters, List<QuerySortOrder> sortOrders, int offset, int limit) throws Throwable {
        return brokerService.getListOfBrokers(filters, sortOrders, offset, limit);
    }

    @Override
    public int gatherCount(BrokersView filters) {
        return brokerService.gatherCount(filters);
    }


    @Override
    public Object onEdit(Row row) throws Throwable {
        return brokerService.getById(row.getId());
    }
}
