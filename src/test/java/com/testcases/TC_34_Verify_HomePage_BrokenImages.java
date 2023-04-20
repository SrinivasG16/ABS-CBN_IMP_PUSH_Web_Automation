package com.testcases;


import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.*;

public class TC_34_Verify_HomePage_BrokenImages extends GenericMethods {



    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();

    }


    @Description("Verification for the functionality of Broken images of the Home page")
    @Test(priority =2)
    public void BrokenImages() throws InterruptedException, AWTException {
        verifyBrokenImages("Home");
    }


}
