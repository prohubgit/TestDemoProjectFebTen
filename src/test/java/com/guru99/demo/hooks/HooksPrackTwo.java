package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksPrackTwo extends BrowserPrack {
    // public level variable declaration for scenario
    public Scenario scenario;

    // Method prerequisits for test executions
    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
        launchBrowser("Chrome");
    }

    // Method for closing Browser
    @After
    public void tearDown(){

        // Method for taking Screenshot and saving that screenshot with name and type using try and catch
        try{
            if (scenario.isFailed()){
                byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Method call for closing the browser from BrowserPrack class
        closeBrowser();
    }
}
