package com.jdbc.automation.executor.mcube4550.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
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

public class TreeTable1 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();

    public static String treeTable1(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        boolean flag= true;
        int n=2;

        String name = "null";
        String temp="false";
        String error="";
        try{
            System.out.println("Inside Tree table 1");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            driver.findElement(By.linkText("Widget")).click();
            driver.findElement(By.linkText("Widget")).click();
            String widgetName = "Tree Table";
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bucketAddButtonID")));
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
            Thread.sleep(2000);
            new Select(driver.findElement(By.xpath("//select[@id = '2bucketSelectButtonID']"))).selectByVisibleText("Terms");
            Thread.sleep(2000);
            new Select(driver.findElement(By.xpath("//select[@id = '2fieldSelectID']"))).selectByVisibleText("Region");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//i[@id = '2metricExpandButtonIID']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@id = '1metricExpandButtonID']")).click();


//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bucketAddButtonID")));
//            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
//
//            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
//
////            driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked kbn-timepicker-modes']/li[2]")).click();
//            Thread.sleep(3000);
////
////            screenShot.add(SeleniumUtils.takeScreenShot(driver));
////            Select drpDatasource = new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
////            Thread.sleep(3000);
////            drpDatasource.selectByIndex(5);
//
//
//
//
//
//
//
//            driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")).click();
//            driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")).click();
//
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//*[@id=\"2bucketSelectButtonID\"]/option[7]")).click();
//
////            Select drpDatafield = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
////            Thread.sleep(3000);
////            drpDatafield.selectByValue("Region");
//            driver.findElement(By.xpath("//select[@id='2fieldSelectID']")).click();
//
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]/optgroup[3]/option[13]")).click();
//
//            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
//            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();





            for (int ycounter1 = 1; ycounter1 < 6; ycounter1++){
                Select drpCounter = new Select(driver.findElement(By.xpath("//select[@id='1bucketSelectButtonID']")));
                drpCounter.selectByIndex(ycounter1);
                int y2 = SeleniumUtils.noOfYFields(driver);
                System.out.println("No of y fields y2 : "+y2);

                if ((ycounter1 == 4) || (ycounter1 == 5)) {
                     n = 3;
                }
                try {
                    for (int ycounter2 = n; ycounter2 < y2; ycounter2++){
                        try {
                            if(ycounter2==6)
                                continue;
                            System.out.println("YCounter2 : "+ycounter2);
                            Select drpCounter2 = new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']")));
                            drpCounter2.selectByIndex(ycounter2);
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
    //                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));

                            Thread.sleep(5000);
                            List<String> chartData =SeleniumUtils.collectChartData(driver);
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            Select page =  new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                            page.selectByVisibleText("All");
                            Thread.sleep(5000);
                            boolean data= SeleniumUtils.validateData(chartData, "Both",driver);
                            boolean metrics = SeleniumUtils.validateMetrics(driver);
                            System.out.println(((ycounter1 + '\t') + ycounter2) + ':');

                            System.out.println("Data: "+ data);

                            System.out.println("Metrics: " + metrics);

                            if (!(data) || !(metrics)) {
                                flag = false;
                                System.out.println("Error in Tree Table ->" );
                                error = ((((error + ycounter1) + '\t') + ycounter2) + '\n');
                                System.out.println("error : "+error);
                                break;
                            }
                            //i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']
                            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                        } catch (InterruptedException e) {
                            System.out.println("cathc error : "+e);
                        }

                    }
                } catch (Exception e) {
                    System.out.println("19th element not present : "+e);
                }

            }
            if (flag == true) {
                System.out.println("Tree table1 passed");
//                KeywordUtil.markPassed('Tree Table 1 Passed')
            } else {
//                KeywordUtil.markFailed('Tree Table 1 Failed')
                System.out.println("Tree table1 failed");
            }

            Random rand = new Random();
            name = "Mcube_TreeTable"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);

            Thread.sleep(2000);


        }
        catch (Exception e) {
            System.out.println("Inside Catch e : "+e);
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
