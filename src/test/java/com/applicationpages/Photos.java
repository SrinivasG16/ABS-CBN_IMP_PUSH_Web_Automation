package com.applicationpages;

import com.applicationobjects.PhotosOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Photos extends GenericMethods {
    private static PhotosOR photosOR;
    private static Photos photos;

    private Photos() {
        // Constructor for the Photos class
        System.out.println("Creating object for Photos PAGE");
    }

    public static Photos getInstance() {
        // Static method to get an instance of the Photos class
        photos = null;

        // Checking if the instance is null
        if (photos == null) {
            // Creating a new instance of the Photos class
            photos = new Photos();

            // Initializing the page factory for the PhotosOR class using the driver
            photosOR = PageFactory.initElements(driver, PhotosOR.class);
        }

        // Returning the instance of the Photos class
        return photos;
    }


    public void Verify_Photos_section() {
        // Verifies the availability of the "Photos" sub section
        availableElement("Photos", "Photos", "Sub section", photosOR.txt_ph_section);
    }

    public void Verify_main_art_thumb() {
        // Verifies the availability of the main article with thumbnail
        availableImage("Photos", "Main article", "Article with thumbnail", photosOR.img_mainart);
    }

    public void Verify_main_art_link() {
        // Verifies the availability of the main article link
        availableElement("Photos", "Main article", "Article", photosOR.lnk_mainart);
    }

    public void Verify_trendnow_section() {
        // Verifies the availability of the "Trending now" sub section
        availableElement("Photos", "Trending now", "Sub section", photosOR.txt_trending_sub);
    }

    public void Verify_trendnow_art() {
        // Verifies the availability of an article in the "Trending now" section
        availableElement("Photos", "Trending now", "Article", photosOR.lnk_tren_art);
    }

    public void Verify_trendnow_art_pdate() {
        // Verifies the availability of the post date for an article in the "Trending now" section
        availableElement("Photos", "Trending now", "article post date", photosOR.txt_tren_art_pdate);
    }

    public void Verify_trendnow_art_num() {
        // Verifies the availability of the article number for an article in the "Trending now" section
        availableElement("Photos", "Trending now", "article number", photosOR.txt_tren_art_num);
    }

    public void Verify_justin_section() {
        // Verifies the availability of the "Just In" sub section
        availableElement("Photos", "Just In", "Sub section", photosOR.txt_justin_sec);
    }

    public void Verify_just_art() {
        // Verifies the availability of an article in the "Just In" section
        availableElement("Photos", "Just In", "Article", photosOR.lnk_just_art);
    }

    public void Verify_just_art_pdate() {
        // Verifies the availability of the post date for an article in the "Just In" section
        availableElement("Photos", "Just In", "Article post date", photosOR.txt_just_art_pdate);
    }

    public void Verify_morephotos() {
        // Verifies the availability of the "More Photos" button in the "Photos" section
        availableElement("Photos", "More Photos", "More Photos Button", photosOR.btn_morephotos);

        // Clicks on the "More Photos" button
        clickElement("Photos", "More Photos", photosOR.btn_morephotos);
    }

    public void Navigate_To_PhotoArticleinner() {
        // Clicks on the main article image in the "Photos" section
        clickElement("Photos", "Main article", photosOR.img_mainart);

        // Scrolls the window by a certain amount using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)","");
        js.executeScript("window.scrollBy(0,1200)","");
        js.executeScript("window.scrollBy(0,2000)","");
    }

    public void Verify_ph_MorePhotos_fun() throws InterruptedException {
        // Retrieves the count of articles before clicking on "More Photos" button
        int artCount_bf = photosOR.lst_art_bf.size();
        System.out.println("Before : " + artCount_bf);

        // Clicks on the "More Photos" button
        clickElement("Photos", "More Photos", photosOR.btn_morephotos);
        Thread.sleep(2000);

        // Retrieves the count of articles after clicking on "More Photos" button
        int artCount_af = photosOR.lst_art_af.size();
        System.out.println("After : " + artCount_af);

        if (artCount_af != artCount_bf) {
            System.out.println("More Photos button functionality working as expected");
        } else {
            Assert.assertNotEquals(artCount_af, artCount_bf, "More Photos button functionality not working as expected");
        }
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void Verify_Recom_sec() {
        // Executes a JavaScript code to scroll the window to the bottom
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Moves the mouse pointer to the "Footer" link in the "Photos" section
        moveToElement("Photos", "Footer", photosOR.lnk_ftr_advus);

        // Verifies the availability of the recommended section ads element
        availableElement("Photos", "Recommended Section", "Ads", photosOR.txt_rec_sec);

        System.out.println("Title link is : " + photosOR.txt_rec_sec.getText());
    }

    public void Verify_outBrain_ads_thumb(String PageName) {
        // Creates a SoftAssert object for assertion
        SoftAssert softAssert = new SoftAssert();

        // Moves the mouse pointer to the "Footer" link in the "Photos" section
        moveToElement("Photos", "Footer", photosOR.txt_rec_sec);

        // Retrieves the count of OutBrain placeholders
        int Count = photosOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        // Iterates through each placeholder
        for (int i = 0; i < Count; i++) {
            // Prints the ID of the OutBrain placeholder
            System.err.println("OutBrain Place holder id : " + photosOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Constructs JavaScript code to get the count of elements within the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Executes the JavaScript code to get the count
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterates through each element within the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Constructs JavaScript code to get the thumbnail element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > img\")";

                    // Executes the JavaScript code to get the thumbnail element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Verifies the availability and clickability of the thumbnail element
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


    public void Verify_outBrain_ads_link(String PageName) {
        // Creates a SoftAssert object for assertion
        SoftAssert soft = new SoftAssert();

        // Moves the mouse pointer to the "Footer" link in the "Home page"
        moveToElement("Home page", "Footer", photosOR.txt_rec_sec);

        // Retrieves the count of OutBrain placeholders
        int Count = photosOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        // Iterates through each placeholder
        for (int i = 0; i < Count; i++) {
            // Prints the ID of the OutBrain placeholder
            System.err.println("OutBrain Place holder id : " + photosOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Constructs JavaScript code to get the count of elements within the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Executes the JavaScript code to get the count
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterates through each element within the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Constructs JavaScript code to get the link element
                    String jslink = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";

                    // Executes the JavaScript code to get the link element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jslink);

                    // Verifies the availability and clickability of the link element
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

    public void Verify_outBrain_ads_source(String PageName) {
        // Creates a SoftAssert object for assertion
        SoftAssert sa = new SoftAssert();

        // Moves the mouse pointer to the "Footer" link in the "Photos" page
        moveToElement("Photos", "Footer", photosOR.txt_rec_sec);

        // Retrieves the count of OutBrain placeholders
        int Count = photosOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        // Iterates through each placeholder
        for (int i = 0; i < Count; i++) {
            // Prints the ID of the OutBrain placeholder
            System.err.println("OutBrain Place holder id : " + photosOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Constructs JavaScript code to get the count of elements within the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Executes the JavaScript code to get the count
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterates through each element within the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Constructs JavaScript code to get the source link element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-source\")";

                    // Executes the JavaScript code to get the source link element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Verifies the availability and clickability of the source link element
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
