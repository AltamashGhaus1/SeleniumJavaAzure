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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class Combo3 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();

    public static String combo3(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();

    String legend = "RIGHT|BOTTOM";

    String[] legendPosition = legend.split("\\|");

    String fontSize = "10|15|20|25";

    String[] font_Size = fontSize.split("\\|");

    String fontFamily = "Arial|Sans-Serif|Times New Roman|Verdana";

    String[] font_family = fontFamily.split("\\|");

    boolean flag = true;
        String name = "null";
        String temp="false";

    try{
        System.out.println("Inside Combo 3-----------");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
        driver.findElement(By.linkText("Widget")).click();
        driver.findElement(By.linkText("Widget")).click();
        String widgetName = "Combo";
        screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
        driver.findElement(By.linkText(widgetName)).click();
        driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
        screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
        driver.findElement(By.linkText(dataset)).click();

        System.out.println("Dataset is clicked.");



        driver.findElement(By.xpath("(//*[@id='bucketButtonAddLabelID'])[3]")).click();
        System.out.println("X axis is clicked");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")).click();
        System.out.println("Aggregation is clicked");

        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id='2bucketSelectButtonID']/option[6]")).click();
        driver.findElement(By.xpath("//*[@id='2bucketSelectButtonID']/option[7]")).click();
        System.out.println("Terms is selected");
        driver.findElement(By.xpath("//select[@id='2fieldSelectID']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='2fieldSelectID']/optgroup[3]/option[13]")).click();
        System.out.println("State of province is selected in field dropdown");

        driver.findElement(By.xpath("//*[@id='2metricExpandButtonIID']")).click();
        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();

        Select yaxis1 = new Select(driver.findElement(By.xpath("//select[@id='1bucketSelectButtonID']")));
        yaxis1.selectByVisibleText("Average");
        Select yaxis2 = new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']")));
        try {
            yaxis2.selectByVisibleText("Sales");
        } catch (Exception e) {
            yaxis2.selectByVisibleText("Discount");
            System.out.println("Discount is clicked in catch err: "+e);
        }

        driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/visualize-app/div/div/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group/div/div[2]/div/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        //Y axis prefix
        driver.findElement(By.xpath("//input[@id='mCubeVFNPrefixID']")).sendKeys("asd");
        //Y axis suffix
        driver.findElement(By.xpath("//input[@id='mCubeVFNSuffixID']")).sendKeys("qwe");
        //Close Y axis after Avg Sales
        driver.findElement(By.xpath("//i[@id='1metricExpandButtonIID']")).click();
        //Add Metrics Button click
        driver.findElement(By.xpath("//div[@id='bucketAddButtonID']")).click();
        //Y2 clicked
        driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
//        Select yaxis2_1 = new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']")));
        Select yaxis2_1 = new Select(driver.findElement(By.xpath("//select[@id='3bucketSelectButtonID']")));
        yaxis2_1.selectByVisibleText("Sum");
//        Select yaxis2_2 = new Select(driver.findElement(By.xpath("//select[@id='1fieldSelectID']")));
        Select yaxis2_2 = new Select(driver.findElement(By.xpath("//select[@id='3fieldSelectID']")));
        try {
            yaxis2_2.selectByVisibleText("Profit");
        } catch (Exception e) {
            yaxis2_2.selectByVisibleText("Unit Price");
            System.out.println("Unit price is clicked inside Y2 catch axis err : "+e);
        }

        //--------
        driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/visualize-app/div/div/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group/div/div[2]/div[2]/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
        //Show datalabels
        driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();

        //Y axis prefix
//        driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[3]")).sendKeys("asd");
        driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[3]")).sendKeys("asd");
        System.out.println("Anda");
        //Y axis suffix
        driver.findElement(By.xpath("(//input[@id='mCubeVFNSuffixID'])[3]")).sendKeys("qwe");
        System.out.println("Aloo");
//--------
        //Y2 arrow button click
        driver.findElement(By.xpath("//i[@id='3metricExpandButtonIID']")).click();
        driver.findElement(By.xpath("//div[@id='bucketAddButtonID']")).click();
        driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
        Select yaxis3 = new Select(driver.findElement(By.xpath("//select[@id='4bucketSelectButtonID']")));
        yaxis3.selectByVisibleText("Calculated Field");
        driver.findElement(By.xpath("//textarea[@id='4calcFieldTextID']")).sendKeys("(#Sum of Profit + #Average Sales) / 2");
        //Y axis suffix
        driver.findElement(By.xpath("//input[@id='calcFieldLabelInputID']")).sendKeys("QATest_3200");
        //--------
        driver.findElement(By.xpath("//body[@id='kibana-body']/div/div/div/div[2]/visualize-app/div/div/vis-editor-sidebar/div/form/div[2]/vis-editor-agg-group/div/div[2]/div[3]/ng-form/vis-editor-agg-params/div[3]/div/a/label")).click();
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
        //Show datalabels
        System.out.println("Show datalabels is clicked");

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@type='checkbox'])[14]")).click();
        System.out.println("Data labels checck boix is cliekd");
