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

public class Combo6 {
    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();

    public static String combo6(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        String name = "null";
        String temp="false";
//        String font_family = "Arial|Sans-Serif|Times New Roman|Verdana";
        String font_family = "Arial|Sans-Serif|Times New Roman|Verdana";

        String[] font_family_new = font_family.split("\\|");
        boolean r6 =  false;

        try{
            System.out.println("Inside Combo 6-----------");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            driver.findElement(By.linkText("Widget")).click();
            driver.findElement(By.linkText("Widget")).click();
            String widgetName = "Combo";
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(widgetName)).click();
            driver.findElement(By.id("PSLFilterFinderID")).sendKeys(dataset);
            screenShot.add(com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.linkText(dataset)).click();



            driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
            driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();
            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[3]")).click();
            Thread.sleep(2000);


            Select drpdown1 = null;
            try {
                drpdown1 = new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
                drpdown1.selectByVisibleText("Terms");
                Select drpdown2 =  new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                drpdown2.selectByVisibleText("Region");
                Thread.sleep(2000);
                System.out.println("Add metric to be cliked");
                driver.findElement(By.xpath("//div[@id='bucketAddButtonID']")).click();
                driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
                System.out.println("About to click Sum of Y2");
            Select drpSum =  new Select(driver.findElement(By.xpath("//select[@id='3bucketSelectButtonID']")));
//                Select drpSum =  new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
//            drpdown1.selectByVisibleText("Sum");
                drpSum.selectByVisibleText("Sum");
                System.out.println("Sum of Y2 clicked");
            Select drpSales =  new Select(driver.findElement(By.xpath("//select[@id='3fieldSelectID']")));
//                Select drpSales =  new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
                try {
                    drpSales.selectByVisibleText("Discount");
                } catch (Exception e) {
                    drpSales.selectByVisibleText("Sales");
                }
            } catch (Exception e) {
                System.out.println("Catch errop : "+e);
            }

            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
            driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
            System.out.println("Shpw Y22 axissz");
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[7]")).click();
            Thread.sleep(3000);
//            driver.findElement(By.xpath("//input[@ng-model='vis.params.y2.show']")).click();
            System.out.println("Shpw Y2 axisz");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@ng-model='vis.params.setY2Extents']")).click();
            System.out.println("Set Y2 axis extent ");
//            driver.findElement(By.xpath("//input[@ng-model='vis.params.y2.show']")).click();
            System.out.println("Y2 axis clicked .");
            driver.findElement(By.xpath("//input[@name='y2Max']")).clear();
            driver.findElement(By.xpath("//input[@name='y2Max']")).sendKeys("2");
            driver.findElement(By.xpath("//input[@name='y2Min']")).clear();
            driver.findElement(By.xpath("//input[@name='y2Min']")).sendKeys("1");
            System.out.println("fdbfg");
            driver.findElement(By.xpath("//i[@id='SBIID']")).click();


            boolean r1= SeleniumUtils.validateYExtent(driver,2,1);
            driver.findElement(By.xpath("(//*[@id='mCubeVFNPrefixID'])[5]")).sendKeys("ab");
            driver.findElement(By.xpath("(//*[@id='mCubeVFNSuffixID'])[5]")).sendKeys("cd");
            driver.findElement(By.xpath("//i[@id='SBIID']")).click();

            boolean r2 = SeleniumUtils.validatePrefixSuffixY2(driver,"ab","cd");
            System.out.println("r2 bal : "+r2);
            driver.findElement(By.xpath("(//i[@class='fa fa-caret-down fa-caret-right'])[4]")).click();
            System.out.println("Show axis advanced option is cliecked");
            driver.findElement(By.xpath("(//input[@type='number'])[10]")).clear();
            driver.findElement(By.xpath("(//input[@type='number'])[10]")).sendKeys("5");
            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[3]")).clear();
            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[3]")).sendKeys("20");
            driver.findElement(By.xpath("(//label[@id='voFontBoldID']/b)[3]")).click();
            System.out.println("Bold is clicked");
            driver.findElement(By.xpath("(//label[@id='voFontItalicID']/i)[3]")).click();
            System.out.println("Italics is clicked");
            driver.findElement(By.xpath("//i[@id='SBIID']")).click();

            for (int i3 = 0; i3 < 4; i3++){
                System.out.println("Inside validateFontFamily");
                Select drpFont =  new Select(driver.findElement(By.xpath("(//*[@id=\"mCubeVFFontFamilyID\"])[3]")));
//                drpdown1.selectByVisibleText(font_family_new[i3]);
                drpFont.selectByVisibleText(font_family_new[i3]);
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                Thread.sleep(2000);
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                r6 = SeleniumUtils.validateFontFamily(driver,font_family_new[i3]);
                System.out.println("r66 font family: "+r6);
                if(r6==false)
                    break;
            }
            System.out.println("Outisde fontfamily");


            boolean r7 = false;
            boolean r8 = false;
            boolean r9 = false;
            boolean r10 = false;
            try {
                r7 = SeleniumUtils.validateBoldFontY2(driver);
                r8 = SeleniumUtils.validateItalicsFontY2(driver);
                r9 = SeleniumUtils.validateFontSizeY2(driver,"20");
                r10 = SeleniumUtils.validateMaxY2TickLength(driver,5);
            } catch (Exception e) {
                System.out.println("Err validation : "+e);
            }

            System.out.println("r10maxticklength : "+r10);

            System.out.println("SetY2Extents r1:  " + r1);

            System.out.println("Prefix-Suffix r2 : " + r2);

/*println('LINE-COLOR: ' + r3)

println('TICK-COLOR: ' + r4)

println('FONT-COLOR: ' + r5)*/

            System.out.println("Font-Family r6 : " + r6);

            System.out.println("BOLD: " + r7);

            System.out.println("ITALICS: " + r8);

            System.out.println("FONT-SIZE: " + r9);

            System.out.println("TICK-LENGTH: " + r10);

            System.out.println("r1 :"+r1);
            System.out.println("r2 :"+r2);
            System.out.println("r6 :"+r6);
            System.out.println("r7 :"+r7);
            System.out.println("r8 :"+r8);
            System.out.println("r9 :"+r9);
            System.out.println("r10 :"+r10);

            if (!(r1) || !(r2) || !(r6) || !(r7) || !(r8) || !(r9) || !(r10)) {
                System.out.println("Combo 6 Fail");
            } else {
                System.out.println("Combo 6 Pass");
            }

            Random rand = new Random();
            name = "Mcube_ComboChart6_"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);
            System.out.println("temp : "+temp);
            Thread.sleep(2000);
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
