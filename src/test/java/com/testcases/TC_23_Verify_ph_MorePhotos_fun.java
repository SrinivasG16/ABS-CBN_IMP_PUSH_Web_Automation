package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_23_Verify_ph_MorePhotos_fun extends GenericMethods {

    HomePage homePage;
    Photos photos;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }



    @Description("Navigating to Photos page from the home page")
    @Test(priority =1)
    public void verify_photos_navigation() throws InterruptedException {
        photos=photos.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_photos();
    }

    @Description("Verification for the functionality of More Photos button on the Photos page")
    @Test(priority = 2)
    public void verify_ph_MorePhotos_fun() throws InterruptedException {
        photos.Verify_ph_MorePhotos_fun();
    }


}
