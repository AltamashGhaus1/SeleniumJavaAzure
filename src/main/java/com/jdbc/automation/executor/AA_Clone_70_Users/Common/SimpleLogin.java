package com.jdbc.automation.executor.AA_Clone_70_Users.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimpleLogin {

    public static Boolean login(WebDriver driver, String username, String password, String url)  throws Exception
    {
        System.out.println("Inside SIMPLE LOGIN");
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        driver.get(url);
        Thread.sleep(5000);

        try {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);

            System.out.println(username+". "+password+".");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();

            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            try {
                driver.findElement(By.id("casErrorDiv"));
                return actualOutcome=false;
            } catch (Exception e) {
                return actualOutcome=true;
            }

        } catch (Exception e) {
            return actualOutcome=false;
        }
       /* record1.setOutcome(actualOutcome);
        record1.setName("LOGIN");
        record1.setScreenShot(screenShot);
        record1.setExpectedResult("");*/
    }
}
