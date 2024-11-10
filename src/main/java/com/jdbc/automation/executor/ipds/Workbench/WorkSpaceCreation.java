package com.jdbc.automation.executor.ipds.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.ipds.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class WorkSpaceCreation {

    private static final Logger log=LoggerFactory.getLogger(WorkSpaceCreation.class);
    static Records rec = new Records();
    public static boolean workSpaceCreation(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            Thread.sleep(3000);

            driver.findElement(By.linkText("User Groups")).click();
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New")));
            try {
                driver.findElement(By.xpath("//*[@id=\"main\"]/ng-view/div[3]/div[2]/button")).click();
            } catch (Exception e) {
                driver.findElement(By.linkText("Add New")).click();
                log.error("",e);
            }

            Thread.sleep(3000);
            Random rand = new Random();
            int randomNo = rand.nextInt(100000);
            String workspaceName = "Mcube_Workspace" + randomNo;//*[@id="tabs1"]/div/div/div[1]/div[1]/input
            System.out.println("Workspace Name : " + workspaceName);

            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[1]/div[1]/input")).sendKeys(workspaceName);

            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[2]/div/textarea")).sendKeys("Workspace in process to get created");
            new Select(driver.findElement(By.name("dotAccount"))).selectByIndex(1);

            Thread.sleep(8000);
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[2]/div/textarea")).click();

            List<WebElement> chkBox = driver.findElements(By.className("checkmark"));
            //List<WebElement> chkBox = driver.findElement(By.cssSelector("div[class=\"assign-dashboard\"]")).findElement(By.cssSelector("label[class=\"custom-check\"]")).findElements(By.tagName("span"));
            //List<WebElement> chkBox = driver.findElements(By.xpath("//*[@id=\"tabs1\"]/div/div/div[4]/div[2]/label/span"));

        /*driver.switchTo().defaultContent();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click;", driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[4]/div[2]/label/span")));
*/
        /*Actions actions = new Actions(driver);
        WebElement webEl = driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[4]/div[2]/label/span"));
        actions.moveToElement(webEl).click().build().perform();
*/

            System.out.println("chkBox size : " + chkBox.size());
            chkBox.get(1).click(); //Give access to all dashboard uncheck
            System.out.println("Give access to all dashboard uncheck");

            chkBox = driver.findElements(By.className("checkmark"));
            System.out.println("Check Box size after 1st click : "+chkBox.size());

            for (int i = 5; i < (chkBox.size() - 2); i++) {
                chkBox.get(i).click();
            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            Thread.sleep(2000);
            try {
                driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[5]/button[2]")).click();
                System.out.println(workspaceName + " Workspace creation save is clicked");
            } catch (Exception e) {
                log.error("",e);
            }

            System.out.println("Waiting for 12 sec to click alert in Workspace Creation");
            Thread.sleep(12000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            int flag=0;
            try {
                WebElement webEl = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[4]/div[2]/button"));
                SeleniumUtils.clickModal(driver, webEl);
                flag=1;
            } catch (Exception e) {
                //driver.switchTo().alert().accept();
                Keys.chord(Keys.ENTER);
                log.error("",e);
            }

            Thread.sleep(4000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            if(flag==1)
            {
                //------------------------------------
                /*String expResult = driver.findElement(By.xpath("//*[@id=\"main\"]/ng-view/div[6]/table/tbody/tr[2]/td[2]")).getText().trim();
                WorkSpaceCreation obj = new WorkSpaceCreation();
                String className = obj.getClass().getCanonicalName();
                System.out.println("Class Name : "+className+".");
                actualOutcome = SeleniumUtils.verifyResult(driver,workspaceName, expResult, rec,className);*/
                //--------------------------------------
                List<WebElement> userNameList = driver.findElement(By.cssSelector("table[class='table table-striped']")).findElements(By.cssSelector("tr[class='ng-scope']"));
                List<WebElement> unList = userNameList.get(0).findElements(By.tagName("td"));
                String expResult = unList.get(1).getText().trim();
                System.out.println("expResult : "+expResult);

                WorkSpaceCreation obj = new WorkSpaceCreation();
                String className = obj.getClass().getCanonicalName();
                System.out.println("Class Name : "+className+".");
                actualOutcome = SeleniumUtils.verifyResult(driver,workspaceName, expResult, rec,className);
                //--------------------------------------
            }

            driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/div/div[2]")).click();
            System.out.println("Management is clicked");
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            log.error("",e);
            //throw new RuntimeException(e);
        }
        finally {
            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-WORKSPACE-01");
            record.setOutcome(actualOutcome);
            record.setName("Workspace Creation.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Workspace creation completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Workspace Creation failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
