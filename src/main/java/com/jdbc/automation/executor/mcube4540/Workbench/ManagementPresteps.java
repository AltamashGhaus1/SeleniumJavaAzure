package com.jdbc.automation.executor.mcube4540.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4540.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class ManagementPresteps {

    private static final Logger log= LoggerFactory.getLogger(ManagementPresteps.class);
    public static boolean managementPresteps(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Administration")));
            driver.findElement(By.linkText("Administration")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User Administration")));
            driver.findElement(By.linkText("User Administration")).click();

            Thread.sleep(3000);
            SeleniumUtils.switchToWindow(1, driver);
            Thread.sleep(2000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usr")));

            //SeleniumUtils.loginWB(driver, screenShot);

            Thread.sleep(6000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //String iden =  driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/div/div[2]")).getText().trim();

            System.out.println("Waiting for 30 secs for credential to be filled");
            Thread.sleep(30000);

            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Management")));
            //driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/div/div[2]")).click();
            List<WebElement> dms = driver.findElements(By.cssSelector("div[class='menupad-left']"));
            System.out.println("DMS size : "+dms.size());
            dms.get(1).click();
            System.out.println("Management is clicked");

            String iden =  dms.get(1).getText().trim();
            actualOutcome = iden.equals("Management");

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-WORKBENCH_PRESTEPS-01");
            record.setOutcome(actualOutcome);
            record.setName("Workbench Presteps.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Workbench Presteps completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Management Presteps failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
