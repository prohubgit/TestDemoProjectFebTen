package com.guru99.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoGuru99Page extends BasePage{
    /*##############################################################################
               DemoGuru99 constructor
     ##############################################################################*/
    public DemoGuru99Page (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //  *******************************************************************************



    @FindBy(css = "body > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=text]")
    private WebElement userEmailID;

    /*##############################################################################
                Method for enter E-Mail Id
    ##############################################################################*/

    public void enterUserEmailId(String emailId){
        userEmailID.sendKeys(emailId);
    }
    //  *******************************************************************************
    @FindBy(css ="body > form > table > tbody > tr:nth-child(6) > td:nth-child(2) > input[type=submit]")
    private WebElement submitButton;

//    /*##############################################################################
//                  Method for click on submit button
//    ##############################################################################*/
//    public UserAccessPage clickOnSubmitButton(){
//        submitButton.click();
//        return new UserAccessPage(driver);
//    }
////  *******************************************************************************



}
