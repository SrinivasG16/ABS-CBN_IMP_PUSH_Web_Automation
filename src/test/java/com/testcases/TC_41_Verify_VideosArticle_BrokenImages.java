package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_41_Verify_VideosArticle_BrokenImages extends GenericMethods {
    Videos videos;
    HomePage homePage;

    @Description("Launching the browser and Navigating to Videos article inner Page")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
        videos=Videos.getInstance();
        homePage.Navigate_To_videos();


    }
    @Description("Verification for availability of Article main image on the video article inner page")
    @Test(priority =1)
    public void navigate_To_VideoArticleinner() throws InterruptedException {
        videos.Navigate_To_VideoArticleinner();
    }

        @Description("Verification for the functionality of Broken images of the Videos  page")
    @Test(priority =2)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Videos ");
    }


}
