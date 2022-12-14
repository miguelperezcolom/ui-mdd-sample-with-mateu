package com.example.demo.bowie;

import com.example.claimsui.ClaimsMenu;
import com.example.demo.platform.brokers.Broker;
import io.mateu.mdd.core.annotations.MateuUI;
import io.mateu.mdd.shared.annotations.FullWidth;
import io.mateu.mdd.shared.annotations.MenuOption;
import io.mateu.mdd.shared.annotations.Submenu;

@MateuUI(path = "")
@FullWidth
public class Bowie {

    @MenuOption(value = "Say hello", order = 30)
    public String hello(String name) {
        return "Hello " + name + "!";
    }

    @MenuOption
    Class brokers = Broker.class;

    @Submenu
    ThisIsASubmenu more;

    @MenuOption
    AForm aForm;

    @Submenu
    ClaimsMenu claims;

}
