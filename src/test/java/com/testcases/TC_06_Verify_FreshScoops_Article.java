package com.testcases;

import com.applicationpages.FreshScoops;
import com.applicationpages.FreshScoopsArticle;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_06_Verify_FreshScoops_Article extends GenericMethods {

    FreshScoopsArticle freshScoopsArticle;
    FreshScoops freshScoops;
    HomePage homePage;

    @Description("Launching the browser and Navigating to Fresh Scoops article inner Page")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
        freshScoops=FreshScoops.getInstance();
        homePage.Navigate_To_freshscoops();
        freshScoops.Navigate_To_FsArticleinner();
    }

    @Description("Verification for availability of Article main image on the Fresh Scoops article inner page")
    @Test(priority =1)
    public void verify_articlemain_image() throws InterruptedException {
        freshScoopsArticle=FreshScoopsArticle.getInstance();
        freshScoopsArticle.Verify_article_main_image();
        JavascriptExecutor js=(JavascriptExecutor)driver;
    }

    @Description("Verification for availability of Latest Photo section on the Fresh Scoops article inner page")
    @Test(priority =9)
    public void verify_latpho_section() throws InterruptedException {
        freshScoopsArticle.Verify_latpho_section();
    }
    @Description("Verification for availability of Latest Photo section articles with thumbnail on the Fresh Scoops article inner page")
    @Test(priority =3)
    public void verify_latpho_thumb() throws InterruptedException {
        freshScoopsArticle.Verify_latpho_art_thumb();
    }
    @Description("Verification for availability of Latest Photo section articles on the Fresh Scoops article inner page")
    @Test(priority =4)
    public void verify_latpho_art() throws InterruptedException {
        freshScoopsArticle.Verify_latpho_art();
    }
    @Description("Verification for availability of Trending section on the Fresh Scoops  article inner page")
    @Test(priority =5)
    public void verify_trendnow_section() throws InterruptedException {
        freshScoopsArticle.Verify_trend_section();
    }

    @Description("Verification for availability of Trending section articles on the Fresh Scoops article inner page")
    @Test(priority =6)
    public void verify_trendnow_art() throws InterruptedException {
        freshScoopsArticle.Verify_trend_art();
    }
    @Description("Verification for availability of Trending section articles posted time on the Fresh Scoops article inner page")
    @Test(priority =7)
    public void verify_trendnow_art_time() throws InterruptedException {
        freshScoopsArticle.Verify_trend_art_pdate();
    }
    @Description("Verification for availability of Trending section articles number on the Fresh Scoops article inner page")
    @Test(priority =8)
    public void verify_trendnow_art_num() throws InterruptedException {
        freshScoopsArticle.Verify_trend_art_num();
    }

    @Description("Verification for availability of Related scoops articles  on the Fresh Scoops article inner page")
    @Test(priority =9)
    public void verify_related_scooparticles() throws InterruptedException {
        freshScoopsArticle.Verify_relscoops_art();
    }
}
