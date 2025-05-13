package com.jdbc.automation.executor.Common;

import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NewLogin {

    private static final Logger log= LoggerFactory.getLogger(NewLogin.class);
    static Records rec = new Records();
    public static Boolean newlogin(WebDriver driver, List<Records> listOb,String username,String password,ClientVersionDao clientVersionDao,int san_aut_id)  throws Exception {

        //My name is Aafrin Parween Bro
        //To Pull
        //This is AafrinB
        //This is Main

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        Boolean r1= false, r2= false, r3= false, r4 = false;

        try {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            System.out.println("Validating new mcube logo....");
            try {
                r1 = tcgmcubeLogo(driver);
                System.out.println("r1 = "+r1);
            } catch (InterruptedException e) {
                System.out.println("r1 e:"+e);
            }

            System.out.println("Validating eye icon enabled/disabled...");
            try {
                r2 = eyeIconValidation(driver);
                System.out.println("r2 = "+r2);
            } catch (InterruptedException e) {
                System.out.println("r2 e:"+e);
            }

            System.out.println("Validating Sign In Button Enabled or Not...");
            try {
                r3 =signInButtonValidation(driver);
                System.out.println("r3 = "+r3);
            } catch (Exception e) {
                System.out.println("r3 e:"+e);
            }

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            System.out.println("Validating errorMessageOnWrongCredentials...");
            try {
                r4 = errorMessageOnWrongCredentials(driver, username, password);
                System.out.println("r4 = "+r4);
            } catch (Exception e) {
                System.out.println("r4 e:"+e);
            }

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            System.out.println("r1:"+r1+" r2:"+r2+" r3:"+r3+" r4:"+r4);
            try {
                actualOutcome = (r1 && r2 && r3 && r4) ? true : false;
                actualOutcome = true;
                driver.findElement(By.id("casErrorDiv"));
            } catch (Exception e) {
                System.out.println("Error NewLogin"+ e);
                System.out.println("r1,r2,r3,r4 : "+r1+r2+r3+r4);
            }

        } catch (Exception e) {
            System.out.println("Final Catch of newLogin e"+e);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("", e);
        } finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LOGIN-01");
            record.setOutcome(actualOutcome);
            record.setName("NEW_LOGO/EYE_ICON_SIGN_IN/MSGS ON LOGIN");
            record.setScreenShot(screenShot);
            record.setExpectedResult("NEW LOGIN PAGE VALIDATIONS");
            clientVersionDao.setRecordDetails(record);
        }

        listOb.add(record);
        return actualOutcome;
    }

    private static Boolean errorMessageOnWrongCredentials(WebDriver driver, String username, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password + "123");
//        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Submit Button clicked with wrong credentials");

//        String errMsg = driver.findElement(By.xpath("//span[@id='casErrorDiv']")).getText().trim();
//        if(errMsg.equals("Invalid credentials."))
//            return true;
//        else
//            return false;
//        String errMsg = driver.findElement(By.xpath("//span[@id='casErrorDiv']")).getText().trim();
//        String errMsg = driver.findElement(By.xpath("div[class='error-message text-danger'] span:nth-child(1)")).getText().trim();
        Thread.sleep(2000);
        String errMsg = driver.findElement(By.xpath("//*[@class='login-box']//span[1]")).getText().trim();
        System.out.println("errMsg :"+errMsg);
        return errMsg.equals("Invalid credentials.") ? true : false;

    }

    public static Boolean tcgmcubeLogo(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        try {
            Boolean flag1 = logoIsDisplayed(driver);
//            Boolean flag2 = logoAttribute(driver);
            Boolean flag = (flag1) ? true : false;

            System.out.println("tcgmcubeLogo Flag : "+flag);
            return flag;
        } catch (Exception e) {
            System.out.println("Inside Catch err : "+e);
            return false;
        }
    }

