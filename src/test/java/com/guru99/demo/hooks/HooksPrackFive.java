package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksPrackFive extends BrowserPrack {

    // Declaration for Scenario varible
    public Scenario scenario;

    // Prerequisites for Test execution

    @Before
    public void setUp(Scenario scenario){

        // Instantiating Scenario
        this.scenario = scenario;

        // calling launchBrowser() method and passing browser name from BrowserPrack class
        launchBrowser("Chrome");

    }

    //Calling closeBrower() method from BrowsePrack class after Test execution

    @After
    public void tearDown(){

        //Declaring Take screenShot () with its name and type using try and catch.
        try{
            if (scenario.isFailed()){
                byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        closeBrowser();

    }





}
