package com.jdbc.automation.executor.Common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Records {

    private static final Logger log= LoggerFactory.getLogger(Records.class);

    public static int san_aut_id= 0;

    public static Boolean actualOutcome= false;
    public String testCaseName;  // SAN-01

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String name;   //Login with valid credentials

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public boolean outcome;
    public String expectedResult;

    public List<File> screenShot= new LinkedList<>();

    //@Beanc(properties = "name, outcome, expectedResult, screenshots")
    /*public Records(String name, String outcome, String expectedResult, List<OutputStream> screenShot)
    {
        this.name = name;
        this.outcome = outcome;
        this.expectedResult = expectedResult;
        this.screenShot = screenShot;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSan_aut_id() {
        return san_aut_id;
    }

    public static void setSan_aut_id(int san_aut_id) {
        Records.san_aut_id = san_aut_id;
    }

    /*public static int getSan_aut_id() {
        return san_aut_id;
    }

    public static void setSan_aut_id(int san_aut_id) {
        Records.san_aut_id = san_aut_id;
    }*/

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public List<File> getScreenShot() {
        return screenShot;
    }

    public void setScreenShot(List<File> screenShot) {
        this.screenShot = screenShot;
    }

    @Override
    public String toString() {

        System.out.println("Screenshots : "+screenShot.size());

        return "Records{" +
                "testCaseName='" + testCaseName + '\'' +
                ", name='" + name + '\'' +
                ", outcome=" + outcome +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}
