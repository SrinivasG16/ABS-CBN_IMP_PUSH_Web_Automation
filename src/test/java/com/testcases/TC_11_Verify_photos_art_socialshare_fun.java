package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.applicationpages.PhotosArticle;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_11_Verify_photos_art_socialshare_fun extends GenericMethods {

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

    @Description("Verification for Functionality of Social share icons on the Photos Article inner page")
    @Test(priority =1)
    public void verify_Social_share_fun() throws InterruptedException {
        photosArticle=PhotosArticle.getInstance();
        photosArticle.Verify_Social_share_fun();
    }
}
