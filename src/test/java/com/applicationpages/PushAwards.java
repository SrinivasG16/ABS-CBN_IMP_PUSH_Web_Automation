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



    private PushAwards() {
        System.out.println("Creating objecting for Push Awards PAGE");
    }

    public static PushAwards getInstance() {
        pushAwards=null;
        if (pushAwards == null) {
            pushAwards = new PushAwards();
            pushAwardsOR = PageFactory.initElements(driver, PushAwardsOR.class);
        }
        return pushAwards;
    }

    public void select_first_thumb(){
        // PageScrollbyJS(PushAwardsOR.txt_pushawards_sec);
        clickElement("Push Awards","Select first thumbnail",pushAwardsOR.img_first_thumb);
    }
    public void Verify_img_slideshow(){
        availableElement("Push Awards","Carousel","slide show thumbnail",pushAwardsOR.img_slideshow);
    }

    public void Verify_slideshow_link(){
        System.out.println("Title is : "+pushAwardsOR.lnk_hero_carousel.getText());
        availableElement("Push Awards","Carousel","slide show art link",pushAwardsOR.lnk_hero_carousel);

    }

    public void Verify_slideart_pdate(){
        availableElement("Push Awards","Carousel","slider article post date",pushAwardsOR.txt_hero_carousel_pdate);
    }

    public void Verify_carousel_sec_desription(){
        availableElement("Push Awards","Carousel","description",pushAwardsOR.txt_hero_carousel_desc);
    }

    public void Verify_pushAwards_section() {
        availableElement("Home", "push Awards", "Section", pushAwardsOR.txt_pushawards_sec);
    }

    public void Verify_pushAwards_thumb_Art() {
        availableElement("Home", "push Awards", "Article with thumbnail", pushAwardsOR.img_pushawards_thumb);
    }

    public void Verify_pushAwards_art_links() {
        availableElement("Home", "push Awards", "Articles links", pushAwardsOR.lnk_pushawards_art);
    }

    public void Verify_pushawards_video() throws InterruptedException {
        driver.switchTo().frame("player-E1SF04nWIhM");
        clickElement("Push Awards","Push video",pushAwardsOR.btn_pushawrads_vdo);
        Thread.sleep(3000);
        moveToElement("Push Awards","Push TV",pushAwardsOR.player_pushawards);
        String runtime=pushAwardsOR.txt_pushawards_video_art.getText();
        System.out.println("run time is : "+runtime);
        if(!runtime.equals("0:00")){
            System.out.println("PUSH Tv video is playing as expected on the Home Page");

        }else {
            Assert.assertNotEquals("0:00",runtime,"Push tv video is not playing on the Home page");
        }
        driver.switchTo().defaultContent();

    }

    public void Verify_pushawards_title(){
        availableElement("Push Awards","Push TV","Title",pushAwardsOR.txt_pushawards_title);
    }

    public void Verify_pushawards_description(){
        availableElement("Push Awards","Push TV","Description",pushAwardsOR.txt_pushawards_desciption);
    }

    public void Verify_pushawards_playlist_thumbnail(){
        availableElement("Push Awards","Push TV","Playlist thumbnail",pushAwardsOR.img_pushawards_pl_thumb);
    }

    public void Verify_pushawards_playlist_title(){
        availableElement("Push Awards","Push TV","Playlist title",pushAwardsOR.lnk_pushawards_playlists_art);
    }
    public void Verify_pushawards_playlist_hash(){
        availableElement("Push Awards","Push TV","Playlist Description",pushAwardsOR.lnk_pushawards_pl_hash);
    }

    public void Verify_pushawards_seemore(){
        availableElement("Push Awards","Push TV","See More",pushAwardsOR.btn_pushawards_seemore);
    }

    public void Verify_trendn_section() {
        availableElement("Push Awards", "TrendingNow ", "Section", pushAwardsOR.txt_trendn_section);
    }

    public void Verify_trendn_art() {
        availableElement("Push Awards", "Trending Now", "Articles", pushAwardsOR.img_tren_art);
    }

    public void Verify_Webstories_section() {
        availableElement("Push Awards", "Web Stories section", "Section", pushAwardsOR.txt_photos_webstories);
    }

    public void Verify_Webstories_thumb_Art() {
        availableElement("Push Awards", "Web Stories section", "Article with thumbnail", pushAwardsOR.img_web_arts);
    }

    public void Verify_pushAwards_innerlnik(){

        String expTitle=pushAwardsOR.lnk_pushawards_art.getText();
        clickElement("Push Awards","Push awards article link",pushAwardsOR.lnk_pushawards_art);
        String actTitle=driver.getTitle();
        System.out.println("Url : "+driver.getCurrentUrl());

        if(actTitle.contains(expTitle)){
            System.out.println("Successfully navigating to Push awards inner page, Hence Push Awards inner page working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"Unable to navigate to Push awards inner page, Hence Push Awards inner page not working as expected");
        }

    }

    public void Verify_pushAwards_innerthumb(){

        String expTitle=pushAwardsOR.lnk_pushawards_art.getText();
        clickElement("Push Awards","Push awards article link",pushAwardsOR.img_pushawards_thumb);
        String actTitle=driver.getTitle();
        System.out.println("Url : "+driver.getCurrentUrl());

        if(actTitle.contains(expTitle)){
            System.out.println("Successfully navigating to Push awards inner page, Hence Push Awards inner page working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"Unable to navigate to Push awards inner page, Hence Push Awards inner page not working as expected");
        }

    }

    public void Verify_seemore_btn_fun() throws InterruptedException {
        int artCount_bf=pushAwardsOR.lst_pushawards_playlists_bf.size();
        System.out.println("Before : "+artCount_bf);
        clickElement("FreshScoops","More Photos",pushAwardsOR.btn_pushawards_seemore);
        Thread.sleep(2000);
        int artCount_af=pushAwardsOR.lst_pushawards_playlists_af.size();
        System.out.println("After : "+artCount_af);

        if(artCount_af!=artCount_bf){
            System.out.println("See More button functionality working as expected");
        }else{
            Assert.assertNotEquals(artCount_af,artCount_bf,"See More button functionality not working as expected");
        }
    }

    public void Verify_trendNow_innerlnik(){

        String expTitle=pushAwardsOR.lnk_tren_art.getText();
        clickElement("Push Awards","Push awards article link",pushAwardsOR.lnk_tren_art);
        String actTitle=driver.getTitle();
        System.out.println("Url : "+driver.getCurrentUrl());

        if(actTitle.contains(expTitle)){
            System.out.println("Successfully navigating to trending now articles inner page, Hence trending now articles inner page working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"Unable to navigate to trending now articles inner page, Hence trending now articles inner page not working as expected");
        }

    }

    public void Verify_trendNow_innerthumb(){

        String expTitle=pushAwardsOR.lnk_tren_art.getText();
        clickElement("Push Awards","Push awards article link",pushAwardsOR.img_tren_art);
        String actTitle=driver.getTitle();
        System.out.println("Url : "+driver.getCurrentUrl());

        if(actTitle.contains(expTitle)){
            System.out.println("Successfully navigating to trending now articles inner page, Hence trending now articles inner page working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"Unable to navigate to trending now articles inner page, Hence trending now articles inner page not working as expected");
        }

    }

    JavascriptExecutor js =(JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        moveToElement("Push Awards","Footer",pushAwardsOR.lnk_ftr_advus);
        availableElement("Push Awards","Recommended Section","Ads",pushAwardsOR.txt_rec_sec);

        System.out.println("Title link is : "+pushAwardsOR.txt_rec_sec.getText());

    }

    public void Verify_outBrain_ads_thumb(String PageName){
        SoftAssert softAssert = new SoftAssert();
        moveToElement("Push Awards","Footer",pushAwardsOR.txt_rec_sec);
        int Count= pushAwardsOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+pushAwardsOR.cou_rec_widgets.get(i).getAttribute("id"));
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
     Verify_recom_ads_thumb(pushAwardsOR.txt_rec_sec, pushAwardsOR.cou_rec_widgets, "hi", "hello");
     }
     *************************************************/

    public void Verify_outBrain_ads_link(String PageName){
        SoftAssert soft = new SoftAssert();
        moveToElement("Home page","Footer",pushAwardsOR.txt_rec_sec);
        int Count= pushAwardsOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+pushAwardsOR.cou_rec_widgets.get(i).getAttribute("id"));
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
        moveToElement("Push Awards","Footer",pushAwardsOR.txt_rec_sec);
        int Count= pushAwardsOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+pushAwardsOR.cou_rec_widgets.get(i).getAttribute("id"));
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
