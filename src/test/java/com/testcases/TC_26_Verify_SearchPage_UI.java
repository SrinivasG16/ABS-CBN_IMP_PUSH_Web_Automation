package com.testcases;



import com.applicationpages.HomePage;
import com.applicationpages.SearchPage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_26_Verify_SearchPage_UI extends GenericMethods {

    HomePage homePage;
    SearchPage searchPage;


    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @Description("Navigating to Search Page from the Home page")
    @Test(priority =1)
    public void verify_Search_fun() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Search_fun("Miss earth philippines");
    }


    @Description("Verification for availability of Push Logo on the Search page")
    @Test(priority =2)
    public void verify_push_logo() throws InterruptedException {
        searchPage=SearchPage.getInstance();
        searchPage.Verify_push_logo();
    }

    @Description("Verification for availability of Header Fresh scoops link on the Search page")
    @Test(priority =3)
    public void verify_hdr_freshscoops() throws InterruptedException {
        searchPage.Verify_hdr_freshscoops();
    }

    @Description("Verification for availability of Header Photos link on the Search page")
    @Test(priority =4)
    public void verify_hdr_photos() throws InterruptedException {
        searchPage.Verify_hdr_photos();
    }

    @Description("Verification for availability of Header Videos link on the Search page")
    @Test(priority =5)
    public void verify_hdr_videos() throws InterruptedException {
        searchPage.Verify_hdr_videos();
    }

    @Description("Verification for availability of Header Push awards thumbnail on the Search page")
    @Test(priority =6)
    public void verify_hdr_pushawards() throws InterruptedException {
        searchPage.Verify_hdr_pushawards();
    }

    @Description("Verification for availability of Search text box on the Search page")
    @Test(priority =7)
    public void verify_Search()  throws InterruptedException {
        searchPage.Verify_Search() ;
    }

    @Description("Verification for availability of Search icon on the Search page")
    @Test(priority =8)
    public void verify_Search_icon()  throws InterruptedException {
        searchPage.Verify_Search_icon() ;
    }

    @Description("Verification for availability of Videos article thumbnail on the Search page")
    @Test(priority =9)
    public void verify_video_sec_thumb() throws InterruptedException {
        searchPage.Verify_video_sec_thumb();
    }

    @Description("Verification for availability of Latest photos section on the Search page")
    @Test(priority =10)
    public void verify_latpho_section() throws InterruptedException {
        searchPage.Verify_latpho_section();
    }

    @Description("Verification for availability of Latest photos article thumbnail on the Search page")
    @Test(priority =11)
    public void verify_latpho_art_thumb() throws InterruptedException {
        searchPage.Verify_latpho_art_thumb();
    }

    @Description("Verification for availability of Latest photos article link on the Search page")
    @Test(priority =12)
    public void verify_latpho_art() throws InterruptedException {
        searchPage.Verify_latpho_art();
    }

    @Description("Verification for availability of Trending Now section on the Search page")
    @Test(priority =13)
    public void verify_trendnow_section() throws InterruptedException {
        searchPage.Verify_trendnow_section();
    }

    @Description("Verification for availability of Trending Now articles on the Search page")
    @Test(priority =14)
    public void verify_trendnow_art() throws InterruptedException {
        searchPage.Verify_trendnow_art();
    }

    @Description("Verification for availability of Facebook follow icon on the Search page")
    @Test(priority =15)
    public void verify_ftr_fbfollow() throws InterruptedException {
        searchPage.Verify_ftr_fbfollow();
    }

    @Description("Verification for availability of Instagram follow icon on the Search page")
    @Test(priority =16)
    public void verify_ftr_instafollow() throws InterruptedException {
        searchPage.Verify_ftr_instafollow();
    }

    @Description("Verification for availability of Twitter follow icon on the Search page")
    @Test(priority =17)
    public void verify_ftr_twfollow() throws InterruptedException {
        searchPage.Verify_ftr_twfollow();
    }

    @Description("Verification for availability of Youtube Subscribe icon on the Search page")
    @Test(priority =18)
    public void verify_ftr_ytfollow() throws InterruptedException {
        searchPage.Verify_ftr_ytfollow();
    }

    @Description("Verification for availability of Terms link on the Search page")
    @Test(priority =19)
    public void verify_ftr_terms() throws InterruptedException {
        searchPage.Verify_ftr_terms();
    }

    @Description("Verification for availability of Privacy link on the Search page")
    @Test(priority =20)
    public void verify_ftr_privacy() throws InterruptedException {
        searchPage.Verify_ftr_privacy();
    }

    @Description("Verification for availability of Contact us link on the Search page")
    @Test(priority =21)
    public void verify_ftr_contactUs() throws InterruptedException {
        searchPage.Verify_ftr_contactUs();
    }

    @Description("Verification for availability of Advertise with us link on the Search page")
    @Test(priority =22)
    public void verify_ftr_advtUs() throws InterruptedException {
        searchPage.Verify_ftr_advtUs();
    }

    @Description("Verification for availability of Copyright on the Search page")
    @Test(priority =23)
    public void verify_ftr_copyright() throws InterruptedException {
        searchPage.Verify_ftr_copyright();
    }




}
