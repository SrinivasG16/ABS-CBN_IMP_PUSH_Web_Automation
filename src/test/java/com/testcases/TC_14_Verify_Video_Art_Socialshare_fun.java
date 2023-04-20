package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.VideoArticle;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_14_Verify_Video_Art_Socialshare_fun extends GenericMethods {

    VideoArticle videoArticle;
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
        videos.Navigate_To_VideoArticleinner();
        videoArticle=VideoArticle.getInstance();
    }

    @Description("Verification for Functionality of Social share icons on the Videos Article inner page")
    @Test(priority =1)
    public void verify_Social_share_fun() throws InterruptedException {
       videoArticle.Verify_Social_share_fun();
    }
}
