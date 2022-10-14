package com.example.demo.bowie.brokersUsingSwapi;

import io.mateu.mdd.core.interfaces.PersistentPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class Broker implements PersistentPojo {

    @Id
    private String id;
    private String name;
    private String email;


    @Override
    public void save() throws IOException, Throwable {
        System.out.println("saved");
    }

    @Override
    public void load(Object id) throws Throwable {
        System.out.println("loading");
    }

    public String toString() {
        return name;
    }
}
