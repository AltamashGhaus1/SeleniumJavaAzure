
package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity.AACloneConcurrency;
import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.WriteData;
import com.jdbc.dao.ClientVersionDao;
import jxl.write.Label;
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

public class CreateWorkflow extends AACloneConcurrency {

    static Records rec = new Records();
    private static final Logger log = LoggerFactory.getLogger(ArtificialIntelligence.class);

    public static void createWorkflow(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, int rows) throws Exception {

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        List<String> listA = Arrays.asList("Read Data","Handle Missing Values","String Indexer","Assemble Vector","Split",
                "Logistic Regression","Train","Transform/Predict","Filter Columns","SQL Transformation");


        int index = 0;
        String wfName = "";

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Advanced Analytics")));
            driver.findElement(By.linkText("Advanced Analytics")).click();
            Thread.sleep(5000);
            SeleniumUtils.switchToWindow1("Workflows", driver);
            Thread.sleep(4000);
            SeleniumUtils.takeScreenShot(driver);

            //----------------------------------start

            Thread.sleep(3000);

            try {
                WebElement webElem = driver.findElement(By.xpath("//div[@class='col-sm-8 icon-description']"));
                int webElemSize = webElem.getText().length();
                String statusLogin = "";
                statusLogin = (webElemSize!=0) ? "PASS" : "FAIL";
                Label labelLogin = new Label(2,rows,statusLogin);
                WriteData.setData(fileName, 0, labelLogin);

                //DB entry
            } catch (Exception e) {
                e.printStackTrace();
                Label labelDetailsFilling = new Label(2,rows,"FAIL");
                WriteData.setData(fileName, 0, labelDetailsFilling);
            }

            driver.findElement(By.xpath("//div[@class='col-sm-8 icon-description']")).click();

            Random rand = new Random();
            int randomNo = rand.nextInt(1000000);
            wfName = "Sample_WF_"+randomNo;


            driver.findElement(By.id("workflow-name")).sendKeys(wfName);

            driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
            System.out.println("WF created : "+wfName);

            Label labelWorkflowCreation = new Label(3,rows,"PASS");
            WriteData.setData(fileName, 0, labelWorkflowCreation);

            Label labelWF = new Label(4,rows,wfName);
            WriteData.setData(fileName, 0, labelWF);



            //to search workflow
            /*driver.findElement(By.cssSelector("input[class='text-center form-control input-search-workflow ng-pristine ng-untouched ng-valid ng-empty']")).sendKeys("AG_Sample WF_20");
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("a[class='ng-binding owned-by-current-user']")).click();*/


            //SeleniumUtils.clickMenuItems(driver,"Adv. Settings");
            //SeleniumUtils.switchCluster(driver,"eks");

            Thread.sleep(3000);
            SeleniumUtils.clickMenuItems(driver,"Start editing");
            Thread.sleep(30000);
            System.out.println("Waiting for Stop Editing button");
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Stop editing")));
                System.out.println("Completed Waiting for Stop Editing button");
            } catch (Exception e) {
                System.out.println("Failed to get Stop Editing button");
                e.printStackTrace();
            }

            actualOutcome = SeleniumUtils.addNode(driver, wait, listA, screenShot,rows,fileName);

            String status = "";
            status = (actualOutcome==true) ? "PASS" : "FAIL";

            Label labelExecution = new Label(8,rows,status);
            WriteData.setData(fileName, 0, labelExecution);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            log.error("", e);
            System.out.println("Final Catch Failed Exit");

        }
    }
}
