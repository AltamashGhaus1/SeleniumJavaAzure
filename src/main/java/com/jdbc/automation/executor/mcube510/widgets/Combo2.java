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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class Combo2 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();
    public static String combo2(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        int n = 2;
        String name = "null";
        String temp="false";
        boolean dataLabels = true;
        boolean chart;
        boolean metrics;
        boolean xTicks;
        boolean flag = true;
//        String XAxis = "Range|Terms|Date Histogram|Histogram";
        String XAxis = "Histogram";
//        String XAxis = "Terms|Date Histogram|Histogram";
        String[] xaxis = XAxis.split("\\|");

        try{
            System.out.println("Inside Combo 2-----------");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
//            driver.findElement(By.linkText("Widget")).click();
//            driver.findElement(By.linkText("Widget")).click();
//            String widgetName = "Combo";
//            screenShot.add(com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.takeScreenShot(driver));
//            driver.findElement(By.linkText(widgetName)).click();
//            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
//            screenShot.add(com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.takeScreenShot(driver));
//            driver.findElement(By.linkText(dataset)).click();



            System.out.println("Customer name selected1");
            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
            System.out.println("Customer name selected2");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[3]")).click();
            System.out.println("Customer name selected3");
            driver.findElement(By.xpath("//button[@id='1metricExpandButtonID']")).click();
            System.out.println("Customer name selected4");
            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
            System.out.println("Customer name selected5");
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
            System.out.println("Customer name selected6");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
            driver.findElement(By.xpath("//button[@id='1metricExpandButtonID']")).click();
            System.out.println("Customer name selected7");
            for (int xcounter1 = 0; xcounter1 < xaxis.length; xcounter1++){
                Select drpCounter = new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
//                drpCounter.selectByIndex(xcounter1);
                drpCounter.selectByVisibleText(xaxis[xcounter1]);
                System.out.println("Bro xAxis : "+xaxis[xcounter1]+" and xcounter1 : "+xcounter1);
                Thread.sleep(5000);
                switch (xaxis[xcounter1]){
                    case "Terms":
                        System.out.println("Inside Terms ----------------------------------------------------------------------");
                        int totalSize = SeleniumUtils.noOfXFields(driver);
                        int stringSize = SeleniumUtils.noOfXStringFields(driver);
                        for (int xcounter2 = ((totalSize - stringSize) + 3); xcounter2 < totalSize; xcounter2++) {
                            Select drpCounter2 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID' or @id='2bucketSelectButtonID']")));
                            drpCounter2.selectByIndex(xcounter1);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Select drpAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpAll.selectByVisibleText("All");
                            Thread.sleep(5000);
                            boolean metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                            boolean ydata = SeleniumUtils.validateYData_combo(driver);
                            boolean xdata = SeleniumUtils.validateXData_combo(driver);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            System.out.println(((((((((xcounter1 + '\t') + xcounter2) + ':') + "\nMetric; before Custom Label\t: ") + metric) +
                                    "\nY Data\t\t\t\t: ") + ydata) + "\nX Data\t\t\t\t: ") + xdata);
                            System.out.println("COUNTER START TERMS---------------------------------");
                            System.out.println("xcounter1 :"+xcounter1);
                            System.out.println("xcounter2 :"+xcounter2);
                            System.out.println("metric | ydata | xdata : "+metric + " "+ydata+" "+xdata);
                            System.out.println("COUNTER END TERMS-----------------------------------");
                            if ((!(metric) || !(ydata)) || !(xdata)) {
                                flag = false;
                            }
                            //FORMAT SERIES
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                            driver.findElement(By.xpath("//input[@id='2stringInputID']")).sendKeys("asdfgh");
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                            driver.findElement(By.xpath("//input[@id='1stringInputID']")).sendKeys("asd");
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Thread.sleep(5000);
                            metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                            System.out.println("Metric; after Custom Label: " + metric);

                            if (!(metric)) {
                                flag = false;
                            }
                            //To chart
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            //END OF FORMAT SERIES
                            //CLEAR TEXT
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//input[@id='2stringInputID']")).clear();
                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();

                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//input[@id='1stringInputID']")).clear();
                            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                        }
                        break;
                    case "Histogram":
                        System.out.println("Inside Histogram");
                         totalSize = SeleniumUtils.noOfXFields(driver);
                        for (int xcounter2 = 2; xcounter2 < totalSize; xcounter2++) {
                            Select drpCounter1 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                            drpCounter1.selectByIndex(xcounter2);
                            driver.findElement(By.xpath("//input[@id='2intervalID']")).sendKeys("1000");
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            //to spy mode
                            Select drpAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpAll.selectByVisibleText("All");
                            Thread.sleep(5000);
                            boolean metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                            boolean ydata = SeleniumUtils.validateYData_combo(driver);
                            boolean xdata = SeleniumUtils.validateXData_combo(driver);
                            //to spy mode
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            System.out.println(((((((((xcounter1 + '\t') + xcounter2) + ':') + "\nMetric; before Custom Label\t: ") + metric) +
                                    "\nY Data\t\t\t\t: ") + ydata) + "\nX Data\t\t\t\t: ") + xdata);
                            System.out.println("COUNTER START HISTOGRAM---------------------------------");
                            System.out.println("xcounter1 :"+xcounter1);
                            System.out.println("xcounter2 :"+xcounter2);
                            System.out.println("metric | ydata | xdata : "+metric + " "+ydata+" "+xdata);
                            System.out.println("COUNTER END HISTOGRAM-----------------------------------");

                            if ((!(metric) || !(ydata)) || !(xdata)) {
                                flag = false;
                            }
                            //FORMAT SERIES

                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                            driver.findElement(By.xpath("//input[@id='2stringInputID']")).sendKeys("asdfgh");
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                            driver.findElement(By.xpath("//input[@id='1stringInputID']")).sendKeys("asd");
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Thread.sleep(5000);
                            metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                            System.out.println("Metric; after Custom Labell: " + metric);

                            if (!(metric)) {
                                flag = false;
                            }
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            //END OF FORMAT SERIES
                            //CLEAR TEXT
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//input[@id='2stringInputID']")).clear();
                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='//input[@id='1stringInputID']")).clear();
                            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            //END OF CLEAR TEXT
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                        }
                        break;
                    case "Date Histogram":
                        System.out.println("Inside Date Histogramm");
                        String interval = "Weekly|Monthly|Yearly";

                        String[] intervals = interval.split("\\|");
                        Select drpOrdDate = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                        drpOrdDate.selectByVisibleText("Order Date");

                        Select drpOrdDate1 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                        drpOrdDate1.selectByVisibleText("Order Date");
                        for (int xcounter2 = 0; xcounter2 < intervals.length; xcounter2++) {
                            Select drpInterval = new Select(driver.findElement(By.xpath("//select[@id='2selectIntervalID']")));
                            drpInterval.selectByVisibleText(intervals[xcounter2]);
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Select drpAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpAll.selectByVisibleText("All");
                            Thread.sleep(5000);
                            boolean metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                            boolean ydata = SeleniumUtils.validateYData_combo(driver);
                            Select drpAll1 = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            drpAll1.selectByVisibleText("All");
                            boolean xdata = SeleniumUtils.validateXData_combo(driver);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            System.out.println(((((((((xcounter1 + '\t') + xcounter2) + ':') + "\nMetric; before Custom Label\t: ") + metric) +
                                    "\nY Data\t\t\t\t: ") + ydata) + "\nX Data\t\t\t\t: ") + xdata);

                            if ((!(metric) || !(ydata)) || !(xdata)) {
                                flag = false;

//                                WebUI.takeScreenshot()
                            }
                            //FORMAT SERIES
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                            driver.findElement(By.xpath("//input[@id='2stringInputID']")).sendKeys("asdfgh");
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                            driver.findElement(By.xpath("//input[@id='1stringInputID']")).sendKeys("asd");
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                            Thread.sleep(5000);


                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Thread.sleep(5000);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Thread.sleep(5000);
                            metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                            System.out.println("Metric; after Custom Label: " + metric);
                            if (!(metric)) {
                                flag = false;

//                                WebUI.takeScreenshot()
                            }
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            //END OF FORMAT SERIES
                            //CLEAR TEXT
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
//                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                            driver.findElement(By.xpath("//input[@id='2stringInputID']")).clear();
                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();

                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//input[@id='1stringInputID']")).clear();
                            driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            //END OF CLEAR TEXT
                            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();

                        }
                        break;

                    case "Range":
                        try {
                            System.out.println("Inside Range");
                            Thread.sleep(5000);
                            System.out.println("Waiting for x fields count inside Range");
                            totalSize = SeleniumUtils.noOfXFields(driver);
                            System.out.println("Total Size : "+totalSize);
                            for (int xcounter2 = 2; xcounter2 < totalSize; xcounter2++){
                                Select drpInterval = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                                drpInterval.selectByIndex(xcounter2);
                                driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                System.out.println("Arror closed Y");
                                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                Thread.sleep(5000);
                                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                Select drpAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                                drpAll.selectByVisibleText("All");
                                Thread.sleep(5000);
                                boolean metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                                boolean ydata = SeleniumUtils.validateYData_combo(driver);
                                boolean xdata = SeleniumUtils.validateXData_combo(driver);
                                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                System.out.println(((((((((xcounter1 + '\t') + xcounter2) + ':') + "\nMetric; before Custom Label\t: ") + metric) +
                                        "\nY Data\t\t\t\t: ") + ydata) + "\nX Data\t\t\t\t: ") + xdata);

                                if ((!(metric) || !(ydata)) || !(xdata)) {
                                    flag = false;

    //                                WebUI.takeScreenshot()
                                }
                                //FORMAT SERIES
                                driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                                driver.findElement(By.xpath("//input[@id='2stringInputID']")).sendKeys("fgh");
                                driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                                driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                                driver.findElement(By.xpath("//input[@id='1stringInputID']")).sendKeys("asd");
                                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                Thread.sleep(5000);
                                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                Thread.sleep(5000);
                                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                Thread.sleep(5000);
                              metric = SeleniumUtils.validateMetrics_combo(driver, "Combo 2");
                                if (!(metric)) {
                                    flag = false;

    //                                WebUI.takeScreenshot()
                                }

                                //to chart
                                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                                //END OF FORMAT SERIES
                                //CLEAR TEXT
                                driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
    //                            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                                driver.findElement(By.xpath("//input[@id='2stringInputID']")).clear();
                                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();

                                driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                                driver.findElement(By.xpath("//input[@id='1stringInputID']")).clear();
                                driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                                //END OF CLEAR TEXT
                                driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();

                            }
                            break;
                        } catch (InterruptedException e) {
                            System.out.println("Range error : "+e);
                        }


                }
                if (flag == true) {
                   System.out.println("Combo Chart Test case 2 Passed");
                } else {
                    System.out.println("Combo Chart Test case 2 Failed");
                }
            }

            Random rand = new Random();
            name = "Mcube_ComboChart2_"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);
            System.out.println("temp : "+temp);
            Thread.sleep(2000);

        }
        catch (Exception e) {
            System.out.println("Error msg : "+e);
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
            record.setTestCaseName("SAN-COMBO-02");
            record.setOutcome(actualOutcome);
            record.setName("COMBO Chart.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Combo chart completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome && temp.equals("false")) {
                log.info("Combo chart creation failed.");
                return "null";
            }
            else
                return name;
        }
    }
}
