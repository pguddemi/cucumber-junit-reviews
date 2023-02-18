package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumber-report.html"}, //especially for reports
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        tags = "@validLogin",
        dryRun = false ,
        //in order to get snippets by making dryRun TRUE
        // or in order to run codes make dryRun FALSE
        publish = true //in order to generate public link for reports

)


public class CukesRunner {
}
