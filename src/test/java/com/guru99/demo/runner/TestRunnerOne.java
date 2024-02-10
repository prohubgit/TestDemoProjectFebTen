package com.guru99.demo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/guru99/demo/features"},
        glue = {"com/guru99/demo/hooks/Hook.java", "com/guru99/demo/stepdefinitions"},
        plugin = {"pretty", "json:target/report.json",
                "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"},
        tags =  "@ignor And @SmokeTest"
)


public class TestRunnerOne {
}
