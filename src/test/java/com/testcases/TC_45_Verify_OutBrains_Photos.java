package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_45_Verify_OutBrains_Photos extends GenericMethods {
   HomePage homePage;
   Photos photos;

    @Description("Launching the browser and Navigating to Photos Page")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
     //   homePage.Navigate_To_photos();
    }

    @Description("Verification for the availability of recommended section on the Photos page")
    @Test(priority =1)
    public void verify_Recom_section() throws InterruptedException {
        photos=Photos.getInstance();
        photos.Verify_Recom_sec();
    }

    @Description("Verification for the availability of out brain ads thumbnails on recommended section in the Photos page")
    @Test(priority =2)
    public void verify_outBrain_ads_thumb() throws InterruptedException {
        photos.Verify_outBrain_ads_thumb("Photos");
    }

    @Description("Verification for the availability of out brain ads link on recommended section in the Photos page")
    @Test(priority =3)
    public void verify_outBrain_ads_link() throws InterruptedException {
        photos.Verify_outBrain_ads_link("Photos");
    }

    @Description("Verification for the availability of out brain ads source link on recommended section in the Photos page")
    @Test(priority =4)
    public void verify_outBrain_ads_source() throws InterruptedException {
        photos.Verify_outBrain_ads_source("Photos");
    }




}
