package com.jdbc.automation.executor.mcube4500.Miscellaneous;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4500.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
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

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class SavedObjects {

    private static final Logger log= LoggerFactory.getLogger(SavedObjects.class);
    static Records rec = new Records();

    public static boolean savedObjects(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Administration")));
            driver.findElement(By.linkText("Administration")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Saved Objects")));
            driver.findElement(By.linkText("Saved Objects")).click();

            Thread.sleep(10000);

            SeleniumUtils.afterStepsSavedObjects(driver, wait, "Dashboards");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            SeleniumUtils.afterStepsSavedObjects(driver, wait, "Searches");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            SeleniumUtils.afterStepsSavedObjects(driver, wait, "Widgets");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //------------------------------------
            //String expResult = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/dashboard-app/kbn-top-nav/div/div/div/div[1]/div[3]/ol/li")).getText().trim();
            SavedObjects obj = new SavedObjects();
            String className = obj.getClass().getCanonicalName();
            System.out.println("Class Name : "+className+".");
            actualOutcome = SeleniumUtils.verifyResult(driver, "Saved Object", "Saved Object", rec,className);
            //--------------------------------------

            SeleniumUtils.clickLogo(driver, wait,"Saved Objects");
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            WebElement webEl = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-danger']"));
            SeleniumUtils.clickModal(driver, webEl);
            Thread.sleep(6000);
            log.error("",e);
        }
        finally {

            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-SAVED_OBJECT-01");
            record.setOutcome(actualOutcome);
            record.setName("Saved object.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Saved object completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Saved Objects creation failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
