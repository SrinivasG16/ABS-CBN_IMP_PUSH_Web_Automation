package com.applicationpages;

import com.applicationobjects.PushAwardsOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PushAwards extends GenericMethods {

    private static PushAwardsOR pushAwardsOR;
    private static PushAwards pushAwards;


    // Private constructor to prevent direct instantiation of the class
    private PushAwards() {
        System.out.println("Creating object for Push Awards PAGE");
    }

    // Public method to get the instance of PushAwards class
    public static PushAwards getInstance() {
        pushAwards = null;

        // Check if the instance is not already created
        if (pushAwards == null) {
            // Create a new instance of PushAwards
            pushAwards = new PushAwards();

            // Initialize the PageFactory elements for the PushAwardsOR class
            pushAwardsOR = PageFactory.initElements(driver, PushAwardsOR.class);
        }

        // Return the instance of PushAwards
        return pushAwards;
    }

    // Select the first thumbnail on the Push Awards page
    public void select_first_thumb(){
        // PageScrollbyJS(PushAwardsOR.txt_pushawards_sec);
        clickElement("Push Awards", "Select first thumbnail", pushAwardsOR.img_first_thumb);
    }

    // Verify the image slideshow on the Push Awards page
    public void Verify_img_slideshow(){
        availableImage("Push Awards", "Carousel", "slide show thumbnail", pushAwardsOR.img_slideshow);
    }

    // Verify the slideshow link on the Push Awards page
    public void Verify_slideshow_link(){
        System.out.println("Title is : " + pushAwardsOR.lnk_hero_carousel.getText());
        availableElement("Push Awards", "Carousel", "slide show art link", pushAwardsOR.lnk_hero_carousel);
    }

    // Verify the slide article post date on the Push Awards page
    public void Verify_slideart_pdate(){
        availableElement("Push Awards", "Carousel", "slider article post date", pushAwardsOR.txt_hero_carousel_pdate);
    }

    // Verify the carousel section description on the Push Awards page
    public void Verify_carousel_sec_desription(){
        availableElement("Push Awards", "Carousel", "description", pushAwardsOR.txt_hero_carousel_desc);
    }

    // Verify the Push Awards section on the home page
    public void Verify_pushAwards_section() {
        availableElement("Home", "Push Awards", "Section", pushAwardsOR.txt_pushawards_sec);
    }

    // Verify the Push Awards article with thumbnail on the home page
    public void Verify_pushAwards_thumb_Art() {
        availableImage("Home", "Push Awards", "Article with thumbnail", pushAwardsOR.img_pushawards_thumb);
    }

    // Verify the Push Awards articles links on the home page
    public void Verify_pushAwards_art_links() {
        availableElement("Home", "Push Awards", "Articles links", pushAwardsOR.lnk_pushawards_art);
    }

    // Verify the Push Awards video on the Push Awards page
    public void Verify_pushawards_video() throws InterruptedException {
        // Switch to the video frame using the frame name or ID
        driver.switchTo().frame("player-E1SF04nWIhM");

        // Click on the Push video element
        clickElement("Push Awards", "Push video", pushAwardsOR.btn_pushawrads_vdo);

        // Pause the execution for 3000 milliseconds
        Thread.sleep(3000);

        // Move the mouse to the Push TV element
        moveToElement("Push Awards", "Push TV", pushAwardsOR.player_pushawards);

        // Get the runtime of the video
        String runtime = pushAwardsOR.txt_pushawards_video_art.getText();
        System.out.println("Runtime is: " + runtime);

        // Check if the runtime is not equal to "0:00"
        if (!runtime.equals("0:00")) {
            System.out.println("PUSH TV video is playing as expected on the Home Page");
        } else {
            // If the runtime is "0:00", fail the assertion
            Assert.assertNotEquals("0:00", runtime, "Push TV video is not playing on the Home page");
        }

        // Switch back to the default content (outside the frame)
        driver.switchTo().defaultContent();
    }

    // Verify the Push Awards title on the Push Awards page
    public void Verify_pushawards_title(){
        availableElement("Push Awards", "Push TV", "Title", pushAwardsOR.txt_pushawards_title);
    }

    // Verify the Push Awards description on the Push Awards page
    public void Verify_pushawards_description(){
        availableElement("Push Awards", "Push TV", "Description", pushAwardsOR.txt_pushawards_desciption);
    }

    // Verify the Push Awards playlist thumbnail on the Push Awards page
    public void Verify_pushawards_playlist_thumbnail(){
        availableImage("Push Awards", "Push TV", "Playlist thumbnail", pushAwardsOR.img_pushawards_pl_thumb);
    }

    // Verify the Push Awards playlist title on the Push Awards page
    public void Verify_pushawards_playlist_title(){
        availableElement("Push Awards", "Push TV", "Playlist title", pushAwardsOR.lnk_pushawards_playlists_art);
    }

    // Verify the Push Awards playlist hash on the Push Awards page
    public void Verify_pushawards_playlist_hash(){
        availableElement("Push Awards", "Push TV", "Playlist Description", pushAwardsOR.lnk_pushawards_pl_hash);
    }

    // Verify the Push Awards "See More" button on the Push Awards page
    public void Verify_pushawards_seemore(){
        availableElement("Push Awards", "Push TV", "See More", pushAwardsOR.btn_pushawards_seemore);
    }

    // Verify the Trending Now section on the Push Awards page
    public void Verify_trendn_section() {
        availableElement("Push Awards", "Trending Now", "Section", pushAwardsOR.txt_trendn_section);
    }

    // Verify the Trending Now articles on the Push Awards page
    public void Verify_trendn_art() {
        availableElement("Push Awards", "Trending Now", "Articles", pushAwardsOR.img_tren_art);
    }

    // Verify the Web Stories section on the Push Awards page
    public void Verify_Webstories_section() {
        availableElement("Push Awards", "Web Stories section", "Section", pushAwardsOR.txt_photos_webstories);
    }

    // Verify the Web Stories article with thumbnail on the Push Awards page
    public void Verify_Webstories_thumb_Art() {
        availableImage("Push Awards", "Web Stories section", "Article with thumbnail", pushAwardsOR.img_web_arts);
    }

    // Verify the inner link functionality of Push Awards
    public void Verify_pushAwards_innerlnik(){
        // Get the expected title of the article
        String expTitle = pushAwardsOR.lnk_pushawards_art.getText();

        // Click on the Push Awards article link
        clickElement("Push Awards", "Push awards article link", pushAwardsOR.lnk_pushawards_art);

        // Get the actual title of the current page
        String actTitle = driver.getTitle();

        // Print the URL of the current page
        System.out.println("URL: " + driver.getCurrentUrl());

        // Check if the actual title contains the expected title
        if (actTitle.contains(expTitle)) {
            System.out.println("Successfully navigating to Push Awards inner page. Push Awards inner page is working as expected.");
        } else {
            Assert.assertEquals(actTitle, expTitle, "Unable to navigate to Push Awards inner page. Push Awards inner page is not working as expected.");
        }
    }

    // Verify the inner thumbnail functionality of Push Awards
    public void Verify_pushAwards_innerthumb(){
        // Get the expected title of the article
        String expTitle = pushAwardsOR.lnk_pushawards_art.getText();

        // Click on the Push Awards article thumbnail
        clickElement("Push Awards", "Push awards article link", pushAwardsOR.img_pushawards_thumb);

        // Get the actual title of the current page
        String actTitle = driver.getTitle();

        // Print the URL of the current page
        System.out.println("URL: " + driver.getCurrentUrl());

        // Check if the actual title contains the expected title
        if (actTitle.contains(expTitle)) {
            System.out.println("Successfully navigating to Push Awards inner page. Push Awards inner page is working as expected.");
        } else {
            Assert.assertEquals(actTitle, expTitle, "Unable to navigate to Push Awards inner page. Push Awards inner page is not working as expected.");
        }
    }

    // Verify the functionality of the "See More" button
    public void Verify_seemore_btn_fun() throws InterruptedException {
        // Get the count of articles before clicking the "See More" button
        int artCount_bf = pushAwardsOR.lst_pushawards_playlists_bf.size();
        System.out.println("Before: " + artCount_bf);

        // Click on the "More Photos" button
        clickElement("FreshScoops", "More Photos", pushAwardsOR.btn_pushawards_seemore);
        Thread.sleep(2000);

        // Get the count of articles after clicking the "See More" button
        int artCount_af = pushAwardsOR.lst_pushawards_playlists_af.size();
        System.out.println("After: " + artCount_af);

        // Check if the article count after clicking is not equal to the count before clicking
        if (artCount_af != artCount_bf) {
            System.out.println("See More button functionality working as expected.");
        } else {
            Assert.assertNotEquals(artCount_af, artCount_bf, "See More button functionality not working as expected.");
        }
    }

    // Verify the inner link functionality of Trending Now articles
    public void Verify_trendNow_innerlnik(){
        // Get the expected title of the article
        String expTitle = pushAwardsOR.lnk_tren_art.getText();

        // Click on the Trending Now article link
        clickElement("Push Awards", "Push awards article link", pushAwardsOR.lnk_tren_art);

        // Get the actual title of the current page
        String actTitle = driver.getTitle();

        // Print the URL of the current page
        System.out.println("URL: " + driver.getCurrentUrl());

        // Check if the actual title contains the expected title
        if (actTitle.contains(expTitle)) {
            System.out.println("Successfully navigating to trending now articles inner page. Trending now articles inner page is working as expected.");
        } else {
            Assert.assertEquals(actTitle, expTitle, "Unable to navigate to trending now articles inner page. Trending now articles inner page is not working as expected.");
        }
    }

    // Verify the inner thumbnail functionality of Trending Now articles
    public void Verify_trendNow_innerthumb(){
        // Get the expected title of the article
        String expTitle = pushAwardsOR.lnk_tren_art.getText();

        // Click on the Trending Now article thumbnail
        clickElement("Push Awards", "Push awards article link", pushAwardsOR.img_tren_art);

        // Get the actual title of the current page
        String actTitle = driver.getTitle();

        // Print the URL of the current page
        System.out.println("URL: " + driver.getCurrentUrl());

        // Check if the actual title contains the expected title
        if (actTitle.contains(expTitle)) {
            System.out.println("Successfully navigating to trending now articles inner page. Trending now articles inner page is working as expected.");
        } else {
            Assert.assertEquals(actTitle, expTitle, "Unable to navigate to trending now articles inner page. Trending now articles inner page is not working as expected.");
        }
    }

    JavascriptExecutor js =(JavascriptExecutor) driver;

    // Verify the Recommended section in Push Awards
    public void Verify_Recom_sec(){
        // Scroll to the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Move to the footer section
        moveToElement("Push Awards", "Footer", pushAwardsOR.lnk_ftr_advus);

        // Check the availability of the Recommended Section ads
        availableElement("Push Awards", "Recommended Section", "Ads", pushAwardsOR.txt_rec_sec);

        // Print the title link of the Recommended Section
        System.out.println("Title link is: " + pushAwardsOR.txt_rec_sec.getText());
    }

    // Verify the OutBrain ads thumbnails in the recommended section
    public void Verify_outBrain_ads_thumb(String PageName){
        // Create a SoftAssert object to accumulate all assertions
        SoftAssert softAssert = new SoftAssert();

        // Move to the footer section
        moveToElement("Push Awards", "Footer", pushAwardsOR.txt_rec_sec);

        // Get the count of placeholders in the recommended section
        int Count = pushAwardsOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders");

        // Iterate through each placeholder
        for (int i = 0; i < Count; i++) {
            System.err.println("OutBrain Placeholder ID: " + pushAwardsOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Build JavaScript code to get the count of elements in the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container > div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterate through each element in the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Build JavaScript code to access the thumbnail element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > img\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the thumbnail element is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads thumbnail of placeholder no. " + (i + 1) + " and position of " + (j + 1), shadowRoot);
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

        // Perform all the assertions accumulated by the SoftAssert object
        softAssert.assertAll();
    }

    // Verify the OutBrain ads links in the recommended section
    public void Verify_outBrain_ads_link(String PageName){
        // Create a SoftAssert object to accumulate all assertions
        SoftAssert soft = new SoftAssert();

        // Move to the footer section
        moveToElement("Home page", "Footer", pushAwardsOR.txt_rec_sec);

        // Get the count of placeholders in the recommended section
        int Count = pushAwardsOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders");

        // Iterate through each placeholder
        for (int i = 0; i < Count; i++) {
            System.err.println("OutBrain Placeholder ID: " + pushAwardsOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Build JavaScript code to get the count of elements in the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container > div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterate through each element in the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Build JavaScript code to access the link element
                    String jslink = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jslink);

                    // Check if the link element is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads link of placeholder no. " + (i + 1) + " and position of " + (j + 1), shadowRoot);
                    if (status == true) {
                        System.out.println("Link placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                        System.out.println("Link is: " + shadowRoot.getText());
                    } else {
                        soft.assertEquals(status, true, "Link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    System.err.println("Link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }

        // Perform all the assertions accumulated by the SoftAssert object
        soft.assertAll();
    }

    // Verify the source links of OutBrain ads in the recommended section
    public void Verify_outBrain_ads_source(String PageName){
        // Create a SoftAssert object to accumulate all assertions
        SoftAssert sa = new SoftAssert();

        // Move to the footer section
        moveToElement("Push Awards", "Footer", pushAwardsOR.txt_rec_sec);

        // Get the count of placeholders in the recommended section
        int Count = pushAwardsOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders");

        // Iterate through each placeholder
        for (int i = 0; i < Count; i++) {
            System.err.println("OutBrain Placeholder ID: " + pushAwardsOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Build JavaScript code to get the count of elements in the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container > div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterate through each element in the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Build JavaScript code to access the source link element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-source\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the source link element is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads source link of placeholder no. " + (i + 1) + " and position of " + (j + 1), shadowRoot);
                    if (status == true) {
                        System.out.println("Source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                        System.out.println("Source Link is: " + shadowRoot.getText());
                    } else {
                        sa.assertEquals(status, true, "Source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    System.err.println("Source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }

        // Perform all the assertions accumulated by the SoftAssert object
        sa.assertAll();
    }






}
