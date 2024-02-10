package com.guru99.demo.hooks;

import com.guru99.demo.common.Browser;
import org.junit.After;
import org.junit.Before;

public class Hook extends Browser {
    // always extends with Browser class
    // Add tag+Before and then setUP(){} method

    @Before
    public void setUp(){
        launchBrowser("Chrome");
    }

    // Add tag+After then add tearDown method ..(@After tearDown())
    @After
    public void tearDown(){
        closeBrowser();
    }

}
