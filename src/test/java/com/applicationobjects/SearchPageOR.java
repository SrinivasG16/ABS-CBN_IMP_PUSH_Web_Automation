package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPageOR {

    @FindBy(xpath="//div[@id='headerLogo']/img")
    public WebElement img_push_logo;

    @FindBy(xpath="//div[text()='FRESH SCOOPS']")
    public WebElement lnk_hdr_fresh;

    @FindBy(xpath="//div[text()='PHOTOS']")
    public WebElement lnk_hdr_photos;

    @FindBy(xpath="//div[text()='VIDEOS']")
    public WebElement lnk_hdr_videos;

    @FindBy(xpath="//img[@alt='Push Awards']")
    public WebElement img_push_awards;

    @FindBy(xpath="//input[contains(@class,'MuiInputBase-input css')]")
    public WebElement inp_search;

    @FindBy(xpath="//*[@data-testid='SearchIcon']")
    public WebElement icn_search;

    @FindBy(xpath="//ul[@class='control-dots']/li[1]")
    public WebElement dot_slider;

    @FindBy(xpath="//li[@class='slide previous']//picture[@style='position: relative;']/img")
    public WebElement img_video_slider_thumb;

    @FindBy(xpath="//div[text()='Latest photos']")
    public WebElement txt_latest_sec;

    @FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-grid-xs-12 css')]//img[@data-id='image-0']")
    public WebElement img_latest_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-grid-xs-12 css')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_latest_art;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sec;

    @FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-item css')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_trend_art;


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

    @FindBy(xpath="//*[@data-testid='FacebookRoundedIcon']")
    public WebElement icn_fb_flw;

    @FindBy(xpath="//*[@data-testid='InstagramIcon']")
    public WebElement icn_ig_flw;

    @FindBy(xpath="//*[@data-testid='TwitterIcon']")
    public WebElement icn_tw_flw;

    @FindBy(xpath="//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css-1hy5x16']")
    public WebElement txt_copyright;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement txt_count_results;

    @FindAll(@FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css-e')]"))
    public List<WebElement> lst_indCount;

    @FindBy(xpath="//div[text()='No Results Found']")
    public WebElement txt_noresult;

    @FindBy(xpath="")
    public WebElement l;

    @FindBy(xpath="")
    public WebElement m;

    @FindBy(xpath="")
    public WebElement n;

    @FindBy(xpath="")
    public WebElement o;

    @FindBy(xpath="")
    public WebElement p;

    @FindBy(xpath="")
    public WebElement q;

    @FindBy(xpath="")
    public WebElement r;

    @FindBy(xpath="")
    public WebElement s;

    @FindBy(xpath="")
    public WebElement t;

    @FindBy(xpath="")
    public WebElement u;

    @FindBy(xpath="")
    public WebElement v;

    @FindBy(xpath="")
    public WebElement w;

    @FindBy(xpath="")
    public WebElement x;

    @FindBy(xpath="")
    public WebElement y;

    @FindBy(xpath="")
    public WebElement z;
}
