package com.testcases;

import com.Reports.GenerateReport;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_RemovePrevious_results extends GenericMethods {

    @Description("Removing the previous allure results")
    @Test(priority =0)
    public void deletePrevious() throws IOException {
       // DeletePrevious();  ;
       // StoreResultsURL();
    }
}
