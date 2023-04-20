package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreshScoopsArticleOR {

    @FindBy(xpath="//*[@data-testid='FacebookRoundedIcon']")
    public WebElement icn_fb_share;

    @FindBy(xpath="//*[@data-testid='TwitterIcon']")
    public WebElement icn_tw_share;

    @FindBy(xpath="//img[@alt='viber icon']")
    public WebElement icn_vbr_share;

    @FindBy(xpath="//div[@class='MuiBox-root css-0']/div/picture/img")
    public WebElement img_art_main;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sub;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_pdate;

    @FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-item css')]//div[contains(@class,'MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_num;

    @FindBy(xpath="//div[text()='Latest photos']")
    public WebElement txt_latphotos_sec;

    @FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-grid-xs-12 css-1avig84']/div/picture/img")
    public WebElement img_latpho_art_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-y3digz')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_latpho_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-dvep3g')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_relscoops_art;

    @FindBy(xpath="")
    public WebElement g;

    @FindBy(xpath="")
    public WebElement h;

    @FindBy(xpath="")
    public WebElement i;

    @FindBy(xpath="")
    public WebElement j;
}
