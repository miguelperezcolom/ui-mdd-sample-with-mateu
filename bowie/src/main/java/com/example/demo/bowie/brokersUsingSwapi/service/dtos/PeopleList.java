package com.example.demo.bowie.brokersUsingSwapi.service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PeopleList {

    private int count;

    private People[] results;

}
