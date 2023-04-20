package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FreshScoopsOR {


    @FindBy(xpath="//div[text()='Fresh scoops']")
    public WebElement txt_fs_section;

    @FindBy(xpath="//div[@class='MuiGrid-root css-rfnosa']//img[@data-id='image-undefined']")
    public WebElement img_mainart;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom jss')]")
    public WebElement lnk_mainart;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sub;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_pdate;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_num;

    @FindBy(xpath="//div[text()='Latest photos']")
    public WebElement txt_latphotos_sec;

    @FindBy(xpath="//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css-1cnbq4a']/div/picture/img")
    public WebElement img_latpho_art_thumb;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-y3digz')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_latpho_art;

    @FindBy(xpath="//button[text()='MORE SCOOPS']")
    public WebElement btn_morescoops;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss10 css')]"))
    public List<WebElement> lst_art_bf;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss10 css')]"))
    public List<WebElement> lst_art_af;

    @FindAll(@FindBy(xpath="//div[@class='OUTBRAIN' and contains(@id,'outbrain_widget_100')]"))
    public List<WebElement> cou_rec_widgets;

    @FindBy(xpath="//span[text()='RECOMMENDED']")
    public WebElement txt_rec_sec;

    @FindBy(xpath="//div[text()='Advertise with us']")
    public WebElement lnk_ftr_advus;

}
