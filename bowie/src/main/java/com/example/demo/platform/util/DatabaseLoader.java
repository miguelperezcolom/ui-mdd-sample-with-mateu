package com.example.demo.platform.util;

import com.example.demo.platform.util.loaders.broker.BrokerLoader;
import com.example.demo.platform.util.loaders.company.CompanyLoader;
import com.example.demo.platform.util.loaders.country.CountryLoader;
import com.example.demo.platform.util.loaders.vehicle.VehicleLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DatabaseLoader {

    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase(
            BrokerLoader peopleLoader,
            CountryLoader countryLoader,
            CompanyLoader companyLoader,
            VehicleLoader vehicleLoader
    ) throws IOException {

        return args -> {

            peopleLoader.run();
            countryLoader.run();
            companyLoader.run();
            vehicleLoader.run();

        };
    }

}