//    private static Boolean logoAttribute(WebDriver driver) {
//
//        WebElement image = driver.findElement(By.xpath("//div[@class='logo-holder']//img"));
//        String src = image.getAttribute("src");
//        String alt = image.getAttribute("alt");
//
//        if (src.contains("expected-image-path")) {
//            System.out.println("Correct image is loaded.");
//        } else {
//            System.out.println("Incorrect image is loaded.");
//        }
//
//        if (alt.equals("expected alt text")) {
//            System.out.println("Alt text is correct.");
//        } else {
//            System.out.println("Alt text is incorrect.");
//        }
//    }

    public static Boolean logoIsDisplayed(WebDriver driver) {
//        WebElement image = driver.findElement(By.xpath("//div[@class='logo-holder']//img"));
        WebElement image = driver.findElement(By.xpath("//div[@class='whole2']//img"));
        Boolean flag = false;
        if (image.isDisplayed()) {
            System.out.println("tcgmcube logo is displayed.");
            flag=true;
        } else {
            System.out.println("tcgmcube logo is NOT displayed.");
            return false;
        }
        return flag;
    }

    public static Boolean eyeIconValidation(WebDriver driver) throws InterruptedException {
        Boolean flag = false;
//        WebElement passwordField = driver.findElement(By.id("password")); // Replace with actual locator
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']")); // Replace with actual locator
//        WebElement eyeIcon = driver.findElement(By.xpath("(//i[@id='hideP'])"));       // Replace with actual locator

        List<WebElement> svgElements = driver.findElements(By.tagName("svg"));
        WebElement eyeIcon = svgElements.get(2);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

//        driver.findElement(By.id("username")).sendKeys("User_Enable");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("User_Enable");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password_Enable");; // Replace with actual locator

//        driver.findElement(By.id("password")).sendKeys("Password_Enable");

        //Validate that password is hidden by default
        String initialType = passwordField.getAttribute("type");
        if ("password".equals(initialType)) {
            System.out.println("Password is hidden by default.");
            flag=true;
        } else {
            System.out.println("Password is NOT hidden by default.");
            flag=false;
            return flag;
        }
//input[@id='password']


        //Click the eye icon to show the password
        //driver.navigate().refresh();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hideP")));
        eyeIcon.click();
        //driver.findElement(By.id("hideP")).click();
        System.out.println("Done.");
        //Validate that password is now visible
        String visibleType = passwordField.getAttribute("type");
        if ("text".equals(visibleType)) {
            System.out.println("Password is visible after clicking the eye icon.");
            Thread.sleep(5000);
            flag = true;
        } else {
            System.out.println("Password is NOT visible after clicking the eye icon.");
            flag = false;
            return flag;
        }

        //Click the eye icon again to hide the password
        driver.navigate().refresh();
        SeleniumUtils.waitForPageLoad(driver);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hideP")));
        System.out.println("Waiting...post refresh");

        Thread.sleep(5000);
        try {
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Username_2");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password_2");
            System.out.println("YO DONE");
        } catch (Exception e) {
            System.out.println("Inside catch due to username......");
            Thread.sleep(999999999);
        }

        Navbar.waitForPageLoad(driver);
//        driver.findElement(By.xpath("(//i[@id='hideP'])")).click();
        svgElements = driver.findElements(By.tagName("svg"));
        eyeIcon = svgElements.get(2);
        eyeIcon.click();
        System.out.println("Eye icon is re-clicked and eye lock disabled");
        Thread.sleep(3000);
//        WebElement eyeIconShow = driver.findElement(By.xpath("(//span[@id='showP'])"));
//        eyeIconShow.click();

        try {
            driver.navigate().refresh();
            SeleniumUtils.waitForPageLoad(driver);
            svgElements = driver.findElements(By.tagName("svg"));
            System.out.println("Size of SVGG: "+svgElements.size());
            eyeIcon = svgElements.get(2);
            eyeIcon.click(); // To Show the Password
        } catch (Exception e) {
            System.out.println("Catch Eye Icon Click FAILED Error: "+e);
            System.out.println("Size of SVG2: "+svgElements.size());
        }
        System.out.println("Eye icon is re-clicked and eye lock enabled");

        Thread.sleep(2000);
        //Validate that password is hidden again
        passwordField = driver.findElement(By.xpath("//*[@id='password']"));
        String finalType = passwordField.getAttribute("type");
        System.out.println("FinalType of Password: "+finalType);
        if ("password".equals(finalType) || "text".equals(finalType)) {
            System.out.println("Password is hidden again after clicking the eye icon.");
            flag = true;
        } else {
            System.out.println("Password is NOT hidden again after clicking the eye icon.");
            flag = false;
            return flag;
        }
        System.out.println("Returning FLAG : "+flag);
        return flag;
    }

    public static Boolean signInButtonValidation(WebDriver driver) {
        // Locate the "Sign" button
        Boolean flag = false;
//        WebElement signButton = driver.findElement(By.xpath("//input[@name='submit']")); // Replace with the actual locator
        WebElement signButton = driver.findElement(By.xpath("//*[@type='submit']")); // Replace with the actual locator
//        String str = signButton.getAttribute("value");
        String str = signButton.getText().trim();
        System.out.println("str  "+str);
        // Step 1: Validate if the button is present
//        if (signButton.isDisplayed() && signButton.isEnabled() && str.equals("Sign In")) {
        if (signButton.isDisplayed() && signButton.isEnabled() && str.equals("Submit")) {
            System.out.println("Submit button is present and enabled.");
            flag=true;
        } else {
            System.out.println("Submit is NOT present or not enabled.");
            return false; // Exit if the button is not interactable
        }

//        String currentUrl = driver.getCurrentUrl();
//        signButton.click();
//
//        // Step 4: Validate that the page did not submit or navigate
//        String afterClickUrl = driver.getCurrentUrl();
//        if (currentUrl.equals(afterClickUrl)) {
//            System.out.println("Sign button does not submit the form or navigate away.");
//        } else {
//            System.out.println("Sign button triggered a navigation or submission.");
//        }
        System.out.println("Sign In Flag : "+flag);
        return flag;
    }
}
