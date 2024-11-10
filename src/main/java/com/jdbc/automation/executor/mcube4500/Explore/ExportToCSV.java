package com.jdbc.automation.executor.mcube4500.Explore;

import com.jdbc.automation.executor.mcube4500.Common.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportToCSV {

    private static final Logger log= LoggerFactory.getLogger(ExportToCSV.class);
    public static void exportToCsv(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Administration")));
        driver.findElement(By.linkText("Administration")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Join Datasets")));
        driver.findElement(By.linkText("Join Datasets")).click();
        //Dataset is clicked
        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/kbn-management-app/div/div/div/div[1]/div[2]/div[1]/div/div/div/ul/li[8]/a")).click();
        Thread.sleep(2000);

        //Checkbox is clicked
        List<WebElement> checkBox = driver.findElements(By.className("control__indicator"));
        checkBox.get(0).click();

        //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/div/div[1]/div[2]/div[2]/div/div/div/ul/li/label/div")).click();

        //driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        driver.findElement(By.id("alltext")).sendKeys("Select admin_data_admin_data.`Manager` , supstore_admin_supstoredate.`City` from supstore_admin_supstoredate , admin_data_admin_data ");
        driver.findElement(By.className("btn-success")).click();

        System.out.println("Waiting for 12 seconds for JD Alert");
        Thread.sleep(10000);

        WebElement webElem = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[2]/div[2]/div/div[4]/div[2]/button"));

        SeleniumUtils.clickModal(driver, webElem);

        /*for(int i=0;i<5;i++)
        {
            System.out.println("Inside alert accept i:"+i);
            try {
                driver.switchTo().alert();
                driver.findElement(By.linkText("OK")).click();
            } catch (Exception e) {
                System.out.println("Inside CATCH : ");
                driver.findElement(By.id("alltext")).click();
                throw new RuntimeException(e);
            }
        }*/
        /*String statusJD = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[396]/div[2]/div/div[3]/div")).getText();
        System.out.println("Status of Join Dataset : "+statusJD);
        driver.findElement(By.className("ajs-button btn btn-danger")).click();*/

        //driver.switchTo().alert().accept();

        //SeleniumUtils.waitForAlert(driver);


        String jd = "Mcube_JoinDataset"+now.format(formatter);
        driver.findElement(By.id("indexName")).sendKeys(jd);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/kbn-management-app/div/div/div/div[1]/div[6]/div[2]/div/div/dataset-name-validate/div/div/div/div[2]/button/span[1]")).click();
        System.out.println("Join Dataset : "+jd+" is created");

        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[4]/div[2]/button[2]")));
        WebElement webElem2 = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[4]/div[2]/button[2]"));
        SeleniumUtils.clickModal(driver, webElem2);

    }
}
