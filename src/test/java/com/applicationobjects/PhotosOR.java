package com.applicationobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PhotosOR {
    @FindBy(xpath="//div[text()='Photos']")
    public WebElement txt_ph_section;

    @FindBy(xpath="//a[contains(@class,'MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineNone css')]/div/picture/img")
    public WebElement img_mainart;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom css')]")
    public WebElement lnk_mainart;

    @FindBy(xpath="//div[text()='Trending']")
    public WebElement txt_trending_sub;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_tren_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-z8kccv')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_pdate;

    @FindBy(xpath="//div[contains(@class,'MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom css')]")
    public WebElement txt_tren_art_num;

    @FindBy(xpath="//div[text()='Just in']")
    public WebElement txt_justin_sec;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-1ygtrui')]//div[contains(@class,'MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css')]")
    public WebElement lnk_just_art;

    @FindBy(xpath="//div[contains(@class,'MuiBox-root css-1ygtrui')]//div[contains(@class,'MuiTypography-root MuiTypography-h6 MuiTypography-gutterBottom css')]")
    public WebElement txt_just_art_pdate;

    @FindBy(xpath="//button[text()='MORE PHOTOS']")
    public WebElement btn_morephotos;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss7 css')]"))
    public List<WebElement> lst_art_bf;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-gutterBottom jss7 css')]"))
    public List<WebElement> lst_art_af;

    @FindAll(@FindBy(xpath="//div[@class='OUTBRAIN' and contains(@id,'outbrain_widget_100')]"))
    public List<WebElement> cou_rec_widgets;

    @FindBy(xpath="//span[text()='RECOMMENDED']")
    public WebElement txt_rec_sec;

    @FindBy(xpath="//div[text()='Advertise with us']")
    public WebElement lnk_ftr_advus;
}
