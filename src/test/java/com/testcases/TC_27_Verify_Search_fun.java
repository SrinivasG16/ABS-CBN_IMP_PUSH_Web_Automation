package com.testcases;


import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_27_Verify_Search_fun extends GenericMethods {

    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();

    }

    @Description("Verification for the functionality of Search on the home page")
    @Test(priority =1)
    public void verify_Search_fun() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Search_fun("Miss earth philippines");
    }




}
