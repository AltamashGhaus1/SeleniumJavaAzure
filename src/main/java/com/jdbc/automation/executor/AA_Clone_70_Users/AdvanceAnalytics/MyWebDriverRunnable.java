package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import com.jdbc.automation.executor.AA_Clone_70_Users.Common.FetchData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

// Runnable implementation for WebDriver
public class MyWebDriverRunnable implements Runnable {
    @Override
    public void run() {

        String url , fileName ,username , password , dataset , mailto, createdBy , createdByName, client ,version="";
//        ClientVersionDao ClientVersionDao=null;

        System.out.println("Inside RUNNABLE 1");
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C://Selenium//web_driver//chromedriver_win32//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

        try {
            url = String.valueOf(FetchData.fetch_Data(driver, wait, 1,2));
            fileName = String.valueOf(FetchData.fetch_Data(driver, wait, 2,2));
            username = String.valueOf(FetchData.fetch_Data(driver, wait, 3,2));
            password = String.valueOf(FetchData.fetch_Data(driver, wait, 4,2));
//            dataset = String.valueOf(FetchData.fetch_Data(driver, wait, 5,2));
//            mailto = String.valueOf(FetchData.fetch_Data(driver, wait, 6,2));
//            createdBy = String.valueOf(FetchData.fetch_Data(driver, wait, 7,2));
//            createdByName = String.valueOf(FetchData.fetch_Data(driver, wait, 8,2));
//            client = String.valueOf(FetchData.fetch_Data(driver, wait, 9,2));
//            version = String.valueOf(FetchData.fetch_Data(driver, wait, 10,2));
        } catch (InterruptedException e) {
            System.out.println("Error in fetching values");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error in fetching values 2");
            throw new RuntimeException(e);
        }

        System.out.println("Inside RUNNABLE 2");
        // Navigate to a webpage
//        driver.get(url);
//        System.out.println("Hit URL..");



        // Perform your WebDriver actions here...
        try {
            CreateCloneWorkflow_2024.createCloneWorkflow(driver, wait,username,password, url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Login
        driver.manage().window().maximize();
        System.out.println("Max Window..");
        //SeleniumUtils.loginBIInValid(driver, listOb,username,password,clientVersionDao,san_aut_id);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


//        SeleniumUtils.loginBIValid(driver, listOb, username, password, url, clientVersionDao, san_aut_id);
//
//        if(version.equalsIgnoreCase("AI concurrent workflow automation")) {
//            CreateWorkflow.createWorkflow(driver, wait, listOb, clientVersionDao, san_aut_id,rows);
//        }
//        else if(version.equalsIgnoreCase("AI clone workflow automation")) {
//            CreateCloneWorkflow.createCloneWorkflow(driver, wait, listOb, clientVersionDao, san_aut_id,rows);
//        }
//        else if(version.equalsIgnoreCase("AI 20 important templates")) {
//            ArtificialIntelligence.artificialIntelligence(driver, wait, listOb, clientVersionDao, san_aut_id);
//        }

        // Close the WebDriver instance
//        driver.quit();
    }
}