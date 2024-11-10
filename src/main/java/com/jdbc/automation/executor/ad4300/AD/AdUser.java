package com.jdbc.automation.executor.ad4300.AD;


import com.jdbc.automation.executor.Common.Records;
import com.jdbc.automation.executor.ad4300.Common.SeleniumUtils;
import com.jdbc.automation.executor.ad4300.widgets.AreaChart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdUser {

    private static final Logger log= LoggerFactory.getLogger(AreaChart.class);
    static Records rec = new Records();


    public static void adUser(WebDriver driver, WebDriverWait wait, List<Records> listOb) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        String user="automation";
        String loginMessage="You are not authorized to use this application. Please contact your system administrator.";

        String name = null;
        try {

            //SeleniumUtils.loginAdUser(driver, listOb,user,loginMessage,"inactiveuser");

            Thread.sleep(5000);

           // SeleniumUtils.loginBIValid(driver, listOb);

            //ManagementPresteps.managementPresteps(driver, wait, listOb, clientVersionDao, san_aut_id);

            SeleniumUtils.loginAdUserInWb(driver,wait ,user,listOb);

            //SeleniumUtils.loginAdUser(driver, listOb,user,loginMessage,"activeuser");

            Thread.sleep(3000);

            SeleniumUtils.validateUserInBI(driver);

            System.out.println("------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }

        record.setTestCaseName("SAN-AdUser");
        record.setOutcome(actualOutcome);
        record.setName("AD");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Ad User verification completed successfully.");

        listOb.add(record);

        if(!actualOutcome)
        {
            throw new Exception("Ad User verification failed");
        }

      }

    }


