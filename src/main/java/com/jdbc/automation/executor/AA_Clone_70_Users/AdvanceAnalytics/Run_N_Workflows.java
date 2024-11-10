package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
import com.jdbc.automation.executor.Common.Records;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils.clickMenuItems;

public class Run_N_Workflows {

    private static final Logger log= LoggerFactory.getLogger(Run_N_Workflows.class);
    public static void runClonedWorkflow(WebDriver driver, WebDriverWait wait, String username, String password, String url, String wfName) throws Exception {
        Date startTime = null;
        DateTimeZone dtZone = null;
        DateTime startDtus = null;
        startTime = Calendar.getInstance().getTime();
        dtZone = DateTimeZone.forID("Asia/Kolkata");
        DateTime startDate = new DateTime(startTime);
        startDtus = startDate.withZone(dtZone);

        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        System.out.println("Inside runClonedWorkflow --------> for Workflow : "+wfName);
        List<String> listA = Arrays.asList("Read Data","Handle Missing Values","String Indexer","Assemble Vector");
        //List<String> listA = Arrays.asList("Transform/Predict","Filter Columns","SQL Transformation");
        //List<String> listA = Arrays.asList("SQL Transformation");

        //SimpleLogin.login(driver, username, password, url);
        int index = 0;

        try {
            driver.findElement(By.xpath("//input[@placeholder='SEARCH...']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='SEARCH...']")).sendKeys(wfName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//td[@class='table__cell table__left table__truncate ']/a")).click();
            Thread.sleep(3000);
            clickMenuItems(driver,"Adv. Settings");
            //SeleniumUtils.switchCluster(driver,"kubernetes");
            SeleniumUtils.switchCluster(driver,"eks");

            Thread.sleep(3000);
            clickMenuItems(driver,"Start editing");
            Thread.sleep(2000);
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
            Thread.sleep(2000);
            clickMenuItems(driver, "Run");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(2000);

            driver.navigate().refresh();

            System.out.println("Waiting for Run button to be visible again");
            try {

                synchronized (Run_N_Workflows.class) {
                    try (FileWriter writer = new FileWriter("D:\\Gurukul_test\\clonedWorkFlowRunning.txt", true)) {
                        writer.write(Thread.currentThread().getName() + ": " + wfName + "\n");
                        System.out.println("Thread :" + Thread.currentThread().getName()+" and "+wfName + " wrote to text file.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Thread.sleep(5000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run")));
                System.out.println("Run re-appears after completing the task");


            }
            catch (Exception e) {

                SeleniumUtils.takeScreenShot(driver);
                System.out.println("Workspace is running already -> No RUN present");
                actualOutcome = false;
//                Label label = new Label(6,rows,"FAIL");
//                WriteData.setData(fileName, 0, label);
//                log.error("", e);
//                String filePath = "D:\\Gurukul_test\\runworkflowOutput.txt";
//                StatusOutput.writeInText(filePath,"FAILED AA IN RUN AUTOMATION");

                synchronized (Run_N_Workflows.class) {
                    try (FileWriter writer = new FileWriter("D:\\Gurukul_test\\clonedWorkFlowFailed.txt", true)) {
                        writer.write(Thread.currentThread().getName() + ": " + wfName + "\n");
                        System.out.println("Thread FAILED:" + Thread.currentThread().getName()+" and "+wfName + " wrote to text file.");
                    } catch (IOException ep) {
                        ep.printStackTrace();
                    }
                }
            }

            System.out.println("verifyAA------------------------->");
            boolean verifyAA = SeleniumUtils.verifyAAWorkflow2(driver);
            Thread.sleep(2000);
            System.out.println("Verify AA : " + verifyAA);

            actualOutcome = verifyAA;
            System.out.println("Validate Workflow : " + actualOutcome);

            if(actualOutcome)
            {
                synchronized (Run_N_Workflows.class) {
                    try (FileWriter writer = new FileWriter("D:\\Gurukul_test\\clonedWorkFlowPass.txt", true)) {
                        writer.write(Thread.currentThread().getName() + ": " + wfName + "\n");
                        System.out.println("Thread :" + Thread.currentThread().getName()+" and "+wfName + " wrote to text file.");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                driver.quit();
            }
            else{
                synchronized (Run_N_Workflows.class) {
                    try (FileWriter writer = new FileWriter("D:\\Gurukul_test\\clonedWorkFlowFailed.txt", true)) {
                        writer.write(Thread.currentThread().getName() + ": " + wfName + "\n");
                        System.out.println("Thread FAILED:" + Thread.currentThread().getName()+" and "+wfName + " wrote to text file.");
                    } catch (IOException ep) {
                        ep.printStackTrace();
                    }
                }
            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            System.out.println("Final Catch Failed Exit");
            synchronized (Run_N_Workflows.class) {
                try (FileWriter writer = new FileWriter("D:\\Gurukul_test\\clonedWorkFlowFailed.txt", true)) {
                    writer.write(Thread.currentThread().getName() + ": " + wfName + "\n");
                    System.out.println("Thread FAILED:" + Thread.currentThread().getName()+" and "+wfName + " wrote to text file.");
                } catch (IOException ep) {
                    ep.printStackTrace();
                }
            }

        }
        finally {
            //----------
            Date endTime = Calendar.getInstance().getTime();
            long diff = endTime.getTime() - startTime.getTime();
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            DateTime endDate = new DateTime(endTime);
            DateTime endDtus = endDate.withZone(dtZone);

//            System.out.println(
//                    System.lineSeparator() +
//                            System.lineSeparator() + "\t\t\t\t|-------------------------------------------------------|" +
//                            System.lineSeparator() + "\t\t\t\t|      DURATION DETAILS RUN WORKFLOW                                |" +
//                            System.lineSeparator() + "\t\t\t\t|_______________________________________________________|" +
//                            System.lineSeparator() + "\t\t\t\t|      START    - " + startDtus.toLocalDateTime().toDate() + "          |" +
//                            System.lineSeparator() + "\t\t\t\t|      END      - " + endDtus.toLocalDateTime().toDate() + "          |" +
//                            System.lineSeparator() + "\t\t\t\t|      ---------------------------------------          |" +
//                            System.lineSeparator() + "\t\t\t\t|      AG_DURATION -     " + diffMinutes + " min(s) " + diffSeconds + " sec(s)               " + (diffMinutes < 10 ? " " : "") + (diffSeconds < 10 ? " " : "") + "|" +
//                            System.lineSeparator() + "\t\t\t\t|-------------------------------------------------------|" +
//                            System.lineSeparator()
//            );

            synchronized (Run_N_Workflows.class) {
                try (FileWriter writer = new FileWriter("D:\\Gurukul_test\\finalOutput.txt", true)) {
                    writer.write(Thread.currentThread().getName() + "| " + wfName +" | "+ actualOutcome +" | " + diffMinutes + " min(s) " + diffSeconds + " sec(s)"+"\n");
                    System.out.println("Thread Finally:" + Thread.currentThread().getName() + "| " + wfName +" | "+ actualOutcome +" | " + diffMinutes + " min(s) " + diffSeconds + " sec(s)"+" wrote to text file.");
                } catch (IOException ep) {
                    ep.printStackTrace();
                }
            }

        }
    }


}
