package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.Photos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_09_Verify_Photos_UI extends GenericMethods {

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

    @Description("Verification for availability of Photos sub section on the Photos page")
    @Test(priority =2)
    public void verify_photos_sub() throws InterruptedException {
        photos.Verify_Photos_section();
    }
    @Description("Verification for availability of Main article with thumbnail on the Photos page")
    @Test(priority =3)
    public void verify_mainart_thumb() throws InterruptedException {
        photos.Verify_main_art_thumb();
    }
    @Description("Verification for availability of Main article link on the Photos page")
    @Test(priority =4)
    public void verify_mainart() throws InterruptedException {
        photos.Verify_main_art_link();
    }
    @Description("Verification for availability of Trending now section on the Photos page")
    @Test(priority =5)
    public void verify_trendnow_section() throws InterruptedException {
        photos.Verify_trendnow_section();
    }

    @Description("Verification for availability of Trending now section articles on the Photos page")
    @Test(priority =6)
    public void verify_trendnow_art() throws InterruptedException {
        photos.Verify_trendnow_art();
    }
    @Description("Verification for availability of Trending now section articles posted time on the Photos page")
    @Test(priority =7)
    public void verify_trendnow_art_time() throws InterruptedException {
        photos.Verify_trendnow_art_pdate();
    }
    @Description("Verification for availability of Trending now section articles number on the Photos page")
    @Test(priority =8)
    public void verify_trendnow_art_num() throws InterruptedException {
        photos.Verify_trendnow_art_num();
    }

    @Description("Verification for availability of Just In section on the Photos page")
    @Test(priority =9)
    public void verify_justin_section() throws InterruptedException {
        photos.Verify_justin_section();
    }

    @Description("Verification for availability of Just In section articles on the Photos page")
    @Test(priority =11)
    public void verify_justin_art() throws InterruptedException {
        photos.Verify_just_art();
    }

    @Description("Verification for availability of Just In section articles post date on the Photos page")
    @Test(priority =12)
    public void verify_justin_art_pdate() throws InterruptedException {
        photos.Verify_just_art_pdate();
    }
    @Description("Verification for availability of See more button on the Photos page")
    @Test(priority =13)
    public void verify_morephotos() throws InterruptedException {
        photos.Verify_morephotos();
    }
}
