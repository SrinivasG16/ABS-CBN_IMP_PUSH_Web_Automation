package com.testcases;


import com.applicationpages.FreshScoops;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_35_Verify_FreshScoops_BrokenImages extends GenericMethods {



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


    @Description("Verification for the functionality of Broken images of the Fresh Scoops page")
    @Test(priority =1)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Fresh Scoops");
    }


}
