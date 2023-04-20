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

    private PhotosArticle() {
        System.out.println("Creating objecting for Photos Article inner PAGE");
    }

    public static PhotosArticle getInstance() {
        photosArticle=null;
        if (photosArticle == null) {
            photosArticle = new PhotosArticle();
            photosArticleOR = PageFactory.initElements(driver, PhotosArticleOR.class);
        }
        return photosArticle;
    }

    public void Verify_article_main_image(){
        availableElement("Photos Article inner","Article","Photos Article Main image", photosArticleOR.img_art_main);
    }

    public void Verify_justin_section(){
        availableElement("Photos Article Inner","Just In","Sub section",photosArticleOR.txt_justin_sec);
    }

    public void Verify_just_art(){
        availableElement("Photos Article Inner","Just In","Article",photosArticleOR.lnk_just_art);
    }

    public void Verify_just_art_pdate(){
        availableElement("Photos Article Inner","Just In","Article post date",photosArticleOR.txt_just_art_pdate);
    }

    public void Verify_trendn_section(){
        availableElement("Photos Article Inner","Trending now","Sub section",photosArticleOR.txt_trending_sub);
    }
    public void Verify_trendn_art(){
        availableElement("Photos Article Inner","Trending now","Article",photosArticleOR.lnk_tren_art);
    }
    public void Verify_trendn_art_pdate(){
        availableElement("Photos Article Inner","Trending now","article post date",photosArticleOR.txt_tren_art_pdate);
    }
    public void Verify_trendn_art_num(){
        availableElement("Photos Article Inner","Trending now","article number",photosArticleOR.txt_tren_art_num);
    }

    public void Verify_Social_share_fun() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        List socialshare = new ArrayList();
        socialshare.add(photosArticleOR.icn_fb_share);
        socialshare.add(photosArticleOR.icn_tw_share);
      //  socialshare.add(photosArticleOR.icn_vbr_share);


        List socialtitle = new ArrayList();
        socialtitle.add("Facebook");
        socialtitle.add("Compose new Tweet / Twitter");
      //  socialtitle.add("Viber");



        for (int i = 0; i < socialshare.size(); i++) {
            clickElement("Photos article inner", "Social Follow icons", (WebElement) socialshare.get(i));
            switchwindow();
            Thread.sleep(2000);
            String actURL= driver.getTitle();
            String expURL=socialtitle.get(i).toString();
            System.out.println("Title : "+actURL);

            if (expURL.contains(actURL)) {
                System.out.println(actURL+" share Functionality is working as expected on the Photo article inner page");
            }else {
                softAssert.assertEquals(actURL,expURL," Share functionality not working as expected on the photo article inner page");
            }

            driver.close();
            Thread.sleep(5000);
            driver.switchTo().window(Parent);
        }
        softAssert.assertAll();
    }

}
