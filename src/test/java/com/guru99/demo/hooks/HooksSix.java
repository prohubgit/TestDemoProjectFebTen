package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksSix extends BrowserPrack {

    // Declaring Scenario variable
    public Scenario scenario;

    // Prerequisites for Test execution

    @Before
    public void setUp(Scenario scenario){

        // Instantiating scenario
        this.scenario = scenario;

        //calling launchBrowser() and passing browser name from BrowserPrack class
        launchBrowser("Chrome");

    }

    //Calling closeBrowser() after Test execution
    public void closeBrowser(){

        //Taking screenshot and saving it with its name and type using try & catch

        try{
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        closeBrowser();
    }

}
