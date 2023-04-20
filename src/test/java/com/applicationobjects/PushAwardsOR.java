package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PushAwardsOR {
    @FindBy(xpath="//div[@class='carousel carousel-slider']//ul[@class='slider animated']/li")
    public WebElement img_hero_banner;

    @FindBy(xpath="//div[@class='carousel']//div[contains(@class,'MuiBox-root css')]")
    public WebElement thumb_hero_carousel;

    @FindBy(xpath="(//ul[@class='thumbs animated']/li)[1]")
    public WebElement img_first_thumb;

    @FindBy(xpath="//li[@class='slide previous']//picture[@style='position: relative;']/img")
    public WebElement img_slideshow;

    @FindBy(xpath="//div[@class='carousel carousel-slider']//ul[@class='slider animated']//div[contains(@class,'MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom css')]")
    public WebElement lnk_hero_carousel;

    @FindBy(xpath="//div[@class='carousel carousel-slider']//ul[@class='slider animated']//div[contains(@class,'MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom css')]")
    public WebElement txt_hero_carousel_pdate;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css')]/h3")
    public WebElement txt_hero_carousel_desc;

    @FindBy(xpath="//div[text()='PUSH Awards 2022 Categories']")
    public WebElement txt_pushawards_sec;

    @FindBy(xpath="//img[@data-id='image-0']")
    public WebElement img_pushawards_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss12 css')]")
    public WebElement lnk_pushawards_art;

    @FindBy(xpath="//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")
    public WebElement btn_pushawrads_vdo;

    @FindBy(xpath="//video[@class='video-stream html5-main-video']")
    public WebElement player_pushawards;

    @FindBy(xpath="//span[@class='ytp-time-current']")
    public WebElement txt_pushawards_video_art;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushawards_title;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushawards_desciption;

    @FindBy(xpath="//div[@elementid='id']/div[1]")
    public WebElement lnk_pushawards_playlists_art;

    @FindAll    (@FindBy(xpath="//div[@elementid='id']/div[1]"))
    public List<WebElement> lst_pushawards_playlists_bf;

    @FindAll    (@FindBy(xpath="//div[@elementid='id']/div[1]"))
    public List<WebElement> lst_pushawards_playlists_af;

    @FindBy(xpath="//div[@class='MuiBox-root css-1vjzthc']")
    public WebElement img_pushawards_pl_thumb;

    @FindBy(xpath="//div[@elementid='id']/div[2]")
    public WebElement lnk_pushawards_pl_hash;

    @FindBy(xpath="//button[text()='SEE MORE']")
    public WebElement btn_pushawards_seemore;

    @FindBy(xpath="//div[text()='Trending now']")
    public WebElement txt_trendn_section;

    @FindBy(xpath="//div[@class='MuiBox-root css-175qxu8']//parent::picture/img")
    public WebElement img_tren_art;

    @FindBy(xpath="(//div[text()='Trending now']//parent::div//parent::div//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')])[2]")
    public WebElement lnk_tren_art;


    @FindBy(xpath="//div[text()='Web Stories']")
    public WebElement txt_photos_webstories;

    @FindBy(xpath="//div[@class='MuiBox-root css-1q3lzqi']")
    public WebElement img_web_arts;

    @FindAll(@FindBy(xpath="//div[@class='OUTBRAIN' and contains(@id,'outbrain_widget_100')]"))
    public List<WebElement> cou_rec_widgets;

    @FindBy(xpath="//span[text()='RECOMMENDED']")
    public WebElement txt_rec_sec;

    @FindBy(xpath="//div[text()='Advertise with us']")
    public WebElement lnk_ftr_advus;
}
