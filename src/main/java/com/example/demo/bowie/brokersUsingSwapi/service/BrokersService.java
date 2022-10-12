package com.example.demo.bowie.brokersUsingSwapi.service;

import com.example.demo.bowie.brokersUsingSwapi.Broker;
import com.example.demo.bowie.brokersUsingSwapi.BrokersView;
import com.example.demo.bowie.brokersUsingSwapi.Row;
import com.example.demo.bowie.brokersUsingSwapi.service.dtos.People;
import com.example.demo.bowie.brokersUsingSwapi.service.dtos.PeopleList;
import com.vaadin.data.provider.QuerySortOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BrokersService {
    String baseResourceUrl = "https://swapi.dev/api/people/";
    RestTemplate restTemplate = new RestTemplate();
    private static final int ROWS_PER_PAGE = 10;

    public List<Row> getListOfBrokers(BrokersView filters, List<QuerySortOrder> sortOrders, int offset, int limit) {
        String queryString = "";
        List<Row> results = new ArrayList<>();
        int current = offset;
        int to = offset + limit;
        while (current < to) {
            int toSkip = 0;
            if (current > 0) {
                queryString = "?page=" + ((current / ROWS_PER_PAGE) + 1);
                toSkip = offset % ROWS_PER_PAGE;
            }
            if (filters.getName() != null && !filters.getName().isEmpty()) {
                queryString += "".equalsIgnoreCase(queryString)?"?":"&";
                queryString += "search=" + URLEncoder.encode(filters.getName(), Charset.defaultCharset());
            }
            System.out.println("==>" + baseResourceUrl + queryString);
            PeopleList peopleList = restTemplate.getForObject(baseResourceUrl + queryString, PeopleList.class);
            results.addAll(Arrays.stream(peopleList.getResults()).map(p -> {
                Row r = new Row();
                r.setId(Arrays.stream(p.getUrl().split("/")).reduce((first, second) -> second).get());
                r.setName(p.getName());
                r.setEmail(p.getHair_color() + "@" + p.getHair_color() + ".com");
                return r;
            }).skip(toSkip).collect(Collectors.toList()));
            if (peopleList.getCount() < to) to = peopleList.getCount();
            current += ROWS_PER_PAGE;
        }
        return results;
    }

    public int gatherCount(BrokersView filters) {
        String queryString = "";
        if (filters.getName() != null && !filters.getName().isEmpty()) {
            queryString += "".equalsIgnoreCase(queryString)?"?":"&";
            queryString += "search=" + URLEncoder.encode(filters.getName(), Charset.defaultCharset());
        }
        System.out.println("==>" + baseResourceUrl + queryString);
        PeopleList peopleList = restTemplate.getForObject(baseResourceUrl + queryString, PeopleList.class);
        return peopleList.getCount();
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
