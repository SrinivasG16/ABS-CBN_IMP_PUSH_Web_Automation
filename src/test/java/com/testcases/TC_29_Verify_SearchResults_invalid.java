package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.SearchPage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_29_Verify_SearchResults_invalid extends GenericMethods {

    HomePage homePage;
    SearchPage searchPage;


    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @Description("Navigating to Search Page from the Home page")
    @Test(priority =1)
    public void verify_Search_fun() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Search_fun("++++++++++++++");
    }


    @Description("Verification for the functionality of Search with special characters on the Search page")
    @Test(priority =2)
    public void verify_Searchresults_invalid() throws InterruptedException {
        searchPage=SearchPage.getInstance();
        searchPage.Verify_Searchresults_invalid();
    }

    @Description("Verification for the functionality of Search with special characters on the Search page")
    @Test(priority =3)
    public void verify_Searchresults_invalids() throws InterruptedException {
        homePage.Verify_push_logo_fun();
        homePage.Verify_Search_fun("philipppp");
        searchPage.Verify_Searchresults_invalid();
    }





}
