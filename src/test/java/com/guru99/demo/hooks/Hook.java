package com.guru99.demo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook extends BrowserPrack {
    public Scenario scenario;
    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        launchBrowser("Chrome");
    }

    @After
    public void tearDown() {
        // Method for taking screenshot and saving with name and type using try & catch

            try{
                if (scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        // Method call for closing browser from BrowserParck class
        closeBrowser();
    }
}
