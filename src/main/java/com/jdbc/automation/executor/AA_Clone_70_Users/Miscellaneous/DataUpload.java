package com.jdbc.automation.executor.AA_Clone_70_Users.Miscellaneous;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
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

public class DataUpload {

    static Records rec = new Records();
    private static final Logger log= LoggerFactory.getLogger(DataUpload.class);
    public static boolean dataUpload(WebDriver driver, WebDriverWait wait, List<Records> listOb, String username, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        //Boolean actualOutcome= false;

        Records record = new Records();
        List<File> screenShot = new ArrayList<>();

        try {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Administration")));
            driver.findElement(By.linkText("Administration")).click();*/
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AdministrationglobalImgID")));
            driver.findElement(By.id("AdministrationglobalImgID")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Data Upload")));
            driver.findElement(By.linkText("Data Upload")).click();
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            String str = "sampledata" + now.format(formatter);
            Thread.sleep(3000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            WebElement chooseFile = driver.findElement(By.cssSelector("input[id='my-file-selector']"));

            Thread.sleep(5000);

            chooseFile.sendKeys("C:\\Selenium\\Test_SampleData.csv");
            //chooseFile.sendKeys("  D:\\Selenium_Sanity_TAGIC_4.3\\Test_SampleData.csv");

            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.cssSelector("button[ng-click='nextToMapping()']")).click();

            WebElement indexName = driver.findElement(By.cssSelector("input[id='indexName']"));
            Thread.sleep(2000);
            indexName.click();
            indexName.clear();
            Thread.sleep(1000);
            indexName.sendKeys(str);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(4000);
            driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();

            Thread.sleep(5000);

            SeleniumUtils.clickOkButton1(driver, wait,screenShot);
            // driver.findElement(By.cssSelector("button[class='ajs-button btn btn-danger']")).click();

            Thread.sleep(5000);

            str = username + "_" + str;
            System.out.println(str);
            Thread.sleep(1000);
            List<WebElement> divGrp = driver.findElements(By.cssSelector("div[class='form-group']"));

           /* divGrp.get(0).findElement(By.tagName("input")).click();
            divGrp.get(0).findElement(By.tagName("input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            divGrp.get(0).findElement(By.tagName("input")).sendKeys(Keys.chord(Keys.BACK_SPACE));
            divGrp.get(0).findElement(By.tagName("input")).sendKeys(str);*/

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-success']")));
            driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='index-pattern-name']")));

            String expResult = driver.findElement(By.cssSelector("div[class='index-pattern-name']")).findElement(By.tagName("h1")).getText().trim();
            System.out.println("Dataset name in Configure Dataset: " + expResult);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            DataUpload obj = new DataUpload();
            String className = obj.getClass().getCanonicalName();
            System.out.println("Class Name : " + className + ".");
            actualOutcome = SeleniumUtils.verifyResult(driver, str, expResult, rec, className);
            //--------------------------------------
            SeleniumUtils.clickLogo(driver, wait, str);
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
            //throw new RuntimeException(e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("DATA UPLOAD");
            record.setOutcome(actualOutcome);
            record.setName("Data Upload");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Data Upload completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);
            if (!actualOutcome) {
                //throw new Exception("Data Upload creation fail");
                System.out.println("Data Upload creation failed");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
