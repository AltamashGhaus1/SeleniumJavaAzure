package com.jdbc.automation.executor.mcube4550.AdvanceAnalytics;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Advanced Analytics")));

            driver.findElement(By.linkText("Advanced Analytics")).click();

            Thread.sleep(2000);

            SeleniumUtils.switchToWindow1("Workflows", driver);

            Thread.sleep(3000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));


            //----------------------------------start
            //Template click
            driver.findElement(By.cssSelector("a[title='Performance Comparision']")).click();

//            List<WebElement> editingList = driver.findElement(By.cssSelector("div[class='pull-right workflow-navbar__top-menu-options']")).findElements(By.tagName("div"));
//            editingList.get(1).click();
//            System.out.println("Clone is clicked");

            SeleniumUtils.clickMenuItems(driver,"Clone");

            SeleniumUtils.takeScreenShot(driver);

            driver.findElement(By.cssSelector("div[class='modal-body ng-pristine ng-valid ng-valid-required']")).findElement(By.tagName("input")).clear();
            String var = "Copy of :Performance Comparision" + now.format(formatter);
            driver.findElement(By.cssSelector("div[class='modal-body ng-dirty ng-valid-parse ng-invalid ng-invalid-required']")).findElement(By.tagName("input")).sendKeys(var);

            driver.findElement(By.cssSelector("[ng-disabled='cloneForm.$invalid']")).click();
            System.out.println("Clone button is clicked");

            SeleniumUtils.clickMenuItems(driver,"Start editing");

            System.out.println("Waiting for Stop editing to be visible");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Stop editing")));

            SeleniumUtils.clickMenuItems(driver,"Run");

            Thread.sleep(5000);

            SeleniumUtils.takeScreenShot(driver);

            System.out.println("Run is clicked and Abort is present on screen.");
            System.out.println("Waiting for Run button to be visible again");

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run")));
            } catch (Exception e) {
                com.jdbc.automation.executor.mcube4500.Common.SeleniumUtils.takeScreenShot(driver);
                actualOutcome = false;
                log.error("",e);
            }

            boolean verifyAA = SeleniumUtils.verifyAAWorkflow2(driver);
            Thread.sleep(2000);
            System.out.println("Verify AA : "+verifyAA);

//---------------------------------------end
            actualOutcome = verifyAA;
            System.out.println("Validate Clone AA Sanity Success: "+actualOutcome);

            Thread.sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
