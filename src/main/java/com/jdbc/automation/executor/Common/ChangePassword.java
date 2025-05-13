package com.jdbc.automation.executor.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePassword {
    public static String changePassword(WebDriver driver, String appName, String oldPassword, String newPassword) {
        Boolean flag = false;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        System.out.println("Change Password for appName:"+appName);
        // Locate input fields
        WebElement currentPasswordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("current-Password")));
        WebElement newPasswordField = driver.findElement(By.id("new-Password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirm-Password"));

        // Locate buttons
        WebElement updateButton = driver.findElement(By.xpath("//div[@class='d-flex justify-content-between']/button[2]"));
        WebElement cancelButton = driver.findElement(By.xpath("//div[@class='d-flex justify-content-between']/button[1]"));

        // Test Case :  Update Validation
        System.out.println("Testing Update Button...");
        currentPasswordField.sendKeys(oldPassword);
        newPasswordField.sendKeys(newPassword);
        confirmPasswordField.sendKeys(newPassword);
        updateButton.click();

        // Validate Update success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("invalidMCubeSpan")));
        if (successMessage.getText().equals("Password changed successfully.")) {
            System.out.println("Update Validation Passed!");
            newPassword = newPassword;
        } else {
            System.out.println("Update Validation Failed!");
            return "";
        }

        return newPassword;
    }

    public static Boolean cancelValidation(WebDriver driver, String appName) {

        Boolean flag = false;

        try {
            System.out.println("Cancel button is clicked for :"+appName);
            Thread.sleep(2000);
            Navbar.waitForPageLoad(driver);
            //Cancel button
            driver.findElement(By.xpath("//button[@class='btn1']")).click();
            Navbar.waitForPageLoad(driver);

            Thread.sleep(2000);
            WebElement BI = driver.findElement(By.xpath("//a[@href='/nxtgen']"));
            if(BI.isDisplayed())
                System.out.println("Cancel Validation Passed for :"+appName);
            else
                System.out.println("Cancel Validation Failedfor :"+appName);
            Navbar.waitForPageLoad(driver);
            flag = true;
        } catch (Exception e) {
            System.out.println("Cancel Err msg : "+e);
            flag = false;
            return flag;
        }
        return flag;
    }
}
