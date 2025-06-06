package com.jdbc.automation.executor.maxfed4200.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.maxfed4200.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class UserCreation {

    private static final Logger log= LoggerFactory.getLogger(UserCreation.class);
    static Records rec = new Records();
    public static boolean userCreation(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            //System.out.println("Role received : "+role);

            Thread.sleep(3000);

           /* List<WebElement> dms = driver.findElements(By.cssSelector("div[class='menupad-left']"));
            System.out.println("DMS size : "+dms.size());
            dms.get(1).click();
            System.out.println("Management is clicked inside User Creation");*/

            Thread.sleep(3000);
            List<WebElement> listMang = driver.findElement(By.cssSelector("ul[class='sidemenusub']")).findElements(By.tagName("li"));
            listMang.get(2).findElement(By.tagName("a")).click();
            System.out.println("Users is clicked");

            Thread.sleep(4000);
            //User is clicked
           /* driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/ul/li[2]/a")).click();
            Thread.sleep(2000);*/
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add User"))).click();

            String uName = "MCUBE"+ SeleniumUtils.randomStringGenerate();
            System.out.println("User Name : "+uName);

            List<WebElement> listUser = driver.findElements(By.cssSelector("div[class='form-elements']"));
            listUser.get(0).findElement(By.tagName("input")).sendKeys(uName);
            listUser.get(1).findElement(By.tagName("input")).sendKeys("Altamash Ghaus");
            driver.findElement(By.cssSelector("input[ng-model='emailId']")).sendKeys("altamash.ghaus@tcgdigital.com");
            listUser.get(2).findElement(By.tagName("input")).sendKeys("8697095670");

            driver.findElement(By.id("password")).sendKeys("Mcube@123!");
            driver.findElement(By.id("confirmPassword")).sendKeys("Mcube@123!");


            /*driver.findElement(By.id("userName")).sendKeys(uName);
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[2]/input")).sendKeys("Altamash Ghaus");
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[3]/input")).sendKeys("altamash.ghaus@tcgdigital.com");
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[4]/input")).sendKeys("8697095670");
            driver.findElement(By.id("password")).sendKeys("Bhutan@123!");
            driver.findElement(By.id("confirmPassword")).sendKeys("Bhutan@123!");
            */

            if(System.getenv("URL").equals("https://mcubeqa4510.tcgdigital.com/nxtgen")) {
                List<WebElement> listAdmin = driver.findElements(By.cssSelector("div[class='ng-scope']"));
                listAdmin.get(3).findElement(By.cssSelector("label[class='custom-check ']")).findElement(By.tagName("span")).click();

                Thread.sleep(2000);
                List<WebElement> adminList = driver.findElement(By.cssSelector("div[class='change-admin']")).findElements(By.cssSelector("label[class='custom-check ']"));
                adminList.get(0).findElement(By.tagName("span")).click();
                adminList.get(1).findElement(By.tagName("span")).click();
                adminList.get(2).findElement(By.tagName("span")).click();

                screenShot.add(SeleniumUtils.takeScreenShot(driver));
            } //System.getenv("URL").equals("https://mcubeinqa451.tcgdigital.com/nxtgen")

            List<String> listUserGroup = new ArrayList<>();
            listUserGroup.add("Default_group");
            /*listUserGroup.add("ipds_subproducer");
            listUserGroup.add("mcube_ipds");*/

            List<String> listRole = new ArrayList<>();
            listRole.add("Power User");
            listRole.add("Editor");
            listRole.add("Viewer");
            listRole.add("Viewer");
            Thread.sleep(2000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            /*List<WebElement> workspaceRole =driver.findElements(By.cssSelector("select[class='ng-pristine ng-valid ng-empty ng-touched']"));
            new Select(workspaceRole.get(0)).selectByVisibleText("Default_group");
            new Select((workspaceRole.get(1))).selectByVisibleText("Power User");

            driver.findElement(By.cssSelector("i[class='fa fa-plus']")).click();

            new Select(workspaceRole.get(0)).selectByVisibleText("Default_group");
            new Select((workspaceRole.get(1))).selectByVisibleText("Power User");*/

            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL : "+currentUrl+".");
            int k=0, flag2=0;
            try {
                for(int i=1;i<3;i++) {
                    new Select(driver.findElement(By.xpath("(//select[@ng-model='selectedUserGroups[$index]'])["+i+"]"))).selectByIndex(i);
                    Thread.sleep(2000);
                    new Select(driver.findElement(By.xpath("(//select[@ng-model='selectedRoles[$index]'])["+i+"]"))).selectByIndex(i);

                    if(i!=2)
                    driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
                }
                /*if(currentUrl.contains("https://mcubeqa4500.tcgdigital.com")) {
                    for (int i = 7; i < 11; i++) {

                        System.out.println("K:" + k);                                    //*[@id="tabs1"]/div[6]/div/form/div/div[8]/div[2]/select
                        if (i == 7) {                                               //*[@id="tabs1"]/div[6]/div/form/div/div[7]/div[2]/select
                            new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[2]/select"))).selectByVisibleText(listUserGroup.get(k));
                        } else {
                            new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[2]/select"))).selectByIndex(k);
                        }
                        if ((role != null) && (flag2 == 0)) {
                            new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[3]/select"))).selectByVisibleText(role);
                            flag2 = 1;
                        } else {
                            new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[3]/select"))).selectByVisibleText(listRole.get(k));
                        }
                        if (i != 10) {
                            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[4]/span/i")).click();
                            Thread.sleep(2000);
                        }
                        k = k + 1;
                        System.out.println("i:" + i);

                    }
                } else if (currentUrl.contains("https://mcubeinqa452.tcgdigital.com")) {
                    {//*[@id="tabs1"]/div[6]/div/form/div/div[10]/div[2]/select
                        for (int i = 8; i < 11; i++) {

                            System.out.println("K:" + k);                                    //*[@id="tabs1"]/div[6]/div/form/div/div[8]/div[2]/select
                            if (i == 8) {                                               //*[@id="tabs1"]/div[6]/div/form/div/div[7]/div[2]/select
                                new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[2]/select"))).selectByVisibleText(listUserGroup.get(k));
                            } else {
                                System.out.println("i="+i+" and k="+k);
                                if(k==2)
                                    k=k+1;
                                Thread.sleep(2000); //*[@id="tabs1"]/div[6]/div/form/div/div[10]/div[3]/select
                                new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[2]/select"))).selectByIndex(k);
                            }
                            if ((role != null) && (flag2 == 0)) {
                                new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[3]/select"))).selectByVisibleText(role);
                                flag2 = 1;
                            } else {
                                new Select(driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[3]/select"))).selectByVisibleText(listRole.get(k));
                            }
                            if (i != 10) {
                                driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/div/div[" + i + "]/div[4]/span/i")).click();
                                Thread.sleep(2000);
                            }
                            k = k + 1;
                            System.out.println("i:" + i);

                        }
                    }
                }*/
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Thread.sleep(4000);
            try {
                WebElement element = driver.findElement(By.cssSelector("div[class='box-inner']")).findElement(By.cssSelector("button[class='round-button']"));
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", element);
                System.out.println("Save Button is clicked for User Creation");
            } catch (Exception e) {
                Robot robot = new Robot();
                for(int i=0;i<11;i++)
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyPress(KeyEvent.VK_ENTER);
                driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div[6]/div/form/button")).click();
                System.out.println("Clicked using ROBOT class");
                log.error("",e);
            }

            System.out.println("Waiting for 12 sec to click alert in User Creation");
            Thread.sleep(12000);
            //WebElement webEl = driver.findElement(By.className("ajs-button ajs-ok"));
            int flag = 0;
            try {                                                            //html/body/div[2]/div[2]/div/div[4]/div[2]/button
                //WebElement webEl = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[4]/div[2]/button"));
                WebElement webEl = driver.findElement(By.cssSelector("div[class='ajs-primary ajs-buttons']")).findElement(By.tagName("button"));
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
                List<WebElement> userNameList = driver.findElement(By.cssSelector("table[class='table table-striped']")).findElements(By.cssSelector("tr[class='ng-scope']"));
                List<WebElement> unList = userNameList.get(0).findElements(By.tagName("td"));
                String expResult = unList.get(2).getText().trim();
                System.out.println("expResult : "+expResult);
                //String expResult = driver.findElement(By.xpath("//*[@id=\"userTable\"]/tbody/tr[2]/td[4]")).getText().trim();
                UserCreation obj = new UserCreation();
                String className = obj.getClass().getSimpleName();
                System.out.println("Class Name : "+className+".");
                actualOutcome = SeleniumUtils.verifyResult(driver,uName, expResult, rec,className);
                //--------------------------------------
            }

            List<WebElement> dms = driver.findElements(By.cssSelector("div[class='menupad-left']"));
            System.out.println("DMS size : "+dms.size());
            dms.get(1).click();
            System.out.println("Management is clickedn");
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-USER-01");
            record.setOutcome(actualOutcome);
            record.setName("User creation.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("User creation completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome) {
                System.out.println("User Creation failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }
}
