package com.jdbc.automation.executor.mcube4530.com.mcube.qa.sanity;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4530.Common.SeleniumUtils;
import com.jdbc.automation.executor.mcube4530.Dashboard.Dashboard;
import com.jdbc.automation.executor.mcube4530.Miscellaneous.DataProfile;
import com.jdbc.automation.executor.mcube4530.Miscellaneous.SavedObjects;
import com.jdbc.automation.executor.mcube4530.Workbench.ManagementPresteps;
import com.jdbc.automation.executor.mcube4530.Workbench.RoleCreation;
import com.jdbc.automation.executor.mcube4530.Workbench.UserCreation;
import com.jdbc.automation.executor.mcube4530.Workbench.WorkSpaceCreation;
import com.jdbc.automation.executor.mcube4530.com.mcube.qa.sanity.email.EmailSender;
import com.jdbc.automation.executor.mcube4530.com.mcube.qa.sanity.pdf.creator.PdfCreator;
import com.jdbc.automation.executor.mcube4530.widgets.AreaChart;
import com.jdbc.automation.executor.mcube4530.widgets.PreStepsForWidget;
import com.jdbc.automation.executor.mcube4530.widgets.TreeTable;
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


public class McubeSanity_4530 {

    private static final Logger log= LoggerFactory.getLogger(McubeSanity_4530.class);
//Add client version dao as argument , Sanity_Aut_Master_ID
    public static File executeAutomation(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {
        Date startTime= Calendar.getInstance().getTime();
        DateTimeZone dtZone = DateTimeZone.forID("Asia/Kolkata");
        DateTime startDate = new DateTime(startTime);
        DateTime startDtus = startDate.withZone(dtZone);
        System.out.println("Hello world!");

        List<Records> listOb = new ArrayList<>();
        Integer percentCount = 0;

        //List<File> screenshot = new ArrayList<File>();

        List<String> widgetList = new ArrayList<String>();
        /*widgetList.add("Mcube_Area_Chart13014");
        widgetList.add("Mcube_Combo_Chart12815");
        widgetList.add("Mcube_Tree_Table90377");*/

        WebDriver driver = null;
        File pdfFile= null;
        try {

            Thread.sleep(3000);
            //WebDriverManager.chromedriver().setup();

            System.setProperty("webdriver.chrome.driver","C://Selenium//web_driver//chromedriver_win32//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

            Records record=new Records();
            record.setTestCaseName("SAN-URL-01");
            boolean actualOutcome=Boolean.FALSE;
            List<File> screenShot = new ArrayList<>();
            try {
                driver.get(url);
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                actualOutcome=Boolean.TRUE;
                record.setOutcome(actualOutcome);
                record.setName("URL REACHABILITY");
                record.setScreenShot(screenShot);
                record.setExpectedResult("LOGIN PAGE SHOULD APPEAR");
                listOb.add(record);
            }catch (Exception e){
                log.error("",e);
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                record.setOutcome(actualOutcome);
                record.setName("URL REACHABILITY");
                record.setScreenShot(screenShot);
                record.setExpectedResult("LOGIN PAGE SHOULD APPEAR");
                listOb.add(record);
                throw new Exception("Provided URL not reachable.");
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

            //Login
            driver.manage().window().maximize();
            //SeleniumUtils.loginBIInValid(driver, listOb,username,password,clientVersionDao,san_aut_id);
            Thread.sleep(2000);
            SeleniumUtils.loginBIValid(driver, listOb,username,password,url,clientVersionDao,san_aut_id);

            //percentCount=10;                         //SAN_LOG_1, PASS, Sanity_Aut_Master_ID
            //ClientVersionDao. insertSanityTCOutcome(TC_ID,outcome)
            //PercentageCountDao.setPercentCount(percentCount);

// --------------------------------- Check Version Start-------------------------------------------------------------------
            McubeSanity_4530 obj = new McubeSanity_4530();
            String className = obj.getClass().getSimpleName();
            System.out.println("Class Name : " + className + ".");
            SeleniumUtils.checkVersion(driver, wait,listOb,className,clientVersionDao,san_aut_id);
//------------------------------------ Check Version End--------------------------------------------------------

// --------------------------------- DataUpload Start-------------------------------------------------------------------
            //DataUpload.dataUpload(driver, wait,listOb, username,clientVersionDao,san_aut_id);

//------------------------------------ DataUpload End------------------------------------------------------------
// ------------------------------------ SavedSearch Start--------------------------------------------------------------

            //SavedSearch.savedSearch(driver, wait, dataset, listOb,clientVersionDao,san_aut_id);
//------------------------------------ SavedSearch End-----------------------------------------------------------------
//------------------------------------ Widget Area Start----------------------------------------------------------------

            PreStepsForWidget.presteps(driver, wait, "Area", listOb,dataset,clientVersionDao,san_aut_id);
            widgetList.add(AreaChart.areaChart(driver, wait, listOb,clientVersionDao,san_aut_id));

//------------------------------------ Widget Area End------------------------------------------------------------------
//------------------------------------ Widget Combo Start----------------------------------------------------------------

            //PreStepsForWidget.presteps(driver, wait, "Combo", listOb,dataset,clientVersionDao,san_aut_id);
            //widgetList.add(ComboChart.comboChart(driver, wait, listOb,clientVersionDao,san_aut_id));

//------------------------------------ Widget Combo End-----------------------------------------------------------------
//------------------------------------ Widget Tree Start----------------------------------------------------------------

            PreStepsForWidget.presteps(driver, wait, "Tree Table", listOb,dataset,clientVersionDao,san_aut_id);
            widgetList.add(TreeTable.treeTable(driver, wait, listOb,clientVersionDao,san_aut_id));

//------------------------------------ Widget Tree End----------------------------------------------------------
//------------------------------------ Data Profile Start---------------------------------------------------------------
            DataProfile.dataProfile(driver, wait, listOb,clientVersionDao,san_aut_id);

//------------------------------------ Data Profile End------------------------------------------------------------------
// --------------------------------- Dashboard Start--------------------------------------------------------------

            int flag = SeleniumUtils.checkNull(widgetList);
            if(flag==1)
                Dashboard.dashboard(driver, wait, widgetList, listOb,clientVersionDao,san_aut_id);
            else
                SeleniumUtils.dashboardFailure(driver, listOb,clientVersionDao,san_aut_id);

//------------------------------------ Dashboard End---------------------------------------------------------------

//------------------------------------ Join Dataset Start---------------------------------------------------------------

            //String jdName = JoinDataset.joinDataset(driver, wait, listOb,dataset);

//------------------------------------ Join Dataset End-----------------------------------------------------------------
// --------------------------------- ArtificialIntelligence Start-------------------------------------------------------

            //ArtificialIntelligence.artificialIntelligence(driver, wait, listOb);
//------------------------------------ ArtificialIntelligence End-------------------------------------------------------------

// --------------------------------- Saved Objects Start--------------------------------------------------------------

            SavedObjects.savedObjects(driver, wait, listOb,clientVersionDao,san_aut_id);

//------------------------------------ Saved Objects End---------------------------------------------------------------
// --------------------------------- Role Start--------------------------------------------------------------
            String role = null;

            ManagementPresteps.managementPresteps(driver, wait, listOb,clientVersionDao,san_aut_id);
            role = RoleCreation.roleCreation(driver, wait, listOb,clientVersionDao,san_aut_id);

//------------------------------------ Role End---------------------------------------------------------------
// --------------------------------- User Start--------------------------------------------------------------

            UserCreation.userCreation(driver, wait,listOb,clientVersionDao,san_aut_id);

//------------------------------------ User End---------------------------------------------------------------
// --------------------------------- Workspace Start--------------------------------------------------------------

            WorkSpaceCreation.workSpaceCreation(driver, wait, listOb,clientVersionDao,san_aut_id);
            // RowAndColumnLevel.rowAndColumnLevel(driver, wait,dataset);


//------------------------------------ Workspace End---------------------------------------------------------------

        } catch (Exception e) {
            log.error("",e);
        } finally {

            if(null!=driver)
            {
                try{
                    System.out.println("Driver is quiting");
                    //driver.quit();
                }catch (Exception e) {
                    log.error("",e);
                }

            }
            System.out.println(""+listOb.size());
            listOb.forEach(e->{
                System.out.println(e.toString());
            });

            pdfFile= PdfCreator.createSanityReportPdf(listOb,url,createdBy,createdByName,client,version);
            if(null!=pdfFile){
                System.out.println("[SANITY][EMAIL] pdf found, sending email.......");
                String body="Dear Sir/Madam,<br/><br/>\n" +
                        "\t\t\n" +
                        "\t\tPlease find below the sanity test result.<br/><br/>\n" +
                        "\t\t\n" +
                        "\t\tRegards,<br/>\t\t\n" +
                        "\t\ttcg mcube QA Team<br/>";
                String subject="Sanity Test Result For URL: "+url;

                String to=mailto.equalsIgnoreCase("NA")?"":mailto;
                if(!createdBy.equalsIgnoreCase("NA")){
                    to=to+","+createdBy;
                }
                String cc=System.getenv("EMAIL_CC").equalsIgnoreCase("NA")?"":System.getenv("EMAIL_CC");
                String bcc=System.getenv("EMAIL_BCC").equalsIgnoreCase("NA")?"":System.getenv("EMAIL_BCC");

                List<File> attachments=new ArrayList<>();
                attachments.add(pdfFile);

                EmailSender.sendEmail(to,cc,bcc,body,subject,attachments);
            }else{
                System.out.println("[SANITY][EMAIL] pdf not found, not sending email.......");
            }
            Date endTime= Calendar.getInstance().getTime();
            long diff = endTime.getTime() - startTime.getTime();
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;

            DateTime endDate = new DateTime(endTime);
            DateTime endDtus = endDate.withZone(dtZone);
            System.out.println(
                    System.lineSeparator()+
                            System.lineSeparator()+"\t\t\t\t|-------------------------------------------------------|"+
                            System.lineSeparator()+"\t\t\t\t|      DURATION DETAILS                                 |"+
                            System.lineSeparator()+"\t\t\t\t|_______________________________________________________|"+
                            System.lineSeparator()+"\t\t\t\t|      START    - "+startDtus.toLocalDateTime().toDate()+"          |"+
                            System.lineSeparator()+"\t\t\t\t|      END      - "+endDtus.toLocalDateTime().toDate()+"          |"+
                            System.lineSeparator()+"\t\t\t\t|      ---------------------------------------          |"+
                            System.lineSeparator()+"\t\t\t\t|      DURATION -     "+diffMinutes+" min(s) "+diffSeconds+" sec(s)               "+(diffMinutes<10?" ":"")+(diffSeconds<10?" ":"")+"|"+
                            System.lineSeparator()+"\t\t\t\t|-------------------------------------------------------|"+
                            System.lineSeparator()
            );
        }
        return pdfFile;
    }
}