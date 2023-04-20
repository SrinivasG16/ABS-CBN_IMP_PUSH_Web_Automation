package com.applicationobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageOR {

    @FindBy(xpath="//div[@id='headerLogo']/img")
    public WebElement img_push_logo;

    @FindBy(xpath="//div[text()='FRESH SCOOPS']")
    public WebElement lnk_hdr_fresh;

    @FindBy(xpath="//div[text()='PHOTOS']")
    public WebElement lnk_hdr_photos;

    @FindBy(xpath="//div[text()='VIDEOS']")
    public WebElement lnk_hdr_videos;

    @FindBy(xpath="(//ul[@class='thumbs animated']/li)[1]")
    public WebElement img_first_thumb;

    @FindBy(xpath="//li[@class='slide previous']//picture[@style='position: relative;']/img")
    public WebElement img_slideshow;


    @FindBy(xpath="//li[@class='slide selected']//div[contains(@class,'MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom css')]")
    public WebElement lnk_slideart_title;

    @FindBy(xpath="//img[@data-id='image-0']")
    public WebElement img_fs_art;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss')]")
    public WebElement lnk_fs_art_title;

    @FindBy(xpath="//button[text()='MORE SCOOPS']")
    public WebElement btn_morescoops;


    @FindBy(xpath="//div[text()='Fresh scoops']")
    public WebElement txt_fs_section;

//    @FindBy(xpath="//div[text()=' On PUSH TV']")
//    public WebElement txt_pushtv_sec;

    @FindBy(xpath="//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")
    public WebElement vdo_pushtv;

    @FindBy(xpath="//video[@class='video-stream html5-main-video']")
    public WebElement player_pushtv;

    @FindBy(xpath="//span[@class='ytp-time-current']")
    public WebElement txt_pushtv_video_art;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushtv_title;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushtv_desciption;

    @FindBy(xpath="//div[@elementid='id']/div[1]")
    public WebElement lnk_pushtv_playlists_art;

    @FindBy(xpath="//div[@class='MuiBox-root css-1vjzthc']")
    public WebElement img_pushtv_pl_thumb;

    @FindBy(xpath="//div[@elementid='id']/div[2]")
    public WebElement lnk_pushtv_pl_hash;

    @FindBy(xpath="//button[text()='SEE MORE']")
    public WebElement btn_pushtv_seemore;

    @FindBy(xpath="//div[text()='Trending now']")
    public WebElement txt_trendn_section;

    @FindBy(xpath="//div[@class='MuiBox-root css-175qxu8']//parent::picture/img")
    public WebElement img_tren_art;

    @FindBy(xpath="(//div[text()='Trending now']//parent::div//parent::div//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')])[2]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[text()='Photos']")
    public WebElement txt_photos_section;

    @FindBy(xpath="//div[@data-testid='renderPhotos']//child::picture/img")
    public WebElement img_photos_art;

    @FindBy(xpath="//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-1cnbq4a']//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_photos_art;

    @FindBy(xpath="//button[text()='more Photos']")
    public WebElement btn_morephotos;

    @FindBy(xpath="//div[text()='Web Stories']")
    public WebElement txt_photos_webstories;

    @FindBy(xpath="//div[@class='MuiBox-root css-1q3lzqi']")
    public WebElement img_web_arts;

    @FindBy(xpath="//div[text()='From ABS-CBN entertainment']")
    public WebElement txt_abscbn_ent_Section;

    @FindBy(xpath="//ul[@class='control-dots']/li")
    public WebElement rdo_ent_carousel;

    @FindBy(xpath="//li[@class='slide selected previous']//img[@alt='image']")
    public WebElement img_ent_thumbnail;

    @FindBy(xpath="//div[@class='MuiBox-root css-15786vt']//div[contains(@class,'MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom css')]")
    public WebElement txt_ent_title;

    @FindBy(xpath="//button[text()='READ MORE']")
    public WebElement btn_ent_readmore;



    @FindBy(xpath="//div[text()='Terms of use']")
    public WebElement lnk_ftr_terms;

    @FindBy(xpath="//div[text()='Privacy policy']")
    public WebElement lnk_ftr_privacy;

    @FindBy(xpath="//div[text()='Contact Us']")
    public WebElement lnk_ftr_contact;

    @FindBy(xpath="//div[text()='Advertise with us']")
    public WebElement lnk_ftr_advus;

    @FindBy(xpath="//*[@data-testid='YouTubeIcon']")
    public WebElement icn_yt_flw;

    @FindBy(xpath="(//*[@data-testid='FacebookRoundedIcon'])[2]")
    public WebElement icn_fb_flw;

    @FindBy(xpath="//*[@data-testid='InstagramIcon']")
    public WebElement icn_ig_flw;

    @FindBy(xpath="(//*[@data-testid='TwitterIcon'])[2]")
    public WebElement icn_tw_flw;

    @FindAll(@FindBy(xpath="//div[@id='navlinks-1']//div[contains(@class,'MuiBox-root css')]/a"))
    public List<WebElement> dd_freshscoops_items;

    @FindAll(@FindBy(xpath="//div[@id='navlinks-2']//div[contains(@class,'MuiBox-root css')]/a"))
    public List<WebElement> dd_photos_items;

    @FindAll(@FindBy(xpath="//div[@id='navlinks-3']//div[contains(@class,'MuiBox-root css')]/a"))
    public List<WebElement> dd_videos_items;

    @FindBy(xpath="//img[@alt='Push Awards']")
    public WebElement img_push_awards;

    @FindBy(xpath="//input[@placeholder='Search']")
    public WebElement txt_serach;

    @FindBy(xpath="//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css')]")
    public WebElement btn_search;

    @FindBy(xpath="//a[text()='Tell me more!']")
    public WebElement lnk_tellme_more;

    @FindBy(xpath="//span[text()='RECOMMENDED']")
    public WebElement txt_rec_sec;

    @FindBy(css="img.ob-rec-image ob-show")
    public WebElement img_rec_sec_art;

    @FindBy(xpath="span.ob-unit ob-rec-text")
    public WebElement lnk_rec_sec_art;

    @FindBy(xpath="//div[@class='i-amphtml-story-button-container i-amphtml-story-fwd-next next-container']")
    public WebElement icn_webstory_next;

    @FindBy(xpath="//div[@class='i-amphtml-story-button-container i-amphtml-story-back-prev prev-container']")
    public WebElement icn_webstory_prev;

    @FindBy(xpath="//button[@class='i-amphtml-story-share-control i-amphtml-story-button']")
    public WebElement btn_webstory_share;


    @FindBy(xpath="//img[@class='i-amphtml-fill-content i-amphtml-replaced-content']")
    public WebElement img_webstory_close;

    @FindBy(xpath="//*[@class='rmq-fc62e5c1 rmq-cd1c2532 rmq-122c08f2 rmq-8655b5f0']/a/img")
    public WebElement btn_webstory_prevArt;

    @FindBy(xpath="//*[@class='rmq-940aaa25 rmq-e982d3d6 rmq-d1ffe696 rmq-14c0b094']/a/img")
    public WebElement btn_webstory_nextArt;

    @FindBy(xpath="//*[@data-testid='LaunchIcon']")
    public WebElement icn_webstory_launch;

    @FindBy(xpath="//button[text()='I Agree!']")
    public WebElement btn_ftr_iagree;

    @FindBy(xpath="//input[contains(@class,'MuiInputBase-input css')]")
    public WebElement inp_search;

    @FindBy(xpath="//*[@data-testid='SearchIcon']")
    public WebElement icn_search;

    @FindAll(@FindBy(xpath="//div[@class='OUTBRAIN' and contains(@id,'outbrain_widget_100')]"))
    public List<WebElement> cou_rec_widgets;









}
