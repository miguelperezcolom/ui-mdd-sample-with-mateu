package com.example.demo.bowie;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Callable;

@Getter@Setter
public class AForm implements Callable<String> {

    private String name;


    @Override
    public String call() throws Exception {
        return name;
    }
}
