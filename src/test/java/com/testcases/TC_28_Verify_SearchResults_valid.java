package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.SearchPage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_28_Verify_SearchResults_valid extends GenericMethods {

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
        homePage.Verify_Search_fun("Miss earth philippines");
    }


    @Description("Verification for the functionality of Search with valid data on the Search page")
    @Test(priority =2)
    public void verify_Searchresults() throws InterruptedException {
        searchPage=SearchPage.getInstance();
        searchPage.Verify_Searchresults();
    }






}
