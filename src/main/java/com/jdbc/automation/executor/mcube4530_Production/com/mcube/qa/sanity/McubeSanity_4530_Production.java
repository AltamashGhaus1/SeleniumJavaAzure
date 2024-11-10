package com.jdbc.automation.executor.mcube4530_Production.com.mcube.qa.sanity;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4530_Production.AdvanceAnalytics.ArtificialIntelligence;
import com.jdbc.automation.executor.mcube4530_Production.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class McubeSanity_4530_Production {

    private static final Logger log = LoggerFactory.getLogger(McubeSanity_4530_Production.class);
    //public static String fileName = "https://docs.google.com/spreadsheets/d/19WhgTRyCMkn5XJepi1eSO2Kmf71oo44J/edit?usp=share_link&ouid=107873733469465654847&rtpof=true&sd=true";
    public static String fileName = "D://output.xls";


   /* public void run(){
        System.out.println("thread is running...");
    }*/

    //Add client version dao as argument , Sanity_Aut_Master_ID
    //public static File executeAutomation(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
    public static File executeAutomation(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Date startTime = Calendar.getInstance().getTime();
        DateTimeZone dtZone = DateTimeZone.forID("Asia/Kolkata");
        DateTime startDate = new DateTime(startTime);
        DateTime startDtus = startDate.withZone(dtZone);
        System.out.println("Hello world!");

        List<Records> listOb = new ArrayList<>();
        Integer percentCount = 0;

        //List<File> screenshot = new ArrayList<File>();

        List<String> widgetList = new ArrayList<String>();
        /*widgetList.add("Mcube_Area_Chart13014");
        widgetList.add("Mcube_Combo_Chart12815");
        widgetList.add("Mcube_Tree_Table90377");*/

        //WindowsUtils.killByName("chromedriver.exe");
        /*try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        WebDriver driver = null;
        File pdfFile = null;
        try {

            Thread.sleep(3000);
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C://Selenium//web_driver//chromedriver_win32//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            Thread.sleep(3000);

            Records record = new Records();
            record.setTestCaseName("UAT-URL-01");
            boolean actualOutcome = Boolean.FALSE;
            List<File> screenShot = new ArrayList<>();
            try {
                System.out.println("URL --> " + url);
                driver.get(url);
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                actualOutcome = Boolean.TRUE;
                record.setOutcome(actualOutcome);
                record.setName("URL REACHABILITY");
                record.setScreenShot(screenShot);
                record.setExpectedResult("LOGIN PAGE SHOULD APPEAR");
                listOb.add(record);
            } catch (Exception e) {
                log.error("", e);
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                record.setOutcome(actualOutcome);
                record.setName("URL REACHABILITY");
                record.setScreenShot(screenShot);
                record.setExpectedResult("LOGIN PAGE SHOULD APPEAR");
                listOb.add(record);
                throw new Exception("Provided URL not reachable.");
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            //Login
            driver.manage().window().maximize();
            //SeleniumUtils.loginBIInValid(driver, listOb,username,password,clientVersionDao,san_aut_id);
            Thread.sleep(2000);
            SeleniumUtils.loginBIValid(driver, listOb, username, password, url, clientVersionDao, san_aut_id);

            //percentCount=10;                         //SAN_LOG_1, PASS, Sanity_Aut_Master_ID
            //ClientVersionDao. insertSanityTCOutcome(TC_ID,outcome)
            //PercentageCountDao.setPercentCount(percentCount);

            if(version.equalsIgnoreCase("AI 20 important templates")) {
                ArtificialIntelligence.artificialIntelligence(driver, wait, listOb, clientVersionDao, san_aut_id);
            }

            //CreateWorkflow.createWorkflow(driver, wait, listOb, clientVersionDao, san_aut_id);

        } catch (Exception e) {
            log.error("", e);
        } finally {

            if (null != driver) {
                try {
                    System.out.println("Driver is quiting");
                    //driver.quit();
                } catch (Exception e) {
                    log.error("", e);
                }

            }
            System.out.println("" + listOb.size());
            listOb.forEach(e -> {
                System.out.println(e.toString());
            });
        }
        return pdfFile;
    }

}