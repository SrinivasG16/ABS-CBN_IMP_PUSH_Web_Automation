package com.Reports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deployreport {

    static WebDriver driver;

    public static String Currentdate(){
        String date = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));


        return date;
    }

    public static void main(String[] args) {

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://app.netlify.com/");
            driver.findElement(By.name("email")).click();
            driver.findElement(By.xpath("//input[contains(@id,'nf_field_')]")).sendKeys("srinigangadhari@gmail.com");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Medhansh@1216");
            driver.findElement(By.xpath("//button[text()='Log in']")).click();


            Thread.sleep(15000);
            driver.findElement(By.xpath("//button[@name='Add new site']")).click();
            driver.findElement(By.xpath("//a[text()='Deploy manually']")).click();
            Thread.sleep(10000);
            driver.findElement(By.xpath("//label[text()='browse to upload']")).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
            //driver.close();
        }

        try {

            System.out.println("robot created");
            Robot rb = new Robot();
            rb.delay(3000);
            StringSelection ss=new StringSelection("D:\\Projects\\Automation\\ABS-CBN_DotCom_Web_Automation\\allure-report");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("robot destroyed");
            System.out.println("robot1 created");

            Thread.sleep(3000);

            Robot rb1 = new Robot();

            rb1.keyPress(KeyEvent.VK_UP);
            rb1.keyRelease(KeyEvent.VK_UP);

            Thread.sleep(5000);

            rb1.keyPress(KeyEvent.VK_ENTER);
            rb1.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("robot1 destroyed");

            Thread.sleep(20000);

            driver.findElement(By.xpath("//span[text()='Site settings']")).click();
            driver.findElement(By.xpath("//button[text()='Change site name']")).click();

            Thread.sleep(5000);

            WebElement rename =driver.findElement(By.xpath("//input[@name='name']"));
            rename.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

            rename.sendKeys("dotcom010523");
            driver.findElement(By.xpath("//button[text()='Save']")).click();

            Thread.sleep(3000);
            WebElement urlResults = driver.findElement(By.xpath("//a[contains(text(),'netlify.app')]"));

            System.out.println("URL is : "+urlResults.getText());



        }catch (Exception ee){
            System.out.println(ee.getMessage());
        }



    }

}
