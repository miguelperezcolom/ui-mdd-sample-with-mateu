package com.example.demo.bowie.brokersUsingSwapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PeopleList {

    private int count;

    private People[] results;

}
