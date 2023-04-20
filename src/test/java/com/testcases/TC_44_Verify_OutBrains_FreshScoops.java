package com.testcases;

import com.applicationpages.FreshScoops;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_44_Verify_OutBrains_FreshScoops extends GenericMethods {
   HomePage homePage;
   FreshScoops freshScoops;

    @Description("Launching the browser and Navigating to Fresh Scoops Page")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
      //  homePage.Navigate_To_freshscoops();
    }

    @Description("Verification for the availability of recommended section on the Fresh Scoops page")
    @Test(priority =1)
    public void verify_Recom_section() throws InterruptedException {
        freshScoops=FreshScoops.getInstance();
        freshScoops.Verify_Recom_sec();
    }

    @Description("Verification for the availability of out brain ads thumbnails on recommended section in the Fresh Scoops page")
    @Test(priority =2)
    public void verify_outBrain_ads_thumb() throws InterruptedException {
        freshScoops.Verify_outBrain_ads_thumb("Home");
    }

    @Description("Verification for the availability of out brain ads link on recommended section in the Fresh Scoops page")
    @Test(priority =3)
    public void verify_outBrain_ads_link() throws InterruptedException {
        freshScoops.Verify_outBrain_ads_link("Home");
    }

    @Description("Verification for the availability of out brain ads source link on recommended section in the Fresh Scoops page")
    @Test(priority =4)
    public void verify_outBrain_ads_source() throws InterruptedException {
        freshScoops.Verify_outBrain_ads_source("Home");
    }




}
