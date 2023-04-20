package com.testcases;

import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_43_Verify_OutBrains_Home extends GenericMethods {
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
        homePage.Verify_Recom_sec();
    }

    @Description("Verification for the availability of out brain ads thumbnails on recommended section in the Home page")
    @Test(priority =2)
    public void verify_outBrain_ads_thumb() throws InterruptedException {
        homePage.Verify_outBrain_ads_thumb("Home");
    }

    @Description("Verification for the availability of out brain ads link on recommended section in the Home page")
    @Test(priority =3)
    public void verify_outBrain_ads_link() throws InterruptedException {
        homePage.Verify_outBrain_ads_link("Home");
    }

    @Description("Verification for the availability of out brain ads source link on recommended section in the Home page")
    @Test(priority =4)
    public void verify_outBrain_ads_source() throws InterruptedException {
        homePage.Verify_outBrain_ads_source("Home");
    }




}
