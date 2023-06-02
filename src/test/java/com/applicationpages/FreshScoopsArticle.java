package com.applicationpages;

import com.applicationobjects.FreshScoopsArticleOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class FreshScoopsArticle extends GenericMethods {

    private static FreshScoopsArticleOR freshScoopsArticleOR;
    private static FreshScoopsArticle freshScoopsArticle;
    // Constructor for the FreshScoopsArticle class
    private FreshScoopsArticle() {
        System.out.println("Creating object for FreshScoops Article inner PAGE");
    }

    // Method to get the instance of FreshScoopsArticle
    public static FreshScoopsArticle getInstance() {
        freshScoopsArticle = null;

        // Check if freshScoopsArticle instance is null
        if (freshScoopsArticle == null) {
            // Create a new instance of FreshScoopsArticle
            freshScoopsArticle = new FreshScoopsArticle();

            // Initialize the freshScoopsArticleOR object using PageFactory, passing driver and FreshScoopsArticleOR class
            freshScoopsArticleOR = PageFactory.initElements(driver, FreshScoopsArticleOR.class);
        }

        // Return the freshScoopsArticle instance
        return freshScoopsArticle;
    }

    // Method to verify the presence of the main image in the Fresh Scoops Article inner page
    public void Verify_article_main_image(){
        availableImage("Fresh Scoops Article inner", "Article", "Fresh Scoops Article Main image", freshScoopsArticleOR.img_art_main);
    }

    // Method to verify the presence of the trend section in the Fresh Scoops Article inner page
    public void Verify_trend_section(){
        availableElement("Fresh Scoops Article inner", "Trending now", "Sub section", freshScoopsArticleOR.txt_trending_sub);
    }

    // Method to verify the presence of a trend article in the Fresh Scoops Article inner page
    public void Verify_trend_art(){
        availableElement("Fresh Scoops Article inner", "Trending now", "Article", freshScoopsArticleOR.lnk_tren_art);
    }

    // Method to verify the presence of the post date of a trend article in the Fresh Scoops Article inner page
    public void Verify_trend_art_pdate(){
        availableElement("Fresh Scoops Article inner", "Trending now", "article post date", freshScoopsArticleOR.txt_tren_art_pdate);
    }

    // Method to verify the presence of the article number in the trend section of the Fresh Scoops Article inner page
    public void Verify_trend_art_num(){
        availableElement("Fresh Scoops Article inner", "Trending now", "article number", freshScoopsArticleOR.txt_tren_art_num);
    }

    // Method to verify the presence of the Latest Photo section in the Fresh Scoops Article inner page
    public void Verify_latpho_section(){
        availableElement("Fresh Scoops Article inner", "Latest Photo", "Sub section", freshScoopsArticleOR.txt_latphotos_sec);
    }

    // Method to verify the presence of an article with thumbnail in the Latest Photo section of the Fresh Scoops Article inner page
    public void Verify_latpho_art_thumb(){
        availableImage("Fresh Scoops Article inner", "Latest Photo", "Article with thumbnail", freshScoopsArticleOR.img_latpho_art_thumb);
    }

    // Method to verify the presence of an article in the Latest Photo section of the Fresh Scoops Article inner page
    public void Verify_latpho_art(){
        availableElement("Fresh Scoops Article inner", "Latest Photo", "Article", freshScoopsArticleOR.lnk_latpho_art);
    }

    // Method to verify the presence of a related Scoops article in the Fresh Scoops Article inner page
    public void Verify_relscoops_art(){
        availableElement("Fresh Scoops Article inner", "Related Scoops", "Article", freshScoopsArticleOR.lnk_relscoops_art);
    }

    public void Verify_Social_share_fun() throws InterruptedException {
        // Creating an instance of SoftAssert for assertion purposes
        SoftAssert softAssert = new SoftAssert();

        // Creating a list to store social share elements
        List socialshare = new ArrayList();
        socialshare.add(freshScoopsArticleOR.icn_fb_share); // Adding Facebook share element
        socialshare.add(freshScoopsArticleOR.icn_tw_share); // Adding Twitter share element
        // socialshare.add(freshScoopsArticleOR.icn_vbr_share); // (Commented out) Adding Viber share element

        // Creating a list to store expected social media titles
        List socialtitle = new ArrayList();
        socialtitle.add("Facebook"); // Adding expected title for Facebook
        socialtitle.add("Compose new Tweet / Twitter"); // Adding expected title for Twitter
        // socialtitle.add("Viber"); // (Commented out) Adding expected title for Viber

        // Iterating over the socialshare list
        for (int i = 0; i < socialshare.size(); i++) {
            // Clicking on the social follow icon
            clickElement("Fresh scoops article inner", "Social Follow icons", (WebElement) socialshare.get(i));
            // Switching to the new window
            switchwindow();
            Thread.sleep(2000);

            // Getting the actual title of the current page
            String actURL = driver.getTitle();
            // Getting the expected title from the socialtitle list
            String expURL = socialtitle.get(i).toString();
            System.out.println("Title: " + actURL);

            // Checking if the expected title contains the actual title
            if (expURL.contains(actURL)) {
                System.out.println(actURL + " Section page Functionality is working as expected on the Fresh scoops article inner page");
            } else {
                // Asserting that the actual title is equal to the expected title
                softAssert.assertEquals(actURL, expURL, "Section page functionality not working as expected on the Fresh scoops article inner page");
            }

            // Closing the current window
            driver.close();
            Thread.sleep(5000);
            // Switching back to the parent window
            driver.switchTo().window(Parent);
        }

        // Asserting all the soft assertions
        softAssert.assertAll();
    }

    public void verify_infinitescroll_art() throws InterruptedException {
        // Creating an instance of Actions class
        Actions act = new Actions(driver);

        // Performing infinite scroll by pressing Ctrl + End multiple times
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(3000);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(3000);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(3000);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(3000);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(3000);

        // Creating a list to store the article texts
        List arts = new ArrayList();

        try {
            // Iterating over the articles on the page and adding their texts to the arts list
            for (int i = 1; i <= 6; i++) {
                WebElement art = driver.findElement(By.xpath("(//div[@class='MuiTypography-root MuiTypography-h1 MuiTypography-gutterBottom css-17pyewg'])[" + i + "]"));
                System.out.println("Art of " + i + " : " + art.getText());
                arts.add(art.getText());
            }

            int count = 0;
            int total = 0;

            // Checking for duplicate articles
            for (int i = 0; i < arts.size(); i++) {
                total = i + total;
                for (int j = i + 1; j < arts.size(); j++) {
                    if (arts.get(i).equals(arts.get(j))) {
                        Assert.assertNotEquals(arts.get(i), arts.get(j), "Articles are Duplicates or Same article are loading in Infinite Scroll");
                    } else {
                        count = count + 1;
                    }
                }
            }

            System.out.println("Count is: " + count);
            System.out.println("Total is: " + total);

            if (count == total) {
                System.out.println("\n");
                System.out.println("Articles in infinite scroll are Unique");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            int count = 0;
            int total = 0;

            // Checking for duplicate articles (in case of exception)
            for (int i = 0; i < arts.size(); i++) {
                total = i + total;
                for (int j = i + 1; j < arts.size(); j++) {
                    if (arts.get(i).equals(arts.get(j))) {
                        Assert.assertNotEquals(arts.get(i), arts.get(j), "Articles are Duplicates or Same in Infinite Scroll");
                    } else {
                        count = count + 1;
                    }
                }
            }

            System.out.println("Count is: " + count);
            System.out.println("Total is: " + total);

            if (count == total) {
                System.out.println("\n");
                System.out.println("Articles in infinite scroll are Unique");
            }
        }
    }




}
