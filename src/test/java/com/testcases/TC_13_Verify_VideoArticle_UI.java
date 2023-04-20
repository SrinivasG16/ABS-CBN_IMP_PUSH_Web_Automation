package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.VideoArticle;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_13_Verify_VideoArticle_UI extends GenericMethods {

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

    @Description("Verification for functionality of push tv video on the  videos article inner page")
    @Test(priority =1)
    public void verify_pushtv_video() throws InterruptedException {
        videoArticle.Verify_pushtv_video();
    }
    @Description("Verification for availability of Push tv article title on the  videos article inner  page")
    @Test(priority =2)
    public void verify_pushtv_title() throws InterruptedException {
        videoArticle.Verify_pushtv_title();
    }
    @Description("Verification for availability of Push tv article description on the  videos article inner  page")
    @Test(priority =3,enabled = false)
    public void verify_pushtv_des() throws InterruptedException {
        videoArticle.Verify_pushtv_description();
    }

    @Description("Verification for availability of Trending section on the videos article inner page")
    @Test(priority =4)
    public void verify_trendnow_section() throws InterruptedException {
        videoArticle.Verify_trend_section();
    }

    @Description("Verification for availability of Trending section articles on the videos article inner  page")
    @Test(priority =5)
    public void verify_trendnow_art() throws InterruptedException {
        videoArticle.Verify_trend_art();
    }
    @Description("Verification for availability of Trending section articles posted time on the videos article inner page")
    @Test(priority =6)
    public void verify_trendnow_art_time() throws InterruptedException {
        videoArticle.Verify_trend_art_pdate();
    }
    @Description("Verification for availability of Trending section articles number on the videos article inner page")
    @Test(priority =7)
    public void verify_trendnow_art_num() throws InterruptedException {
        videoArticle.Verify_trend_art_num();
    }

    @Description("Verification for availability of Latest Photo section on the videos article inner page")
    @Test(priority =8)
    public void verify_latpho_section() throws InterruptedException {
        videoArticle.Verify_latpho_section();
    }
    @Description("Verification for availability of Latest Photo section articles with thumbnail on the videos article inner page")
    @Test(priority =9)
    public void verify_latpho_thumb() throws InterruptedException {
        videoArticle.Verify_latpho_art_thumb();
    }
    @Description("Verification for availability of Latest Photo section articles on the videos article inner page")
    @Test(priority =10)
    public void verify_latpho_art() throws InterruptedException {
        videoArticle.Verify_latpho_art();
    }
}
