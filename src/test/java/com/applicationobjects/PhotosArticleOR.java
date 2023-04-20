package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotosArticleOR {

    @FindBy(xpath="//*[@data-testid='FacebookRoundedIcon']")
    public WebElement icn_fb_share;

    @FindBy(xpath="//*[@data-testid='TwitterIcon']")
    public WebElement icn_tw_share;

    @FindBy(xpath="//img[@alt='viber icon']")
    public WebElement icn_vbr_share;

    @FindBy(xpath="//li[@class='slide previous']/div/div/picture/img")
    public WebElement img_art_main;

    @FindBy(xpath="//div[text()='Just in']")
    public WebElement txt_justin_sec;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-1ygtrui')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_just_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-1ygtrui')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_just_art_pdate;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sub;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_pdate;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_num;
}
