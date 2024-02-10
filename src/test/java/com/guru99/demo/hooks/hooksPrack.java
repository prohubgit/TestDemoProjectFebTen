package com.guru99.demo.hooks;

import com.guru99.demo.common.BrowserPrack;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooksPrack extends BrowserPrack {

    // declaring public level scenario varible
    public Scenario scenario;

    // declaring the prerequisites for a test
    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
        launchBrowser("Chrome");
    }

    @After
    public void teardown(){
        //
        try{
        if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach("screenshot", "image/png", scenario.getName());}
            } catch (Exception e){
                e.printStackTrace();
            }

        closeBrowser();
    }
}
