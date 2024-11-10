package com.jdbc.automation.executor.ad4300.Dashboard;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.ad4300.Common.SeleniumUtils;
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
import java.util.Random;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

//import static Common.Records.screenShot;

public class Dashboard {

    private static final Logger log= LoggerFactory.getLogger(Dashboard.class);
    static Records rec = new Records();
    /*public Dashboard(String name, String outcome, String expectedResult, OutputStream screenshots) {
        super(name, outcome, expectedResult, screenshots);
    }*/

    public static boolean dashboard(WebDriver driver, WebDriverWait wait, List<String> widgetList, String savedSearch, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
            driver.findElement(By.linkText("Dashboard")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Dashboard")).click();

            SeleniumUtils.changeDate(driver,wait,screenShot);

            //Add is clicked
            driver.findElement(By.xpath("//*[@id=\"KTNdashboardAddPanelButtonLocalMenuID\"]")).click();

           for(int i=0;i<widgetList.size();i++) {

               if(!widgetList.get(i).equalsIgnoreCase("null"))
                   driver.findElement(By.cssSelector("div[class='input-group form-group finder-form col-md-7 findvisualization']")).findElement(By.cssSelector("input[id='SOFWidgetsID']")).sendKeys(widgetList.get(i));
               else
                   continue;
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("li[class='list-group-item list-group-menu-item']")).click();
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("div[class='input-group form-group finder-form col-md-7 findvisualization']")).findElement(By.cssSelector("input[id='SOFWidgetsID']")).click();
               // Keys.chord(Keys.BACK_SPACE);
                driver.findElement(By.cssSelector("div[class='input-group form-group finder-form col-md-7 findvisualization']")).findElement(By.cssSelector("input[id='SOFWidgetsID']")).clear();
            }

            Thread.sleep(2000);

            driver.findElement(By.cssSelector("a[title='Searches']")).click();

            driver.findElement(By.cssSelector("div[class='input-group form-group finder-form col-md-7 findvisualization']")).findElement(By.cssSelector("input[placeholder='Saved Searches Filter...']")).sendKeys(savedSearch);

            Thread.sleep(3000);

            driver.findElement(By.cssSelector("li[class='list-group-item list-group-menu-item']")).click();

            Thread.sleep(1000);

            driver.findElement(By.cssSelector("i[class='fa fa-arrow-up']")).click();

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //Save button
            Random rand = new Random();
            String name = "Mcube_Dashboard" + rand.nextInt(100000);

            driver.findElement(By.id("KTNdashboardSaveButtonLocalMenuID")).click();
            System.out.println("Save button is clicked");
            SeleniumUtils.saveByName(driver, name);

            Thread.sleep(2000);
            /*try {
                driver.switchTo().alert().accept();
            } catch (Exception e) {
                log.error("",e);
            }*/

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(2000);

            //------------------------------------
            String expResult = driver.findElement(By.cssSelector("div[class='dashboardname ']")).findElement(By.tagName("span")).getText().trim();
            System.out.println(expResult);
           // expResult = firstWord(expResult);//why?
            Dashboard obj = new Dashboard();
            String className = obj.getClass().getSimpleName();
            System.out.println("Class Name : "+className+".");
            actualOutcome = SeleniumUtils.verifyResult(driver, name, expResult, rec,className);
            //--------------------------------------

            SeleniumUtils.clickLogo(driver, wait, name);

            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            log.error("",e);
            actualOutcome = false;
        }
        finally{
            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-DASHBOARD-01");
            record.setOutcome(actualOutcome);
            record.setName("Dashboard.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Dashboard completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("Dashboard creation failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
