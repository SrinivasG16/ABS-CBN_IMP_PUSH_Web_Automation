package com.applicationpages;

import com.applicationobjects.PhotosArticleOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class PhotosArticle extends GenericMethods {

    private static PhotosArticleOR photosArticleOR;
    private static PhotosArticle photosArticle;

    // Private constructor to prevent direct instantiation of the class
    private PhotosArticle() {
        System.out.println("Creating object for Photos Article inner PAGE");
    }

    // Public method to get the instance of PhotosArticle class
    public static PhotosArticle getInstance() {
        photosArticle = null;

        // Check if the instance is not already created
        if (photosArticle == null) {
            // Create a new instance of PhotosArticle
            photosArticle = new PhotosArticle();

            // Initialize the PageFactory elements for the PhotosArticleOR class
            photosArticleOR = PageFactory.initElements(driver, PhotosArticleOR.class);
        }

        // Return the instance of PhotosArticle
        return photosArticle;
    }
    // Verify the main image of the Photos Article inner page
    public void Verify_article_main_image(){
        availableImage("Photos Article inner", "Article", "Photos Article Main image", photosArticleOR.img_art_main);
    }

    // Verify the Justin section of the Photos Article inner page
    public void Verify_justin_section(){
        availableElement("Photos Article Inner", "Just In", "Sub section", photosArticleOR.txt_justin_sec);
    }

    // Verify the Justin article of the Photos Article inner page
    public void Verify_just_art(){
        availableElement("Photos Article Inner", "Just In", "Article", photosArticleOR.lnk_just_art);
    }

    // Verify the post date of the Justin article on the Photos Article inner page
    public void Verify_just_art_pdate(){
        availableElement("Photos Article Inner", "Just In", "Article post date", photosArticleOR.txt_just_art_pdate);
    }

    // Verify the Trending now section of the Photos Article inner page
    public void Verify_trendn_section(){
        availableElement("Photos Article Inner", "Trending now", "Sub section", photosArticleOR.txt_trending_sub);
    }

    // Verify the Trending now article of the Photos Article inner page
    public void Verify_trendn_art(){
        availableElement("Photos Article Inner", "Trending now", "Article", photosArticleOR.lnk_tren_art);
    }

    // Verify the post date of the Trending now article on the Photos Article inner page
    public void Verify_trendn_art_pdate(){
        availableElement("Photos Article Inner", "Trending now", "article post date", photosArticleOR.txt_tren_art_pdate);
    }

    // Verify the article number of the Trending now article on the Photos Article inner page
    public void Verify_trendn_art_num(){
        availableElement("Photos Article Inner", "Trending now", "article number", photosArticleOR.txt_tren_art_num);
    }

    // Verify the social share functionality on the Photos article inner page
    public void Verify_Social_share_fun() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // Create a list to store the social share elements
        List socialshare = new ArrayList();
        socialshare.add(photosArticleOR.icn_fb_share);
        socialshare.add(photosArticleOR.icn_tw_share);
        // socialshare.add(photosArticleOR.icn_vbr_share);

        // Create a list to store the expected social titles
        List socialtitle = new ArrayList();
        socialtitle.add("Facebook");
        socialtitle.add("Compose new Tweet / Twitter");
        // socialtitle.add("Viber");

        // Iterate over the social share elements
        for (int i = 0; i < socialshare.size(); i++) {
            // Click on the social share icon
            clickElement("Photos article inner", "Social Follow icons", (WebElement) socialshare.get(i));

            // Switch to the new window opened
            switchwindow();

            // Pause the execution for 2000 milliseconds
            Thread.sleep(2000);

            // Get the actual URL of the current page
            String actURL = driver.getTitle();

            // Get the expected URL from the socialtitle list
            String expURL = socialtitle.get(i).toString();

            // Print the actual title of the page
            System.out.println("Title: " + actURL);

            // Check if the expected URL contains the actual URL
            if (expURL.contains(actURL)) {
                System.out.println(actURL + " share Functionality is working as expected on the Photo article inner page");
            } else {
                softAssert.assertEquals(actURL, expURL, "Share functionality not working as expected on the photo article inner page");
            }

            // Close the current window
            driver.close();

            // Pause the execution for 5000 milliseconds
            Thread.sleep(5000);

            // Switch back to the parent window
            driver.switchTo().window(Parent);
        }

        // Perform assertAll to check if any soft assertions failed
        softAssert.assertAll();
    }


}
