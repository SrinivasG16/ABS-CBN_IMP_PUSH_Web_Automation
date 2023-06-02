package com.applicationpages;


import com.applicationobjects.VideosOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Videos extends GenericMethods {
    private static VideosOR videosOR;
    private static Videos videos;

    private Videos() {
        // Constructor for the Videos class
        // This constructor is private, meaning it can only be accessed within the class itself
        System.out.println("Creating object for Videos PAGE");
    }

    public static Videos getInstance() {
        // Static method to get an instance of the Videos class
        // This method can be accessed without creating an object of the Videos class

        // Set the videos variable to null
        videos = null;

        // Check if videos is null
        if (videos == null) {
            // If videos is null, create a new instance of the Videos class
            videos = new Videos();

            // Initialize the videosOR object using the PageFactory class
            // This initializes the object repository (videosOR) with the web elements from the driver
            videosOR = PageFactory.initElements(driver, VideosOR.class);
        }

        // Return the videos instance
        return videos;
    }

    public void Verify_videos_section(){
        // Verify the availability of the "Videos" sub section
        availableElement("Videos", "Videos", "Videos Sub section", videosOR.txt_vid_section);
    }

    public void Verify_main_art_thumb(){
        // Verify the availability of the main article thumbnail in the "Videos" section
        availableImage("Videos", "Main article", "Article with thumbnail", videosOR.img_mainart);
    }

    public void Verify_main_art_link(){
        // Verify the availability of the main article link in the "Videos" section
        availableElement("Videos", "Main article", "Article", videosOR.lnk_mainart);
    }

    public void Verify_trendnow_section(){
        // Verify the availability of the "Trending now" sub section in the "Videos" section
        availableElement("Videos", "Trending now", "Sub section", videosOR.txt_trending_sub);
    }

    public void Verify_trendnow_art(){
        // Verify the availability of a trending article in the "Trending now" section
        availableElement("Videos", "Trending now", "Article", videosOR.lnk_tren_art);
    }

    public void Verify_trendnow_art_pdate(){
        // Verify the availability of the article post date in the trending articles of the "Trending now" section
        availableElement("Videos", "Trending now", "article post date", videosOR.txt_tren_art_pdate);
    }

    public void Verify_trendnow_art_num(){
        // Verify the availability of the article number in the trending articles of the "Trending now" section
        availableElement("Videos", "Trending now", "article number", videosOR.txt_tren_art_num);
    }

    public void Verify_latpho_section(){
        // Verify the availability of the "Latest Photo" sub section in the "Videos" section
        availableElement("Videos", "Latest Photo", "Sub section", videosOR.txt_latphotos_sec);
    }

    public void Verify_latpho_art_thumb(){
        // Verify the availability of the article thumbnail in the "Latest Photo" section
        availableImage("Videos", "Latest Photo", "Article with thumbnail", videosOR.img_latpho_art_thumb);
    }

    public void Verify_latpho_art(){
        // Verify the availability of an article in the "Latest Photo" section
        availableElement("Videos", "Latest Photo", "Article", videosOR.lnk_latpho_art);
    }

    public void Verify_morevideos(){
        // Verify the availability of the "More Videos" button in the "Videos" section
        availableElement("Videos", "More Videos", "More videos button", videosOR.btn_morevideos);
    }



    public void Verify_pushtv_video(){
        // Switch to the "player" frame
        driver.switchTo().frame("player");
        // Move to the "Push TV" element in the "Videos" section
        moveToElement("Videos", "Push TV", videosOR.player_pushtv);
        // Get the runtime of the Push TV video
        String runtime = videosOR.txt_pushtv_video_art.getText();
        // Check if the runtime is "0:00" (indicating that the video is not playing by default)
        if(runtime.equals("0:00")){
            // If the video is not playing by default, assert that the runtime is not "0:00"
            Assert.assertNotEquals("0:00", runtime, "Push TV video is not playing by default on the videos page");
        }else {
            // If the video is playing as expected, print a success message
            System.out.println("PUSH TV video is playing as expected on the videos page");
        }
        // Switch back to the default content (outside the frame)
        driver.switchTo().defaultContent();
    }

    public void Verify_pushtv_title(){
        // Verify the availability of the "Push TV" title element in the "Videos" section
        availableElement("Videos", "Push TV", "Title", videosOR.txt_pushtv_title);
    }

    public void Verify_pushtv_description(){
        // Verify the availability of the "Push TV" description element in the "Videos" section
        availableElement("Videos", "Push TV", "Description", videosOR.txt_pushtv_desciption);
    }

    public void Verify_pushtv_playlist_thumbnail(){
        // Verify the availability of the "Push TV" playlist thumbnail image in the "Videos" section
        availableImage("Videos", "Push TV", "Playlist thumbnail", videosOR.img_pushtv_pl_thumb);
    }

    public void Verify_pushtv_playlist_title(){
        // Verify the availability of the "Push TV" playlist title element in the "Videos" section
        availableElement("Videos", "Push TV", "Playlist title", videosOR.lnk_pushtv_playlists_art);
    }

    public void Verify_pushtv_playlist_hash(){
        // Verify the availability of the "Push TV" playlist description element in the "Videos" section
        availableElement("Videos", "Push TV", "Playlist Description", videosOR.lnk_pushtv_pl_hash);
    }

    public void Verify_pushtv_seemore(){
        // Verify the availability of the "Push TV" "See More" button in the "Videos" section
        availableElement("Videos", "Push TV", "See More", videosOR.btn_pushtv_seemore);
    }

    public void Navigate_To_VideoArticleinner(){
        // Click on the "Main article" image in the "Videos" section to navigate to the video article inner page
        clickElement("Videos", "Main article", videosOR.img_mainart);
    }

    public void Verify_recently_section(){
        // Verify the availability of the "Recently" sub section element in the "Videos" section
        availableElement("Videos", "Recently", "Sub section", videosOR.txt_recently_sec);
    }

    public void Verify_recently_art_thumb(){
        // Verify the availability of the "Recently" article with thumbnail image in the "Videos" section
        availableImage("Videos", "Recently", "Article with thumbnail", videosOR.img_rec_art_thumb);
    }

    public void Verify_recently_art(){
        // Verify the availability of the "Recently" article element in the "Videos" section
        availableElement("Videos", "Recently", "Article", videosOR.lnk_rec_art);
    }

    public void Verify_vd_MoreVideos_fun() throws InterruptedException {
        // Get the count of articles before clicking "More Videos"
        int artCount_bf = videosOR.lst_art_bf.size();
        System.out.println("Before: " + artCount_bf);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll the page to specific positions using JavaScriptExecutor
        js.executeScript("window.scrollBy(0,800)", "");
        js.executeScript("window.scrollBy(0,1200)", "");
        js.executeScript("window.scrollBy(0,2000)", "");

        // Click on the "More Videos" button
        clickElement("Videos", "More Videos", videosOR.btn_morevideos);
        Thread.sleep(2000);
        // Get the count of articles after clicking "More Videos"
        int artCount_af = videosOR.lst_art_af.size();
        System.out.println("After: " + artCount_af);

        if (artCount_af != artCount_bf) {
            System.out.println("More Videos button functionality working as expected");
        } else {
            Assert.assertNotEquals(artCount_af, artCount_bf, "More Videos button functionality not working as expected");
        }
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        // Scroll the page to the bottom using JavaScriptExecutor
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        // Move to the "Footer" section
        moveToElement("Videos", "Footer", videosOR.lnk_ftr_advus);
        // Verify the availability of the recommended section ads element
        availableElement("Videos", "Recommended Section", "Ads", videosOR.txt_rec_sec);

        System.out.println("Title link is: " + videosOR.txt_rec_sec.getText());
    }

    public void Verify_outBrain_ads_thumb(String PageName) {
        // Create a SoftAssert object to collect assertions without failing immediately
        SoftAssert softAssert = new SoftAssert();

        // Move to the specified element on the Videos page
        moveToElement("Videos", "Footer", videosOR.txt_rec_sec);

        // Get the count of OutBrain placeholders
        int Count = videosOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        // Iterate through each OutBrain placeholder
        for (int i = 0; i < Count; i++) {
            // Print the ID of the OutBrain placeholder
            System.err.println("OutBrain Place holder id: " + videosOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Construct JavaScript code to get the count of elements within each placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterate through each element within the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Construct JavaScript code to select the thumbnail element within each placeholder
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > img\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Verify if the thumbnail element is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads thumbnail of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

                    if (status == true) {
                        // Print the availability of the thumbnail placeholder
                        System.out.println("Thumbnail placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                    } else {
                        // Assert that the thumbnail placeholder is not available or loaded
                        softAssert.assertEquals(status, true, "Thumbnail placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    // Print an error message if the thumbnail placeholder is not available or loaded
                    System.err.println("Thumbnail placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }

        // Assert all the collected soft assertions
        softAssert.assertAll();
    }


    public void Verify_outBrain_ads_link(String PageName) {
        // Create a SoftAssert object to collect assertions without failing immediately
        SoftAssert soft = new SoftAssert();

        // Move to the specified element on the Home page
        moveToElement("Home page", "Footer", videosOR.txt_rec_sec);

        // Get the count of recommendation widgets
        int Count = videosOR.cou_rec_widgets.size();
        System.out.println("We have " + Count + " placeholders ");

        // Iterate through each recommendation widget
        for (int i = 0; i < Count; i++) {
            // Print the ID of the OutBrain placeholder
            System.err.println("OutBrain Place holder id: " + videosOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Construct the JavaScript code to get the count of elements within the widget
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Execute the JavaScript code and get the element count
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterate through each element within the widget
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Construct the JavaScript code to find the link element within the widget
                    String jslink = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";

                    // Execute the JavaScript code and get the link element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jslink);

                    // Check if the link element is clickable
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads link of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

                    if (status == true) {
                        // Print the availability of the link placeholder
                        System.out.println("Link placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                        System.out.println("Link is: " + shadowRoot.getText());
                    } else {
                        // Assert that the link placeholder is not available or loaded
                        soft.assertEquals(status, true, "Link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    // Print an error message if the link placeholder is not available or loaded
                    System.err.println("Link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }

        // Assert all the collected soft assertions
        soft.assertAll();
    }

    public void Verify_outBrain_ads_source(String PageName){
        // Create a SoftAssert object for accumulating verification failures
        SoftAssert sa = new SoftAssert();

        // Move to the "Footer" section of the "Videos" page
        moveToElement("Videos","Footer",videosOR.txt_rec_sec);

        // Get the count of placeholders in the recommended section
        int Count = videosOR.cou_rec_widgets.size();

        // Print the count of placeholders
        System.out.println("We have " + Count + " placeholders ");

        // Iterate through each placeholder
        for(int i = 0; i < Count; i++) {
            // Print the ID of the current placeholder
            System.err.println("OutBrain Place holder id : " + videosOR.cou_rec_widgets.get(i).getAttribute("id"));

            // Construct JavaScript code to get the count of elements within the placeholder
            String listCount = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";

            // Execute the JavaScript code and retrieve the element count
            long elementCount = (long) js.executeScript("return " + listCount);

            // Iterate through each element within the placeholder
            for (int j = 0; j < elementCount; j++) {
                try {
                    // Construct JavaScript code to retrieve the OutBrain ads source link element
                    String jsthumb = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-source\")";

                    // Execute the JavaScript code and retrieve the OutBrain ads source link element
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);

                    // Check if the source link is clickable and verify it
                    boolean status = elementClickable(PageName, "recommended section", "OutBrain ads source link of placeholder no of " + (i + 1) + " and position of " + (j + 1), shadowRoot);

                    // If the source link is available and clickable, print the information
                    if(status == true) {
                        System.out.println("source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is available");
                        System.out.println("Source Link is: " + shadowRoot.getText());
                    } else {
                        // If the source link is not available or not clickable, fail the verification
                        sa.assertEquals(status, true, "source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                    }
                } catch (Exception e) {
                    // Catch any exceptions that occur and print an error message
                    System.err.println("source link placeholder of " + (i + 1) + " position of " + (j + 1) + " is not available/loaded");
                }
            }
        }

        // Perform the final assertion to check all accumulated verification failures
        sa.assertAll();
    }




}
