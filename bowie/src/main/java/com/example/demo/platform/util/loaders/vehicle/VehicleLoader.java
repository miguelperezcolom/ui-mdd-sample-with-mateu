package com.example.demo.platform.util.loaders.vehicle;

import com.example.demo.platform.util.dtos.Starship;
import com.example.demo.platform.util.dtos.StarshipList;
import com.example.demo.platform.vehicles.Vehicle;
import com.example.demo.platform.vehicles.VehicleRepository;
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
public class VehicleLoader implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(VehicleLoader.class);

    @Autowired
    private VehicleRepository repository;

    @SneakyThrows
    @Override
    public void run() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        StarshipList people = mapper.readValue(new ClassPathResource("/data/starships.json").getInputStream()
                , StarshipList.class);

        for (Starship person : people.getResults()) {
            log.info("Preloading " + repository.save(new Vehicle(
                    Arrays.stream(person.getUrl().split("/")).reduce((first, second) -> second).get()
                    , person.getName()
                    , person.getManufacturer()
                    , person.getUrl()
            )));
        }
    }
}
