package com.example.demo.platform.util.loaders.broker;

import com.example.demo.platform.brokers.Broker;
import com.example.demo.platform.brokers.BrokerRepository;
import com.example.demo.platform.util.dtos.People;
import com.example.demo.platform.util.dtos.PeopleList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class BrokerLoader implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(BrokerLoader.class);

    @Autowired
    private BrokerRepository repository;

    @SneakyThrows
    @Override
    public void run() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PeopleList people = mapper.readValue(new ClassPathResource("/data/people.json").getInputStream()
                , PeopleList.class);

        for (String postfix : new String[] {"", " 2"})
        for (People person : people.getResults()) {
            Broker broker = new Broker(
                    Arrays.stream(person.getUrl().split("/")).reduce((first, second) -> second).get()
                    , person.getName() + postfix
                    , person.getHair_color() + "@" + person.getGender() + ".com"
                    , person.getUrl(),
                    null,
                    null,
                    false,
                    new ArrayList<>()
            );
            log.info("Preloading " + repository.save(broker));
        }
    }
}
