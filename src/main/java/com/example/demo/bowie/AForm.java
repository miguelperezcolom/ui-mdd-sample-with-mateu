package com.example.demo.bowie;

import com.example.demo.bowie.brokersUsingSwapi.service.BrokersService;
import com.example.demo.bowie.brokersUsingSwapi.BrokersView;
import io.mateu.mdd.shared.annotations.Ignored;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Getter@Setter
@Component
public class AForm implements Callable<String> {

    @Autowired@Ignored
    private BrokersService brokersService;


    private String name;


    @Override
    public String call() throws Exception {
        return "" + name + " " + brokersService.gatherCount(new BrokersView());
    }
}
