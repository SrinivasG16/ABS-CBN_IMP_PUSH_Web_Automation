package com.annotations;


import com.genericmethods.GenericMethods;
import com.getconfidetails.ReadConfigDetails;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class Annotations {
    @BeforeSuite
    public void beforeSuite(){
        ReadConfigDetails readConfigDetails = new ReadConfigDetails();
        readConfigDetails.loadProperties();

    }
    @AfterClass
    public void afterClass()
    {
        GenericMethods.driver.quit();
    }

    @AfterSuite
    public void afterSuite()
    {
       GenericMethods.driver.quit();
    }

}
