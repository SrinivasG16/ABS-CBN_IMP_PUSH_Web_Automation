package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_46_Verify_OutBrains_Videos extends GenericMethods {
   HomePage homePage;
   Videos videos;

    @Description("Launching the browser and Navigating to Videos")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
      //  homePage.Navigate_To_videos();
    }

    @Description("Verification for the availability of recommended section on the Videos page")
    @Test(priority =1)
    public void verify_Recom_section() throws InterruptedException {
        videos =Videos.getInstance();
        videos.Verify_Recom_sec();
    }

    @Description("Verification for the availability of out brain ads thumbnails on recommended section in the Videos page")
    @Test(priority =2)
    public void verify_outBrain_ads_thumb() throws InterruptedException {
        videos.Verify_outBrain_ads_thumb("Videos");
    }

    @Description("Verification for the availability of out brain ads link on recommended section in the Videos page")
    @Test(priority =3)
    public void verify_outBrain_ads_link() throws InterruptedException {
        videos.Verify_outBrain_ads_link("Videos");
    }

    @Description("Verification for the availability of out brain ads source link on recommended section in the Videos page")
    @Test(priority =4)
    public void verify_outBrain_ads_source() throws InterruptedException {
        videos.Verify_outBrain_ads_source("Videos");
    }




}
