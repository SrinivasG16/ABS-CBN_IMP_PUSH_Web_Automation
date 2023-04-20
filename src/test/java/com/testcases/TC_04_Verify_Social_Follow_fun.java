package com.testcases;

import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TC_04_Verify_Social_Follow_fun extends GenericMethods {

    @Description("Verification for Functionality of Social Follow icons on the home page")
    @Test(priority =0)
    public void verify_Social_follow_fun() throws InterruptedException {
        launchBrowser();
        manageCookies();
        HomePage homePage = HomePage.getInstance();
        homePage.Verify_Social_follow_fun();
    }

}
