package com.testcases;


import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_20_Verify_Webstories_close_fun extends GenericMethods {

    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @Description("Navigating to Web stories inner page from the home page")
    @Test(priority =1)
    public void verify_Webstories_thumb_Art() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Webstories_thumb_Art();

    }

    @Description("Verification for availability of right arrow for Next slide on the Web stories inner page")
    @Test(priority =2)
    public void verify_Webstories_rightArrow() throws InterruptedException {
        homePage.Verify_Webstories_Close_fun();
    }



}
