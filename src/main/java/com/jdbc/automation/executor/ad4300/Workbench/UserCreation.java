package com.jdbc.automation.executor.ad4300.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.ad4300.Common.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserCreation {

    private static final Logger log= LoggerFactory.getLogger(UserCreation.class);
    static Records rec = new Records();
    public static void userCreation(WebDriver driver, WebDriverWait wait, String role, List<Records> listOb) throws Exception {

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            System.out.println("Role received : "+role);

            Thread.sleep(3000);

            //User is clicked
            driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/ul/li[2]/a")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add User"))).click();

            String uName = "MCUBE"+ SeleniumUtils.randomStringGenerate();
            System.out.println("User Name : "+uName);

            driver.findElement(By.id("userName")).sendKeys(uName);
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[2]/input")).sendKeys("Altamash Ghaus");
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[3]/input")).sendKeys("altamash.ghaus@tcgdigital.com");
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[4]/input")).sendKeys("8697095670");
            driver.findElement(By.id("password")).sendKeys("Bhutan@123!");
            driver.findElement(By.id("confirmPassword")).sendKeys("Bhutan@123!");
            Thread.sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            List<String> listUserGroup = new ArrayList<>();
            listUserGroup.add("ipds_producer");
            listUserGroup.add("ipds_subproducer");
            listUserGroup.add("mcube_ipds");

            List<String> listRole = new ArrayList<>();
            listRole.add("Power User");
            listRole.add("Editor");
            listRole.add("Viewer");
            Thread.sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            int k=0, flag2=0;
            for(int i=8;i<11;i++) {

                System.out.println("K:"+k);
                new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div["+i+"]/div[2]/select"))).selectByVisibleText(listUserGroup.get(k));
                if ((role != null) && (flag2==0)) {
                    new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div["+i+"]/div[3]/select"))).selectByVisibleText(role);
                    flag2=1;
                } else {
                    new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div["+i+"]/div[3]/select"))).selectByVisibleText(listRole.get(k));
                }
                if(i!=10)
                {
                    driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div["+i+"]/div[4]/span/i")).click();
                    Thread.sleep(2000);
                }
                k=k+1;
                System.out.println("i:"+i);

            }

            Thread.sleep(2000);
            try {
                driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/button")).click();
                System.out.println("Save Button is clicked for User Creation");
            } catch (Exception e) {
                log.error("",e);
            }

            System.out.println("Waiting for 12 sec to click alert in User Creation");
            Thread.sleep(12000);
            //WebElement webEl = driver.findElement(By.className("ajs-button ajs-ok"));
            int flag = 0;
            try {                                                            //html/body/div[2]/div[2]/div/div[4]/div[2]/button
                WebElement webEl = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[4]/div[2]/button"));
                SeleniumUtils.clickModal(driver,webEl);
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
                String expResult = driver.findElement(By.xpath("//*[@id=\"userTable\"]/tbody/tr[2]/td[4]")).getText().trim();
                UserCreation obj = new UserCreation();
                String className = obj.getClass().getSimpleName();
                System.out.println("Class Name : "+className+".");
                actualOutcome = SeleniumUtils.verifyResult(driver,uName, expResult, rec,className);
                //--------------------------------------
            }

            driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/div/div[2]")).click();
            System.out.println("Management is clicked");
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        record.setTestCaseName("SAN-USER-01");
        record.setOutcome(actualOutcome);
        record.setName("User creation.");
        record.setScreenShot(screenShot);
        record.setExpectedResult("User Creation completed successfully.");

        listOb.add(record);

        if(!actualOutcome)
        {
            throw new Exception("User Creation failed.");
        }
    }
}
