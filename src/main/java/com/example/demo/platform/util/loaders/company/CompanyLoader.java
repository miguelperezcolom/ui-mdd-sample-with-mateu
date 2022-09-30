package com.example.demo.platform.util.loaders.company;

import com.example.demo.platform.brokers.Broker;
import com.example.demo.platform.brokers.BrokerRepository;
import com.example.demo.platform.companies.Company;
import com.example.demo.platform.companies.CompanyRepository;
import com.example.demo.platform.util.dtos.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CompanyLoader implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(CompanyLoader.class);

    @Autowired
    private CompanyRepository repository;

    @SneakyThrows
    @Override
    public void run() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        FilmList people = mapper.readValue(new ClassPathResource("/data/films.json").getFile()
                , FilmList.class);

        for (Film person : people.getResults()) {
            Company company = new Company(
                    Arrays.stream(person.getUrl().split("/")).reduce((first, second) -> second).get()
                    , person.getTitle()
                    , person.getDirector()
                    , person.getUrl()
            );
            log.info("Preloading " + repository.save(company));
        }
    }
}
