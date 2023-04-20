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


    public void Navigate_To_photos(){
        clickElement("Home","Freshscoops header",homePageOR.lnk_hdr_photos);

        String expURL="https://qa-push-web.abs-cbn.com/photos";
        String actURL=driver.getCurrentUrl();
        if(expURL.equals(actURL)){
            System.out.println("Navigated to Photos section page");

            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,800)","");
            js.executeScript("window.scrollBy(0,1200)","");
            js.executeScript("window.scrollBy(0,2000)","");
        }else {
            Assert.assertEquals(actURL,expURL,"unable to navigate to Photos section page");
        }
    }

    public void Navigate_To_videos(){
        clickElement("Home","videos header",homePageOR.lnk_hdr_videos);

        String expURL="https://qa-push-web.abs-cbn.com/videos";
        String actURL=driver.getCurrentUrl();
        if(expURL.equals(actURL)){
            System.out.println("Navigated to Videos section page");

            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,800)","");
            js.executeScript("window.scrollBy(0,1200)","");
            js.executeScript("window.scrollBy(0,2000)","");
        }else {
            Assert.assertEquals(actURL,expURL,"unable to navigate to Videos section page");
        }
    }

    public void Verify_push_logo(){
        availableElement("Home","Push logo","Push Logo",homePageOR.img_push_logo);
    }

    public void Verify_hdr_freshscoops(){
        availableElement("Home","Header links","Fresh scoops header link",homePageOR.lnk_hdr_fresh);
    }
    public void Verify_hdr_photos(){
        availableElement("Home","Header links","Photos header link",homePageOR.lnk_hdr_photos);
    }
    public void Verify_hdr_videos(){
        availableElement("Home","Header links","Videos header link",homePageOR.lnk_hdr_videos);
    }



    public void select_first_thumb(){
       // PageScrollbyJS(homePageOR.txt_pushtv_sec);
        clickElement("Home","Select first thumbnail",homePageOR.img_first_thumb);
    }
    public void Verify_img_slideshow(){
        availableElement("Home","Carousel","slide show thumbnail",homePageOR.img_slideshow);
    }

    public void Verify_slideshow_link(){
        System.out.println("Title is : "+homePageOR.lnk_slideart_title.getText());
        availableElement("Home","Carousel","slide show art link",homePageOR.lnk_slideart_title);

    }

    public void Verify_fs_section(){
       // PageScrollbyJS(homePageOR.img_first_thumb);
        availableElement("Home","Fresh scoops","Fresh scoops section",homePageOR.txt_fs_section);
    }

    public void Verify_fs_art_thumbnail(){
        availableElement("Home","Fresh scoops","Article with thumbnail",homePageOR.img_fs_art);
    }
    public void Verify_fs_art_link(){
        availableElement("Home","Fresh scoops","Article ",homePageOR.lnk_fs_art_title);
    }

    public void Verify_fs_morescoops(){
        availableElement("Home","Fresh scoops","More Scoops ",homePageOR.btn_morescoops);
    }


    public void Verify_pushtv_video() throws InterruptedException {
        moveToElement("Home","Morescoops",homePageOR.btn_morescoops);
        driver.switchTo().frame("player");
        clickElement("Home","Push video",homePageOR.vdo_pushtv);
        Thread.sleep(3000);
        moveToElement("Home","Push TV",homePageOR.player_pushtv);
        String runtime=homePageOR.txt_pushtv_video_art.getText();
        System.out.println("run time is : "+runtime);
        if(!runtime.equals("0:00")){
            System.out.println("PUSH Tv video is playing as expected on the Home Page");

        }else {
            Assert.assertNotEquals("0:00",runtime,"Push tv video is not playing on the Home page");
        }
        driver.switchTo().defaultContent();

    }

    public void Verify_pushtv_title(){
        availableElement("Home","Push TV","Title",homePageOR.txt_pushtv_title);
    }

    public void Verify_pushtv_description(){
        availableElement("Home","Push TV","Description",homePageOR.txt_pushtv_desciption);
    }

    public void Verify_pushtv_playlist_thumbnail(){
        availableElement("Home","Push TV","Playlist thumbnail",homePageOR.img_pushtv_pl_thumb);
    }

    public void Verify_pushtv_playlist_title(){
        availableElement("Home","Push TV","Playlist title",homePageOR.lnk_pushtv_playlists_art);
    }
    public void Verify_pushtv_playlist_hash(){
        availableElement("Home","Push TV","Playlist Description",homePageOR.lnk_pushtv_pl_hash);
    }

    public void Verify_pushtv_seemore(){
        availableElement("Home","Push TV","See More",homePageOR.btn_pushtv_seemore);
    }

    public void Verify_trendn_section() {
        availableElement("Home", "TrendingNow ", "Section", homePageOR.txt_trendn_section);
    }

    public void Verify_trendn_art() {
        availableElement("Home", "Trending Now", "Articles", homePageOR.img_tren_art);
    }

    public void Verify_photos_section() {
        availableElement("Home", "Photos section", "Section", homePageOR.txt_photos_section);
    }

    public void Verify_photos_thumb_Art() {
        availableElement("Home", "Photos section", "Article with thumbnail", homePageOR.img_photos_art);
    }

    public void Verify_photos_art_links() {
        availableElement("Home", "Photos section", "Articles links", homePageOR.lnk_photos_art);
    }

    public void Verify_more_photos() {
        availableElement("Home", "Photos section", "More Photos", homePageOR.btn_morephotos);
    }

    public void Verify_Webstories_section() {
        availableElement("Home", "Web Stories section", "Section", homePageOR.txt_photos_webstories);
    }

    public void Verify_Webstories_thumb_Art() {
        availableElement("Home", "Web Stories section", "Article with thumbnail", homePageOR.img_web_arts);
    }

    public void Verify_ent_section() {
        availableElement("Home", "Entertainment section", "Entertainment Section", homePageOR.txt_abscbn_ent_Section);
    }

    public void rdo_ent_corousel(){
        clickElement("Home","First radio button",homePageOR.rdo_ent_carousel);
    }
    public void Verify_ent_art_thumb() {
        availableElement("Home", "Entertainment section", "Article thumbnail", homePageOR.img_ent_thumbnail);
    }

    public void Verify_ent_art_title() {
        availableElement("Home", "Entertainment section", "Article ", homePageOR.txt_ent_title);
    }

    public void Verify_ent_readmore() {
        availableElement("Home", "Entertainment section", "Read More button ", homePageOR.btn_ent_readmore);
    }

    public void Verify_push_logo_fun(){
        clickElement("Home","Push Logo",homePageOR.img_push_logo);
        String actURL= driver.getCurrentUrl();
        String expURL="https://qa-push-web.abs-cbn.com/";

        if (actURL.equals(expURL)) {
            System.out.println("Push logo Functionality is working as expected");
        }else {
            Assert.assertEquals(actURL,expURL,"Push logo functionality not working as expected");
        }
    }

    public void Verify_hdr_link_fun() {
        SoftAssert softAssert=new SoftAssert();

        List hdrlinks = new ArrayList();
        hdrlinks.add(homePageOR.lnk_hdr_fresh);
        hdrlinks.add(homePageOR.lnk_hdr_photos);
        hdrlinks.add(homePageOR.lnk_hdr_videos);

        List hdrURL = new ArrayList();
        hdrURL.add("https://qa-push-web.abs-cbn.com/fresh-scoops");
        hdrURL.add("https://qa-push-web.abs-cbn.com/photos");
        hdrURL.add("https://qa-push-web.abs-cbn.com/videos");


        for (int i = 0; i < hdrlinks.size(); i++) {
            clickElement("Home", "Header links", (WebElement) hdrlinks.get(i));
            String actURL= driver.getCurrentUrl();
            String expURL=hdrURL.get(i).toString();

            if (actURL.equals(expURL)) {
                System.out.println(actURL+" Section page Functionality is working as expected");
            }else {
                softAssert.assertEquals(actURL,expURL,"Section page functionality not working as expected");
            }

            clickElement("Section ", "Logo", homePageOR.img_push_logo);
        }
        softAssert.assertAll();
    }

    public void Verify_ftr_link_fun() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        List ftrlinks = new ArrayList();
        ftrlinks.add(homePageOR.lnk_ftr_terms);
        ftrlinks.add(homePageOR.lnk_ftr_privacy);
        ftrlinks.add(homePageOR.lnk_ftr_contact);
        ftrlinks.add(homePageOR.lnk_ftr_advus);

        List ftrURL = new ArrayList();
        ftrURL.add("https://www.abs-cbn.com/terms?screen=terms");
        ftrURL.add("https://www.abs-cbn.com/privacy");
        ftrURL.add("https://ent.abs-cbn.com/contact-us");
        ftrURL.add("https://dash.abs-cbn.com/");


        for (int i = 0; i < ftrlinks.size(); i++) {
            clickElement("Home", "Footer links", (WebElement) ftrlinks.get(i));
            String actURL= driver.getCurrentUrl();
            String expURL=ftrURL.get(i).toString();

            if (actURL.equals(expURL)) {
                System.out.println(actURL+" Section page Functionality is working as expected");
            }else {
                softAssert.assertEquals(actURL,expURL,"Section page functionality not working as expected");
            }

            driver.navigate().back();
            Thread.sleep(5000);
        }
        softAssert.assertAll();
    }

    public void Verify_Social_follow_fun() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        List socialfollow = new ArrayList();
        socialfollow.add(homePageOR.icn_fb_flw);
        socialfollow.add(homePageOR.icn_ig_flw);
        socialfollow.add(homePageOR.icn_tw_flw);
        socialfollow.add(homePageOR.icn_yt_flw);

        List socialtitle = new ArrayList();
        socialtitle.add("Push - Home | Facebook");
        socialtitle.add("Push (@pushalerts) • Instagram photos and videos");
        socialtitle.add("PUSH ALERTS (@Push_Alerts) / Twitter");
        socialtitle.add("Push - YouTube");


        for (int i = 0; i < socialfollow.size(); i++) {

            clickElement("Home", "Social Follow icons", (WebElement) socialfollow.get(i));
            switchwindow();
            String actURL= driver.getTitle();
            String expURL=socialtitle.get(i).toString();
            System.out.println("Title : "+actURL);

            if (expURL.contains(actURL)) {
                getScreenshot();
                System.out.println(actURL+" functionality is working as expected");
            }else {
                getScreenshot();
                softAssert.assertEquals(actURL,expURL," functionality not working as expected");
            }

            driver.close();
            driver.switchTo().window(Parent);
            Thread.sleep(5000);
        }
        softAssert.assertAll();
    }

    public void verify_page_titles() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        String acthome=driver.getTitle();
        String exphome="PUSH";
        if(acthome.contains(exphome)){
            System.out.println("Home Page title is matching as expected");
        }else{
            softAssert.assertEquals(acthome,exphome,"Home page title is not available/matched");
        }

        homePage.Navigate_To_freshscoops();
        String actfs=driver.getTitle();
        String expfs="FRESH-SCOOPS";
        if(actfs.contains(expfs)){
            System.out.println("Fresh Scoops Page title is matching as expected");
        }else{
            softAssert.assertEquals(actfs,expfs,"Fresh Scoops page title is not available/matched");
        }
        driver.navigate().back();
        homePage.Navigate_To_photos();
        String actp=driver.getTitle();
        String expp="PHOTOS";
        if(actp.contains(expp)){
            System.out.println("Photos Page title is matching as expected");
        }else{
            softAssert.assertEquals(actp,expp,"Photos page title is not available/matched");
        }
        driver.navigate().back();
        homePage.Navigate_To_videos();

        String actv=driver.getTitle();
        String expv="VIDEOS";
        if(actv.contains(expv)){
            System.out.println("Videos Page title is matching as expected");
        }else{
            softAssert.assertEquals(actv,expv,"Videos page title is not available/matched");
        }

        softAssert.assertAll();

    }



    public void Verify_Freshscoops_MouseHover_items(){
        Actions builder = new Actions(driver);
        builder.moveToElement(homePageOR.lnk_hdr_fresh).build().perform();
        int count =0;

        for(int i=0;i<homePageOR.dd_freshscoops_items.size();i++){
            availableElement("Home Page","FreshScoops ","MouseHover items",homePageOR.dd_freshscoops_items.get(i));
            count++;
            System.out.println("Link is : "+homePageOR.dd_freshscoops_items.get(i).getText());
        }

        if (count == 5) {
            System.out.println("We have 5 freshscoops mouse hover items");
        }else {
            Assert.assertEquals(count,5,"We have "+count+" itmes only in Fresh scoops mousehover functionality");
        }
    }

    public void Verify_Videos_MouseHover_items(){
        Actions builder = new Actions(driver);
        builder.moveToElement(homePageOR.lnk_hdr_videos).build().perform();
        int count =0;

        for(int i=0;i<homePageOR.dd_videos_items.size();i++){
            availableElement("Home Page","Videos ","MouseHover items",homePageOR.dd_videos_items.get(i));
            count++;
            System.out.println("Link is : "+homePageOR.dd_videos_items.get(i).getText());
        }

        if (count == 5) {
            System.out.println("We have 5 videos mouse hover items");
        }else {
            Assert.assertEquals(count,5,"We have "+count+" itmes only in videos mousehover functionality");
        }
    }

    public void Verify_Photos_MouseHover_items(){
        Actions builder = new Actions(driver);
        builder.moveToElement(homePageOR.lnk_hdr_photos).build().perform();
        int count =0;

        for(int i=0;i<homePageOR.dd_photos_items.size();i++){
            availableElement("Home Page","Photos ","MouseHover items",homePageOR.dd_photos_items.get(i));
            count++;
            System.out.println("Link is : "+homePageOR.dd_photos_items.get(i).getText());
        }

        if (count == 5) {
            System.out.println("We have 5 Photos mouse hover items");
        }else {
            Assert.assertEquals(count,5,"We have "+count+" itmes only in Photos mousehover functionality");
        }
    }

    public void Verify_hdr_pushawards(){
        availableElement("Home","Header links","Push Awards header image",homePageOR.img_push_awards);
    }

    public void Verify_txt_search(){
        availableElement("Home","Header ","Search text box",homePageOR.txt_serach);
    }

    public void Verify_btn_search(){
        availableElement("Home","Header ","Search button",homePageOR.btn_search);
    }

    public void Verify_MoreScoops_btn_fun(){
       clickElement("Home","More scoops button",homePageOR.btn_morescoops);

        String expTitle="FRESH-SCOOPS | PUSH.COM.PH";
        String actTitle=driver.getTitle();

        if (expTitle.equals(actTitle)) {
            System.out.println("More scoops button functionality working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"More scoops button functionality not working as expected");
        }
    }

    public void Verify_SeeMore_btn_fun(){
        clickElement("Home","See More button",homePageOR.btn_pushtv_seemore);

        String expTitle="VIDEOS | PUSH.COM.PH";
        String actTitle=driver.getTitle();

        if (expTitle.equals(actTitle)) {
            System.out.println("See More button functionality working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"See More button functionality not working as expected");
        }
    }

    public void Verify_MorePhotos_btn_fun(){
        clickElement("Home","More Photos button",homePageOR.btn_morephotos);

        String expTitle="PHOTOS | PUSH.COM.PH";
        String actTitle=driver.getTitle();

        if (expTitle.equals(actTitle)) {
            System.out.println("More Photos button functionality working as expected");
        }else {
            Assert.assertEquals(actTitle,expTitle,"More Photos button functionality not working as expected");
        }
    }

    public void Verify_TellmeMore_fun(){

        clickElement("Home","Tell me more", homePageOR.lnk_tellme_more);
        switchwindow();

        String expUrl="https://www.abs-cbn.com/privacy";
        String actUrl=driver.getCurrentUrl();

        System.out.println("Actual : "+actUrl);

        if(expUrl.equals(actUrl)){
            System.out.println("Tell me more! link is working as expected");
        }else {
            getScreenshot();
            Assert.assertEquals(actUrl,expUrl,"Tell me more! link is not working as expected");
        }

    }

    public void Verify_IAgree_btn(){
        availableElement("Home","footer","I Agree Cookie button",homePageOR.btn_ftr_iagree);

    }

    public void Navigate_To_PushAwards(){
        //clickElement("Home","Push Awards image",homePageOR.img_push_awards);
        driver.navigate().to("https://qa-push-web.abs-cbn.com/push-awards");

        String expURL="https://qa-push-web.abs-cbn.com/push-awards";
        String actURL=driver.getCurrentUrl();
        if(expURL.equals(actURL)){
            System.out.println("Navigated to Push Awards section page");
        }else {
            Assert.assertEquals(actURL,expURL,"unable to navigate to Push Awards section page");
        }
    }

    public void Verify_Webstories(){
        moveToElement("Home page","Trending now",homePageOR.txt_trendn_section);
        clickElement("Home","Web stories articles",homePageOR.img_web_arts);

        String title= driver.getTitle();

        System.out.println("Title is : "+title);
        if(title.contains("webstory")){
            System.out.println("Home page is redirecting to Web stories inner page");
        }else {
            Assert.assertEquals(true,title.contains("web stories"),"Home page is not redirecting to Web stories inner page");
        }
    }

    public void Verify_Webstories_rightArrow(){
        availableElement("Web Stories Inner"," Web stories articles","Right icon",homePageOR.icn_webstory_next);
    }

    public void Verify_Webstories_leftArrow(){
        clickElement("Web Stories Inner","Right arrow",homePageOR.icn_webstory_next);
        availableElement("Web Stories Inner"," Web stories articles","left icon",homePageOR.icn_webstory_prev);
    }

    public void Verify_Webstories_share(){
        availableElement("Web Stories Inner"," Web stories articles","Share button",homePageOR.btn_webstory_share);
    }

    JavascriptExecutor js =(JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        moveToElement("Home page","Footer",homePageOR.lnk_ftr_advus);
        availableElement("Home","Recommended Section","Ads",homePageOR.txt_rec_sec);

        System.out.println("Title link is : "+homePageOR.txt_rec_sec.getText());

    }

    public void Verify_outBrain_ads_thumb(String PageName){
        SoftAssert softAssert = new SoftAssert();
        moveToElement("Home page","Footer",homePageOR.txt_rec_sec);
        int Count= homePageOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+homePageOR.cou_rec_widgets.get(i).getAttribute("id"));
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    String jsthumb="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > span > img\")";
                    //System.out.println(jsthumb);
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
        Verify_recom_ads_thumb(homePageOR.txt_rec_sec, homePageOR.cou_rec_widgets, "hi", "hello");
    }
    *************************************************/

    public void Verify_outBrain_ads_link(String PageName){
        SoftAssert soft = new SoftAssert();
        moveToElement("Home page","Footer",homePageOR.txt_rec_sec);
        int Count= homePageOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+homePageOR.cou_rec_widgets.get(i).getAttribute("id"));
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    String jslink="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > span > section > span.ob-unit.ob-rec-text\")";
                    //System.out.println(jslink);
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
        moveToElement("Home page","Footer",homePageOR.txt_rec_sec);
        int Count= homePageOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+homePageOR.cou_rec_widgets.get(i).getAttribute("id"));
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) js.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    String jsthumb="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > section > span.ob-unit.ob-rec-source\")";
                   // System.out.println(jsthumb);
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

    public void Verify_Webstories_NextArtarrow(){
        availableElement("Web Stroies Inner"," Webstories artilces","Next article arrow",homePageOR.btn_webstory_nextArt);

    }

    public void Verify_Webstories_prevArtarrow(){
        clickElement("Web Stroies Inner","Next article arrow",homePageOR.btn_webstory_nextArt);
        availableElement("Web Stroies Inner"," Webstories artilces","Next article arrow",homePageOR.btn_webstory_prevArt);

    }

    public void Verify_Webstories_Close(){
        availableElement("Web Stroies Inner"," Webstories artilces","Close button",homePageOR.img_webstory_close);
    }

    public void Verify_Webstories_launchart(){
        availableElement("Web Stroies Inner"," Webstories artilces","Launch icon",homePageOR.icn_webstory_launch);

    }

    public void Verify_Webstories_Close_fun(){
        String curURL=driver.getCurrentUrl();
        clickElement("Web Stories","Close button",homePageOR.img_webstory_close);
        String actURL= driver.getCurrentUrl();

        if(actURL.equals(curURL)){
            Assert.assertNotEquals(actURL,curURL,"Web Stories close functionality not working as expected");
        }else{
            System.out.println("Web Stories close functionality working as expected");
        }
    }

    public void Verify_Search() {
        availableElement("Home", "Search", "Search text box", homePageOR.inp_search);
    }

    public void Verify_Search_icon() {

        availableElement("Home", "Search", "Search text box", homePageOR.icn_search);
    }

    public void Verify_Search_fun(String searchKey) throws InterruptedException {
//        String searchKey="Hello hi hollywood";
        System.out.println("We are searching with the "+searchKey+" keyword/letter/character/Special character");
        String searchk="";
      homePageOR.inp_search.sendKeys(searchKey);
      clickElement("Home","Search icon",homePageOR.icn_search);
      Thread.sleep(3000);
        if(searchKey.contains(" ")){
            searchk=searchKey.replace(" ","+");
            System.out.println(searchk);
        } else if (searchKey.contains("+")) {
            searchk=searchKey.replace("+","%2B");
            System.out.println(searchk);
        }else if (searchKey.contains("=")) {
            searchk=searchKey.replace("=","%3");
            System.out.println(searchk);
        }else {
            searchk=searchKey;
            System.out.println(searchk);
        }
       // System.out.println(searchk);

        String actURL= driver.getCurrentUrl();
        String expURL="https://qa-push-web.abs-cbn.com/search?q="+searchk;

        if(actURL.equals(expURL)){
            System.out.println("Search functionality working as expected");
        }else {
            Assert.assertEquals(actURL,expURL,"Search functionality not working as expected");
        }

    }
}