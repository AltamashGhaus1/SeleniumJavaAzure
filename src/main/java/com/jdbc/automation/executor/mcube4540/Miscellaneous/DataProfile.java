package com.jdbc.automation.executor.mcube4540.Miscellaneous;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4540.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class DataProfile {

    static Records rec = new Records();
    private static final Logger log= LoggerFactory.getLogger(DataProfile.class);
    public static boolean dataProfile(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        String profile = null;

        try {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            String db = "mcube";
            String dataset = "access_master";
            profile = "dataProfile" + now.format(formatter);
            Boolean clickAdd = false;
            Boolean profileCreated=false;

            driver.findElement(By.linkText("Administration")).click();
            Thread.sleep(1000);

            driver.findElement(By.linkText("Data Profile")).click();
            Thread.sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            SeleniumUtils.clickDb(driver, wait, db, dataset);
            Thread.sleep(3000);

            clickAdd = (SeleniumUtils.clickAddNew(driver, wait));

            if (clickAdd == false) {
                driver.findElement(By.cssSelector("td[class='align-left']")).click();
                clickAdd = true;
            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys(profile);

            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            SeleniumUtils.clickOkButton(driver, wait);

            /* List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-primary']"));
               list.get(1).click();
               Thread.sleep(1000);*/

            SeleniumUtils.clickData(driver, wait);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.cssSelector("button[ng-click='submitButtonFunction()']")).click();

            for(int i=0;i<3;i++) {

                Thread.sleep(10000);
                driver.findElement(By.cssSelector("button[class='fa fa-refresh no-bkc-btn1 font12']")).click();
            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.cssSelector("i[class=' fa fa-chevron-left']")).click();

            Thread.sleep(5000);

            /* profileCreated=SeleniumUtils.validateProfile(driver, wait,profile);
            if(profileCreated.equals(true)) {
                System.out.println("Data Profile created");
                expResult="true";
            }*/

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //------------------------------------
            String expResult = SeleniumUtils.validateProfile(driver, wait,profile);
            DataProfile obj = new DataProfile();
            String className = obj.getClass().getCanonicalName();
            System.out.println("Class Name : "+className+".");
            actualOutcome = SeleniumUtils.verifyResult(driver, profile, expResult, rec,className);
            //--------------------------------------

            SeleniumUtils.clickLogo(driver, wait, profile);
            System.out.println("------------------------------------------------------------------------------------------");

        }
        catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            log.error("",e);
            throw new RuntimeException(e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("DATA PROFILE");
            record.setOutcome(actualOutcome);
            record.setName("Data Profile");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Data Profile completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Data Profile creation failed");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
