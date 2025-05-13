package com.jdbc.automation.executor.mcube510.widgets;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube510.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class TreeTable {

    private static final Logger log= LoggerFactory.getLogger(TreeTable.class);
    static Records rec = new Records();

    public static String treeTable(WebDriver driver, WebDriverWait wait, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {

        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        String name = "null";
        String temp="false";
        try {
            SeleniumUtils.yDataFillTree(driver, wait, "Tree");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            SeleniumUtils.xDataFillTree(driver, wait);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            Thread.sleep(7000);
            //Tick is clicked
            driver.findElement(By.xpath("//*[@id=\"SBIID\"]")).click();

            //Save button
            Random rand = new Random();
            name = "Mcube_Tree_Table" + rand.nextInt(100000);

            driver.findElement(By.id("KTNvisualizeSaveButtonLocalMenuID")).click();
            System.out.println("Save button is clicked");
            temp = SeleniumUtils.saveByName(driver, name);

            Thread.sleep(2000);
            String expResult = null;
            try {
                List<WebElement> allBreadCrumbs = driver.findElements(By.xpath("//div[@class='breadcr col-sm-16']/ul/li"));
                int n = allBreadCrumbs.size();
                expResult = allBreadCrumbs.get(n-1).findElement(By.tagName("a")).getText().trim();
                System.out.println("Try TreeTable ExpResult : "+expResult);
            } catch (Exception e) {
                System.out.println("expResult Error inside TreeTable: "+expResult);
            }


            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //------------------------------------
//            String expResult = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[2]/visualize-app/kbn-top-nav/div/div/div/div[1]/div[1]/ol/li[4]/a")).getText().trim();
//            String expResult = driver.findElement(By.xpath("//li[@id='KTNvisualization:Mcube_Area_Chart20825LabelID']/a")).getText().trim();
            TreeTable obj = new TreeTable();
            String className = obj.getClass().getCanonicalName();
            System.out.println("Class Name : "+className+".");
            actualOutcome = SeleniumUtils.verifyResult(driver, name, expResult, rec,className);
            //--------------------------------------

            SeleniumUtils.clickLogo(driver, wait, name);
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
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
            record.setTestCaseName("SAN-TREE_TABLE-01");
            record.setOutcome(actualOutcome);
            record.setName("Tree table Chart.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Tree table completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);

            if (!actualOutcome && temp.equals("false")) {
                System.out.println("Tree Table creation failed.");
                return "null";
            }
            else
                return name;
        }
    }
}
