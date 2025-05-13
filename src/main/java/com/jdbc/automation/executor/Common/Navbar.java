package com.jdbc.automation.executor.Common;

import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Navbar_buttons.*;
import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class Navbar {
    private static final Logger log = LoggerFactory.getLogger(Navbar.class);
    static Records record = new Records();
    public static String navbar(WebDriver driver, WebDriverWait wait, String username, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id,String appName) throws Exception {
        List<File> screenShot = new ArrayList<>();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        String name = "null";
        String applName = "";
    try{
        System.out.println("Inside Navbar for :"+appName);

//--------        Landing Page----------------------------------
        if(appName.equalsIgnoreCase("Landing")) {
            System.out.println("Inside Landing if block");
            actualOutcome = checkButtons(driver, username, appName, screenShot);
        }


        //-------------------------BI----------------------------------

        if(appName.equalsIgnoreCase("BI")) {
            System.out.println("Inside BI if blockg");
//            driver.findElement(By.xpath("//a[@href='/nxtgen']")).click();
            Thread.sleep(3000);
            try {
                applName = driver.findElement(By.xpath("//div[@class='breadcr col-sm-8']/ul/li/a")).getText();
            } catch (Exception e) {
                System.out.println("Exception of BI: "+e);
                applName = driver.findElement(By.xpath("//div[@class='localNavRow']/div/ul/li/a")).getText();
                Thread.sleep(3000);
            }

            actualOutcome = checkButtons(driver, username, applName, screenShot);
        }
        //td[normalize-space()='John Smith']/preceding-sibling::td[3]/input


//        ---------------------AI--------------------
        if(appName.equalsIgnoreCase("AI")) {
            try {
                System.out.println("Inside AI if block");
//            driver.findElement(By.xpath("//a[@href='/aa']")).click();
                waitForPageLoad(driver);
                Thread.sleep(5000);
//                applName = driver.findElement(By.xpath("//div[@class='sc-ixGGxD caaPGn link']")).getText();
                applName = driver.findElement(By.xpath("//div[@class='crumb']/div/div")).getText();
                Thread.sleep(3000);
                waitForPageLoad(driver);
                System.out.println("Appname--->" + applName);
                Boolean actualOutcome1 = checkButtons(driver, username, applName,screenShot);
                Boolean actualOutcome2 = chkThreeDots(driver, applName,listOb, clientVersionDao, san_aut_id);
                Thread.sleep(2000);
                //Boolean actualOutcome3 = backToHome(driver, applName,listOb, clientVersionDao, san_aut_id);

                System.out.println("actualOutcome1 : "+actualOutcome1);
                System.out.println("actualOutcome2 : "+actualOutcome2);
//                System.out.println("actualOutcome3 : "+actualOutcome3);
                actualOutcome = (actualOutcome1 && actualOutcome2) ? true : false;
            } catch (Exception e) {
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                actualOutcome = false;
                System.out.println("AI err msg : "+e);
            }
        }


//        -------------------------ezextend-------------------------------
        if(appName.equalsIgnoreCase("ezeXtend")) {
            Boolean ezactualOutcome1,  ezactualOutcome2,  ezactualOutcome3 = false;

            System.out.println("Inside ezeXtend if block");
//            driver.findElement(By.xpath("//a[@href='/ezextend']")).click();
            Thread.sleep(3000);
            applName = driver.findElement(By.xpath("//div[@class='breadcr']/ul/li[1]/a")).getText();
            Thread.sleep(3000);
            System.out.println("Appname--->>>" + applName);
            ezactualOutcome1 = checkButtons(driver, username, applName,screenShot);
            ezactualOutcome2 = chkThreeDots(driver, applName,listOb, clientVersionDao, san_aut_id);
            Thread.sleep(2000);
//            ezactualOutcome3 = backToHome(driver, applName,listOb, clientVersionDao, san_aut_id);

            System.out.println("eze actualOutcome1 : "+ezactualOutcome1);
            System.out.println("eze actualOutcome2 : "+ezactualOutcome2);
//            System.out.println("eze actualOutcome3 : "+ezactualOutcome3);
            actualOutcome = (ezactualOutcome1 && ezactualOutcome2) ? true : false;
            System.out.println("Final ez outcome : "+actualOutcome);
        }


        //----------------------------Workbench--------------------------------//
        if(appName.equalsIgnoreCase("Workbench")) {
            System.out.println("Inside Workbench if block");
//            driver.findElement(By.xpath("//a[@href='/workbench']")).click();
            Thread.sleep(3000);
            String text1 = driver.findElement(By.xpath("//div[@class='col-md-offset-1 col-md-10 ng-scope']/h2")).getText();
            if (text1.equals("Real Time Streaming")) {
                applName = "Workbench";
                System.out.println("Appname---from Navbar" + applName);
                actualOutcome = checkButtons(driver, username, applName,screenShot);
            }
        }
//        chkWorkspace(driver,applName);
//        Thread.sleep(2000);
//        chkhelp(driver,applName);
//        Thread.sleep(3000);
//        chkProfile(driver,applName,username);
//        Thread.sleep(2000);
//        backToHome(driver,applName);



    }
    catch (Exception e) {
        screenShot.add(SeleniumUtils.takeScreenShot(driver));
        actualOutcome = false;
        driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
        Thread.sleep(3000);
        WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
        SeleniumUtils.clickModal(driver, webEl);
        Thread.sleep(2000);
        log.error("",e);
    }
    finally {
        Navbar.waitForPageLoad(driver);
        record.setSan_aut_id(san_aut_id);
        record.setTestCaseName("SAN-NAV-"+appName+"-01");
        record.setOutcome(actualOutcome);
        record.setName(appName+" Navbar Checked");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Navbar "+appName+" completed successfully.");
        clientVersionDao.setRecordDetails(record);

        listOb.add(record);

        if (!actualOutcome) {
            log.info("Navbar creation failed.");
            return "null";
        }
        else
            return name;
    }

    }

public static Boolean checkButtons(WebDriver driver,String username, String applName,List<File> screenShot) throws Exception {
    System.out.println("------------------------------------START------------------------------------------");
    System.out.println("Inside checkButtons..");
    System.out.println("Appname---->"+applName);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='common-navbar']")));
    waitForPageLoad(driver);
    System.out.println("Waited for page to load :"+applName);
    try {
        chkWorkspace(driver,applName);
        Thread.sleep(2000);
        screenShot.add(SeleniumUtils.takeScreenShot(driver));
        chkhelp(driver,applName);
        Thread.sleep(2000);
        screenShot.add(SeleniumUtils.takeScreenShot(driver));
        chkProfile(driver,username,applName,"Mcube@123!","Mcube@1234!","Yes");
        Thread.sleep(2000);
        screenShot.add(SeleniumUtils.takeScreenShot(driver));
        System.out.println("---------------------------------END---------------------------------------------");
//        backToHome(driver,applName);
    } catch (Exception e) {
        System.out.println("Err Message ::"+e);
        System.out.println("Return False");
        return false;
    }
    System.out.println("RETURN TRUE FOR :"+applName);
    return true;
 }

