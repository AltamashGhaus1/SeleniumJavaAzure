package com.jdbc.automation.executor.Common;

import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
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

public class Landing {

    static Records rec = new Records();
    private static final Logger log = LoggerFactory.getLogger(Landing.class);

    public static boolean landing(WebDriver driver, WebDriverWait wait, List<Records> listOb, String username, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Boolean actualOutcome= false;

        Records record = new Records();
        List<File> screenShot = new ArrayList<>();

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Navbar.waitForPageLoad(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Applications']")));

//            driver.findElement(By.linkText("Business Intelligence")).click();

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            Thread.sleep(5000);


//Application present
            SeleniumUtils.validateapplication(driver,listOb, clientVersionDao, san_aut_id);
//All tiles

            Thread.sleep(2000);
            SeleniumUtils.validateBoldColor(driver,listOb, clientVersionDao, san_aut_id);
            SeleniumUtils.validateAllTiles(driver,listOb, clientVersionDao, san_aut_id);
            Thread.sleep(1000);
// All text present

            //AG TO LOOK TOOLTIP
//            SeleniumUtils.validateAllTextPresent(driver,listOb, clientVersionDao, san_aut_id);
            Thread.sleep(5000);
//------------
            Boolean isTileClicable = SeleniumUtils.validateTilesisClickable(driver,wait,username,listOb,clientVersionDao,san_aut_id);
            Thread.sleep(8000);
            System.out.println("validateTilesisClickable DONE isTileClicable : "+isTileClicable);
//------------
          SeleniumUtils.validatetilesisenabledAfterWS_Switch(driver,listOb, clientVersionDao, san_aut_id);

//            Thread.sleep(8000);
            System.out.println("validatedisablesTilesMessage DISABLED");
//            SeleniumUtils.validatedisablesTilesMessage(driver,wait,listOb, clientVersionDao, san_aut_id);

            System.out.println("------------------------------------------------Landing Page End------------------------------------------");
            actualOutcome = true;
        } catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
            //throw new RuntimeException(e);
        } finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("Landing Page");
            record.setOutcome(actualOutcome);
            record.setName("Landing Page");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Landing Page completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);
        }

        return  actualOutcome;
    }
}

