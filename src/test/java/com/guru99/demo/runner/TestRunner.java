package com.guru99.demo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Add RunWith tag and CucucmberOptions tag before the TestRunner class
@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/java/com/guru99/demo/features"},
        glue = {"com/guru99/demo/hooks","com/guru99/demo/stepdefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty", "json:target/report.json"},
       // plugin = {"pretty", "json:target/report.json"}
        // Here operator "or" means execute All the scenarios of feature file with tags of @newUserCredential or @SmokeTest
       tags = "@newUserCredential or  @SmokeTest and @ignor"
)
public class TestRunner {
}
