package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before //it should come from cucumber java not junit
    public void setUp(){
        System.out.println("SET UP BEFORE EACH SCENARIO");
    }

    @After //it should come from cucumber java not junit
    public void tearDown(){
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }



}
