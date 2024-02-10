package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksSeven extends BrowserPrack {

    // Declaring Scenario variable
    public Scenario scenario;

    //Required prerequisites for Test execution

    @Before
    public void setUp(Scenario scenario){

        // Instantiating scenario
        this.scenario  = scenario;

        // Calling launchBrowser() and passing its name from BrowserPrack classs
        launchBrowser("Chrome");
    }

    //Declaring routine required After Test Execution

    @After
    public void tearDown(){
        // Takinng screenshot and saving it with its name and type using try & catch
        try{
            if(scenario.isFailed()){
                byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        //calling closeBrowser() to close the browser and all of its instances from BrowserPrack class
        closeBrowser();
    }

}
