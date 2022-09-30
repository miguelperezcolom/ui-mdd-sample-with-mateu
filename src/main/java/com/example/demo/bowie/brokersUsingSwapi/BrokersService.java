package com.example.demo.bowie.brokersUsingSwapi;

import com.example.demo.bowie.brokersUsingSwapi.dtos.People;
import com.example.demo.bowie.brokersUsingSwapi.dtos.PeopleList;
import com.vaadin.data.provider.QuerySortOrder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BrokersService {
    String baseResourceUrl = "https://swapi.dev/api/people/";
    RestTemplate restTemplate = new RestTemplate();

    public List<Row> getListOfBrokers(BrokersView filters, List<QuerySortOrder> sortOrders, int offset, int limit) {
        PeopleList peopleList = restTemplate.getForObject(baseResourceUrl, PeopleList.class);
        return Arrays.stream(peopleList.getResults()).map(p -> {
            Row r = new Row();
            r.setId(Arrays.stream(p.getUrl().split("/")).reduce((first, second) -> second).get());
            r.setName(p.getName());
            r.setEmail(p.getHair_color() + "@" + p.getHair_color() + ".com");
            return r;
        }).collect(Collectors.toList());
    }

    public int gatherCount(BrokersView filters) {
        PeopleList peopleList = restTemplate.getForObject(baseResourceUrl, PeopleList.class);
        return peopleList.getResults().length;
    }

    public Broker getById(String id) {
        People p = restTemplate.getForObject(baseResourceUrl + id, People.class);
        Broker broker = new Broker();
        broker.setId(Arrays.stream(p.getUrl().split("/")).reduce((first, second) -> second).get());
        broker.setName(p.getName());
        broker.setEmail(p.getHair_color() + "@" + p.getHair_color() + ".com");
        return broker;
    }


    public static void main(String[] args) {
        List<Row> r = new BrokersService().getListOfBrokers(null, null, 0, 200);
        System.out.println("done");
    }
}
