package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.applicationpages.PhotosArticle;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_40_Verify_PhotosArticle_BrokenImages extends GenericMethods {



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
    @Description("Verification for the functionality of Broken images of the Photos Article page")
    @Test(priority =1)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Photos Article");
    }


}
