package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.PushAwards;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_47_Verify_OutBrains_PushAwards extends GenericMethods {
   HomePage homePage;
   PushAwards pushAwards;

    @Description("Launching the browser and Navigating to Push Awards page")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_PushAwards();
    }

    @Description("Verification for the availability of recommended section on the Push Awards page")
    @Test(priority =1)
    public void verify_Recom_section() throws InterruptedException {
        pushAwards=PushAwards.getInstance();
        pushAwards.Verify_Recom_sec();
    }

    @Description("Verification for the availability of out brain ads thumbnails on recommended section in the Push Awards page")
    @Test(priority =2)
    public void verify_outBrain_ads_thumb() throws InterruptedException {
        pushAwards.Verify_outBrain_ads_thumb("Push Awards");
    }

    @Description("Verification for the availability of out brain ads link on recommended section in the Push Awards page")
    @Test(priority =3)
    public void verify_outBrain_ads_link() throws InterruptedException {
        pushAwards.Verify_outBrain_ads_link("Push Awards");
    }

    @Description("Verification for the availability of out brain ads source link on recommended section in the Push Awards page")
    @Test(priority =4)
    public void verify_outBrain_ads_source() throws InterruptedException {
        pushAwards.Verify_outBrain_ads_source("Push Awards");
    }




}
