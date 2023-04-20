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
        System.out.println("Creating objecting for Video Article inner PAGE");
    }

    public static VideoArticle getInstance() {
        videoArticle=null;
        if (videoArticle == null) {
            videoArticle = new VideoArticle();
            videoArticleOR = PageFactory.initElements(driver, VideoArticleOR.class);
        }
        return videoArticle;
    }

    public void Verify_trend_section(){
        availableElement("Videos Article inner","Trending now","Sub section",videoArticleOR.txt_trending_sub);
    }
    public void Verify_trend_art(){
        availableElement("Videos Article inner","Trending now","Article",videoArticleOR.lnk_tren_art);
    }
    public void Verify_trend_art_pdate(){
        availableElement("Videos Article inner","Trending now","article post date",videoArticleOR.txt_tren_art_pdate);
    }
    public void Verify_trend_art_num(){
        availableElement("Videos Article inner","Trending now","article number",videoArticleOR.txt_tren_art_num);
    }
    public void Verify_latpho_section(){
        availableElement("Videos Article inner","Latest Photo","Sub section",videoArticleOR.txt_latphotos_sec);
    }
    public void Verify_latpho_art_thumb(){
        availableElement("Videos Article inner","Latest Photo","Article with thumbnail",videoArticleOR.img_latpho_art_thumb);
    }
    public void Verify_latpho_art(){
        availableElement("Videos Article inner","Latest Photo","Article",videoArticleOR.lnk_latpho_art);
    }

    public void Verify_pushtv_title(){

        availableElement("Videos Article inner","Push TV","Title",videoArticleOR.txt_pushtv_title);
    }

    public void Verify_pushtv_description(){
        availableElement("Videos Article inner","Push TV","Description",videoArticleOR.txt_pushtv_desciption);
    }

    public void Verify_pushtv_video(){
        driver.switchTo().frame("player");
        moveToElement("Videos Article inner","Push TV",videoArticleOR.player_pushtv);
        String runtime=videoArticleOR.txt_pushtv_video_art.getText();
        if(runtime.equals("0:00")){
            Assert.assertNotEquals("0:00",runtime,"Push tv video is not playing by default on the videos article inner page");
        }else {
            System.out.println("PUSH Tv video is playing as expected on the videos article inner page");
        }
        driver.switchTo().defaultContent();

    }


    public void Verify_Social_share_fun() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        List socialshare = new ArrayList();
        socialshare.add(videoArticleOR.icn_fb_share);
        socialshare.add(videoArticleOR.icn_tw_share);
        //  socialshare.add(photosArticleOR.icn_vbr_share);


        List socialtitle = new ArrayList();
        socialtitle.add("Facebook");
        socialtitle.add("Compose new Tweet / Twitter");
        //  socialtitle.add("Viber");



        for (int i = 0; i < socialshare.size(); i++) {
            clickElement("Video Article inner", "Social Follow icons", (WebElement) socialshare.get(i));
            switchwindow();
            Thread.sleep(2000);
            String actURL= driver.getTitle();
            String expURL=socialtitle.get(i).toString();
            System.out.println("Title : "+actURL);

            if (expURL.contains(actURL)) {
                System.out.println(actURL+" share Functionality is working as expected on the video article inner page");
            }else {
                softAssert.assertEquals(actURL,expURL," Share functionality not working as expected on the video article inner page");
            }

            driver.close();
            Thread.sleep(5000);
            driver.switchTo().window(Parent);
        }
        softAssert.assertAll();
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void Navigate_to_ty_video(){
        driver.navigate().to("https://uat-push-web.abs-cbn.com/2023/4/5/email-video-content-type-1021");
    }

    public void Verify_yt_Video_play() throws InterruptedException {
        js.executeScript("window.scrollBy(0,80)", "");
        driver.switchTo().frame(videoArticleOR.ifr_yt_player);
        clickElement("Video inner Page","Play button",videoArticleOR.btn_yt_play);
        Thread.sleep(5000);
        act.moveToElement(videoArticleOR.ply_yt_player).perform();
        String time= videoArticleOR.txt_yt_ptime.getText();
        System.out.println("Play time is : "+time);
        int pt= Integer.parseInt(time.replaceAll(":",""));
        if(pt>=0){
            System.out.println("Youtube video is playing and working as expected");
        }else {
            Assert.assertNotEquals(pt,0,"Youtube video is not playing");
        }
    }


    public void Verify_yt_Video_pause(){
        clickElement("Video Inner ","Pause", videoArticleOR.btn_yt_playPause);
        String pause=videoArticleOR.btn_yt_playPause.getAttribute("data-title-no-tooltip");
        System.out.println("Pause value : "+pause);

        if(pause.equals("Play")){
            System.out.println("Video pause functionality is working as expected");
        }else {
            Assert.assertEquals(pause,"Play","Video pause functionality is not working as expected");
        }

    }
    public void Verify_yt_Video_mute(){
        act.moveToElement(videoArticleOR.ply_yt_player).perform();
        clickElement("Video Inner","Mute",videoArticleOR.btn_yt_vol);
        String val=videoArticleOR.btn_yt_vol.getAttribute("data-title-no-tooltip");
        System.out.println("Mute value : "+val);

        if(val.equals("Unmute")){
            System.out.println("Video muted");
        }else {
            Assert.assertEquals(val,"Play","Unable to mute the video");
        }

    }


    public void Verify_yt_Video_Unmute(){
        act.moveToElement(videoArticleOR.ply_yt_player).perform();
        clickElement("Video Inner","Mute",videoArticleOR.btn_yt_vol);
        String val=videoArticleOR.btn_yt_vol.getAttribute("data-title-no-tooltip");
        System.out.println("UnMute value : "+val);

        if(val.equals("Mute")){
            System.out.println("Video unmuted");
        }else {
            Assert.assertEquals(val,"Play","Unable to unmute the video");
        }

    }

    public void Verify_yt_Video_Maximise(){
        act.moveToElement(videoArticleOR.ply_yt_player).perform();
        clickElement("Video Inner","Maximise",videoArticleOR.btn_yt_max);
        String val=videoArticleOR.btn_yt_max.getAttribute("data-title-no-tooltip");
        System.out.println("Max value : "+val);

        if(val.equals("Exit full screen")){
            System.out.println("Able to maximise the video");
        }else {
            Assert.assertEquals(val,"Exit Full screen","Unable to maximise the video");
        }

    }

    public void Verify_yt_Video_Minimise(){
        act.moveToElement(videoArticleOR.ply_yt_player).perform();
        clickElement("Video Inner","Minimise",videoArticleOR.btn_yt_max);
        String val=videoArticleOR.btn_yt_max.getAttribute("data-title-no-tooltip");
        System.out.println("min value : "+val);

        if(val.equals("Full screen")){
            System.out.println("Able to Minimise the video");
        }else {
            Assert.assertEquals(val,"Full screen","Unable to Minimise the video");
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
