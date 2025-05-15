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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class Combo5 {
    private static final Logger log= LoggerFactory.getLogger(Combo5.class);
    static Records rec = new Records();
    public static String combo5(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        String name = "null";
        String temp="false";
        String title_position = "OUTER-MIDDLE|INNER-TOP|INNER-MIDDLE|INNER-BOTTOM|OUTER-TOP|OUTER-BOTTOM";

        String[] title_position_new = title_position.split("\\|");

        boolean r3=false;

        boolean r4= false;
        boolean r5=false;

        boolean r6=false;
        try{
            System.out.println("Inside Combo 5-----------");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            driver.findElement(By.linkText("Widget")).click();
            driver.findElement(By.linkText("Widget")).click();
            String widgetName = "Combo";
            screenShot.add(com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            screenShot.add(com.jdbc.automation.executor.mcube510.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();


            driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
            System.out.println("1 is clicked");
            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
            System.out.println("2 is clicked");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[3]")).click();
            System.out.println("3 is clicked");
            Thread.sleep(2000);

            boolean r1 = false;
            boolean r2 = false;
            try {
                Select drpdown1 =  new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
                drpdown1.selectByVisibleText("Terms");
                Select drpdown2 =  new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                drpdown2.selectByVisibleText("Region");
                System.out.println("Region is selected");
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
                driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[7]")).click();
                System.out.println("Y axis is clicked");
//                driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
                driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
                System.out.println(" Set Y-Axis Extents is selected");
                driver.findElement(By.xpath("//input[@name='yMax']")).clear();
                driver.findElement(By.xpath("//input[@name='yMax']")).sendKeys("2");
                driver.findElement(By.xpath("//input[@name='yMin']")).clear();
                driver.findElement(By.xpath("//input[@name='yMin']")).sendKeys("1");
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                System.out.println("Tick is selected");
                r1 = SeleniumUtils.validateYExtent(driver,2,1);
                driver.findElement(By.xpath("(//input[@id='mCubeVFNPrefixID'])[3]")).sendKeys("ab");
                driver.findElement(By.xpath("(//input[@id='mCubeVFNSuffixID'])[3]")).sendKeys("cd");
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                r2 = SeleniumUtils.validatePrefixSuffixY(driver,"ab","cd");
                System.out.println("Prefix and Suffix r1 :"+r1);
                System.out.println("Prefix and Suffix r2 :"+r2);
                driver.findElement(By.xpath("//a[@ng-click='yAdvancedToggled = !yAdvancedToggled']/label")).click();
                driver.findElement(By.xpath("(//input[@type='number'])[8]")).clear();
                driver.findElement(By.xpath("(//input[@type='number'])[8]")).sendKeys("5");
                System.out.println("Tocl label length is 5 bro");
                System.out.println("Advanced Toghles");
                driver.findElement(By.xpath("(//label[@id='voFontBoldID']/b)[2]")).click();
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
            } catch (Exception e) {
                System.out.println("Inside cathc : "+e);
            }

//            driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
            System.out.println("10 is clied");
            driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("values");

            System.out.println("11 is clied");
            for (int i = 0; i < 6; i++){
                System.out.println("12 is clied");
                Select title =  new Select(driver.findElement(By.xpath("//div[@ng-show='yAdvancedToggled']/div[@class='vis-editor-agg-form-row']/div[2]/select")));
                title.selectByVisibleText(title_position_new[i]);
                System.out.println("Y axis title_position_new is selected ");
                Thread.sleep(2000);
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                r3 = SeleniumUtils.validateTitlePosition(driver,title_position_new[i]);
                System.out.println("r3 : "+r3+" for i : "+i);
                if(r3)
                    break;

            }
            //Colorbox
            System.out.println("COlor palette color box begins ");
            for (int i1 = 1; i1 <= 3; i1++){
                System.out.println("Inside r4..");
//                WebUI.focus(findTestObject('Combo5/Page_mcube/div_Line Color_circle-inner'))  Need to convert
                driver.findElement(By.xpath("(//div[@class='colorpicker-circle']/div[@class='circle-inner'])[2]")).click();
//                Need to convert
//                colorBox = WebUI.modifyObjectProperty(findTestObject('Combo5/Page_mcube/div_Wheel_color-unit'), 'xpath', 'equals', ('//*[@class=\'colorpicker dropdown position-top\']/div[2]/div[' +  i1) + ']/div', true)
                Thread.sleep(5000);
//                WebUI.scrollToElement(colorBox, 60)  Need to convert
                SeleniumUtils.clickSelectButton(driver,"colorpicker dropdown position-top");
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                r4 = SeleniumUtils.validateLineColor(driver,i1);
                System.out.println("r44:"+r4);
                if (r4)
                    break;

            }

//            for (int i2 = 1; i2 <= 3; i2++){
//                System.out.println("Inside r5");
////                WebUI.focus(findTestObject('Combo5/Page_mcube/div_Tick Color_circle-inner'))   Need to convert
//                driver.findElement(By.xpath("(//div[@class='colorpicker-circle']/div[@class='circle-inner'])[3]")).click();
////                colorBox1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Combo5
////                /Page_mcube/div_Wheel_color-unit (1)'), 'xpath', 'equals',
////                ('//*[@class='colorpicker dropdown position-top\']/div[2]/div[' +
////                        i2) + ']/div', true)      Need to convert
//                driver.findElement(By.xpath("//*[@class='colorpicker dropdown position-top']/div[2]/div['i2']/div")).click();
//                Thread.sleep(5000);
////                WebUI.scrollToElement(colorBox1, 60) Need to convert
//
////                WebUI.click(colorBox1)  Need to convert
//                SeleniumUtils.clickSelectButton(driver,"colorpicker dropdown position-top");
//                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
//                System.out.println("Going inside r5 validateTickColor");
//                r5 = SeleniumUtils.validateTickColor(driver,i2);
//                System.out.println("r55 : "+r5);
//                if(r5)
//                    break;
//
//
//            }
            for (int i3 = 1; i3 <= 3; i3++){
                System.out.println("Inside r6");
//                WebUI.focus(findTestObject('Combo5/Page_mcube/div_Italic_circle-inner'))      Need to convert
                driver.findElement(By.xpath("(//div[@class='colorpicker-circle ng-not-empty ng-valid']/div[@class='circle-inner'])[2]")).click();

//                Need to convert
//                colorBox2 = WebUI.modifyObjectProperty(findTestObject('Combo4/Page_mcube/div_Wheel_color-unit'), 'xpath', 'equals',('//*[@class=\'colorpicker dropdown position-top\']/div[2]/div[' + i3) + ']/div', true)
                Thread.sleep(5000);

//                WebUI.scrollToElement(colorBox2, 60)    Need to convert
//                WebUI.click(colorBox2)     Need to convert

                SeleniumUtils.clickSelectButton(driver,"colorpicker dropdown position-top");
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                r6 = SeleniumUtils.validateFontColor(driver,i3);
                System.out.println("r66 : "+r6);
                if(r6)
                    break;


            }
            driver.findElement(By.xpath("(//label[@id='voFontItalicID']/i)[2]")).click();
            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[2]")).sendKeys("20");
            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
            boolean r7 = SeleniumUtils.validateMaxYTickLength(driver,5);
            boolean r8 = SeleniumUtils.validateBoldFontY(driver);
            boolean r9 = SeleniumUtils.validateItalicsFontY(driver);
            boolean r10 = SeleniumUtils.validateTitleText(driver,"values");
            boolean r11 = SeleniumUtils.validateFontSizeY(driver,"20");

            System.out.println("R1-r1: " + r1);
            System.out.println("prefix suffix R2-r2:: " + r2);
            System.out.println("TITLE-POSITION R3-r3: " + r3);
            System.out.println("LINE-COLOR R4-r4: " + r4);
            System.out.println("TICK-COLOR R5-r5: " + r5);
            System.out.println("FONT-COLOR R6-r6:: " + r6);
            System.out.println("TICK-LENGTH R7-r7:" + r7);
            System.out.println("BOLD R8-r8: " + r8);
            System.out.println("ITALICS R9-r9: " + r9);
            System.out.println("TITLE-TEXT R10-r10: " + r10);
            System.out.println("Font-Size R11-r11: " + r11);

            System.out.println("Only r5 needs to be fixed --- AG");
            if ((((((((((!(r1) || !(r2)) || !(r3)) || !(r4)) || !(r5)) || !(r6)) || !(r7)) || !(r8)) || !(r9)) || !(r10)) || !(r11)) {
                System.out.println("Combo 5 Fail");
            } else {
                System.out.println("Combo 5 Pass");
            }


            Random rand = new Random();
            name = "Mcube_ComboChart5_"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);
            System.out.println("temp : "+temp);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            System.out.println("Catch e : "+e);
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
            record.setTestCaseName("SAN-COMBO-05");
            record.setOutcome(actualOutcome);
            record.setName("COMBO Chart 5");
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
