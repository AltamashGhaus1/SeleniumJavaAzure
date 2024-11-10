package com.jdbc.automation.executor.mcube4550.Workbench;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.mcube4550.Common.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RowAndColumnLevel {

    private static final Logger log= LoggerFactory.getLogger(RowAndColumnLevel.class);
    static Records rec = new Records();
    public static void rowAndColumnLevel(WebDriver driver, WebDriverWait wait,String dataset) throws Exception {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

        Thread.sleep(3000);

        driver.findElement(By.linkText("User Groups")).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New")));
        try {
            driver.findElement(By.xpath("//*[@id=\"main\"]/ng-view/div[6]/table/tbody/tr[2]/td[7]/i")).click();
            System.out.println("Pencil is clicked to edit Workspace");
        } catch (Exception e) {
            log.error("",e);
        }

        Thread.sleep(4000);

        List<WebElement> chkBox = driver.findElements(By.className("checkmark"));

        System.out.println("chkBox size : " + chkBox.size());
        chkBox.get(0).click(); //Assign Index and Field Level Access
        System.out.println("Give access to usergroup on all fields across all the datasets");

        driver.findElement(By.id("selectedIndex_0")).sendKeys(dataset);

        List<WebElement> listDataset = driver.findElement(By.cssSelector("div[class=\"md-virtual-repeat-scroller\"]")).findElement(By.cssSelector("ul[class=\"md-autocomplete-suggestions autocomplete-custom-template\"]")).findElements(By.tagName("li"));
        int dsSize = listDataset.size();
        System.out.println("Dataset Size : "+dsSize);

        Thread.sleep(4000);

        for(int i=0;i<dsSize;i++)
        {
            List<WebElement> webEl1 = listDataset.get(i).findElements(By.cssSelector("span[md-highlight-text=\"searchText\"]"));
            List<WebElement> webEl = new ArrayList<>();
            for(int j=0;j<webEl1.size();j++) {
                webEl = webEl1.get(j).findElements(By.cssSelector("span[class=\"highlight\"]"));
                System.out.println("WebElement of Dataset: "+webEl.get(j).getText());

                if((webEl.get(j).getText()).equalsIgnoreCase(dataset))
                {
                    webEl.get(j).click();
                    System.out.println("Dataset is clicked at j :"+j);
                }
            }
        }

        chkBox = driver.findElements(By.className("checkmark"));
        System.out.println("Check Box size after 1st click : "+chkBox.size());

        for (int i = 5; i < (chkBox.size() - 2); i++) {
            chkBox.get(i).click();
        }

        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//*[@id=\"tabs1\"]/div/div/div[5]/button[2]")).click();

        } catch (Exception e) {
            log.error("",e);
        }

        System.out.println("Waiting for 12 sec to click alert in Workspace Creation");
        Thread.sleep(12000);

        int flag=0;
        try {
            WebElement webEl = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[4]/div[2]/button"));
            SeleniumUtils.clickModal(driver, webEl);
            flag=1;
        } catch (Exception e) {
            //driver.switchTo().alert().accept();
            Keys.chord(Keys.ENTER);
            log.error("",e);
        }

        Thread.sleep(4000);

        rec.screenShot.add(SeleniumUtils.takeScreenShot(driver));

        if(flag==1)
        {
            //------------------------------------
            String expResult = driver.findElement(By.xpath("//*[@id=\"main\"]/ng-view/div[6]/table/tbody/tr[2]/td[2]")).getText().trim();
            WorkSpaceCreation obj = new WorkSpaceCreation();
            String className = obj.getClass().getCanonicalName();
            System.out.println("Class Name : "+className+".");
          //  SeleniumUtils.verifyResult(driver,workspaceName, expResult, rec,className);
            //--------------------------------------
        }

        driver.findElement(By.xpath("//*[@id=\"mySidenav\"]/ul/li[2]/div/div[2]")).click();
        System.out.println("Management is clicked");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
