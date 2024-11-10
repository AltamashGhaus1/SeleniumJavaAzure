package com.jdbc.automation.executor.mcube4550.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
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
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class TreeTable2 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();
    public static String treeTable2(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        boolean flag= true;
        int n=0;
        String name = "null";
        String temp="false";
        String error="";
        String XAxis = "Date Histogram|Range|Histogram|Terms";
        int totalSize=0,stringSize=0;

        String[] xaxis = XAxis.split("\\|");
        try{
            System.out.println("Inside Tree table 2");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
            Thread.sleep(3000);
            for (int xcounter1 = 0; xcounter1 < xaxis.length; xcounter1++){
                driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")).click();
                Thread.sleep(3000);
                driver.findElement(By.linkText(xaxis[xcounter1])).click();
                switch (xaxis[xcounter1]){
                    case "Terms":
                        System.out.println("Inside Terms ----------------------------------------------------------------------");


                        totalSize = SeleniumUtils.noOfXFields(driver);    //Need to change the validation

                        System.out.println("Total Size :"+totalSize);
                        stringSize = SeleniumUtils.noOfXFields(driver);  //Need to change the validation

                        System.out.println("String Size :"+stringSize);
                        for (int xcounter2 = ((totalSize - stringSize) + 3); xcounter2 < totalSize; xcounter2++){
                            Select drpXcounter = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                            drpXcounter.selectByIndex(xcounter2);
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

                        System.out.println("Total Size :"+totalSize);
                        for (int xcounter2 = 2; xcounter2 < totalSize; xcounter2++){
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
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();

                          }


                }



            }
            if (flag == true) {
                System.out.println("Tree table1 passed");
            } else {
                System.out.println("Tree table1 failed");
            }

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
