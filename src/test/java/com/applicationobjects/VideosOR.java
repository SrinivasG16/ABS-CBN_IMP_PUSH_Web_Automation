package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VideosOR {

    @FindBy(xpath="//*[text()='Videos']")
    public WebElement txt_vid_section;

    @FindBy(xpath="//a[contains(@class,'MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css')]")
    public WebElement img_mainart;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement lnk_mainart;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sub;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_pdate;

    @FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-container css-ce6o4s']//div[contains(@class,'MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_num;

    @FindBy(xpath="//div[text()='Latest photos']")
    public WebElement txt_latphotos_sec;

    @FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-grid-xs-12 css-1avig84']//img[@data-id='image-0']")
    public WebElement img_latpho_art_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-y3digz')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_latpho_art;

    @FindBy(xpath="//button[text()='MORE VIDEOS']")
    public WebElement btn_morevideos;

    @FindBy(xpath="//div[text()='Recently']")
    public WebElement txt_recently_sec;

    @FindBy(xpath="(//img[@loading='eager'])[3]")
    public WebElement img_rec_art_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss')]")
    public WebElement lnk_rec_art;

    @FindBy(xpath="//div[@class='MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom css-ut36iv']")
    public WebElement txt_rec_hashtag;

    @FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-container css-1vsjo3e')]//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushtv_title;

    @FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-10 MuiGrid-grid-sm-8 css-1rh8o1l')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement txt_pushtv_desciption;

    @FindBy(xpath="//div[@elementid='id']/div[1]")
    public WebElement lnk_pushtv_playlists_art;

    @FindBy(xpath="//video[@class='video-stream html5-main-video']")
    public WebElement player_pushtv;

    @FindBy(xpath="//div[@class='MuiBox-root css-1vjzthc']")
    public WebElement img_pushtv_pl_thumb;

    @FindBy(xpath="//div[@elementid='id']/div[2]")
    public WebElement lnk_pushtv_pl_hash;

    @FindBy(xpath="//button[text()='SEE MORE']")
    public WebElement btn_pushtv_seemore;

    @FindBy(xpath="//span[@class='ytp-time-current']")
    public WebElement txt_pushtv_video_art;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss11 css')]"))
    public List<WebElement> lst_art_bf;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss11 css')]"))
    public List<WebElement> lst_art_af;


    @FindAll(@FindBy(xpath="//div[@class='OUTBRAIN' and contains(@id,'outbrain_widget_100')]"))
    public List<WebElement> cou_rec_widgets;

    @FindBy(xpath="//span[text()='RECOMMENDED']")
    public WebElement txt_rec_sec;

    @FindBy(xpath="//div[text()='Advertise with us']")
    public WebElement lnk_ftr_advus;
}
