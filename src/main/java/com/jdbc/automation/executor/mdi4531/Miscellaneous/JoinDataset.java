package com.jdbc.automation.executor.mdi4531.Miscellaneous;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mdi4531.Common.SeleniumUtils;
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

public class JoinDataset {

    static Records rec = new Records();

    private static final Logger log= LoggerFactory.getLogger(JoinDataset.class);

    public static String joinDataset(WebDriver driver, WebDriverWait wait, List<Records> listOb,String dataset) throws Exception {

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        String name = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Administration")));
            driver.findElement(By.linkText("Administration")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Join Datasets")));
            driver.findElement(By.linkText("Join Datasets")).click();

            SeleniumUtils.selectIndices(driver,wait,dataset);
            //Dataset is clicked
            //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/kbn-management-app/div/div/div/div[1]/div[2]/div[1]/div/div/div/ul/li[8]/a")).click();
            Thread.sleep(2000);

            //Checkbox is clicked
           /* List<WebElement> checkBox = driver.findElements(By.className("control__indicator"));
            checkBox.get(0).click();*/


            driver.findElement(By.id("alltext")).sendKeys("Select @");

            SeleniumUtils.query(driver, wait);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.className("btn-success")).click();
            System.out.println("Waiting for 14 seconds for JD Alert");
            Thread.sleep(14000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //*[@id="kibana-body"]/div[39]/div[2]/div/div[4]/div[2]/button
            WebElement webElem = null;                              //html/body/div[2]/div[2]/div/div[4]/div[2]/button
                                                                    //*[@id=\"kibana-body\"]/div[2]/div[2]/div/div[4]/div[2]/button
            try {                                                   //*[@id=\"kibana-body\"]/div[2]/div[2]/div/div[4]/div[2]/button
                //webElem = driver.findElement(By.xpath("/html/body/div[83]/div[2]/div/div[4]/div[2]/button"));
                webElem = driver.findElement(By.cssSelector("button[class=\"ajs-button btn btn-danger\"]"));
            } catch (Exception e) { //*[@id="kibana-body"]/div[83]/div[2]/div/div[4]/div[2]/button
                 webElem = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[83]/div[2]/div/div[4]/div[2]/button"));
                log.error("",e);
            }

            SeleniumUtils.clickModal(driver, webElem);

        /*for(int i=0;i<5;i++)
        {
            System.out.println("Inside alert accept i:"+i);
            try {
                driver.switchTo().alert();
                driver.findElement(By.linkText("OK")).click();
            } catch (Exception e) {
                System.out.println("Inside CATCH : ");
                driver.findElement(By.id("alltext")).click();
                 log.error("",e);
            }
        }*/
        /*String statusJD = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[396]/div[2]/div/div[3]/div")).getText();
        System.out.println("Status of Join Dataset : "+statusJD);
        driver.findElement(By.className("ajs-button btn btn-danger")).click();*/

            //driver.switchTo().alert().accept();

            //SeleniumUtils.waitForAlert(driver);


            name = "Mcube_JoinDataset" + now.format(formatter);
            driver.findElement(By.id("indexName")).sendKeys(name);
            Thread.sleep(5000);
            //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/kbn-management-app/div/div/div/div[1]/div[6]/div[2]/div/div/dataset-name-validate/div/div/div/div[2]/button/span[1]")).click();
            driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
            System.out.println("Join Dataset : " + name + " is created");

            Thread.sleep(15000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[4]/div[2]/button[2]")));

            WebElement webElem2 = null;
            try {
                List<WebElement> ok = driver.findElements(By.cssSelector("button[class='ajs-button btn btn-danger']"));
                webElem2=ok.get(1);
            } catch (Exception e) {
                // webElem2 = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[40]/div[2]/div/div[4]/div[2]/button[2]"));
                log.error("",e);
            }
            SeleniumUtils.clickModal(driver, webElem2);

            Thread.sleep(5000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //------------------------------------
           // String expResult = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/div/kbn-management-index-header/div/h1")).getText().trim();
            String expResult = driver.findElement(By.cssSelector("div[class='index-pattern-name']")).findElement(By.tagName("h1")).getText().trim();
            System.out.println("Dataset name: "+expResult);
            JoinDataset obj = new JoinDataset();
            String className = obj.getClass().getCanonicalName();
            System.out.println("Class Name : " + className + ".");
            actualOutcome = SeleniumUtils.verifyResult(driver, name, expResult, rec, className);
            //--------------------------------------

            SeleniumUtils.clickLogo(driver, wait, name);
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }

        record.setTestCaseName("SAN-JOIN_DATA_SET-01");
        record.setOutcome(actualOutcome);
        record.setName("Join dataset.");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Join dataset completed successfully.");

        listOb.add(record);

        if(!actualOutcome)
        {
            throw new Exception("Login failed.");
        }

        return name;

    }
}
