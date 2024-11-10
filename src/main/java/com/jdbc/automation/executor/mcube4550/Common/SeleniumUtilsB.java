package com.jdbc.automation.executor.mcube4550.Common;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.dao.ClientVersionDao;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class SeleniumUtilsB {

    private static final Logger log= LoggerFactory.getLogger(SeleniumUtils.class);
    private static WebDriverManager DriverFactory;
    private static Instant wait;
    static int field_size;
    static int i;
    static boolean flag;
//    static  String chart;
    static int spySize;
    static int count = 0;
    static int iCount;
    static String sText;
    static boolean sFlag;
    static String sExpectedFontValue;
    static String sActualColor;
    static String tempSpy;


    public static void yDataFill(WebDriver driver, WebDriverWait wait, String widget) {
        //Add Metric click
        driver.findElement(By.id("bucketAddButtonID")).click();
        //Y Axis click
        driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
        int y1Count = 3, y2Count = 3;
        int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
        System.out.println("lenY : " + lenY);

        //Y Data entry
        new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
        System.out.println("Here");
        new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
        //Y arrow button close
        driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

        /*for(int i=2;i<lenX-4;i++)
        {
            //Y Data entry
            new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            //Y arrow button close
            driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //X Data entry
            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByIndex(x1Count);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();

        }*/
    }

    public static void xDataFill(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
        int x1Count = 1, x2Count = 1;

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@id=\"bucketButtonAddLabelID\"])[2]")).click();

        int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
        System.out.println("lenX : " + lenX);

        new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
        Thread.sleep(3000);
        //X Axis Field fill
        new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
        Thread.sleep(3000);
        //X arrow button close
        driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();


        if (widget.equalsIgnoreCase("Area")) {
            driver.findElement(By.id("bucketAddSubButtonID")).click();
            //X Axis click                            //*[@id="bucketButtonAddLabelID"][2]
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][2]")).click();

            new Select(driver.findElement(By.xpath("//*[@id=\"4bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"4fieldSelectID\"]"))).selectByVisibleText("Discount");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"4metricExpandButtonIID\"]")).click();
        }


    }


   /* public static void yDataFill(WebDriver driver, WebDriverWait wait, String widget) {
        //Add Metric click
        driver.findElement(By.id("bucketAddButtonID")).click();
        //Y Axis click
        driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
        int y1Count = 3, y2Count = 3;
        int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
        System.out.println("lenY : " + lenY);

        //Y Data entry
        new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
        System.out.println("Here");
        new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
        //Y arrow button close
        driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

        *//*for(int i=2;i<lenX-4;i++)
        {
            //Y Data entry
            new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            //Y arrow button close
            driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //X Data entry
            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByIndex(x1Count);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();

        }*//*
    }*/

    public static void yDataFillTree(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
        //Add Metric click
        int j=0;
        for (int i = 2; i <= 13; i++) {

            driver.findElement(By.id("bucketAddButtonID")).click();
            //Y Axis click
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
            int y1Count = 2, y2Count = 2;

            int lenYY = new Select(driver.findElement(By.id(i+"bucketSelectButtonID"))).getOptions().size();
            System.out.println("lenY : " + lenYY);

           /* int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
            System.out.println("lenY : " + lenY);*/

            //Y Data entry
            /* new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            System.out.println("Here");*/

            if(i<7) {

                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i);
                System.out.println("Here");
             new Select(driver.findElement(By.id(+i+"fieldSelectID"))).selectByIndex(i);

            }
            else if(i>=7){
                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i-5);
                System.out.println("Here");
                new Select(driver.findElement(By.id(+i+"fieldSelectID"))).selectByIndex(i-6);
            }

            // new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            // Y arrow button close
            //driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //To minimize
            driver.findElement(By.id(+i+"metricExpandButtonIID")).click();

            String selectedMetric = driver.findElement(By.id(+i+"metricDescriptionID")).getText().trim();
            if(selectedMetric.equalsIgnoreCase("Median date")
                    || selectedMetric.equalsIgnoreCase("Max date"))
            {
                driver.findElement(By.id(+i+"metricDisableAggregationIID")).click();
                Thread.sleep(2000);
            }
        }
    }

    public static void xDataFillCombo(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
        int x1Count = 1, x2Count = 1;

        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.cssSelector("li[id='bucketButtonAddLabelID']"));
        int size = list.size();
        System.out.println("Size Info" + size);

        for (int i = 0; i < size; i++) {

            String str = list.get(i).getText().trim();
            System.out.println("string" + str);
            if (str.equalsIgnoreCase("X-Axis") || str.equalsIgnoreCase("Split Rows")) {
                list.get(i).click();
                break;
            } else {
                continue;
            }
        }
        //list.get(1).click();
        //driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
        if(widget.equalsIgnoreCase("Combo")) {
            int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
            System.out.println("lenX : " + lenX);

            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
        }
        else if(widget.equalsIgnoreCase("Area")) {
            driver.findElement(By.id("bucketAddSubButtonID")).click();
            //X Axis click                            //*[@id="bucketButtonAddLabelID"][2]
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][2]")).click();

            new Select(driver.findElement(By.xpath("//*[@id=\"4bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"4fieldSelectID\"]"))).selectByVisibleText("Discount");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"4metricExpandButtonIID\"]")).click();
        }

    }

    public static void xDataFillTree(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        int x1Count = 1, x2Count = 1;

        Thread.sleep(2000);


        for(int i=14;i<=15;i++) {
            List<WebElement> list = driver.findElements(By.cssSelector("li[id='bucketButtonAddLabelID']"));
            int size = list.size();
            System.out.println("Size Info" + size);
            String str = list.get(1).getText().trim();
            System.out.println("string" + str);
            if (str.equalsIgnoreCase("Split Rows")) {
                list.get(1).click();
            }

            driver.findElement(By.id("bucketAddSubButtonID")).click();
            //X Axis click
            new Select(driver.findElement(By.id(i+"bucketSelectButtonID"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            if(i==14) {
                new Select(driver.findElement(By.id(i +"fieldSelectID"))).selectByVisibleText("Region");
                Thread.sleep(3000);
                driver.findElement(By.id(i+"metricExpandButtonIID")).click();
            }
            else {
                //X arrow button close
                new Select(driver.findElement(By.id(i +"fieldSelectID"))).selectByVisibleText("City");
                Thread.sleep(3000);
                driver.findElement(By.id(i + "metricExpandButtonIID")).click();

            }
        }
    }


    /*public static void afterStepsSavedObjects(WebDriver driver, WebDriverWait wait, String dsw) throws InterruptedException {

        List<WebElement> webEl = new ArrayList<WebElement>();

        int k = 0, j = 0;
        if (dsw.equals("Dashboards")) {
            j = 2;
        } else if (dsw.equals("Searches")) {
            j = 3;
            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/ul/li[2]/a")).click();
        } else if (dsw.equals("Widgets")) {
            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/ul/li[3]/a")).click();
            j = 4;
        }
        Thread.sleep(3000);

        for (int i = 1; i < 5; i++) {
            try {                                                        //*[@id="kibana-body"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[3]/ul/li[1]/div[2]/input
                //System.out.println("i=" + i);                           //*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[3]/ul/li[2]/div[2]/input
                webEl.add(k, driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[" + j + "]/ul/li[" + i + "]/div[2]/input")));
                //System.out.println("j:" + j);
                //System.out.println("WebEl : " + webEl.get(k));
                //System.out.println("WebEl Size: " + webEl.size());
                k = k + 1;
            } catch (Exception e) {
                log.error("",e);
            }
        }
        System.out.println("Size of Dashboards : " + webEl.size());
        Thread.sleep(2000);

        //Checkbox is clicked
        List<WebElement> checkBox = webEl;
        for (int i = 0; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }
        //Export                                  //*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[2]
        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[2]")).click();
        Thread.sleep(20000);
        //Uncheck
        for (int i = 1; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }
        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[1]")).click();

        SeleniumUtils.waitForAlert(driver);
    }*/

    public static void afterStepsSavedObjects(WebDriver driver, WebDriverWait wait, String dsw) throws InterruptedException {

        List<WebElement> webEl = new ArrayList<WebElement>();

        int k = 0, j = 0;
        if (dsw.equals("Dashboards")) {
            j = 2;
        } else if (dsw.equals("Searches")) {
            j = 3;
            driver.findElement(By.cssSelector("a[title='searches']")).click();
        } else if (dsw.equals("Widgets")) {
            driver.findElement(By.cssSelector("a[title='widgets']")).click();
            j = 4;
        }
        Thread.sleep(3000);

        try {
            // webEl.add(k, driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[" + j + "]/ul/li[" + i + "]/div[2]/input")));
            List<WebElement> list = driver.findElement(By.cssSelector("div[class='tab-pane active']")).findElements(By.cssSelector("li[class='item']"));
            System.out.println(list.size());
            for (int i = 1; i < 5; i++) {
                WebElement el = list.get(i).findElement(By.cssSelector("div[class='pull-left checkbox-margin']")).findElement(By.tagName("input"));
                webEl.add(k, el);

                //System.out.println("j:" + j);
                //System.out.println("WebEl : " + webEl.get(k));
                //System.out.println("WebEl Size: " + webEl.size());

                k = k + 1;
            }
        } catch (Exception e) {
            log.error("", e);
        }

        System.out.println("Size of Dashboards : " + webEl.size());
        Thread.sleep(2000);

        //Checkbox is clicked
        List<WebElement> checkBox = webEl;
        for (int i = 0; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }

        //Export
        driver.findElement(By.cssSelector("a[class='btn btn-xs btn-default']")).click();
        Thread.sleep(13000);
        //Uncheck
        for (int i = 1; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }

        driver.findElement(By.cssSelector("a[class='btn btn-xs btn-danger']")).click();
        Thread.sleep(2000);
        SeleniumUtils.waitForAlert(driver);
        Thread.sleep(8000);
    }
    public static void loginBIInValid(WebDriver driver, List<Records> listOb,String username,String password,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<File>();

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password+"123");

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();
            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            try{
                driver.findElement(By.id("casErrorDiv"));
                actualOutcome=true;
            }
            catch(Exception e){
                actualOutcome=false;
                log.error("",e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LOGIN-01");
            record.setOutcome(actualOutcome);
            record.setName("INVALID LOGIN");
            record.setScreenShot(screenShot);
            record.setExpectedResult("INVALID LOGIN MESSAGE APPEARS");
            clientVersionDao.setRecordDetails(record);
        }
        /*record1.setOutcome(actualOutcome);
        record1.setName("LOGIN");
        record1.setScreenShot(screenShot);
        record1.setExpectedResult("");*/

        listOb.add(record);
        //listOb.add(record1);
    }

    //Add Client version dao for every method, aut_master_id as parameter too
    public static void loginBIValid(WebDriver driver, List<Records> listOb, String username, String password, String url, ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
      Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        driver.get(url);
        Thread.sleep(5000);

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();

            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            try{
                driver.findElement(By.id("casErrorDiv")); //No Error message will be shown on screen
                actualOutcome=false;
            }
            catch(Exception e){
                actualOutcome=true;
                log.error("",e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {

            //record.setSanityAutomationMasterID()
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LOGIN-02");
            record.setOutcome(actualOutcome);
            record.setName("LOGIN");
            record.setScreenShot(screenShot);
            record.setExpectedResult("LOGGED IN");

            //SAN_LOG_1, PASS, Sanity_Aut_Master_ID
            //ClientVersionDao. insertSanityTCOutcome(record)
            clientVersionDao.setRecordDetails(record);
        }
       /* record1.setOutcome(actualOutcome);
        record1.setName("LOGIN");
        record1.setScreenShot(screenShot);
        record1.setExpectedResult("");*/

        listOb.add(record);
        if(!actualOutcome)
        {
            throw new Exception("Login failed.");
        }
        // listOb.add(record1);
    }

    public static void loginWB(WebDriver driver,List<File> screenShot,String username,String password) throws Exception {

        Boolean actualOutcome = false;
        try {
            driver.findElement(By.id("usr")).sendKeys(username);
            driver.findElement(By.id("pwd")).sendKeys(password);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.id("login")).click();
            Thread.sleep(5000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static void switchToWindow(int index, WebDriver driver) {
        String windowId = null;
        System.out.println("Present Window : " + driver.getWindowHandle());
        Set<String> allWin = driver.getWindowHandles();
        System.out.println("All windows : " + driver.getWindowHandles());
        Iterator<String> iter = allWin.iterator();

        for (int i = 0; i <= index; i++) {
            windowId = iter.next();
        }
        driver.switchTo().window(windowId);
        System.out.println("Switched to Window : " + windowId);
    }

    public static void changeDate(WebDriver driver, WebDriverWait wait, List<File> screenShot) throws Exception {

        Boolean actualOutcome = false;

        try {
            //driver.findElement(By.xpath("//*[@id=\"KGTPTimePickerBtnID\"]/pretty-duration")).click();
            driver.findElement(By.cssSelector("div[id='KGTPTimePickerBtnID']")).findElement(By.tagName("pretty-duration")).click();
            driver.findElement(By.linkText("Relative")).click();

            List<WebElement> yearDDList = driver.findElements(By.cssSelector("div[class='kbn-timepicker-section']"));
            System.out.println("yearDDList Size :"+yearDDList);
            List<WebElement> yearDDSubList = yearDDList.get(0).findElements(By.cssSelector("div[class='form-group']"));
            System.out.println("yearDDSubList Size :"+yearDDSubList);
            WebElement yearDDWeb = yearDDSubList.get(1).findElement(By.tagName("select"));
            Select yearDD = new Select(yearDDWeb);
            yearDD.selectByIndex(6);
            //GO is clicked
            yearDDList.get(2).findElement(By.cssSelector("div")).findElement(By.tagName("button")).click();

            //driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[2]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/button")).click();
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
           driver.findElement(By.cssSelector("i[class='fa fa-arrow-up']")).click();
            System.out.println("Arrow is clicked");
           // driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[1]/i")).click();


        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static String saveByName(WebDriver driver, String saveName) {

        try {
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).click();
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(Keys.chord(Keys.BACK_SPACE));

            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(saveName);
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/button")).click();
        } catch (Exception e) {
           return "false";
        }
        return "true";
    }

    public static void addClick(WebDriver driver, WebElement webElem) {
        try {
            Actions action = new Actions(driver);
            //String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[3]/div")).getText();
            //System.out.println("Alert message : "+str);
            action.moveToElement(webElem).build().perform();

            WebElement add = webElem.findElement(By.cssSelector("button[class=\"btn btn-xs btn-primary discover-field-toggle\"]"));
            add.click();
            System.out.println("Add is clicked..");
        } catch (Exception e) {
            System.out.println("Modal clicked failed inside catch..");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("OK")));
            log.error("",e);
        }
    }

    public static void clickModal(WebDriver driver, WebElement webElem) {
        try {
            Actions action = new Actions(driver);
            //String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[3]/div")).getText();
            //System.out.println("Alert message : "+str);
            action.moveToElement(webElem).click().build().perform();
            System.out.println("Modal clicked successfully..");
        } catch (Exception e) {
            System.out.println("Modal clicked failed inside catch..");
            log.error("",e);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("OK")));
            throw new RuntimeException(e);
        }
    }

    public static void waitForAlert(WebDriver driver) throws InterruptedException {
        int i = 0;
        while (i++ < 10) {
            try {
                Thread.sleep(5000);
                //Status
                System.out.println("Inside waitforalert and i : " + i);
                driver.switchTo().alert().accept();
                //Alert alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(2000);
                continue;
            }
        }
    }

    public static File takeScreenShot(WebDriver driver) throws Exception {

        Thread.sleep(2000);
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//        OutputStream out = new FileOutputStream((SrcFile));
        //File DestFile=new File(fileWithPath);
        //FileUtils.copyFile(SrcFile, DestFile);

        return SrcFile;
    }

    public static String firstWord(String str) {
        int len = str.length();
        String s = "";
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                s = str.substring(0, i);
                break;
            }
        }
        // System.out.println("Substring is : "+s+".");
        return s;
    }

    public static boolean verifyResult(WebDriver driver, String name, String expResult, Records rec, String className)
    {
        /* rec.setName(className);
            rec.setOutcome(true);
            rec.setExpectedResult(className+" Creation Pass named "+name);
            rec.setScreenShot(rec.screenShot);

            System.out.println("Name is : "+rec.getName());
            System.out.println("Outcome is : "+rec.isOutcome());
            System.out.println("Expected Result is : "+rec.getExpectedResult());
            System.out.println("Screenshot is : "+rec.getScreenShot());*/
        /* System.out.println(name+"."+" | NOT EQUALS | "+expResult+"."+" | FOR | "+className);
            rec.setName(className);
            rec.setOutcome(false);
            rec.setExpectedResult(className+" Creation Fail named "+name);
            rec.setScreenShot(rec.screenShot);*/
        return expResult.equalsIgnoreCase(name);
    }

    public static void clickLogo(WebDriver driver, WebDriverWait wait, String name) throws InterruptedException {
        System.out.println(name + " is prepared, clicking on mcube logo");
        driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
        //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/nav/div[1]/li")).click();
        System.out.println("Waiting for Home Text on screen");
        Thread.sleep(6000);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/div/kbn-top-nav/div/div/div/div[3]/div[1]/div/div")));
        //wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mid-stack']"))));
        //div[id='mCubeSSPLogicID']
    }

    public static String randomStringGenerate() {

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // create random string builders
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        int length = 5;
        for (int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
    }

    public static boolean selectIndices(WebDriver driver, WebDriverWait wait, String index) {

        boolean flag = true;
        try {
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='inputpart']")));
            Thread.sleep(1000);

            List<WebElement> list = driver.findElements(By.cssSelector("div[class='scroll-box']"));
            int size = list.size();
            System.out.println("SIZE of scroll box list: " + size);
            List<WebElement> list1 = list.get(0).findElements(By.cssSelector("li[class='control-group']"));
            int size1 = list1.size();
            System.out.println("SIZE of li list: " + size1);

            for (int i = 0; i < size1; i++) {
                //String str=list.get(i).findElement(By.cssSelector("label[class='control control--checkbox']")).getText();

                WebElement el = list1.get(i).findElement(By.tagName("label"));
                String str = el.getText();
                str = str.trim();
                Thread.sleep(1000);
                System.out.println("Index name: " + str);
                System.out.println("Index name: " + index);

                if (str.equalsIgnoreCase(index)) {
                    System.out.println("str :"+str+" and index :"+index);
                    Thread.sleep(1000);
                    list1.get(i).click();
                    break;
                } else {
                    System.out.println("continue");
                    continue;
                }
            }
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            log.error("", e);
            flag = false;
            return flag;
        }
        return flag;
    }

    public static boolean query(WebDriver driver, WebDriverWait wait) {

        boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='dropdown-menu scrollable-menu']")));

            List<WebElement> list = driver.findElement(By.cssSelector("ul[class='dropdown-menu scrollable-menu']")).findElements(By.tagName("li"));
            int size = list.size();
            System.out.println("SIZE of Query List : " + size);
            WebElement text = driver.findElement(By.cssSelector("form[class='ng-dirty ng-valid-parse ng-valid ng-valid-required']")).findElement(By.tagName("textarea"));
            System.out.println("About to click");
            list.get(1).click();
            System.out.println("Cliocked");
            text.sendKeys(", @");

            list.get(3).click();

            text.sendKeys(" from @");
            //text.sendKeys(" from @")

            list.get(0).click();
            //text.sendKeys(","+index);
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            log.error("", e);
            flag = false;
            return flag;
        }
        return flag;
    }

    public static boolean isRoleCreated(WebDriver driver, WebDriverWait wait, String roleName) {

        boolean flag = false;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"userlist\"]")));

            List<WebElement> list = driver.findElement(By.cssSelector("div[class=\"userlist\"]")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
            int size = list.size();
            System.out.println("SIZE of Role List : " + size);

            for (int i = 0; i < size; i++) {
                if (list.get(i).getText().equals(roleName)) {
                    System.out.println(roleName + " is present");
                    flag = true;
                    list.get(i).click();
                    Thread.sleep(3000);
                    break;
                } else {
                    flag = false;
                }
            }
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            log.error("",e);
            flag = false;
            return flag;
        }
        return flag;
    }

    public static void scrollByVisibleElement(WebDriver driver, WebElement webEl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webEl);
    }

    //-----------------------------------------------------------------

    public static boolean clickOkButton1(WebDriver driver,WebDriverWait wait,List<File> screenShot) throws Exception {

        String str=null;
        Boolean actualOutcome = false;

        try {

            Thread.sleep(2000);
            List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-danger']"));
            int size=list.size();
            System.out.println(size);
            for(int i=0;i<size;i++) {
                str=list.get(i).getText();
                if (str.equalsIgnoreCase("OK")||str.equalsIgnoreCase("Add Dataset")) {
                    screenShot.add(SeleniumUtils.takeScreenShot(driver));
                    list.get(i).click();
                    Thread.sleep(1000);
                }
                else{
                    continue;
                }
            }
        }
        catch (Exception e) {
            actualOutcome = false;
            Thread.sleep(5000);
            Keys.chord(Keys.ENTER);
            log.error("",e);
            throw new RuntimeException(e);
        }
        return actualOutcome;
    }
    public static int noOfYFields(WebDriver driver) {

        field_size = 0;
        List<WebElement> fields = driver.findElement(By.cssSelector("select[id='1fieldSelectID']")).findElements(By.tagName("option"));

        int size = fields.size();

        for (i = 0; i < size; i++) {

            String text = fields.get(i).getText();

            if (text != "") {
                field_size++;
            }
        }
        return field_size;
    }
    public static void clickSelectButton(String colorPicker) {

        WebDriver driver = DriverFactory.getWebDriver();

        String css = "div[class='" + colorPicker + "']";

        WebElement we = driver.findElement(By.cssSelector(css)).findElement(By.className("select"));

        we.click();
    }
    public static boolean validateChartFormation(WebDriver driver) {

        flag = true;

        try {
            String dValue = driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='pathgroup 0']")).findElement(By.tagName("path")).getAttribute("d");
            System.out.println("DValue: " + dValue);
            //String genericDValue = "M93.63414634146342,269L263.8780487804878,269L434.1219512195122,269L604.3658536585366,269L604.3658536585366,269L434.1219512195122,269L263.8780487804878,269L93.63414634146342,269Z"

//            String genericDValue = "M92.35760975609757,10.090909090909093L260.2805365853659,26.023925825130533L428.20346341463414,49.54408929357286L596.1263902439025,60.92481165605092L596.1263902439025,111L428.20346341463414,111L260.2805365853659,111L92.35760975609757,111Z";


            String genericDValue = "M52.895333333333326,39.39345454545451L149.06866666666664,201.60179679144383L245.24199999999996,201.60179679144383L341.41533333333325,201.60179679144383L437.58866666666654,201.60179679144383L437.58866666666654,433.328L341.41533333333325,433.328L245.24199999999996,433.328L149.06866666666664,433.328L52.895333333333326,433.328Z";
            System.out.println("GValue: " + genericDValue);

            //String genericDvalue = "M87.92031707317074,10.090909090909083L247.7754390243902,62.199401945573776L407.63056097560974,70.5463921356436L567.4856829268292,78.15328007737826L567.4856829268292,111L407.63056097560974,111L247.7754390243902,111L87.92031707317074,111Z"
            boolean r = dValue.equals(genericDValue);
            if (!r) {
                flag = false;
                return flag;
            }
        }    //end of try block
        catch (Exception ex) {

            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            flag = false;
            return flag;

        } //end of catch block
        return flag;
    }
    public static boolean validateChartFormation1(WebDriver driver) {
        flag = true;
        try {
            driver.findElement(By.xpath("//i[@class=\"fa fa-chevron-circle-up\" or @class=\"fa fa-chevron-circle-down\"]")).click();
            System.out.println("Click spy mode");
            System.out.println("Inside validateChartFormation1");
            WebElement dValue = driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='pathgroup 0']"));
            String chart = dValue.getAttribute("class");
            chart.trim();
            System.out.println("Class name: " +chart);
            if(chart.equals("pathgroup 0"))
            {
                System.out.println("pass");
            }else
            {
                flag = false;
                System.out.println("fail");
            }

        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //End of catch block

        return flag;
        //end of method
    }
    public static boolean validateXAxisLabels(WebDriver driver) {

        flag = true;
        count = 0;
//        WebDriver driver = DriverFactory.getWebDriver();

        try {

            List<WebElement> spy = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

            spySize = spy.size();

            List<WebElement> xaxisData = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));

            int xaxisSize = xaxisData.size();

            for( i = 0; i < xaxisSize; i++) {

                String tempX = xaxisData.get(i).getText();

                System.out.println("X Tick: " + tempX);

                String tempSpy = spy.get(i*2).getAttribute("textContent");

                System.out.println("Spy Data: " + tempSpy);

                if(tempX.equalsIgnoreCase(tempSpy)) {
                    count++ ;
                }
            }
            if(count != xaxisSize) {
                flag = false;
                return flag;
            }
        }	//end of try block
        catch (Exception ex) {

            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            flag = false;
            return flag;

        } //end of catch block
        return flag;
    }

    public static String validateProfile(WebDriver driver, WebDriverWait wait,String value) {

        boolean flag=true;
        String str=null;
        //WebDriver driver = DriverFactory.getWebDriver()
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));

            List<WebElement> list =driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            int size=list.size();
            System.out.println(size);
            for(int i=1;i<size;i++) {
                List<WebElement> list1 =list.get(i).findElements(By.tagName("td"));
                int size1=list1.size();
                System.out.println(size1);
                str=list1.get(1).getText().trim();

                System.out.println(str);

                if (str.equals(value)){
                    System.out.println("Successful profile creation");
                    break;
                }
                else{
                    continue;
                }
            }
        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return str;
            //end of catch block
        }//end of method
        return str;
    }

    public static boolean clickData(WebDriver driver, WebDriverWait wait) {

        boolean flag= true;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-bordered']")));

            List<WebElement>  list=driver.findElement(By.cssSelector("tbody[class='highlight']")).findElements(By.cssSelector("tr[ng-repeat='tableDetails in tableMetaData']"));
            int size=list.size();
            System.out.println("SIZE: "+size);

            for(int j=0; j<size;j++){

                String rowName=list.get(j).findElement(By.cssSelector("td[class='highlighted-name']")).getText();
                System.out.println("ROW NAME: "+rowName);

                List<WebElement>  el = list.get(j).findElements(By.cssSelector("td[ng-repeat='functions in tableDetails.functionDetails ']"));
                int Size=el.size();

                for(int i=0; i<Size; i++){

                    String str=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span")).getAttribute("class");

                    if(str.contains("checkmark-disabled")){
                        continue;
                    }

                    else{
                        WebElement elem=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span"));
                        js.executeScript("arguments[0].click();", elem);

                        System.out.println(i+". CHECKED");
                    }
                }
            }
        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }	//end of method
    public String spyHeaderY(WebDriver driver) {

        String spyY;
        int counter = 0;

        driver = DriverFactory.getWebDriver();

        try {
//            WebDriverWait wait = new WebDriverWait(driver);
//            long until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));

            List<WebElement> spyLabels = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));

            spyY = spyLabels.get(1).findElement(By.tagName("span")).getText();
        }	//end of try block
        catch (StaleElementReferenceException ex) {

            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            return "Header Not Found !";

        } //end of catch block
        return spyY;
    }	//end of method

    public static boolean validateMetrics(WebDriver driver) {

        boolean flag = true;
        String lhsY, lhsX, spyX, chartY, chartX;
        boolean r1, r2, r3, r4 ;

        try {
//            WebDriverWait wait = new WebDriverWait(driver,2,null);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));
            
            List<WebElement> spyLabels = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));

            spyX = spyLabels.get(0).findElement(By.tagName("span")).getText();

            System.out.println("Spy X: " + spyX );

            String spyY = spyHeaderY();

            System.out.println("Spy Y: " + spyY);

            lhsY = driver.findElement(By.cssSelector("span[id='1metricDescriptionID']")).getText();

            System.out.println("LHS Y: " + lhsY);

            lhsX = driver.findElement(By.cssSelector("span[id='2metricDescriptionID']")).getText();

            System.out.println("LHS X: " + lhsX);

            chartY = driver.findElement(By.cssSelector("div[class='y-axis-title']")).findElement(By.tagName("text")).getText();

            System.out.println("Chart Y: " + chartY);

            chartX = driver.findElement(By.cssSelector("div[class='x-axis-title']")).findElement(By.tagName("text")).getText();

            System.out.println("Chart X: " + chartX);

            if(lhsY.startsWith("Median")) {
                r1 = true;
                r2 = spyY.equals(chartY);
            }
            else {
                r1 = lhsY.equals(spyY);

                System.out.println("lhsY.equals(spyY): " + r1);

                r2 = lhsY.equals(chartY);

                System.out.println("lhsY.equals(chartY): " + r2);
            }

            r3 = lhsX.equals(spyX);

            System.out.println("lhsX.equals(spyX): " + r3);

            r4 = lhsX.equals(chartX);

            System.out.println("lhsX.equals(chartX): " + r4);

            if(!r1 || !r2 || !r3 || !r4) {
                flag = false;
                return false;
            }
        }	//end of try block
        catch (Exception ex) {

            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            flag = false;
            return flag;

        } //end of catch block
        return flag;
    }	//end of method

    private static String spyHeaderY() {
        return null;
    }


    public static boolean validateDataLabels1(WebDriver driver) {

        try {
            driver.findElement(By.xpath("//i[@class=\"fa fa-chevron-circle-up\" or @class=\"fa fa-chevron-circle-down\"]")).click();
            System.out.println("Inside validateDataLabels1 for spy");

            List<WebElement> spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));
            int spySize = spyData.size();
            System.out.println("SpySize : "+spySize);

            List<String> listSpyData = new ArrayList<>();
            for(int i=0;i<spySize;i++)
            {
                try {
                    String doub = spyData.get((i * 2) + 1).getAttribute("textContent");
                        listSpyData.add(doub);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            System.out.println("List Spy Data : "+listSpyData);

            Thread.sleep(1000);
            driver.findElement(By.xpath("//i[@class=\"fa fa-chevron-circle-up\" or @class=\"fa fa-chevron-circle-down\"]")).click();
            System.out.println("Inside validateDataLabels2 for chart");

            List<WebElement> dataLabels = driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='points area']")).findElements(By.tagName("text"));
            int dataSize = dataLabels.size();
            System.out.println("Datasize :"+ dataSize);

            List<String> listChartData = new ArrayList<>();
            for(int i=0;i<dataSize;i++)
            {
                try {
                    String doub = dataLabels.get(i).getAttribute("textContent");
                    listChartData.add(doub);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            System.out.println("List Chart Data : "+listChartData);

            if(listChartData.equals(listSpyData)==true)
            {
                System.out.println("TRUEEE");
                return true;
            }
            else {
                System.out.println("FALSEEEE");
                return false;
            }

        }    //end of try block
        catch (Exception ex) {
            System.out.println("STA6LE ELEMENT REFERENCE MORE THAN TWICEEE!!");
            return false;
        }
    }

    public static boolean clickAddNew(WebDriver driver, WebDriverWait wait) {

        boolean flag=true;
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));

            WebElement we =driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.tagName("input"));

            String str=we.getAttribute("class");
            System.out.println(str);

            if(str.equals("form-control")){
                System.out.println("Element is Visible");
            }

        }//end of try block

        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }	//end of method
        return flag;
    }

    public static boolean clickDb(WebDriver driver, WebDriverWait wait, String value, String value1) {

        boolean flag = true;
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='a db-set']")));

            List<WebElement> list = driver.findElement(By.cssSelector("div[class='a db-set']")).findElement(By.cssSelector("div[class='db-set-inner']")).findElements(By.tagName("db-list"));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).getAttribute("textContent");
                System.out.println("DB NAME: " + str);
                if (str.equals(value)) {
                    Thread.sleep(1000);
                    list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).click();

                    Thread.sleep(2000);
                    List<WebElement> list1 = list.get(i).findElement(By.cssSelector("ul[class='subList']")).findElements(By.cssSelector("li[class='tableLabel']"));
                    int Size = list1.size();
                    System.out.println("Li Size "+Size);

                    for (int j = 0; j < Size; j++) {

                        String str1 = list1.get(j).getText();
                        System.out.println("Dataset Name:" + str1);

                        if (str1.equals(value1)) {
                            Thread.sleep(2000);
                            list1.get(j).click();
                            break;
                        }
                    }
                    break;
                }
            }
        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }

    public static void switchToWindow1(String title, WebDriver driver) {

        boolean foundWindow = false;

        for(String handle:driver.getWindowHandles()) {

            if (driver.switchTo().window(handle).getTitle().contains(title)) {
                System.out.println("Switched to window with title:" + title);
                foundWindow = true;
                break;
            }
            if (foundWindow) {
                System.out.println("Couldn't find the window with title -> " + title);
            }
        }
    }

    public static void dbConnection(WebDriver driver,String database,int index,String connectionName, List<File> screenShot) {

        //  Boolean actualOutcome=false;
        String str=null;

        try {

            //datasource click, database click, select jdbc and jpfdist and create a wf and run the workflow and validate green tick
            driver.findElement(By.cssSelector("div[class='model-navigator']")).findElement(By.cssSelector("li[ng-click='$ctrl.openDatasources()']")).click();
            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span[class='btn-modal__icon sa sa-database']")).click();

            Select databaseDropdown = new Select(driver.findElement(By.cssSelector("select[class='select-drive select-dataserver ng-pristine ng-untouched ng-valid ng-empty']")));
            System.out.println("databaseDropdown: " + databaseDropdown);

            databaseDropdown.selectByIndex(index);

            Thread.sleep(5000);

            driver.findElement(By.cssSelector("input[id='DATABASE']")).sendKeys("gpadmin");

            driver.findElement(By.cssSelector("input[id='host']")).sendKeys("192.112.200.16");

            driver.findElement(By.cssSelector("input[id='port']")).sendKeys("5432");

            driver.findElement(By.cssSelector("input[id='username']")).sendKeys("gpadmin");

            driver.findElement(By.cssSelector("input[id='password']")).sendKeys("gpadmin");

            driver.findElement(By.cssSelector("button[class='btnstyle align-right']")).click();

            Thread.sleep(3000);

            str = driver.findElement(By.cssSelector("div[class='error-mgs ng-binding ng-scope']")).getText().trim();

            System.out.println(str);

            Thread.sleep(3000);

            Select databaseDropdown1 = new Select(driver.findElement(By.cssSelector("select[id='tables']")));

            System.out.println("databaseDropdown: " + databaseDropdown1);

            databaseDropdown1.selectByVisibleText("sales_all_details_11");

            if(database.equals("Greenplum-JDBC")) {

                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);

            }
            else if(database.equals("Greenplum-GPFDIST")) {

                Thread.sleep(3000);

                Select partitionDropdown = new Select(driver.findElement(By.cssSelector("select[id='PARTITIONCOL']")));

                partitionDropdown.selectByVisibleText("gp_segment_id");

                driver.findElement(By.cssSelector("input[id='PARTITIONNUM']")).sendKeys("100");

                driver.findElement(By.cssSelector("input[id='SPARKPORT']")).sendKeys("12005");

                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);

            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("button[class='btn btn-blue ng-scope']")).click();
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("div[class='cross']")).click();
        }
        catch (Exception e) {
            log.error("", e);
        }
    }

    public static boolean addReadNode(WebDriver driver, WebDriverWait wait,String value, List<File> screenShot) throws Exception {

        boolean flag=true;
        Actions actions = new Actions(driver);
        String str=null;

        //WebDriver driver = DriverFactory.getWebDriver()
        try {

            WebElement elementLocator = driver.findElement(By.cssSelector("div[class='new-node-container']"));
            actions.contextClick(elementLocator).perform();
            Thread.sleep(3000);

            WebElement inputOutput=driver.findElement(By.cssSelector("operation-catalogue[class='new-node__catalogue ng-isolate-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
            actions.moveToElement(inputOutput).perform();
            Thread.sleep(3000);

            WebElement readData=driver.findElement(By.cssSelector("div[class='operations-list__next-level ng-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
            actions.moveToElement(readData).click().build().perform();
            Thread.sleep(3000);
            if(value.contains("Greenplum-GPFDIST")) {

                List<WebElement> list1 = driver.findElements(By.cssSelector("div[class='custom-name ng-binding ng-scope']"));
                list1.get(1).findElement(By.cssSelector("span[class='ng-binding']")).click();

            }
            else{
                driver.findElement(By.cssSelector("div[class='custom-name ng-binding ng-scope']")).findElement(By.cssSelector("span[class='ng-binding']")).click();
            }

            List<WebElement> list= driver.findElement(By.cssSelector("div[class='datasources-list']")).findElements(By.cssSelector("div[class='datasources-element__name-wrapper']"));
            int size=list.size();

            System.out.println(size);

            for(int i=0;i<size;i++){

                WebElement we=list.get(i).findElement(By.cssSelector("div[class='datasources-element__name ng-binding']"));
                str=we.getAttribute("title").trim();
                Thread.sleep(3000);
                System.out.println(str);
                System.out.println(value);

                if(value.equals(str)){
                    Thread.sleep(2000);
                    we.click();
                    break;
                }
                else{
                    continue;
                }
            }

            Thread.sleep(2000);
            Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
            reportType.selectByIndex(1);
            Thread.sleep(4000);
            clickMenuItems(driver,"Run");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(10000);

        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }//end of method
        return flag;
    }

    public static void clickMenuItems(WebDriver driver,String usage) {

        Boolean actualOutcome=false;
        String str=null;
        try {
            Thread.sleep(2000);
            List<WebElement> list=driver.findElement(By.cssSelector("div[class='pull-right workflow-navbar__top-menu-options']")).findElements(By.cssSelector("span[class='workflow-navbar__text-label ng-binding']"));
            int size=list.size();
            System.out.println("Menu Items: "+size);
            for(int i=0;i<size;i++){

                str=list.get(i).getText().trim();
                System.out.println("str"+str);
                if(usage.equals(str))
                {
                    list.get(i).click();
                    break;
                }
                else{
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Click Failed");
            log.error("", e);
        }
    }

    public static boolean validateSuccess(WebDriver driver, WebDriverWait wait,String value) {

        boolean flag=true;
        //WebDriver driver = DriverFactory.getWebDriver()
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));

            List<WebElement> list =driver.findElements(By.cssSelector("div[class='graph-node__content']"));
            int size=list.size();
            System.out.println(size);
            for(int i=0;i<size;i++) {

                WebElement we =list.get(i).findElement(By.cssSelector("status-icon[class='graph-node__status-icon ng-scope ng-isolate-scope']")).findElement(By.cssSelector("div[popover-placement='right']"));

                String str=we.getAttribute("class").trim();

                System.out.println(str);

                if (str.equals(value)){
                    System.out.println("Read Node Executed Successfully");
                    flag=true;
                }
                else{
                    continue;
                }
            }
        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }//end of method
        return flag;
    }
    public static void clickOkButton(WebDriver driver,WebDriverWait wait) throws Exception {

        Boolean actualOutcome = false;

        try {

            Thread.sleep(2000);
            List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-primary']"));
            int size=list.size();
            System.out.println(size);
            if(size==1) {
                list.get(0).click();
                Thread.sleep(1000);
            }
            else{
                list.get(1).click();
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyAAWorkflow2(WebDriver driver) {
        boolean flag=true;
        int counter = 0;
        try
        {
            List<WebElement> Weblist = driver.findElement(By.cssSelector("div[class='c-dynamic-part ng-scope']")).findElement(By.cssSelector("div[class='editor']")).findElement(By.cssSelector("div[class='flowchart-paint-area']")).findElements(By.cssSelector("graph-node[class='graph-node-component ng-scope ng-isolate-scope jtk-draggable jtk-endpoint-anchor jtk-connected']"));
            int size = Weblist.size();
            System.out.println("No. of nodes " +size);
            for(int i =0; i < size; i++) {
                List<WebElement> we = Weblist.get(i).findElement(By.tagName("status-icon")).findElements(By.tagName("div"));
                //WebElement we1 = we.get(0)
                String sText1 = we.get(0).getAttribute("class");
                sText1=sText1.trim();
                System.out.println(sText1);

                if(sText1.contains("status-icon completed"))
                {
                    counter+=1;
                    //flag=true
                    System.out.println("pass");
                }
                else
                {
                    flag=false;
                    System.out.println("continue");
                }

            }//end of for loop
            if(counter==size)
            {
                System.out.println("No. of nodes having checked status " +counter);
                System.out.println("pass:- No. of nodes and checked status are equal");
            }
            else {
                System.out.println("fail:- No. of nodes and checked status are not equal");
            }
        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //End of catch block
        return flag;
    } //end of method
    public static void dashboardFailure(WebDriver driver, List<Records> listOb,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        screenShot.add(SeleniumUtils.takeScreenShot(driver));

        Records.setSan_aut_id(san_aut_id);
        record.setTestCaseName("SAN-DASHBOARD-01");
        record.setOutcome(actualOutcome);
        record.setName("Dashboard.");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Dashboard completed successfully.");
        clientVersionDao.setRecordDetails(record);

        listOb.add(record);
        System.out.println("Dashboard creation failed due to null widgetlist.");
    }
    public static int checkNull(List<String> widgetList)
    {
        int flag=0;
        for(String name : widgetList) {
            if(name.contains("Mcube_")) {
                flag = 1;
                break;
            }
            else {
                flag=0;
            }
        }
        return flag;
    }
    public static boolean validateFontSizeYTick(WebDriver driver, Object inputFontSize1) {


        String actualFont = sExpectedFontValue + "pt";
         sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-div")));
            List<WebElement> weSvg = driver.findElement(By.xpath("//*[@class='y-axis-div']")).findElements(By.tagName("text"));

            int linkSize = weSvg.size();
            for (iCount = 0; iCount < linkSize; iCount++) {
                WebElement we = weSvg.get(iCount);
                sText = we.getText();
                if (sText.equalsIgnoreCase("true")) {
                } else {
                    String sFont = we.getAttribute("style");
                    if(sFont.contains(actualFont)) {
                        //System.out.println("The font size of Y-axis tick: "+we.getText()+" is "+sFont+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font size of Y-axis tick: "+we.getText()+" is "+sFont+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }   //End of inner if-else
                }   //End of outer loop
            }  //End of for loop
        } //End of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }   //End of catch block
        return sFlag;
    }
    public static boolean validateYTickFontColor(WebDriver driver, int index) {

        sFlag=true;

        WebElement rgb = null;
        sActualColor = String.valueOf(rgb.getSize());

//        WebDriver driver  = DriverFactory.getWebDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-div")));

            List<WebElement> weSvg = driver.findElement(By.xpath("//*[@class='y-axis-div']")).findElements(By.tagName("text"));
            //List<WebElement> weSvg = driver.findElement(By.className("y-axis-div")).findElements(By.tagName("text"))
            int listSize = weSvg.size();

            for (iCount = 0; iCount < listSize; iCount++) {

                WebElement we = weSvg.get(iCount);

                String sText = we.getText();

                if (sText.equalsIgnoreCase("true")) {

                    String sFontColor = we.getAttribute("style");

                    if(sFontColor.contains(sActualColor)) {
                        //System.out.println("The font color for Y-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font color for Y-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }
                }	//end of outer if
            }	//end of for loop
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block

        return sFlag;
    }
    public static boolean validateFontSizeYTitle(WebDriver driver,Object sExpectedFontValue) {


        String actualFont = sExpectedFontValue + "pt";
         sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-title")));
            WebElement weSvg = driver.findElement(By.xpath("//*[@class='y-axis-title']")).findElement(By.tagName("text"));

            String sText = weSvg.getText();
            if (sText.equalsIgnoreCase("True")) {
                String sFont = weSvg.getAttribute("style");
                if(sFont.contains(actualFont)) {
                    //System.out.println("The font size of Y-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font size of Y-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }  //End of inner if-else
            } //End of outer if
        } //End of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }   //End of catch block
        return sFlag;
    }
    public static boolean validateYTitleFontColor(WebDriver driver, int index) {

         sFlag=true;
        WebElement rgb = null;
        sActualColor = String.valueOf(rgb.getSize());

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-title")));
            WebElement we = driver.findElement(By.xpath("//*[@class='y-axis-title']")).findElement(By.tagName("text"));
            String sText = we.getText();
            if (sText.equalsIgnoreCase("True")) {

                String sFontColor = we.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //	System.out.println("The font color for Y-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for Y-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }
    public static boolean validateYAxisColor(WebDriver driver, int index) {

         sFlag=true;
        WebElement rgb = null;
        sActualColor = String.valueOf(rgb.getSize());

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-div")));
            WebElement we = driver.findElement(By.xpath("//*[@class='y-axis-div']")).findElement(By.className("domain"));
            //WebElement we = driver.findElement(By.className("y-axis-div")).findElement(By.className("domain"))

            String sText = we.getText();

            if (sText.equalsIgnoreCase("True")) {

                String sFontColor = we.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //System.out.println("The font color for Y-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for Y-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block

        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }
    public static boolean validatePrefixYTick(WebDriver driver, String sExpectedPrefix) {

         sFlag = true;

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-div")));

            WebElement weSvg=driver.findElements(By.tagName("svg")).get(1);
            List<WebElement> listOfPoints1 = weSvg.findElement(By.tagName("g")).findElements(By.tagName("g"));


            int listSize = listOfPoints1.size();

            for (iCount = 0; iCount <listSize; iCount++) {

                WebElement we = listOfPoints1.get(iCount);
                String Yaxis_labels= we.findElement(By.tagName("text")).getText();


                if (Yaxis_labels.equalsIgnoreCase("True")) {

                    if(Yaxis_labels.startsWith(sExpectedPrefix)) {
                        //	System.out.println("The prefix for Y-axis ticks: "+Yaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The prefix for Y-axis ticks: "+Yaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    } // end inner if
                } // end outer if
            } // end for loop
        } //end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        } //end of catch block

        return sFlag;
    }
    public static boolean validateSuffixYTick(WebDriver driver, String sExpectedSuffix) {


         sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-div")));
            WebElement weSvg=driver.findElements(By.tagName("svg")).get(1);
            List<WebElement> listOfPoints1 = weSvg.findElement(By.tagName("g")).findElements(By.tagName("g"));

            int listSize = listOfPoints1.size();

            for (iCount = 0; iCount < listSize; iCount++) {
                WebElement we = listOfPoints1.get(iCount);
                String Yaxis_labels= we.findElement(By.tagName("text")).getText();

                if (Yaxis_labels.equalsIgnoreCase("True")) {

                    if(Yaxis_labels.endsWith(sExpectedSuffix)) {
                        //	System.out.println("The suffix for Y-axis ticks: "+Yaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The suffix for Y-axis ticks: "+Yaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }   //end of inner if-else
                }  //end of outer if
            }   //end of for loop
        }    //end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }   //end of catch block

        return sFlag;
    }
    public static boolean validateFontSizeXTick(WebDriver driver, Object sExpectedFontValue) {


        String actualFont = sExpectedFontValue + "pt";
         sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-div")));
            List<WebElement> weSvg = driver.findElement(By.xpath("//*[@class='x-axis-div']")).findElements(By.tagName("text"));

            int linkSize =  weSvg.size();

            for (iCount = 0; iCount < linkSize; iCount++) {
                WebElement we = weSvg.get(iCount);

                String sText = we.getText();

                if (sText.equalsIgnoreCase("")) {
                    String sFont = we.getAttribute("style");
                    if(sFont.contains(actualFont)) {
                        //	System.out.println("The font size of X-axis ticks: "+we.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font size of X-axis ticks: "+we.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }   //End of inner if-else
                } //End of outer if
            }   //End of for loop
        }   //End of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }    //End of catch block
        return sFlag;
    }
    public static boolean validateXTickFontColor(WebDriver driver, int index) {

        sFlag=true;
        WebElement rgb = null;
        sActualColor = String.valueOf(rgb.getSize());

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-div")));

            List<WebElement> weSvg = driver.findElement(By.xpath("//*[@class='x-axis-div']")).findElements(By.tagName("text"));

            int listSize = weSvg.size();
            for (iCount = 0; iCount < listSize; iCount++) {

                WebElement we = weSvg.get(iCount);

                String sText = we.getText();

                if (sText.equalsIgnoreCase("")) {

                    String sFontColor = we.getAttribute("style");

                    if(sFontColor.contains(sActualColor)) {
                        //System.out.println("The font color for X-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font color for X-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }
                }	//end of outer if
            }	//end of for loop
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }
    public static boolean validateFontSizeXTitle(WebDriver driver, Object sExpectedFontValue) {


        String actualFont = sExpectedFontValue + "pt";
         sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-title")));
            WebElement weSvg = driver.findElement(By.xpath("//*[@class='x-axis-title']")).findElement(By.tagName("text"));

            String sText = weSvg.getText();

            if (sText.equalsIgnoreCase("")) {
                String sFont = weSvg.getAttribute("style");
                if(sFont.contains(actualFont)) {
                    //System.out.println("The font size of X-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font size of X-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;

                }   //End of inner if-else
            }   //End of outer if
        } //End of try block

        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        } //End of catch clock
        return sFlag;
    }
    public static boolean validateXTitleFontColor(WebDriver driver, int index) {

         sFlag=true;
        WebElement rgb = null;
        sActualColor = String.valueOf(rgb.getSize());
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-title")));
            WebElement we = driver.findElement(By.xpath("//*[@class='x-axis-title']")).findElement(By.tagName("text"));

            String sText = we.getText();

            if (sText.equalsIgnoreCase("")) {

                String sFontColor = we.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //System.out.println("The font color for X-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for X-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }
    public static boolean validateXAxisColor(WebDriver driver, int index) {

         sFlag=true;
        WebElement rgb = null;
        sActualColor = String.valueOf(rgb.getSize());

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-div")));
            WebElement we = driver.findElement(By.xpath("//*[@class='x-axis-div']")).findElement(By.className("domain"));

            String sText = we.getText();

            if (sText.equalsIgnoreCase("")) {

                String sFontColor = we.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //System.out.println("The font color for X-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for X-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block

        return sFlag;
    }
    public static boolean validatePrefixXTick(WebDriver driver, Object sExpectedPrefix) {

         sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-div")));

            List<WebElement> listOfPoints1=driver.findElement(By.className("x-axis-div")).findElement(By.tagName("svg")).findElement(By.tagName("g")).findElements(By.tagName("g"));

            int listSize = listOfPoints1.size();

            for (iCount = 1; iCount < listSize; iCount++) {

                WebElement we = listOfPoints1.get(iCount);
                String Xaxis_labels= we.findElement(By.tagName("text")).getText();

                if (Xaxis_labels.equalsIgnoreCase("")) {
                    if(Xaxis_labels.startsWith((String) sExpectedPrefix)) {
                        //	System.out.println("The prefix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The prefix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }	//end of inner if-else
                }	//end of outer if
            }   //end of for loop
        }   //end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }   //end of catch block
        return sFlag;
    }
    public static boolean validateSuffixXTick(WebDriver driver, String sExpectedSuffix) {

        sFlag  = true;
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("x-axis-div")));

            List<WebElement> listOfPoints1=driver.findElement(By.className("x-axis-div")).findElement(By.tagName("svg")).findElement(By.tagName("g")).findElements(By.tagName("g"));

            int listSize = listOfPoints1.size();

            for (iCount = 1; iCount < listSize; iCount++) {

                WebElement we = listOfPoints1.get(iCount);
                String Xaxis_labels= we.findElement(By.tagName("text")).getText();

                if (Xaxis_labels.equalsIgnoreCase("")) {
                    if(Xaxis_labels.endsWith(sExpectedSuffix)) {
                        //	System.out.println("The suffix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The suffix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }   //end of inner if-else
                }    //end of outer if
            }    //end of for loop
        }    //end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }    //end of catch block
        return sFlag;
    }
    public void focusElement(WebDriver driver, WebElement italicCircleInner) {
    }

    public static boolean checkVersion(WebDriver driver, WebDriverWait wait, List<Records> listOb, String className,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {

        Records record = new Records();
        List<File> screenShot = new ArrayList<>();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HelpglobalTitleID")));
            driver.findElement(By.id("HelpglobalTitleID")).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appVersionHelpPageID")));
            String version = driver.findElement(By.id("appVersionHelpPageID")).getText().trim();
            System.out.println("Version name : "+version);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            if(className.contains("4540") && version.equals("Version: 4.5.4.0"))
                actualOutcome=true;
            else if(className.contains("4531") && version.equals("Version: 4.5.3.1"))
                actualOutcome=true;
            else if(className.contains("4530") && version.equals("Version: 4.5.3.0"))
                actualOutcome=true;
            else if(className.contains("4520") && version.equals("Version: 4.5.2.0"))
                actualOutcome=true;
            else if(className.contains("4510") && version.equals("Version: 4.5.1.1"))
                actualOutcome=true;
            else if(className.contains("4500") && version.equals("Version: 4.5.0.0"))
                actualOutcome=true;
            else if(className.contains("ipds") && version.equals("Version: 3.2.0.0"))
                actualOutcome=true;
            else actualOutcome= className.contains("ad4300") && version.equals("Version: 4.3");
        } catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
            //throw new RuntimeException(e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("VERSION CHECK");
            record.setOutcome(actualOutcome);
            record.setName("Version Check");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Version check completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);
            if (!actualOutcome) {
                //throw new Exception("Data Upload creation fail");
                System.out.println("Version check failed");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
