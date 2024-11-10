package com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity;

import com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics.CreateCloneWorkflow;
import com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics.CreateWorkflow;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.SeleniumUtils;
import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics.ArtificialIntelligence;
import com.jdbc.automation.executor.mcube4520.com.mcube.qa.sanity.email.EmailSender;
import com.jdbc.automation.executor.mcube4520.com.mcube.qa.sanity.pdf.creator.PdfCreator;
import com.jdbc.dao.ClientVersionDao;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AACloneConcurrency {

    private static final Logger log = LoggerFactory.getLogger(AACloneConcurrency.class);
    //public static String fileName = "https://docs.google.com/spreadsheets/d/19WhgTRyCMkn5XJepi1eSO2Kmf71oo44J/edit?usp=share_link&ouid=107873733469465654847&rtpof=true&sd=true";
    public static String fileName = "D://output.xls";

   /* public void run(){
        System.out.println("thread is running...");
    }*/
   //Add client version dao as argument , Sanity_Aut_Master_ID
    //public static File executeAutomation(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
    public static File executeAutomation(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id, int rows) throws Exception {

        Date startTime = Calendar.getInstance().getTime();
        DateTimeZone dtZone = DateTimeZone.forID("Asia/Kolkata");
        DateTime startDate = new DateTime(startTime);
        DateTime startDtus = startDate.withZone(dtZone);
        System.out.println("Hello world!");

        List<Records> listOb = new ArrayList<>();
        Integer percentCount = 0;

        //List<File> screenshot = new ArrayList<File>();

        List<String> widgetList = new ArrayList<String>();

        WebDriver driver = null;
        File pdfFile = null;
        try {

            Thread.sleep(3000);
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C://Selenium//web_driver//chromedriver_win32//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            Thread.sleep(3000);

            Records record = new Records();
            record.setTestCaseName("UAT-URL-01");
            boolean actualOutcome = Boolean.FALSE;
            List<File> screenShot = new ArrayList<>();
            try {
                System.out.println("URL --> " + url);
                driver.get(url);
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                actualOutcome = Boolean.TRUE;
                record.setOutcome(actualOutcome);
                record.setName("URL REACHABILITY");
                record.setScreenShot(screenShot);
                record.setExpectedResult("LOGIN PAGE SHOULD APPEAR");
                listOb.add(record);
            } catch (Exception e) {
                log.error("", e);
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                record.setOutcome(actualOutcome);
                record.setName("URL REACHABILITY");
                record.setScreenShot(screenShot);
                record.setExpectedResult("LOGIN PAGE SHOULD APPEAR");
                listOb.add(record);
                throw new Exception("Provided URL not reachable.");
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

            //Login
            driver.manage().window().maximize();
            //SeleniumUtils.loginBIInValid(driver, listOb,username,password,clientVersionDao,san_aut_id);
            Thread.sleep(2000);
            SeleniumUtils.loginBIValid(driver, listOb, username, password, url, clientVersionDao, san_aut_id);

            if(version.equalsIgnoreCase("AI concurrent workflow automation")) {
                CreateWorkflow.createWorkflow(driver, wait, listOb, clientVersionDao, san_aut_id,rows);
            }
            else if(version.equalsIgnoreCase("AI clone workflow automation")) {
                CreateCloneWorkflow.createCloneWorkflow(driver, wait, listOb, clientVersionDao, san_aut_id,rows);
            }
            else if(version.equalsIgnoreCase("AI 20 important templates")) {
                ArtificialIntelligence.artificialIntelligence(driver, wait, listOb, clientVersionDao, san_aut_id);
            }

        } catch (Exception e) {
            log.error("", e);
        } finally {

            if (null != driver) {
                try {
                    System.out.println("Driver is quiting");
                    //driver.quit();
                } catch (Exception e) {
                    log.error("", e);
                }

            }
            System.out.println("" + listOb.size());
            listOb.forEach(e -> {
                System.out.println(e.toString());
            });

            if (version.equalsIgnoreCase("AI 20 important templates")) {

                pdfFile = PdfCreator.createSanityReportPdf(listOb, url, createdBy, createdByName, client, version);
                if (null != pdfFile) {
                    System.out.println("[SANITY][EMAIL] pdf found, sending email.......");
                    String body = "Dear Sir/Madam,<br/><br/>\n" +
                            "\t\t\n" +
                            "\t\tPlease find below the sanity test result.<br/><br/>\n" +
                            "\t\t\n" +
                            "\t\tRegards,<br/>\t\t\n" +
                            "\t\ttcg mcube QA Team<br/>";
                    String subject = "Sanity Test Result For URL: " + url;

                    String to = mailto.equalsIgnoreCase("NA") ? "" : mailto;
                    if (!createdBy.equalsIgnoreCase("NA")) {
                        to = to + "," + createdBy;
                    }
                    String cc = System.getenv("EMAIL_CC").equalsIgnoreCase("NA") ? "" : System.getenv("EMAIL_CC");
                    String bcc = System.getenv("EMAIL_BCC").equalsIgnoreCase("NA") ? "" : System.getenv("EMAIL_BCC");

                    List<File> attachments = new ArrayList<>();
                    attachments.add(pdfFile);

                    EmailSender.sendEmail(to, cc, bcc, body, subject, attachments);
                } else {
                    System.out.println("[SANITY][EMAIL] pdf not found, not sending email.......");
                }
                Date endTime = Calendar.getInstance().getTime();
                long diff = endTime.getTime() - startTime.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;

                DateTime endDate = new DateTime(endTime);
                DateTime endDtus = endDate.withZone(dtZone);
                System.out.println(
                        System.lineSeparator() +
                                System.lineSeparator() + "\t\t\t\t|-------------------------------------------------------|" +
                                System.lineSeparator() + "\t\t\t\t|      DURATION DETAILS                                 |" +
                                System.lineSeparator() + "\t\t\t\t|_______________________________________________________|" +
                                System.lineSeparator() + "\t\t\t\t|      START    - " + startDtus.toLocalDateTime().toDate() + "          |" +
                                System.lineSeparator() + "\t\t\t\t|      END      - " + endDtus.toLocalDateTime().toDate() + "          |" +
                                System.lineSeparator() + "\t\t\t\t|      ---------------------------------------          |" +
                                System.lineSeparator() + "\t\t\t\t|      DURATION -     " + diffMinutes + " min(s) " + diffSeconds + " sec(s)               " + (diffMinutes < 10 ? " " : "") + (diffSeconds < 10 ? " " : "") + "|" +
                                System.lineSeparator() + "\t\t\t\t|-------------------------------------------------------|" +
                                System.lineSeparator()
                );
            }
        }
        return pdfFile;

    }

}