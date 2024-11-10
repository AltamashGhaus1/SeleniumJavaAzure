package com.jdbc.automation.executor.Common;

import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewLogin {

    private static final Logger log= LoggerFactory.getLogger(NewLogin.class);
    static Records rec = new Records();
    public static Boolean newlogin(WebDriver driver, List<Records> listOb,String username,String password,ClientVersionDao clientVersionDao,int san_aut_id)  throws Exception {

        //My name is Aafrin Parween Bro
        //To Pull
        //This is AafrinB
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password + "123");

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();
            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            try {
                driver.findElement(By.id("casErrorDiv"));
                actualOutcome = true;
            } catch (Exception e) {
                actualOutcome = false;
                log.error("", e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
        } finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LOGIN-01");
            record.setOutcome(actualOutcome);
            record.setName("INVALID LOGIN");
            record.setScreenShot(screenShot);
            record.setExpectedResult("INVALID LOGIN MESSAGE APPEARS");
            clientVersionDao.setRecordDetails(record);
        }

        listOb.add(record);
        return actualOutcome;
    }
}
