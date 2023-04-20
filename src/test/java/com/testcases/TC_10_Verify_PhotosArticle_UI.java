package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.applicationpages.PhotosArticle;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_10_Verify_PhotosArticle_UI extends GenericMethods {

    PhotosArticle photosArticle;
    Photos photos;
    HomePage homePage;

    @Description("Launching the browser and Navigating to Photos article inner Page")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
        photos=Photos.getInstance();
        homePage.Navigate_To_photos();
        photos.Navigate_To_PhotoArticleinner();
    }
    @Description("Verification for availability of Article main image on the Fresh Scoops article inner page")
    @Test(priority =1)
    public void verify_articlemain_image() throws InterruptedException {
        photosArticle=PhotosArticle.getInstance();
        photosArticle.Verify_article_main_image();
    }

    @Description("Verification for availability of Just In section on the Photos page")
    @Test(priority =2)
    public void verify_justin_section() throws InterruptedException {

        photosArticle.Verify_justin_section();
    }

    @Description("Verification for availability of Just In section articles on the Photos page")
    @Test(priority =3)
    public void verify_justin_art() throws InterruptedException {
        photosArticle.Verify_just_art();
    }

    @Description("Verification for availability of Just In section articles post date on the Photos page")
    @Test(priority =4)
    public void verify_justin_art_pdate() throws InterruptedException {
        photosArticle.Verify_just_art_pdate();
    }

    @Description("Verification for availability of Trending section on the Photos page")
    @Test(priority =5)
    public void verify_trendnow_section() throws InterruptedException {
        photosArticle.Verify_trendn_section();
    }

    @Description("Verification for availability of Trending section articles on the Photos page")
    @Test(priority =6)
    public void verify_trendnow_art() throws InterruptedException {
        photosArticle.Verify_trendn_art();
    }
    @Description("Verification for availability of Trending section articles posted time on the Photos page")
    @Test(priority =7)
    public void verify_trendnow_art_time() throws InterruptedException {
        photosArticle.Verify_trendn_art_pdate();
    }
    @Description("Verification for availability of Trending section articles number on the Photos page")
    @Test(priority =8)
    public void verify_trendnow_art_num() throws InterruptedException {
        photosArticle.Verify_trendn_art_num();
    }
}
