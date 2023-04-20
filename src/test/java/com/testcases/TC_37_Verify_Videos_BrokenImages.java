package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_37_Verify_Videos_BrokenImages extends GenericMethods {
    Videos videos;
    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }
    @Description("Verification for navigating to videos page from the home page")
    @Test(priority =1)
    public void verify_videos_navigation() throws InterruptedException {
        videos=videos.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_videos();
        System.out.println(driver.getTitle());
    }

    @Description("Verification for the functionality of Broken images of the Videos Article page")
    @Test(priority =2)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Videos Article");
    }


}
