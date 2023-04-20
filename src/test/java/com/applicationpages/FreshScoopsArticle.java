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

    private FreshScoopsArticle() {
        System.out.println("Creating objecting for FreshScoops Article inner PAGE");
    }

    public static FreshScoopsArticle getInstance() {
        freshScoopsArticle=null;
        if (freshScoopsArticle == null) {
            freshScoopsArticle = new FreshScoopsArticle();
            freshScoopsArticleOR = PageFactory.initElements(driver, FreshScoopsArticleOR.class);
        }
        return freshScoopsArticle;
    }

    public void Verify_article_main_image(){
        availableElement("Fresh Scoops Article inner","Article","Fresh Scoops Article Main image", freshScoopsArticleOR.img_art_main);
    }

    public void Verify_trend_section(){
        availableElement("Fresh Scoops Article inner","Trending now","Sub section",freshScoopsArticleOR.txt_trending_sub);
    }
    public void Verify_trend_art(){
        availableElement("Fresh Scoops Article inner","Trending now","Article",freshScoopsArticleOR.lnk_tren_art);
    }
    public void Verify_trend_art_pdate(){
        availableElement("Fresh Scoops Article inner","Trending now","article post date",freshScoopsArticleOR.txt_tren_art_pdate);
    }
    public void Verify_trend_art_num(){
        availableElement("Fresh Scoops Article inner","Trending now","article number",freshScoopsArticleOR.txt_tren_art_num);
    }
    public void Verify_latpho_section(){
        availableElement("Fresh Scoops Article inner","Latest Photo","Sub section",freshScoopsArticleOR.txt_latphotos_sec);
    }
    public void Verify_latpho_art_thumb(){
        availableElement("Fresh Scoops Article inner ","Latest Photo","Article with thumbnail",freshScoopsArticleOR.img_latpho_art_thumb);
    }
    public void Verify_latpho_art(){
        availableElement("Fresh Scoops Article inner","Latest Photo","Article",freshScoopsArticleOR.lnk_latpho_art);
    }

    public void Verify_relscoops_art(){
        availableElement("Fresh Scoops Article inner","Related Scoops","Article",freshScoopsArticleOR.lnk_relscoops_art);

    }

    public void Verify_Social_share_fun() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        List socialshare = new ArrayList();
        socialshare.add(freshScoopsArticleOR.icn_fb_share);
        socialshare.add(freshScoopsArticleOR.icn_tw_share);
       // socialshare.add(freshScoopsArticleOR.icn_vbr_share);


        List socialtitle = new ArrayList();
        socialtitle.add("Facebook");
        socialtitle.add("Compose new Tweet / Twitter");
      //  socialtitle.add("Viber");



        for (int i = 0; i < socialshare.size(); i++) {
            clickElement("Fresh scoops article inner", "Social Follow icons", (WebElement) socialshare.get(i));
            switchwindow();
            Thread.sleep(2000);
            String actURL= driver.getTitle();
            String expURL=socialtitle.get(i).toString();
            System.out.println("Title : "+actURL);

            if (expURL.contains(actURL)) {
                System.out.println(actURL+" Section page Functionality is working as expected on the Fresh scoops article inner page");
            }else {
                softAssert.assertEquals(actURL,expURL,"Section page functionality not working as expected on the Fresh scoops article inner page");
            }

            driver.close();
            Thread.sleep(5000);
            driver.switchTo().window(Parent);
        }
        softAssert.assertAll();
    }

    public void verify_infinitescroll_art() throws InterruptedException {
        Actions act = new Actions(driver);
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
        List arts = new ArrayList();
        try {
            for (int i = 1; i <= 6; i++) {
                WebElement art = driver.findElement(By.xpath("(//div[@class='MuiTypography-root MuiTypography-h1 MuiTypography-gutterBottom css-17pyewg'])[" + i + "]"));
                System.out.println("Art of " + i + " : " + art.getText());
                arts.add(art.getText());
            }
            int count=0;
            int total=0;
            for (int i = 0; i < arts.size(); i++) {
                total=i+total;
                for (int j = i + 1; j < arts.size(); j++) {
                    if (arts.get(i).equals(arts.get(j))) {
                        Assert.assertNotEquals(arts.get(i), arts.get(j), "Articles are Duplicates or Same article are loading in Infinite Scroll");
                    } else {
                        count = count + 1;
                    }
                }
            }
            System.out.println("Count is : "+count);
            System.out.println("Total  is : "+total);
            if (count == total) {
                System.out.println("\n");
                System.out.println("Articles in infinite scroll are Unique");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            int count=0;
            int total=0;

            for (int i = 0; i < arts.size(); i++) {
                total=i+total;
                for (int j = i + 1; j < arts.size(); j++) {
                    if (arts.get(i).equals(arts.get(j))) {
                        Assert.assertNotEquals(arts.get(i), arts.get(j), "Articles are Duplicates or Same in Infinite Scroll");
                    } else {
                        count = count + 1;
                    }
                }
            }
            System.out.println("Count is : "+count);
            System.out.println("Total  is : "+total);
            if (count == total) {
                System.out.println("\n");
                System.out.println("Articles in infinite scroll are Unique");
            }

        }
    }




}
