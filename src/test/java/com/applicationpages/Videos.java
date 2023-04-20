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
        System.out.println("Creating objecting for Videos PAGE");
    }

    public static Videos getInstance() {
        videos=null;
        if (videos == null) {
            videos = new Videos();
            videosOR = PageFactory.initElements(driver, VideosOR.class);
        }
        return videos;
    }

    public void Verify_videos_section(){
        availableElement("Videos","Videos","Videos Sub section",videosOR.txt_vid_section);
    }
    public void Verify_main_art_thumb(){
        availableElement("Videos","Main article","Article with thumbnail",videosOR.img_mainart);
    }
    public void Verify_main_art_link(){
        availableElement("Videos","Main article","Article",videosOR.lnk_mainart);
    }
    public void Verify_trendnow_section(){
        availableElement("Videos","Trending now","Sub section",videosOR.txt_trending_sub);
    }
    public void Verify_trendnow_art(){
        availableElement("Videos","Trending now","Article",videosOR.lnk_tren_art);
    }
    public void Verify_trendnow_art_pdate(){
        availableElement("Videos","Trending now","article post date",videosOR.txt_tren_art_pdate);
    }
    public void Verify_trendnow_art_num(){
        availableElement("Videos","Trending now","article number",videosOR.txt_tren_art_num);
    }
    public void Verify_latpho_section(){
        availableElement("Videos","Latest Photo","Sub section",videosOR.txt_latphotos_sec);
    }
    public void Verify_latpho_art_thumb(){
        availableElement("Videos","Latest Photo","Article with thumbnail",videosOR.img_latpho_art_thumb);
    }
    public void Verify_latpho_art(){
        availableElement("Videos","Latest Photo","Article",videosOR.lnk_latpho_art);
    }
    public void Verify_morevideos(){
        availableElement("Videos","More Videos","More videos button",videosOR.btn_morevideos);
    }



    public void Verify_pushtv_video(){
        driver.switchTo().frame("player");
        moveToElement("Videos","Push TV",videosOR.player_pushtv);
        String runtime=videosOR.txt_pushtv_video_art.getText();
        if(runtime.equals("0:00")){
            Assert.assertNotEquals("0:00",runtime,"Push tv video is not playing by default on the videos page");
        }else {
            System.out.println("PUSH Tv video is playing as expected on the videos page");
        }
        driver.switchTo().defaultContent();

    }
    public void Verify_pushtv_title(){
        availableElement("Videos","Push TV","Title",videosOR.txt_pushtv_title);
    }

    public void Verify_pushtv_description(){
        availableElement("Videos","Push TV","Description",videosOR.txt_pushtv_desciption);
    }

    public void Verify_pushtv_playlist_thumbnail(){
        availableElement("Videos","Push TV","Playlist thumbnail",videosOR.img_pushtv_pl_thumb);
    }

    public void Verify_pushtv_playlist_title(){
        availableElement("Videos","Push TV","Playlist title",videosOR.lnk_pushtv_playlists_art);
    }
    public void Verify_pushtv_playlist_hash(){
        availableElement("Videos","Push TV","Playlist Description",videosOR.lnk_pushtv_pl_hash);
    }

    public void Verify_pushtv_seemore(){
        availableElement("Videos","Push TV","See More",videosOR.btn_pushtv_seemore);
    }

    public void Navigate_To_VideoArticleinner(){
        clickElement("Videos","Main article", videosOR.img_mainart);
    }


    public void Verify_recently_section(){
        availableElement("Videos","Recently","Sub section",videosOR.txt_recently_sec);
    }
    public void Verify_recently_art_thumb(){
        availableElement("Videos","Recently","Article with thumbnail",videosOR.img_rec_art_thumb);
    }
    public void Verify_recently_art(){
        availableElement("Videos","Recently","Article",videosOR.lnk_rec_art);
    }

    public void Verify_vd_MoreVideos_fun() throws InterruptedException {
        int artCount_bf=videosOR.lst_art_bf.size();
        System.out.println("Before : "+artCount_bf);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)","");
        js.executeScript("window.scrollBy(0,1200)","");
        js.executeScript("window.scrollBy(0,2000)","");

        clickElement("Videos","More Videos",videosOR.btn_morevideos);
        Thread.sleep(2000);
        int artCount_af=videosOR.lst_art_af.size();
        System.out.println("After : "+artCount_af);

        if(artCount_af!=artCount_bf){
            System.out.println("More Videos button functionality working as expected");
        }else{
            Assert.assertNotEquals(artCount_af,artCount_bf,"More Videos button functionality not working as expected");
        }

    }
    JavascriptExecutor js =(JavascriptExecutor) driver;
    public void Verify_Recom_sec(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        moveToElement("Videos","Footer",videosOR.lnk_ftr_advus);
        availableElement("Videos","Recommended Section","Ads",videosOR.txt_rec_sec);

        System.out.println("Title link is : "+videosOR.txt_rec_sec.getText());

    }

    public void Verify_outBrain_ads_thumb(String PageName){
        SoftAssert softAssert = new SoftAssert();
        moveToElement("Videos","Footer",videosOR.txt_rec_sec);
        int Count= videosOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+videosOR.cou_rec_widgets.get(i).getAttribute("id"));
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
     Verify_recom_ads_thumb(videosOR.txt_rec_sec, videosOR.cou_rec_widgets, "hi", "hello");
     }
     *************************************************/

    public void Verify_outBrain_ads_link(String PageName){
        SoftAssert soft = new SoftAssert();
        moveToElement("Home page","Footer",videosOR.txt_rec_sec);
        int Count= videosOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+videosOR.cou_rec_widgets.get(i).getAttribute("id"));
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
        moveToElement("Videos","Footer",videosOR.txt_rec_sec);
        int Count= videosOR.cou_rec_widgets.size();
        System.out.println("We have "+Count+ " placeholders ");
        for(int i=0;i<Count;i++) {
            System.err.println("OutBrain Place holder id : "+videosOR.cou_rec_widgets.get(i).getAttribute("id"));
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