//        driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[5]")).sendKeys("asd");
        driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[5]")).sendKeys("asd");
        System.out.println("Sum of profits asd and qwe is done1");
        //Y axis suffix
        driver.findElement(By.xpath("(//input[@id='mCubeVFNSuffixID'])[5]")).sendKeys("qwe");
//        driver.findElement(By.xpath("(//input[@id='mCubeVFNSuffixID'])[3]")).sendKeys("qwe");
        System.out.println("Sum of profits asd and qwe is done2");

        driver.findElement(By.xpath("//i[@id='4metricExpandButtonIID']")).click();
        driver.findElement(By.xpath("//i[@id='SBIID']")).click();
        driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
        //Tool Tip is opened
        driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[4]")).click();
        //Tooltip prefix

        driver.findElement(By.xpath("//*[@id='mCubeVFCPrefixID']")).sendKeys("pre");
        driver.findElement(By.xpath("//*[@id='mCubeVFCSuffixID']")).sendKeys("suff");
        driver.findElement(By.xpath("(//button[@id='mCubeVPButtonID'])[2]")).click();
        //END OF DATA LABELS
        System.out.println("End of data labels");
//TOOLTIP
//Option Y axis is opened
        driver.findElement(By.xpath("(//button[@id='mCubeVPButtonID'])[6]")).click();
        //Tooltip prefix
        driver.findElement(By.xpath("//input[@id='mCubeVFCPrefixID']")).sendKeys("asd");
        //Tooltip suffix
        driver.findElement(By.xpath("//input[@id='mCubeVFCSuffixID']")).sendKeys("qwe");
        //Y axis prefix
        driver.findElement(By.xpath("//*[@id='mCubeVFCPrefixID']")).sendKeys("asd");
        //Y axis suffix
        driver.findElement(By.xpath("//*[@id='mCubeVFCSuffixID']")).sendKeys("qwe");

        System.out.println("QWE ..");

        //Y Axis Open
        driver.findElement(By.xpath("(//button[@id='mCubeVPButtonID'])[6]")).click();
        driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[3]")).click();
        driver.findElement(By.xpath("(//*[@id='voFontBoldID']/b)[4]")).click();
        driver.findElement(By.xpath("(//*[@id='voFontItalicID']/i)[4]")).click();

        //legendPosition.length
        for (int i1 = 0; i1 < 1; i1++){
            Select bottomright = new Select(driver.findElement(By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[19]")));
            bottomright.selectByVisibleText(legendPosition[i1]);
            ///font_Size.length
            for (int i2 = 0; i2 < 1; i2++){
                driver.findElement(By.xpath("(//*[@id=\"mCubeVFInputID\"])[4]")).clear();
                Thread.sleep(3000);
                driver.findElement(By.xpath("(//*[@id=\"mCubeVFInputID\"])[4]")).sendKeys(font_Size[i2]);
                //GlobalVariable.ColorPickerLength
                int ColorPickerLength=1;
                for (int i3 = 1; i3 <= ColorPickerLength; i3++){

//                    WebUI.focus(findTestObject('Object Repository/Combo- 3/Page_mcube/div_Italic_circle-inner'))    Need to convert
                    driver.findElement(By.xpath("(//div[@class='colorpicker-circle ng-not-empty ng-valid']/div[1])[4]")).click();
                    for (int i4 = 0; i4 < 1; i4++){
                        Select fontfamily = new Select(driver.findElement(By.xpath("(//*[@id=\"mCubeVFFontFamilyID\"])[4]")));
                        fontfamily.selectByVisibleText(font_family[i4]);
                        driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                        Thread.sleep(2000);
                        boolean dlpresuff = SeleniumUtils.validateDLPreSuff(driver,"asd","qwe");
                        boolean ttpresuff = SeleniumUtils.validateTTPreSuff(driver,"asd","qwe");
                        boolean leg_fontsize = SeleniumUtils.legendValidations(driver,"Font Size", font_Size[i2]);
                        boolean leg_bold = SeleniumUtils.legendValidations(driver,"Bold","qwe");
                        boolean leg_italic = SeleniumUtils.legendValidations(driver,"Italics","qwe");
                        String index = Integer.toString(i3);
                        boolean leg_fontfamily = SeleniumUtils.legendValidations(driver,"Font Family",font_family[i4]);
                        System.out.println("dlpresuff: " + dlpresuff);

                        System.out.println("ttpresuff: " + ttpresuff);

                        System.out.println("leg_fontsize: " + leg_fontsize);

                        System.out.println("leg_bold: " + leg_bold);

                        System.out.println("leg_italic: " + leg_italic);

                        // println('leg_fontcolor: ' + leg_fontcolor)

                        System.out.println("leg_fontfamily: " + leg_fontfamily);
                        if (((((!(dlpresuff) || !(ttpresuff)) || !(leg_fontsize)) || !(leg_bold)) || !(leg_italic)) || !(leg_fontfamily)) {
                            flag = false;

//                            WebUI.takeScreenshot()
                        }

                    }

                }
            }

        }
        driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[3]")).click();

        if (flag == true) {
            System.out.println("Combo chart 3 passed");
//                    KeywordUtil.markPassed("Combo Chart Test1 Case Passed")
        } else {
            System.out.println("Combo chart 3 failed");
//                    KeywordUtil.markFailed("Combo Chart Test1 Case Failed")
        }

        Random rand = new Random();
        name = "Mcube_ComboChart3_"+rand.nextInt(100000);
        driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
        log.info("Save button is clicked");
        Thread.sleep(3000);
        temp = SeleniumUtils.saveByName(driver, name);
        System.out.println("temp : "+temp);
        Thread.sleep(2000);
    }
    catch (Exception e) {
        System.out.println("Catch e:"+ e);
        screenShot.add(SeleniumUtils.takeScreenShot(driver));
        actualOutcome = false;
        driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
        Thread.sleep(3000);
        WebElement webEl = driver.findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
        SeleniumUtils.clickModal(driver, webEl);
        Thread.sleep(2000);
        log.error("",e);
        return "";
    }
    finally {

        record.setSan_aut_id(san_aut_id);
        record.setTestCaseName("SAN-COMBO-03");
        record.setOutcome(actualOutcome);
        record.setName("COMBO Chart.");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Combo chart completed successfully.");
        clientVersionDao.setRecordDetails(record);

        listOb.add(record);

        if (!actualOutcome && temp.equals("false")) {
            log.info("Combo chart creation failed.");
            return "null";
        }
        else
            return name;
    }

}
}
