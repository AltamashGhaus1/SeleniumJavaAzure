package com.jdbc.automation.executor.mcube4530_Production.Common;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.dao.ClientVersionDao;
import jxl.write.Label;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.*;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class SeleniumUtils {

    private static final Logger log = LoggerFactory.getLogger(SeleniumUtils.class);

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
        int j = 0;
        for (int i = 2; i <= 13; i++) {

            driver.findElement(By.id("bucketAddButtonID")).click();
            //Y Axis click
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
            int y1Count = 2, y2Count = 2;

            int lenYY = new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).getOptions().size();
            System.out.println("lenY : " + lenYY);

           /* int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
            System.out.println("lenY : " + lenY);*/

            //Y Data entry
            /* new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            System.out.println("Here");*/

            if (i < 7) {

                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i);
                System.out.println("Here");
                new Select(driver.findElement(By.id(+i + "fieldSelectID"))).selectByIndex(i);

            } else if (i >= 7) {
                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i - 5);
                System.out.println("Here");
                new Select(driver.findElement(By.id(+i + "fieldSelectID"))).selectByIndex(i - 6);
            }

            // new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            // Y arrow button close
            //driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //To minimize
            driver.findElement(By.id(+i + "metricExpandButtonIID")).click();

            String selectedMetric = driver.findElement(By.id(+i + "metricDescriptionID")).getText().trim();
            if (selectedMetric.equalsIgnoreCase("Median date")
                    || selectedMetric.equalsIgnoreCase("Max date")) {
                driver.findElement(By.id(+i + "metricDisableAggregationIID")).click();
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
        if (widget.equalsIgnoreCase("Combo")) {
            int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
            System.out.println("lenX : " + lenX);

            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
        } else if (widget.equalsIgnoreCase("Area")) {
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


        for (int i = 14; i <= 15; i++) {
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
            new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            if (i == 14) {
                new Select(driver.findElement(By.id(i + "fieldSelectID"))).selectByVisibleText("Region");
                Thread.sleep(3000);
                driver.findElement(By.id(i + "metricExpandButtonIID")).click();
            } else {
                //X arrow button close
                new Select(driver.findElement(By.id(i + "fieldSelectID"))).selectByVisibleText("City");
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

    public static void loginBIInValid(WebDriver driver, List<Records> listOb, String username, String password, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<File>();

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password + "123");

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();
            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            try {
                driver.findElement(By.id("casErrorDiv"));
                actualOutcome = true;
            } catch (Exception e) {
                actualOutcome = false;
                log.error("", e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
        } finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("UAT-LOGIN-01");
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
    public static void loginBIValid(WebDriver driver, List<Records> listOb, String username, String password, String url, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        driver.get(url);
        Thread.sleep(5000);

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();

            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            try {
                driver.findElement(By.id("casErrorDiv"));
                actualOutcome = false;
            } catch (Exception e) {
                actualOutcome = true;
                log.error("", e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
        } finally {

            //record.setSanityAutomationMasterID()
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("UAT-LOGIN-02");
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
        if (!actualOutcome) {
            throw new Exception("Login failed.");
        }
        // listOb.add(record1);
    }

    public static void loginWB(WebDriver driver, List<File> screenShot, String username, String password) throws Exception {

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
            System.out.println("yearDDList Size :" + yearDDList);
            List<WebElement> yearDDSubList = yearDDList.get(0).findElements(By.cssSelector("div[class='form-group']"));
            System.out.println("yearDDSubList Size :" + yearDDSubList);
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
            log.error("", e);
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
            log.error("", e);
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

    public static boolean verifyResult(WebDriver driver, String name, String expResult, Records rec, String className) {
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
                    System.out.println("str :" + str + " and index :" + index);
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
            log.error("", e);
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

    public static boolean clickOkButton1(WebDriver driver, WebDriverWait wait, List<File> screenShot) throws Exception {

        String str = null;
        Boolean actualOutcome = false;

        try {

            Thread.sleep(2000);
            List<WebElement> list = driver.findElements(By.cssSelector("button[class='ajs-button btn btn-danger']"));
            int size = list.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                str = list.get(i).getText();
                if (str.equalsIgnoreCase("OK") || str.equalsIgnoreCase("Add Dataset")) {
                    screenShot.add(SeleniumUtils.takeScreenShot(driver));
                    list.get(i).click();
                    Thread.sleep(1000);
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            actualOutcome = false;
            Thread.sleep(5000);
            Keys.chord(Keys.ENTER);
            log.error("", e);
            throw new RuntimeException(e);
        }
        return actualOutcome;
    }

    public static String validateProfile(WebDriver driver, WebDriverWait wait, String value) {

        boolean flag = true;
        String str = null;
        //WebDriver driver = DriverFactory.getWebDriver()
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));

            List<WebElement> list = driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            int size = list.size();
            System.out.println(size);
            for (int i = 1; i < size; i++) {
                List<WebElement> list1 = list.get(i).findElements(By.tagName("td"));
                int size1 = list1.size();
                System.out.println(size1);
                str = list1.get(1).getText().trim();

                System.out.println(str);

                if (str.equals(value)) {
                    System.out.println("Successful profile creation");
                    break;
                } else {
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

        boolean flag = true;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-bordered']")));

            List<WebElement> list = driver.findElement(By.cssSelector("tbody[class='highlight']")).findElements(By.cssSelector("tr[ng-repeat='tableDetails in tableMetaData']"));
            int size = list.size();
            System.out.println("SIZE: " + size);

            for (int j = 0; j < size; j++) {

                String rowName = list.get(j).findElement(By.cssSelector("td[class='highlighted-name']")).getText();
                System.out.println("ROW NAME: " + rowName);

                List<WebElement> el = list.get(j).findElements(By.cssSelector("td[ng-repeat='functions in tableDetails.functionDetails ']"));
                int Size = el.size();

                for (int i = 0; i < Size; i++) {

                    String str = el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span")).getAttribute("class");

                    if (str.contains("checkmark-disabled")) {
                        continue;
                    } else {
                        WebElement elem = el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span"));
                        js.executeScript("arguments[0].click();", elem);

                        System.out.println(i + ". CHECKED");
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
    }    //end of method


    public static boolean clickAddNew(WebDriver driver, WebDriverWait wait) {

        boolean flag = true;
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));

            WebElement we = driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.tagName("input"));

            String str = we.getAttribute("class");
            System.out.println(str);

            if (str.equals("form-control")) {
                System.out.println("Element is Visible");
            }

        }//end of try block

        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }    //end of method
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
                    System.out.println("Li Size " + Size);

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

        for (String handle : driver.getWindowHandles()) {

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

    public static void dbConnection(WebDriver driver, String database, int index, String connectionName, List<File> screenShot) {

        //  Boolean actualOutcome=false;
        String str = null;

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

            if (database.equals("Greenplum-JDBC")) {

                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);

            } else if (database.equals("Greenplum-GPFDIST")) {

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
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public static boolean addReadNode(WebDriver driver, WebDriverWait wait, String value, List<File> screenShot) throws Exception {

        boolean flag = true;
        Actions actions = new Actions(driver);
        String str = null;

        //WebDriver driver = DriverFactory.getWebDriver()
        try {

            WebElement elementLocator = driver.findElement(By.cssSelector("div[class='new-node-container']"));
            actions.contextClick(elementLocator).perform();
            Thread.sleep(3000);

            WebElement inputOutput = driver.findElement(By.cssSelector("operation-catalogue[class='new-node__catalogue ng-isolate-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
            actions.moveToElement(inputOutput).perform();
            Thread.sleep(3000);

            WebElement readData = driver.findElement(By.cssSelector("div[class='operations-list__next-level ng-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
            actions.moveToElement(readData).click().build().perform();
            Thread.sleep(3000);
            if (value.contains("Greenplum-GPFDIST")) {

                List<WebElement> list1 = driver.findElements(By.cssSelector("div[class='custom-name ng-binding ng-scope']"));
                list1.get(1).findElement(By.cssSelector("span[class='ng-binding']")).click();

            } else {
                driver.findElement(By.cssSelector("div[class='custom-name ng-binding ng-scope']")).findElement(By.cssSelector("span[class='ng-binding']")).click();
            }

            List<WebElement> list = driver.findElement(By.cssSelector("div[class='datasources-list']")).findElements(By.cssSelector("div[class='datasources-element__name-wrapper']"));
            int size = list.size();

            System.out.println(size);

            for (int i = 0; i < size; i++) {

                WebElement we = list.get(i).findElement(By.cssSelector("div[class='datasources-element__name ng-binding']"));
                str = we.getAttribute("title").trim();
                Thread.sleep(3000);
                System.out.println(str);
                System.out.println(value);

                if (value.equals(str)) {
                    Thread.sleep(2000);
                    we.click();
                    break;
                } else {
                    continue;
                }
            }

            Thread.sleep(2000);
            Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
            reportType.selectByIndex(1);
            Thread.sleep(4000);
            clickMenuItems(driver, "Run");
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

    public static void clickMenuItems(WebDriver driver, String usage) {

        Boolean actualOutcome = false;
        String str = null;
        try {
            Thread.sleep(2000);
            List<WebElement> list = driver.findElement(By.cssSelector("div[class='pull-right workflow-navbar__top-menu-options']")).findElements(By.cssSelector("span[class='workflow-navbar__text-label ng-binding']"));
            int size = list.size();
            System.out.println("Menu Items: " + size);
            for (int i = 0; i < size; i++) {

                str = list.get(i).getText().trim();
                System.out.println("str : " + str);
                if (usage.equals(str)) {
                    list.get(i).click();
                    break;
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Start Editing Click Failed");
            log.error("", e);
        }
    }

    public static boolean validateSuccess(WebDriver driver, WebDriverWait wait, String value) {

        boolean flag = true;
        //WebDriver driver = DriverFactory.getWebDriver()
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));

            List<WebElement> list = driver.findElements(By.cssSelector("div[class='graph-node__content']"));
            int size = list.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {

                WebElement we = list.get(i).findElement(By.cssSelector("status-icon[class='graph-node__status-icon ng-scope ng-isolate-scope']")).findElement(By.cssSelector("div[popover-placement='right']"));

                String str = we.getAttribute("class").trim();

                System.out.println(str);

                if (str.equals(value)) {
                    System.out.println("Read Node Executed Successfully");
                    flag = true;
                } else {
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

    public static void clickOkButton(WebDriver driver, WebDriverWait wait) throws Exception {

        Boolean actualOutcome = false;

        try {

            Thread.sleep(2000);
            List<WebElement> list = driver.findElements(By.cssSelector("button[class='ajs-button btn btn-primary']"));
            int size = list.size();
            System.out.println(size);
            if (size == 1) {
                list.get(0).click();
                Thread.sleep(1000);
            } else {
                list.get(1).click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyAAWorkflow2(WebDriver driver) {
        boolean flag = true;
        int counter = 0;
        try {
            List<WebElement> Weblist = driver.findElement(By.cssSelector("div[class='c-dynamic-part ng-scope']")).findElement(By.cssSelector("div[class='editor']")).findElement(By.cssSelector("div[class='flowchart-paint-area']")).findElements(By.cssSelector("graph-node[class='graph-node-component ng-scope ng-isolate-scope jtk-draggable jtk-endpoint-anchor jtk-connected']"));
            int size = Weblist.size();
            System.out.println("No. of nodes " + size);
            for (int i = 0; i < size; i++) {
                List<WebElement> we = Weblist.get(i).findElement(By.tagName("status-icon")).findElements(By.tagName("div"));
                //WebElement we1 = we.get(0)
                String sText1 = we.get(0).getAttribute("class");
                sText1 = sText1.trim();
                System.out.println(sText1);

                if (sText1.contains("status-icon completed")) {
                    counter += 1;
                    //flag=true
                    System.out.println("pass");
                } else {
                    flag = false;
                    System.out.println("continue");
                }

            }//end of for loop
            if (counter == size) {
                System.out.println("No. of nodes having checked status " + counter);
                System.out.println("pass:- No. of nodes and checked status are equal");
            } else {
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

    public static void dashboardFailure(WebDriver driver, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        screenShot.add(SeleniumUtils.takeScreenShot(driver));

        Records.setSan_aut_id(san_aut_id);
        record.setTestCaseName("UAT-DASHBOARD-01");
        record.setOutcome(actualOutcome);
        record.setName("Dashboard.");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Dashboard completed successfully.");
        clientVersionDao.setRecordDetails(record);

        listOb.add(record);
        System.out.println("Dashboard creation failed due to null widgetlist.");
    }

    public static int checkNull(List<String> widgetList) {
        int flag = 0;
        for (String name : widgetList) {
            if (name.contains("Mcube_")) {
                flag = 1;
                break;
            } else {
                flag = 0;
            }
        }
        return flag;
    }

    public static boolean checkVersion(WebDriver driver, WebDriverWait wait, List<Records> listOb, String className, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        List<File> screenShot = new ArrayList<>();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HelpglobalTitleID")));
            driver.findElement(By.id("HelpglobalTitleID")).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appVersionHelpPageID")));
            String version = driver.findElement(By.id("appVersionHelpPageID")).getText().trim();
            System.out.println("Version name : " + version);
            if (className.contains("4520") && version.equals("Version: 4.5.2.0"))
                actualOutcome = true;
            else if (className.contains("4510") && version.equals("Version: 4.5.1.1"))
                actualOutcome = true;
            else if (className.contains("4500") && version.equals("Version: 4.5.0.0"))
                actualOutcome = true;
            else if (className.contains("ipds") && version.equals("Version: 3.2.0.0"))
                actualOutcome = true;
            else actualOutcome = className.contains("ad4300") && version.equals("Version: 4.3");
        } catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
            //throw new RuntimeException(e);
        } finally {
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

    public static void runWorkspace(WebDriver driver, List<Records> listOb, String username, String password, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<File>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.cssSelector("//a[@class='nav-bar-item']")).click();
            String str = driver.findElement(By.cssSelector("//span[@class='workflow-navbar__text-label ng-binding']")).getText().trim();
            System.out.println("Str : " + str);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(str)));
            if (str.equalsIgnoreCase("Stop editing")) {
                driver.findElement(By.cssSelector("(//span[@class='workflow-navbar__text-label ng-binding'])[3]")).click();

            }

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();
            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            try {
                driver.findElement(By.id("casErrorDiv"));
                actualOutcome = true;
            } catch (Exception e) {
                actualOutcome = false;
                log.error("", e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
        } finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("UAT-LOGIN-01");
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

    public static boolean addNode(WebDriver driver, WebDriverWait wait, List<String> node, List<File> screenShot, int rows, String fileName) throws Exception {

        Actions actions = new Actions(driver);
        String nodeName = null;
        Boolean actualOutcome = false;

        System.out.println("Inside addNode");

        try {

            for (int i = 0; i < node.size(); i++) {
                nodeName = node.get(i);
                System.out.println(nodeName);
                WebElement elementLocator = driver.findElement(By.cssSelector("div[class='new-node-container']"));
                actions.contextClick(elementLocator).perform();
                Thread.sleep(1000);

                driver.findElement(By.cssSelector("div[class='new-node__input-container']")).findElement(By.tagName("input")).sendKeys(nodeName);

                Thread.sleep(2000);

                driver.findElement(By.cssSelector("div[class='operations__name ng-binding']")).click();

                Thread.sleep(2000);

                    System.out.println("Inside Read Data if not  for details filling ------->");
                    boolean detailsOutcome = detailsFilling(driver, wait, i, nodeName, screenShot);
                    System.out.println("deatailOutcome : "+detailsOutcome);

                try {
                    String statusDetails = "";
                    statusDetails = (detailsOutcome==true) ? "PASS" : "FAIL";
                    Label labelDetailsFilling = new Label(6,rows,statusDetails);
                    WriteData.setData(fileName, 0, labelDetailsFilling);
                    Label labelNodeAddition = new Label(5,rows,statusDetails);
                    WriteData.setData(fileName, 0, labelNodeAddition);

                    if(detailsOutcome==false)
                    {
                        System.out.println("Returning false");
                        return false;
                    }
                    else {
                        System.out.println("Continue at i "+i);
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Inside try for details Filling status");
                    e.printStackTrace();
                }

            }

            Thread.sleep(2000);
            Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
            reportType.selectByIndex(1);
            Thread.sleep(4000);
            clickMenuItems(driver, "Run");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(10000);

            //------------------------------------------Start-----------
            System.out.println("Waiting for Run button to be visible again");

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run")));
                System.out.println("Run re-appears after completing the task");
                Label label = new Label(7,rows,"PASS");
                WriteData.setData(fileName, 0, label);

            } catch (Exception e) {
                SeleniumUtils.takeScreenShot(driver);
                System.out.println("Workspace is running already -> No RUN present");
                actualOutcome = false;
                Label label = new Label(6,rows,"FAIL");
                WriteData.setData(fileName, 0, label);
                log.error("", e);
            }

            boolean verifyAA = SeleniumUtils.verifyAAWorkflow2(driver);
            Thread.sleep(2000);
            System.out.println("Verify AA : " + verifyAA);

            actualOutcome = verifyAA;
            System.out.println("Validate Workflow : " + actualOutcome);
            //------------------------------------------------End -----------------

        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            actualOutcome= false;
            return actualOutcome;
            //end of catch block
        }//end of method
        return actualOutcome;
    }

    public static boolean detailsFilling(WebDriver driver, WebDriverWait wait,int index,String nodeName, List<File> screenShot) throws Exception {

        System.out.println("Inside detailsFilling------->");
        boolean flag=false;
        Actions actions = new Actions(driver);
        String str=null;
        String datasetName="demo_lab_data1.csv";
        String datasourceName="demo_lab_data_20_04_2023";

        System.out.println("Node name : "+nodeName);
        if (nodeName.equals("Read Data")) {
            System.out.println("Inside Read Data node name : "+nodeName);

            System.out.println("Inside Read Data------->");
            List<WebElement> list1 = driver.findElements(By.cssSelector("div[class='custom-name ng-binding ng-scope']"));
            list1.get(0).findElement(By.cssSelector("span[class='ng-binding']")).click();
            System.out.println("Clciked Read Data for data source entry");
            //driver.findElement(By.cssSelector("div[class='custom-name ng-binding ng-scope']")).findElement(By.cssSelector("span[class='ng-binding']")).click();
            libraryConnection(driver,datasourceName,screenShot);
            Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
            reportType.selectByIndex(1);
            Thread.sleep(1000);
            clickMenuItems(driver,"Run");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(10000);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run")));
                System.out.println("Run re-appears after Running Read Data");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Read Data still running after 60 secs");
                flag=false;
            }

            Thread.sleep(2000);
            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,-450,-250,1);
            flag=true;

        } else if (nodeName.equals("Handle Missing Values")){
            System.out.println("Inside Handle Missing Values------->");

            List<String> listEditSelection = Arrays.asList("Testing_Department");

            SeleniumUtils.editSelection(driver,listEditSelection,nodeName);

            WebElement webEl = driver.findElement(By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[3]"));
            SeleniumUtils.scrollByVisibleElement(driver, webEl);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[3]"))).selectByValue("string:Full report");

            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,-300,-250,2);
            flag=true;
        }
        else if (nodeName.equals("String Indexer")){
            System.out.println("Inside String Indexer------->");

            List<String> listEditSelection = Arrays.asList("Order_Source_Location","Container_Type","Test_Result_Name",
                    "Abnormality_Status","Sample_Fluid_Type","Patient_Type","Patient_Gender");

            SeleniumUtils.editSelection(driver,listEditSelection,nodeName);

            //Output dropdown                                                     form-control ng-pristine ng-untouched ng-valid ng-not-empty
            new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"))).selectByValue("string:append new columns");
            System.out.println("Output as append new column is selected");
                                             //form-control ng-pristine ng-untouched ng-valid ng-scope ng-empty
            driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-scope ng-empty']")).sendKeys("Index_");

            WebElement webEl = driver.findElement(By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])"));
            SeleniumUtils.scrollByVisibleElement(driver, webEl);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])"))).selectByValue("string:Full report");

            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,-150,-250,3);
            flag=true;
        }
        else if (nodeName.equals("Assemble Vector")){
            System.out.println("Inside Assemble Vector------->");

            List<String> listEditSelection = Arrays.asList("Patient_age","Index_Sample_Fluid_Type","Index_Patient_Gender",
                    "Index_Patient_Type","Index_Abnormality_Status");

            SeleniumUtils.editSelection(driver,listEditSelection,nodeName);

            driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']")).sendKeys("features");

            WebElement webEl = driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"));
            SeleniumUtils.scrollByVisibleElement(driver, webEl);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"))).selectByValue("string:Full report");

            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,-10,-250,4);
            flag=true;
        }
        else if (nodeName.equals("Transform/Predict")){
            System.out.println("Inside Transform/Predict------->");

            //List<WebElement> totalEditNodes = driver.findElements(By.xpath("//i[@class='fa fa-server action-icon node-icon-styles']"));
            List<WebElement> totalEditNodes = driver.findElements(By.xpath("//div[@class='operation-name']"));
            int nodeNo = totalEditNodes.size();

            System.out.println("Node No inside Tranform/Predict : "+nodeNo);

            driver.findElement(By.xpath("(//div[@class='operation-name'])["+nodeNo+"]")).click();
            Thread.sleep(2000);

            WebElement webEl = driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"));
            SeleniumUtils.scrollByVisibleElement(driver, webEl);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"))).selectByValue("string:Full report");

            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,140,-250,1);
            flag=true;
        }
        else if (nodeName.equals("Filter Columns")){
            System.out.println("Inside Filter Columns------->");

            List<String> listEditSelection = Arrays.asList("probability","Index_Sample_Fluid_Type","features","Index_Order_Source_Location","Index_Patient_Gender",
                    "rawPrediction","Index_Test_Result_Name","Index_Patient_Type","Index_Abnormality_Status","Index_Container_Type");

            SeleniumUtils.editSelection(driver,listEditSelection,nodeName);

            WebElement webEl = driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"));
            SeleniumUtils.scrollByVisibleElement(driver, webEl);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"))).selectByValue("string:Full report");

            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,-430,-100,2);
            flag=true;
        }
        else if (nodeName.equals("SQL Transformation")){
            System.out.println("Inside SQL Transformation------->");

            List<WebElement> totalEditNodes = driver.findElements(By.xpath("//div[@class='operation-name']"));
            int nodeNo = totalEditNodes.size();

            System.out.println("Node No inside Tranform/Predict : "+nodeNo);

            driver.findElement(By.xpath("(//div[@class='operation-name'])["+nodeNo+"]")).click();
            Thread.sleep(2000);

            WebElement area = driver.findElement(By.xpath("//div[@class='ace_scroller']"));
            driver.findElement(By.xpath("//div[@class='ace_scroller']")).click();
            String ctrlA = Keys.chord(Keys.CONTROL, "a",Keys.DELETE);
            area.sendKeys(ctrlA);
//            String delA = Keys.chord(Keys.DELETE);
//            area.sendKeys(delA);
            String sqlData = "SELECT case when metric = 'TP' then count end as TP,case when metric = 'TN' then count end as TN, case when metric = 'FP' then count end as FP,case when metric = 'FN' then count end as FN FROM ((SELECT count(*) as Count, \"TP\" as Metric FROM df where ontime_flag=1 and prediction =1)\n" +
                    "UNION ALL\n" +
                    "(SELECT count(*) as Count, \"TN\" as Metric FROM df where ontime_flag=0 and prediction =0)\n" +
                    "UNION ALL\n" +
                    "(SELECT count(*) as Count, \"FP\" as Metric FROM df where ontime_flag=0 and prediction =1)\n" +
                    "UNION ALL\n" +
                    "(SELECT count(*) as Count, \"FN\" as Metric FROM df where ontime_flag=1 and prediction =0))\n";

            driver.findElement(By.xpath(" //div[@class='ace_scroller']")).sendKeys(sqlData);


            WebElement webEl = driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"));
            SeleniumUtils.scrollByVisibleElement(driver, webEl);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"))).selectByValue("string:Full report");

            SeleniumUtils.setOffsetDragAndDrop(driver,nodeName,-280,-100,1);
            flag=true;
        }

        return flag;
    }

    public static void setOffsetDragAndDrop(WebDriver driver, String nodeName, int x, int y, int nodeNo) throws InterruptedException {
        Actions actions = new Actions(driver);
        System.out.println("Inside setOffsetDragAndDrop and nodeName = "+nodeName +" and x = "+x+" y = "+y );
        nodeNo=nodeNo-1;
        System.out.println("Node No : "+nodeNo);

        List<WebElement> list1=driver.findElements(By.cssSelector("div[class='graph-node__content']"));
        actions.dragAndDropBy(list1.get(nodeNo),x,y).build().perform();
        Thread.sleep(3000);
        if(!nodeName.equals("Read Data") && !nodeName.equals("Handle Missing Values")
                && !nodeName.equals("Transform/Predict")) {
            List<WebElement> drag1 = driver.findElements(By.cssSelector("div[class='jtk-endpoint jtk-endpoint-anchor jtk-draggable jtk-droppable output dataframe']"));
            List<WebElement> drop1 = driver.findElements(By.cssSelector("div[class='jtk-endpoint jtk-endpoint-anchor jtk-draggable jtk-droppable dataframe']"));
            Thread.sleep(2000);
            System.out.println("drop1 size : "+drop1.size());
            System.out.println("drag1 size : "+drag1.size());
            actions.dragAndDrop(drag1.get(0), drop1.get(0)).build().perform();
        }
        else if (nodeName.equals("Handle Missing Values"))
        {
            List<WebElement> drag1 = driver.findElements(By.cssSelector("div[class='jtk-endpoint jtk-endpoint-anchor jtk-draggable jtk-droppable has-report sa sa-chart output dataframe']"));
            List<WebElement> drop1 = driver.findElements(By.cssSelector("div[class='jtk-endpoint jtk-endpoint-anchor jtk-draggable jtk-droppable dataframe']"));
            Thread.sleep(2000);
            System.out.println("drop1 size : "+drop1.size());
            System.out.println("drag1 size : "+drag1.size());
            actions.dragAndDrop(drag1.get(0), drop1.get(0)).build().perform();
        }
    }
    public static void editSelection(WebDriver driver,List<String> listEditSelection,String nodeName) throws Exception {

        try {
            System.out.println("Inside editSelection------->");
            List<WebElement> totalEditNodes = driver.findElements(By.xpath("//i[@class='fa fa-server action-icon node-icon-styles']"));
            int nodeNo = totalEditNodes.size();

            driver.findElement(By.xpath("(//i[@class='fa fa-server action-icon node-icon-styles'])["+nodeNo+"]")).click();

            Thread.sleep(3000);
            if(nodeName.equals("String Indexer"))
            {
                //Multiple columns
                System.out.println("Inside String Indexer dropdwon select");
                new Select(driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']"))).selectByValue("string:multiple columns");
                System.out.println("Multiple columns selected");
            }

            driver.findElement(By.xpath("//button[@class='btn btn-info btn-xs o-action-text add-selector-item']")).click();
            System.out.println("Edit Selection is clicked");
            //List<WebElement> selections = new ArrayList<>();
            List<WebElement> sections = driver.findElements(By.xpath("//article[@class='modal-body u-flex o-modal-selector__main-panel ng-scope']/section"));
            sections.get(1).findElement(By.tagName("div")).click();
            System.out.println("Div is clickedd");
            for(int i=0;i<listEditSelection.size();i++) {
                System.out.println("i---->"+i);

                if(i==0) {
                    driver.findElement(By.xpath("//input[@class='form-control o-custom ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']")).sendKeys(listEditSelection.get(i));
                }
                else {
                    driver.findElement(By.xpath("//input[@class='form-control o-custom ng-dirty ng-touched ng-empty ng-invalid ng-invalid-required']")).sendKeys(listEditSelection.get(i));
                }
                driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
                System.out.println("j---->"+i);
            }
            driver.findElement(By.xpath("//button[@class='btn btn-sm btn-info']")).click();
            System.out.println("Done is clicked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void libraryConnection(WebDriver driver,String datasourceName, List<File> screenShot) throws Exception {

        Random rand = new Random();
        int randomNo = rand.nextInt(1000000);
        String randNo = String.valueOf(randomNo);
        System.out.println("randNo : "+randNo);
        String datasetName="demo_lab_data1.csv";
        datasourceName=datasourceName+randNo;
        System.out.println("datasourceName : "+datasourceName);
        try {
            /*driver.findElement(By.cssSelector("div[class='model-navigator']")).findElement(By.cssSelector("li[ng-click='$ctrl.openDatasources()']")).click();
            Thread.sleep(4000);*/
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("span[class='btn-modal__icon sa sa-library']")).click();

            driver.findElement(By.cssSelector("input[placeholder='Search in library']")).sendKeys(datasetName);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(1000);

            driver.findElement(By.cssSelector("div[class='name-section']")).findElement(By.cssSelector("div[title='demo_lab_data1.csv']")).click();
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(1000);

            driver.findElement(By.cssSelector("input[name='datasourceName']")).clear();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(datasourceName);

            driver.findElement(By.cssSelector("button[class='btn btn-blue ng-scope']")).click();
            System.out.println("OK button is clicked for saving data source");

            Thread.sleep(2000);

            driver.findElement(By.cssSelector("input[id='myInput']")).sendKeys(datasourceName);

            Thread.sleep(2000);

            driver.findElement(By.cssSelector("div[title="+datasourceName+"]")).click();
            Thread.sleep(2000);
        }
        catch (Exception e) {
            log.error("", e);
        }
    }
    public static void setBlankInExcelForHeader(String fileName) {
        for (int j = 0; j <= 3; j++) {
            Label labelBlank = new Label(1, j, "");
            WriteData.setData(fileName, 0, labelBlank);
            System.out.println("Upper Header Details turned blank in EXCEL");
        }
    }
    public static void setBlankInExcelForRows(int rows, String fileName){

        for(int i=0;i<=8;i++) {
            Label labelBlank = new Label(i, rows, "FAIL");
            WriteData.setData(fileName, 0, labelBlank);
            System.out.println("Bottom Thread Details turned blank in EXCEL");
        }
    }

    public static void switchCluster(WebDriver driver, String clusterName) throws InterruptedException {
        driver.findElement(By.xpath("//img[@ng-switch-when='"+clusterName+"']")).click();
       Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class='btn btn-white'])")).click();
        System.out.println("Closed button is clicked after cluster switch");
    }
}
