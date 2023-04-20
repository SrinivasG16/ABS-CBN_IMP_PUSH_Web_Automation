package com.testcases;


import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_25_Verify_TellmeMore_fun extends GenericMethods {

    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    @Description("Verification for the availability of i Agree button on the Home page")
    @Test(priority =1)
    public void verify_IAgree_btn() throws InterruptedException {

        homePage=HomePage.getInstance();
        homePage.Verify_IAgree_btn();

    }

    @Description("Verification for the functionality of Tell me more link on the Home page")
    @Test(priority =2)
    public void verify_TellmeMore_fun() throws InterruptedException {
        homePage.Verify_TellmeMore_fun();

    }

}
