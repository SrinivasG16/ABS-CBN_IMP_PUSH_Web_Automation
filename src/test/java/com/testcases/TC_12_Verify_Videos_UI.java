package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.Videos;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_12_Verify_Videos_UI extends GenericMethods {
    Videos videos;
    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }
    @Description("Verification for navigating to videos page from the home page")
    @Test(priority =1)
    public void verify_videos_navigation() throws InterruptedException {
        videos=videos.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_videos();
        System.out.println(driver.getTitle());
    }

    @Description("Verification for availability of videos sub section on the videos page")
    @Test(priority =2)
    public void verify_videos_sub() throws InterruptedException {
        videos.Verify_videos_section();
    }
    @Description("Verification for availability of Main article with thumbnail on the videos page")
    @Test(priority =3)
    public void verify_mainart_thumb() throws InterruptedException {
        videos.Verify_main_art_thumb();
    }
    @Description("Verification for availability of Main article link on the videos page")
    @Test(priority =4)
    public void verify_mainart() throws InterruptedException {
        videos.Verify_main_art_link();
    }
    @Description("Verification for availability of Trending now section on the videos page")
    @Test(priority =5)
    public void verify_trendnow_section() throws InterruptedException {
        videos.Verify_trendnow_section();
    }

    @Description("Verification for availability of Trending now section articles on the videos page")
    @Test(priority =6)
    public void verify_trendnow_art() throws InterruptedException {
        videos.Verify_trendnow_art();
    }
    @Description("Verification for availability of Trending now section articles posted time on the videos page")
    @Test(priority =7)
    public void verify_trendnow_art_time() throws InterruptedException {
        videos.Verify_trendnow_art_pdate();
    }
    @Description("Verification for availability of Trending now section articles number on the videos page")
    @Test(priority =8)
    public void verify_trendnow_art_num() throws InterruptedException {
        videos.Verify_trendnow_art_num();
    }

    @Description("Verification for availability of Latest Photo section on the videos page")
    @Test(priority =9)
    public void verify_latpho_section() throws InterruptedException {
        videos.Verify_latpho_section();
    }
    @Description("Verification for availability of Latest Photo section articles with thumbnail on the videos page")
    @Test(priority =10)
    public void verify_latpho_thumb() throws InterruptedException {
        videos.Verify_latpho_art_thumb();
    }
    @Description("Verification for availability of Latest Photo section articles on the videos page")
    @Test(priority =11)
    public void verify_latpho_art() throws InterruptedException {
        videos.Verify_latpho_art();
    }

    @Description("Verification for availability of More Videos button on the Videos page")
    @Test(priority =12)
    public void verify_morevideos() throws InterruptedException {
        videos.Verify_morevideos();
    }

    @Description("Verification for functionality of push tv video on the videos page")
    @Test(priority =13)
    public void verify_pushtv_video() throws InterruptedException {
        videos.Verify_pushtv_video();
    }
    @Description("Verification for availability of Push tv article title on the videos page")
    @Test(priority =14)
    public void verify_pushtv_title() throws InterruptedException {
        videos.Verify_pushtv_title();
    }
    @Description("Verification for availability of Push tv article description on the videos page")
    @Test(priority =15)
    public void verify_pushtv_des() throws InterruptedException {
        videos.Verify_pushtv_description();
    }
    @Description("Verification for availability of Push tv playlist thumbnail on the videos page")
    @Test(priority =16)
    public void verify_pushtv_pl_thumbnail() throws InterruptedException {
        videos.Verify_pushtv_playlist_thumbnail();
    }
    @Description("Verification for availability of Push tv playlist title on the videos page")
    @Test(priority =17)
    public void verify_pushtv_pl_title() throws InterruptedException {
        videos.Verify_pushtv_playlist_title();
    }
    @Description("Verification for availability of Push tv playlist Hash tag on the videos page")
    @Test(priority =18)
    public void verify_pushtv_pl_hash() throws InterruptedException {
        videos.Verify_pushtv_playlist_hash();
    }

    @Description("Verification for availability of Push tv see more button on the videos page")
    @Test(priority =19)
    public void verify_pushtv_seemore() throws InterruptedException {
        videos.Verify_pushtv_seemore();
    }

    @Description("Verification for availability of Recently section on the videos page")
    @Test(priority =20)
    public void verify_recently_section() throws InterruptedException {
        videos.Verify_recently_section();
    }
    @Description("Verification for availability of Recently section articles with thumbnail on the videos page")
    @Test(priority =21)
    public void verify_recently_thumb() throws InterruptedException {
        videos.Verify_recently_art_thumb();
    }
    @Description("Verification for availability of Recently section articles on the videos page")
    @Test(priority =22)
    public void verify_recently_art() throws InterruptedException {
        videos.Verify_recently_art();
    }
}
