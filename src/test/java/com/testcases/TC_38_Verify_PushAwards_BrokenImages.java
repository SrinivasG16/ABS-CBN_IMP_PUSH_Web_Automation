package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.PushAwards;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_38_Verify_PushAwards_BrokenImages extends GenericMethods {



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

    @Description("Verification for the functionality of Broken images of the Push Awards page")
    @Test(priority =1)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Push Awards");
    }


}
