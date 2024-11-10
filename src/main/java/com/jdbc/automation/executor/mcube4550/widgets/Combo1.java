package com.jdbc.automation.executor.mcube4550.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class Combo1 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();
    public static String combo1(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        String name = "null";
        String temp="false";
        String error="";
        int n = 2;

        boolean dataLabels = true;

        boolean chart;

        boolean metrics;

        boolean xTicks;

        boolean flag = true;
        try{

            System.out.println("Inside Combo 1-----------");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            driver.findElement(By.linkText("Widget")).click();
            driver.findElement(By.linkText("Widget")).click();
            String widgetName = "Combo";
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();



            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
//            Y axis open
            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
            driver.findElement(By.xpath("(//a[@ng-click='advancedToggled = !advancedToggled'])[1]")).click();
//------------------------------------------------------------------------------------------------------
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
            driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
            Thread.sleep(2000);
            System.out.println(":About to click Data tab then X axis of bucket");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[3]")).click();
            driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")).click();

            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"2bucketSelectButtonID\"]/option[7]")).click();

            driver.findElement(By.xpath("//select[@id='2fieldSelectID']")).click();

            Thread.sleep(3000);
            System.out.println("Customer name selected");
            driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]/optgroup[3]/option[1]")).click();
//            driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]/optgroup[3]/option[13]")).click();

            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();

            for (int ycounter1 = 1; ycounter1 < 6; ycounter1++){
                System.out.println("Inside yCounter1 : "+ycounter1);
                Select drpCounter = new Select(driver.findElement(By.xpath("//select[@id='1bucketSelectButtonID']")));
                drpCounter.selectByIndex(ycounter1);
                n=2;
                int y2 = SeleniumUtils.noOfYFields(driver);
                System.out.println("y2 : "+y2);
                if ((ycounter1 == 3) || (ycounter1 == 9)) {
                    n = 2;
                }
                for (int ycounter2 = n; ycounter2 < y2; ycounter2++){
                    if(ycounter2==6)
                        continue;
                    Select drpCounter2 = new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']")));
                    drpCounter2.selectByIndex(ycounter2);
                    System.out.println("yCounter1 : "+ycounter1+" and yCounter2 :"+ycounter2);
                    if(n==2) {

                        if ((ycounter1 == 3 || ycounter1 == 9)) {
                            System.out.println("Inside counter 4, yCounter1 : " + ycounter1);
                            driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/visualize-app/div/div/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group/div/div[2]/div/ng-form/vis-editor-agg-params/div[4]/div/a/label")).click();
                            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
                        }
                        else {
                            driver.findElement(By.xpath("(//a[@ng-click='advancedToggled = !advancedToggled'])[1]")).click();
                            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
                        }
                        n++;
                        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                        driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                        Select page =  new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                        page.selectByVisibleText("All");
                        Thread.sleep(2000);

                        boolean metric = SeleniumUtils.validateMetrics_combo(driver,"Combo 1");
                        boolean y_data = SeleniumUtils.validateYData_combo(driver);
                        boolean x_data = SeleniumUtils.validateXData_combo(driver);

                        driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                        System.out.println(((((((((ycounter1 + '\t') + ycounter2) + ':') + "\nMetric; before Custom Label\t: ") + metric) + "\nY Data\t\t\t\t: ") +
                                y_data) + "\nX Data\t\t\t\t: ") + x_data);

                        System.out.println("1Metric : "+metric);


                        if ((!(metric) || !(y_data)) || !(x_data)) {
                            System.out.println("Metric : "+metric);
                            System.out.println("y_data : "+y_data);
                            System.out.println("x_data : "+x_data);
                            flag = false;

//                            WebUI.takeScreenshot()
                        }
                        //FORMAT SERIES
                        System.out.println("YPPO");
                        driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                        driver.findElement(By.xpath("//input[@id='2stringInputID']")).sendKeys("asdfgh");
                        driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                        System.out.println("Start of combo1 for ycounter1 : "+ycounter1);
                        //GlobalVariable.ColorPickerLength

                        //=======================COlor picker commented by AG
                        int ColorPickerLength=1;
//                        for (int iIndex1 = 1; iIndex1 <=ColorPickerLength; iIndex1++){
//                            System.out.println("Inside color picker");
//                            if (iIndex1 == 47) {
//                                System.out.println("Continued");
//                                continue;
//                            }
//                            else{
//                                System.out.println("Inside else of If");
//                                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
//                                if (ycounter2 == 2){
//                                    driver.findElement(By.xpath("//input[@id='1stringInputID']")).sendKeys("asd");
//                                }
//                                else{
//                                    driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
//                                    driver.findElement(By.xpath("//input[@id='1stringInputID']")).sendKeys("asd");
//                                }
//                                String path1 = "(('//*[@class=\'colorpicker dropdown position-top\']/div[@class='tab-colorbox']/div[' + iIndex1) + ']/div[@class=\'color-unit\']')";
//
////                                WebUI.focus(findTestObject('Combo- 1/Page_mcube/div_Series Color_circle-inner'))
//
//                                WebElement colorCircleInner = driver.findElement(By.xpath("(//div[@class=\"circle-inner\"])[4]"));
//                                colorCircleInner.click();
//                                System.out.println("colorCircleInner" + colorCircleInner);
//                                Thread.sleep(2000);
//                                driver.findElement(By.xpath("(//div[@class='colorpicker-circle'])")).click();
//                                Thread.sleep(2000);
//
///*                                need to convert(Jayisha)
//                                colorBox1 = WebUI.modifyObjectProperty(findTestObject('Combo- 1/Page_mcube/div_Wheel_color-unit'), 'xpath',
//                                        'equals', path1, true)
//
//                                WebUI.focus(colorBox1)
//
//                                WebUI.scrollToElement(colorBox1, GlobalVariable.WaitPeriod)
//
//                                WebUI.click(colorBox1)
//
// */
//// By Banamali
//                                WebElement colorBox1 = driver.findElement(By.xpath(path1));
//                                Actions actions = new Actions(driver);
//                                actions.moveToElement(colorBox1).perform();
//                                colorBox1.click();
//                                driver.findElement(By.xpath("(//div[@class=\"select\"])[4]")).click();
//                                System.out.println("colorBox1 sucessfully selected");
////                    SeleniumUtils.clickSelectButton("colorpicker dropdown position-left");
//                                Thread.sleep(2000);
//
//
//                                SeleniumUtils.clickSelectButton("'colorpicker dropdown position-top'",driver);
//                                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
//                                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
//                                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
//                                Thread.sleep(2000);
//                                Thread.sleep(2000);
//                                metric = SeleniumUtils.validateMetrics_combo(driver,"Combo 1");
//                                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-down']")).click();
//                                boolean seriesColor = SeleniumUtils.validateSeriesColor(iIndex1,driver);
//                                System.out.println("HALTTTTTTTTTTTTT");
//                                System.out.println("Metric; after Custom Label: " + metric);
//
//                               System.out.println("Series Color\t: " + seriesColor);
//                                if (!(metric) || !(seriesColor)) {
//                                    flag = false;
//
////                                    WebUI.takeScreenshot()
//                                }
//                            }
//                        }
                        //==========================
                        //END OF FORMAT SERIES
                        //CLEAR TEXT
                        driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                        driver.findElement(By.xpath("//input[@id='2stringInputID']")).clear();
                        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group[2]/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
                        System.out.println("Intermdeiate of combo1 for ycounter1 : "+ycounter1);
                        driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
                        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                        driver.findElement(By.xpath("//input[@id='1stringInputID']")).click();
                        driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
//                        End of clear text
                        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                        driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();

                        System.out.println("End of combo1 for ycounter1 : "+ycounter1);



                    }

                }
                if (flag == true) {
                    System.out.println("Combo chart 1 passed");
//                    KeywordUtil.markPassed("Combo Chart Test1 Case Passed")
                } else {
                    System.out.println("Combo chart 1 failed");
//                    KeywordUtil.markFailed("Combo Chart Test1 Case Failed")
                }
            }

            Random rand = new Random();
            name = "Mcube_ComboChart1_"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);
            System.out.println("temp : "+temp);
            Thread.sleep(2000);

        }
        catch (Exception e) {
            System.out.println("Catch e:"+e);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
            Thread.sleep(3000);
            WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
            SeleniumUtils.clickModal(driver, webEl);
            Thread.sleep(2000);
            log.error("",e);
        }
        finally {

            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-COMBO-01");
            record.setOutcome(actualOutcome);
            record.setName("COMBO Chart.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Combo chart completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);
            System.out.println("Inside  finally of Combo1");
            if (!actualOutcome && temp.equals("false")) {
                System.out.println("Combo chart creation failed.");
                return "null";
            }
            else
                return name;
        }

    }
//


}