//    public static void waitForPageLoad(WebDriver driver) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
//        );
//    }


    public static void waitForPageLoad(WebDriver driver) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
                        && (Boolean) ((JavascriptExecutor) webDriver).executeScript("return !!window.jQuery ? jQuery.active == 0 : true"));
    Thread.sleep(3000);
    }


    public static Boolean tilesButton(WebDriver driver, String appname) throws InterruptedException {
//        driver.navigate().refresh();
        waitForPageLoad(driver);
        System.out.println("Inside tilesButton Click of Navar . java");
        try {
            Navbar.waitForPageLoad(driver);
            //Profile button
            if (appname.equalsIgnoreCase("BI")) {
                driver.findElement(By.xpath("//div[normalize-space()='Business Intelligence']")).click();
                System.out.println("BI is clickeed");
            }else if (appname.equalsIgnoreCase("AI")) {
                driver.findElement(By.xpath("//div[normalize-space()='Artificial Intelligence']")).click();
                System.out.println("AI is clicked");
            }else if (appname.equalsIgnoreCase("ezeXtend")) {
                driver.findElement(By.xpath("//div[normalize-space()='ezeXtend']")).click();
                System.out.println("ezextend is clicked");
            }else if (appname.equalsIgnoreCase("Workbench")) {
                driver.findElement(By.xpath("//div[normalize-space()='Workbench']")).click();
                System.out.println("Workbench is clicked");
            }

            System.out.println("Tile button for :"+appname+": is clicked !!");
            Thread.sleep(3000);
            Navbar.waitForPageLoad(driver);

            return true;
        } catch (Exception e) {
            System.out.println("Tile button Catch : "+e+" for appname : "+appname);
            return false;
        }

    }
    public static Boolean profileButtons(WebDriver driver, String appname) throws InterruptedException {
        waitForPageLoad(driver);
        try {
            //Profile button
            if(appname.equalsIgnoreCase("Landing"))
                driver.findElement(By.xpath("//span[@class='nav-link admin-toggle cursr-pt']")).click();
            else if (appname.equalsIgnoreCase("BI")) {
                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/nav[1]/div[3]/ul/li[4]")).click();
            }else if (appname.equalsIgnoreCase("AI")) {
//                driver.findElement(By.xpath("//div[@class='ant-flex css-63xcpf']/div")).click();
                driver.findElement(By.xpath("//div[@class='ant-dropdown-trigger']")).click();
            }else if (appname.equalsIgnoreCase("ezeXtend")) {
                driver.findElement(By.xpath("//div[@class=' css-1jxwmua'][2]")).click();
            }else if (appname.equalsIgnoreCase("Workbench")) {
                driver.findElement(By.xpath("//span[@class='icon-universal']//*[name()='svg']")).click();
            }
            System.out.println("Profile button for "+appname+" is clicked !!");

            return true;
        } catch (Exception e) {
            System.out.println("Profile Catch : "+e+" for appname : "+appname);
            return false;
        }
    }

    public static void loginPostPasswordChange(WebDriver driver, String username, String newPassword) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        System.out.println("Username : "+username);
        System.out.println("New-Password : "+newPassword);
//        driver.get(url);
        Thread.sleep(5000);

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            System.out.println("Entering Credentials to Login After Password Change");
            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).clear();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(newPassword);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();

            Thread.sleep(4000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(3000);

            try{
                driver.findElement(By.id("casErrorDiv")); //No Error message will be shown on screen
                actualOutcome=false;
            }
            catch(Exception e){
                actualOutcome=true;
//                log.error("",e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
//            log.error("",e);
        }

        if(!actualOutcome)
        {
            throw new Exception("Login failed.");
        }
        // listOb.add(record1);
    }

}
