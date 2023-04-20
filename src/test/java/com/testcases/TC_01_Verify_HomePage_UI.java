package com.testcases;

import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_01_Verify_HomePage_UI extends GenericMethods {

    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Description("Verification for availability of PUSH logo on the home page")
    @Test(priority =1)
    public void verify_push_logo() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_push_logo();
    }

    @Description("Verification for availability of Fresh scoops header link on the home page")
    @Test(priority =2)
    public void verify_freshscoops_hdr() throws InterruptedException {
        homePage.Verify_hdr_freshscoops();
    }

    @Description("Verification for availability of Photos header link on the home page")
    @Test(priority =3)
    public void verify_photos_hdr() throws InterruptedException {
        homePage.Verify_hdr_photos();
    }

    @Description("Verification for availability of videos header link on the home page")
    @Test(priority =4)
    public void verify_videos_hdr() throws InterruptedException {
        homePage.Verify_hdr_videos();
    }

    @Description("Verification for availability of Search text box on the home page")
    @Test(priority =5)
    public void verify_Search() throws InterruptedException {
        homePage.Verify_Search();
    }

    @Description("Verification for availability of Search icon on the home page")
    @Test(priority =6)
    public void verify_Search_icon() throws InterruptedException {
        homePage.Verify_Search_icon();
    }


    @Description("Verification for availability of Carousel with images on the home page")
    @Test(priority =7)
    public void verify_carousel_art() throws InterruptedException {
        homePage.select_first_thumb();
        homePage.Verify_img_slideshow();
    }
    @Description("Verification for availability of Carousel articles title links on the home page")
    @Test(priority =8)
    public void verify_carousel_title() throws InterruptedException {
        homePage.select_first_thumb();
        homePage.Verify_slideshow_link();
    }

    @Description("Verification for availability of fresh scoops sub section on the home page")
    @Test(priority =9)
    public void verify_fs_subsection() throws InterruptedException {

        homePage.Verify_fs_section();
    }
    @Description("Verification for availability of fresh scoops article with thumbnail on the home page")
    @Test(priority =10)
    public void verify_fs_art_thumbnail() throws InterruptedException {
        homePage.Verify_fs_art_thumbnail();
    }

    @Description("Verification for availability of fresh scoops articles links on the home page")
    @Test(priority =10)
    public void verify_fs_art_links() throws InterruptedException {
        homePage.Verify_fs_art_link();
    }
    @Description("Verification for availability of fresh scoops more scoops button on the home page")
    @Test(priority =11)
    public void verify_fs_morescoops() throws InterruptedException {
        homePage.Verify_fs_morescoops();
    }
    @Description("Verification for functionality of push tv video on the home page")
    @Test(priority =12)
    public void verify_pushtv_video() throws InterruptedException {
        homePage.Verify_pushtv_video();
    }
    @Description("Verification for availability of Push tv article title on the home page")
    @Test(priority =14)
    public void verify_pushtv_title() throws InterruptedException {
        homePage.Verify_pushtv_title();
    }
    @Description("Verification for availability of Push tv article description on the home page")
    @Test(priority =15)
    public void verify_pushtv_des() throws InterruptedException {
        homePage.Verify_pushtv_description();
    }
    @Description("Verification for availability of Push tv playlist thumbnail on the home page")
    @Test(priority =16)
    public void verify_pushtv_pl_thumbnail() throws InterruptedException {
        homePage.Verify_pushtv_playlist_thumbnail();
    }
    @Description("Verification for availability of Push tv playlist title on the home page")
    @Test(priority =17)
    public void verify_pushtv_pl_title() throws InterruptedException {
        homePage.Verify_pushtv_playlist_title();
    }
    @Description("Verification for availability of Push tv playlist Hash tag on the home page")
    @Test(priority =18)
    public void verify_pushtv_pl_hash() throws InterruptedException {
        homePage.Verify_pushtv_playlist_hash();
    }

    @Description("Verification for availability of Push tv see more button on the home page")
    @Test(priority =19)
    public void verify_pushtv_seemore() throws InterruptedException {
        homePage.Verify_pushtv_seemore();
    }

    @Description("Verification for availability of trending now section on the home page")
    @Test(priority =20)
    public void verify_trendn_section() throws InterruptedException {
        homePage.Verify_trendn_section();
    }

    @Description("Verification for availability of trending now articles on the home page")
    @Test(priority =21)
    public void verify_trend_art() throws InterruptedException {
        homePage.Verify_trendn_art();
    }
    @Description("Verification for availability of Photos sub section on the home page")
    @Test(priority =22)
    public void verify_photos_sub() throws InterruptedException {
        homePage.Verify_photos_section();
    }
    @Description("Verification for availability of Photos sub section article with thumbnail on the home page")
    @Test(priority =23)
    public void verify_photos_art_thumb() throws InterruptedException {
        homePage.Verify_photos_thumb_Art();
    }
    @Description("Verification for availability of Photos sub section article with link on the home page")
    @Test(priority =24)
    public void verify_photos_art_links() throws InterruptedException {
        homePage.Verify_photos_art_links();
    }
    @Description("Verification for availability of Photos sub section more photos button on the home page")
    @Test(priority =25)
    public void verify_photos_more() throws InterruptedException {
        homePage.Verify_more_photos();
    }
    @Description("Verification for availability of Web Stories sub section on the home page")
    @Test(priority =26)
    public void verify_webstories() throws InterruptedException {
        homePage.Verify_Webstories_section();
    }
    @Description("Verification for availability of Web Stories sub section article with thumbnail on the home page")
    @Test(priority =27)
    public void verify_webstories_thumb_art() throws InterruptedException {
        homePage.Verify_Webstories_thumb_Art();
    }

    @Description("Verification for availability of Entertainment sub section on the home page")
    @Test(priority =28)
    public void verify_ent_section() throws InterruptedException {
        homePage.Verify_ent_section();
    }

    @Description("Verification for availability of Entertainment sub section article with thumbnail on the home page")
    @Test(priority =29)
    public void verify_ent_art_thumb() throws InterruptedException {
        homePage.Verify_ent_art_thumb();
    }

    @Description("Verification for availability of Entertainment sub section article title on the home page")
    @Test(priority =30)
    public void verify_ent_art_title() throws InterruptedException {
        homePage.rdo_ent_corousel();
        homePage.Verify_ent_art_title();
    }

    @Description("Verification for availability of Web Stories sub section read more button on the home page")
    @Test(priority =31)
    public void verify_ent_readmore() throws InterruptedException {
        homePage.rdo_ent_corousel();
        homePage.Verify_ent_readmore();
    }


    // New developed
    @Description("Verification for availability of Push Awards header image on the home page")
    @Test(priority =32)
    public void verify_hdr_pushawards() throws InterruptedException {
        homePage.Verify_hdr_pushawards();
    }

    @Description("Verification for availability of Search field in Header on the home page")
    @Test(priority =33)
    public void verify_txt_search() throws InterruptedException {
        homePage.Verify_txt_search();
    }

    @Description("Verification for availability of Search field button in Header on the home page")
    @Test(priority =34)
    public void Verify_btn_search() throws InterruptedException {
        homePage.Verify_btn_search();
    }







}
