package com.testcases;

import com.applicationpages.HomePage;
import com.applicationpages.PushAwards;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_30_Verify_PushAwardsPage_UI extends GenericMethods {

    PushAwards pushAwards;
    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }

    @Description("Verification for navigating to Push Awards page from the home page")
    @Test(priority =1)
    public void navigate_To_PushAwards() throws InterruptedException {
        pushAwards=pushAwards.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_PushAwards();
    }
    @Description("Verification for availability of Carousel with images on the Push Awards page")
    @Test(priority =2)
    public void verify_clorousel_art() throws InterruptedException {
        pushAwards.select_first_thumb();
        pushAwards.Verify_img_slideshow();
    }
    @Description("Verification for availability of Carousel articles title links on the Push Awards page")
    @Test(priority =3)
    public void verify_clorousel_title() throws InterruptedException {
        pushAwards.select_first_thumb();
        pushAwards.Verify_slideshow_link();
    }

    @Description("Verification for availability of Push Awards sub section on the Push Awards page")
    @Test(priority =4)
    public void verify_photos_sub() throws InterruptedException {
        pushAwards.Verify_pushAwards_section();
    }
    @Description("Verification for availability of Push Awards sub section article with thumbnail on the Push Awards page")
    @Test(priority =5)
    public void verify_pushAwards_thumb_Art() throws InterruptedException {
        pushAwards.Verify_pushAwards_thumb_Art();
    }
    @Description("Verification for availability of Push Awards sub section article with link on the Push Awards page")
    @Test(priority =6)
    public void verify_pushAwards_art_links() throws InterruptedException {
        pushAwards.Verify_pushAwards_art_links();
    }

    @Description("Verification for functionality of push tv video on the Push Awards page")
    @Test(priority =7)
    public void verify_pushawards_video() throws InterruptedException {
        pushAwards.Verify_pushawards_video();
    }
    @Description("Verification for availability of Push tv article title on the Push Awards page")
    @Test(priority =8)
    public void verify_pushawards_title() throws InterruptedException {
        pushAwards.Verify_pushawards_title();
    }
    @Description("Verification for availability of Push tv article description on the Push Awards page")
    @Test(priority =9)
    public void verify_pushawards_des() throws InterruptedException {
        pushAwards.Verify_pushawards_description();
    }
    @Description("Verification for availability of Push tv playlist thumbnail on the Push Awards page")
    @Test(priority =10)
    public void verify_pushawards_pl_thumbnail() throws InterruptedException {
        pushAwards.Verify_pushawards_playlist_thumbnail();
    }
    @Description("Verification for availability of Push tv playlist title on the Push Awards page")
    @Test(priority =11)
    public void verify_pushawards_pl_title() throws InterruptedException {
        pushAwards.Verify_pushawards_playlist_title();
    }
    @Description("Verification for availability of Push tv playlist Hash tag on the Push Awards page")
    @Test(priority =12)
    public void verify_pushawards_pl_hash() throws InterruptedException {
        pushAwards.Verify_pushawards_playlist_hash();
    }

    @Description("Verification for availability of Push tv see more button on the Push Awards page")
    @Test(priority =13)
    public void verify_pushawards_seemore() throws InterruptedException {
        pushAwards.Verify_pushawards_seemore();
    }

    @Description("Verification for availability of trending now section on the Push Awards page")
    @Test(priority =14)
    public void verify_trendn_section() throws InterruptedException {
        pushAwards.Verify_trendn_section();
    }

    @Description("Verification for availability of trending now articles on the Push Awards page")
    @Test(priority =15)
    public void verify_trend_art() throws InterruptedException {
        pushAwards.Verify_trendn_art();
    }

    @Description("Verification for availability of Web Stories sub section on the Push Awards page")
    @Test(priority =16)
    public void verify_webstories() throws InterruptedException {
        pushAwards.Verify_Webstories_section();
    }
    @Description("Verification for availability of Web Stories sub section article with thumbnail on the Push Awards page")
    @Test(priority =17)
    public void verify_webstories_thumb_art() throws InterruptedException {
        pushAwards.Verify_Webstories_thumb_Art();
    }









}
