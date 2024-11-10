package com.jdbc.automation.executor.ipds.AdvanceAnalytics;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.ipds.Common.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArtificialIntelligence {

    static Records rec = new Records();

    private static final Logger log= LoggerFactory.getLogger(ArtificialIntelligence.class);
    public static void artificialIntelligence(WebDriver driver, WebDriverWait wait, List<Records> listOb) throws Exception {

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddd Do MMM yyyy hh:mm:ss");
            String workflow="test"+ now.format(formatter);
            //System.out.println(workflow);
            String jdbc_connection= "Greenplum-JDBC"+now.format(formatter);

            String gpfdist_connection= "Greenplum-GPFDIST"+now.format(formatter);

            //  SeleniumUtils.switchToWindow(0, driver);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Advanced AnalyticsglobalImgID")));
            driver.findElement(By.id("Advanced AnalyticsglobalImgID")).click();

            //driver.findElement(By.linkText("Advanced Analytics")).click();

            Thread.sleep(2000);

            SeleniumUtils.switchToWindow1("Workflows", driver);

            Thread.sleep(3000);

            SeleniumUtils.takeScreenShot(driver);

            List<WebElement> list= driver.findElement(By.cssSelector("div[class='col-sm-12']")).findElements(By.cssSelector("div[class='col-sm-8 icon-description']"));

            list.get(0).click();

            driver.findElement(By.cssSelector("input[id='workflow-name']")).sendKeys(workflow);

            Thread.sleep(2000);

            driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();

            Thread.sleep(4000);
            SeleniumUtils.takeScreenShot(driver);
            SeleniumUtils.clickMenuItems(driver,"Start editing");

            Thread.sleep(30000);

        /*driver.findElement(By.cssSelector("input[class='text-center form-control input-search-workflow ng-pristine ng-untouched ng-valid ng-empty']")).sendKeys("test27102022113751");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[class='ng-binding owned-by-current-user']")).click();
        Thread.sleep(2000);*/

            SeleniumUtils.dbConnection(driver,"Greenplum-JDBC",3,jdbc_connection,screenShot);

            Thread.sleep(5000);

            SeleniumUtils.addReadNode(driver,wait,jdbc_connection,screenShot);

            Thread.sleep(5000);
            SeleniumUtils.takeScreenShot(driver);

            SeleniumUtils.dbConnection(driver,"Greenplum-GPFDIST",4,gpfdist_connection,screenShot);

            Thread.sleep(5000);

            SeleniumUtils.addReadNode(driver,wait,gpfdist_connection,screenShot);

            SeleniumUtils.takeScreenShot(driver);
            Thread.sleep(5000);

            SeleniumUtils.validateSuccess(driver,wait,"status-icon completed");
            System.out.println("Validate node success: "+actualOutcome);

            Thread.sleep(2000);
            SeleniumUtils.takeScreenShot(driver);
        }
        catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            log.error("",e);
            throw new RuntimeException(e);
        }

        record.setTestCaseName("Advanced Analytics");
        record.setOutcome(actualOutcome);
        record.setName("Advanced Analytics");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Advanced Analytics completed successfully.");

        listOb.add(record);

        if(!actualOutcome)
        {
            System.out.println(actualOutcome);
            throw new Exception("Advanced Analytics fail");
        }
    }
}