package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoArticleOR {

    @FindBy(xpath="//*[@data-testid='FacebookRoundedIcon']")
    public WebElement icn_fb_share;

    @FindBy(xpath="//*[@data-testid='TwitterIcon']")
    public WebElement icn_tw_share;

    @FindBy(xpath="//img[@alt='viber icon']")
    public WebElement icn_vbr_share;

    @FindBy(xpath="//div[text()='Latest photos']")
    public WebElement txt_latphotos_sec;

    @FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-grid-xs-12 css-1avig84']//img[@data-id='image-0']")
    public WebElement img_latpho_art_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-y3digz')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_latpho_art;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sub;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_pdate;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_num;

    @FindBy(xpath="//video[@class='video-stream html5-main-video']")
    public WebElement player_pushtv;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushtv_title;

    @FindBy(xpath="//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css-n4iohf']")
    public WebElement txt_pushtv_desciption;

    @FindBy(xpath="//span[@class='ytp-time-current']")
    public WebElement txt_pushtv_video_art;

    @FindBy(xpath = "//button[@aria-label='Play']")
    public WebElement btn_yt_play;

    @FindBy(xpath="//video[@class='video-stream html5-main-video']")
    public WebElement ply_yt_player;

    @FindBy(xpath="//span[@class='ytp-time-current']")
    public WebElement txt_yt_ptime;

    @FindBy(xpath="//div[@id='headerLogo']/img")
    public WebElement img_push_logo;

    @FindBy(xpath="//div[@id='message']//parent::div/iframe")
    public WebElement ifr_yt_player;

    @FindBy(xpath="//div[text()='Recently']")
    public WebElement txt_rec_sec;

    @FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
    public WebElement btn_yt_playPause;

    @FindBy(xpath="//button[@class='ytp-mute-button ytp-button']")
    public WebElement btn_yt_vol;

    @FindBy(xpath="//button[@class='ytp-fullscreen-button ytp-button']")
    public WebElement btn_yt_max;

    @FindBy(xpath="")
    public WebElement i;

    @FindBy(xpath="")
    public WebElement j;

    @FindBy(xpath="")
    public WebElement l;

    @FindBy(xpath="")
    public WebElement m;

}
