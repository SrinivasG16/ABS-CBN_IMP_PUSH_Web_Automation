package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_36_Verify_Photos_BrokenImages extends GenericMethods {



    Photos photos;
    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }

    @Description("Verification for navigating to Photos page from the home page")
    @Test(priority =1)
    public void verify_photos_navigation() throws InterruptedException {
        photos=photos.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_photos();
    }

    @Description("Verification for the functionality of Broken images of the Photos page")
    @Test(priority =1)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Photos");
    }


}
