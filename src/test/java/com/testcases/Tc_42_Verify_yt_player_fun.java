package com.testcases;

import com.applicationpages.VideoArticle;
import com.genericmethods.GenericMethods;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Tc_42_Verify_yt_player_fun extends GenericMethods {
    VideoArticle videoArticle;

    @Description("Launching the browser")
    @Test(priority =0)
    public void launchbrowser() throws InterruptedException {
        launchBrowser();
        manageCookies();
    }

    @Description("Navigate to Video article")
    @Test(priority =1)
    public void verify_push_logo_fun() throws InterruptedException {
        videoArticle=VideoArticle.getInstance();
        videoArticle.Navigate_to_ty_video();
    }

    @Description("Verification for Functionality of play the video")
    @Test(priority =2)
    public void verify_yt_Video_play() throws InterruptedException {
        videoArticle.Verify_yt_Video_play();
    }

    @Description("Verification for Functionality of Maximise the video")
    @Test(priority =3)
    public void Verify_yt_Video_Maximise() throws InterruptedException {
        videoArticle.Verify_yt_Video_Maximise();
    }

    @Description("Verification for Functionality of minimise the video")
    @Test(priority =4)
    public void Verify_yt_Video_Minimise() throws InterruptedException {
        videoArticle.Verify_yt_Video_Minimise();
    }

    @Description("Verification for Functionality of mute the video")
    @Test(priority =5)
    public void Verify_yt_Video_mute() throws InterruptedException {
        videoArticle.Verify_yt_Video_mute();
    }

    @Description("Verification for Functionality of unmute the video")
    @Test(priority =6)
    public void Verify_yt_Video_Unmute() throws InterruptedException {
        videoArticle.Verify_yt_Video_Unmute();
    }

    @Description("Verification for Functionality of pause the video")
    @Test(priority =7)
    public void verify_yt_Video_pause() throws InterruptedException {
        videoArticle.Verify_yt_Video_pause();
    }
}
