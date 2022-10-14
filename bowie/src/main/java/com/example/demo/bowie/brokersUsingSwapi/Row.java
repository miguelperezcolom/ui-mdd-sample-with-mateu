package com.example.demo.bowie.brokersUsingSwapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Row {

    @Id
    private String id;
    private String name;
    private String email;

    public String toString() {
        return id;
    }
}
