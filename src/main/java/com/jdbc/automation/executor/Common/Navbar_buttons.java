package com.jdbc.automation.executor.Common;

import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Navbar.waitForPageLoad;
import static com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.*;

public class Navbar_buttons {
    public static boolean chkWorkspace(WebDriver driver,String appname)throws Exception {
        System.out.println("Inside chkWorkspace appname : "+appname);
        String workspacename = "";
        String wrkspacename1 = "";
        boolean chkWrkSpace = true;
        Boolean flag = false;
        System.out.println("Inside chkWorkspace for : "+appname);

        try {
            if (appname.equals("Landing")) {
                driver.findElement(By.xpath("//*[@xmlns='http://www.w3.org/2000/svg'][1]")).click();
                Thread.sleep(2000);
                workspacename = driver.findElement(By.xpath("//a[@class='dropdown-item hover-color']/span[2]")).getText();
                chkWrkSpace = chkWrkspace(driver, workspacename);
                System.out.println("chkWrkSpace----" + workspacename + " " + chkWrkSpace);
                if (chkWrkSpace) {
                    System.out.println("Switch workspace :  Pass");
                    driver.findElement(By.xpath("//a[@class='dropdown-item hover-color']/span[2]")).click();
                } else {
                    System.out.println("Switch workspace :  Fail");
                }

                Thread.sleep(2000);
            }
            else if(appname.equals("BI")){
                wrkspacename1 = driver.findElement(By.xpath("//a[@tooltip='Default_group']")).getText();
                chkWrkSpace = chkWrkspace(driver, wrkspacename1);
                System.out.println("Inside BI if blovk");
                if(chkWrkSpace){
                    System.out.println("Workspace matched- Pass");

                }
                else {
                    System.out.println("Workspace matched- Fail");
                }

            } else if (appname.equals("AI")) {
//                wrkspacename1 = driver.findElement(By.xpath("//div[@class='ant-flex css-63xcpf ant-flex-align-center']/div[2]")).getText();
                wrkspacename1 = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]")).getText();
                chkWrkSpace = chkWrkspace(driver, wrkspacename1);
                if(chkWrkSpace){
                    System.out.println("Workspace matched- Pass");
                }
                else {
                    System.out.println("Workspace matched- Fail");
                }
            }
            else if (appname.equals("ezeXtend")) {
                wrkspacename1 = driver.findElement(By.xpath("//div[@class='groupname-link workspace-right-space']")).getText();
                chkWrkSpace = chkWrkspace(driver, wrkspacename1);
                if(chkWrkSpace){
                    System.out.println("Workspace matched- Pass");
                }
                else {
                    System.out.println("Workspace matched- Fail");
                }

            }
            else if (appname.equals("Workbench")) {
                wrkspacename1 = driver.findElement(By.xpath("//span[@class='workspace-text-gap ng-binding ng-scope']")).getText();
                chkWrkSpace = chkWrkspace(driver, wrkspacename1);
                if(chkWrkSpace){
                    System.out.println("Workspace matched- Pass");

                }
                else {
                    System.out.println("Workspace matched- Fail");
                }

            }
            flag = true;
        } catch (Exception e) {
            flag = false;
            e.toString();
            e.getMessage();
        }
        return flag;
    }
    public static boolean chkhelp(WebDriver driver,String appname)throws Exception{
        boolean flag = false;
        System.out.println("Inside chkhelp for : "+appname);
        try{
            if(appname.equals("Landing")){
                System.out.println("help started");
                driver.findElement(By.xpath("//li[@class='nav-item dropdown']/span")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//span[@class='help-icon-styled']")).click();

                System.out.println("help ended");
            }
            else if(appname.equals("BI")){
                System.out.println("BI help started");
                driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();

                System.out.println("BI help ended");

            }
            else if(appname.equals("AI")){
                System.out.println("AI help started");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[3]/div")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[3]/div")).click();

                System.out.println("AI help ended");

            }
            else if(appname.equals("ezeXtend")){
                System.out.println("ezextend help started");
                driver.findElement(By.xpath("//div[@class=' css-1jxwmua'][1]")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//div[@class=' css-1jxwmua'][1]")).click();

                System.out.println("ezextend help ended");

            }
            else if(appname.equals("Workbench")){
                System.out.println("workbench help started");
                driver.findElement(By.xpath("//span[@class='help-icon-styled']")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//div[@ng-controller='wbnavbar']/div[1]")).click();

                System.out.println("workbench help ended");

            }
            flag = true;
        }
        catch (Exception e) {
            flag = false;
            e.toString();
            e.getMessage();
        }
        return flag;
    }

    public static boolean chkProfile(WebDriver driver,String username, String appname, String oldPassword, String newPassword, String wantToChangePassword)throws Exception{
        String chngePasswrd = "";
        String userName = "";
        String userMail = "";
        boolean chkChngePasswrd=true;
        boolean flag = false;
        System.out.println("Inside chkProfile for : "+appname);

        try{
            System.out.println("Profile check started for : "+appname);

            if(appname.equals("Landing")){
                System.out.println("Profile started for:"+appname);

                //----------------
                Navbar.profileButtons(driver, appname);

                Thread.sleep(2000);
                chngePasswrd = driver.findElement(By.xpath("//li[@class='dropdown-item hover-color']")).getAttribute("innerHTML");
                chkChngePasswrd = chkChngePasswrd(driver, chngePasswrd);
                System.out.println("Change Password----" + chngePasswrd + " " + chkChngePasswrd);
                Thread.sleep(2000);
                if (chkChngePasswrd) {
                    driver.findElement(By.xpath("//li[@class='dropdown-item hover-color']")).click();
                    newPassword = ChangePassword.changePassword(driver,appname,oldPassword,newPassword);
                    System.out.println("Inside Navbar_Buttons Returned password : "+newPassword+" from "+appname);
                }
                Thread.sleep(2000);
                //Code for only password and only username login

                Navbar.loginPostPasswordChange(driver,username,newPassword);

                Navbar.profileButtons(driver,appname);
                driver.findElement(By.xpath("//li[@class='dropdown-item hover-color']")).click();

                ChangePassword.cancelValidation(driver, appname);

                Thread.sleep(3000);
                Navbar.profileButtons(driver,appname);
                //---------------
//                driver.findElement(By.xpath("//span[@class='nav-link admin-toggle cursr-pt']")).click();

                userName = driver.findElement(By.xpath("//span[@class='mat-mdc-tooltip-trigger admin-name']")).getText();
                if (chkUserName(driver, userName, username)) {
                    System.out.println("Verified userName---" + userName);

                }

                userMail = driver.findElement(By.xpath("//span[@class='mat-mdc-tooltip-trigger admin-email']")).getText();
                if (chkUserMail(driver, userMail)) {
                    System.out.println("userEmail--- " + userMail);
                }

                System.out.println("profile ended fore :"+appname);
            }
            else if(appname.equals("BI")){
                System.out.println("profile started for BI");

                waitForPageLoad(driver);
                Navbar.profileButtons(driver, appname);

                Thread.sleep(2000);
                chngePasswrd = driver.findElement(By.xpath("//li[@class='custom-class-change-password']/a/span[2]")).getText();
                chkChngePasswrd = chkChngePasswrd(driver, chngePasswrd);
                System.out.println("BI: Change Password----" + chngePasswrd + " " + chkChngePasswrd);
                Thread.sleep(2000);
                if (chkChngePasswrd) {
                    driver.findElement(By.xpath("//span[@class='custom-class-change-password-icon']")).click();
                    System.out.println("chkChngePasswrd is true for :"+appname);
                }
                Thread.sleep(2000);
//            driver.findElement(By.xpath("//span[@class='arrow-icon']")).click();

                driver.findElement(By.xpath("//button[@class='btn1']")).click();
                System.out.println("Cancel button is clicked");

                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/nav[1]/div[3]/ul/li[4]")).click();
                System.out.println("User profile dropdown clicked");

                userName = driver.findElement(By.xpath("//div[@class='user-name']/span")).getText();
                if (chkUserName(driver, userName, username)) {
                    System.out.println("BI: Verified userName---" + userName);

                }

                userMail = driver.findElement(By.xpath("//div[@class='user-mailid']/span")).getText();
                if (chkUserMail(driver, userMail)) {
                    System.out.println("BI: userEmail---" + userMail);
                }
                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/nav[1]/div[3]/ul/li[4]")).click();
                System.out.println("User profile dropdown closed");

                System.out.println("profile ended");
            }
            else if(appname.equals("AI")){

                System.out.println("Profile started for AI");
                waitForPageLoad(driver);

               Navbar.profileButtons(driver,appname);

                Thread.sleep(2000);
//                chngePasswrd = driver.findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'][2]/span/div/span")).getText();
                chngePasswrd = driver.findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'][2]/span/div/span")).getText();
                chkChngePasswrd = chkChngePasswrd(driver, chngePasswrd);
                System.out.println("AI: Change Password----" + chngePasswrd + " " + chkChngePasswrd);
                Thread.sleep(2000);
                if (chkChngePasswrd) {
                    driver.findElement(By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'][2]/span/div/span")).click();
                    System.out.println("chkChngePasswrd is true for :"+appname);
                }
                Thread.sleep(2000);
//            driver.findElement(By.xpath("//span[@class='arrow-icon']")).click();

                driver.findElement(By.xpath("//button[@class='btn1']")).click();
                System.out.println("Cancel Button of Change Password field inside User Profile AI is clicked");

//                driver.findElement(By.xpath("//div[@class='ant-flex css-63xcpf']/div")).click();
                driver.findElement(By.xpath("//div[@class='ant-dropdown-trigger']")).click();
                Thread.sleep(2000);

                userName = driver.findElement(By.xpath("//div[@class='user-name']")).getText();

                if (chkUserName(driver, userName, username)) {
                    System.out.println("AI: Verified userName---" + userName);

                }
                else {
                    System.out.println("AI: Verified userName-- FAIL");
                }

                userMail = driver.findElement(By.xpath("//div[@class='user-mailid']")).getText();

                if (chkUserMail(driver, userMail)) {
                    System.out.println("AI: userEmail---" + userMail);
                }
                else{
                    System.out.println("AI: userEmail---FAIL");
                }

//                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/nav[1]/div[3]/ul/li[4]")).click();
                driver.findElement(By.xpath("//div[@class='ant-dropdown-trigger ant-dropdown-open]")).click();
                System.out.println("AI User profile dropdown closed");

                System.out.println("profile ended");
            }
            else if(appname.equals("ezeXtend")){
                System.out.println("profile started for ezeXtend");
                waitForPageLoad(driver);
                Navbar.profileButtons(driver,appname);

                Thread.sleep(2000);
                chngePasswrd = driver.findElement(By.xpath("//button[@class='mantine-UnstyledButton-root mantine-Button-root header-sublist profile-button user-button mantine-1fss9k4']/div/span[2]")).getText();
                chkChngePasswrd = chkChngePasswrd(driver, chngePasswrd);
                System.out.println("ezextend: Change Password----" + chngePasswrd + "-" + chkChngePasswrd);
                Thread.sleep(2000);
                if (chkChngePasswrd) {
                    driver.findElement(By.xpath("//button[@class='mantine-UnstyledButton-root mantine-Button-root header-sublist profile-button user-button mantine-1fss9k4']/div/span[2]")).click();
                    System.out.println("chkChngePasswrd is true for :"+appname);
                }
                Thread.sleep(2000);
//            driver.findElement(By.xpath("//span[@class='arrow-icon']")).click();

                driver.findElement(By.xpath("//button[@class='btn1']")).click();

                driver.findElement(By.xpath("//div[@class=' css-1jxwmua'][2]")).click();
                Thread.sleep(2000);


                userName = driver.findElement(By.xpath("//div[@class='user-name']")).getText();


                if (chkUserName(driver, userName, username)) {
                    System.out.println("ezextend: Verified userName---" + userName);

                }
                else {
                    System.out.println("ezextend: Verified userName-- FAIL");
                }

                userMail = driver.findElement(By.xpath("//div[@class='user-mailid']")).getText();

                if (chkUserMail(driver, userMail)) {
                    System.out.println("ezextend: userEmail---" + userMail);
                }
                else{
                    System.out.println("ezextend: userEmail---FAIL");
                }


                System.out.println("profile ended");
            }

            else if(appname.equals("Workbench")){
                System.out.println("profile started for : "+appname);
                waitForPageLoad(driver);
//                Thread.sleep(2000);

                Navbar.profileButtons(driver,appname);
                Thread.sleep(2000);
                chngePasswrd = driver.findElement(By.xpath("//span[@class='dropdown-item']/span[2]")).getText();
                chkChngePasswrd = chkChngePasswrd(driver, chngePasswrd);
                System.out.println("Workbench: Change Password----" + chngePasswrd + " " + chkChngePasswrd);
                Thread.sleep(2000);
                if (chkChngePasswrd && wantToChangePassword.equalsIgnoreCase("Yes")) {
                    driver.findElement(By.xpath("//span[@class='dropdown-item']/span[2]")).click();
                //To change password anywhere
                    newPassword = ChangePassword.changePassword(driver,appname,newPassword,oldPassword);
                    System.out.println("Inside Navbar_Buttons Returned password : "+newPassword+" from "+appname);
                    Navbar.loginPostPasswordChange(driver,username,newPassword);
                    waitForPageLoad(driver);
                }
                Thread.sleep(2000);
//            driver.findElement(By.xpath("//span[@class='arrow-icon']")).click();

                driver.findElement(By.xpath("//button[@class='btn1']")).click();

                driver.findElement(By.xpath("//span[@class='icon-universal']//*[name()='svg']")).click();


                userName = driver.findElement(By.xpath("//div[@class='user-name']/div/span")).getText();
                if (chkUserName(driver, userName, username)) {
                    System.out.println("Workbench: Verified userName---" + userName);

                }
                Thread.sleep(2000);

                userMail = driver.findElement(By.xpath("//div[@class='user-mailid ng-scope']/div/span")).getText();
                if (chkUserMail(driver, userMail)) {
                    System.out.println("Workbench: userEmail---" + userMail);
                }

                driver.findElement(By.xpath("//div[@ng-controller='wbnavbar']/div[1]")).click();

                System.out.println("profile ended for : "+appname);
            }
            flag = true;
        }
        catch (Exception e) {
            System.out.println("Inside catch profile check ended for: "+appname);
            flag = false;
            e.toString();
            e.getMessage();
        }
        System.out.println("profile check ended for : "+appname);
        return flag;
    }

    public static boolean chkThreeDots(WebDriver driver,String appname, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id){
        String first = "";
        String second = "";
        System.out.println("Inside chkThreeDots for appname : "+appname);
        List<File> screenShot = new ArrayList<>();
        Records record = new Records();
        Boolean r1,r2,r3,r4 = false;
        Boolean actualOutcome = false;

        try{
            if (appname.equals("AI")){

                try {
                    Navbar.waitForPageLoad(driver);
                    Thread.sleep(3000);
//                    driver.findElement(By.xpath("//div[@class='ant-flex css-63xcpf ant-flex-align-center']/div[5]")).click();
                    try {
                        driver.findElement(By.xpath("(//div[@class='ant-dropdown-trigger'])")).click();
                    } catch (Exception e) {
                        driver.findElement(By.xpath("(//div[@class='ant-dropdown-trigger'])[2]")).click();
                        System.out.println("Error for three elipson in AI: "+e);
                    }
                    System.out.println("Three Dropdown Elipson is clicked inside AI Bavbar_Buttons");
                    Thread.sleep(2000);
                    System.out.println("opened");


                    first= driver.findElement(By.xpath("//span[normalize-space()='Sessions']")).getText();
                    System.out.println("Session validation---"+first);
                    if (first.equals("Sessions")){
                        System.out.println("Session validation---PASS");
                        driver.findElement(By.xpath("//span[normalize-space()='Sessions']")).click();
                        Thread.sleep(2000);
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                        driver.findElement(By.xpath("//div[@class='sc-ixGGxD caaPGn link']")).click();
                        driver.findElement(By.xpath("//div[@id='root']/div[2]/div/div")).click();
                        System.out.println("First Session is Clicked");
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));
                        r1  = true;
                    }
                    else {
                        System.out.println("Session validation---Fail");
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));
                        r1 = false;
                    }
                    Thread.sleep(2000);
//                    driver.findElement(By.xpath("//div[@class='ant-flex css-63xcpf ant-flex-align-center']/div[5]")).click();
                    driver.findElement(By.xpath("(//div[@class='ant-dropdown-trigger'])[2]")).click();
                    Thread.sleep(2000);

//                second= driver.findElement(By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light css-63xcpf']/li[2]/span")).getText();
                    second = driver.findElement(By.xpath("//span[normalize-space()='Workflow']")).getText();
                    System.out.println("Workflow validation--->"+second);
                    if(second.equals("Workflow")){
                        System.out.println("Workflow validation---PASS");
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));
                        r2 = true;
                    }
                   else {
                        System.out.println("Workflow validation---FAIL");
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));
                        r2 = false;
                    }
                    Thread.sleep(2000);
                    //to open three dots
                    //driver.findElement(By.xpath("//div[@class='ant-flex css-63xcpf ant-flex-align-center']/div[5]")).click();
                    //Thread.sleep(3000);

                    r3 = darkTheme(driver, listOb, clientVersionDao, san_aut_id);
                    //To open Three dots again for light theme
                    driver.findElement(By.xpath("//div[@id='root']//div[5]//*[name()='svg']")).click();
                    System.out.println("Three dots clicked again for light theme");
                    r4 = lightTheme(driver,listOb,clientVersionDao,san_aut_id);
                    System.out.println("AI r1 :"+r1);
                    System.out.println("AI r2 :"+r2);
                    System.out.println("AI r3 :"+r3);
                    System.out.println("AI r4 :"+r4);
                    actualOutcome = (r1 && r2 && r3 && r4) ? true : false;

                } catch (Exception e) {
                    System.out.println("AI Three Dots error : "+e);
                }
                finally {
                    Records.setSan_aut_id(san_aut_id);
                    record.setTestCaseName("SAN-THREE-DOTS-01");
                    record.setOutcome(actualOutcome);
                    record.setName("AI THREE DOTS");
                    record.setScreenShot(screenShot);
                    record.setExpectedResult("AI THREE DOTS VALIDATIONS");
                    clientVersionDao.setRecordDetails(record);
                    listOb.add(record);
                }
            }

            if(appname.equals("ezeXtend")){
                try {
                    Navbar.waitForPageLoad(driver);
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//div[@class=' css-1fg52zh']")).click();
                    Thread.sleep(2000);
                    String first1= driver.findElement(By.xpath("//button[@class='mantine-UnstyledButton-root mantine-Button-root header-sublist profile-button user-button mantine-15ktcks']/div/span[2]")).getText();
                    if(first1.equals("Documentation")){
                        System.out.println("ezeXtend: Documentation---opened");
                        Thread.sleep(2000);

                        driver.findElement(By.xpath("//button[@class='mantine-UnstyledButton-root mantine-Button-root header-sublist profile-button user-button mantine-15ktcks']/div/span[2]")).click();
                        Thread.sleep(2000);

                        String tryNowBtn = driver.findElement(By.xpath("//span[normalize-space()='Try Now']")).getText();
                        if(tryNowBtn.equals("Try Now"))
                        {
                            actualOutcome = true;
                            System.out.println("Try Now button is visible");
                        }
                        else {
                            actualOutcome = false;
                            System.out.println("Try Now button not visible");
                        }

                        driver.findElement(By.xpath("//a[normalize-space()='ezeXtend']")).click();
                        System.out.println("EzeXtend  Breadcrumb is clicked post Documentation");
//                        backToHome(driver,appname,listOb, clientVersionDao, san_aut_id);
                        actualOutcome = true;
                    }
                    else {
                        System.out.println("ezeXtend: Documentation---Fail");
                        actualOutcome = false;
                    }
                } catch (InterruptedException e) {
                    System.out.println("EzeXtend Three Dots Error : "+e);
                    actualOutcome = false;
                }finally {
                    Records.setSan_aut_id(san_aut_id);
                    record.setTestCaseName("SAN-THREE-DOTS-02");
                    record.setOutcome(actualOutcome);
                    record.setName("EZEXTEND THREE DOTS");
                    record.setScreenShot(screenShot);
                    record.setExpectedResult("EZEXTEND THREE DOTS VALIDATIONS");
                    clientVersionDao.setRecordDetails(record);
                    listOb.add(record);
                }
            }

        }
        catch (Exception e) {
            System.out.println("Inside catch for chkThreeDots for appname : "+appname);
            actualOutcome = false;
            e.toString();
            e.getMessage();
        }
        System.out.println("Returning flag from chkThreeDots for appname "+appname+" = "+actualOutcome);
        return actualOutcome;
    }

    private static Boolean darkTheme(WebDriver driver, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        String bgcolor= "";
        List<File> screenShot = new ArrayList<>();
        Records record = new Records();
        Boolean actualOutcome = false;

        try {
            driver.findElement(By.xpath("//span[normalize-space()='Dark Theme']")).click();
//            WebElement app = driver.findElement(By.cssSelector("div[id='root']"));
            waitForPageLoad(driver);
            Thread.sleep(2000);
            List<WebElement> app = driver.findElements(By.xpath("//body[@class='dark']"));
            int count = app.size();

            if(count==1)
            {
                System.out.println("dark theme success");
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                actualOutcome = true;
            }

//            bgcolor=app.getCssValue("--bg");
//            System.out.println("color---"+bgcolor);
//            if(bgcolor.equals("#121212")){
//                System.out.println("dark theme");
//                screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                actualOutcome = true;
//            }
            else {
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                System.out.println("Fail Dark Theme");
                actualOutcome = false;
            }
            return actualOutcome;
        } catch (Exception e) {
            System.out.println("Dark Theme Error : "+e);
            return actualOutcome;
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-DARK-THEME-01");
            record.setOutcome(actualOutcome);
            record.setName("DARK THEME");
            record.setScreenShot(screenShot);
            record.setExpectedResult("DARK THEME VALIDATION");
            clientVersionDao.setRecordDetails(record);
            listOb.add(record);
        }
    }

    private static Boolean lightTheme(WebDriver driver, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        String bgcolor= "";
        List<File> screenShot = new ArrayList<>();
        Records record = new Records();
        Boolean actualOutcome = false;

        try {
            driver.findElement(By.xpath("//span[normalize-space()='Light Theme']")).click();
//            WebElement app = driver.findElement(By.cssSelector("div[id='root']"));
            waitForPageLoad(driver);
            Thread.sleep(2000);
            List<WebElement> app = driver.findElements(By.xpath("//body[@class]"));
            int count = app.size();

            if(count==1)
            {
                System.out.println("light theme success");
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                actualOutcome = true;
            }
//            bgcolor=app.getCssValue("--bg");
//            System.out.println("color---"+bgcolor);
//            if(bgcolor.equals("#fff")){
//                System.out.println("light theme success");
//                screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                actualOutcome = true;
//            }
            else {
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                System.out.println("Fail Light Theme");
                actualOutcome = false;
            }
            return actualOutcome;
        } catch (Exception e) {
            System.out.println("Light Theme Error : "+e);
            return actualOutcome;
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LIGHT-THEME-01");
            record.setOutcome(actualOutcome);
            record.setName("LIGHT THEME");
            record.setScreenShot(screenShot);
            record.setExpectedResult("LIGHT THEME VALIDATION");
            clientVersionDao.setRecordDetails(record);
            listOb.add(record);
        }
    }

    public static boolean backToHome(WebDriver driver, String appname, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        String appText="";
        System.out.println("Inside backToHome for : "+appname);

        List<File> screenShot = new ArrayList<>();
        Records record = new Records();
        Boolean actualOutcome = false;
        waitForPageLoad(driver);
        SeleniumUtils.waitForPageLoad(driver);

        try{

            System.out.println("Waited for page to load properly inside backToHome function for appName:"+appname);

            if(appname.equals("Landing")){
//                appText= driver.findElement(By.xpath("//h2[@class='section-title-modules mb-0']")).getText();
                appText= driver.findElement(By.xpath("//h2[normalize-space()='Applications']")).getText();
                Thread.sleep(2000);
                waitForPageLoad(driver);
                if(appText.equals("Applications")) {
                    System.out.println("tcgmcube logo click-> landing page : Pass" );
                    actualOutcome = true;
                }
                else {
                    System.out.println("tcgmcube logo click-> landing page : Fail" );
                    actualOutcome = false;
                }
            }
            else if(appname.equals("BI")){
                Navbar.waitForPageLoad(driver);
                Thread.sleep(5000);
                System.out.println("About to click home icon from BI");
                driver.findElement(By.xpath("//*[@class='hometooltip']/img")).click();
//                appText= driver.findElement(By.xpath("//h2[@class='section-title-modules mb-0']")).getText();
                Navbar.waitForPageLoad(driver);
                appText= driver.findElement(By.xpath("//h2[normalize-space()='Applications']")).getText();
                Thread.sleep(2000);
                waitForPageLoad(driver);
                if(appText.equals("Applications")) {
                    System.out.println("tcgmcube logo click-> BI Page : Pass" );
                    actualOutcome = true;
                }
                else {
                    System.out.println("tcgmcube logo click-> BI Page : Fail" );
                    actualOutcome = false;
                }
            }
            else if(appname.equals("AI")){
//                driver.findElement(By.xpath("//a[@href='/home']")).click();
//                driver.findElement(By.xpath("//a[@href='/home' or @href='/home/#/landing']")).click();
                driver.findElement(By.xpath("//a[contains(@href, '/home')]")).click();
                Thread.sleep(2000);
                waitForPageLoad(driver);

                appText= driver.findElement(By.xpath("//h2[@class='section-title-modules mb-0']")).getText();
                Thread.sleep(2000);
                if(appText.equals("Applications")){
                    System.out.println("tcgmcube logo click-> AI page : Pass" );
                    actualOutcome = true;
                }
                else {
                    System.out.println("tcgmcube logo click-> AI page : Fail" );
                    actualOutcome = false;
                }
            }
            else if(appname.equals("ezeXtend")){
//                driver.findElement(By.xpath("//a[@href='/home']")).click();
                driver.findElement(By.xpath("//a[contains(@href, '/home')]")).click();
                Thread.sleep(2000);
                waitForPageLoad(driver);
                appText= driver.findElement(By.xpath("//h2[@class='section-title-modules mb-0']")).getText();
                Thread.sleep(2000);
                if(appText.equals("Applications")){
                    System.out.println("tcgmcube logo click-> ezextend page : Pass" );
                    actualOutcome = true;
                }
                else {
                    System.out.println("tcgmcube logo click-> ezextend page : Fail" );
                    actualOutcome = false;
                }
            }
            else if(appname.equals("Workbench")){
                try {
                    waitForPageLoad(driver);
                    System.out.println("Back to home appname : "+appname);
                    Thread.sleep(3000);
                    //driver.findElement(By.xpath("//a[@href='https://mcubeinqa510.tcgdigital.com/home']")).click();
                    driver.findElement(By.xpath("//div[@class='logo-link tooltip-bottom']/a/img")).click();
                    System.out.println("1st....");
                    Thread.sleep(4000);
                    waitForPageLoad(driver);
                    appText= driver.findElement(By.xpath("//h2[@class='section-title-modules mb-0']")).getText();
                    System.out.println("2nd apptext :"+appText);
                    Thread.sleep(2000);
                    if(appText.equals("Applications")){
                        System.out.println("tcgmcube logo click-> workbench page : Pass" );
                        actualOutcome = true;
                    }
                    else {
                        System.out.println("tcgmcube logo click-> workbench page : Fail" );
                        actualOutcome = false;
                    }
                } catch (InterruptedException e) {
                    actualOutcome = false;
                    System.out.println("Error Workbench : "+e);
                    waitForPageLoad(driver);
                }
            }

        }
        catch (Exception e) {
            System.out.println("Module->"+appname+" <-and e : "+e);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            waitForPageLoad(driver);
            actualOutcome = false;
            e.toString();
            e.getMessage();
        }
        finally {
            System.out.println("Finally : "+appname);
            if(!appname.equalsIgnoreCase("Workbench")) {
                Records.setSan_aut_id(san_aut_id);
                record.setTestCaseName("SAN-HOME-01");
                record.setOutcome(actualOutcome);
                record.setName("HOME ICON CLICK");
                record.setScreenShot(screenShot);
                record.setExpectedResult("HOME ICON REDIRECTION FROM " + appname);
                clientVersionDao.setRecordDetails(record);
                listOb.add(record);
            }
        }
        System.out.println("Actual Outcome from HOME ICON for : "+appname +" : "+actualOutcome);
        return actualOutcome;
    }

}
