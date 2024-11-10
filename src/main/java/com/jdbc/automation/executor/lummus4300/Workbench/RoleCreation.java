package com.jdbc.automation.executor.lummus4300.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.lummus4300.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class RoleCreation {

    private static final Logger log= LoggerFactory.getLogger(RoleCreation.class);
    static Records rec = new Records();

    public static String roleCreation(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        String roleName = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");


            driver.findElement(By.linkText("Roles")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Power User"))).click();
            Thread.sleep(2000);
            try {
                driver.findElement(By.cssSelector("i[class='fa fa-plus-square-o ng-scope']")).click();
            } catch (Exception e) {
                //driver.findElement(By.className("fa fa-plus-square-o")).click();
                log.error("",e);
            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(2000);

            try {
                driver.findElement(By.cssSelector("input[id='role-name']")).click();
            } catch (Exception e) {
                driver.findElement(By.xpath("//*[@id=\"role-name\"]")).click();
                log.error("",e);
            }

            roleName = "Mcube_Role" + now.format(formatter);

            try {
                driver.findElement(By.cssSelector("input[id='role-name']")).sendKeys(roleName);
            } catch (Exception e) {
                driver.findElement(By.xpath("//*[@id=\"role-name\"]")).sendKeys(roleName);
                log.error("",e);
            }

            //List<WebElement> list = driver.findElement(By.cssSelector("tr[class=\"ng-scope\"]")).findElement(By.cssSelector("td[class=\"td-checkbox-custom-width define-icons \"]")).findElements(By.cssSelector("i[class=\"fa fa-check-square-o\"]"));
            List<WebElement> list = driver.findElements(By.cssSelector("tr[ng-repeat=\"pageAccess in pageAccesses track by $index\"]"));
            List<WebElement> liChk = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                liChk.add(list.get(i).findElement(By.cssSelector("td[class=\"td-checkbox-custom-width define-icons \"]")));
            }
            List<WebElement> chkpts = new ArrayList<>();
            for (int i = 0; i < liChk.size(); i++) {
                chkpts.add(liChk.get(i).findElement(By.cssSelector("i[class=\"fa fa-check-square-o\"]")));
            }

            System.out.println("CheckBox SizeE: " + chkpts.size());
            chkpts.get(3).click();
            chkpts.get(4).click();

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //Save is clicked
            driver.findElement(By.cssSelector("div[class='save-all']")).findElement(By.tagName("button")).click();

            System.out.println("Waiting for 6 sec to click alert in Role Creation");
            Thread.sleep(6000);
            //WebElement webEl = driver.findElement(By.className("ajs-button ajs-ok"));
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            int flag = 0;
            try {
                WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button ajs-ok']"));
                SeleniumUtils.clickModal(driver, webEl);
                flag = 1;

            } catch (Exception e) {
                //driver.switchTo().alert().accept();
                Keys.chord(Keys.ENTER);
                log.error("",e);
            }

            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            if (flag == 1) {
                //------------------------------------
                String expResult = "";
                if (SeleniumUtils.isRoleCreated(driver, wait, roleName)) {
                    expResult = roleName;
                    System.out.println("Expected Result : "+expResult);
                    WebElement webEl = driver.findElement(By.cssSelector("div[class='col-sm-offset-4 col-sm-5 workbench-title']"));
                    SeleniumUtils.scrollByVisibleElement(driver,webEl);
                    Thread.sleep(4000);
                    screenShot.add(SeleniumUtils.takeScreenShot(driver));
                }

                RoleCreation obj = new RoleCreation();
                String className = obj.getClass().getCanonicalName();
                System.out.println("Class Name : " + className + ".");
                actualOutcome = SeleniumUtils.verifyResult(driver, roleName, expResult, rec, className);
                //--------------------------------------
            }

            List<WebElement> iden =  driver.findElements(By.cssSelector("div[class='menupad-left']"));
            iden.get(1).click();
            System.out.println("Management is clicked");
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {

            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-ROLE-01");
            record.setOutcome(actualOutcome);
            record.setName("Role creation.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Role creation completed successfully.");
            clientVersionDao.setRecordDetails(record);
            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Role creation failed.");
                return roleName;
            }
        }
        return roleName;
    }
}
