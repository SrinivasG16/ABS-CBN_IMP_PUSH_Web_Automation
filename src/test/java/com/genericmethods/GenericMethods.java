package com.genericmethods;


import com.annotations.Annotations;
import com.getconfidetails.ReadConfigDetails;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericMethods extends Annotations {

    public static String Parent;
    public static String childWindow;
    public static WebDriver driver;


    @Step("Launching the browser")
    public boolean launchBrowser() {

        boolean status = true;
        ReadConfigDetails property = new ReadConfigDetails();
        try {
            switch (property.getProperty("BROWSER").toLowerCase()) {

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("general.useragent.override", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/111.0");
                    options.setProfile(profile);
                    driver = new FirefoxDriver(options);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions opt = new EdgeOptions();
                    opt.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.39");
                    driver = new EdgeDriver(opt);

                default:
                    ChromeOptions ops = new ChromeOptions();
                    ops.addArguments("--remote-allow-origins=*");
                    ops.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
                    break;
            }

            driver.manage().window().maximize();
            driver.get(property.getProperty(property.getProperty("EXECUTE_ENVIRONMENT") + ("_APP_URL")));

            try{
                JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,800)","");
                js.executeScript("window.scrollBy(0,1200)","");
                js.executeScript("window.scrollBy(0,2000)","");
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.findElement(By.xpath("//button[text()='I AGREE!']")).click();
            }catch (Exception e){
                System.out.println(" ");
            }
        } catch (Exception e) {
            status = false;
            System.out.println(e.getMessage());
        }
        return status;
    }

    public void manageCookies(){
        try{
            driver.findElement(By.xpath("//button[text()='I Agree!']")).click();
        }catch (Exception e){
            System.out.println("hello ");
        }

    }

    @Step("Verifying the {2} element in {1} section on the {0} page")
    public boolean availableElement(String pageName, String section,String elementName, WebElement element){
        boolean status = true;
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
            PageScrollbyJS(element);
            getScreenshot();
            System.out.println(elementName +" is clickable/available in "+section +" on "+pageName +" page");
        }
        catch (Exception e)
        {
            status= false;
            getScreenshot();
            Assert.assertEquals(status,true,elementName +" is not clickable/available in "+section +" on the "+pageName);
        }
        return status;
    }

    @Step("Verifying the {2} element in {1} section on the {0} page")
    public boolean elementClickable(String pageName, String section,String elementName, WebElement element){

      //  SoftAssert sa= new SoftAssert();
        boolean status = true;
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
            PageScrollbyJS(element);
            getScreenshot();
            System.out.println(elementName +" is clickable/available in "+section +" on "+pageName +" page");
        }
        catch (Exception e)
        {
            status= false;
            getScreenshot();
           //  sa.assertEquals(status,true,elementName +" is not clickable/available in "+section +" on the "+pageName);
        }

        return status;
    }


    @Step("Click the element {1} on the {0} page")
    public boolean clickElement(String pageName, String elementName, WebElement element){
        boolean status = true;
        try
        {
            Actions acc= new Actions(driver);
            acc.moveToElement(element).click(element).build().perform();
            getScreenshot();
        }
        catch (Exception e)
        {
            getScreenshot();
            System.out.println(e.getMessage());
            status= false;
            Assert.assertEquals(status,true,"Unable to click on the "+elementName);
        }
        return status;
    }
     public static boolean PageScrollbyJS(WebElement element)
    {
        Boolean status = true;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status;
    }

     public boolean moveToElement(String pageName, String elementName, WebElement element){
        boolean status = true;
        try
        {
            Actions acc= new Actions(driver);
            acc.moveToElement(element).build().perform();
        }
        catch (Exception e)
        {
            status= false;
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean switchwindow(){
        boolean status = true;
        try{
            Set<String> s1=driver.getWindowHandles();
            Iterator<String> iterator=s1.iterator();
            Parent =iterator.next();
            childWindow=iterator.next();
            driver.switchTo().window(childWindow);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return status;
    }

    public boolean switchtomain(){
        boolean status = true;
        try{
            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(Parent);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return status;

    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        TakesScreenshot sht = (TakesScreenshot) driver;
        return sht.getScreenshotAs(OutputType.BYTES);
    }

    public void verifyBrokenImages(String pageName) throws InterruptedException, AWTException {

        int count=0;

        SoftAssert softAssert =new SoftAssert();
        try {
            List<WebElement> allImages = driver.findElements(By.tagName("img"));
            System.out.println("Total images in this Page is : "+allImages.size());

            for (WebElement img : allImages) {
                String imgSrc=img.getAttribute("src");
                try{
                    URL url = new URL(imgSrc);
                    URLConnection urlConnection= url.openConnection();
                    HttpURLConnection httpURLConnection= (HttpURLConnection) urlConnection;
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();

                    int statusCode=httpURLConnection.getResponseCode();

                    if(statusCode!=200){
                        softAssert.assertEquals(200,statusCode," So "+imgSrc+" is a broken image");
                        count++;
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }


            if(count!=0) {
                System.err.println("We have " + count + " broken images in " + pageName+" page");
                softAssert.assertAll();
            }else {
                System.out.println(" ALl the images are loading as expected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Verifying the {2} element in {1} section on the {0} page")
    public boolean availableImage(String pageName, String section,String elementName, WebElement element) {
        boolean status = true;

        String imgSrc = element.getAttribute("src");
        try {
            URL url = new URL(imgSrc);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            int statusCode = httpURLConnection.getResponseCode();

            if (statusCode == 200) {
                PageScrollbyJS(element);
                getScreenshot();
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));

                System.out.println(elementName + " is clickable/available in " + section + " on " + pageName + " page");
            } else {
                getScreenshot();
                Assert.assertEquals(200, statusCode, " So " + imgSrc + " is a broken image Hence it is not clickable/available in " + section + " on the " + pageName);

            }


        } catch (Exception e) {
            status = false;
            getScreenshot();
            Assert.assertEquals(status, true, elementName + " is not clickable/available in " + section + " on the " + pageName);
        }
        return status;
    }

    public void Verify_recom_ads_thumb(WebElement target,List<WebElement> list,String root,String shadow){

        JavascriptExecutor jse =(JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        // moveToElement("Home page","Footer",homePageOR.lnk_ftr_advus);

        moveToElement("Home page","Footer",target);

        int Count= list.size();
        System.out.println("We have "+Count+ " placeholders ");


        for(int i=0;i<Count;i++) {
            System.out.println();
            String listCount ="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelectorAll(\"div > div > div.ob-widget-items-container>div\").length;";
            long elementCount = (long) jse.executeScript("return "+listCount);
            for (int j = 0; j < elementCount; j++) {
                try {
                    // String jsf="document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-text\")";

                    //String jsf = "document.querySelector(\"#outbrain_widget_100" + (i + 1) + "\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-" + j + ".ob-p > a > section > span.ob-unit.ob-rec-source\")";
                    String jsf="document.querySelector(\"#outbrain_widget_100"+(i+1)+"\").shadowRoot.querySelector(\"div > div > div.ob-widget-items-container > div.ob-dynamic-rec-container.ob-recIdx-"+j+".ob-p > a > span > img\")";
                    System.out.println(jsf);
                    WebElement shadowRoot = (WebElement) jse.executeScript("return " + jsf);

                    availableElement("Home","recommended section","OutBrain ads thumbnail of placeholder no of "+(i+1)+" and position of "+j,shadowRoot);

                    System.out.println("Source value of " + (i+1) + "widget of " + j + " Position is : " + shadowRoot.isDisplayed());
                }catch (Exception e){
                    System.out.println(" i value : "+(i+1)+" and j value is : "+j);
                }


            }
        }

    }

}
