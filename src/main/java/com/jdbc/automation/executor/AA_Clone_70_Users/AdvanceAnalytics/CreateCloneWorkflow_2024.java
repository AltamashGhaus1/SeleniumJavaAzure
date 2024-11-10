package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import com.jdbc.automation.executor.AA_Clone_70_Users.Common.FetchData;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SimpleLogin;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.StatusOutput;
import com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity.AACloneConcurrency;
import com.jdbc.automation.executor.Common.Records;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateCloneWorkflow_2024 extends AACloneConcurrency {

    static Records rec = new Records();
    private static final Logger log = LoggerFactory.getLogger(ArtificialIntelligence.class);

    public static void createCloneWorkflow(WebDriver driver, WebDriverWait wait,String username,String password, String url) throws Exception {

        System.out.println("Inside CreateCloneWorkflpe_2024");
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        List<String> listA = Arrays.asList("Read Data","Handle Missing Values","String Indexer","Assemble Vector");
        //List<String> listA = Arrays.asList("Transform/Predict","Filter Columns","SQL Transformation");
        //List<String> listA = Arrays.asList("SQL Transformation");

        Boolean loggedIn = SimpleLogin.login(driver, username, password, url);
        int index = 0;
        String clonedWFName = "";

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Advanced Analytics")));
            driver.findElement(By.linkText("Advanced Analytics")).click();
            Thread.sleep(5000);
            SeleniumUtils.switchToWindow1("Workflows", driver);
            Thread.sleep(4000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            try {
                WebElement webElem = driver.findElement(By.xpath("//div[@class='col-sm-8 icon-description']"));
                int webElemSize = webElem.getText().length();
                String statusLogin = "";
                statusLogin = (webElemSize!=0) ? "PASS AA FIRST PAGE" : "FAIL";
//                Label labelLogin = new Label(2,rows,statusLogin);
                String filePath = "D:\\Gurukul_test\\output.txt";
                StatusOutput.writeInText(filePath,statusLogin);
//                WriteData.setData(fileName, 0, labelLogin);
            } catch (Exception e) {
                e.printStackTrace();
//                Label labelDetailsFilling = new Label(2,rows,"FAIL");
//                WriteData.setData(fileName, 0, labelDetailsFilling);
                String filePath = "D:\\Gurukul_test\\output.txt";
                StatusOutput.writeInText(filePath,"FAILED AA FIRST PAGE");
            }
            //----------------------------------start
            //Template click
            System.out.println("Workflow clicked for :"+ (++index) +" time");
            driver.findElement(By.xpath("//li[@class='o-tab']/a")).click();
            Thread.sleep(3000);

            //String cloneFromFile = "On Time Classification Template_v2";
            String wfnameFromFile = String.valueOf(FetchData.fetch_Data(driver, wait, 11,2));

            driver.findElement(By.xpath("//input[@placeholder='SEARCH...']")).sendKeys(wfnameFromFile);

            List<WebElement> wsList = driver.findElements(By.xpath("//a[@class='ng-binding owned-by-current-user']"));
            System.out.println("wsList -------> ");
            for (WebElement we : wsList) {
                System.out.println("Yo "+we.getAttribute("title"));
            }

            List<WebElement> wsListFinal = new ArrayList<>();


            int k=0;
            for (int i = 0; i < wsList.size(); i = i + 2) {
                String wsName = wsList.get(i).getAttribute("title");
                System.out.println("wsnName : " + wsName);
                if (wsName.equals(wfnameFromFile))
                {
                    WebElement wli = wsList.get(i);
                    System.out.println("Inisde loop i :::: "+i);

                    /*JavascriptExecutor je = (JavascriptExecutor) driver;
                    WebElement scrollToElem = wli.findElement(By.xpath("/ancestor::td[1]/following-sibling::td[5]/span/a"));
                    je.executeScript("arguments[0].scrollIntoView(true);",scrollToElem);

                    scrollToElem.click();*/
                    //wli.findElement(By.xpath("/ancestor::td[1]/following-sibling::td[5]/span/a")).click();
                    driver.findElement(By.xpath("//span[@class='fa fa-files-o ']")).click();
                    System.out.println("Clone button is clciked");

                    System.out.println("Clone Button of WF : "+wsName+" is clicked");

                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).clear();
                     clonedWFName = "LAU_";

                    //driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys(clonedWFName);

//                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys(String.valueOf(rows));
                    Random rand = new Random();
                    int randomNo = rand.nextInt(1000000);
                    String randNo = String.valueOf(randomNo);
                    clonedWFName=clonedWFName+"_"+randNo+"__";
//                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys("_");

                    String oldWFName = driver.findElement(By.xpath("//h4[@class='modal-title ng-binding']")).getText();
//                    clonedWFName=clonedWFName+oldWFName.substring(17);
                    clonedWFName=clonedWFName+wfnameFromFile;

                    System.out.println("New cloned WF : "+clonedWFName);

                    //Cloned
                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys(clonedWFName);

                    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
                    Thread.sleep(5000);
                    //wsListFinal.add(k,wli);
                    //k++;
                }
                else {
                    continue;
                }
            }

            Run_N_Workflows.runClonedWorkflow(driver, wait, username, password, url, clonedWFName);

        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            log.error("", e);
            System.out.println("Final Catch Failed Exit");

        }
    }
}

