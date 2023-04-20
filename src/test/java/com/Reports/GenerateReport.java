package com.Reports;

;
import com.genericmethods.GenericMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GenerateReport extends GenericMethods {
  //  static WebDriver driver;

    static String date = null;
    public static String path="D:\\Projects\\ABS-CBN_IMP_PUSH_Automation";

    //private static ReportOR reportOR;
    private static GenerateReport generateReport;



    private GenerateReport() {
        System.out.println("Obect creating for Generate report");
    }

    public static GenerateReport getInstance() {
        generateReport=null;
        if (generateReport == null) {
            generateReport = new GenerateReport();
          //  reportOR = PageFactory.initElements(driver, ReportOR.class);
        }
        return generateReport;
    }

    public static String Currentdate(){
        DateFormat dateFormat = new SimpleDateFormat("MMddyy_hhmm");
        Date date1 = new Date();
        date=dateFormat.format(date1);
        return date;
    }

    public String getCurrentDateTime () {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
        Date date = new Date();
        dateFormat.setTimeZone(TimeZone.getTimeZone("Singapore"));
        String currentDateTime = dateFormat.format(date);
        currentDateTime = currentDateTime + "_PHT";
        System.out.println("time is : " + currentDateTime);
        return currentDateTime;
    }

    public static void DeletePrevious(){

        //String path ="D:\\Projects\\ABS-CBN_IMP_PUSH_Automation";
       // String path="C:\\Users\\User\\Documents\\Lightshot";
        try {
            File file = new File(path + "\\allure-report");
            FileUtils.deleteDirectory(new File(String.valueOf(file)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            File file1 = new File(path + "\\allure-results");
            FileUtils.cleanDirectory(file1);
           // FileUtils.deleteDirectory(new File(String.valueOf(file1)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Generatereport() {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"allure generate --clean ");
            Thread.sleep(5000);
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
        } catch (Exception e) {
            System.out.println("HEY Something Went Wrong ");
            e.printStackTrace();
        }

    }

    public void StoreResultsURL(String url,String date) throws IOException {

        File file =    new File(path+"\\Results.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        Row newRow = sheet.createRow(rowCount+1);
        sheet.createRow(rowCount+1).createCell(0).setCellValue(date);
        sheet.createRow(rowCount+1).createCell(1).setCellValue(url);
        fis.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        outputStream.close();

    }





    public void Deployreport(){
        try {
           // ChromeOptions ops = new ChromeOptions();
          //  ops.addArguments("--remote-allow-origins=*");
            //ops.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");

           // WebDriverManager.chromedriver().setup();
           // driver = new ChromeDriver();

            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://app.netlify.com/");

            driver.findElement(By.xpath("//button[text()='Log in with email']")).click();
            driver.findElement(By.xpath("//input[contains(@id,'nf_field_')]")).sendKeys("srinigangadhari@gmail.com");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Medhansh@1216");
            driver.findElement(By.xpath("//button[text()='Log in']")).click();
            Thread.sleep(15000);

            driver.findElement(By.xpath("//button[@name='Add new site']")).click();
            driver.findElement(By.xpath("//*[text()='Deploy manually']")).click();
            Thread.sleep(10000);

            driver.findElement(By.xpath("//label[text()='browse to upload']")).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
            //driver.close();
        }

        try {
            System.out.println("Robot try started");
            Robot rb = new Robot();
            rb.delay(3000);
            StringSelection ss=new StringSelection(path+"\\allure-report");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

            System.out.println("1");
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            System.out.println("2");
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            System.out.println("3");
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("4");
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            System.out.println("5");
            Robot rb1 = new Robot();
            rb1.keyPress(KeyEvent.VK_UP);
            rb1.keyRelease(KeyEvent.VK_UP);
            Thread.sleep(5000);
            System.out.println("6");
            rb1.keyPress(KeyEvent.VK_ENTER);
            rb1.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("7");
            System.out.println("Time before: "+Currentdate());
            Thread.sleep(300000);
            try {
                Thread.sleep(150000);
                System.out.println("Time try: "+Currentdate());
               // waitForElementToDisplay(reportOR.lnk_site_set,60);
            }catch (Exception e){
                Thread.sleep(150000);
                System.out.println("Time catch: "+Currentdate());
              //  waitForElementToDisplay(reportOR.lnk_site_set,60);
            }
            System.out.println("8");
            driver.findElement(By.xpath("//*[text()='Site settings']")).click();
            System.out.println("9");
            driver.findElement(By.xpath("//button[text()='Change site name']")).click();
            Thread.sleep(5000);

            String date=Currentdate();
            String name="ImpPush"+date;
            WebElement rename =driver.findElement(By.xpath("//input[@name='name']"));
            rename.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            rename.sendKeys(name);
            driver.findElement(By.xpath("//button[text()='Save']")).click();
            Thread.sleep(5000);

            WebElement urlResults = driver.findElement(By.xpath("//a[contains(text(),'netlify.app')]"));
            String url=urlResults.getText();
            System.out.println("URL is : "+url);
            Thread.sleep(3000);

            StoreResultsURL(url,date);

            driver.quit();

        }catch (Exception ee){
            System.out.println(ee.getMessage());
            driver.quit();
        }

    }
}
