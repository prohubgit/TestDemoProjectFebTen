package com.guru99.demo.stepdefinitions;

import com.guru99.demo.pages.BasePage;
import com.guru99.demo.pages.DemoGuru99Page;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;

public class UserAccountSteps extends BasePage {
    DemoGuru99Page demoGuru99Page = PageFactory.initElements(driver, DemoGuru99Page.class);

    @Given("I navigate to Guru99 home page")
    public void i_navigate_to_guru99_home_page() {
        launchUrl();

    }
    @Given("I click on AcceptAll button on Manage your Privacy")
    public void i_click_on_accept_all_button_on_manage_your_privacy() {

    }
}
