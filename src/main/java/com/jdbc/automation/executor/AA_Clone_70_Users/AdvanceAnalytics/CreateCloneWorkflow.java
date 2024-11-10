package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.WriteData;
import com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity.AACloneConcurrency;
import com.jdbc.automation.executor.Common.Records;
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

import static com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils.clickMenuItems;

public class CreateCloneWorkflow extends AACloneConcurrency {

    static Records rec = new Records();
    private static final Logger log = LoggerFactory.getLogger(ArtificialIntelligence.class);

    public static void createCloneWorkflow(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, int rows) throws Exception {

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        List<String> listA = Arrays.asList("Read Data","Handle Missing Values","String Indexer","Assemble Vector");
        //List<String> listA = Arrays.asList("Transform/Predict","Filter Columns","SQL Transformation");
        //List<String> listA = Arrays.asList("SQL Transformation");

        int index = 0;
        String wfName = "";

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
                statusLogin = (webElemSize!=0) ? "PASS" : "FAIL";
                Label labelLogin = new Label(2,rows,statusLogin);
                WriteData.setData(fileName, 0, labelLogin);
            } catch (Exception e) {
                e.printStackTrace();
                Label labelDetailsFilling = new Label(2,rows,"FAIL");
                WriteData.setData(fileName, 0, labelDetailsFilling);
            }
            //----------------------------------start
            //Template click
            System.out.println("Workflow clicked for :"+ (++index) +" time");
            driver.findElement(By.xpath("//li[@class='o-tab']/a")).click();
            Thread.sleep(3000);

            //String cloneFromFile = "On Time Classification Template_v2";
            String cloneFromFile = "automation";

            driver.findElement(By.xpath("//input[@placeholder='SEARCH...']")).sendKeys(cloneFromFile);

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
                if (wsName.equals("automation"))
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
                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys("automation_");

                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys(String.valueOf(rows));
                    Random rand = new Random();
                    int randomNo = rand.nextInt(1000000);
                    String randNo = String.valueOf(randomNo);
                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys("_");
                    driver.findElement(By.xpath("//input[@placeholder='Name for a new workflow']")).sendKeys(randNo);

                    String newClonedWF = driver.findElement(By.xpath("//h4[@class='modal-title ng-binding']")).getText();
                    newClonedWF=newClonedWF.substring(17)+"_"+rows+"_"+randNo;

                    System.out.println("New cloned WF : "+newClonedWF);

                    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//td[@class='table__cell table__left table__truncate ']/a")).click();


                    //wsListFinal.add(k,wli);
                    //k++;
                }
                else {
                    continue;
                }
            }




            Thread.sleep(5000);
            clickMenuItems(driver,"Adv. Settings");
            //SeleniumUtils.switchCluster(driver,"kubernetes");
            SeleniumUtils.switchCluster(driver,"eks");

            Thread.sleep(3000);
            clickMenuItems(driver,"Start editing");
            Thread.sleep(30000);
            System.out.println("Waiting for Stop Editing button");
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Stop editing")));
                System.out.println("Completed Waiting for Stop Editing button");
            } catch (Exception e) {
                System.out.println("Failed to get Stop Editing button");
                e.printStackTrace();
            }

            Thread.sleep(2000);
           // Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
            //reportType.selectByIndex(1);
            Thread.sleep(4000);
            clickMenuItems(driver, "Run");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(10000);

            driver.navigate().refresh();

            System.out.println("Waiting for Run button to be visible again");
            try {

                Thread.sleep(5000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run")));
                System.out.println("Run re-appears after completing the task");
                Label label = new Label(7,rows,"PASS");
                WriteData.setData(fileName, 0, label);

            }
            catch (Exception e) {

                SeleniumUtils.takeScreenShot(driver);
                System.out.println("Workspace is running already -> No RUN present");
                actualOutcome = false;
                Label label = new Label(6,rows,"FAIL");
                WriteData.setData(fileName, 0, label);
                log.error("", e);
            }

            System.out.println("verifyAA------------------------->");
            boolean verifyAA = SeleniumUtils.verifyAAWorkflow2(driver);
            Thread.sleep(2000);
            System.out.println("Verify AA : " + verifyAA);

            actualOutcome = verifyAA;
            System.out.println("Validate Workflow : " + actualOutcome);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            log.error("", e);
            System.out.println("Final Catch Failed Exit");

        }
    }
}
