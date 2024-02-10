package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksPrackThree extends BrowserPrack {

    // Declaring Scenario varible
    public Scenario scenario;
    // Prerequisites for test executions
    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
        launchBrowser("Chrome");
    }

    // Method for after test execution
    @After
    public void tearDown(){

        //Taking Screenshot and saving it with name and its type using try and catch
        try{
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        // calling closeBrowser method of BrowserPrack class
        closeBrowser();
    }

}
