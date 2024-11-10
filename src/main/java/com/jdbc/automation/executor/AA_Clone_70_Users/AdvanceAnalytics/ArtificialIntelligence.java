package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
import com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity.AACloneConcurrency;
import com.jdbc.automation.executor.Common.Records;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ArtificialIntelligence extends AACloneConcurrency {

    static Records rec = new Records();


    private static final Logger log= LoggerFactory.getLogger(ArtificialIntelligence.class);
    public static boolean artificialIntelligence(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        int index = 0;
        String wfName="";
        wait = new WebDriverWait(driver, Duration.ofSeconds(180));

//        int excelUpperRows = 4;
        try {
//            Label label = new Label(2,rows,"PASS");
//            WriteData.setData(fileName,0,label);
            //WriteData.setData("https://docs.google.com/spreadsheets/d/10XZMwEaTC7nBMUUWy7D1kimO7Z27guvU/edit?usp=share_link&ouid=107873733469465654847&rtpof=true&sd=true",0,label);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Advanced Analytics")));
            driver.findElement(By.linkText("Advanced Analytics")).click();
            Thread.sleep(5000);
            SeleniumUtils.switchToWindow1("Workflows", driver);
            Thread.sleep(4000);
            //screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //----------------------------------start
            //Template click
            System.out.println("Workflow clicked for :"+ (++index) +" time");
            driver.findElement(By.xpath("//li[@class='o-tab']/a")).click();
            Thread.sleep(3000);

            //String cloneFromFile = "On Time Classification Template_v2";

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
                    /*if (!wsName.contains("copy") && !wsName.contains("Copy") && !wsName.contains("dummy") && !wsName.contains("test")
                            && !wsName.contains("Test") && !wsName.contains("SK_TES") && !wsName.contains("ttt")
                            && !wsName.startsWith("admin")  && !wsName.startsWith("new") && !wsName.startsWith("tes")
                            && !wsName.startsWith("k8") && !wsName.startsWith("adma demo") && !wsName.startsWith("MT")
                            && !wsName.startsWith("Workflow") && !wsName.startsWith("catalent")) {*/

                    if (wsName.equals("Airlines Sentiment Analysis Demo") || wsName.equals("Flight Delay Prediction V2 ELT")
                            || wsName.equals("MCUBE UI") || wsName.equals("Bijan_Student Pathways")
                            || wsName.equals("KPI-Mcube Demo") || wsName.equals("Loan Defaulters Prediction")
                            || wsName.equals("LVA Classification Template") || wsName.equals("LVA Polynomial Regression Template")
                            || wsName.equals("LVA_Pearson_Coefficient_and_2Tail_Significance") || wsName.equals("LVA Classification Template Flow Cytometry")
                            || wsName.equals("TAT Classification") || wsName.equals("Plasma Data")
                            || wsName.equals("Template Classification Template") || wsName.equals("Template_Polynomial_Regression_Workflow")
                            || wsName.equals("Calbration_Curve_Workflow") || wsName.equals("Template_Pearson_Coefficient_and_2Tail_Significance")
                            || wsName.equals("Replicate Analysis2") || wsName.equals("Reagent Adjiustment Analysis")
                            || wsName.equals("Elecsys IPC Analysis") || wsName.equals("Drug Stability")) {

                        WebElement wli = wsList.get(i);
                        wsListFinal.add(k,wli);
                        k++;
                    }
                    else {
                        continue;
                    }
                }
                List<String> wfListFinalName = new ArrayList<>();
                System.out.println("wsListFinal -------> ");
                for (WebElement we : wsListFinal) {
                    String str = we.getAttribute("title");
                    System.out.println(str);
                    wfListFinalName.add(str);
                }


//wsListFinal.size()
                for (index = 0; index < 10; index++) {
                    try {
                        System.out.println("index value : "+index);
                        //System.out.println(wsListFinal.get(index).getAttribute("title") + " IS ABOUT TO BE CLICKED");
                        wfName = wfListFinalName.get(index);

                        driver.findElement(By.xpath("//div[@class='input-group search-field']/input")).
                                sendKeys(wfListFinalName.get(index));

                        Thread.sleep(3000);
                        //driver.findElement(By.xpath("//td[@class='table__cell table__left table__truncate ']/a")).click();
                        driver.findElement(By.linkText(wfListFinalName.get(index))).click();

                        //wsListFinal.get(index).click();
                        System.out.println(wfListFinalName.get(index) + " IS CLICKED");

                        Thread.sleep(6000);
                        try {
                            driver.findElement(By.xpath("//i[@class='fa fa-arrows-alt']")).click();
                        } catch (Exception e) {
                            Thread.sleep(3000);
                            driver.findElement(By.xpath("//i[@class='fa fa-arrows-alt']")).click();

                        }
                        SeleniumUtils.clickMenuItems(driver, "Start editing");

                        System.out.println("Waiting for Stop editing to be visible");
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Stop editing")));

                        SeleniumUtils.clickMenuItems(driver, "Run");

                        Thread.sleep(5000);

                        //SeleniumUtils.takeScreenShot(driver);

                        System.out.println("Run is clicked and Abort is present on screen.");
                        System.out.println("Waiting for Run button to be visible again");

                        try {
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run")));
                            System.out.println("Run re-appears after completing the task");
                        } catch (Exception e) {
                            screenShot.add(SeleniumUtils.takeScreenShot(driver));
                            System.out.println("Workspace is running already -> No RUN present");
                            actualOutcome = false;
                            log.error("", e);
                        }


                        boolean verifyAA = SeleniumUtils.verifyAAWorkflow2(driver);
                        Thread.sleep(2000);
                        System.out.println("Verify AA : " + verifyAA);

                        //---------------------------------------end
                        actualOutcome = verifyAA;
                        System.out.println("Validate Clone AA Sanity Success: " + actualOutcome);

                        Thread.sleep(2000);
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));


                    } catch (Exception e) {
                        screenShot.add(SeleniumUtils.takeScreenShot(driver));
                        actualOutcome = false;
                        log.error("", e);
                    } finally {
                        System.out.println("INDEX inside FINALLY ->"+(index+1));
                        //-----------------------------
                        record.setSan_aut_id(san_aut_id);
                        record.setTestCaseName("UAT-AA-0" + (index + 1));
                        record.setOutcome(actualOutcome);
                        record.setName("WF EXECUTED : " + wfName);
                        record.setScreenShot(screenShot);
                        record.setExpectedResult("SUCCESSFULLY RAN WF : " + wfName);
                        clientVersionDao.setRecordDetails(record);

                        listOb.add(record);

                        record = new Records();
                        actualOutcome = false;
                        screenShot = new ArrayList<>();
                        wfName="";

                        if ((index + 1) != wsListFinal.size()) {
                            driver.findElement(By.xpath("//div[@class='mcube-logo logo ']")).click();
                            Thread.sleep(4000);
                            driver.navigate().refresh();
                            System.out.println("Page Refreshed");
                            Thread.sleep(3000);
                            System.out.println("Workflow clicked for :" + (index + 1) + " time inside Finally");
                            driver.findElement(By.xpath("//li[@class='o-tab']/a")).click();
                            Thread.sleep(3000);
                        }
                        //------------------------
                    }
                }
            System.out.println("Final TRY Passed");
        }
        catch(InterruptedException e){
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                log.error("", e);
            System.out.println("Final Catch Failed Exit");
            }
        finally {
            if (!actualOutcome) {
                System.out.println("AI FAIL AS WHOLE");
                return actualOutcome;
            }
            else{
                System.out.println("AI PASS AS WHOLE");
                return actualOutcome;
            }
        }
    }
}
