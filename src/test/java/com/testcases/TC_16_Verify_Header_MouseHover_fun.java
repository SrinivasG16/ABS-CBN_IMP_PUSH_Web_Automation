package com.testcases;

import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_16_Verify_Header_MouseHover_fun extends GenericMethods {

    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }

    @Description("Verification for functionality of Fresh scoops header link mouse hover items on the home page")
    @Test(priority =1)
    public void Verify_Freshscoops_MouseHover_items() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Freshscoops_MouseHover_items();
    }

    @Description("Verification for functionality of Photos header link mouse hover items on the home page")
    @Test(priority =2)
    public void verify_Header_MouseHover_items() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Photos_MouseHover_items();
    }

    @Description("Verification for functionality of Videos header link mouse hover items on the home page")
    @Test(priority =3)
    public void verify_Videos_MouseHover_items() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Videos_MouseHover_items();
    }
}
