package com.testcases;


import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TC_19_Verify_Webstories_UI extends GenericMethods {

    HomePage homePage;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @Description("Navigating to Web stories inner page from the home page")
    @Test(priority =1)
    public void verify_Webstories_thumb_Art() throws InterruptedException {
        homePage=HomePage.getInstance();
        homePage.Verify_Webstories_thumb_Art();

    }

    @Description("Verification for availability of right arrow for Next slide on the Web stories inner page")
    @Test(priority =2)
    public void verify_Webstories_rightArrow() throws InterruptedException {
        homePage.Verify_Webstories_rightArrow();
    }

    @Description("Verification for availability of left arrow for previous slide on the Web stories inner page")
    @Test(priority =3)
    public void verify_Webstories_leftArrow() throws InterruptedException {
        homePage.Verify_Webstories_leftArrow();
    }

    @Description("Verification for availability of close button on the Web stories inner page")
    @Test(priority =4)
    public void verify_Webstories_Close() throws InterruptedException {
        homePage.Verify_Webstories_Close();
    }

    @Description("Verification for availability of Next arrow for next web story on the Web stories inner page")
    @Test(priority =5)
    public void verify_Webstories_NextArtarrow() throws InterruptedException {
        homePage.Verify_Webstories_NextArtarrow();
    }

    @Description("Verification for availability of previous arrow for previous web story on the Web stories inner page")
    @Test(priority =6)
    public void verify_Webstories_prevArtarrow() throws InterruptedException {
        homePage.Verify_Webstories_prevArtarrow();
    }

    @Description("Verification for availability of launch web story icon on the Web stories inner page")
    @Test(priority =7)
    public void verify_Webstories_launchart() throws InterruptedException {
        homePage.Verify_Webstories_launchart();
    }

}
