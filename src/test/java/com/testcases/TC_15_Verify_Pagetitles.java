package com.testcases;

import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_15_Verify_Pagetitles extends GenericMethods {
    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        homePage=HomePage.getInstance();
    }

    @Description("Verification for page titles")
    @Test(priority =1)
    public void verify_page_titles() throws InterruptedException {
        homePage.verify_page_titles();

    }
}
