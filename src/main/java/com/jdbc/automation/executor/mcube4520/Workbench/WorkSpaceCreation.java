package com.jdbc.automation.executor.mcube4520.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4520.Common.SeleniumUtils;
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
            List<WebElement> listMang = driver.findElement(By.cssSelector("ul[class='sidemenusub']")).findElements(By.tagName("li"));
            listMang.get(3).findElement(By.tagName("a")).click();
            System.out.println("Workspace is clicked");
            Thread.sleep(5000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New")));
            try {
                driver.findElement(By.cssSelector("div[class='action-point ng-scope']")).findElement(By.cssSelector("div[class='save-all']")).findElement(By.tagName("button")).click();

            } catch (Exception e) {
                driver.findElement(By.linkText("Add New")).click();
                log.error("",e);
            }

            Thread.sleep(3000);
            Random rand = new Random();
            int randomNo = rand.nextInt(100000);
            String workspaceName = "Mcube_Workspace" + randomNo;//*[@id="tabs1"]/div/div/div[1]/div[1]/input
            System.out.println("Workspace Name : " + workspaceName);


            driver.findElement(By.cssSelector("input[class='ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']")).sendKeys(workspaceName);
            Thread.sleep(3000);
            new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[1]/div[1]/div[2]/select"))).selectByVisibleText(".nxtgen");
            //new Select(driver.findElement(By.className("ng-pristine ng-valid ng-empty ng-touched"))).selectByIndex(5);
            //new Select(driver.findElement(By.cssSelector("select[class='ng-pristine ng-valid ng-empty ng-touched']"))).selectByVisibleText(".nextgen");
            System.out.println("Clcicked");
            Thread.sleep(10000);

            List<WebElement> selAll = driver.findElement(By.cssSelector("div[class='multiselect-box']")).findElements(By.tagName("input"));
            selAll.get(0).click();
            List<WebElement> chekBoxDataset = driver.findElement(By.cssSelector("div[class='search-index search-index1']")).findElements(By.tagName("div"));

            for(int i=0;i<5;i++) {
                chekBoxDataset.get(i).findElement(By.tagName("input")).click();
            }
            driver.findElement(By.cssSelector("span[class='save-index  save-all']")).findElement(By.tagName("button")).click();
            System.out.println("Save Pool is clicked");
            Thread.sleep(3000);

            int flag=0;
            try {
                WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button ajs-ok']"));
                SeleniumUtils.clickModal(driver, webEl);
                flag=1;
            } catch (Exception e) {
                //driver.switchTo().alert().accept();
                Keys.chord(Keys.ENTER);
                log.error("",e);
            }

           List<WebElement> addWS = driver.findElement(By.cssSelector("div[class='save-all butn-fixed']")).findElements(By.tagName("button"));
           addWS.get(1).click();
           Thread.sleep(2000);

            try {
                WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button ajs-ok']"));
                SeleniumUtils.clickModal(driver, webEl);
                flag=1;
            } catch (Exception e) {
                //driver.switchTo().alert().accept();
                Keys.chord(Keys.ENTER);
                log.error("",e);
            }

            System.out.println("Waiting for 12 sec to click alert in Workspace Creation");
            Thread.sleep(12000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            try {
                List<WebElement> webElList = driver.findElements(By.cssSelector("button[class='ajs-button ajs-ok']"));
                WebElement webEl = webElList.get(1);
                SeleniumUtils.clickModal(driver, webEl);
                flag=1;
            } catch (Exception e) {
                //driver.switchTo().alert().accept();
                Keys.chord(Keys.ENTER);
                log.error("",e);
            }

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            if(flag==1)
            {
                //------------------------------------
                //String expResult = driver.findElement(By.xpath("//*[@id=\"main\"]/ng-view/div[6]/table/tbody/tr[2]/td[2]")).getText().trim();
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
            System.out.println("Workspace Creation is completed");
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
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
