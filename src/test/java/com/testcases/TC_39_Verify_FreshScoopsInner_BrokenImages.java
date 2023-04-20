package com.testcases;


import com.applicationpages.FreshScoops;
import com.applicationpages.FreshScoopsArticle;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_39_Verify_FreshScoopsInner_BrokenImages extends GenericMethods {



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
    }

    @Description("Verification for the functionality of Broken images of the Fresh Scoops Article page")
    @Test(priority =2)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Fresh Scoops Article");
    }


}
