package com.jdbc.automation.executor.mcube510.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class TreeTable2 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();
    public static String treeTable2(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        boolean flag= true;
        int n=0;
        String name = "null";
        String temp="false";
        String error="";
        String XAxis = "Range";
//        String XAxis = "Terms|Histogram|Date Histogram|Range";
        int totalSize=0,stringSize=0;

        String[] xaxis = XAxis.split("\\|");
        try{
            System.out.println("Inside Tree table 2");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
            Thread.sleep(3000);
            try
            {
                for (int xcounter1 = 0; xcounter1 < xaxis.length; xcounter1++)
                  {
                    System.out.println("ASxaxis[xcounter1] : "+xaxis[xcounter1]);
                    driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")).click();
                    Thread.sleep(3000);
                    System.out.println("ABC1");
                    Select drpCounter = new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
                    System.out.println("ABC2");
                    drpCounter.selectByVisibleText(xaxis[xcounter1]);
                    System.out.println("ABC3");
                    System.out.println("AAAxaxis[xcounter1] : "+xaxis[xcounter1]);
                    System.out.println("ABC4");
    //                driver.findElement(By.linkText(xaxis[xcounter1])).click();
                    try {
                        switch (xaxis[xcounter1])
                        {
                            case "Terms":
                                    System.out.println("Inside Terms ----------------------------------------------------------------------");
                                    totalSize = SeleniumUtils.noOfXFields(driver);    //Need to change the validation
                                    System.out.println("Total Size :"+totalSize);
                                    stringSize = SeleniumUtils.noOfXFields(driver);  //Need to change the validation
                                    System.out.println("String Size Terms:"+stringSize);
                                try {
                                    for (int xcounter2 = ((totalSize - stringSize) + 3); xcounter2 < totalSize; xcounter2++){
//                                    for (int xcounter2 = ((totalSize - stringSize) + 3); xcounter2 < 4; xcounter2++){
                                        try {
                                            Select drpXcounter = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                                            drpXcounter.selectByIndex(xcounter2);
                                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                            System.out.println("Expand is closed for Terms");
                                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                            Thread.sleep(5000);
                                            List<String> chartData =SeleniumUtils.collectChartData(driver);
                                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                            Select page =  new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                                            page.selectByVisibleText("All");
                                            Thread.sleep(5000);
                                            boolean data= SeleniumUtils.validateData(chartData, "Both",driver);
                                            boolean metrics = SeleniumUtils.validateMetrics(driver);
                                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                                            System.out.println("Data: " + data);

                                            System.out.println("Terms Metrics: " + metrics);
                                            if (!(data) || !(metrics)) {
                                                flag = false;
                //                                error = ((((error + ycounter1) + '\t') + ycounter2) + '\n');
                                            }
                                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                            System.out.println("Chv is clicked for opening the Terms");
                                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                            System.out.println("Split Rows X is expanded for Terms");
                                        } catch (InterruptedException e) {
                                            System.out.println("1. Terms Catch e:"+e);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("2. Terms Catch e:"+e);
                                }
                                break;
                            case "Histogram":
                                System.out.println("Inside Histograms ----------------------------------------------------------------------");
                                totalSize = SeleniumUtils.noOfXFields(driver);
                                System.out.println("Total Size :"+totalSize);
                                    for (int xcounter2 = 2; xcounter2 < totalSize; xcounter2++){
                                    Select drpXcounter = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                                    drpXcounter.selectByIndex(xcounter2);
                                    driver.findElement(By.xpath("//input[@id='2intervalID']")).sendKeys("1000");
                                    if(xcounter2==2){
                                        driver.findElement(By.xpath("//input[@id='2mdcInputID']")).click();

                                    }
                                    driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                    driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                    Thread.sleep(5000);
                                    List<String> chartData =SeleniumUtils.collectChartData(driver);
                                    driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                    Select page =  new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                                    page.selectByVisibleText("All");
                                    Thread.sleep(5000);
                                    boolean data= SeleniumUtils.validateData(chartData, "Both",driver);
                                    boolean metrics = SeleniumUtils.validateMetrics(driver);
                                    System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                                    System.out.println("Data: " + data);
                                    System.out.println("Metrics: " + metrics);
                                    if (!(data) || !(metrics)) {
                                        flag = false;
        //                                error = ((((error + ycounter1) + '\t') + ycounter2) + '\n');
                                    }
                                    driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                    driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                }
                                    break;
                            case "Date Histogram":
                                System.out.println("Inside Date Histogram ----------------------------------------------------------------------");
                                String interval = "Weekly|Monthly|Yearly";
                                String[] intervals = interval.split("\\|");
                                Select date=new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                                date.selectByVisibleText("Order Date");
                                    for (int xcounter2 = 0; xcounter2 < intervals.length; xcounter2++){
                                    Select timeInterval = new Select(driver.findElement(By.xpath("//select[@id='2selectIntervalID']")));
                                    timeInterval.selectByVisibleText(intervals[xcounter2]);
                                    driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                    driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                    Thread.sleep(5000);
                                    List<String> chartData =SeleniumUtils.collectChartData(driver);
                                    driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                    Select page =  new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                                    page.selectByVisibleText("All");
                                    Thread.sleep(5000);
                                    boolean data= SeleniumUtils.validateData(chartData, "Both",driver);
                                    boolean metrics = SeleniumUtils.validateMetrics(driver);
                                    System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                                    System.out.println("Data: " + data);
                                    System.out.println("Metrics: " + metrics);
                                    if (!(data) || !(metrics)) {
                                        flag = false;
        //                                error = ((((error + ycounter1) + '\t') + ycounter2) + '\n');
                                    }
                                    driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                    driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                }
                                break;
                            case "Range":
                                System.out.println("Inside Range ----------------------------------------------------------------------");
                                totalSize = SeleniumUtils.noOfXFields(driver);    //Need to change the validation
                                int dup = 0;
                                System.out.println("Total Size of Range:"+totalSize);
                                    for (int xcounter2 = 2; xcounter2 < totalSize-1; xcounter2++){
                                        dup=xcounter2;
                                        Select xcounter = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                                        xcounter.selectByIndex(xcounter2);
                                        driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                        driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                        Thread.sleep(5000);
                                        List<String> chartData =SeleniumUtils.collectChartData(driver);
                                        driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                        Select page =  new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                                        page.selectByVisibleText("All");
                                        Thread.sleep(5000);
                                        boolean data= SeleniumUtils.validateData(chartData, "Only Y",driver);
                                        boolean metrics = SeleniumUtils.validateMetrics(driver);
                                        System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                                        System.out.println("Data: " + data);
                                        System.out.println("Metrics: " + metrics);
                                        if (!(data) || !(metrics)) {
                                            flag = false;
            //                                error = ((((error + ycounter1) + '\t') + ycounter2) + '\n');
                                        }
                                        driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                        System.out.println("Chhevbron is clickeuf");
                                        driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                        System.out.println("Collapsed is clicked for Range and xcounter :"+xcounter2);
                                      }
                                break;
                            default:
                                System.out.println("END BSxaxis[xcounter1] : "+xaxis[xcounter1]);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Error of switch case: "+e);
                    }
                  }
            } catch (InterruptedException e) {
                System.out.println("Exception for loop ALL: "+e);
            }

            if (flag == true) {
                System.out.println("Tree table2 passeed");
            } else {
                System.out.println("Tree table2 faileddf");
            }

            Random rand = new Random();
            name = "Mcube_TreeTable2_"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);
            System.out.println("temp : "+temp);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println("Inside big catch of TreeTable2 e:"+e);
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

            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-TREE_TABLE-01");
            record.setOutcome(actualOutcome);
            record.setName("Tree table Chart.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Tree table completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome && temp.equals("false")) {
                log.info("Tree Table creation failed.");
                return "null";
            }
            else
                return name;
        }
    }

}
