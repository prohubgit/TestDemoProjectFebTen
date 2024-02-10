package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksFour extends BrowserPrack {

    // Declaration for Scenario vaiable
    public Scenario scenario;

    //Prerequisites for Test execution

    @Before
    public void setUp(Scenario scenario){
        // Instantiation of Scenario
        this.scenario = scenario;

        // calling launchBrowser Method  and passing browser name in it from BrowserPrack class
        launchBrowser("Chrome");
    }

    // calling closseBrowser Method after Test execution from BrowserPrack class
    @After
    public  void tearDown(){

        // Taking screenshot and saving it with its name and type using try and catch
        try{
            if (scenario.isFailed()){
                byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        closeBrowser();
    }






}
