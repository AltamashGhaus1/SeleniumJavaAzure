//package com.jdbc.automation.executor.mcube510.Miscellaneous;
//
//import com.jdbc.automation.executor.Common.Records;
//import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
//import com.jdbc.automation.executor.mcube510.widgets.TreeTable;
//import com.jdbc.dao.ClientVersionDao;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import static com.jdbc.automation.executor.Common.Records.actualOutcome;
//
//public class ScriptedField_1 {
//    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
//    static Records rec = new Records();
//
//
//    public static String scriptedField_1(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        Records record = new Records();
//        List<File> screenShot = new ArrayList<>();
//        String name = "null";
//        String temp="false";
//        boolean key1 = false;
//        boolean key2 = false;
//        boolean key3 = false;
//        boolean key4 = false;
//        boolean key5 = false;
//        String stepfailed="";
//        String steppassed="";
//        boolean flag= true;
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
//
//        String sf1 = "new_scripted_field" + now.format(formatter);
//        String ss1 = "save_search_" + now.format(formatter);
//        String w1 = "area_" + now.format(formatter);
//        String d1 = "dashboard_" + now.format(formatter);
//        try{
//            System.out.println("Inside scripted field....");
//            driver.findElement(By.xpath("//div[@id='AdministrationglobalTitleID']")).click();
//            driver.findElement(By.xpath("(//a[@class='management-link ng-binding'])[1]")).click();
//            driver.findElement(By.xpath("(//a[@class='management-link ng-binding'])[1]")).sendKeys(dataset);
//
////            driver.findElement(By.xpath("(//div[@class='sidebar-item-title '])[1]")).click();
//            driver.findElement(By.linkText(dataset)).click();
//            System.out.println("Dataset is clicked : "+dataset);
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//li[@class='kbn-management-tab']")).click();
//            Thread.sleep(2000);
//
//             try {
//                driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/scripted-fields/header/a")).click();
//            } catch (Exception e) {
//                driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/scripted-fields/paginated-table/paginate/div/table/tbody/tr/td[5]/div/a/i")).click();
//            }
//
//             driver.findElement(By.c)
//
//             driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/scripted-fields/paginated-table/paginate/div/table/tbody/tr/td[5]/div/a/i")).click();
//            Actions action1 = new Actions(driver);
//
//            action1.moveToElement(driver.findElement(By.xpath("(//button[@type='button'])[4]")));
//
//            action1.doubleClick().build().perform();
//            Actions action2 = new Actions(driver);
//
//            action2.moveToElement(driver.findElement(By.xpath("(//button[@type='button'])[4]")));
//
//            action2.doubleClick().build().perform();
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/scripted-fields/paginated-table/paginate/div/table/thead/tr/th/i")).click();
//            //Str to capture before asc
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/scripted-fields/paginated-table/paginate/div/table/thead/tr/th/i")).click();
////New Str to capture after asc //if(!str.equals(newstr)) - Validation
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/div/scripted-fields/paginated-table/paginate/div/table/thead/tr/th/i")).click();
//            Select value1 = new Select(driver.findElement(By.xpath("(//select[@id='PCPageSizeID'])[2]")));
//            value1.selectByValue("number:10");
//            Select value2 = new Select(driver.findElement(By.xpath("(//select[@id='PCPageSizeID'])[2]")));
//            value2.selectByValue("number:25");
//            Select value3 = new Select(driver.findElement(By.xpath("(//select[@id='PCPageSizeID'])[2]")));
//            value3.selectByValue("number:10");
//            boolean r1= SeleniumUtils.checkpagesize_twentyfive(driver);
//            driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/field-editor/form/div/input")).sendKeys(sf1);
//            Actions action3 = new Actions(driver);
//
//            action3.moveToElement(driver.findElement(By.xpath("//button[@type='button']")));
//
//            action3.doubleClick().build().perform();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            Select value4 = new Select(driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/field-editor/form/div[6]/div/select")));
//            value4.selectByValue("string:Inline");
//
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/kbn-management-app/div/div/kbn-management-indices/div[2]/field-editor/form/div[6]/div[2]/textarea")).sendKeys("\\'doc[\"Sales\"].value + 200\\'");
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            driver.findElement(By.xpath("//div[@id='ExploreglobalTitleID']")).click();
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/discover-app/div/div[2]/div/disc-field-chooser/div/div/div")).click();
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/discover-app/div/div[2]/div/disc-field-chooser/div/div/div[2]/ul/li[4]")).click();
//            driver.findElement(By.xpath("//div[@id='KGTPTimePickerBtnID']/pretty-duration")).click();
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/kbn-timepicker/div/div[2]/div/div[2]/div/ul/li[2]/a")).click();
//
//            Select value5 = new Select(driver.findElement(By.xpath("(//div[@class='form-group'])[2]")));
//            value5.selectByValue("string:y");
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/kbn-timepicker/div/div/i")).click();
//            try{
//                key1 = SeleniumUtils.clickAdd(driver,sf1);
//                System.out.println("Key1-------"+key1);
//
//            }
//            catch(Exception e)  {
//                stepfailed =  stepfailed + "Verify adding field failed";
//            }
//            driver.findElement(By.xpath("//div[@id='KTNdiscoverSaveButtonLocalMenuID']")).click();
//            driver.findElement(By.xpath("//input[@id='SaveSearch']")).sendKeys(ss1);
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            try {
//                key2=SeleniumUtils.verifyssname(driver,ss1);
//                System.out.println("Key2-------"+key2);
//            }
//            catch(Exception e)  {
//                stepfailed = stepfailed + "Verify name of save search failed";
//            }
//            driver.findElement(By.xpath("//div[@id='WidgetglobalTitleID']")).click();
//            driver.findElement(By.xpath("//img[@id='areachartImgID']")).click();
//            driver.findElement(By.xpath("//a[@id='PSLindex-pattern:admin_timebased_dataset_1URLAhitID']")).click();
//            driver.findElement(By.xpath("//div[@id='bucketAddButtonID']")).click();
//            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[1]")).click();
//            Select value6 = new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
//            value6.selectByVisibleText("Sum");
//            Select value7 = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
//            value7.selectByValue(sf1);
//            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
//            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
//            Select value8 = new Select(driver.findElement(By.xpath("//select[@id='3bucketSelectButtonID']")));
//            value8.selectByVisibleText("Terms");
//            Select value9 = new Select(driver.findElement(By.xpath("//select[@id='3fieldSelectID']")));
//            value9.selectByValue("City");
//            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
//            driver.findElement(By.xpath("//div[@id='KTNvisualizeSaveButtonLocalMenuID']")).click();
//            driver.findElement(By.xpath("//input[@name='visTitle']")).sendKeys(w1);
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            try {
//                key3=SeleniumUtils.verifywidgetname(driver,w1);
//                System.out.println("Key3-------"+key3);
//            }
//            catch(Exception e)  {
//                stepfailed =  stepfailed + "Verify name of widget failed";
//            }
//            driver.findElement(By.xpath("//div[@id='DashboardglobalTitleID']")).click();
//            driver.findElement(By.xpath("//div[@id='KTNdashboardAddPanelButtonLocalMenuID']")).click();
//            driver.findElement(By.xpath("//input[@id='SOFWidgetsID']")).sendKeys(ss1);
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/div/ul/li[2]/a")).click();
//            driver.findElement(By.xpath("//input[@id='SOFSaved SearchesID']")).sendKeys(ss1);
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/div/div[3]/saved-object-finder/paginate/ul/li[2]/a[2]/span")).click();
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/div/ul/li/a")).click();
//            driver.findElement(By.xpath("//input[@id='SOFWidgetsID']")).sendKeys(w1);
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/div/div[3]/saved-object-finder/paginate/ul/li[2]/a[2]/span")).click();
//            driver.findElement(By.xpath("//div[@id='template_wrapper']/div/div[2]/i")).click();
//            driver.findElement(By.xpath("//div[@id='dashboard-scroll']/dashboard-grid/ul/li/span[3]")).click();
//            driver.findElement(By.xpath("//div[@id='dashboard-scroll']/dashboard-grid/ul/li[2]/dashboard-panel/div/div")).click();
//            driver.findElement(By.xpath("//html")).click();
//            driver.findElement(By.xpath("//div[@id='KTNdashboardSaveButtonLocalMenuID']")).click();
//
//            driver.findElement(By.xpath("//input[@id='dashboardTitle']")).sendKeys(w1);
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            try {
//                key4=SeleniumUtils.verifydashboardname(driver,d1);
//                System.out.println("Key4-------"+key4);
//            }
//            catch(Exception e)  {
//                stepfailed =  stepfailed + "Verify name of dashboard failed";
//            }
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/dashboard-app/kbn-top-nav/div/div/div/div[3]/div[3]/div")).click();
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/dashboard-app/kbn-top-nav/div/div/div/div[3]/div[3]/div/span[2]/span/ul/li[4]/a")).click();
//            driver.findElement(By.xpath("//body[@id='kibana-body']/div[11]/div[2]/div/div[4]/div[2]/button[2]")).click();
//            try {
//                key5=SeleniumUtils.verifylogout(driver);
//                System.out.println("key5-------"+key5);
//            }
//            catch(Exception e)  {
//                stepfailed =  stepfailed + "Verify logging out from Mcube failed";
//            }
//            Thread.sleep(3000);
//            if (key1 == false) {
//                stepfailed = stepfailed + "Verify adding field failed";
//                System.out.println("Stepfailed--"+stepfailed);
//
//                flag = false;
//            } else {
//                steppassed = steppassed +"Verify adding field passed";
//                System.out.println("steppassed--"+steppassed);
//            }
//
//            if (key2 == false) {
//                stepfailed = stepfailed + "Verify name of save search failed";
//                System.out.println("Stepfailed--"+stepfailed);
//                flag = false;
//            } else {
//                steppassed = steppassed +"Verify name of save search passed";
//                System.out.println("steppassed--"+steppassed);
//            }
//            if (key3 == false) {
//                stepfailed = stepfailed +  "Verify name of widget failed";
//                System.out.println("Stepfailed--"+stepfailed);
//                flag = false;
//            } else {
//                steppassed = steppassed + "Verify name of widget passed";
//                System.out.println("steppassed--"+steppassed);
//            }
//            if (key4 == false) {
//                stepfailed = stepfailed + "Verify name of dashboard failed";
//                System.out.println("Stepfailed--"+stepfailed);
//                flag = false;
//            } else {
//                steppassed = steppassed +"Verify name of dashboard passed";
//                System.out.println("steppassed--"+steppassed);
//            }
//            if (key5 == false) {
//                stepfailed = stepfailed + "Verify logging out from Mcube failed";
//                System.out.println("Stepfailed--"+stepfailed);
//                flag = false;
//            } else {
//                steppassed = steppassed +"Verify logging out from Mcube passed";
//                System.out.println("steppassed--"+steppassed);
//            }
//
//
//        }
//        catch (Exception e) {
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//            actualOutcome = false;
//            driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
//            Thread.sleep(3000);
//            WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
//            SeleniumUtils.clickModal(driver, webEl);
//            Thread.sleep(2000);
//            log.error("",e);
//        }
//        finally {
//
//            record.setSan_aut_id(san_aut_id);
//            record.setTestCaseName("Scripted Field_1");
//            record.setOutcome(actualOutcome);
//            record.setName("Scripted field.");
//            record.setScreenShot(screenShot);
//            record.setExpectedResult("Scripted field completed successfully.");
//            clientVersionDao.setRecordDetails(record);
//
//            listOb.add(record);
//
//            if (!actualOutcome && temp.equals("false")) {
//                log.info("Combo chart creation failed.");
//                return "null";
//            }
//            else
//                return name;
//        }
//    }
//
//}
