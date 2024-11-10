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

public class Combo4 {
    private static final Logger log= LoggerFactory.getLogger(Combo4.class);
    static Records rec = new Records();
    public static String combo4(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id, String dataset) throws Exception{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        String name = "null";
        String temp="false";
        String title_position = "OUTER-CENTER|INNER-RIGHT|INNER-CENTER|INNER-LEFT|OUTER-RIGHT|OUTER-LEFT";

        String[] title_position_new = title_position.split("\\|");


        boolean r1=true;

        boolean r2;

        boolean r3;

        boolean r4;

        try{
            System.out.println("Inside Combo 4-----------");


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
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[2]")).click();

            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
            System.out.println("Data is clcicked back");
            driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[3]")).click();

            Thread.sleep(2000);


            Select drpdown1 =  new Select(driver.findElement(By.xpath("//select[@id='2bucketSelectButtonID']")));
            drpdown1.selectByVisibleText("Terms");
            Select drpdown2 =  new Select(driver.findElement(By.xpath("//select[@id='2fieldSelectID']")));
            drpdown2.selectByVisibleText("Region");

            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
            driver.findElement(By.xpath("//a[@id='SBOAID']")).click();
//Options - X Axis
            driver.findElement(By.xpath("(//i[@id='mCubeVPIID'])[5]")).click();
//            driver.findElement(By.xpath("(//i[@class='fa fa-caret-down fa-caret-right'])[3]")).click();
            driver.findElement(By.xpath("(//i[@class='fa fa-caret-down fa-caret-right'])[3]")).click();

            System.out.println("Waiting to click on num field");
            driver.findElement(By.xpath("(//input[@type='number'])[6]")).clear();
            driver.findElement(By.xpath("(//input[@type='number'])[6]")).sendKeys("4");
            System.out.println("Waiting to click on num field2");
            driver.findElement(By.xpath("(//input[@type='number'])[7]")).click();
            driver.findElement(By.xpath("(//input[@type='number'])[7]")).sendKeys("4");
            System.out.println("Waiting to click on num field3");
            driver.findElement(By.xpath("(//input[@type='number'])[8]")).clear();
            driver.findElement(By.xpath("(//input[@type='number'])[8]")).sendKeys("4");
            System.out.println("Waiting to click on num field4");

//            driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
//            driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Region");
            driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
            driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("Region");
            System.out.println("HelReg");
            driver.findElement(By.xpath("(//label[@id='voFontBoldID']/b)[2]")).click();
            System.out.println("HelBold");
            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
            driver.findElement(By.xpath("(//label[@id='voFontItalicID']/i)[2]")).click();
            System.out.println("Helitalic");

            for (int i3 = 0; i3 < 6; i3++){
                Select titlePosition = new Select(driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/div/div[1]/vis-editor-sidebar/div/form/div[3]/vis-editor-vis-options/div/div/div/div[5]/div[1]/ng-transclude/fieldset/div/div[7]/div[4]/div[2]/select")));
                titlePosition.selectByVisibleText(title_position_new[i3]);
                System.out.println("Inside for loopfwes");
                driver.findElement(By.xpath("//i[@id='SBIID']")).click();
                r1= SeleniumUtils.validateTitlePosition(driver,title_position_new[i3]);

            }

//            WebUI.waitForElementVisible(findTestObject('Combo4/Page_mcube/div_Line Color_circle-inner'), 5)  NEED to convert
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@id='mCubeVFInputID'])[2]")).sendKeys("10");
            driver.findElement(By.xpath("//i[@id='SBIID']")).click();
            Thread.sleep(5000);
            System.out.println("Hel0");
            boolean r5= SeleniumUtils.validateMaxXLabels(driver,4);
            System.out.println("Hel1");
            boolean r6 = SeleniumUtils.validateRotateXTicks(driver,"4");
            System.out.println("Hel2");
            boolean r7 = SeleniumUtils.validateMaxXTickLength(driver,4);
            System.out.println("Hel3");
            boolean r8 = SeleniumUtils.validateFontSizeX(driver,"10");
            System.out.println("Hel4");
            boolean r9 = SeleniumUtils.validateBoldFontX(driver);
            System.out.println("Hel5");
            boolean r10 = SeleniumUtils.validateItalicsFontY(driver);
            System.out.println("Hel5");
            driver.findElement(By.xpath("//a[@id='SDataAID']")).click();
            System.out.println("Waiting to cloick //button[@id='2metricExpandButtonID']");
            driver.findElement(By.xpath("//button[@id='2metricExpandButtonID']")).click();
            boolean r11 = SeleniumUtils.validateTitleText(driver);
            System.out.println("TEXT-POSITION: " + r1);

/*println('LINE-COLOR: ' + r2)

println('TICK-COLOR: ' + r3)

println('FONT-COLOR: ' + r4)*/

            System.out.println("Max X Ticks: " + r5);

            System.out.println("Rotate X Ticks: " + r6);

            System.out.println("Length X Ticks: " + r7);

            System.out.println("Font-Size: " + r8);

            System.out.println("Bold-Font: " + r9);

            System.out.println("Italics-Font: " + r10);

            System.out.println("Title Text: " + r11);
            if (!(r1) || !(r5) || !(r6) || !(r7) || !(r8) || !(r9) || !(r10) || !(r11)) {
                System.out.println("Combo 4 Fail");
            } else {
                System.out.println("Combo 4 Pass");
            }

            Random rand = new Random();
            name = "Mcube_ComboChart4_"+rand.nextInt(100000);
            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            log.info("Save button is clicked");
            Thread.sleep(3000);
            temp = SeleniumUtils.saveByName(driver, name);
            System.out.println("temp : "+temp);
            Thread.sleep(2000);


        }
        catch (Exception e) {
            System.out.println("catch e : "+e);
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
                log.info("Combo Chart4 creation failed.");
                return "null";
            }
            else
                return name;
        }
    }
}
