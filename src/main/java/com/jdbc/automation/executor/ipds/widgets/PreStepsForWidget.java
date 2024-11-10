package com.jdbc.automation.executor.ipds.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.ipds.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;
import static java.lang.Thread.sleep;

public class PreStepsForWidget {
    private static final Logger log= LoggerFactory.getLogger(PreStepsForWidget.class);
    public static boolean presteps(WebDriver driver, WebDriverWait wait, String widgetName, List<Records> listOb, String dataset, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        // WebDriver driver = new ChromeDriver();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        //Widgets

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WidgetglobalImgID")));
            driver.findElement(By.id("WidgetglobalImgID")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("WidgetglobalImgID")).click();
            Thread.sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            sleep(2000);
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();
            sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bucketAddButtonID")));
            screenShot.add(SeleniumUtils.takeScreenShot(driver));


            //Records rec = SeleniumUtils.changeDate(driver,wait, record1);

            SeleniumUtils.changeDate(driver,wait, screenShot,"Widget");

            // screenShot.add(SeleniumUtils.takeScreenShot(driver));

            Thread.sleep(2000);
            try {
                String textMsg = driver.findElement(By.xpath("//*[@id=\"style-1\"]/div/div/h4")).getText();
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                System.out.println("textMsg---> : "+textMsg);
            } catch (Exception e) {
                log.error("",e);
            }

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            String iden =  driver.findElement(By.xpath("//*[@id=\"bucketAddButtonID\"]")).getText().trim();
            actualOutcome = iden.equals("Add metrics");

        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {

            widgetName = widgetName.toUpperCase().trim();
            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-" + widgetName + "-PRESTEPS-01");
            record.setOutcome(actualOutcome);
            record.setName(widgetName + " presteps.");
            record.setScreenShot(screenShot);
            record.setExpectedResult(widgetName + " presteps completed successfully.");
            clientVersionDao.setRecordDetails(record);
            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Presteps for widgets failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
