package com.example.demo.platform.util.loaders.country;

import com.example.demo.platform.countries.Country;
import com.example.demo.platform.countries.CountryRepository;
import com.example.demo.platform.util.dtos.Planet;
import com.example.demo.platform.util.dtos.PlanetList;
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
public class CountryLoader implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(CountryLoader.class);

    @Autowired
    private CountryRepository repository;

    @SneakyThrows
    @Override
    public void run() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PlanetList people = mapper.readValue(new ClassPathResource("/data/planets.json").getInputStream()
                , PlanetList.class);

        for (Planet person : people.getResults()) {
            log.info("Preloading " + repository.save(new Country(
                    Arrays.stream(person.getUrl().split("/")).reduce((first, second) -> second).get()
                    , person.getName()
                    , person.getTerrain()
                    , person.getClimate()
            )));
        }
    }
}
