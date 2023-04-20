package com.testcases;

import com.Reports.GenerateReport;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class TC_Generate_ExtentReport extends GenericMethods {

    GenerateReport generateReport;
    @Description("Generating the allure results")
    @Test(priority =0)
    public void generateAllure() throws InterruptedException {
        generateReport=GenerateReport.getInstance();
        generateReport.Generatereport();
    }

    @Description("Launching the browser , Navigating to netlify.app and Manually deploying the allure results ")
    @Test(priority =1)
    public void deployResults() throws InterruptedException {
        generateReport=GenerateReport.getInstance();
        generateReport.Deployreport();

    }



}
