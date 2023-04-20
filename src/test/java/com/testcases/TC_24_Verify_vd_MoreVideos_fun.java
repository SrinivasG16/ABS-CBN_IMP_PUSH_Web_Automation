package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_24_Verify_vd_MoreVideos_fun extends GenericMethods {

    HomePage homePage;
    Videos videos;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }



    @Description("Navigating to videos page from the home page")
    @Test(priority =1)
    public void verify_videos_navigation() throws InterruptedException {
        videos=videos.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_videos();
    }

    @Description("Verification for the functionality of More Videos button on the Videos page")
    @Test(priority = 2)
    public void verify_vd_MoreVideos_fun() throws InterruptedException {
        videos.Verify_vd_MoreVideos_fun();
    }


}
