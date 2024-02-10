package com.guru99.demo.pages;

import com.guru99.demo.common.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Iterator;
import java.util.Set;




public class BasePage extends Driver {

    public String BASE_URL = "https://demo.guru99.com/test/upload/";
    public  String BASE_URL_IND_01 = "https://demo.guru99.com/popup.php";


    // Declaring Select variable;
    private static Select select;
    private static Actions action;

    {
        select = null;
        action = null;
    }
    /*#################################################################################
             Method for launching browser
     #################################################################################*/
    public void launchUrl(){
        //driver.navigate().to(BASE_URL);
        driver.navigate().to(BASE_URL_IND_01);

    }
    //*********************************************************************************


    /*=================================================================================
        Manage Privacy Direct Alert
    ================================================================================= */
    public void managePrivacyBP(WebElement element){
        element.click();
    }
    //==================================================================================

    /*=================================================================================
        Manage Privacy On IFrame Alert
    ================================================================================= */
    public void managePrivacyBP(WebElement frameElement, WebElement element){
        driver.switchTo().frame(frameElement);
        element.click();
    }
    //==================================================================================


    /*#################################################################################
               Method for Selecting Text from ListBox
     ################################################################################*/
    public void selectByText(WebElement element, String text){
        select = new Select(element);
        select.selectByVisibleText(text);

    }
    //  *******************************************************************************

    //#################################################################################
    //            Method for Selecting Value from ListBox
    // ################################################################################
    public void selectByValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);

    }
    //  *******************************************************************************

    //#################################################################################
    //            Method for Selecting Value by Index from ListBox
    // ################################################################################
    //Define method to select by index
    public void selectByIndex(WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);

    }
    //  *******************************************************************************

    /*#################################################################################
               Method for Scroll Web Page Vertical
    ################################################################################*/
    // use negative vale to traverse upward
    public void scrollPageVerticall(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2000)");

    }
    //  *******************************************************************************


    /*#################################################################################
                Method for Scroll the page Horizontally /Backward
    ##################################################################################*/

    // use negative vale to traverse backward
    public void scrollPageHorizontally(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(2000,0)");

    }
    //  *******************************************************************************

    /*#################################################################################
                Method for Hovering on An Element
    ##################################################################################*/

    public static void HoverOver(WebElement element) throws Exception{
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    //***********************************************************************************


    /*#################################################################################
            Method for ContextClick on An Element
    ##################################################################################*/
    public static void contextClickOnElement(WebElement element) throws Exception{
        action =  new Actions(driver);
        action.contextClick(element).build().perform();

    }
    //***********************************************************************************


    /*####################################################################################
    Using Get Windows Handle & Handles Method to return to Parent Window from Child Window
        [Using Only One WebElement]
     ************************************************************************************/
    public void windowsHandler(WebElement element, String text){
        String parentWindow = driver.getWindowHandle();
        // To handle all new opened windows
        Set<String> set1 = driver.getWindowHandles();
        Iterator<String> ite = set1.iterator();

        while(ite.hasNext()){
            String ChildWindow = ite.next();
            if(!parentWindow.equalsIgnoreCase(ChildWindow)){
                // switching to child Window
                driver.switchTo().window(ChildWindow);
                element.sendKeys(text);
//                    element1.click();
//                    driver.close();
            }
        }
        // swithing back to parent Window
        //driver.switchTo().window(parentWindow);
    }




    //===================================================================================//

    /*====================================================================================
         Method for checking elements presence on Page
    =====================================================================================*/
    public void checkIfElemntPresent(String element, int timeout) throws Exception{
        for(int sec=0;; sec++){
            if(sec>=timeout)
                //fail("Timeoout! Coundn't locate element"+element);
                try {
                    //     if(selenium.isElementPresent(element))
                    break;
                }
                catch (Exception ex){

                }
            Thread.sleep(1000);
        }
    }

    //===================================================================================//

    /*#################################################################################
             Method for Screenshot
     #################################################################################*/
    public void screenshot(){
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now copy the shreenshot on specific location
        // FileUtils.copyFile(screen, newFile("src/test/errorScreenshots"));
    }
    //*********************************************************************************

}
