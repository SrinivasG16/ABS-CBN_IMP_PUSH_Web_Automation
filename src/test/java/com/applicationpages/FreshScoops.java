package com.applicationpages;

import com.applicationobjects.FreshScoopsOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FreshScoops extends GenericMethods {

    private static FreshScoopsOR freshScoopsOR;
    private static FreshScoops freshScoops;

    private FreshScoops() {
        // Constructor for the FreshScoops class
        System.out.println("Creating object for FreshScoops PAGE");
    }

    public static FreshScoops getInstance() {
        // Method to get an instance of the FreshScoops class

        freshScoops = null;
        if (freshScoops == null) {
            // Check if freshScoops instance is null

            freshScoops = new FreshScoops();
            // Create a new instance of the FreshScoops class

            freshScoopsOR = PageFactory.initElements(driver, FreshScoopsOR.class);
            // Initialize the freshScoopsOR object using PageFactory with the driver and FreshScoopsOR class

        }
        return freshScoops;
        // Return the freshScoops instance
    }



    public void Verify_freshscoops_section(){
        // Verify the availability of the "Fresh scoops" sub section in the "Fresh Scoops" section
        availableElement("Fresh Scoops", "Fresh scoops", "Sub section", freshScoopsOR.txt_fs_section);
    }

    public void Verify_main_art_thumb(){
        // Verify the availability of the article with thumbnail in the "Main article" section of "Fresh Scoops"
        availableImage("Fresh Scoops", "Main article", "Article with thumbnail", freshScoopsOR.img_mainart);
    }

    public void Verify_main_art_link(){
        // Verify the availability of the article link in the "Main article" section of "Fresh Scoops"
        availableElement("Fresh Scoops", "Main article", "Article", freshScoopsOR.lnk_mainart);
    }

    public void Verify_trendnow_section(){
        // Verify the availability of the "Trending now" sub section in the "Fresh Scoops" section
        availableElement("Fresh Scoops", "Trending now", "Sub section", freshScoopsOR.txt_trending_sub);
    }

    public void Verify_trendnow_art(){
        // Verify the availability of the article in the "Trending now" section of "Fresh Scoops"
        availableElement("Fresh Scoops", "Trending now", "Article", freshScoopsOR.lnk_tren_art);
    }

    public void Verify_trendnow_art_pdate(){
        // Verify the availability of the article post date in the "Trending now" section of "Fresh Scoops"
        availableElement("Fresh Scoops", "Trending now", "article post date", freshScoopsOR.txt_tren_art_pdate);
    }

    public void Verify_trendnow_art_num(){
        // Verify the availability of the article number in the "Trending now" section of "Fresh Scoops"
        availableElement("Fresh Scoops", "Trending now", "article number", freshScoopsOR.txt_tren_art_num);
    }

    public void Verify_latpho_section(){
        // Verify the availability of the "Latest Photo" sub section in the "Fresh Scoops" section
        availableElement("Fresh Scoops", "Latest Photo", "Sub section", freshScoopsOR.txt_latphotos_sec);
    }

    public void Verify_latpho_art_thumb(){
        // Verify the availability of the article with thumbnail in the "Latest Photo" section of "Fresh Scoops"
        availableImage("Fresh Scoops", "Latest Photo", "Article with thumbnail", freshScoopsOR.img_latpho_art_thumb);
    }

    public void Verify_latpho_art(){
        // Verify the availability of the article in the "Latest Photo" section of "Fresh Scoops"
        availableElement("Fresh Scoops", "Latest Photo", "Article", freshScoopsOR.lnk_latpho_art);
    }

    public void Verify_morescoops_fun(){
        // Verify the availability of the "More Scoops" button in the "Fresh Scoops" section
        availableElement("Fresh Scoops", "More Scoops button", "More Scoops button", freshScoopsOR.btn_morescoops);

        // Click on the "More Scoops" button in the "Fresh Scoops" section
        clickElement("Fresh Scoops", "More Scoops", freshScoopsOR.btn_morescoops);
    }

    public void Navigate_To_FsArticleinner(){
        // Click on the "Main article" with thumbnail in the "Fresh Scoops" section
        clickElement("Fresh Scoops", "Main article", freshScoopsOR.img_latpho_art_thumb);

        // Scroll the page by 800 pixels vertically
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)","");

        // Scroll the page by an additional 1200 pixels vertically
        js.executeScript("window.scrollBy(0,1200)","");

        // Scroll the page by an additional 2000 pixels vertically
        js.executeScript("window.scrollBy(0,2000)","");
    }

    public void Verify_fs_MoreScoops_fun() throws InterruptedException {
        // Get the count of articles before clicking on the "More Scoops" button
        int artCount_bf = freshScoopsOR.lst_art_bf.size();
        System.out.println("Before : "+artCount_bf);

        // Click on the "More Scoops" button in the "Fresh Scoops" section
        clickElement("FreshScoops", "More Scoops", freshScoopsOR.btn_morescoops);
        Thread.sleep(2000);

        // Get the count of articles after clicking on the "More Scoops" button
        int artCount_af = freshScoopsOR.lst_art_af.size();
        System.out.println("After : "+artCount_af);

        if(artCount_af != artCount_bf){
            System.out.println("More scoops button functionality working as expected");
        }else{
            Assert.assertNotEquals(artCount_af, artCount_bf, "More scoops button functionality not working as expected");
        }
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void Verify_Recom_sec(){
        // Scroll the page to the bottom
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Move to the "Footer" section in the "FreshScoops" page
        moveToElement("FreshScoops", "Footer", freshScoopsOR.lnk_ftr_advus);

        // Check if the "Recommended Section" with ads is available
        availableElement("FreshScoops", "Recommended Section", "Ads", freshScoopsOR.txt_rec_sec);

        // Print the text of the "Recommended Section"
        System.out.println("Title link is : " + freshScoopsOR.txt_rec_sec.getText());
    }

    public void Verify_outBrain_ads_thumb(String PageName){
        SoftAssert softAssert = new SoftAssert();

        // Move to the "Footer" section in the "FreshScoops" page
        moveToElement("FreshScoops", "Footer", freshScoopsOR.txt_rec_sec);

        // Get the count of OutBrain placeholders
        int Count = freshScoopsOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders");

        for(int i = 0; i < Count; i++) {
            System.err.println("OutBrain Place holder id : " + freshScoopsOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Construct the JavaScript code to get the count of elements in each placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Execute the JavaScript code to get the count of elements in each placeholder
            long elementCount = (long) js.executeScript("return " + listCount);

            for (int j = 0; j < elementCount; j++) {
                try {
                    // Construct the JavaScript code to select the thumbnail element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > img\")";

                    // Execute the JavaScript code to select the thumbnail element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the thumbnail is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads thumbnail of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

                    if (status == true) {
                        System.out.println("Thumbnail placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                    } else {
                        softAssert.assertEquals(status, true, "Thumbnail placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    System.err.println("Thumbnail placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }
        softAssert.assertAll();
    }


    public void Verify_outBrain_ads_link(String PageName){
        SoftAssert soft = new SoftAssert();

        // Move to the "Footer" section in the "Home page"
        moveToElement("Home page", "Footer", freshScoopsOR.txt_rec_sec);

        // Get the count of OutBrain placeholders
        int Count = freshScoopsOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders");

        for (int i = 0; i < Count; i++) {
            System.err.println("OutBrain Place holder id : " + freshScoopsOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Construct the JavaScript code to get the count of elements in each placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Execute the JavaScript code to get the count of elements in each placeholder
            long elementCount = (long) js.executeScript("return " + listCount);

            for (int j = 0; j < elementCount; j++) {
                try {
                    // Construct the JavaScript code to select the link element
                    String jslink = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";

                    // Execute the JavaScript code to select the link element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jslink);

                    // Check if the link is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads link of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

                    if (status == true) {
                        System.out.println("link placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                        System.out.println("Link is : " + shadowRoot.getText());
                    } else {
                        soft.assertEquals(status, true, "link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    System.err.println("link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }
        soft.assertAll();
    }

    public void Verify_outBrain_ads_source(String PageName){
        SoftAssert sa = new SoftAssert();

        // Move to the "Footer" section in the "FreshScoops" page
        moveToElement("FreshScoops", "Footer", freshScoopsOR.txt_rec_sec);

        // Get the count of OutBrain placeholders
        int Count = freshScoopsOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders");

        for (int i = 0; i < Count; i++) {
            System.err.println("OutBrain Place holder id : " + freshScoopsOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Construct the JavaScript code to get the count of elements in each placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Execute the JavaScript code to get the count of elements in each placeholder
            long elementCount = (long) js.executeScript("return " + listCount);

            for (int j = 0; j < elementCount; j++) {
                try {
                    // Construct the JavaScript code to select the source link element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-source\")";

                    // Execute the JavaScript code to select the source link element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the source link is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads source link of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

                    if (status == true) {
                        System.out.println("source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                        System.out.println("Source Link is : " + shadowRoot.getText());
                    } else {
                        sa.assertEquals(status, true, "source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    System.err.println("source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }
        sa.assertAll();
    }



}
