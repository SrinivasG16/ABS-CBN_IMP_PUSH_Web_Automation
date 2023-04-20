package com.testcases;

import com.applicationpages.FreshScoops;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_22_Verify_fs_MoreScoops_fun extends GenericMethods {

    HomePage homePage;
    FreshScoops freshScoops;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    @Description("Navigating to fresh scoops page from the home page")
    @Test(priority =1)
    public void navigate_To_freshscoops() throws InterruptedException {
        freshScoops=FreshScoops.getInstance();
        homePage=HomePage.getInstance();

        homePage.Navigate_To_freshscoops();
    }

    @Description("Verification for the functionality of More scoops button on the fresh scoops page")
    @Test(priority = 2)
    public void verify_fs_MoreScoops_fun() throws InterruptedException {
       freshScoops.Verify_fs_MoreScoops_fun();
    }


}
