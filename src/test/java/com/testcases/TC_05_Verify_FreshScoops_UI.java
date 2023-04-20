package com.testcases;

import com.applicationpages.FreshScoops;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_05_Verify_FreshScoops_UI extends GenericMethods {

    FreshScoops freshScoops;
    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }
    @Description("Verification for navigating to fresh scoops page from the home page")
    @Test(priority =1)
    public void verify_freshscoops_navigation() throws InterruptedException {
        freshScoops=FreshScoops.getInstance();
        homePage=HomePage.getInstance();
        homePage.Navigate_To_freshscoops();
    }

    @Description("Verification for availability of Fresh scoops sub section on the Fresh Scoops page")
    @Test(priority =2)
    public void verify_freshscoops_sub() throws InterruptedException {
        freshScoops.Verify_freshscoops_section();
    }
    @Description("Verification for availability of Main article with thumbnail on the Fresh Scoops page")
    @Test(priority =3)
    public void verify_mainart_thumb() throws InterruptedException {
        freshScoops.Verify_main_art_thumb();
    }
    @Description("Verification for availability of Main article link on the Fresh Scoops page")
    @Test(priority =4)
    public void verify_mainart() throws InterruptedException {
        freshScoops.Verify_main_art_link();
    }
    @Description("Verification for availability of Trending section on the Fresh Scoops page")
    @Test(priority =5)
    public void verify_trendnow_section() throws InterruptedException {
        freshScoops.Verify_trendnow_section();
    }

    @Description("Verification for availability of Trending section articles on the Fresh Scoops page")
    @Test(priority =6)
    public void verify_trendnow_art() throws InterruptedException {
        freshScoops.Verify_trendnow_art();
    }
    @Description("Verification for availability of Trending section articles posted time on the Fresh Scoops page")
    @Test(priority =7)
    public void verify_trendnow_art_time() throws InterruptedException {
        freshScoops.Verify_trendnow_art_pdate();
    }
    @Description("Verification for availability of Trending section articles number on the Fresh Scoops page")
    @Test(priority =8)
    public void verify_trendnow_art_num() throws InterruptedException {
        freshScoops.Verify_trendnow_art_num();
    }

    @Description("Verification for availability of Latest Photo section on the Fresh Scoops page")
    @Test(priority =9)
    public void verify_latpho_section() throws InterruptedException {
        freshScoops.Verify_latpho_section();
    }
    @Description("Verification for availability of Latest Photo section articles with thumbnail on the Fresh Scoops page")
    @Test(priority =10)
    public void verify_latpho_thumb() throws InterruptedException {
        freshScoops.Verify_latpho_art_thumb();
    }
    @Description("Verification for availability of Latest Photo section articles on the Fresh Scoops page")
    @Test(priority =11)
    public void verify_latpho_art() throws InterruptedException {
        freshScoops.Verify_latpho_art();
    }

    @Description("Verification for availability of More Scoops button on the Fresh Scoops page")
    @Test(priority =12)
    public void verify_morescoops() throws InterruptedException {
        freshScoops.Verify_morescoops_fun();
    }
}
