package com.applicationpages;

import com.applicationobjects.HomePageOR;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends GenericMethods {
    private static HomePageOR homePageOR;
    private static HomePage homePage;



    // Constructor for the HomePage class
    private HomePage() {
        // Print a message to the console
        System.out.println("Creating object for HOME PAGE");
    }

    // This method returns an instance of the HomePage class
    public static HomePage getInstance() {
        // Set homePage to null initially
        homePage = null;

        // Check if homePage is null
        if (homePage == null) {
            // If it is, create a new instance of HomePage
            homePage = new HomePage();

            // Initialize homePageOR using PageFactory and the driver
            homePageOR = PageFactory.initElements(driver, HomePageOR.class);
        }

        // Return the instance of HomePage
        return homePage;
    }


    // This method navigates to the "Freshscoops" section of the website.
    public void Navigate_To_freshscoops(){
        // Clicks on the "Freshscoops" header link located on the home page.
        clickElement("Home","Freshscoops header",homePageOR.lnk_hdr_fresh);

        // Compares the expected URL with the actual URL of the current page.
        String expURL="https://qa-push-web.abs-cbn.com/fresh-scoops";
        String actURL=driver.getCurrentUrl();
        if(expURL.equals(actURL)){
            // If the URLs match, print a message indicating that the page has been successfully navigated to.
            System.out.println("Navigated to Fresh Scoops section page");

            // Use JavascriptExecutor to scroll down the page to reveal more content.
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,800)","");
            js.executeScript("window.scrollBy(0,1200)","");
            js.executeScript("window.scrollBy(0,2000)","");
        }else {
            // If the URLs do not match, use the Assert library to fail the test and print an error message.
            Assert.assertEquals(actURL,expURL,"unable to navigate to Fresh Scoops section page");
        }
    }

    public void Navigate_To_photos() {
        // Click on the "Photos" link in the Freshscoops header
        clickElement("Home", "Freshscoops header", homePageOR.lnk_hdr_photos);

        // Define the expected URL for the Photos section page
        String expURL = "https://qa-push-web.abs-cbn.com/photos";
        // Get the current URL
        String actURL = driver.getCurrentUrl();

        // Compare the expected URL with the actual URL
        if (expURL.equals(actURL)) {
            System.out.println("Navigated to Photos section page");

            // Scroll the window to specific positions using JavaScriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,800)","");
            js.executeScript("window.scrollBy(0,1200)","");
            js.executeScript("window.scrollBy(0,2000)","");
        } else {
            Assert.assertEquals(actURL, expURL, "Unable to navigate to Photos section page");
        }
    }

    public void Navigate_To_videos() {
        // Click on the "Videos" link in the header
        clickElement("Home", "Videos header", homePageOR.lnk_hdr_videos);

        // Define the expected URL for the Videos section page
        String expURL = "https://qa-push-web.abs-cbn.com/videos";
        // Get the current URL
        String actURL = driver.getCurrentUrl();

        // Compare the expected URL with the actual URL
        if (expURL.equals(actURL)) {
            System.out.println("Navigated to Videos section page");

            // Scroll the window to specific positions using JavaScriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,800)","");
            js.executeScript("window.scrollBy(0,1200)","");
            js.executeScript("window.scrollBy(0,2000)","");
        } else {
            Assert.assertEquals(actURL, expURL, "Unable to navigate to Videos section page");
        }
    }

    public void Verify_push_logo() {
        // Check the availability of the Push logo image on the Home page
        availableImage("Home", "Push logo", "Push Logo", homePageOR.img_push_logo);
    }

    public void Verify_hdr_freshscoops() {
        // Check the availability of the Fresh scoops header link in the header on the Home page
        availableElement("Home", "Header links", "Fresh scoops header link", homePageOR.lnk_hdr_fresh);
    }

    public void Verify_hdr_photos() {
        // Check the availability of the Photos header link in the header on the Home page
        availableElement("Home", "Header links", "Photos header link", homePageOR.lnk_hdr_photos);
    }

    public void Verify_hdr_videos() {
        // Check the availability of the Videos header link in the header on the Home page
        availableElement("Home", "Header links", "Videos header link", homePageOR.lnk_hdr_videos);
    }

    public void select_first_thumb() {
        // Click on the first thumbnail in the Home page
        clickElement("Home", "Select first thumbnail", homePageOR.img_first_thumb);
    }

    public void Verify_img_slideshow() {
        // Check the availability of the slide show thumbnail in the carousel on the Home page
        availableImage("Home", "Carousel", "Slide show thumbnail", homePageOR.img_slideshow);
    }

    public void Verify_slideshow_link() {
        System.out.println("Title is : " + homePageOR.lnk_slideart_title.getText());
        // Check the availability of the slide show article link in the carousel on the Home page
        availableElement("Home", "Carousel", "Slide show art link", homePageOR.lnk_slideart_title);
    }

    public void Verify_fs_section() {
        // Check the availability of the Fresh scoops section on the Home page
        availableElement("Home", "Fresh scoops", "Fresh scoops section", homePageOR.txt_fs_section);
    }

    public void Verify_fs_art_thumbnail() {
        // Check the availability of the articles with thumbnails in the Fresh scoops section on the Home page
        availableImage("Home", "Fresh scoops", "Article with thumbnail", homePageOR.img_fs_art);
    }

    public void Verify_fs_art_link() {
        // Check the availability of the articles in the Fresh scoops section on the Home page
        availableElement("Home", "Fresh scoops", "Article", homePageOR.lnk_fs_art_title);
    }

    public void Verify_fs_morescoops() {
        // Check the availability of the "More Scoops" button in the Fresh scoops section on the Home page
        availableElement("Home", "Fresh scoops", "More Scoops", homePageOR.btn_morescoops);
    }


    public void Verify_pushtv_video() throws InterruptedException {
        // Move to the "Morescoops" button on the Home page
        moveToElement("Home", "Morescoops", homePageOR.btn_morescoops);

        // Switch to the "player" frame
        driver.switchTo().frame("player");

        // Click on the Push video in the Home page
        clickElement("Home", "Push video", homePageOR.vdo_pushtv);

        // Wait for 3 seconds for the video to load
        Thread.sleep(3000);

        // Move to the Push TV player on the Home page
        moveToElement("Home", "Push TV", homePageOR.player_pushtv);

        // Get the runtime of the Push TV video
        String runtime = homePageOR.txt_pushtv_video_art.getText();
        System.out.println("Runtime is: " + runtime);

        // Check if the video is playing (runtime is not 0:00)
        if (!runtime.equals("0:00")) {
            System.out.println("Push TV video is playing as expected on the Home Page");
        } else {
            Assert.assertNotEquals("0:00", runtime, "Push TV video is not playing on the Home page");
        }

        // Switch back to the default content of the page
        driver.switchTo().defaultContent();
    }

    public void Verify_pushtv_title(){
        // Check the availability of the Push TV title element on the Home page
        availableElement("Home", "Push TV", "Title", homePageOR.txt_pushtv_title);
    }

    public void Verify_pushtv_description(){
        // Check the availability of the Push TV description element on the Home page
        availableElement("Home", "Push TV", "Description", homePageOR.txt_pushtv_desciption);
    }

    public void Verify_pushtv_playlist_thumbnail(){
        // Check the availability of the Push TV playlist thumbnail image on the Home page
        availableImage("Home", "Push TV", "Playlist thumbnail", homePageOR.img_pushtv_pl_thumb);
    }

    public void Verify_pushtv_playlist_title(){
        // Check the availability of the Push TV playlist title element on the Home page
        availableElement("Home", "Push TV", "Playlist title", homePageOR.lnk_pushtv_playlists_art);
    }

    public void Verify_pushtv_playlist_hash(){
        // Check the availability of the Push TV playlist description element on the Home page
        availableElement("Home", "Push TV", "Playlist Description", homePageOR.lnk_pushtv_pl_hash);
    }

    public void Verify_pushtv_seemore(){
        // Check the availability of the "See More" button for Push TV on the Home page
        availableElement("Home", "Push TV", "See More", homePageOR.btn_pushtv_seemore);
    }

    public void Verify_trendn_section() {
        // Check the availability of the TrendingNow section element on the Home page
        availableElement("Home", "TrendingNow", "Section", homePageOR.txt_trendn_section);
    }

    public void Verify_trendn_art() {
        // Check the availability of the Trending Now articles on the Home page
        availableElement("Home", "Trending Now", "Articles", homePageOR.img_tren_art);
    }

    public void Verify_photos_section() {
        // Check the availability of the Photos section element on the Home page
        availableElement("Home", "Photos section", "Section", homePageOR.txt_photos_section);
    }

    public void Verify_photos_thumb_Art() {
        // Check the availability of the articles with thumbnails in the Photos section on the Home page
        availableImage("Home", "Photos section", "Article with thumbnail", homePageOR.img_photos_art);
    }

    public void Verify_photos_art_links() {
        // Check the availability of the article links in the Photos section on the Home page
        availableElement("Home", "Photos section", "Articles links", homePageOR.lnk_photos_art);
    }

    public void Verify_more_photos() {
        // Check the availability of the "More Photos" button in the Photos section on the Home page
        availableElement("Home", "Photos section", "More Photos", homePageOR.btn_morephotos);
    }

    public void Verify_Webstories_section() {
        // Check the availability of the Web Stories section element on the Home page
        availableElement("Home", "Web Stories section", "Section", homePageOR.txt_photos_webstories);
    }

    public void Verify_Webstories_thumb_Art() {
        // Check the availability of the articles with thumbnails in the Web Stories section on the Home page
        availableImage("Home", "Web Stories section", "Article with thumbnail", homePageOR.img_web_arts);
    }

    public void Verify_ent_section() {
        // Check the availability of the Entertainment section element on the Home page
        availableElement("Home", "Entertainment section", "Entertainment Section", homePageOR.txt_abscbn_ent_Section);
    }

    public void rdo_ent_corousel(){
        // Click on the first radio button in the Entertainment section carousel on the Home page
        clickElement("Home", "First radio button", homePageOR.rdo_ent_carousel);
    }

    public void Verify_ent_art_thumb() {
        // Check the availability of the article thumbnails in the Entertainment section on the Home page
        availableImage("Home", "Entertainment section", "Article thumbnail", homePageOR.img_ent_thumbnail);
    }

    public void Verify_ent_art_title() {
        // Check the availability of the articles in the Entertainment section on the Home page
        availableElement("Home", "Entertainment section", "Article", homePageOR.txt_ent_title);
    }

    public void Verify_ent_readmore() {
        // Check the availability of the "Read More" button in the Entertainment section on the Home page
        availableElement("Home", "Entertainment section", "Read More button", homePageOR.btn_ent_readmore);
    }

    public void Verify_push_logo_fun(){
        // Click on the "Push Logo" element on the "Home" page
        clickElement("Home","Push Logo",homePageOR.img_push_logo);

        // Get the current URL of the web page
        String actURL = driver.getCurrentUrl();

        // Define the expected URL
        String expURL = "https://qa-push-web.abs-cbn.com/";

        // Check if the actual URL matches the expected URL
        if (actURL.equals(expURL)) {
            System.out.println("Push logo Functionality is working as expected");
        } else {
            // If the URLs don't match, fail the test and provide an error message
            Assert.assertEquals(actURL,expURL,"Push logo functionality not working as expected");
        }
    }

    public void Verify_hdr_link_fun() {
        // Create a SoftAssert object to accumulate assertions
        SoftAssert softAssert=new SoftAssert();

        // Create a list to store the header links
        List hdrlinks = new ArrayList();
        hdrlinks.add(homePageOR.lnk_hdr_fresh);
        hdrlinks.add(homePageOR.lnk_hdr_photos);
        hdrlinks.add(homePageOR.lnk_hdr_videos);

        // Create a list to store the corresponding expected URLs
        List hdrURL = new ArrayList();
        hdrURL.add("https://qa-push-web.abs-cbn.com/fresh-scoops");
        hdrURL.add("https://qa-push-web.abs-cbn.com/photos");
        hdrURL.add("https://qa-push-web.abs-cbn.com/videos");

        // Iterate over the header links
        for (int i = 0; i < hdrlinks.size(); i++) {
            // Click on the current header link
            clickElement("Home", "Header links", (WebElement) hdrlinks.get(i));

            // Get the current URL of the web page
            String actURL= driver.getCurrentUrl();

            // Get the expected URL corresponding to the current header link
            String expURL=hdrURL.get(i).toString();

            // Check if the actual URL matches the expected URL
            if (actURL.equals(expURL)) {
                System.out.println(actURL + " Section page Functionality is working as expected");
            } else {
                // If the URLs don't match, accumulate the assertion error without failing the test immediately
                softAssert.assertEquals(actURL,expURL,"Section page functionality not working as expected");
            }

            // Click on the "Push Logo" element on the section page to return to the "Home" page
            clickElement("Section ", "Logo", homePageOR.img_push_logo);
        }

        // Perform all accumulated assertions and fail the test if any of the assertions failed
        softAssert.assertAll();
    }

    public void Verify_ftr_link_fun() throws InterruptedException {
        // Create a SoftAssert object to accumulate assertions
        SoftAssert softAssert = new SoftAssert();

        // Create a list to store the footer links
        List ftrlinks = new ArrayList();
        ftrlinks.add(homePageOR.lnk_ftr_terms);
        ftrlinks.add(homePageOR.lnk_ftr_privacy);
        ftrlinks.add(homePageOR.lnk_ftr_contact);
        ftrlinks.add(homePageOR.lnk_ftr_advus);

        // Create a list to store the corresponding expected URLs
        List ftrURL = new ArrayList();
        ftrURL.add("https://www.abs-cbn.com/terms?screen=terms");
        ftrURL.add("https://www.abs-cbn.com/privacy");
        ftrURL.add("https://ent.abs-cbn.com/contact-us");
        ftrURL.add("https://dash.abs-cbn.com/");

        // Iterate over the footer links
        for (int i = 0; i < ftrlinks.size(); i++) {
            // Click on the current footer link
            clickElement("Home", "Footer links", (WebElement) ftrlinks.get(i));

            // Get the current URL of the web page
            String actURL = driver.getCurrentUrl();

            // Get the expected URL corresponding to the current footer link
            String expURL = ftrURL.get(i).toString();

            // Check if the actual URL matches the expected URL
            if (actURL.equals(expURL)) {
                System.out.println(actURL + " Section page Functionality is working as expected");
            } else {
                // If the URLs don't match, accumulate the assertion error without failing the test immediately
                softAssert.assertEquals(actURL, expURL, "Section page functionality not working as expected");
            }

            // Navigate back to the previous page
            driver.navigate().back();

            // Pause execution for 5000 milliseconds (5 seconds)
            Thread.sleep(5000);
        }

        // Perform all accumulated assertions and fail the test if any of the assertions failed
        softAssert.assertAll();
    }

    public void Verify_Social_follow_fun() throws InterruptedException {
        // Create a SoftAssert object to accumulate assertions
        SoftAssert softAssert = new SoftAssert();

        // Create a list to store the social follow icons
        List socialfollow = new ArrayList();
        socialfollow.add(homePageOR.icn_fb_flw);
        socialfollow.add(homePageOR.icn_ig_flw);
        socialfollow.add(homePageOR.icn_tw_flw);
        socialfollow.add(homePageOR.icn_yt_flw);

        // Create a list to store the corresponding expected social media titles
        List socialtitle = new ArrayList();
        socialtitle.add("Push - Home | Facebook");
        socialtitle.add("Push (@pushalerts) • Instagram photos and videos");
        socialtitle.add("PUSH ALERTS (@Push_Alerts) / Twitter");
        socialtitle.add("Push - YouTube");

        // Iterate over the social follow icons
        for (int i = 0; i < socialfollow.size(); i++) {
            // Click on the current social follow icon
            clickElement("Home", "Social Follow icons", (WebElement) socialfollow.get(i));

            // Switch to the new window or tab that opened
            switchwindow();

            // Get the title of the current web page
            String actURL = driver.getTitle();

            // Get the expected social media title corresponding to the current social follow icon
            String expURL = socialtitle.get(i).toString();
            System.out.println("Title: " + actURL);

            // Check if the expected social media title contains the actual title
            if (expURL.contains(actURL)) {
                getScreenshot();
                System.out.println(actURL + " functionality is working as expected");
            } else {
                getScreenshot();
                // If the titles don't match, accumulate the assertion error without failing the test immediately
                softAssert.assertEquals(actURL, expURL, "Functionality not working as expected");
            }

            // Close the current window or tab
            driver.close();

            // Switch back to the parent window or tab
            driver.switchTo().window(Parent);

            // Pause execution for 5000 milliseconds (5 seconds)
            Thread.sleep(5000);
        }

        // Perform all accumulated assertions and fail the test if any of the assertions failed
        softAssert.assertAll();
    }

    public void verify_page_titles() throws InterruptedException {
        // Create a SoftAssert object to accumulate assertions
        SoftAssert softAssert = new SoftAssert();

        // Get the title of the current web page (Home Page)
        String acthome = driver.getTitle();
        String exphome = "PUSH";
        if (acthome.contains(exphome)) {
            System.out.println("Home Page title is matching as expected");
        } else {
            softAssert.assertEquals(acthome, exphome, "Home page title is not available/matched");
        }

        // Navigate to the Fresh Scoops page
        homePage.Navigate_To_freshscoops();

        // Get the title of the current web page (Fresh Scoops Page)
        String actfs = driver.getTitle();
        String expfs = "FRESH-SCOOPS";
        if (actfs.contains(expfs)) {
            System.out.println("Fresh Scoops Page title is matching as expected");
        } else {
            softAssert.assertEquals(actfs, expfs, "Fresh Scoops page title is not available/matched");
        }

        // Navigate back to the previous page (Home Page)
        driver.navigate().back();

        // Navigate to the Photos page
        homePage.Navigate_To_photos();

        // Get the title of the current web page (Photos Page)
        String actp = driver.getTitle();
        String expp = "PHOTOS";
        if (actp.contains(expp)) {
            System.out.println("Photos Page title is matching as expected");
        } else {
            softAssert.assertEquals(actp, expp, "Photos page title is not available/matched");
        }

        // Navigate back to the previous page (Home Page)
        driver.navigate().back();

        // Navigate to the Videos page
        homePage.Navigate_To_videos();

        // Get the title of the current web page (Videos Page)
        String actv = driver.getTitle();
        String expv = "VIDEOS";
        if (actv.contains(expv)) {
            System.out.println("Videos Page title is matching as expected");
        } else {
            softAssert.assertEquals(actv, expv, "Videos page title is not available/matched");
        }

        // Perform all accumulated assertions and fail the test if any of the assertions failed
        softAssert.assertAll();
    }



    public void Verify_Freshscoops_MouseHover_items(){
        // Create an Actions object to perform mouse hover actions
        Actions builder = new Actions(driver);

        // Move the mouse cursor to the Fresh Scoops header link
        builder.moveToElement(homePageOR.lnk_hdr_fresh).build().perform();

        // Initialize a count variable to keep track of the number of mouse hover items
        int count = 0;

        // Iterate over the Fresh Scoops mouse hover items
        for(int i = 0; i < homePageOR.dd_freshscoops_items.size(); i++){
            // Check if the current mouse hover item is available
            availableElement("Home Page", "FreshScoops ", "MouseHover items", homePageOR.dd_freshscoops_items.get(i));

            // Increment the count
            count++;

            System.out.println("Link is: " + homePageOR.dd_freshscoops_items.get(i).getText());
        }

        // Check if the count is equal to 5
        if (count == 5) {
            System.out.println("We have 5 freshscoops mouse hover items");
        } else {
            // If the count is not equal to 5, fail the test and display the actual count
            Assert.assertEquals(count, 5, "We have " + count + " items only in Fresh scoops mousehover functionality");
        }
    }

    public void Verify_Videos_MouseHover_items(){
        // Create an Actions object to perform mouse hover actions
        Actions builder = new Actions(driver);

        // Move the mouse cursor to the Videos header link
        builder.moveToElement(homePageOR.lnk_hdr_videos).build().perform();

        // Initialize a count variable to keep track of the number of mouse hover items
        int count = 0;

        // Iterate over the Videos mouse hover items
        for(int i = 0; i < homePageOR.dd_videos_items.size(); i++){
            // Check if the current mouse hover item is available
            availableElement("Home Page", "Videos ", "MouseHover items", homePageOR.dd_videos_items.get(i));

            // Increment the count
            count++;

            System.out.println("Link is: " + homePageOR.dd_videos_items.get(i).getText());
        }

        // Check if the count is equal to 5
        if (count == 5) {
            System.out.println("We have 5 videos mouse hover items");
        } else {
            // If the count is not equal to 5, fail the test and display the actual count
            Assert.assertEquals(count, 5, "We have " + count + " items only in videos mousehover functionality");
        }
    }

    public void Verify_Photos_MouseHover_items(){
        // Create an Actions object to perform mouse hover actions
        Actions builder = new Actions(driver);

        // Move the mouse cursor to the Photos header link
        builder.moveToElement(homePageOR.lnk_hdr_photos).build().perform();

        // Initialize a count variable to keep track of the number of mouse hover items
        int count = 0;

        // Iterate over the Photos mouse hover items
        for(int i = 0; i < homePageOR.dd_photos_items.size(); i++){
            // Check if the current mouse hover item is available
            availableElement("Home Page", "Photos ", "MouseHover items", homePageOR.dd_photos_items.get(i));

            // Increment the count
            count++;

            System.out.println("Link is: " + homePageOR.dd_photos_items.get(i).getText());
        }

        // Check if the count is equal to 5
        if (count == 5) {
            System.out.println("We have 5 Photos mouse hover items");
        } else {
            // If the count is not equal to 5, fail the test and display the actual count
            Assert.assertEquals(count, 5, "We have " + count + " items only in Photos mousehover functionality");
        }
    }

    public void Verify_hdr_pushawards(){
        // Check if the Push Awards header image is available
        availableImage("Home", "Header links", "Push Awards header image", homePageOR.img_push_awards);
    }

    public void Verify_txt_search(){
        // Check if the Search text box is available
        availableElement("Home", "Header ", "Search text box", homePageOR.txt_serach);
    }

    public void Verify_btn_search(){
        // Check if the Search button is available
        availableElement("Home", "Header ", "Search button", homePageOR.btn_search);
    }

    public void Verify_MoreScoops_btn_fun(){
        // Click on the More scoops button
        clickElement("Home", "More scoops button", homePageOR.btn_morescoops);

        // Define the expected title
        String expTitle = "FRESH-SCOOPS | PUSH.COM.PH";

        // Get the actual title of the current web page
        String actTitle = driver.getTitle();

        if (expTitle.equals(actTitle)) {
            System.out.println("More scoops button functionality working as expected");
        } else {
            // If the actual title is not equal to the expected title, fail the test
            Assert.assertEquals(actTitle, expTitle, "More scoops button functionality not working as expected");
        }
    }

    public void Verify_SeeMore_btn_fun(){
        // Click on the See More button
        clickElement("Home", "See More button", homePageOR.btn_pushtv_seemore);

        // Define the expected title
        String expTitle = "VIDEOS | PUSH.COM.PH";

        // Get the actual title of the current web page
        String actTitle = driver.getTitle();

        if (expTitle.equals(actTitle)) {
            System.out.println("See More button functionality working as expected");
        } else {
            // If the actual title is not equal to the expected title, fail the test
            Assert.assertEquals(actTitle, expTitle, "See More button functionality not working as expected");
        }
    }

    public void Verify_MorePhotos_btn_fun(){
        // Click on the More Photos button
        clickElement("Home", "More Photos button", homePageOR.btn_morephotos);

        // Define the expected title
        String expTitle = "PHOTOS | PUSH.COM.PH";

        // Get the actual title of the current web page
        String actTitle = driver.getTitle();

        if (expTitle.equals(actTitle)) {
            System.out.println("More Photos button functionality working as expected");
        } else {
            // If the actual title is not equal to the expected title, fail the test
            Assert.assertEquals(actTitle, expTitle, "More Photos button functionality not working as expected");
        }
    }

    public void Verify_TellmeMore_fun(){
        // Click on the Tell me more link
        clickElement("Home", "Tell me more", homePageOR.lnk_tellme_more);

        // Switch to the new window
        switchwindow();

        // Define the expected URL
        String expUrl = "https://www.abs-cbn.com/privacy";

        // Get the actual URL of the current web page
        String actUrl = driver.getCurrentUrl();

        System.out.println("Actual : " + actUrl);

        if (expUrl.equals(actUrl)) {
            System.out.println("Tell me more! link is working as expected");
        } else {
            // If the actual URL is not equal to the expected URL, fail the test and take a screenshot
            getScreenshot();
            Assert.assertEquals(actUrl, expUrl, "Tell me more! link is not working as expected");
        }
    }

    public void Verify_IAgree_btn(){
        // Check the availability of the "I Agree" Cookie button in the footer section
        availableElement("Home", "footer", "I Agree Cookie button", homePageOR.btn_ftr_iagree);
    }

    public void Navigate_To_PushAwards(){
        // Navigate to the Push Awards section page
        driver.navigate().to("https://qa-push-web.abs-cbn.com/push-awards");

        // Define the expected URL
        String expURL = "https://qa-push-web.abs-cbn.com/push-awards";

        // Get the actual URL of the current web page
        String actURL = driver.getCurrentUrl();

        if (expURL.equals(actURL)) {
            System.out.println("Navigated to Push Awards section page");
        } else {
            // If the actual URL is not equal to the expected URL, fail the test
            Assert.assertEquals(actURL, expURL, "Unable to navigate to Push Awards section page");
        }
    }

    public void Verify_Webstories(){
        // Move to the "Trending now" element on the Home page
        moveToElement("Home page", "Trending now", homePageOR.txt_trendn_section);

        // Click on the Web stories articles
        clickElement("Home", "Web stories articles", homePageOR.img_web_arts);

        // Get the title of the current web page
        String title = driver.getTitle();

        System.out.println("Title is : " + title);

        if (title.contains("webstory")) {
            System.out.println("Home page is redirecting to Web stories inner page");
        } else {
            // If the title doesn't contain "webstory", fail the test
            Assert.assertEquals(true, title.contains("web stories"), "Home page is not redirecting to Web stories inner page");
        }
    }

    public void Verify_Webstories_rightArrow(){
        // Check the availability of the right icon in the Web Stories Inner page for navigating to the next story
        availableElement("Web Stories Inner", "Web stories articles", "Right icon", homePageOR.icn_webstory_next);
    }

    public void Verify_Webstories_leftArrow(){
        // Click on the right arrow icon in the Web Stories Inner page to navigate to the next story
        clickElement("Web Stories Inner", "Right arrow", homePageOR.icn_webstory_next);

        // Check the availability of the left icon in the Web Stories Inner page for navigating to the previous story
        availableElement("Web Stories Inner", "Web stories articles", "Left icon", homePageOR.icn_webstory_prev);
    }

    public void Verify_Webstories_share(){
        // Check the availability of the Share button in the Web Stories Inner page
        availableElement("Web Stories Inner", "Web stories articles", "Share button", homePageOR.btn_webstory_share);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        // Scroll to the bottom of the page using JavaScriptExecutor
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Move to the Footer section on the Home page
        moveToElement("Home page", "Footer", homePageOR.lnk_ftr_advus);

        // Check the availability of the Ads in the Recommended Section on the Home page
        availableElement("Home", "Recommended Section", "Ads", homePageOR.txt_rec_sec);

        System.out.println("Title link is: " + homePageOR.txt_rec_sec.getText());
    }

    public void Verify_outBrain_ads_thumb(String PageName){
        // Create a SoftAssert object for performing soft assertions
        SoftAssert softAssert = new SoftAssert();

        // Move to the Footer section on the Home page
        moveToElement("Home page", "Footer", homePageOR.txt_rec_sec);

        // Get the count of placeholders
        int Count = homePageOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        for(int i=0; i<Count; i++) {
            System.err.println("OutBrain Placeholder ID: " + homePageOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Generate JavaScript code to count the number of elements in the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            for (int j = 0; j < elementCount; j++) {
                try {
                    // Generate JavaScript code to select the thumbnail element in the placeholder
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > img\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the thumbnail is clickable
                    boolean status = elementClickable(PageName, "Recommended section", "OutBrain ads thumbnail of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

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

        // Perform the soft assertions
        softAssert.assertAll();
    }

    public void Verify_outBrain_ads_link(String PageName){
        // Create a SoftAssert object for performing soft assertions
        SoftAssert soft = new SoftAssert();

        // Move to the Footer section on the Home page
        moveToElement("Home page", "Footer", homePageOR.txt_rec_sec);

        // Get the count of placeholders
        int Count = homePageOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        for(int i=0; i<Count; i++) {
            System.err.println("OutBrain Placeholder ID: " + homePageOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Generate JavaScript code to count the number of elements in the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            for (int j = 0; j < elementCount; j++) {
                try {
                    // Generate JavaScript code to select the link element in the placeholder
                    String jslink = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jslink);

                    // Check if the link is clickable
                    boolean status = elementClickable(PageName, "Recommended section", "OutBrain ads link of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

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

        // Perform the soft assertions
        soft.assertAll();
    }

    public void Verify_outBrain_ads_source(String PageName){
        // Create a SoftAssert object for performing soft assertions
        SoftAssert sa = new SoftAssert();

        // Move to the Footer section on the Home page
        moveToElement("Home page", "Footer", homePageOR.txt_rec_sec);

        // Get the count of placeholders
        int Count = homePageOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        for(int i=0; i<Count; i++) {
            System.err.println("OutBrain Placeholder ID: " + homePageOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Generate JavaScript code to count the number of elements in the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            for (int j = 0; j < elementCount; j++) {
                try {
                    // Generate JavaScript code to select the source link element in the placeholder
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-source\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the source link is clickable
                    boolean status = elementClickable(PageName, "Recommended section", "OutBrain ads source link of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

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

        // Perform the soft assertions
        sa.assertAll();
    }

    public void Verify_Webstories_NextArtarrow() {
        // Check the availability of the next article arrow in the Web Stories Inner section
        availableElement("Web Stroies Inner", "Webstories articles", "Next article arrow", homePageOR.btn_webstory_nextArt);
    }

    public void Verify_Webstories_prevArtarrow() {
        // Click on the next article arrow in the Web Stories Inner section
        clickElement("Web Stroies Inner", "Next article arrow", homePageOR.btn_webstory_nextArt);
        // Check the availability of the previous article arrow in the Web Stories Inner section
        availableElement("Web Stroies Inner", "Webstories articles", "Previous article arrow", homePageOR.btn_webstory_prevArt);
    }

    public void Verify_Webstories_Close() {
        // Check the availability of the close button in the Web Stories Inner section
        availableElement("Web Stroies Inner", "Webstories articles", "Close button", homePageOR.img_webstory_close);
    }

    public void Verify_Webstories_launchart() {
        // Check the availability of the launch icon in the Web Stories Inner section
        availableElement("Web Stroies Inner", "Webstories articles", "Launch icon", homePageOR.icn_webstory_launch);
    }

    public void Verify_Webstories_Close_fun() {
        // Get the current URL of the page
        String curURL = driver.getCurrentUrl();
        // Click on the close button in the Web Stories section
        clickElement("Web Stories", "Close button", homePageOR.img_webstory_close);
        // Get the updated URL after closing the Web Stories
        String actURL = driver.getCurrentUrl();

        // Compare the current URL with the updated URL
        if (actURL.equals(curURL)) {
            // Assert that the updated URL is not equal to the current URL, with an error message if they are equal
            Assert.assertNotEquals(actURL, curURL, "Web Stories close functionality not working as expected");
        } else {
            System.out.println("Web Stories close functionality working as expected");
        }
    }

    public void Verify_Search() {
        // Check the availability of the search text box on the Home page
        availableElement("Home", "Search", "Search text box", homePageOR.inp_search);
    }

    public void Verify_Search_icon() {
        // Check the availability of the search icon on the Home page
        availableElement("Home", "Search", "Search icon", homePageOR.icn_search);
    }

    public void Verify_Search_fun(String searchKey) throws InterruptedException {
        // Print the search key being used
        System.out.println("We are searching with the " + searchKey + " keyword/letter/character/Special character");

        // Initialize the searchk variable
        String searchk = "";

        // Enter the search key in the search input field
        homePageOR.inp_search.sendKeys(searchKey);

        // Click on the search icon
        clickElement("Home", "Search icon", homePageOR.icn_search);

        // Pause execution for 3000 milliseconds (3 seconds)
        Thread.sleep(3000);

        // Modify the search key if it contains spaces, plus signs, or equal signs
        if (searchKey.contains(" ")) {
            searchk = searchKey.replace(" ", "+");
            System.out.println(searchk);
        } else if (searchKey.contains("+")) {
            searchk = searchKey.replace("+", "%2B");
            System.out.println(searchk);
        } else if (searchKey.contains("=")) {
            searchk = searchKey.replace("=", "%3");
            System.out.println(searchk);
        } else {
            searchk = searchKey;
            System.out.println(searchk);
        }

        // Get the actual URL of the current page
        String actURL = driver.getCurrentUrl();

        // Construct the expected URL based on the modified search key
        String expURL = "https://qa-push-web.abs-cbn.com/search?q=" + searchk;

        // Compare the actual URL with the expected URL
        if (actURL.equals(expURL)) {
            System.out.println("Search functionality working as expected");
        } else {
            // Assert that the actual URL matches the expected URL, with an error message if they don't match
            Assert.assertEquals(actURL, expURL, "Search functionality not working as expected");
        }
    }

}