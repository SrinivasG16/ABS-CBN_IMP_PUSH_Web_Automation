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
        System.out.println("Creating objecting for Photos PAGE");
    }

    public static Photos getInstance() {
        photos=null;
        if (photos == null) {
            photos = new Photos();
            photosOR = PageFactory.initElements(driver, PhotosOR.class);
        }
        return photos;
    }



    public void Verify_Photos_section(){
        availableElement("Photos","Photos","Sub section",photosOR.txt_ph_section);
    }
    public void Verify_main_art_thumb(){
        availableElement("Photos","Main article","Article with thumbnail",photosOR.img_mainart);
    }
    public void Verify_main_art_link(){
        availableElement("Photos","Main article","Article",photosOR.lnk_mainart);
    }
    public void Verify_trendnow_section(){
        availableElement("Photos","Trending now","Sub section",photosOR.txt_trending_sub);
    }
    public void Verify_trendnow_art(){
        availableElement("Photos","Trending now","Article",photosOR.lnk_tren_art);
    }
    public void Verify_trendnow_art_pdate(){
        availableElement("Photos","Trending now","article post date",photosOR.txt_tren_art_pdate);
    }
    public void Verify_trendnow_art_num(){
        availableElement("Photos","Trending now","article number",photosOR.txt_tren_art_num);
    }
    public void Verify_justin_section(){
        availableElement("Photos","Just In","Sub section",photosOR.txt_justin_sec);
    }

    public void Verify_just_art(){
        availableElement("Photos","Just In","Article",photosOR.lnk_just_art);
    }

    public void Verify_just_art_pdate(){
        availableElement("Photos","Just In","Article post date",photosOR.txt_just_art_pdate);
    }

    public void Verify_morephotos(){
        availableElement("Photos","More Photos","More Photos Button",photosOR.btn_morephotos);
        clickElement("Photos","More Photos",photosOR.btn_morephotos);
    }

    public void Navigate_To_PhotoArticleinner(){
        clickElement("Photos","Main article", photosOR.img_mainart);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)","");
        js.executeScript("window.scrollBy(0,1200)","");
        js.executeScript("window.scrollBy(0,2000)","");
    }

    public void Verify_ph_MorePhotos_fun() throws InterruptedException {
        int artCount_bf=photosOR.lst_art_bf.size();
        System.out.println("Before : "+artCount_bf);
        clickElement("Photos","More Photos",photosOR.btn_morephotos);
        Thread.sleep(2000);
        int artCount_af=photosOR.lst_art_af.size();
        System.out.println("After : "+artCount_af);

        if(artCount_af!=artCount_bf){
            System.out.println("More Photos button functionality working as expected");
        }else{
            Assert.assertNotEquals(artCount_af,artCount_bf,"More Photos button functionality not working as expected");
        }

    }

    JavascriptExecutor js =(JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        moveToElement("Photos","Footer",photosOR.lnk_ftr_advus);
        availableElement("Photos","Recommended Section","Ads",photosOR.txt_rec_sec);

        System.out.println("Title link is : "+photosOR.txt_rec_sec.getText());

    }

    public void Verify_outBrain_ads_thumb(String PageName){
        SoftAssert softAssert = new SoftAssert();
        moveToElement("Photos","Footer",photosOR.txt_rec_sec);
        int Count= photosOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+photosOR.cou_rec_widgets.get(i).getAttribute("id"));
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    String jsthumb="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > span > img\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);
                    boolean status= elementClickable(PageName,"recommended section","OutBrain ads thumbnail of placeholder no of "+(i+1)+" and position of "+(j+1),shadowRoot);
                    if(status==true) {
                        System.out.println("Thumbnail placeholder of " + (i + 1) + " position of " + (j+1) + " is available");
                    }else {
                        softAssert.assertEquals(status,true,"Thumbnail placeholder of " + (i + 1) + " position of " + (j+1) + " is not available/loaded");
                    }
                }catch (Exception e){
                    System.err.println("Thumbnail placeholder of " + (i + 1) + " position of " + (j+1) + " is not available/loaded");
                }


            }
        }
        softAssert.assertAll();

    }

    /*************************************************

     public void verify_R() {
     String roots="document.querySelector(\"#outbrain_widget_100";
     String shadows="\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\";
     Verify_recom_ads_thumb(photosOR.txt_rec_sec, photosOR.cou_rec_widgets, "hi", "hello");
     }
     *************************************************/

    public void Verify_outBrain_ads_link(String PageName){
        SoftAssert soft = new SoftAssert();
        moveToElement("Home page","Footer",photosOR.txt_rec_sec);
        int Count= photosOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+photosOR.cou_rec_widgets.get(i).getAttribute("id"));
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    String jslink="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jslink);
                    boolean status= elementClickable(PageName,"recommended section","OutBrain ads link of placeholder no of "+(i+1)+" and position of "+(j+1),shadowRoot);
                    if(status==true) {
                        System.out.println("link placeholder of " + (i + 1) + " position of " + (j+1) + " is available");
                        System.out.println("Link is : "+shadowRoot.getText());
                    }else {
                        soft.assertEquals(status,true,"link placeholder of " + (i + 1) + " position of " + (j+1) + " is not available/loaded");
                    }
                }catch (Exception e){
                    System.err.println("link placeholder of " + (i + 1) + " position of " + (j+1) + " is not available/loaded");
                }


            }
        }
        soft.assertAll();


    }

    public void Verify_outBrain_ads_source(String PageName){
        SoftAssert sa = new SoftAssert();
        moveToElement("Photos","Footer",photosOR.txt_rec_sec);
        int Count= photosOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+photosOR.cou_rec_widgets.get(i).getAttribute("id"));
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    String jsthumb="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > section > span.ob-unit.ob-rec-source\")";
                    WebElement shadowRoot = (WebElement) js.executeScript("return " + jsthumb);
                    boolean status= elementClickable(PageName,"recommended section","OutBrain ads source link of placeholder no of "+(i+1)+" and position of "+(j+1),shadowRoot);
                    if(status==true) {
                        System.out.println("source link placeholder of " + (i + 1) + " position of " + (j+1) + " is available");
                        System.out.println("Source Link is : "+shadowRoot.getText());
                    }else {
                        sa.assertEquals(status,true,"source link placeholder of " + (i + 1) + " position of " + (j+1) + " is not available/loaded");
                    }
                }catch (Exception e){
                    System.err.println("source link placeholder of " + (i + 1) + " position of " + (j+1) + " is not available/loaded");
                }


            }
        }
        sa.assertAll();

    }



}
