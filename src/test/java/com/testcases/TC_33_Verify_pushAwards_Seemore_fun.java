package com.testcases;


import com.applicationpages.HomePage;
import com.applicationpages.PushAwards;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_33_Verify_pushAwards_Seemore_fun extends GenericMethods {

   HomePage homePage;
    PushAwards pushAwards;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }



    @Description("Navigating to Push Awards page from the home page")
    @Test(priority =1)
    public void Navigate_To_PushAwards() throws InterruptedException {

        homePage=HomePage.getInstance();
        homePage.Navigate_To_PushAwards();

    }

    @Description("Verification for the functionality of Push awards video section see more button on Push Awards page")
    @Test(priority =2)
    public void verify_pushAwards_innerthumb() throws InterruptedException {

       pushAwards=PushAwards.getInstance();
       pushAwards.Verify_seemore_btn_fun();

    }


}
