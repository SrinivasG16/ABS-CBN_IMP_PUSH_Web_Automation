package com.applicationpages;

import com.applicationobjects.FreshScoopsOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FreshScoops extends GenericMethods {

    private static FreshScoopsOR freshScoopsOR;
    private static FreshScoops freshScoops;
    private FreshScoops() {
        System.out.println("Creating objecting for FreshScoops PAGE");
    }

    public static FreshScoops getInstance() {
        freshScoops=null;
        if (freshScoops == null) {
            freshScoops = new FreshScoops();
            freshScoopsOR = PageFactory.initElements(driver, FreshScoopsOR.class);
        }
        return freshScoops;
    }



    public void Verify_freshscoops_section(){
        availableElement("Fresh Scoops","Fresh scoops","Sub section",freshScoopsOR.txt_fs_section);
    }
    public void Verify_main_art_thumb(){
        availableElement("Fresh Scoops","Main article","Article with thumbnail",freshScoopsOR.img_mainart);
    }
    public void Verify_main_art_link(){
        availableElement("Fresh Scoops","Main article","Article",freshScoopsOR.lnk_mainart);
    }
    public void Verify_trendnow_section(){
        availableElement("Fresh Scoops","Trending now","Sub section",freshScoopsOR.txt_trending_sub);
    }
    public void Verify_trendnow_art(){
        availableElement("Fresh Scoops","Trending now","Article",freshScoopsOR.lnk_tren_art);
    }
    public void Verify_trendnow_art_pdate(){
        availableElement("Fresh Scoops","Trending now","article post date",freshScoopsOR.txt_tren_art_pdate);
    }
    public void Verify_trendnow_art_num(){
        availableElement("Fresh Scoops","Trending now","article number",freshScoopsOR.txt_tren_art_num);
    }
    public void Verify_latpho_section(){
        availableElement("Fresh Scoops","Latest Photo","Sub section",freshScoopsOR.txt_latphotos_sec);
    }
    public void Verify_latpho_art_thumb(){
        availableElement("Fresh Scoops","Latest Photo","Article with thumbnail",freshScoopsOR.img_latpho_art_thumb);
    }
    public void Verify_latpho_art(){
        availableElement("Fresh Scoops","Latest Photo","Article",freshScoopsOR.lnk_latpho_art);
    }
    public void Verify_morescoops_fun(){
        availableElement("Fresh Scoops","More Scoops button","More Scoops button",freshScoopsOR.btn_morescoops);
        clickElement("Fresh Scoops","More Scoops",freshScoopsOR.btn_morescoops);
    }

    public void Navigate_To_FsArticleinner(){
        clickElement("Fresh Scoops","Main article",freshScoopsOR.img_latpho_art_thumb);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)","");
        js.executeScript("window.scrollBy(0,1200)","");
        js.executeScript("window.scrollBy(0,2000)","");
    }

    public void Verify_fs_MoreScoops_fun() throws InterruptedException {
        int artCount_bf=freshScoopsOR.lst_art_bf.size();
        System.out.println("Before : "+artCount_bf);
        clickElement("FreshScoops","More Scoops",freshScoopsOR.btn_morescoops);
        Thread.sleep(2000);
        int artCount_af=freshScoopsOR.lst_art_af.size();
        System.out.println("After : "+artCount_af);

        if(artCount_af!=artCount_bf){
            System.out.println("More scoops button functionality working as expected");
        }else{
            Assert.assertNotEquals(artCount_af,artCount_bf,"More scoops button functionality not working as expected");
        }

    }

    JavascriptExecutor js =(JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        moveToElement("FreshScoops","Footer",freshScoopsOR.lnk_ftr_advus);
        availableElement("FreshScoops","Recommended Section","Ads",freshScoopsOR.txt_rec_sec);

        System.out.println("Title link is : "+freshScoopsOR.txt_rec_sec.getText());

    }

    public void Verify_outBrain_ads_thumb(String PageName){
        SoftAssert softAssert = new SoftAssert();
        moveToElement("FreshScoops","Footer",freshScoopsOR.txt_rec_sec);
        int Count= freshScoopsOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+freshScoopsOR.cou_rec_widgets.get(i).getAttribute("id"));
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
     Verify_recom_ads_thumb(freshScoopsOR.txt_rec_sec, freshScoopsOR.cou_rec_widgets, "hi", "hello");
     }
     *************************************************/

    public void Verify_outBrain_ads_link(String PageName){
        SoftAssert soft = new SoftAssert();
        moveToElement("Home page","Footer",freshScoopsOR.txt_rec_sec);
        int Count= freshScoopsOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+freshScoopsOR.cou_rec_widgets.get(i).getAttribute("id"));
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
        moveToElement("FreshScoops","Footer",freshScoopsOR.txt_rec_sec);
        int Count= freshScoopsOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+freshScoopsOR.cou_rec_widgets.get(i).getAttribute("id"));
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
