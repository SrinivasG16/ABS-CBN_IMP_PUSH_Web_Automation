package com.testcases;

import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class atest extends GenericMethods {
   HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }

    @Description("Verification for the availability of recommended section on the Home page")
    @Test(priority =1)
    public void verify_Recom_section() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_outBrain_ads_thumb("Home");
    }



}
