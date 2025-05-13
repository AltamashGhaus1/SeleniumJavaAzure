package com.jdbc.automation.executor.mcube510.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class VerticalBar1 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();


    public static String verticalbar1(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        String name = "null";
        String temp="false";
        int n = 2;
        boolean dataLabels = true;
        boolean chart=true;
        boolean metrics=true;
        boolean xTicks=true;
        boolean flag = true;
        Robot rb = new Robot();
        String fontSize = "10|20|30|40|50|200";
        String[] font_Size = fontSize.split("\\|");
        int ColorPickerLength = 1;

//        rb.keyPress(KeyEvent.VK_F11);
        try{
            System.out.println("Inside Vertical bar 1.............");


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            driver.findElement(By.linkText("Widget")).click();
            driver.findElement(By.linkText("Widget")).click();
            String widgetName = "Combo";
            screenShot.add(com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            screenShot.add(com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();



            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
            Select drpdown1 =  new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
            drpdown1.selectByVisibleText("Terms");
            Select drpdown2 =  new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
            drpdown2.selectByVisibleText("LOC_STATE");
            driver.findElement(By.xpath("//i[@id='2metricExpandButtonIID']")).click();
            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
            for (int ycounter1 = 1; ycounter1 < 6; ycounter1++) {
                Select drpdown3 = new Select(driver.findElement(By.xpath("//select[@id='1bucketSelectButtonID']")));
                drpdown3.selectByIndex(ycounter1);
                int y2 = SeleniumUtils.noOfYFields(driver);
                if ((ycounter1 == 4) || (ycounter1 == 5)) {
                    n = 3;
                }
                for (int ycounter2 = n; ycounter2 < y2; ycounter2++) {
                    Select drpdown4 = new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']")));
                    drpdown4.selectByIndex(ycounter2);
                    if (ycounter2 == n) {
                        driver.findElement(By.xpath("//i[@id='formatSeriesID']")).click();
                        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

                    }
                    driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                    driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                    Select drpdownAll = new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']")));
                    drpdownAll.selectByVisibleText("All");
                    Thread.sleep(2000);
                    chart = SeleniumUtils.validateChartFormation(driver);
                    if (chart) {
                        dataLabels = SeleniumUtils.validateDataLabels(driver);
                    }
                    metrics = SeleniumUtils.validateMetrics(driver);
                    xTicks = SeleniumUtils.validateXAxisLabels(driver);
                    driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div[2]/visualize/visualize-spy/div/div/i")).click();
                    System.out.println(((ycounter1 + '\t') + ycounter2) + ':');

                    System.out.println((((((("Chart Formation : " + chart) + "\nData Labels\t: ") + dataLabels) + "\nMetrics\t\t: ") + metrics) + "\nX Ticks\t\t: ") + xTicks);
                    driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                }
                if ((!(dataLabels) || !(metrics)) || !(xTicks)) {
                    flag = false;

//                    WebUI.takeScreenshot()
                }
                //Y AXIS TAB
                driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
                driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
                for (int iIndex1 = 0; iIndex1 < 1; iIndex1++) {
                    String InputFontSize1 = (font_Size[iIndex1]);
                    driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[4]")).sendKeys(InputFontSize1);
                    for (int iIndex2 = 1; iIndex2 <= ColorPickerLength; iIndex2++) {
                        if (iIndex2 == 47) {
                            continue;
                        } else {
                            String path1 = "(('//*[@class=\'colorpicker dropdown position-left\']/div[2]/div[' + iIndex2) + ']/div')";
                            System.out.println(path1);
//                            WebUI.focus(findTestObject('VB-DP Mega/Y Axis/div_Italic_circle-inner'))    Need to convert
                            driver.findElement(By.xpath("//div[@id='Tick Font']/div/div/div/div")).click();
                            Thread.sleep(2000);

//                           ----------- Need to convert------------
//                            colorBox1 = WebUI.modifyObjectProperty(findTestObject('VB-DP Mega/Y Axis/div_Wheel_color-unit'), 'xpath',
//                                    'equals', path1, true)
//
//                            WebUI.focus(colorBox1)
//
//                            WebUI.scrollToElement(colorBox1, GlobalVariable.WaitPeriod)
//                            WebUI.click(colorBox1)

                            SeleniumUtils.clickSelectButton(driver, "colorpicker dropdown position-left");
                            for (int iIndex3 = 0; iIndex3 < 1; iIndex3++) {
                                String InputFontSize2 = (font_Size[iIndex3]);
                                driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[5]")).sendKeys(InputFontSize2);
                                for (int iIndex4 = 1; iIndex4 <= ColorPickerLength; iIndex4++) {
                                    if (iIndex4 == 47) {
                                        continue;
                                    } else {
                                        String path2 = "(('//*[@class=\'colorpicker dropdown position-left\']/div[2]/div[' + iIndex4) +']/div')";
                                        System.out.println(path2);
//                                        WebUI.focus(findTestObject('VB-DP Mega/Y Axis/div_Italic_circle-inner (1)'))   Need to convert
                                        driver.findElement(By.xpath("//div[@id='Title Font']/div/div/div/div")).click();
                                        Thread.sleep(2000);

//                                        ----------------Need to convert-----------------------
//                                        colorBox2 = WebUI.modifyObjectProperty(findTestObject('VB-DP Mega/Y Axis/div_Wheel_color-unit (1)'),
//                                                'xpath', 'equals', path2, true)
//
//                                        WebUI.waitForElementVisible(colorBox2, GlobalVariable.WaitPeriod)
//
//                                        WebUI.scrollToElement(colorBox2, GlobalVariable.WaitPeriod)
//
//                                        WebUI.click(colorBox2)

                                        SeleniumUtils.clickSelectButton(driver, "colorpicker dropdown position-left");
                                        for (int iIndex5 = 1; iIndex5 <= ColorPickerLength; iIndex5++) {
                                            if (iIndex5 == 47) {
                                                continue;
                                            } else {
                                                String path3 = "(('//*[@class=\'colorpicker dropdown position-left\']/div[2]/div[' + iIndex5) +']/div')";
                                                System.out.println(path3);
//                                                WebUI.focus(findTestObject('VB-DP Mega/Y Axis/div_Axis Line Color_circle-inner'))     Need to convert
                                                driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div/vis-editor-sidebar/div/form/div[3]/vis-editor-vis-options/div/div/div/div[2]/div/ng-transclude/fieldset/div[4]/div/label/div/div")).click();
                                                Thread.sleep(1000);
//                                          -------------------Need to convert-------------------------------------------
//                                                colorBox3 = WebUI.modifyObjectProperty(findTestObject('VB-DP Mega/Y Axis/div_Wheel_color-unit (2)'),
//                                                        'xpath', 'equals', path3, true)
//
//                                                WebUI.waitForElementVisible(colorBox3, GlobalVariable.WaitPeriod)
//
//                                                WebUI.scrollToElement(colorBox3, GlobalVariable.WaitPeriod)
//
//                                                WebUI.click(colorBox3)

                                                SeleniumUtils.clickSelectButton(driver, "colorpicker dropdown position-left");
                                                for (int iIndex6 = 0; iIndex6 < 1; iIndex6++) {
                                                    String InputFontSize3 = (font_Size[iIndex6]);
                                                    driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[4]")).sendKeys(InputFontSize3);
                                                    for (int iIndex7 = 1; iIndex7 <= ColorPickerLength; iIndex7++) {
                                                        if (iIndex7 == 47) {
                                                            continue;
                                                        } else {
                                                            String path4 = "(('//*[@class=\\'colorpicker dropdown position-top\\']/div[2]/div[' + \n" + "  iIndex7) + ']/div')";
                                                            System.out.println(path4);

//                                                            WebUI.focus(findTestObject('VB-DP Mega/X Axis/div_Italic_circle-inner'))   Need to convert
                                                            driver.findElement(By.xpath("(//div[@id='Tick Font']/div/div/div/div)[2]")).click();
                                                            Thread.sleep(1000);

//                                                            ---------------Need to convert---------------------------------------
//                                                            colorBox4 = WebUI.modifyObjectProperty(findTestObject('VB-DP Mega/X Axis/div_Wheel_color-unit'),
//                                                                    'xpath', 'equals', path4, true)
//
//                                                            WebUI.waitForElementVisible(colorBox4, GlobalVariable.WaitPeriod)
//
//                                                            WebUI.scrollToElement(colorBox4, GlobalVariable.WaitPeriod)
//
//                                                            WebUI.click(colorBox4)
                                                            SeleniumUtils.clickSelectButton(driver, "colorpicker dropdown position-top");
                                                            for (int iIndex8 = 0; iIndex8 < 1; iIndex8++) {
                                                                String InputFontSize4 = (font_Size[iIndex8]);
                                                                driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[5]")).sendKeys(InputFontSize4);
                                                                for (int iIndex9 = 1; iIndex9 <= ColorPickerLength; iIndex9++) {
                                                                    if (iIndex9 == 47) {
                                                                        continue;
                                                                    } else {
                                                                        String path5 = " (('//*[@class=\'colorpicker dropdown position-top\']/div[2]/div[' + iIndex9) + ']/div')";
                                                                        System.out.println(path5);
//                                                                        WebUI.focus(findTestObject('VB-DP Mega/X Axis/div_Italic_circle-inner (1)'))   Need to convert
                                                                        driver.findElement(By.xpath("(//div[@id='Title Font']/div/div/div/div)[2]")).click();
                                                                        Thread.sleep(1000);

//                                                    ---------------------------------- Need to convert--------------------------------------------
                                                                        SeleniumUtils.clickSelectButton(driver, "colorpicker dropdown position-top");
                                                                        for (int iIndex10 = 1; iIndex10 <= ColorPickerLength; iIndex10++) {
                                                                            if (iIndex10 == 47) {
                                                                                continue;
                                                                            } else {
                                                                                String path6 = "(('//*[@class=\'colorpicker dropdown position-top\']/div[2]/div[' +iIndex10) + ']/div')";
                                                                                System.out.println(path6);
//                                                                                WebUI.focus(findTestObject('VB-DP Mega/X Axis/div_Axis Line Color_circle-inner'))   Need to convert

                                                                                driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[3]/visualize-app/div/div/vis-editor-sidebar/div/form/div[3]/vis-editor-vis-options/div/div/div/div[2]/div/ng-transclude/fieldset[2]/div[5]/div/label/div/div")).click();
                                                                                Thread.sleep(1000);

//                                                                               -----------------Need to convert-------------------------

//                                                                                colorBox6 = WebUI.modifyObjectProperty(findTestObject(
//                                                                                                'VB-DP Mega/X Axis/div_Wheel_color-unit (2)'),
//                                                                                        'xpath', 'equals', path6, true)
//
//                                                                                WebUI.waitForElementVisible(colorBox6, GlobalVariable.WaitPeriod)
//
//                                                                                WebUI.scrollToElement(colorBox6, GlobalVariable.WaitPeriod)
//
//                                                                                WebUI.click(colorBox6)

                                                                                SeleniumUtils.clickSelectButton(driver, "colorpicker dropdown position-top");
                                                                                driver.findElement(By.xpath("//input[@id='mCubeVFCPrefixID']")).sendKeys("pre");
                                                                                driver.findElement(By.xpath("//input[@id='mCubeVFCSuffixID']")).sendKeys("suff");
                                                                                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                                                                                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
                                                                                Thread.sleep(5000);
                                                                                boolean Result2 = SeleniumUtils.validateYTickFontColor(driver, iIndex2);
                                                                                boolean Result4 = SeleniumUtils.validateYTitleFontColor(driver, iIndex4);
                                                                                boolean Result5 = SeleniumUtils.validateYAxisColor(driver, iIndex5);
                                                                                boolean Result8 = SeleniumUtils.validateFontSizeXTick(driver, InputFontSize3);
                                                                                boolean Result9 = SeleniumUtils.validateXTickFontColor(driver, iIndex7);
                                                                                boolean Result10 = SeleniumUtils.validateFontSizeXTitle(driver, InputFontSize4);
                                                                                boolean Result11 = SeleniumUtils.validateXTitleFontColor(driver, iIndex9);
                                                                                boolean Result12 = SeleniumUtils.validateXAxisColor(driver, iIndex10);
                                                                                boolean Result13 = SeleniumUtils.validatePrefixXTick(driver, "pre");
                                                                                boolean Result14 = SeleniumUtils.validateSuffixXTick(driver, "suff");
                                                                                System.out.println("\nY Ticks Font Color:\t' + Result2 + '\nY Title Font Color:\t' + Result4 + '\nY Axis Color:\t\t' + Result5 + '\nX Ticks Font Size:\t' + Result8 + '\nX Ticks Font Color:\t' + Result9 + '\nX Title Font Size:\t' + Result10 + '\nX Title Font Color:\t' + Result11 + '\nX Axis Color:\t\t' + Result12 + '\nX Ticks Prefix: \t' + Result13 + '\nX Ticks Suffix: \t' + Result14");

                                                                                if (!Result2 || !Result4 || !Result5 || !Result8 || !Result9 || !Result10 || !Result11 || !Result12 || !Result13 || !Result14) {

//                                                                                    WebUI.takeScreenshot()

                                                                                    flag = false;

//                                                                                    WebUI.takeScreenshot()


                                                                                }
                                                                            }

                                                                        }
                                                                    }

                                                                }
                                                            }
                                                        }
                                                    }


                                                }
                                            }
                                        }
                                    }

                                }


                            }
                        }

                    }
                }
                driver.findElement(By.xpath("//input[@id='mCubeVFCPrefixID']")).clear();
                driver.findElement(By.xpath("//input[@id='mCubeVFCSuffixID']")).clear();
                driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
                driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
                driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();

                if (flag == true) {
                    System.out.println("Vertical bar 1 passed");
                } else {
                    System.out.println("Vertical bar 1 failed");
                }

            }
        }
        catch (Exception e) {
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
            record.setTestCaseName("SAN-VB-01");
            record.setOutcome(actualOutcome);
            record.setName("Vertical bar.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Vertical bar completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome && temp.equals("false")) {
                log.info("Vertical bar creation failed.");
                return "null";
            }
            else
                return name;
        }
    }

}

