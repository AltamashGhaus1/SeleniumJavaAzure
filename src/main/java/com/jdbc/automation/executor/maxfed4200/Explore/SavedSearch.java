package com.jdbc.automation.executor.maxfed4200.Explore;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.maxfed4200.Common.SeleniumUtils;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class SavedSearch {

    private static final Logger log= LoggerFactory.getLogger(SavedSearch.class);
    static Records rec = new Records();

    public static boolean savedSearch(WebDriver driver, WebDriverWait wait, String jdName, List<Records> listOb, ClientVersionDao clientVersionDao, int san_aut_id) throws Exception {


        Records record = new Records();
        //Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Explore")));
            driver.findElement(By.linkText("Explore")).click();

            Thread.sleep(4000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Selected Fields")));
            String dsName = "";
            try {
                dsName = driver.findElement(By.cssSelector("div[class='sidebar-list']")).findElement(By.cssSelector("div[ng-show='indexPatternList.length > 1']")).findElement(By.cssSelector("div[class='index-pattern']")).findElement(By.tagName("div")).getText().trim();
                System.out.println(dsName);
            } catch (Exception e) {
                dsName = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/discover-app/div/div[2]/div[1]/disc-field-chooser/div/div[2]/div/div")).getText().trim();
                log.error("",e);
            }


            System.out.println("Dataset_Name at first : " + dsName + ". and jdname to compare : " + jdName + ".");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            if (dsName.equals(jdName)) {
                /*try {
                    String popular = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/discover-app/div/div[2]/div[1]/disc-field-chooser/div/ul[2]/li[1]/h6")).getText().trim();
                } catch (Exception e) {
                    driver.findElement(By.xpath(""))
                    throw new RuntimeException(e);
                }*/

                try {
                    SeleniumUtils.changeDate(driver, wait,screenShot);
                } catch (Exception e) {
                    System.out.println("Dataset is not time bound");
                    log.error("",e);
                }
                //Un-Popular Fields
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                try {
                    List<WebElement> countLi = driver.findElement(By.cssSelector("ul[class=\"list-unstyled discover-unpopular-fields hidden-sm hidden-xs\"]")).findElements(By.cssSelector("li[class=\"sidebar-item\"]"));
                    int countSize = countLi.size();
                    System.out.println("countSize : " + countSize);

                    for (int i = 0; i < countSize; i++) {
                        WebElement we = countLi.get(i);
                        SeleniumUtils.addClick(driver, we);

                    }
                } catch (Exception e) {
                    log.error("",e);
                }

                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                //Popular Fields

                try {
                    List<WebElement> countLi = driver.findElement(By.cssSelector("ul[class=\"list-unstyled sidebar-well discover-popular-fields hidden-sm hidden-xs\"]")).findElements(By.cssSelector("li[class=\"sidebar-item\"]"));
                    int countSize = countLi.size();
                    System.out.println("countSize : " + countSize);

                    for (int i = 0; i < countSize; i++) {
                        WebElement we = countLi.get(i);
                        SeleniumUtils.addClick(driver, we);
                    }
                }
                catch (Exception e) {
                    log.error("",e);
                }

            } else {
                // driver.findElement(By.className("fa fa-caret-down")).click();

                //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/discover-app/div/div[2]/div[1]/disc-field-chooser/div/div[1]/div[1]/i[1]")).click();
                driver.findElement(By.cssSelector("div[class='sidebar-list']")).findElement(By.cssSelector("div[ng-show='indexPatternList.length > 1']")).findElement(By.cssSelector("i[ng-hide='showIndexPatternSelection']")).click();
                Thread.sleep(2000);
                //--------------------------findElement(By.tagName("li"))
                List<WebElement> listOfDataset = driver.findElement(By.cssSelector("div[ng-show=\"showIndexPatternSelection\"]")).findElement(By.cssSelector("ul[class=\"list-unstyled sidebar-item index-pattern-selection\"]")).findElements(By.tagName("li"));

                String captured = driver.findElement(By.cssSelector("li[title='"+jdName+"']")).getText();
                System.out.println("Captured : "+captured);

                try {
                    driver.findElement(By.cssSelector("li[title='"+jdName+"']")).click();
                } catch (Exception e) {

                    System.out.println("Inside Catchh");
                    for(int i=0; i< listOfDataset.size();i++) {
                        String dataset = listOfDataset.get(i).getText();
                        System.out.println("Dataset : "+dataset+" i :"+i);
                        if(dataset.equalsIgnoreCase(jdName))
                        {
                            System.out.println("Dataset : "+dataset+" found");
                            //Dataset click
                            //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/discover-app/div/div[2]/div[1]/disc-field-chooser/div/div[1]/div[2]/ul/li["+(i+1)+"]")).click();
                            listOfDataset.get(i).click();
                            break;
                        }
                    }

                    e.printStackTrace();
                }


                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                //---------------------------
                //driver.findElement(By.linkText(jdName)).click();
                Thread.sleep(5000);
               /* driver.findElement(By.linkText("Explore")).click();
                Thread.sleep(5000);*/

                try {
                    SeleniumUtils.changeDate(driver, wait, screenShot);
                } catch (Exception e) {
                    System.out.println("Dataset is not time bound");
                    log.error("",e);
                }
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                //Un-Popular Fields
                try {
                    List<WebElement> countLi = driver.findElement(By.cssSelector("ul[class=\"list-unstyled discover-unpopular-fields hidden-sm hidden-xs\"]")).findElements(By.cssSelector("li[class=\"sidebar-item\"]"));
                    int countSize = countLi.size();
                    System.out.println("countSize : " + countSize);

                    for (int i = 0; i < countSize; i++) {
                        WebElement we = countLi.get(i);
                        SeleniumUtils.addClick(driver, we);
                    }
                } catch (Exception e) {
                    log.error("",e);
                }
                screenShot.add(SeleniumUtils.takeScreenShot(driver));
                //Popular Fields
                try {
                    List<WebElement> countLi = driver.findElement(By.cssSelector("ul[class=\"list-unstyled sidebar-well discover-popular-fields hidden-sm hidden-xs\"]")).findElements(By.cssSelector("li[class=\"sidebar-item\"]"));
                    int countSize = countLi.size();
                    System.out.println("countSize : " + countSize);

                    for (int i = 0; i < countSize; i++) {
                        WebElement we = countLi.get(i);
                        SeleniumUtils.addClick(driver, we);
                    }
                } catch (Exception e) {
                    log.error("",e);
                }
            }

            //Save is clicked
            String name = "SaveSearch" + now.format(formatter);
            driver.findElement(By.id("KTNdiscoverSaveButtonLocalMenuID")).click();
            Thread.sleep(2000);
            SeleniumUtils.saveByName(driver, name);
            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //------------------------------------
           /* String expResult = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/div/div/div[3]/discover-app/kbn-top-nav/div/div/div/div[1]/div[4]/div/span/span")).getText().trim();
            SavedSearch obj = new SavedSearch();
            String className = obj.getClass().getSimpleName();
            System.out.println("Class Name : " + className + ".");
            actualOutcome = SeleniumUtils.verifyResult(driver, name, expResult, rec, className);*/

            //------------------------------------
            String expResult = driver.findElement(By.cssSelector("span[class='localBreadcrumb__emphasis']")).findElement(By.tagName("span")).getText().trim();
            System.out.println(expResult);
            SavedSearch obj = new SavedSearch();
            String className = obj.getClass().getSimpleName();
            System.out.println("Class Name : " + className + ".");
            actualOutcome = SeleniumUtils.verifyResult(driver, name, expResult, rec, className);
            //--------------------------------------
            //--------------------------------------

            SeleniumUtils.clickLogo(driver, wait, name);
            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {

            record.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-SAVE_SEARCH-01");
            record.setOutcome(actualOutcome);
            record.setName("Save Search.");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Save Search completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);
            if (!actualOutcome) {
                System.out.println("Login failed.");
                return actualOutcome;
            }
        }
        return actualOutcome;

    }
}
