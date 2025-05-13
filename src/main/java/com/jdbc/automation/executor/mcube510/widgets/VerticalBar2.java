package com.jdbc.automation.executor.mcube510.widgets;


import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class VerticalBar2 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();
    public static String verticalbar2(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        String name = "null";
        String temp="false";
        int n = 2;

        boolean dataLabels = true;

        boolean chart = true;

        boolean metrics = true;

        boolean xTicks = true;

        boolean flag = true;

        String error = "";
        String XAxis = "Histogram|Terms|Range|Date Histogram";

        String[] xaxis = XAxis.split("\\|");
        System.out.println("Going inside try");
//        Robot rb = new Robot();

//        rb.keyPress(KeyEvent.VK_F11);
        try{
            System.out.println("Inside Vertical bar 2.............");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            driver.findElement(By.linkText("Widget")).click();
            driver.findElement(By.linkText("Widget")).click();
            String widgetName = "Vertical Bar";
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();

            Thread.sleep(3000);
            System.out.println("About to click metric Y axis");
            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
            Thread.sleep(2000);
            System.out.println("To click Show Data Labels");
//            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

            System.out.println("Datalabels clicked");
            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
            System.out.println("Y axis closed");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
            for (int xcounter1 = 0; xcounter1 < xaxis.length; xcounter1++){
                Select drpdown1 = new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
//                drpdown1.selectByIndex(xcounter1);
                drpdown1.selectByVisibleText(xaxis[xcounter1]);
                System.out.println("Dropdown: "+xaxis[xcounter1]);

                switch (xaxis[xcounter1]){
                    case "Terms":
                        int totalSize =  SeleniumUtils.noOfXFields(driver);
                        int stringSize = SeleniumUtils.noOfXStringFields(driver);
                        System.out.println("Total size :"+totalSize);
                        System.out.println("String Size : "+stringSize);

                        for (int xcounter2 = ((totalSize - stringSize) + 3); xcounter2 < totalSize; xcounter2++) {
                            System.out.println("xcounter2 : "+xcounter2);
                            Select drpdown2 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                            drpdown2.selectByIndex(xcounter2);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            Select drpdownAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpdownAll.selectByVisibleText("All");
                            Thread.sleep(2000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');
                            chart = SeleniumUtils.validateChartFormation(driver);
                            System.out.println("Chart1 : "+chart);
                            if (chart) {
                                dataLabels = SeleniumUtils.validateDataLabels(driver);

                            }
                            xTicks = SeleniumUtils.validateXAxisLabels(driver);
                            metrics = SeleniumUtils.validateMetrics(driver);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            Thread.sleep(2000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                            System.out.println((((((("Chart Formation : " + chart) + "\nData Labels\t: ") + dataLabels) + "\nMetrics\t\t: ") + metrics) + "\nX Ticks\t\t: ") + xTicks);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            if ((!(dataLabels) || !(metrics)) || !(xTicks) || !(chart)) {
                                flag = false;

                                error += xcounter1 + '\t' + xcounter2 + "\n";

//                                WebUI.takeScreenshot()
                            }
                        }
                        break;
                    case "Histogram":
                        System.out.println("Inside Histogram");
                        totalSize = SeleniumUtils.noOfXFields(driver);
                        for (int xcounter2 = 2; xcounter2 < totalSize; xcounter2++){
                            System.out.println("Histogram xcounter2 : "+xcounter2);
                            Select drpdown2 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                            drpdown2.selectByIndex(xcounter2);
                            driver.findElement(By.xpath("//input[@id='2intervalID']")).sendKeys("10000");
                            if (xcounter2 == 2){
                                driver.findElement(By.xpath("//input[@id='2mdcInputID']")).click();
                            }
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            System.out.println("Tick done");
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
//                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();

                            Select drpdownAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpdownAll.selectByVisibleText("All");
                            System.out.println("All done");
                            Thread.sleep(2000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');
                            chart = SeleniumUtils.validateChartFormation(driver);
                            System.out.println("Chart2 : "+chart);
                            if (chart) {
                                dataLabels = SeleniumUtils.validateDataLabels(driver);

                            }
                            xTicks = SeleniumUtils.validateXAxisLabels(driver);
                            System.out.println("Wait bro");
                            Thread.sleep(300000000);
                            metrics = SeleniumUtils.validateMetrics(driver);
//                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();


                            Thread.sleep(2000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                            System.out.println((((((("Chart Formation : " + chart) + "\nData Labels\t: ") + dataLabels) + "\nMetrics\t\t: ") + metrics) + "\nX Ticks\t\t: ") + xTicks);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            if ((!(dataLabels) || !(metrics)) || !(xTicks) || !(chart)) {
                                flag = false;

                                error += xcounter1 + '\t' + xcounter2 + "\n";

//                                    WebUI.takeScreenshot()
                            }

                        }
                        break;
                    case "Date Histogram":
                        String interval = "Weekly|Monthly|Yearly";

                        System.out.println("Inside Date Histogram..");
                        String[] intervals = interval.split("\\|");
                        Select drpdownDate = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                        drpdownDate.selectByVisibleText("Order Date");
                        for (int xcounter2 = 0; xcounter2 < intervals.length; xcounter2++){
                            Select drpdown3 = new Select(driver.findElement(By.xpath("//select[@id='2selectIntervalID']")));
                            drpdown3.selectByVisibleText(intervals[xcounter2]);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            Select drpdownAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpdownAll.selectByVisibleText("All");
                            Thread.sleep(2000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');
                            chart = SeleniumUtils.validateChartFormation(driver);
                            System.out.println("Chart3 : "+chart);
                            if (chart) {
                                dataLabels = SeleniumUtils.validateDataLabels(driver);

                            }

                            metrics = SeleniumUtils.validateMetrics(driver);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            Thread.sleep(1000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                            System.out.println((((((("Chart Formation : " + chart) + "\nData Labels\t: ") + dataLabels) + "\nMetrics\t\t: ") + metrics) + "\nX Ticks\t\t: ") + xTicks);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            if ((!(dataLabels) || !(metrics)) || !(chart)) {
                                flag = false;

                                error += xcounter1 + '\t' + xcounter2 + "\n";

//                                WebUI.takeScreenshot()
                            }

                        }
                        break;
                    case "Range":
                        totalSize = SeleniumUtils.noOfXFields(driver);
                        for (int xcounter2 = 2; xcounter2 < totalSize; xcounter2++){
                            Select drpdown2 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                            drpdown2.selectByIndex(xcounter2);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            Select drpdownAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpdownAll.selectByVisibleText("All");
                            Thread.sleep(2000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');
                            chart = SeleniumUtils.validateChartFormation(driver);
                            System.out.println("Chart5 : "+chart);
                            if (chart) {
                                dataLabels = SeleniumUtils.validateDataLabels(driver);

                            }

                            metrics = SeleniumUtils.validateMetrics(driver);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                            Thread.sleep(1000);
                            System.out.println(((xcounter1 + '\t') + xcounter2) + ':');

                            System.out.println((((((("Chart Formation : " + chart) + "\nData Labels\t: ") + dataLabels) + "\nMetrics\t\t: ") + metrics) + "\nX Ticks\t\t: ") + xTicks);
                            if ((!(dataLabels) || !(metrics)) || !(chart)) {
                                flag = false;

                                error += xcounter1 + '\t' + xcounter2 + "\n";

//                                WebUI.takeScreenshot()
                            }

                        }
                        break;



                }
            }
            System.out.println("Error: " + error);

            if (flag == true) {
                System.out.println("Vertical Bar 2 passed");
            } else {
                System.out.println("Vertical Bar 2 failed");
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
            record.setTestCaseName("SAN-VB-02");
            record.setOutcome(actualOutcome);
            record.setName("Vertical bar.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Vertical bar completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome && temp.equals("false")) {
                log.info("Vertical bar creation failed.");
                return "null";
            }
            else
                return name;
        }
    }
}
