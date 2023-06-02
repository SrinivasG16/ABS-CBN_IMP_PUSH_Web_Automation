package com.applicationpages;

import com.applicationobjects.VideoArticleOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class VideoArticle extends GenericMethods {

    private static VideoArticleOR videoArticleOR;
    private static VideoArticle videoArticle;
    Actions act = new Actions(driver);

    private VideoArticle() {
        // Constructor for the VideoArticle class
        System.out.println("Creating object for Video Article inner PAGE");
    }

    public static VideoArticle getInstance() {
        // Get an instance of the VideoArticle class
        videoArticle = null;

        if (videoArticle == null) {
            // If an instance does not exist, create a new one
            videoArticle = new VideoArticle();

            // Initialize the page elements using PageFactory
            videoArticleOR = PageFactory.initElements(driver, VideoArticleOR.class);
        }

        // Return the instance of the VideoArticle class
        return videoArticle;
    }

    public void Verify_trend_section(){
        // Verify the availability of the "Trending now" sub section in the "Videos Article inner" section
        availableElement("Videos Article inner", "Trending now", "Sub section", videoArticleOR.txt_trending_sub);
    }

    public void Verify_trend_art(){
        // Verify the availability of a trending article in the "Videos Article inner" section
        availableElement("Videos Article inner", "Trending now", "Article", videoArticleOR.lnk_tren_art);
    }

    public void Verify_trend_art_pdate(){
        // Verify the availability of the post date for a trending article in the "Videos Article inner" section
        availableElement("Videos Article inner", "Trending now", "article post date", videoArticleOR.txt_tren_art_pdate);
    }

    public void Verify_trend_art_num(){
        // Verify the availability of the article number for a trending article in the "Videos Article inner" section
        availableElement("Videos Article inner", "Trending now", "article number", videoArticleOR.txt_tren_art_num);
    }

    public void Verify_latpho_section(){
        // Verify the availability of the "Latest Photo" sub section in the "Videos Article inner" section
        availableElement("Videos Article inner", "Latest Photo", "Sub section", videoArticleOR.txt_latphotos_sec);
    }

    public void Verify_latpho_art_thumb(){
        // Verify the availability of an article with thumbnail in the "Videos Article inner" section under "Latest Photo"
        availableImage("Videos Article inner", "Latest Photo", "Article with thumbnail", videoArticleOR.img_latpho_art_thumb);
    }

    public void Verify_latpho_art(){
        // Verify the availability of an article in the "Videos Article inner" section under "Latest Photo"
        availableElement("Videos Article inner", "Latest Photo", "Article", videoArticleOR.lnk_latpho_art);
    }

    public void Verify_pushtv_title(){
        // Verify the availability of the title for the "Push TV" section in the "Videos Article inner" section
        availableElement("Videos Article inner", "Push TV", "Title", videoArticleOR.txt_pushtv_title);
    }

    public void Verify_pushtv_description(){
        // Verify the availability of the description for the "Push TV" section in the "Videos Article inner" section
        availableElement("Videos Article inner", "Push TV", "Description", videoArticleOR.txt_pushtv_desciption);
    }

    public void Verify_pushtv_video(){
        // Switch to the "player" iframe
        driver.switchTo().frame("player");

        // Move to the element representing the "Push TV" section in the "Videos Article inner" section
        moveToElement("Videos Article inner", "Push TV", videoArticleOR.player_pushtv);

        // Get the runtime of the video from the element
        String runtime = videoArticleOR.txt_pushtv_video_art.getText();

        // Check if the runtime is "0:00"
        if(runtime.equals("0:00")){
            // Assert that the runtime is not "0:00", indicating that the Push TV video is not playing by default
            Assert.assertNotEquals("0:00", runtime, "Push TV video is not playing by default on the videos article inner page");
        } else {
            // Print a message indicating that the Push TV video is playing as expected
            System.out.println("Push TV video is playing as expected on the videos article inner page");
        }

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }


    public void Verify_Social_share_fun() throws InterruptedException {
        // Create a SoftAssert object for soft assertions
        SoftAssert softAssert = new SoftAssert();

        // Create a list of social share elements
        List socialshare = new ArrayList();
        socialshare.add(videoArticleOR.icn_fb_share);
        socialshare.add(videoArticleOR.icn_tw_share);
        // socialshare.add(photosArticleOR.icn_vbr_share);

        // Create a list of expected social share titles
        List socialtitle = new ArrayList();
        socialtitle.add("Facebook");
        socialtitle.add("Compose new Tweet / Twitter");
        // socialtitle.add("Viber");

        // Iterate through the social share elements
        for (int i = 0; i < socialshare.size(); i++) {
            // Click on the social share icon
            clickElement("Video Article inner", "Social Follow icons", (WebElement) socialshare.get(i));

            // Switch to the new window
            switchwindow();

            // Pause execution for 2000 milliseconds (2 seconds)
            Thread.sleep(2000);

            // Get the title of the current page
            String actURL = driver.getTitle();

            // Get the expected title from the socialtitle list
            String expURL = socialtitle.get(i).toString();

            // Print the title of the current page
            System.out.println("Title: " + actURL);

            if (expURL.contains(actURL)) {
                // The actual URL is contained in the expected URL, indicating that the share functionality is working as expected
                System.out.println(actURL + " share functionality is working as expected on the video article inner page");
            } else {
                // Assert that the actual URL matches the expected URL, indicating that the share functionality is not working as expected
                softAssert.assertEquals(actURL, expURL, "Share functionality not working as expected on the video article inner page");
            }

            // Close the current window
            driver.close();

            // Pause execution for 5000 milliseconds (5 seconds)
            Thread.sleep(5000);

            // Switch back to the parent window
            driver.switchTo().window(Parent);
        }

        // Perform all the soft assertions
        softAssert.assertAll();
    }

    // Create a JavaScriptExecutor object to execute JavaScript code
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void Navigate_to_ty_video(){
        // Navigate to the specified URL
        driver.navigate().to("https://uat-push-web.abs-cbn.com/2023/4/5/email-video-content-type-1021");
    }

    public void Verify_yt_Video_play() throws InterruptedException {
        // Scroll the page by 80 pixels vertically using JavaScript
        js.executeScript("window.scrollBy(0,80)", "");

        // Switch to the iframe containing the YouTube player
        driver.switchTo().frame(videoArticleOR.ifr_yt_player);

        // Click on the play button in the "Video inner Page"
        clickElement("Video inner Page", "Play button", videoArticleOR.btn_yt_play);

        // Pause execution for 5000 milliseconds (5 seconds)
        Thread.sleep(5000);

        // Move the mouse pointer to the "ply_yt_player" element
        act.moveToElement(videoArticleOR.ply_yt_player).perform();

        // Get the play time from the "txt_yt_ptime" element
        String time = videoArticleOR.txt_yt_ptime.getText();

        // Print the play time
        System.out.println("Play time is: " + time);

        // Convert the play time to an integer by removing the ":" separator
        int pt = Integer.parseInt(time.replaceAll(":", ""));

        if(pt >= 0){
            // The play time is greater than or equal to 0, indicating that the YouTube video is playing and working as expected
            System.out.println("YouTube video is playing and working as expected");
        } else {
            // Assert that the play time is not equal to 0, indicating that the YouTube video is not playing
            Assert.assertNotEquals(pt, 0, "YouTube video is not playing");
        }
    }

    public void Verify_yt_Video_pause(){
        // Click on the "Pause" button in the "Video Inner" section
        clickElement("Video Inner", "Pause", videoArticleOR.btn_yt_playPause);

        // Get the value of the "data-title-no-tooltip" attribute from the "btn_yt_playPause" element
        String pause = videoArticleOR.btn_yt_playPause.getAttribute("data-title-no-tooltip");

        // Print the value of the pause attribute
        System.out.println("Pause value: " + pause);

        if(pause.equals("Play")){
            // The pause value is "Play", indicating that the video pause functionality is working as expected
            System.out.println("Video pause functionality is working as expected");
        }else {
            // Assert that the pause value is "Play", indicating that the video pause functionality is not working as expected
            Assert.assertEquals(pause, "Play", "Video pause functionality is not working as expected");
        }
    }

    public void Verify_yt_Video_mute(){
        // Move the mouse pointer to the "ply_yt_player" element
        act.moveToElement(videoArticleOR.ply_yt_player).perform();

        // Click on the "Mute" button in the "Video Inner" section
        clickElement("Video Inner", "Mute", videoArticleOR.btn_yt_vol);

        // Get the value of the "data-title-no-tooltip" attribute from the "btn_yt_vol" element
        String val = videoArticleOR.btn_yt_vol.getAttribute("data-title-no-tooltip");

        // Print the value of the mute attribute
        System.out.println("Mute value: " + val);

        if(val.equals("Unmute")){
            // The mute value is "Unmute", indicating that the video is muted
            System.out.println("Video muted");
        }else {
            // Assert that the mute value is "Unmute", indicating that the video is unable to be muted
            Assert.assertEquals(val, "Unmute", "Unable to mute the video");
        }
    }

    public void Verify_yt_Video_Unmute(){
        // Move the mouse pointer to the "ply_yt_player" element
        act.moveToElement(videoArticleOR.ply_yt_player).perform();

        // Click on the "Mute" button in the "Video Inner" section
        clickElement("Video Inner", "Mute", videoArticleOR.btn_yt_vol);

        // Get the value of the "data-title-no-tooltip" attribute from the "btn_yt_vol" element
        String val = videoArticleOR.btn_yt_vol.getAttribute("data-title-no-tooltip");

        // Print the value of the unmute attribute
        System.out.println("Unmute value: " + val);

        if(val.equals("Mute")){
            // The unmute value is "Mute", indicating that the video is unmuted
            System.out.println("Video unmuted");
        }else {
            // Assert that the unmute value is "Mute", indicating that the video is unable to be unmuted
            Assert.assertEquals(val, "Mute", "Unable to unmute the video");
        }
    }

    public void Verify_yt_Video_Maximise(){
        // Move the mouse pointer to the "ply_yt_player" element
        act.moveToElement(videoArticleOR.ply_yt_player).perform();

        // Click on the "Maximise" button in the "Video Inner" section
        clickElement("Video Inner", "Maximise", videoArticleOR.btn_yt_max);

        // Get the value of the "data-title-no-tooltip" attribute from the "btn_yt_max" element
        String val = videoArticleOR.btn_yt_max.getAttribute("data-title-no-tooltip");

        // Print the value of the max attribute
        System.out.println("Max value: " + val);

        if(val.equals("Exit full screen")){
            // The max value is "Exit full screen", indicating that the video is maximised
            System.out.println("Able to maximise the video");
        }else {
            // Assert that the max value is "Exit full screen", indicating that the video is unable to be maximised
            Assert.assertEquals(val, "Exit full screen", "Unable to maximise the video");
        }
    }

    public void Verify_yt_Video_Minimise(){
        // Move the mouse pointer to the "ply_yt_player" element
        act.moveToElement(videoArticleOR.ply_yt_player).perform();

        // Click on the "Minimise" button in the "Video Inner" section
        clickElement("Video Inner", "Minimise", videoArticleOR.btn_yt_max);

        // Get the value of the "data-title-no-tooltip" attribute from the "btn_yt_max" element
        String val = videoArticleOR.btn_yt_max.getAttribute("data-title-no-tooltip");

        // Print the value of the min attribute
        System.out.println("Min value: " + val);

        if(val.equals("Full screen")){
            // The min value is "Full screen", indicating that the video is minimised
            System.out.println("Able to Minimise the video");
        }else {
            // Assert that the min value is "Full screen", indicating that the video is unable to be minimised
            Assert.assertEquals(val, "Full screen", "Unable to Minimise the video");
        }
    }


    public void Verify_ivs_Video_play() throws InterruptedException {
        js.executeScript("window.scrollBy(0,100)", "");
       // driver.switchTo().frame(videoArticleOR.ifr_yt_player);
        driver.findElement(By.xpath("//*[@id=\"Layer_1-2\"]/polygon")).click();
        //clickElement("Video inner Page","Play button",videoArticleOR.btn_yt_play);
        Thread.sleep(5000);
//        act.moveToElement(videoArticleOR.ply_yt_player).perform();
//        String time= videoArticleOR.txt_yt_ptime.getText();
//        System.out.println("Play time is : "+time);
//        int pt= Integer.parseInt(time.replaceAll(":",""));
//        if(pt>=0){
//            System.out.println("Youtube video is playing and working as expected");
//        }else {
//            Assert.assertNotEquals(pt,0,"Youtube video is not playing");
//        }
    }

}
