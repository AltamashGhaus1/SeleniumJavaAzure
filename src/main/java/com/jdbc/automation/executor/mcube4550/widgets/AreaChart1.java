//package com.jdbc.automation.executor.mcube4550.widgets;
//
//import com.jdbc.automation.executor.Common.Records;
//import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
//import com.jdbc.dao.ClientVersionDao;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import static com.jdbc.automation.executor.Common.Records.actualOutcome;
//
//public class AreaChart1 {
//    static int iIndex1;
//    static int ycounter1;
//    static int ycounter2;
//    static int n;
//    static int iIndex2;
//    static int iIndex3;
//    static int iIndex4;
//    static int iIndex5;
//    static int iIndex6;
//    static int iIndex7;
//    static int iIndex8;
//    static int iIndex9;
//    static int iIndex10;
//    static boolean chart;
//    static boolean dataLabels;
//    static boolean metrics;
//    static boolean xTicks;
//    static boolean flag;
//    static boolean yAxisFormat;
//    static  Object InputFontSize1;
//    static  Object InputFontSize4;
//    static boolean Result1 ;
//    static boolean Result2 ;
//    static boolean Result3 ;
//    static boolean Result4 ;
//    static boolean Result5 ;
//    static boolean Result6 ;
//    static boolean Result7 ;
//    static boolean Result8 ;
//    static boolean Result9 ;
//    static boolean Result10 ;
//    static boolean Result11 ;
//    static boolean Result12 ;
//    static boolean Result13 ;
//    static boolean Result14 ;
//    private static final Logger log= LoggerFactory.getLogger(AreaChart1.class);
//    static Records rec = new Records();
//
//    public static <JavascriptExecutor> String areaChart(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception {
//
//        Records record = new Records();
//
//        List<File> screenShot = new ArrayList<>();
//
//        String name = "null";
//        String temp = "false";
////        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
//
//        try {
//            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
////            SeleniumUtils.yDataFill(driver, wait,"Area1");
////            screenShot.add(SeleniumUtils.takeScreenShot(driver));
////            SeleniumUtils.xDataFill(driver, wait,"Area1");
////            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
//            driver.findElement(By.linkText("Widget")).click();
//            driver.findElement(By.linkText("Widget")).click();
//            String widgetName = "Area";
//            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
//            driver.findElement(By.linkText(widgetName)).click();
//            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
//            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
//            driver.findElement(By.linkText(dataset)).click();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bucketAddButtonID")));
//            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
//            driver.findElement(By.xpath("(//li[@id=\"bucketButtonAddLabelID\"])[2]")).click();
//            Select dropDownAggrigation = new Select(driver.findElement(By.xpath("//select[@id=\'2bucketSelectButtonID\']")));
//            dropDownAggrigation.selectByVisibleText("Terms");
//            Select dropDownField = new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
//            dropDownField.selectByVisibleText("City");
//            driver.findElement(By.xpath("//i[@id ='2metricExpandButtonIID']")).click();
//            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
//            Thread.sleep(2000);
//            for (ycounter1 = 1; ycounter1 < 5 ; ycounter1++) {
//                new Select(driver.findElement(By.xpath("//select[@id='1bucketSelectButtonID']"))).selectByIndex(ycounter1);
//                int y2;
//                y2 = SeleniumUtils.noOfYFields(driver);
//                System.out.println(y2);
//                if ((ycounter1 == 3) || (ycounter1 == 4)) {
//                    n = 3;
//                    for (ycounter2 = n; ycounter2 < y2; ycounter2++) {
//
//                        new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']"))).selectByIndex(ycounter2);
//                        if (ycounter2 == n) {
//                            driver.findElement(By.xpath("(//i[@id='formatSeriesID'])[1]")).click();
//                            System.out.println("Clicked on Format Series ");
//                            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
//                            System.out.println("Select CheckBox");
//                            driver.findElement(By.xpath("//input[@id='mCubeVFNRegID']")).sendKeys("00.00");
//                        }
//                        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
//                        System.out.println("Close expand matrics");
//                        driver.findElement(By.xpath("(//i[@id = 'SBIID'])[1]")).click();
//                        driver.findElement(By.xpath("//i[@class=\"fa fa-chevron-circle-up\" or @class=\"fa fa-chevron-circle-down\"]")).click();
//                        System.out.println("Click spy mode");
//                        new Select(driver.findElement(By.xpath("//select[@id='PCPageSizeID']"))).selectByValue("number:0");
//                        chart = SeleniumUtils.validateChartFormation1(driver);
//                        System.out.println(chart);
//                        if (chart) {
//                          dataLabels = SeleniumUtils.validateDataLabels1(driver);
//                            System.out.println("Data Labels : "+dataLabels);
//                        }
//
//                        driver.findElement(By.xpath("//i[@class=\"fa fa-chevron-circle-up\" or @class=\"fa fa-chevron-circle-down\"]")).click();
//                        metrics = SeleniumUtils.validateMetrics(driver);
//
//                        xTicks = SeleniumUtils.validateXAxisLabels(driver);
//                        driver.findElement(By.xpath("//i[@class=\"fa fa-chevron-circle-down\"]"));
//                        System.out.println(((ycounter1 + '\t') + ycounter2) + ':');
//                        System.out.println("Chart Formation: " + chart);
//                        System.out.println("Data Labels: " + dataLabels);
//                        System.out.println("Metrics: " + metrics);
//                        System.out.println("X Ticks: " + xTicks);
//                        if ((!(dataLabels) || !(metrics)) || !(xTicks)) {
//                            //flag = false
//                            flag = true;
//                            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                        }
////                        Boolean matricks =
//
//                        //========Click on OPTION============
//
//                        driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
//
//                        driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
//
//                        yAxisFormat = driver.findElement(By.xpath("(//fieldset[@class=\"custom-fieldset \"])[1]")).isDisplayed();
//                        if (yAxisFormat) {
////                            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[2]")).sendKeys("13");
//
//                            for (iIndex1 = 0; iIndex1 <= 1; iIndex1++) {
//                                //YTick font size
//                                Object[] font_Size = new Object[iIndex1];
//                                Object InputFontSize1 = (font_Size);
//                                driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[2]")).sendKeys(InputFontSize1.toString());
//                                int ColorPickerLength = 1;
//                                for (iIndex2 = 1; iIndex2 <= ColorPickerLength; iIndex2++) {
//                                    if (iIndex2 == 47) {
//                                        continue;
//                                    } else {
//                                        String s = " + iIndex2) + ";
//                                        WebElement path1 = driver.findElement(By.xpath("//*[@class=\\'colorpicker dropdown position-left\\']/div[2]/div['" + s + "']/div"));
//                                        System.out.println(String.valueOf(path1));
//                                        WebElement italicCircleInner = driver.findElement(By.xpath("//div[contains(@class, 'Italic_circle-inner')]"));
////                                    focusElement(driver, italicCircleInner);
//                                        italicCircleInner.click();
//                                        WebElement colorBox1 = driver.findElement(By.xpath("//body[@id='kibana-body']/div[8]" + path1));
//                                        colorBox1.click();
//                                        for (iIndex3 = 0; iIndex3 < 1; iIndex3++) {
//                                            WebElement InputFontSize2 = driver.findElement(By.id("i(//input[@id='mCubeVFInputID'])[3]"));
//                                            InputFontSize2.sendKeys((CharSequence) font_Size[iIndex3]);
//                                            for (iIndex4 = 1; iIndex4 <= ColorPickerLength; iIndex4++) {
//                                                if (iIndex4 == 47) {
//                                                    continue;
//                                                } else {
//                                                    String path2 = "//*[@class='colorpicker dropdown position-left']/div[2]/div[" + iIndex4 + "]/div";
////                                                WebUI.focus(findTestObject('Area-DPMegaOptions/y axis/Page_mcube/div_Italic_circle-inner (1)'))
//                                                    driver.findElement(By.xpath("//div[@id='Title Font']/div/div/div/div")).click();
//                                                    WebElement colorbox2 = driver.findElement(By.xpath("(//div[@class=\"circle-inner\"])[3]" + path2));
////                                                colorbox2.
//                                                    colorbox2.click();
//                                                    SeleniumUtils.clickSelectButton("colorpicker dropdown position-left");
//                                                    for (iIndex5 = 1; iIndex5 <= ColorPickerLength; iIndex5++) {
//                                                        if (iIndex5 == 47) {
//                                                            continue;
//                                                        } else {
//                                                            String path3 = "//*[@class='colorpicker dropdown position-left']/div[2]/div[" + iIndex5 + "]/div";
//                                                            System.out.println(path3);
////                                                            WebUI.focus(findTestObject('Object Repository/Area-DPMegaOptions/Page_mcube/div_Axis Line Color_circle-inner'))
//                                                            driver.findElement(By.xpath("(//div[@class=\"circle-inner\"])[4]")).click();
//                                                            WebElement colorBox3 = driver.findElement(By.xpath("//body[@id='kibana-body']/div[11]/div[2]/div[26]/div" + path3));
//
//                                                            colorBox3.click();
//                                                            SeleniumUtils.clickSelectButton("colorpicker dropdown position-left");
//                                                            for (iIndex6 = 0; iIndex6 < 1; iIndex6++) {
//                                                                Object[] font_Size1 = new Object[iIndex6];
//                                                                Object InputFontSize3 = (font_Size1);
//                                                                driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[4]")).sendKeys(InputFontSize3.toString());
//                                                                for (iIndex7 = 1; iIndex7 <= ColorPickerLength; iIndex7++) {
//                                                                    if (iIndex7 == 47) {
//                                                                        continue;
//                                                                    } else {
//                                                                        String path4 = (("//*[@class='colorpicker dropdown position-top']/div[2]/div[" + iIndex7) + "]/div");
//
//                                                                        System.out.println(path4);
//                                                                        driver.findElement(By.xpath("(//div[@id='Tick Font']/div/div/div/div)[2]")).click();
//                                                                        WebElement colorbox4 = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[14]/div[2]/div[9]/div" + path4));
//                                                                        colorbox4.isDisplayed();
////                                                                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
//                                                                        colorbox4.click();
//                                                                        SeleniumUtils.clickSelectButton("colorpicker dropdown position-left");
//                                                                        for (iIndex8 = 0; iIndex8 < 1; iIndex8++) {
//                                                                            Object[] font_Size2 = new Object[iIndex8];
//                                                                            InputFontSize4 = (font_Size2);
//                                                                            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[5]")).sendKeys(InputFontSize4.toString());
//                                                                            for (iIndex9 = 1; iIndex9 <= ColorPickerLength; iIndex9++) {
//                                                                                if (iIndex9 == 47) {
//                                                                                    continue;
//                                                                                } else {
//                                                                                    String path5 = (("//*[@class='colorpicker dropdown position-top']/div[2]/div[" + iIndex9) + "]/div");
//                                                                                    System.out.println(path5);
////                                                                                    WebUI.focus(findTestObject('Area-DPMegaOptions/x axis/Page_mcube/div_Italic_circle-inner (1)'))
//                                                                                    driver.findElement(By.xpath("(//div[@id='Title Font']/div/div/div/div)[2]")).click();
//                                                                                    WebElement colorbox5 = driver.findElement(By.xpath("//body[@id='kibana-body']/div[15]/div[2]/div[32]/div" + path5));
//                                                                                    wait.until(ExpectedConditions.visibilityOfElementLocated((By) colorbox5));
//                                                                                    colorbox5.click();
//                                                                                    SeleniumUtils.clickSelectButton("colorpicker dropdown position-left");
//                                                                                    for (iIndex10 = 1; iIndex10 <= ColorPickerLength; iIndex10++) {
//                                                                                        if (iIndex10 == 47) {
//                                                                                            continue;
//                                                                                        } else {
//                                                                                            String path6 = (("//*[@class=\'colorpicker dropdown position-top\']/div[2]/div[" + iIndex10) + "]/div");
//                                                                                            System.out.println(path6);
////                                                                                            WebUI.focus(findTestObject('Object Repository/Area-DPMegaOptions/Page_mcube/div_Axis Line Color_circle-inner (1)'))
//                                                                                            driver.findElement(By.xpath("(//div[@class=\"circle-inner\"])[7]")).click();
//                                                                                            WebElement colorbox6 = driver.findElement(By.xpath("//body[@id='kibana-body']/div[17]/div[2]/div[25]/div" + path6));
//                                                                                            wait.until(ExpectedConditions.visibilityOfElementLocated((By) colorbox6));
////                                                                                            WebUI.scrollToElement(colorBox6, GlobalVariable.WaitPeriod);
//                                                                                            colorbox6.click();
//                                                                                            SeleniumUtils.clickSelectButton("colorpicker dropdown position-left");
//                                                                                            driver.findElement(By.xpath("//input[@id='mCubeVFCPrefixID']")).sendKeys("pre");
//                                                                                            driver.findElement(By.xpath("//input[@id='mCubeVFCSuffixID']")).sendKeys("suff");
//                                                                                            driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[2]")).sendKeys("pre");
//                                                                                            driver.findElement(By.xpath("(//input[@id='mCubeVFNSuffixID'])[2]")).sendKeys("suff");
//                                                                                            driver.findElement(By.xpath("(//i[@id='SBIID'])[1]")).click();
//
//                                                                                            Result1 = SeleniumUtils.validateFontSizeYTick(driver,InputFontSize1);
//                                                                                            Result2 = SeleniumUtils.validateYTickFontColor(driver,iIndex2);
//                                                                                            Result3 = SeleniumUtils.validateFontSizeYTitle(driver,InputFontSize2);
//                                                                                            Result4 = SeleniumUtils.validateYTitleFontColor(driver,iIndex4);
//                                                                                            Result5 = SeleniumUtils.validateYAxisColor(driver,iIndex5);
//                                                                                            Result6 = SeleniumUtils.validatePrefixYTick(driver,"pre");
//                                                                                            Result7 = SeleniumUtils.validateSuffixYTick(driver,"suff");
//                                                                                            Result8 = SeleniumUtils.validateFontSizeXTick(driver,InputFontSize3);
//                                                                                            Result9 = SeleniumUtils.validateXTickFontColor(driver,iIndex7);
//                                                                                            Result10 = SeleniumUtils.validateFontSizeXTitle(driver,InputFontSize4);
//                                                                                            Result11 = SeleniumUtils.validateXTitleFontColor(driver,iIndex9);
//                                                                                            Result12 = SeleniumUtils.validateXAxisColor(driver,iIndex10);
//                                                                                            Result13 = SeleniumUtils.validatePrefixXTick(driver,"pre");
//                                                                                            Result14 = SeleniumUtils.validateSuffixXTick(driver,"suff");
//                                                                                            System.out.println("Y Ticks Font Size:\t" + Result1);
//
//                                                                                            System.out.println("Y Ticks Font Color:\t" + Result2);
//
//                                                                                            System.out.println("Y Title Font Size:\t" + Result3);
//
//                                                                                            System.out.println("Y Title Font Color:\t" + Result4);
//
//                                                                                            System.out.println("Y Axis Color:\t\t" + Result5);
//
//                                                                                            System.out.println("Y Ticks Prefix: \t" + Result6);
//                                                                                            System.out.println("Y Ticks Suffix: \t" + Result7);
//
//                                                                                            System.out.println("X Ticks Font Size:\t" + Result8);
//
//                                                                                            System.out.println("X Ticks Font Color:\t" + Result9);
//
//                                                                                            System.out.println("X Title Font Size:\t" + Result10);
//
//                                                                                            System.out.println("X Title Font Color:\t" + Result11);
//
//                                                                                            System.out.println("X Axis Color:\t\t" + Result12);
//
//                                                                                            System.out.println("X Ticks Prefix: \t" + Result13);
//                                                                                            System.out.println("X Ticks Suffix: \t" + Result14);
//
//                                                                                            if (((((((((((((!(Result1) || !(Result2)) || !(Result3)) ||
//                                                                                                    !(Result4)) || !(Result5)) || !(Result6)) || !(Result7)) ||
//                                                                                                    !(Result8)) || !(Result9)) || !(Result10)) || !(Result11)) ||
//                                                                                                    !(Result12)) || !(Result13)) || !(Result14))
//                                                                                            {
//                                                                                                //flag = false
//                                                                                                flag = true;
//
//                                                                                                screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                                                                                            }
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//            driver.findElement(By.xpath("//input[@id='mCubeVFCPrefixID']")).clear();
//            driver.findElement(By.xpath("//input[@id='mCubeVFCSuffixID']")).clear();
//            driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[2]")).clear();
//            driver.findElement(By.xpath("(//input[@id='mCubeVFNSuffixID'])[2]")).clear();
//            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
//            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
//            driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
//
//                Thread.sleep(7000);
//                //Tick is clicked
//                driver.findElement(By.xpath("(//*[@id=\"SBIID\"])[1]")).click();
//                //Save button
//                Random rand = new Random();
//                name = "Mcube_Area_Chart" + rand.nextInt(100000);
//                driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
//                System.out.println("Save button is clicked");
//                Thread.sleep(4000);
//                temp = SeleniumUtils.saveByName(driver, name);
//
//                Thread.sleep(4000);
//                try {
//                    driver.switchTo().alert().accept();
//                } catch (Exception e) {
//                    log.error("", e);
//                }
//
//                Thread.sleep(5000);
//
//                screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                //------------------------------------
//                String expResult = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/kbn-top-nav/div/div/div/div[1]/div[1]/ol/li[4]/a")).getText().trim();
//                AreaChart1 obj = new AreaChart1();
//                String className = obj.getClass().getCanonicalName();
//                System.out.println("Class Name : " + className + ".");
//                actualOutcome = SeleniumUtils.verifyResult(driver, name, expResult, rec, className);
//                //--------------------------------------
//
//                SeleniumUtils.clickLogo(driver, wait, name);
//                System.out.println("------------------------------------------------------------------------------------------");
//
//            } catch(Exception e){
//                screenShot.add(SeleniumUtils.takeScreenShot(driver));
//                actualOutcome = false;
////                driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
//                Thread.sleep(4000);
//                WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
//                SeleniumUtils.clickModal(driver, webEl);
//                Thread.sleep(3000);
//                log.error("", e);
//            }
//        finally{
//
//                record.setSan_aut_id(san_aut_id);
//                record.setTestCaseName("SAN-AREA-01");
//                record.setOutcome(actualOutcome);
//                record.setName("Area Chart.");
//                record.setScreenShot(screenShot);
//                record.setExpectedResult("Area chart completed successfully.");
//                clientVersionDao.setRecordDetails(record);
//                listOb.add(record);
//                if (!actualOutcome && temp.equals("false")) {
//                    System.out.println("Area chart creation failed.");
//                    return "null";
//                } else
//                    return name;
//            }
//        }
//
//
//    }
