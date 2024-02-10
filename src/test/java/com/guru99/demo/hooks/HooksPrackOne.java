package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksPrackOne extends BrowserPrack {
    // public level variable for Scenario
    public Scenario scenario;
    public void setUp(Scenario scenario){
        this.scenario = scenario;
        launchBrowser("Chrome");
    }
    public void tearDown(){
        //Method declaration and saving screenshot with name and its type using try and catch
        try{
            if (scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        // calling clseBrower from BrowserPrack class
        closeBrowser();;
    }
}
