package com.example.demo.bowie;

import com.example.demo.bowie.brokersUsingSwapi.BrokersView;
import com.example.demo.platform.companies.Company;
import com.example.demo.platform.countries.Country;
import com.example.demo.platform.vehicles.Vehicle;
import io.mateu.mdd.shared.annotations.MenuOption;

public class ThisIsASubmenu {

    @MenuOption
    Class companies = Company.class;

    @MenuOption
    Class countries = Country.class;

    @MenuOption
    Class vehicles = Vehicle.class;

    @MenuOption
    BrokersView brokersUsingRest;


}
