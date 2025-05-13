//package com.jdbc.automation.executor.Common;
//
//import com.jdbc.automation.executor.Common.Records;
//import com.jdbc.dao.ClientVersionDao;
//import org.apache.commons.lang3.ArrayUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.awt.*;
//import java.io.File;
//import java.time.Duration;
//import java.util.List;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//import static com.jdbc.automation.executor.Common.Records.actualOutcome;
//
//public class SeleniumUtils23 {
//    private static ArrayUtils rgb;
//
//    private static final Logger log= LoggerFactory.getLogger(SeleniumUtils23.class);
//
//    public static void yDataFill(WebDriver driver, WebDriverWait wait, String widget) {
//        //Add Metric click
//        driver.findElement(By.id("bucketAddButtonID")).click();
//        //Y Axis click
//        driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
//        int y1Count = 3, y2Count = 3;
//        int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
//        log.info("lenY : " + lenY);
//
//        //Y Data entry
//        new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
//        log.info("Here");
//        new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
//        //Y arrow button close
//        driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();
//
//        /*for(int i=2;i<lenX-4;i++)
//        {
//            //Y Data entry
//            new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
//            new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
//            //Y arrow button close
//            driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();
//
//            //X Data entry
//            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByIndex(x1Count);
//            //X arrow button close
//            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
//
//        }*/
//    }
//
//    public static void xDataFill(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
//        int x1Count = 1, x2Count = 1;
//
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//*[@id=\"bucketButtonAddLabelID\"])[2]")).click();
//
//        int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
//        log.info("lenX : " + lenX);
//
//        new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
//        Thread.sleep(3000);
//        //X Axis Field fill
//        new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
//        Thread.sleep(3000);
//        //X arrow button close
//        driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
//
//
//        if (widget.equalsIgnoreCase("Area")) {
//            driver.findElement(By.id("bucketAddSubButtonID")).click();
//            //X Axis click                            //*[@id="bucketButtonAddLabelID"][2]
//            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][2]")).click();
//
//            new Select(driver.findElement(By.xpath("//*[@id=\"4bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
//            Thread.sleep(3000);
//            //X Axis Field fill
//            new Select(driver.findElement(By.xpath("//*[@id=\"4fieldSelectID\"]"))).selectByVisibleText("Discount");
//            Thread.sleep(3000);
//            //X arrow button close
//            driver.findElement(By.xpath("//*[@id=\"4metricExpandButtonIID\"]")).click();
//        }
//
//
//    }
////   public static boolean validateTitlePosition(WebDriver driver,String value) {
////         int counter = 0;
////        boolean flag = true;
//////        WebDriver driver = DriverFactory.getWebDriver()
////        try {
////
////            String newstr=driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElement(By.tagName("text")).getAttribute("style");
////
////
////            if(value.endsWith("RIGHT")) {
////
////                if(newstr.contains("text-anchor: end")){
////
////                    System.out.println("Title position: " +value );
////                }
////            }
////            else if(value.endsWith("LEFT")){
////
////                if(newstr.contains("text-anchor: start")){
////
////                    System.out.println("Title position: " +value );
////                }
////                else if(value.endsWith("CENTER")){
////
////                    if(newstr.contains("text-anchor: middle")){
////
////                        System.out.println("Title position: " +value );
////                    }
////
////
////                    else {
////                        flag = false;
////                        return flag;
////                    }
////                }
////            }
////        }	//end of try block
////        catch (StaleElementReferenceException ex) {
////            ex.printStackTrace();
////            counter++;
////            if (counter < 3) {
////                validateTitlePosition(driver,value);
////            }
////            else {
////                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
////                flag = false;
////                return flag;
////            } //end of inner if-else
////        } //end of catch block
////        return flag;
////    }	//end of method
//
//
//   /* public static void yDataFill(WebDriver driver, WebDriverWait wait, String widget) {
//        //Add Metric click
//        driver.findElement(By.id("bucketAddButtonID")).click();
//        //Y Axis click
//        driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
//        int y1Count = 3, y2Count = 3;
//        int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
//        log.info("lenY : " + lenY);
//
//        //Y Data entry
//        new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
//        log.info("Here");
//        new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
//        //Y arrow button close
//        driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();
//
//        *//*for(int i=2;i<lenX-4;i++)
//        {
//            //Y Data entry
//            new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
//            new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
//            //Y arrow button close
//            driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();
//
//            //X Data entry
//            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByIndex(x1Count);
//            //X arrow button close
//            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
//
//        }*//*
//    }*/
//
//    public static boolean validateMaxXLabels(WebDriver driver,int num) {
//
//        int c = 0;
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.cssSelector("g[class='tick']"));
//            int s = list.size();
//
//            for(int i = 0; i < s; i++) {
//
//                String dis = list.get(i).getAttribute("style");
//
//                if(dis.contains("display: block"))
//                {
//                    c++;
//                }
//            }	//end of for loop
//
//            if(c<=num) {
//                System.out.println(c + "<=" + num);
//            }
//            else {
//                flag = false;
//                return flag;
//            }
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateMaxXLabels(driver,num);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static void clickSelectButton(WebDriver driver,String colorPicker) {
//
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        String css = "div[class='" + colorPicker + "']";
//
//        WebElement we = driver.findElement(By.cssSelector(css)).findElement(By.className("select"));
//
//        we.click();
//    }
//
//    public static boolean validateTTBackgroundColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try{
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("rect"));
//            WebElement a = listOfPoints.get(1);
//            Actions builder = new Actions(driver);
//            Action mouseOver = builder.moveToElement(a).build();
//            mouseOver.perform();
//
//            WebElement we = driver.findElement(By.className("vis-tooltip"));
//            if (we.getText()=="") {
//                String sFontColor = we.getAttribute("style");
//                String actualColor ="background: rgb"+rgb.toString(index-1);
//                if(sFontColor.contains(actualColor)) {
//                    //System.out.println("The BG color for tooltip background is: "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The BG color for tooltip background is: "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }
//
//    public static boolean validateTTFontColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try{
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("rect"));
//            WebElement a = listOfPoints.get(1);
//            Actions builder = new Actions(driver);
//            Action mouseOver = builder.moveToElement(a).build();
//            mouseOver.perform();
//
//            WebElement we = driver.findElement(By.className("vis-tooltip"));
//            if (we.getText().equals("")) {
//                String sFontColor = we.getAttribute("style");
//                String actualColor = "color: rgb"+rgb.toString(index-1);
//                if(sFontColor.contains(actualColor)) {
//                    //	System.out.println("The font color for tooltip is: "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font color for tooltip is: "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateTTBorderColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try{
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("rect"));
//            WebElement a = listOfPoints.get(1);
//            Actions builder = new Actions(driver);
//            Action mouseOver = builder.moveToElement(a).build();
//            mouseOver.perform();
//
//            WebElement we = driver.findElement(By.className("vis-tooltip"));
//            if (we.getText()=="") {
//                String sFontColor = we.getAttribute("style");
//                String actualColor = "solid rgb"+rgb.toString(index-1);
//                if(sFontColor.contains(actualColor)) {
//                    //	System.out.println("The border color for tooltip is: "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The border color for tooltip is: "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch bloc
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateTTBorderWidth(WebDriver driver,String sTTBW) {
//
//        boolean sFlag=true;
//        String sActualBW = "border: "+sTTBW+"px";
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("rect"));
//            WebElement a = listOfPoints.get(1);
//            Actions builder = new Actions(driver);
//            Action mouseOver = builder.moveToElement(a).build();
//            mouseOver.perform();
//
//            WebElement we = driver.findElement(By.className("vis-tooltip"));
//            if (we.getText()=="") {
//                String sFontColor = we.getAttribute("style");
//                if(sFontColor.contains(sActualBW)) {
//                    //	System.out.println("The border width of tooltip is: "+sTTBW+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The border width of tooltip is: "+sTTBW+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateTTPointStrokeWidth(WebDriver driver,String sTTPSW) {
//
//        boolean sFlag=true;
//
//        String sActualPSW = "opacity: "+sTTPSW;
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("rect"));
//            WebElement a = listOfPoints.get(1);
//            Actions builder = new Actions(driver);
//            Action mouseOver = builder.moveToElement(a).build();
//            mouseOver.perform();
//
//            WebElement we = driver.findElement(By.className("vis-tooltip"));
//            if (we.getText()=="") {
//                String sFontColor = we.getAttribute("style");
//                if(sFontColor.contains(sActualPSW)) {
//                    //	System.out.println("The opacity of tooltip is: "+sTTPSW+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The opacity of tooltip is: "+sTTPSW+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateFontSizeTooltip(WebDriver driver,String sExpectedFontValue) {
//
//        boolean sFlag = true;
//        String actualFont ="font-size: " + sExpectedFontValue + "px";
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("rect"));
//            WebElement a = listOfPoints.get(1);
//            Actions builder = new Actions(driver);
//            Action mouseOver = builder.moveToElement(a).build();
//            mouseOver.perform();
//
//            WebElement we = driver.findElement(By.className("vis-tooltip"));
//            if (we.getText()=="" ){
//                String sFont = we.getAttribute("style");
//                if(sFont.contains(actualFont)) {
//                    //	System.out.println("The font size of Tooltip is: "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font size of Tooltip is: "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateRotateXTicks(WebDriver driver,String value) {
//
//        String rotvalue = "rotate("+ value + ")";
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("text"));
//
//            int s = list.size();
//
//            for(int i = 1; i < s; i++) {
//                String rot=list.get(i).getAttribute("transform");
//
//                System.out.println("Transform: " + rot);
//
//                if( rotvalue.equals(rot)) {
//
//                    System.out.println("Tick label rotated by " + value + "degrees");
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateRotateXTicks(driver,value);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateYTickFontColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
//
//        String sActualColor = rgb.toString(index-1);
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div']")));
//            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='y-axis-div']")).findElements(By.tagName("text"));
//            //List<WebElement> weSvg = driver.findElement(By.className("y-axis-div")).findElements(By.tagName("text"))
//            int listSize = weSvg.size();
//
//            for (int iCount = 0; iCount < listSize; iCount++) {
//
//                WebElement we = weSvg.get(iCount);
//
//                String sText = we.getText();
//
//                if (sText.equals("")) {
//
//                    String sFontColor = we.getAttribute("style");
//
//                    if(sFontColor.contains(sActualColor)) {
//                        //System.out.println("The font color for Y-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
//                    }
//                    else {
//                        System.out.println("The font color for Y-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
//                        sFlag = false;
//                        return sFlag;
//                    }
//                }	//end of outer if
//            }	//end of for loop
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateYTitleFontColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
//        String sActualColor = rgb.toString(index-1);
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div']")));
//            WebElement weSvg = driver.findElement(By.cssSelector("div[class='y-axis-div']")).findElement(By.tagName("text"));
//            String sText = weSvg.getText();
//            if (sText.equals("")) {
//
//                String sFontColor = weSvg.getAttribute("style");
//
//                if(sFontColor.contains(sActualColor)) {
//                    //	System.out.println("The font color for Y-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font color for Y-Title: "+weSvg.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateYAxisColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
//        String sActualColor = rgb.toString(index-1);
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div']")));
//            WebElement weSvg = driver.findElement(By.cssSelector("div[class='y-axis-div']")).findElement(By.cssSelector("path[class='domain']"));
//            //WebElement we = driver.findElement(By.className("y-axis-div")).findElement(By.className("domain"))
//
//            String sText = weSvg.getText();
//
//            if (sText.equals("")) {
//
//                String sFontColor = weSvg.getAttribute("style");
//
//                if(sFontColor.contains(sActualColor)) {
//                    //System.out.println("The font color for Y-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font color for Y-Axis: "+weSvg.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateFontSizeXTick(WebDriver driver,String sExpectedFontValue) {
//
//
//        String actualFont = sExpectedFontValue + "pt";
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));
//
//            int linkSize =  weSvg.size();
//
//            for (int iCount = 0; iCount < linkSize; iCount++) {
//                WebElement we = weSvg.get(iCount);
//
//                String sText = we.getText();
//
//                if (sText.equals("")) {
//                    String sFont = we.getAttribute("style");
//                    if(sFont.contains(actualFont)) {
//                        //	System.out.println("The font size of X-axis ticks: "+we.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
//                    }
//                    else {
//                        System.out.println("The font size of X-axis ticks: "+we.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
//                        sFlag = false;
//                        return sFlag;
//                    }   //End of inner if-else
//                } //End of outer if
//            }   //End of for loop
//        }   //End of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }    //End of catch block
//        return sFlag;
//    }// End of keyword
//
//    public static boolean validateXTickFontColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
//        String sActualColor = rgb.toString(index-1);
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));
//
//            int listSize = weSvg.size();
//            for (int iCount = 0; iCount < listSize; iCount++) {
//
//                WebElement we = weSvg.get(iCount);
//
//                String sText = we.getText();
//
//                if (sText.equals("")) {
//
//                    String sFontColor = we.getAttribute("style");
//
//                    if(sFontColor.contains(sActualColor)) {
//                        //System.out.println("The font color for X-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
//                    }
//                    else {
//                        System.out.println("The font color for X-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
//                        sFlag = false;
//                        return sFlag;
//                    }
//                }	//end of outer if
//            }	//end of for loop
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateXTitleFontColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
//        String sActualColor = rgb.toString(index-1);
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            WebElement weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElement(By.tagName("text"));
//
//            String sText = weSvg.getText();
//
//            if (sText.equals("")) {
//
//                String sFontColor = weSvg.getAttribute("style");
//
//                if(sFontColor.contains(sActualColor)) {
//                    //System.out.println("The font color for X-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font color for X-Title: "+weSvg.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }	//end of keyword
//    public static boolean validatePrefixXTick(WebDriver driver,String sExpectedPrefix) {
//
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));
//
//            int listSize = weSvg.size();
//
//            for (int iCount = 1; iCount < listSize; iCount++) {
//
//                WebElement we = weSvg.get(iCount);
//                String Xaxis_labels= we.getText();
//
//                if (Xaxis_labels.equals("")) {
//                    if(Xaxis_labels.startsWith(sExpectedPrefix)) {
//                        //	System.out.println("The prefix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS PASSED");
//                    }
//                    else {
//                        System.out.println("The prefix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS FAILED");
//                        sFlag = false;
//                        return sFlag;
//                    }	//end of inner if-else
//                }	//end of outer if
//            }   //end of for loop
//        }   //end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }   //end of catch block
//        return sFlag;
//    }  //end of method
//
//    public static boolean validateSuffixXTick(WebDriver driver,String sExpectedSuffix) {
//
//        boolean    sFlag  = true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));
//
//            int listSize = weSvg.size();
//
//            for (int iCount = 1; iCount < listSize; iCount++) {
//
//                WebElement we = weSvg.get(iCount);
//                String Xaxis_labels= we.getText();
//
//                if (Xaxis_labels.equals("")) {
//                    if(Xaxis_labels.endsWith(sExpectedSuffix)) {
//                        //	System.out.println("The suffix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS PASSED");
//                    }
//                    else {
//                        System.out.println("The suffix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS FAILED");
//                        sFlag = false;
//                        return sFlag;
//                    }   //end of inner if-else
//                }    //end of outer if
//            }    //end of for loop
//        }    //end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }    //end of catch block
//        return sFlag;
//    }// end of method
//    public static int noOfXFields(WebDriver driver) {
//
//        int field_size = 0;
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        List<WebElement> fields = driver.findElement(By.cssSelector("select[id='2fieldSelectID']")).findElements(By.tagName("option"));
//
//        int size = fields.size();
//
//        for(int i = 0; i < size; i++) {
//
//            String text = fields.get(i).getText();
//
//            if(text != "") {
//                field_size++;
//            }
//        }
//        return field_size;
//    }
//
//    public static int noOfXStringFields(WebDriver driver) {
//
//        int field_size = 0;
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        List<WebElement> fields = driver.findElement(By.cssSelector("select[id='2fieldSelectID']")).findElements(By.tagName("optgroup"));
//
//        List<WebElement> stringFields = fields.get(2).findElements(By.tagName("option"));
//
//        int size = stringFields.size();
//
//        for(int i = 0; i < size; i++) {
//
//            String text = stringFields.get(i).getText();
//
//            if(text != "") {
//                field_size++;
//            }
//        }
//        return field_size;
//    }	//end of method
//
//    public static boolean validateChartFormation(WebDriver driver) {
//
//        boolean height = true, sFlag = true;
//        int count = 0;
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        try {
//
//            List<WebElement> rect= driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='series 0']")).findElements(By.tagName("rect"));
//
//            int size = rect.size();
//
//            for(int i = 0; i < size; i++) {
//
//                WebElement we = rect.get(i);
//
//                String h = we.getAttribute("height");
//
//                if(h.equals("0")) {
//                    count++;
//                }
//            }
//            if(count == size) {
//                sFlag = false;
//                return sFlag;
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }
//
//    public static boolean clickDb(WebDriver driver,String value, String value1) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='a db-set']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class='a db-set']")).findElement(By.cssSelector("div[class='db-set-inner']")).findElements(By.tagName("db-list"));
//            //G
//            //List<WebElement> list=driver.findElement(By.cssSelector("div[class='a db-set']")).findElement(By.cssSelector("div[class='db-set-inner']"))
//
//            int size=list.size();
//            System.out.println("LIST SIZE :"+size);
//
//            for(int i=0;i<size;i++){
//                String str=list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).getAttribute("textContent");
//                System.out.println("DB NAME: "+str);
//                if(str.equals(value)){
//                    WebElement we=list.get(i).findElement(By.cssSelector("label[class='dbLabel']"));
//                    we.click();
//
//                    List<WebElement> list1=list.get(i).findElement(By.cssSelector("ul[class='subList']")).findElements(By.cssSelector("li[class='tableLabel']"));
//                    int Size=list1.size();
//                    System.out.println(Size);
//
//                    for(int j=0;j<Size;j++){
//                        String str1=list1.get(j).getText();
//                        System.out.println("Dataset Name inside:"+value+" is : "+str1);
//
//                        if(str1.equals(value1)){
//                            list1.get(j).click();
//                            break;
//                        }
//                    }
//                    break;
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean clickAddNew(WebDriver driver) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////            Thread.sleep(10000);
//            System.out.println("Inside add new");
//            Thread.sleep(2000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));
//            System.out.println("Element found");
//            Thread.sleep(10000);
//            WebElement we =driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.tagName("input"));
//            System.out.println("Text box found");
//            String str=we.getAttribute("class");
//            System.out.println("STR :"+str);
//            if(str.equals("form-control")){
//                System.out.println("Element is Visible");
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//            //end of catch block
//        }	//end of method
//        return flag;
//    }
//
//    public static boolean clickData(WebDriver driver) {
//
//        boolean flag= true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-bordered']")));
//
//            List<WebElement>  list=driver.findElement(By.cssSelector("tbody[class='highlight']")).findElements(By.cssSelector("tr[ng-repeat='tableDetails in tableMetaData']"));
//            //List<WebElement> list= driver.findElement(By.cssSelector("table[class='table table-bordered']")).findElements(By.cssSelector("tbody[class='highlight']"))
//
//            int size=list.size();
//            System.out.println("SIZE: "+size);
//
//            for(int j=0; j<size;j++){
//
//                String rowname=list.get(j).findElement(By.cssSelector("td[class='highlighted-name']")).getText();
//                System.out.println("ROW NAME: "+rowname);
//                //List<WebElement>  el = list.get(j).findElements(By.cssSelector("td[ng-repeat='functions in functionList ']"))
//                //List<WebElement> el = list.get(j).findElements(By.xpath("/ancestor::tr/td[contains(text(),'functions in tableDetails.functionDetails')]"))
//                List<WebElement>  el = list.get(j).findElements(By.cssSelector("td[ng-repeat='functions in tableDetails.functionDetails ']"));
//                int Size=el.size();
//                System.out.println(rowname+"---------------------------BEGIN-------------------------");
//                System.out.println("Size of ROW NAME : "+rowname+" is : "+Size);
//
//                for(int i=0; i<Size; i++){
//
//                    String str=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span")).getAttribute("class");
//                    System.out.println(" SPAN "+str);
//                    if(str.contains("checkmark-disabled")){
//                        System.out.println("continue");
//                    }
//                    else{
//                        WebElement elem=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span"));
//                        js.executeScript("arguments[0].click();", elem);
//                        //TimeUnit.SECONDS.sleep(3)
//                        System.out.println(i+". CHECKED");
//                    }
//                }
//                System.out.println(rowname+"---------------------------END-------------------------");
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean submitRunningProfile(WebDriver driver) throws AWTException {
//
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
////        System.setProperty("java.awt.headless", "false");
////        Robot rb=new Robot();
//
//        String value="Can't submit job as one instance of this profile is already running";
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-pulse']")));
//            System.out.println("Submit alert");
//
////            WebElement el=driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-pulse']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.xpath("(//div[@class='ajs-content'])[2]"));
//            WebElement el =  driver.findElement(By.xpath("(//div[@class='ajs-content'])[2]"));
//            String str=el.getText();
//            System.out.println("STRING------- "+str);
//
//            if(str.contains(value)){
//                System.out.println("pass");
//            }
//            else{
//                System.out.println("fail");
//            }
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean clickChart(WebDriver driver) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='sidepanel-tab-content']")));
//
//            List<WebElement> list = driver.findElement(By.cssSelector("div[class='sidepanel-tab-content']")).findElement(By.cssSelector("div[class='b data-status']")).findElements(By.tagName("li"));
//            int size=list.size();
//            System.out.println("list size:"+size);
//           list.get(0).findElement(By.cssSelector("span[class='status-icon']")).click();
//            System.out.println("clicked on chart icon");
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean searchDataList(WebDriver driver,String value) throws AWTException {
//
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        Robot rb=new Robot();
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='db-set-inner']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class='db-set-inner']")).findElements(By.cssSelector("db-list[ng-repeat='item in schemasList.schemas| filter:searchString']"));
//            int size=list.size();
//            for(int i=0;i<size;i++){
//
//
//                String str=list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).getText();
//                System.out.println("STRING "+str);
//
//                if(str.contains(value)){
//                    System.out.println("pass");
//                }
//                else{
//                    System.out.println("fail");
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean searchProfile(WebDriver driver,String value) throws AWTException {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        Robot rb=new Robot();
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElements(By.cssSelector("tr[ng-repeat='profiles in profilesList.functionDetails| filter:searchProfile']"));
//            int size=list.size();
//
//            for(int i=0;i<size;i++){
//
//                List<WebElement> list1=list.get(i).findElements(By.tagName("td"));
//                int Size=list1.size();
//
//                String  str=list1.get(2).getAttribute("textContent");
//                if(str.contains(value)){
//                    System.out.println("pass");
//                }
//                else{
//                    System.out.println("fail");
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean clickProfile(WebDriver driver) {
//
//        String str1="";
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        String value="QA_PROFILE";
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElements(By.cssSelector("tr[ng-repeat='profiles in profilesList.functionDetails| filter:searchProfile |orderBy:propertyName:reverse']"));
//            int size=list.size();
//
//            System.out.println("LIST SIZE "+size);
//
//            for(int i=0;i<size;i++){
//
//                List<WebElement> list1=list.get(i).findElements(By.tagName("td"));
//                int Size=list1.size();
//
//
//                String  str=list1.get(1).getAttribute("textContent");
//                str1=list1.get(2).getAttribute("textContent");
//
//                System.out.println("VALUE IS "+str);
//                System.out.println(str1);
//                if(str.contains(value)){
//                    list1.get(1).click();
//                }
//            }
//            List<WebElement> list2=driver.findElement(By.cssSelector("div[class='tableFixHead2 full-width-table intro-page-table']")).findElements(By.cssSelector("tr[ng-repeat='prevRuns in runData.functionDetails|orderBy:allJobsPropertyName:allJobsReverse']"));
//            int sizee=list2.size();
//            System.out.println(sizee);
//            String no_of_jobs = Integer.toString(sizee);
//            if(str1.equals(no_of_jobs)){
//                System.out.println("NO OF JOBS IS EQUAL: ");
//            }
//
//            WebElement el=list2.get(0).findElement(By.cssSelector("td[class='align-center']")).findElement(By.cssSelector("span[ng-click='loadPrevRuns(prevRuns.RUN_ID)']"));
//            el.click();
//
//            editProfile(driver);
//            System.out.println("edit");
//            TimeUnit.SECONDS.sleep(2);
//
//            WebElement ele=driver.findElement(By.cssSelector("div[class='back-btn ']")).findElement(By.tagName("i"));
//            ele.click();
//
//            System.out.println("back");
//
//            TimeUnit.SECONDS.sleep(2);
//
//            List<WebElement> list3=driver.findElements(By.cssSelector("tr[ng-repeat='prevRuns in runData.functionDetails|orderBy:allJobsPropertyName:allJobsReverse']"));
//
//            WebElement el1=list3.get(0).findElement(By.cssSelector("td[class='align-center']")).findElement(By.cssSelector("span[ng-click='viewReport(prevRuns.RUN_ID)']"));
//            el1.click();
//
//            displayReport(driver);
//
//            TimeUnit.SECONDS.sleep(2);
//            WebElement cross=driver.findElement(By.cssSelector("div[ng-show='showReport']")).findElement(By.cssSelector("button[class='submit-data-btn']"));
//            cross.click();
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean clickWorkspaceBI(WebDriver driver,String value) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='row cardholder']")));
//
//            List<WebElement> list = driver.findElement(By.cssSelector("div[class='row cardholder']")).findElements(By.cssSelector("ul[id='userProfiles']"));
//            int size=list.size();
//            System.out.println(size);
//            for(int i=0;i<size;i++){
//                WebElement we=list.get(i).findElement(By.cssSelector("div[class='card']")).findElement(By.cssSelector("div[class='container1']")).findElement(By.tagName("b"));
//                String str=we.getText();
//                System.out.println(str);
//                if(str.equals(value)){
//                    we.click();
//                }
//                else{
//                    continue;
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean clickProfile1(WebDriver driver, String user) {
//
//        String str1,str2;
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        String value="QA_PROFILE";
//        String no_of_jobs = Integer.toString(1);
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElements(By.cssSelector("tr[ng-repeat='profiles in profilesList.functionDetails| filter:searchProfile |orderBy:propertyName:reverse']"));
//            int size=list.size();
//
//            System.out.println("LIST SIZE of Data Profiles "+size);
//            for(int i=0;i<size;i++){
//
//                List<WebElement> list1=list.get(i).findElements(By.tagName("td"));
//                int Size=list1.size();
//
//                String  str=list1.get(1).getAttribute("textContent");
//                str=str.trim();
//                str1=list1.get(2).getAttribute("textContent");
//                str1=str1.trim();
//                str2=list1.get(5).getAttribute("textContent");
//                str2=str2.trim();
//                System.out.println("VALUE IS "+str);
//                System.out.println(str1);
//                System.out.println(str2);
//                if(str.equals(value)){
//                    System.out.println("one");
//                    if(str1.equals(no_of_jobs)){
//                        System.out.println("Pass one 1");
//                    }
//                    if(str2.equals(user)){
//                        System.out.println("Pass two 2");
//                    }
//                }
//                else{
//                    System.out.println("fail");
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean buttonOk1(WebDriver driver) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-flipx']")));
//
//            WebElement we = driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-flipx']")).findElement(By.cssSelector("div[class='ajs-primary ajs-buttons']")).findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
//            we.click();
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//  /*  public boolean displayReport(WebDriver driver) {
//
//        boolean flag=true;
//
//        String value="tableFixHead report-table-height";
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[ng-show='showReport']")));
//
//            List<WebElement> list=driver.findElements(By.cssSelector("div[ng-show='showReport']"));
//
//            String str=list.get(0).findElement(By.tagName("div")).getAttribute("class");
//
//            if(str.equals(value)){
//                System.out.println("Display Report Test Case Pass");
//            }
//
//            else{
//                System.out.println("Display Report Test Case Fail")
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString()
//            e.getMessage()
//            flag = false
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method*/
//
//    public static boolean editProfile(WebDriver driver) {
//
//        boolean flag=true;
//        String value="tableFixHead tableFixHead1  edit-table-height";
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='table-holder']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class='table-holder']")).findElements(By.tagName("div"));
//            int size=list.size();
//            System.out.println(size);
//            String str=list.get(0).getAttribute("class");
//
//            if(str.equals(value)){
//                System.out.println("Edit Profile Test Case Pass");
//            }
//            else{
//                System.out.println("Edit Profile Test Case Fail");
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean displayReport(WebDriver driver) {
//
//        boolean flag=true;
//
//        String value="tableFixHead report-table-height";
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            System.out.println("Inside report");
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[ng-show='showReport']")));
//
//            List<WebElement> list=driver.findElements(By.cssSelector("div[ng-show='showReport']"));
//
//            String str=list.get(0).findElement(By.tagName("div")).getAttribute("class");
//
//            if(str.equals(value)){
//                System.out.println("Display Report Test Case Pass");
//            }
//
//            else{
//                System.out.println("Display Report Test Case Fail");
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean clickOk1(WebDriver driver) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));
//
//            WebElement we = driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-primary ajs-buttons']")).findElement(By.cssSelector("button[class='ajs-button btn btn-danger']"));
//            we.click();
//            System.out.println("Clicked Ok");
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean addNewProfile(WebDriver driver) throws AWTException {
//
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        Robot rb=new Robot();
//        String value="Please select a table first";
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));
//
//            WebElement el=driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.cssSelector("div[class='ajs-content']"));
//
//            String str=el.getText();
//            System.out.println("STRING "+str);
//
//            if(str.contains(value)){
//                System.out.println("pass");
//            }
//            else{
//                System.out.println("fail");
//            }
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean dataValidate(WebDriver driver,List<String> value) {
//
//        boolean flag = true;
//        List<String> listA = new ArrayList<String>();
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='tableFixHead report-table-height']")));
//
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class='tableFixHead report-table-height']")).findElements(By.cssSelector("tr[ng-repeat='rows in report.rows']"));
//            int size=list.size();
//            System.out.println("LIST SIZE of ROWS : "+size);
//            for(int j=0;j<size;j++){
//                List<WebElement> el=list.get(j).findElements(By.cssSelector("td[ng-repeat='row in rows track by $index']"));
//                int Size=el.size();
//                System.out.println("LIST SIZE of Columns inside each ROW "+Size);
//
//                for(int i=0; i<Size; i++){
//                    //println("data profile")
//                    //String str=el.get(i).findElement(By.tagName("span")).getAttribute("textContent")
//                    String str=el.get(i).findElement(By.tagName("span")).getAttribute("class");
//                    if(str.equals("number")){
//
//                        String str1=el.get(i).findElement(By.tagName("span")).getAttribute("textContent");
//                        System.out.println(i+" VALUES: "+str1);
//                        listA.add(str1);
//                    }
//                }
//            }
//            System.out.println("list on screen: "+listA);
//            System.out.println("list pre-entered: "+value);
//            if(value.equals(listA)){
//                System.out.println("Test Case Successful");
//            }
//            else{
//                System.out.println("Data Mismatch");
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//
//
//    public static boolean validateXAxisColor(WebDriver driver,int index) {
//
//        boolean sFlag=true;
//        String sActualColor = rgb.toString(index-1);
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            WebElement weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElement(By.cssSelector("path[class='domain']"));
//
//            String sText = weSvg.getText();
//
//            if (sText.equals("")) {
//
//                String sFontColor = weSvg.getAttribute("style");
//
//                if(sFontColor.contains(sActualColor)) {
//                    //System.out.println("The font color for X-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font color for X-Axis: "+sText+" is "+sFontColor+" ------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//                }
//            }	//end of outer if
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateFontSizeXTitle(WebDriver driver,String sExpectedFontValue) {
//
//
//        String actualFont = sExpectedFontValue + "pt";
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
//            WebElement weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElement(By.tagName("text"));
//
//            String sText = weSvg.getText();
//
//            if (sText.equals("")) {
//                String sFont = weSvg.getAttribute("style");
//                if(sFont.contains(actualFont)) {
//                    //System.out.println("The font size of X-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
//                }
//                else {
//                    System.out.println("The font size of X-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
//                    sFlag = false;
//                    return sFlag;
//
//                }   //End of inner if-else
//            }   //End of outer if
//        } //End of try block
//
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        } //End of catch clock
//        return sFlag;
//    } //End of keyword
//
//    public static boolean validateLineColor(WebDriver driver,int index) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-y']")));
//
//            String newstr	= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElement(By.cssSelector("path[class='domain']")).getAttribute("style");
//
//            String str = "stroke: rgb" + rgb.toString(index-1);
//
//
//            if(newstr.contains(str)) {
//                System.out.println("LINE-COLOR:" +newstr);
//            }
//            else {
//                flag = false;
//                return flag;
//            }
//
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateLineColor(driver,index);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateTickColor(WebDriver driver,int index) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-y']")));
//
//            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int s=list.size();
//            String str = "stroke: rgb" + rgb.toString(index-1);
//
//            for(int i=0; i< s;i++){
//
//                String newstr=list.get(i).findElement(By.tagName("line")).getAttribute("style");
//
//                if(newstr.contains(str)) {
//                    System.out.println("TICK-COLOR:" +newstr);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }//end of for loop
//        }//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateTickColor(driver,index);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateFontColor(WebDriver driver,int index) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-y']")));
//
//            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int s=list.size();
//            String str = "fill: rgb" + rgb.toString(index-1);
//
//            for(int i=0; i< s;i++){
//
//                String newstr=list.get(i).findElement(By.tagName("text")).getAttribute("style");
//
//                if(newstr.contains(str)) {
//                    System.out.println("FONT-COLOR:" +str);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }//end of for loop
//        }//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateFontColor(driver,index);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateMetrics2(WebDriver driver) {
//
//        boolean flag = true;
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));
//
//            List<WebElement> spyLabels = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));
//
//            int spySize = spyLabels.size();
//
//            List<WebElement> ymetrics = driver.findElement(By.cssSelector("div[class='vis-editor-agg-group metrics']")).findElements(By.cssSelector("span[class='vis-editor-agg-header-description']"));
//
//            int ySize = ymetrics.size();
//
//            List<WebElement> xbuckets = driver.findElement(By.cssSelector("div[class='vis-editor-agg-group buckets']")).findElements(By.cssSelector("span[class='vis-editor-agg-header-description']"));
//
//            int xSize = xbuckets.size();
//
//            for(int i = 0; i < xSize; i++) {
//
//                String xvalue = xbuckets.get(i).getText();
//
//                String spyvalue = spyLabels.get(i).findElement(By.tagName("span")).getText();
//
//                int result = spyvalue.compareTo(xvalue);
//
//                if(result != 0) {
//                    flag = false;
//                }
//            }
//            for(int i = 0; i < ySize; i++) {
//
//                String yvalue = ymetrics.get(i).getText();
//
//                String spyvalue = spyLabels.get(i+xSize).findElement(By.tagName("span")).getText();
//
//                int result = spyvalue.compareTo(yvalue);
//
//                if(result != 0) {
//                    flag = false;
//                    return flag;
//                }
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("Stale Element Reference more than twice!!");
//            flag = false;
//            return flag;
//        }// end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateYExtends(WebDriver driver,String YAxisMax , String YAxisMin) {
//
//        double ymax = Double.parseDouble(YAxisMax);
//
//        double ymin = Double.parseDouble(YAxisMin);
//
//        boolean sFlag=true;
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div-wrapper']")));
//
//            List<WebElement> listOfPoints = driver.findElement(By.cssSelector("div[class='y-axis-div-wrapper']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int listSize = listOfPoints.size();
//
//            for(int iCount = 0; iCount < listSize; iCount++) {
//
//                String ytick = listOfPoints.get(iCount).findElement(By.tagName("text")).getText();
//
//                ytick = ytick.replace(',', ' ');
//
//                double yval = Double.parseDouble(ytick);
//
//                if((yval <= ymax) || (yval >= ymin)) {
//                    //println("Y Tick " + yval + " in range")
//                }
//                else {
//                    sFlag = false;
//                    return sFlag;
//                }
//            } // end for loop
//
//        } catch (Exception ex) {
//            System.out.println("Stale Element Reference more than twice!!");
//            sFlag = false;
//            return sFlag;
//        }// end of catch block
//        return sFlag;
//    }	//end of function
//    public static double min(ArrayList<String> asd) {
//
//        int length = asd.size();
//        String minVal = asd.get(0);
//
//        double minIntVal = Double.parseDouble(minVal);
//        for(int i=1;i<length; i++) {
//
//            String temp = asd.get(i);
//
//            double tempIntVal = Double.parseDouble(temp);
//            if(tempIntVal<minIntVal) {
//                minIntVal = tempIntVal;
//                minVal= temp;
//            }	//end of if
//        }	//end of for loop
//        return minIntVal;
//    }	//end of function
//
//    public static double max(ArrayList<String> asd) {
//
//        int length = asd.size();
//        String maxVal = asd.get(0);
//
//        double maxIntVal = Double.parseDouble(maxVal);
//        for(int i=1;i<length; i++) {
//
//            String temp = asd.get(i);
//
//            double tempIntVal = Double.parseDouble(temp);
//            if(tempIntVal>maxIntVal) {
//                maxIntVal = tempIntVal;
//                maxVal = temp;
//            }	//end of if
//        }	//end of for loop
//        return maxIntVal;
//    }	//end of function
//
//    public static boolean validateYExtendsToDataBounds(WebDriver driver) {
//
//        boolean sFlag=true;
//
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chart-wrapper-row")));
//
//            List<WebElement> weSvgDL = driver.findElement(By.className("chart-wrapper-row")).findElements(By.tagName("text"));
//            ArrayList<String> DL = new ArrayList<String>();
//            int listSizeDL =  weSvgDL.size();
//            for(int i = 0; i < listSizeDL; i++) {
//                String temp = weSvgDL.get(i).getText();
//                temp = temp.replace(',', ' ');
//                DL.add(i, temp);
//            }	//end of for loop
//
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("y-axis-div")));
//
//            List<WebElement> weSvgYT = driver.findElement(By.cssSelector("div[class='y-axis-div-wrapper']")).findElements(By.cssSelector("g[class='tick']"));
//            int listSizeYT = weSvgYT.size();
//
//            double minimum = min(DL);
//            double maximum = max(DL);
//
//            for(int i = 0; i < listSizeYT; i++) {
//
//                String temp = weSvgYT.get(i).getText();
//                temp = temp.replace(',', ' ');
//                double s = Double.parseDouble(temp);
//                if(!(s == 0.00)) {
//                    if((s<=maximum) && (s>=minimum)) {
//                        sFlag = true;
//                        //println("Y Tick " + s + " is within range.")
//                    }
//                    else {
//                        System.out.println("Y Tick " + s + " is not within range!");
//                        sFlag = false;
//                        return sFlag;
//                    }
//                }	//end of outer if
//            }	//end of for loop
//        }	//end of try block
//
//        catch (Exception ex) {
//            System.out.println("Stale Element Reference more than twice!!");
//            sFlag = false;
//            return sFlag;
//        }// end of catch block
//        return true;
//    }	//end of function
//
//    public static boolean LegendPosition(WebDriver driver,String sPosition) {
//
//        boolean sFlag=true;
////        WebDriver driver  = DriverFactory.getWebDriver()
//
//        try {
//            String POSITION             = "";
//            String LEFT_VALIDATOR_TAG   = "vis-container vis-container--legend-left";
//            String RIGHT_VALIDATOR_TAG  = "vis-container vis-container--legend-right";
//            String BOTTOM_VALIDATOR_TAG = "vis-container vis-container--legend-bottom";
//            String TOP_VALIDATOR_TAG    = "vis-container vis-container--legend-top";
//
//            if (sPosition.equalsIgnoreCase("bottom")) {
//                POSITION = BOTTOM_VALIDATOR_TAG;
//            } else if (sPosition.equalsIgnoreCase("top")) {
//                POSITION = TOP_VALIDATOR_TAG;
//            } else if (sPosition.equalsIgnoreCase("right")) {
//                POSITION = RIGHT_VALIDATOR_TAG;
//            } else {
//                POSITION = LEFT_VALIDATOR_TAG;
//            }
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[id='style-1']")));
//
//            WebElement legendPosition = driver.findElement(By.cssSelector("div[id='style-1']"));
//
//            String value = legendPosition.getAttribute("class");
//
//            if (value.equalsIgnoreCase(POSITION)) {
//                System.out.println("Legend is present at " + sPosition + "------>TEST CASE PASS");
//            } else {
//                System.out.println("Legend is not present at " + sPosition + "------>TEST CASE FAIL");
//                sFlag = false;
//                return sFlag;
//            }
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("Stale Element Reference more than twice!!");
//            sFlag = false;
//            return sFlag;
//        }// end of catch block
//
//        return sFlag;
//    }	//end of keyword
//
//    public static boolean validateMetrics3(WebDriver driver) {
//
//        boolean flag = true;
//
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        List lhsYHeaders = new ArrayList();
//
//        List lhsXHeaders = new ArrayList();
//
//        try{
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));
//            //Spy Table headers
//            List<WebElement> spyHeaders = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tree-table-vis-headers")));
//            //Chart Table headers
//            List<WebElement> tableHeaders = driver.findElement(By.tagName("tree-table-vis-headers")).findElement(By.cssSelector("div[class*='tree-headers']")).findElements(By.tagName("div"));
//
//            for(int i = 1; i <= 5; i++) {
//                // For left side metric/buckets names
//                String id = i + "metricDescriptionID";
//
//                String we = driver.findElement(By.id(id)).getAttribute("textContent");
//
//                we = we.trim();
//
//                if((i == 4) || (i == 5)) {
//                    lhsXHeaders.add(we);
//                }
//                else {
//                    lhsYHeaders.add(we);
//                }
//            }	//end of for loop
//            //Y Headers
//
//            int YSize = lhsYHeaders.size();
//
//            for(int i = 0; i < YSize; i++) {
//
//                String lhs = String.valueOf(lhsYHeaders.get(i));
//
//
//                System.out.println("LHS Y: " + lhs);
//                // i+1 is done as 0th i refers to whole header row and 1st i refer Region
//                String chart = tableHeaders.get(i+1).getAttribute("textContent");
//
//                chart = chart.trim();
//
//                System.out.println("Chart Y: " + chart);
//
//                String spy1 = spyHeaders.get(i+1).findElement(By.tagName("span")).getAttribute("textContent");
//
//                spy1 = spy1.trim();
//
//                System.out.println("Spy First Half Y: " + spy1);
//
//                String spy2 = spyHeaders.get(i+5).findElement(By.tagName("span")).getAttribute("textContent");
//
//                spy2 = spy2.trim();
//
//                System.out.println("Spy Second Half: " + spy2);
//
//                boolean r1 = lhs.equals(chart);
//                boolean r2 = lhs.equals(spy1);
//                boolean r3 = lhs.equals(spy2);
//
//                if(!r1 || !r2 || !r3) {
//                    flag = false;
//                }
//            }	//end of Y Headers
//            //X Headers
//
//            int XSize = lhsXHeaders.size();
//
//            List<WebElement> x = tableHeaders.get(0).findElements(By.tagName("span"));
//
//            for(int i = 0; i < XSize; i++) {
//
//                boolean r2;
//
//                String lhs = String.valueOf(lhsXHeaders.get(i));
//
//                System.out.println("LHS X: " + lhs);
//
//                String chart = x.get(i*2).getAttribute("textContent");
//
//                chart = chart.trim();
//
//                System.out.println("Chart X: " + chart);
//
//                String spy1 = spyHeaders.get(0).findElement(By.tagName("span")).getAttribute("textContent");
//
//                spy1 = spy1.trim();
//
//                System.out.println("Spy First Half X: " + spy1);
//
//                String spy2 = spyHeaders.get(4).findElement(By.tagName("span")).getAttribute("textContent");
//
//                spy2 = spy2.trim();
//
//                System.out.println("Spy Second Half X: " + spy2);
//
//                boolean r1 = chart.startsWith(lhs);
//
//                if(i == 0) {
//                    r2 = chart.startsWith(spy1);
//                }
//                else {
//                    r2 = chart.startsWith(spy2);
//                }
//                if(!r1 || !r2) {
//                    flag = false;
//                }
//            }	//end of XHeaders
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateHeaderOptions(WebDriver driver,String property, String value) {
//
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try{
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tree-table-vis-headers")));
//
//            WebElement we = driver.findElement(By.tagName("tree-table-vis-headers")).findElement(By.cssSelector("div[class*='tree-headers']"));
//
//            String style = we.getAttribute("style");
//            boolean r = true;
//            int val = 0;
//
//            switch(property) {
//
//                case "Font Size":
//                    String font_size = "font-size: " + value + "px;";
//                     r = style.contains(font_size);
//                    if(!r) {
//                        flag = false;
//                    }
//                    break;
//
//                case "Font Color":
//                    val = Integer.parseInt(value);
//                    String font_color = "color: rgb" + rgb.toString(val-1) + ";";
//                    r = style.contains(font_color);
//                    if(!r) {
//                        flag = false;
//                    }
//                    break;
//
//                case "BG Color":
//                    val = Integer.parseInt(value);
//                    String bg_color = "background-color: rgb" + rgb.toString(val-1) + ";";
//                    r = style.contains(bg_color);
//                    if(!r) {
//                        flag = false;
//                    }
//                    break;
//                case "Bold":
//                    String bold = "font-weight: 800";
//                    r = style.contains(bold);
//                    if(!r) {
//                        flag = false;
//                    }
//                    break;
//                case "Italics":
//                    String italic = "font-style: italic";
//                    r = style.contains(italic);
//                    if(!r) {
//                        flag = false;
//                    }
//                    break;
//            }	//end of switch-case
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateRowOptions(WebDriver driver,String property, String value) {
//
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try{
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tree-table-vis-rows")));
//
//            List<WebElement> we = driver.findElement(By.tagName("tree-table-vis-rows")).findElements(By.cssSelector("div[class='col-xs-12 tree-rows tree-rows']"));
//
//            int len = we.size();
//            boolean r= true;
//            int val = 0;
//
//            for(int i = 0; i < len; i++) {
//                String style = we.get(i).getAttribute("style");
//
//                switch(property) {
//
//                    case "Font Size":
//                        String font_size = "font-size: " + value + "px;";
//                        r = style.contains(font_size);
//                        if(!r) {
//                            flag = false;
//                        }
//                        break;
//
//                    case "Font Color":
//                        val = Integer.parseInt(value);
//                        String font_color = "color: rgb" + rgb.toString(val-1) + ";";
//                        r = style.contains(font_color);
//                        if(!r) {
//                            flag = false;
//                        }
//                        break;
//
//                    case "BG Color":
//                        val = Integer.parseInt(value);
//                        String bg_color = "background-color: rgb" + rgb.toString(val-1) + ";";
//                        r = style.contains(bg_color);
//                        if(!r) {
//                            flag = false;
//                        }
//                        break;
//
//                    case "Bold":
//                        String bold = "font-weight: bold";
//                        r = style.contains(bold);
//                        if(!r) {
//                            flag = false;
//                        }
//                        break;
//
//                    case "Italics":
//                        String italic = "font-style: italic";
//                        r = style.contains(italic);
//                        if(!r) {
//                            flag = false;
//                        }
//                        break;
//                }	//end of switch-case
//            }	//end of for loop
//        }	//end of try block
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateMaxXTickLength(WebDriver driver,int value) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("text"));
//
//            int s = list.size();
//            for(int i = 1; i < s; i++) {
//
//                String str=list.get(i).findElement(By.tagName("tspan")).getText();
//
//                int len=str.length();
//
//                if(len <= value) {
//
//                    System.out.println(len + "<=" + value);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateMaxXTickLength(driver,value);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateFontSize(WebDriver driver,String value) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("text"));
//
//            int s = list.size();
//
//            for(int i = 1; i < s; i++) {
//
//                String str=list.get(i).getAttribute("style");
//                String newstr="font-size: "+ value +"pt";
//
//                if(str.contains(newstr)){
//
//                    System.out.println("FONT-SIZE: " + value);
//                }
//
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateFontSize(driver,value);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateY2Extent(WebDriver driver,int max, int min){
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int s = list.size();
//            System.out.println("Size of Y2 extent : "+s);
//
//            for(int i = 0; i < s; i++) {
//
//                int value=Integer.valueOf(list.get(i).findElement(By.tagName("tspan")).getText());
//
//                if( value<= max && value >= min ) {
//
//                    System.out.println("Y2extent: " +value);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateY2Extent(driver,max,min);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
////    public static boolean validatePrefixSuffix(WebDriver driver,String prefix, String suffix){
////
////
////        int counter = 0;
////        boolean flag = true;
//////        WebDriver driver = DriverFactory.getWebDriver()
////
////        try {
////            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));
////
////            int s = list.size();
////            for(int i = 0; i < s; i++) {
////
////                String value=list.get(i).findElement(By.tagName("tspan")).getText();
////
////                boolean first = value.startsWith(prefix);
////
////                boolean last = value.endsWith(suffix);
////                if(first && last ) {
////                    //if( value.startsWith(prefix) && value.endsWith(suffix) ){
////
////                    System.out.println("Prefix-Suffix: " +value);
////                }
////                else {
////                    flag = false;
////                    return flag;
////                }
////            }	//end of for loop
////        }	//end of try block
////        catch (StaleElementReferenceException ex) {
////            ex.printStackTrace();
////            counter++;
////            if (counter < 3) {
////                validatePrefixSuffix(driver,prefix,suffix);
////            }
////            else {
////                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
////                flag = false;
////                return flag;
////            } //end of inner if-else
////        } //end of catch block
////        return flag;
////    }	//end of method
//
//    public static boolean validateBoldFont(WebDriver driver) {
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.cssSelector("g[class='tick']"));
//            int s = list.size();
//
//
//            for(int i = 0; i < s; i++) {
//
//                String str= "font-weight: bold";
//                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");
//                System.out.println("string" +dis);
//                if(dis.contains(str)) {
//                    System.out.println("Bold-Font: " +str);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateBoldFont(driver);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateFontFamily(WebDriver driver,String  value) {
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        try {
//
//
//            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int s=list.size();
//
//            String str="font-family: " +value+";";
//
//            System.out.println(str);
//            for(int i = 0; i < s;i++)
//            {
//                String newstr = list.get(i).findElement(By.tagName("text")).getAttribute("style");
//
//                if(newstr.contains(str))
//                {
//                    System.out.println("Font-Family: "+value);
//                }
//
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateFontFamily(driver,value);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateYExtent(WebDriver driver,int max, int min){
//
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int s = list.size();
//            for(int i = 0; i < s; i++) {
//
//                int value=Integer.valueOf(list.get(i).findElement(By.tagName("tspan")).getText());
//
//                if(value<= max && value >= min ) {
//
//                    System.out.println("Yextent: " +value);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateYExtent(driver,max,min);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validatePrefixSuffix(WebDriver driver,String prefix, String suffix){
//
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
//
//            int s = list.size();
//            for(int i = 0; i < s; i++) {
//
//                String value=list.get(i).findElement(By.tagName("tspan")).getText();
//
//                boolean first = value.startsWith(prefix);
//
//                boolean last = value.endsWith(suffix);
//                if(first && last ) {
//                    //if( value.startsWith(prefix) && value.endsWith(suffix) ){
//
//                    System.out.println("Prefix-Suffix: " +value);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validatePrefixSuffix(driver,prefix,suffix);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateTitlePosition(WebDriver driver,String value) {
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        try {
//
//            String newstr=driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElement(By.tagName("text")).getAttribute("style");
//
//
//            if(value.endsWith("TOP")) {
//
//                if(newstr.contains("text-anchor: end")){
//
//                    System.out.println("Title position: " +value );
//                }
//            }
//            else if(value.endsWith("BOTTOM")){
//
//                if(newstr.contains("text-anchor: start")){
//
//                    System.out.println("Title position: " +value );
//                }
//                else if(value.endsWith("MIDDLE")){
//
//                    if(newstr.contains("text-anchor: middle")){
//
//                        System.out.println("Title position: " +value );
//                    }
//
//
//                    else {
//                        flag = false;
//                        return flag;
//                    }
//                }
//            }
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateTitlePosition(driver,value);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateItalicsFont(WebDriver driver) {
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.cssSelector("g[class='tick']"));
//            int s = list.size();
//
//            for(int i = 0; i < s; i++) {
//
//                String str="font-style: italic";
//                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");
//
//
//                if(dis.contains(str)) {
//                    System.out.println("Italics-Font: " +str);
//                }
//                else {
//                    flag = false;
//                    return flag;
//                }
//            }	//end of for loop
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateItalicsFont(driver);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateTitleText(WebDriver driver,String value) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            String newstr	= driver.findElement(By.cssSelector("text[class='c3-axis-y-label']")).getText();
//
//
//            if(value.equals(newstr)) {
//                System.out.println("Title text: " + newstr);
//            }
//            else {
//                flag = false;
//                return flag;
//            }
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateTitleText(driver,value);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static boolean validateTitleText(WebDriver driver) {
//
//        int counter = 0;
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            String str = driver.findElement(By.cssSelector("span[id='2metricDescriptionID']")).getText();
//            String newstr	= driver.findElement(By.cssSelector("text[class='c3-axis-x-label']")).getText();
//
//            System.out.println("STR: " + str);
//            if(str.startsWith(newstr)) {
//                System.out.println("Title text: " + newstr);
//            }
//            else {
//                flag = false;
//                return flag;
//            }
//        }	//end of try block
//        catch (StaleElementReferenceException ex) {
//            ex.printStackTrace();
//            counter++;
//            if (counter < 3) {
//                validateTitleText(driver);
//            }
//            else {
//                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//                flag = false;
//                return flag;
//            } //end of inner if-else
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//
//    public static void yDataFillTree(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
//        //Add Metric click
//        int j=0;
////        for (int i = 2; i <= 13; i++) {
//        for (int i = 2; i <= 12; i++) {
//
//            driver.findElement(By.id("bucketAddButtonID")).click();
//            //Y Axis click
//            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
//            int y1Count = 2, y2Count = 2;
//
//            int lenYY = new Select(driver.findElement(By.id(i+"bucketSelectButtonID"))).getOptions().size();
//            log.info("lenY : " + lenYY);
//
//           /* int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
//            log.info("lenY : " + lenY);*/
//
//            //Y Data entry
//            /* new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
//            log.info("Here");*/
//
//            if(i<7) {
//
//                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i);
//                log.info("Here");
//             new Select(driver.findElement(By.id(+i+"fieldSelectID"))).selectByIndex(i);
//
//            }
//            else if(i>=7){
//                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i-5);
//                log.info("Here");
//                new Select(driver.findElement(By.id(+i+"fieldSelectID"))).selectByIndex(i-6);
//            }
//
//            // new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
//            // Y arrow button close
//            //driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();
//
//            //To minimize
//            driver.findElement(By.id(+i+"metricExpandButtonIID")).click();
//
//            String selectedMetric = driver.findElement(By.id(+i+"metricDescriptionID")).getText().trim();
//            if(selectedMetric.equalsIgnoreCase("Median date")
//                    || selectedMetric.equalsIgnoreCase("Max date"))
//            {
//                driver.findElement(By.id(+i+"metricDisableAggregationIID")).click();
//                Thread.sleep(2000);
//            }
//        }
//    }
//
//    public static void xDataFillCombo(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
//        int x1Count = 1, x2Count = 1;
//
//        Thread.sleep(2000);
//        List<WebElement> list = driver.findElements(By.cssSelector("li[id='bucketButtonAddLabelID']"));
//        int size = list.size();
//        System.out.println("Size Info" + size);
//
//        for (int i = 0; i < size; i++) {
//
//            String str = list.get(i).getText().trim();
//            System.out.println("string" + str);
//            if (str.equalsIgnoreCase("X-Axis") || str.equalsIgnoreCase("Split Rows")) {
//                list.get(i).click();
//                break;
//            } else {
//                continue;
//            }
//        }
//        //list.get(1).click();
//        //driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
//        if(widget.equalsIgnoreCase("Combo")) {
//            int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
//            log.info("lenX : " + lenX);
//
//            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
//            Thread.sleep(3000);
//            //X Axis Field fill
//            new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
//            Thread.sleep(3000);
//            //X arrow button close
//            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
//        }
//        else if(widget.equalsIgnoreCase("Area")) {
//            driver.findElement(By.id("bucketAddSubButtonID")).click();
//            //X Axis click                            //*[@id="bucketButtonAddLabelID"][2]
//            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][2]")).click();
//
//            new Select(driver.findElement(By.xpath("//*[@id=\"4bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
//            Thread.sleep(3000);
//            //X Axis Field fill
//            new Select(driver.findElement(By.xpath("//*[@id=\"4fieldSelectID\"]"))).selectByVisibleText("Discount");
//            Thread.sleep(3000);
//            //X arrow button close
//            driver.findElement(By.xpath("//*[@id=\"4metricExpandButtonIID\"]")).click();
//        }
//
//    }
//
//    public static void xDataFillTree(WebDriver driver, WebDriverWait wait) throws InterruptedException {
//        int x1Count = 1, x2Count = 1;
//
//        Thread.sleep(2000);
//
//
//        for(int i=14;i<=15;i++) {
//            List<WebElement> list = driver.findElements(By.cssSelector("li[id='bucketButtonAddLabelID']"));
//            int size = list.size();
//            System.out.println("Size Info" + size);
//            String str = list.get(1).getText().trim();
//            System.out.println("string" + str);
//            if (str.equalsIgnoreCase("Split Rows")) {
//                list.get(1).click();
//            }
//
//            driver.findElement(By.id("bucketAddSubButtonID")).click();
//            //X Axis click
//            new Select(driver.findElement(By.id(i+"bucketSelectButtonID"))).selectByVisibleText("Terms");
//            Thread.sleep(3000);
//            //X Axis Field fill
//            if(i==14) {
//                new Select(driver.findElement(By.id(i +"fieldSelectID"))).selectByVisibleText("Region");
//                Thread.sleep(3000);
//                driver.findElement(By.id(i+"metricExpandButtonIID")).click();
//            }
//            else {
//                //X arrow button close
//                new Select(driver.findElement(By.id(i +"fieldSelectID"))).selectByVisibleText("City");
//                Thread.sleep(3000);
//                driver.findElement(By.id(i + "metricExpandButtonIID")).click();
//
//            }
//        }
//    }
//
//
//    /*public static void afterStepsSavedObjects(WebDriver driver, WebDriverWait wait, String dsw) throws InterruptedException {
//
//        List<WebElement> webEl = new ArrayList<WebElement>();
//
//        int k = 0, j = 0;
//        if (dsw.equals("Dashboards")) {
//            j = 2;
//        } else if (dsw.equals("Searches")) {
//            j = 3;
//            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/ul/li[2]/a")).click();
//        } else if (dsw.equals("Widgets")) {
//            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/ul/li[3]/a")).click();
//            j = 4;
//        }
//        Thread.sleep(3000);
//
//        for (int i = 1; i < 5; i++) {
//            try {                                                        //*[@id="kibana-body"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[3]/ul/li[1]/div[2]/input
//                //log.info("i=" + i);                           //*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[3]/ul/li[2]/div[2]/input
//                webEl.add(k, driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[" + j + "]/ul/li[" + i + "]/div[2]/input")));
//                //log.info("j:" + j);
//                //log.info("WebEl : " + webEl.get(k));
//                //log.info("WebEl Size: " + webEl.size());
//                k = k + 1;
//            } catch (Exception e) {
//                log.error("",e);
//            }
//        }
//        log.info("Size of Dashboards : " + webEl.size());
//        Thread.sleep(2000);
//
//        //Checkbox is clicked
//        List<WebElement> checkBox = webEl;
//        for (int i = 0; i < webEl.size(); i++) {
//            checkBox.get(i).click();
//        }
//        //Export                                  //*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[2]
//        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[2]")).click();
//        Thread.sleep(20000);
//        //Uncheck
//        for (int i = 1; i < webEl.size(); i++) {
//            checkBox.get(i).click();
//        }
//        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[1]")).click();
//
//        SeleniumUtils23.waitForAlert(driver);
//    }*/
//
//    public static void afterStepsSavedObjects(WebDriver driver, WebDriverWait wait, String dsw) throws InterruptedException {
//
//        List<WebElement> webEl = new ArrayList<WebElement>();
//
//        int k = 0, j = 0;
//        if (dsw.equals("Dashboards")) {
//            j = 2;
//        } else if (dsw.equals("Searches")) {
//            j = 3;
//            driver.findElement(By.cssSelector("a[title='searches']")).click();
//        } else if (dsw.equals("Widgets")) {
//            driver.findElement(By.cssSelector("a[title='widgets']")).click();
//            j = 4;
//        }
//        Thread.sleep(3000);
//
//        try {
//            // webEl.add(k, driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[" + j + "]/ul/li[" + i + "]/div[2]/input")));
//            List<WebElement> list = driver.findElement(By.cssSelector("div[class='tab-pane active']")).findElements(By.cssSelector("li[class='item']"));
//            System.out.println(list.size());
//            for (int i = 1; i < 5; i++) {
//                WebElement el = list.get(i).findElement(By.cssSelector("div[class='pull-left checkbox-margin']")).findElement(By.tagName("input"));
//                webEl.add(k, el);
//
//                //log.info("j:" + j);
//                //log.info("WebEl : " + webEl.get(k));
//                //log.info("WebEl Size: " + webEl.size());
//
//                k = k + 1;
//            }
//        } catch (Exception e) {
//            log.error("", e);
//        }
//
//        log.info("Size of Dashboards : " + webEl.size());
//        Thread.sleep(2000);
//
//        //Checkbox is clicked
//        List<WebElement> checkBox = webEl;
//        for (int i = 0; i < webEl.size(); i++) {
//            checkBox.get(i).click();
//        }
//
//        //Export
//        driver.findElement(By.cssSelector("a[class='btn btn-xs btn-default']")).click();
//        Thread.sleep(13000);
//        //Uncheck
//        for (int i = 1; i < webEl.size(); i++) {
//            checkBox.get(i).click();
//        }
//
//        driver.findElement(By.cssSelector("a[class='btn btn-xs btn-danger']")).click();
//        Thread.sleep(2000);
//        SeleniumUtils23.waitForAlert(driver);
//        Thread.sleep(8000);
//    }
//    public static int noOfYFields(WebDriver driver) {
//
//        int field_size = 0;
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        List<WebElement> fields = driver.findElement(By.cssSelector("select[id='1fieldSelectID']")).findElements(By.tagName("option"));
//
//        int size = fields.size();
//
//        for(int i = 0; i < size; i++) {
//
//            String text = fields.get(i).getText();
//
//            if(text != "") {
//                field_size++;
//            }
//        }
//        return field_size;
//    }
//
////    public static boolean validateChartFormation(WebDriver driver) {
////
////        boolean height = true, sFlag = true;
////        int count = 0;
////
//////        WebDriver driver = DriverFactory.getWebDriver();
////
////        try {
////
////            List<WebElement> rect= driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='series 0']")).findElements(By.tagName("rect"));
////
////            int size = rect.size();
////
////            for(int i = 0; i < size; i++) {
////
////                WebElement we = rect.get(i);
////
////                String h = we.getAttribute("height");
////
////                if(h.equals("0")) {
////                    count++;
////                }
////            }
////            if(count == size) {
////                sFlag = false;
////                return sFlag;
////            }
////        }
////        catch (Exception ex) {
////            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
////            sFlag = false;
////            return sFlag;
////        }	//end of catch block
////        return sFlag;
////    }
//    public static String spyHeaderY(WebDriver driver) {
//
//        String spyY, msg;
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));
//
//            List<WebElement> spyLabels = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));
//
//            spyY = spyLabels.get(1).findElement(By.tagName("span")).getText();
//        }
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            msg = "STALE ELEMENT REFERENCE MORE THAN TWICE!!";
//            return msg;
//        }	//end of catch block
//
//        return spyY;
//    }
//
//    public static boolean validateMetrics(WebDriver driver) {
//
////        WebDriver driver = DriverFactory.getWebDriver();
//
//        String lhsY, lhsX, spyY, spyX, chartY, chartX;
//        boolean r1, r2, r3, r4, sFlag = true;
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));
//
//            List<WebElement> spyLabels = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));
//
//            spyX = spyLabels.get(0).findElement(By.tagName("span")).getText();
//
//            System.out.println("Spy X: " + spyX);
//
//            spyY = spyHeaderY(driver);
//
//            System.out.println("Spy Y: " + spyY);
//
//            lhsY = driver.findElement(By.cssSelector("span[id='1metricDescriptionID']")).getText();
//
//            System.out.println("LHS Y: " + lhsY);
//
//            lhsX = driver.findElement(By.cssSelector("span[id='2metricDescriptionID']")).getText();
//
//            System.out.println("LHS X: " + lhsX);
//
//            chartY = driver.findElement(By.cssSelector("div[class='y-axis-title']")).findElement(By.tagName("text")).getText();
//
//            System.out.println("Chart Y: " + chartY);
//
//            chartX = driver.findElement(By.cssSelector("div[class='x-axis-title']")).findElement(By.tagName("text")).getText();
//
//            System.out.println("Chart X: " + chartX);
//
//            if(lhsY.startsWith("Median")) {
//                r1 = true;
//                r2 = spyY.equals(chartY);
//            }
//
//            else {
//
//                r1 = lhsY.equals(spyY);
//
//                System.out.println("lhsY.equals(spyY): " + r1);
//
//                r2 = lhsY.equals(chartY);
//
//                System.out.println("lhsY.equals(chartY): " + r2);
//            }
//
//            r3 = lhsX.equals(spyX);
//
//            System.out.println("lhsX.equals(spyX): " + r3);
//
//            r4 = lhsX.equals(chartX);
//
//            System.out.println("lhsX.equals(chartX): " + r4);
//
//
//            if(!r1 || !r2 || !r3 || !r4) {
//                sFlag = false;
//                return sFlag;
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }
//
//    public static boolean validateXAxisLabels(WebDriver driver) {
//
////        WebDriver driver = DriverFactory.getWebDriver();
//        int count = 0;
//        boolean sFlag = true;
//
//        try {
//            List<WebElement> spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));
//
//            int spySize = spyData.size();
//
//            List<WebElement> xaxisData = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));
//            //.findElement(By.cssSelector("g[class='x-axis']"))
//            int xaxisSize = xaxisData.size();
//
//            for(int i = 0; i < xaxisSize; i++) {
//
//                String tempX = xaxisData.get(i).getText();
//
//                System.out.println("X Tick: " + tempX);
//
//                String tempSpy = spyData.get(i*2).getText();
//
//                System.out.println("Spy Data: " + tempSpy);
//
//                boolean r = tempX.equalsIgnoreCase(tempSpy) || tempX.equalsIgnoreCase(tempSpy + "0") || tempX.equalsIgnoreCase(tempSpy + ".00");
//
//                if(r) {
//                    count++;
//                }
//            }
//            if(count != xaxisSize) {
//                sFlag = false;
//                return sFlag;
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }
//
//
//    public static boolean validateDataLabels(WebDriver driver) {
//
////        WebDriver driver = DriverFactory.getWebDriver();
//        int count = 0;
//        boolean sFlag = true;
//
//        try {
//
//            List<WebElement> spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));
//
//            int spySize = spyData.size();
//
//            List<WebElement> dataLabels = driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='series 0']")).findElements(By.tagName("text"));
//
//            int dataSize = dataLabels.size();
//
//            for(int i = 0; i < dataSize; i++) {
//
//                String tempD = dataLabels.get(i).getText();
//
//                System.out.println("Data label: " + tempD);
//
//                String tempSpy = spyData.get((i*2)+1).getText();
//
//                System.out.println("Spy Data: " + tempSpy);
//
//                if(tempD.equalsIgnoreCase(tempSpy)) {
//                    count++;
//                }
//            }
//            if(count != dataSize) {
//                sFlag = false;
//                return sFlag;
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
//            sFlag = false;
//            return sFlag;
//        }	//end of catch block
//        return sFlag;
//    }
//
//    public static void loginBIInValid(WebDriver driver, List<Records> listOb,String username,String password,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
//        Records record = new Records();
//        Boolean actualOutcome = false;
//        List<File> screenShot = new ArrayList<File>();
//
//        try {
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//
//            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();
//
//            driver.findElement(By.id("username")).sendKeys(username);
//            driver.findElement(By.id("password")).sendKeys(password+"123");
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//
//            driver.findElement(By.name("submit")).click();
//            Thread.sleep(2000);
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();
//
//            try{
//                driver.findElement(By.id("casErrorDiv"));
//                actualOutcome=true;
//            }
//            catch(Exception e){
//                actualOutcome=false;
//                log.error("",e);
//            }
//
//        } catch (Exception e) {
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            actualOutcome = false;
//            log.error("",e);
//        }
//        finally {
//            Records.setSan_aut_id(san_aut_id);
//            record.setTestCaseName("SAN-LOGIN-01");
//            record.setOutcome(actualOutcome);
//            record.setName("INVALID LOGIN");
//            record.setScreenShot(screenShot);
//            record.setExpectedResult("INVALID LOGIN MESSAGE APPEARS");
//            clientVersionDao.setRecordDetails(record);
//        }
//        /*record1.setOutcome(actualOutcome);
//        record1.setName("LOGIN");
//        record1.setScreenShot(screenShot);
//        record1.setExpectedResult("");*/
//
//        listOb.add(record);
//        //listOb.add(record1);
//    }
//
//    //Add Client version dao for every method, aut_master_id as parameter too
//    public static void loginBIValid(WebDriver driver, List<Records> listOb, String username, String password, String url, ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
//      Records record = new Records();
//        Boolean actualOutcome = false;
//        List<File> screenShot = new ArrayList<>();
//        driver.get(url);
//        Thread.sleep(5000);
//
//        try {
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//
//            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();
//
//            driver.findElement(By.id("username")).sendKeys(username);
//            driver.findElement(By.id("password")).sendKeys(password);
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//
//            driver.findElement(By.name("submit")).click();
//
//            Thread.sleep(4000);
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            Thread.sleep(3000);
//            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
//            try{
//                driver.findElement(By.id("casErrorDiv"));
//                actualOutcome=false;
//            }
//            catch(Exception e){
//                actualOutcome=true;
//                log.error("",e);
//            }
//
//        } catch (Exception e) {
//
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            actualOutcome = false;
//            log.error("",e);
//        }
//        finally {
//
//            //record.setSanityAutomationMasterID()
//            Records.setSan_aut_id(san_aut_id);
//            record.setTestCaseName("SAN-LOGIN-02");
//            record.setOutcome(actualOutcome);
//            record.setName("LOGIN");
//            record.setScreenShot(screenShot);
//            record.setExpectedResult("LOGGED IN");
//
//            //SAN_LOG_1, PASS, Sanity_Aut_Master_ID
//            //ClientVersionDao. insertSanityTCOutcome(record)
//            clientVersionDao.setRecordDetails(record);
//        }
//       /* record1.setOutcome(actualOutcome);
//        record1.setName("LOGIN");
//        record1.setScreenShot(screenShot);
//        record1.setExpectedResult("");*/
//
//        listOb.add(record);
//        if(!actualOutcome)
//        {
//            throw new Exception("Login failed.");
//        }
//        // listOb.add(record1);
//    }
//
//    public static void loginWB(WebDriver driver,List<File> screenShot,String username,String password) throws Exception {
//
//        Boolean actualOutcome = false;
//        try {
//            driver.findElement(By.id("usr")).sendKeys(username);
//            driver.findElement(By.id("pwd")).sendKeys(password);
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            driver.findElement(By.id("login")).click();
//            Thread.sleep(5000);
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//        } catch (Exception e) {
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            actualOutcome = false;
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void switchToWindow(int index, WebDriver driver) {
//        String windowId = null;
//        log.info("Present Window : " + driver.getWindowHandle());
//        Set<String> allWin = driver.getWindowHandles();
//        log.info("All windows : " + driver.getWindowHandles());
//        Iterator<String> iter = allWin.iterator();
//
//        for (int i = 0; i <= index; i++) {
//            windowId = iter.next();
//        }
//        driver.switchTo().window(windowId);
//        log.info("Switched to Window : " + windowId);
//    }
//
//    public static void changeDate(WebDriver driver, WebDriverWait wait, List<File> screenShot) throws Exception {
//
//        Boolean actualOutcome = false;
//
//        try {
//            //driver.findElement(By.xpath("//*[@id=\"KGTPTimePickerBtnID\"]/pretty-duration")).click();
//            driver.findElement(By.cssSelector("div[id='KGTPTimePickerBtnID']")).findElement(By.tagName("pretty-duration")).click();
//            driver.findElement(By.linkText("Relative")).click();
//
//            List<WebElement> yearDDList = driver.findElements(By.cssSelector("div[class='kbn-timepicker-section']"));
//            System.out.println("yearDDList Size :"+yearDDList);
//            List<WebElement> yearDDSubList = yearDDList.get(0).findElements(By.cssSelector("div[class='form-group']"));
//            System.out.println("yearDDSubList Size :"+yearDDSubList);
//            WebElement yearDDWeb = yearDDSubList.get(1).findElement(By.tagName("select"));
//            Select yearDD = new Select(yearDDWeb);
//            yearDD.selectByIndex(6);
//            //GO is clicked
//            yearDDList.get(2).findElement(By.cssSelector("div")).findElement(By.tagName("button")).click();
//
//            //driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[2]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/button")).click();
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//           driver.findElement(By.cssSelector("i[class='fa fa-arrow-up']")).click();
//            System.out.println("Arrow is clicked");
//           // driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[1]/i")).click();
//
//
//        } catch (Exception e) {
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            actualOutcome = false;
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static String saveByName(WebDriver driver, String saveName) {
//
//        try {
//            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).click();
//            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(Keys.chord(Keys.BACK_SPACE));
//
//            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(saveName);
//            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/button")).click();
//        } catch (Exception e) {
//           return "false";
//        }
//        return "true";
//    }
//
//    public static void addClick(WebDriver driver, WebElement webElem) {
//        try {
//            Actions action = new Actions(driver);
//            //String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[3]/div")).getText();
//            //log.info("Alert message : "+str);
//            action.moveToElement(webElem).build().perform();
//
//            WebElement add = webElem.findElement(By.cssSelector("button[class=\"btn btn-xs btn-primary discover-field-toggle\"]"));
//            add.click();
//            log.info("Add is clicked..");
//        } catch (Exception e) {
//            log.info("Modal clicked failed inside catch..");
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("OK")));
//            log.error("",e);
//        }
//    }
//
//    public static void clickModal(WebDriver driver, WebElement webElem) {
//        try {
//            Actions action = new Actions(driver);
//            //String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[3]/div")).getText();
//            //log.info("Alert message : "+str);
//            action.moveToElement(webElem).click().build().perform();
//            log.info("Modal clicked successfully..");
//        } catch (Exception e) {
//            log.info("Modal clicked failed inside catch..");
//            log.error("",e);
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("OK")));
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void waitForAlert(WebDriver driver) throws InterruptedException {
//        int i = 0;
//        while (i++ < 10) {
//            try {
//                Thread.sleep(5000);
//                //Status
//                log.info("Inside waitforalert and i : " + i);
//                driver.switchTo().alert().accept();
//                //Alert alert = driver.switchTo().alert();
//                break;
//            } catch (NoAlertPresentException e) {
//                Thread.sleep(2000);
//                continue;
//            }
//        }
//    }
//
//    public static File takeScreenShot(WebDriver driver) throws Exception {
//
//        Thread.sleep(2000);
//        TakesScreenshot scrShot = ((TakesScreenshot) driver);
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
////        OutputStream out = new FileOutputStream((SrcFile));
//        //File DestFile=new File(fileWithPath);
//        //FileUtils.copyFile(SrcFile, DestFile);
//
//        return SrcFile;
//    }
//
//    public static String firstWord(String str) {
//        int len = str.length();
//        String s = "";
//        for (int i = 0; i < len; i++) {
//            char ch = str.charAt(i);
//            if (ch == ' ') {
//                s = str.substring(0, i);
//                break;
//            }
//        }
//        // log.info("Substring is : "+s+".");
//        return s;
//    }
//
//    public static boolean verifyResult(WebDriver driver, String name, String expResult, Records rec, String className)
//    {
//        /* rec.setName(className);
//            rec.setOutcome(true);
//            rec.setExpectedResult(className+" Creation Pass named "+name);
//            rec.setScreenShot(rec.screenShot);
//
//            log.info("Name is : "+rec.getName());
//            log.info("Outcome is : "+rec.isOutcome());
//            log.info("Expected Result is : "+rec.getExpectedResult());
//            log.info("Screenshot is : "+rec.getScreenShot());*/
//        /* log.info(name+"."+" | NOT EQUALS | "+expResult+"."+" | FOR | "+className);
//            rec.setName(className);
//            rec.setOutcome(false);
//            rec.setExpectedResult(className+" Creation Fail named "+name);
//            rec.setScreenShot(rec.screenShot);*/
//        return expResult.equalsIgnoreCase(name);
//    }
//
//    public static void clickLogo(WebDriver driver, WebDriverWait wait, String name) throws InterruptedException {
//        log.info(name + " is prepared, clicking on mcube logo");
//        driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
//        //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/nav/div[1]/li")).click();
//        log.info("Waiting for Home Text on screen");
//        Thread.sleep(6000);
//       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/div/kbn-top-nav/div/div/div/div[3]/div[1]/div/div")));
//        //wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mid-stack']"))));
//        //div[id='mCubeSSPLogicID']
//    }
//
//    public static String randomStringGenerate() {
//
//        // create a string of all characters
//        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        // create random string builders
//        StringBuilder sb = new StringBuilder();
//        // create an object of Random class
//        Random random = new Random();
//        // specify length of random string
//        int length = 5;
//        for (int i = 0; i < length; i++) {
//            // generate random index number
//            int index = random.nextInt(alphabet.length());
//            // get character specified by index
//            // from the string
//            char randomChar = alphabet.charAt(index);
//            // append the character to string builder
//            sb.append(randomChar);
//        }
//        String randomString = sb.toString();
//        log.info("Random String is: " + randomString);
//        return randomString;
//    }
//
//    public static boolean selectIndices(WebDriver driver, WebDriverWait wait, String index) {
//
//        boolean flag = true;
//        try {
//            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='inputpart']")));
//            Thread.sleep(1000);
//
//            List<WebElement> list = driver.findElements(By.cssSelector("div[class='scroll-box']"));
//            int size = list.size();
//            log.info("SIZE of scroll box list: " + size);
//            List<WebElement> list1 = list.get(0).findElements(By.cssSelector("li[class='control-group']"));
//            int size1 = list1.size();
//            log.info("SIZE of li list: " + size1);
//
//            for (int i = 0; i < size1; i++) {
//                //String str=list.get(i).findElement(By.cssSelector("label[class='control control--checkbox']")).getText();
//
//                WebElement el = list1.get(i).findElement(By.tagName("label"));
//                String str = el.getText();
//                str = str.trim();
//                Thread.sleep(1000);
//                System.out.println("Index name: " + str);
//                System.out.println("Index name: " + index);
//
//                if (str.equalsIgnoreCase(index)) {
//                    System.out.println("str :"+str+" and index :"+index);
//                    Thread.sleep(1000);
//                    list1.get(i).click();
//                    break;
//                } else {
//                    log.info("continue");
//                    continue;
//                }
//            }
//        } catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            log.error("", e);
//            flag = false;
//            return flag;
//        }
//        return flag;
//    }
//
//    public static boolean query(WebDriver driver, WebDriverWait wait) {
//
//        boolean flag = true;
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='dropdown-menu scrollable-menu']")));
//
//            List<WebElement> list = driver.findElement(By.cssSelector("ul[class='dropdown-menu scrollable-menu']")).findElements(By.tagName("li"));
//            int size = list.size();
//            log.info("SIZE of Query List : " + size);
//            WebElement text = driver.findElement(By.cssSelector("form[class='ng-dirty ng-valid-parse ng-valid ng-valid-required']")).findElement(By.tagName("textarea"));
//            System.out.println("About to click");
//            list.get(1).click();
//            System.out.println("Cliocked");
//            text.sendKeys(", @");
//
//            list.get(3).click();
//
//            text.sendKeys(" from @");
//            //text.sendKeys(" from @")
//
//            list.get(0).click();
//            //text.sendKeys(","+index);
//        } catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            log.error("", e);
//            flag = false;
//            return flag;
//        }
//        return flag;
//    }
//
//    public static boolean isRoleCreated(WebDriver driver, WebDriverWait wait, String roleName) {
//
//        boolean flag = false;
//
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"userlist\"]")));
//
//            List<WebElement> list = driver.findElement(By.cssSelector("div[class=\"userlist\"]")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
//            int size = list.size();
//            log.info("SIZE of Role List : " + size);
//
//            for (int i = 0; i < size; i++) {
//                if (list.get(i).getText().equals(roleName)) {
//                    log.info(roleName + " is present");
//                    flag = true;
//                    list.get(i).click();
//                    Thread.sleep(3000);
//                    break;
//                } else {
//                    flag = false;
//                }
//            }
//        } catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            log.error("",e);
//            flag = false;
//            return flag;
//        }
//        return flag;
//    }
//
//    public static void scrollByVisibleElement(WebDriver driver, WebElement webEl) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", webEl);
//    }
//
//    //-----------------------------------------------------------------
//
//    public static boolean clickOkButton1(WebDriver driver,WebDriverWait wait,List<File> screenShot) throws Exception {
//
//        String str=null;
//        Boolean actualOutcome = false;
//
//        try {
//
//            Thread.sleep(2000);
//            List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-danger']"));
//            int size=list.size();
//            System.out.println(size);
//            for(int i=0;i<size;i++) {
//                str=list.get(i).getText();
//                if (str.equalsIgnoreCase("OK")||str.equalsIgnoreCase("Add Dataset")) {
//                    screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//                    list.get(i).click();
//                    Thread.sleep(1000);
//                }
//                else{
//                    continue;
//                }
//            }
//        }
//        catch (Exception e) {
//            actualOutcome = false;
//            Thread.sleep(5000);
//            Keys.chord(Keys.ENTER);
//            log.error("",e);
//            throw new RuntimeException(e);
//        }
//        return actualOutcome;
//    }
//
//    public static String validateProfile(WebDriver driver, WebDriverWait wait,String value) {
//
//        boolean flag=true;
//        String str=null;
//        //WebDriver driver = DriverFactory.getWebDriver()
//        try {
//            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));
//
//            List<WebElement> list =driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
//            int size=list.size();
//            System.out.println(size);
//            for(int i=1;i<size;i++) {
//                List<WebElement> list1 =list.get(i).findElements(By.tagName("td"));
//                int size1=list1.size();
//                System.out.println(size1);
//                str=list1.get(1).getText().trim();
//
//                System.out.println(str);
//
//                if (str.equals(value)){
//                    System.out.println("Successful profile creation");
//                    break;
//                }
//                else{
//                    continue;
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return str;
//            //end of catch block
//        }//end of method
//        return str;
//    }
//
//    public static boolean clickData(WebDriver driver, WebDriverWait wait) {
//
//        boolean flag= true;
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        try {
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-bordered']")));
//
//            List<WebElement>  list=driver.findElement(By.cssSelector("tbody[class='highlight']")).findElements(By.cssSelector("tr[ng-repeat='tableDetails in tableMetaData']"));
//            int size=list.size();
//            System.out.println("SIZE: "+size);
//
//            for(int j=0; j<size;j++){
//
//                String rowName=list.get(j).findElement(By.cssSelector("td[class='highlighted-name']")).getText();
//                System.out.println("ROW NAME: "+rowName);
//
//                List<WebElement>  el = list.get(j).findElements(By.cssSelector("td[ng-repeat='functions in tableDetails.functionDetails ']"));
//                int Size=el.size();
//
//                for(int i=0; i<Size; i++){
//
//                    String str=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span")).getAttribute("class");
//
//                    if(str.contains("checkmark-disabled")){
//                        continue;
//                    }
//
//                    else{
//                        WebElement elem=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span"));
//                        js.executeScript("arguments[0].click();", elem);
//
//                        System.out.println(i+". CHECKED");
//                    }
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//
//    public static boolean clickAddNew(WebDriver driver, WebDriverWait wait) {
//
//        boolean flag=true;
//        try {
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));
//
//            WebElement we =driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.tagName("input"));
//
//            String str=we.getAttribute("class");
//            System.out.println(str);
//
//            if(str.equals("form-control")){
//                System.out.println("Element is Visible");
//            }
//
//        }//end of try block
//
//        catch (Exception e) {
//
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//            //end of catch block
//        }	//end of method
//        return flag;
//    }
//
//    public static boolean clickDb(WebDriver driver, WebDriverWait wait, String value, String value1) {
//
//        boolean flag = true;
//        try {
//            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='a db-set']")));
//
//            List<WebElement> list = driver.findElement(By.cssSelector("div[class='a db-set']")).findElement(By.cssSelector("div[class='db-set-inner']")).findElements(By.tagName("db-list"));
//            int size = list.size();
//            for (int i = 0; i < size; i++) {
//                String str = list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).getAttribute("textContent");
//                System.out.println("DB NAME: " + str);
//                if (str.equals(value)) {
//                    Thread.sleep(1000);
//                    list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).click();
//
//                    Thread.sleep(2000);
//                    List<WebElement> list1 = list.get(i).findElement(By.cssSelector("ul[class='subList']")).findElements(By.cssSelector("li[class='tableLabel']"));
//                    int Size = list1.size();
//                    System.out.println("Li Size "+Size);
//
//                    for (int j = 0; j < Size; j++) {
//
//                        String str1 = list1.get(j).getText();
//                        System.out.println("Dataset Name:" + str1);
//
//                        if (str1.equals(value1)) {
//                            Thread.sleep(2000);
//                            list1.get(j).click();
//                            break;
//                        }
//                    }
//                    break;
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }
//
//    public static void switchToWindow1(String title, WebDriver driver) {
//
//        boolean foundWindow = false;
//
//        for(String handle:driver.getWindowHandles()) {
//
//            if (driver.switchTo().window(handle).getTitle().contains(title)) {
//                System.out.println("Switched to window with title:" + title);
//                foundWindow = true;
//                break;
//            }
//            if (foundWindow) {
//                System.out.println("Couldn't find the window with title -> " + title);
//            }
//        }
//    }
//
//    public static void dbConnection(WebDriver driver,String database,int index,String connectionName, List<File> screenShot) {
//
//        //  Boolean actualOutcome=false;
//        String str=null;
//
//        try {
//
//            //datasource click, database click, select jdbc and jpfdist and create a wf and run the workflow and validate green tick
//            driver.findElement(By.cssSelector("div[class='model-navigator']")).findElement(By.cssSelector("li[ng-click='$ctrl.openDatasources()']")).click();
//            Thread.sleep(4000);
//            driver.findElement(By.cssSelector("span[class='btn-modal__icon sa sa-database']")).click();
//
//            Select databaseDropdown = new Select(driver.findElement(By.cssSelector("select[class='select-drive select-dataserver ng-pristine ng-untouched ng-valid ng-empty']")));
//            log.info("databaseDropdown: " + databaseDropdown);
//
//            databaseDropdown.selectByIndex(index);
//
//            Thread.sleep(5000);
//
//            driver.findElement(By.cssSelector("input[id='DATABASE']")).sendKeys("gpadmin");
//
//            driver.findElement(By.cssSelector("input[id='host']")).sendKeys("192.112.200.16");
//
//            driver.findElement(By.cssSelector("input[id='port']")).sendKeys("5432");
//
//            driver.findElement(By.cssSelector("input[id='username']")).sendKeys("gpadmin");
//
//            driver.findElement(By.cssSelector("input[id='password']")).sendKeys("gpadmin");
//
//            driver.findElement(By.cssSelector("button[class='btnstyle align-right']")).click();
//
//            Thread.sleep(3000);
//
//            str = driver.findElement(By.cssSelector("div[class='error-mgs ng-binding ng-scope']")).getText().trim();
//
//            System.out.println(str);
//
//            Thread.sleep(3000);
//
//            Select databaseDropdown1 = new Select(driver.findElement(By.cssSelector("select[id='tables']")));
//
//            log.info("databaseDropdown: " + databaseDropdown1);
//
//            databaseDropdown1.selectByVisibleText("sales_all_details_11");
//
//            if(database.equals("Greenplum-JDBC")) {
//
//                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);
//
//            }
//            else if(database.equals("Greenplum-GPFDIST")) {
//
//                Thread.sleep(3000);
//
//                Select partitionDropdown = new Select(driver.findElement(By.cssSelector("select[id='PARTITIONCOL']")));
//
//                partitionDropdown.selectByVisibleText("gp_segment_id");
//
//                driver.findElement(By.cssSelector("input[id='PARTITIONNUM']")).sendKeys("100");
//
//                driver.findElement(By.cssSelector("input[id='SPARKPORT']")).sendKeys("12005");
//
//                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);
//
//            }
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            Thread.sleep(1000);
//            driver.findElement(By.cssSelector("button[class='btn btn-blue ng-scope']")).click();
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            Thread.sleep(1000);
//            driver.findElement(By.cssSelector("div[class='cross']")).click();
//        }
//        catch (Exception e) {
//            log.error("", e);
//        }
//    }
//
//    public static boolean addReadNode(WebDriver driver, WebDriverWait wait,String value, List<File> screenShot) throws Exception {
//
//        boolean flag=true;
//        Actions actions = new Actions(driver);
//        String str=null;
//
//        //WebDriver driver = DriverFactory.getWebDriver()
//        try {
//
//            WebElement elementLocator = driver.findElement(By.cssSelector("div[class='new-node-container']"));
//            actions.contextClick(elementLocator).perform();
//            Thread.sleep(3000);
//
//            WebElement inputOutput=driver.findElement(By.cssSelector("operation-catalogue[class='new-node__catalogue ng-isolate-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
//            actions.moveToElement(inputOutput).perform();
//            Thread.sleep(3000);
//
//            WebElement readData=driver.findElement(By.cssSelector("div[class='operations-list__next-level ng-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
//            actions.moveToElement(readData).click().build().perform();
//            Thread.sleep(3000);
//            if(value.contains("Greenplum-GPFDIST")) {
//
//                List<WebElement> list1 = driver.findElements(By.cssSelector("div[class='custom-name ng-binding ng-scope']"));
//                list1.get(1).findElement(By.cssSelector("span[class='ng-binding']")).click();
//
//            }
//            else{
//                driver.findElement(By.cssSelector("div[class='custom-name ng-binding ng-scope']")).findElement(By.cssSelector("span[class='ng-binding']")).click();
//            }
//
//            List<WebElement> list= driver.findElement(By.cssSelector("div[class='datasources-list']")).findElements(By.cssSelector("div[class='datasources-element__name-wrapper']"));
//            int size=list.size();
//
//            System.out.println(size);
//
//            for(int i=0;i<size;i++){
//
//                WebElement we=list.get(i).findElement(By.cssSelector("div[class='datasources-element__name ng-binding']"));
//                str=we.getAttribute("title").trim();
//                Thread.sleep(3000);
//                System.out.println(str);
//                System.out.println(value);
//
//                if(value.equals(str)){
//                    Thread.sleep(2000);
//                    we.click();
//                    break;
//                }
//                else{
//                    continue;
//                }
//            }
//
//            Thread.sleep(2000);
//            Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
//            reportType.selectByIndex(1);
//            Thread.sleep(4000);
//            clickMenuItems(driver,"Run");
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            Thread.sleep(10000);
//
//        }//end of try block
//        catch (Exception e) {
//
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//            //end of catch block
//        }//end of method
//        return flag;
//    }
//
//    public static void clickMenuItems(WebDriver driver,String usage) {
//
//        Boolean actualOutcome=false;
//        String str=null;
//        try {
//            Thread.sleep(2000);
//            List<WebElement> list=driver.findElement(By.cssSelector("div[class='pull-right workflow-navbar__top-menu-options']")).findElements(By.cssSelector("span[class='workflow-navbar__text-label ng-binding']"));
//            int size=list.size();
//            System.out.println("Menu Items: "+size);
//            for(int i=0;i<size;i++){
//
//                str=list.get(i).getText().trim();
//                System.out.println("str"+str);
//                if(usage.equals(str))
//                {
//                    list.get(i).click();
//                    break;
//                }
//                else{
//                    continue;
//                }
//            }
//        } catch (Exception e) {
//            log.info("Click Failed");
//            log.error("", e);
//        }
//    }
//
//    public static boolean validateSuccess(WebDriver driver, WebDriverWait wait,String value) {
//
//        boolean flag=true;
//        //WebDriver driver = DriverFactory.getWebDriver()
//        try {
//            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
//            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));
//
//            List<WebElement> list =driver.findElements(By.cssSelector("div[class='graph-node__content']"));
//            int size=list.size();
//            System.out.println(size);
//            for(int i=0;i<size;i++) {
//
//                WebElement we =list.get(i).findElement(By.cssSelector("status-icon[class='graph-node__status-icon ng-scope ng-isolate-scope']")).findElement(By.cssSelector("div[popover-placement='right']"));
//
//                String str=we.getAttribute("class").trim();
//
//                System.out.println(str);
//
//                if (str.equals(value)){
//                    System.out.println("Read Node Executed Successfully");
//                    flag=true;
//                }
//                else{
//                    continue;
//                }
//            }
//        }//end of try block
//        catch (Exception e) {
//
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//            //end of catch block
//        }//end of method
//        return flag;
//    }
//
//    public static boolean clickOk(WebDriver driver) {
//
//        boolean flag=true;
////        WebDriver driver = DriverFactory.getWebDriver()
//
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-pulse']")));
//
//            WebElement we = driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-pulse']")).findElement(By.cssSelector("div[class='ajs-primary ajs-buttons']")).findElement(By.xpath("(//button[@class='ajs-button btn btn-danger'])[2]"));
////            WebElement we = driver.findElement(By.xpath("(//button[@class='ajs-button btn btn-danger'])[2]"));
//            we.click();
//
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }	//end of method
//
//    public static void clickOkButton(WebDriver driver,WebDriverWait wait) throws Exception {
//
//        Boolean actualOutcome = false;
//
//        try {
//
//            Thread.sleep(2000);
//            List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-primary']"));
//            int size=list.size();
//            System.out.println(size);
//            if(size==1) {
//                list.get(0).click();
//                Thread.sleep(1000);
//            }
//            else{
//                list.get(1).click();
//                Thread.sleep(1000);
//            }
//        }
//        catch (Exception e) {
//            actualOutcome = false;
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static boolean verifyAAWorkflow2(WebDriver driver) {
//        boolean flag=true;
//        int counter = 0;
//        try
//        {
//            List<WebElement> Weblist = driver.findElement(By.cssSelector("div[class='c-dynamic-part ng-scope']")).findElement(By.cssSelector("div[class='editor']")).findElement(By.cssSelector("div[class='flowchart-paint-area']")).findElements(By.cssSelector("graph-node[class='graph-node-component ng-scope ng-isolate-scope jtk-draggable jtk-endpoint-anchor jtk-connected']"));
//            int size = Weblist.size();
//            System.out.println("No. of nodes " +size);
//            for(int i =0; i < size; i++) {
//                List<WebElement> we = Weblist.get(i).findElement(By.tagName("status-icon")).findElements(By.tagName("div"));
//                //WebElement we1 = we.get(0)
//                String sText1 = we.get(0).getAttribute("class");
//                sText1=sText1.trim();
//                System.out.println(sText1);
//
//                if(sText1.contains("status-icon completed"))
//                {
//                    counter+=1;
//                    //flag=true
//                    System.out.println("pass");
//                }
//                else
//                {
//                    flag=false;
//                    System.out.println("continue");
//                }
//
//            }//end of for loop
//            if(counter==size)
//            {
//                System.out.println("No. of nodes having checked status " +counter);
//                System.out.println("pass:- No. of nodes and checked status are equal");
//            }
//            else {
//                System.out.println("fail:- No. of nodes and checked status are not equal");
//            }
//        }//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //End of catch block
//        return flag;
//    } //end of method
//    public static void dashboardFailure(WebDriver driver, List<Records> listOb,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
//        Records record = new Records();
//        List<File> screenShot = new ArrayList<>();
//        screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//
//        Records.setSan_aut_id(san_aut_id);
//        record.setTestCaseName("SAN-DASHBOARD-01");
//        record.setOutcome(actualOutcome);
//        record.setName("Dashboard.");
//        record.setScreenShot(screenShot);
//        record.setExpectedResult("Dashboard completed successfully.");
//        clientVersionDao.setRecordDetails(record);
//
//        listOb.add(record);
//        log.info("Dashboard creation failed due to null widgetlist.");
//    }
//    public static int checkNull(List<String> widgetList)
//    {
//        int flag=0;
//        for(String name : widgetList) {
//            if(name.contains("Mcube_")) {
//                flag = 1;
//                break;
//            }
//            else {
//                flag=0;
//            }
//        }
//        return flag;
//    }
//    public static boolean checkpagesize_ten(WebDriver driver) {
////        WebDriver driver = DriverFactory.getWebDriver()
//        boolean flag = false;
//        try {
//            WebElement li = driver.findElement(By.xpath("//indexed-fields//paginated-table//paginate//paginate-controls/form/div/select/option[1]"));
//            String textli = li.getText();
//            //		println("text"+textli)
//            System.out.println("Page size is: "+textli);
//            if(textli.equals("10")){
//                flag = true;
//                System.out.println("It is the page size");
//            }else {
//                System.out.println("It is not the page size");
//            }
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return flag;
//    }
//
//    public static boolean clickAdd(WebDriver driver,String value){
//
//        boolean flag = true;
////        WebDriver driver = DriverFactory.getWebDriver()
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='sidebar-list']")));
//
//            List<WebElement> list = driver.findElement(By.cssSelector("div[class='sidebar-list']")).findElement(By.cssSelector("ul[class='list-unstyled discover-unpopular-fields hidden-sm hidden-xs']")).findElements(By.tagName("li"));
//            int size = list.size();
//            System.out.println(size);
//            for(int i = 1; i <size; i++) {
//
//                String str=list.get(i).findElement(By.tagName("span")).getAttribute("textContent");
//                str = str.trim();
//                //println(str)
//
//                if(value.equals(str)){
//
//                    WebElement we = list.get(i);
//
//                    Actions builder = new Actions(driver);
//
//                    Action mouseOver = builder.moveToElement(we).build();
//
//                    mouseOver.perform();
//
//                    WebElement add=list.get(i).findElement(By.tagName("button"));
//
//                    add.click();
//
//                    break;
//                }
//
//                else{
//                    System.out.println("continue");
//                }
//            }//end of for loop
//        }	//end of try block
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//        } //end of catch block
//        return flag;
//    }
//    //end of method
//
//    public static boolean verifyssname(WebDriver driver,String ssname) {
////        WebDriver driver = DriverFactory.getWebDriver()
//        boolean flag = true;
//        WebElement li = driver.findElement(By.cssSelector("div[class='localNavRow']"));//.findElement(By.cssSelector("div[class='breadcrumbconainer col-sm-4']"))//.findElement(By.cssSelector("li[id='KTNvisualization:New-Widget__2LabelID']"))
//        String textli= li.getText();
//        //WebElement lu = driver.findElement(By.xpath("//div[@class='breadcrumbconainer col-sm-4']/ol//li[4]"))
//        String textlu = li.getText();
//        System.out.println("SS"+ textli);
//        if(textli.equalsIgnoreCase(textlu)) {
//            flag = true;
//            System.out.println("It is the save search's name");
//        }
//        else {
//            System.out.println("It is not the save search's name ");
//            flag = false;
//        }
//
//        return flag;
//
//    }
//    public static boolean verifywidgetname(WebDriver driver,String widgetname) {
////        WebDriver driver = DriverFactory.getWebDriver()
//        boolean flag = true;
//        try {
//            WebElement li = driver.findElement(By.cssSelector("div[class='localNavRow']")).findElement(By.cssSelector("div[class='breadcrumbconainer col-sm-4']"));//.findElement(By.cssSelector("li[id='KTNvisualization:New-Widget__2LabelID']"))
//            String textli= li.getText();
//            WebElement lu = driver.findElement(By.xpath("//div[@class='breadcrumbconainer col-sm-4']/ol//li[4]"));
//            String textlu = lu.getText();
//            System.out.println("Area"+ textli);
//            if(textlu.equalsIgnoreCase(widgetname)) {
//                flag = true;
//                System.out.println("It is the widget's name");}
//            else {
//                System.out.println("fail");
//                flag = false;
//            }
//
//            return flag;
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//    }
//
//    public static boolean verifydashboardname(WebDriver driver,String dashname) {
////        WebDriver driver = DriverFactory.getWebDriver()
//        boolean flag = true;
//        try {
//            WebElement li = driver.findElement(By.cssSelector("div[class='localNavRow']")).findElement(By.cssSelector("div[class='dashboardname ']"));//.findElement(By.cssSelector("span[id='KTNdashboard:dnBreadCrumbID']"))
//            String textli= li.getText();
//            System.out.println("ND"+ textli);
//            if(textli.equalsIgnoreCase(dashname)) {
//                flag = true;
//                System.out.println("It is dashboard's name");}
//            else {
//                System.out.println("fail");
//                flag = false;
//            }
//
//            return flag;
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//    }
//
//    public static boolean verifylogout(WebDriver driver) {
////        WebDriver driver = DriverFactory.getWebDriver()
//        System.out.println("Verify end");
//        //wait for 6second
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        boolean flag = false;
//        //path for text
//        try {
//            WebElement li = driver.findElement(By.cssSelector("div[id='login']")).findElement(By.cssSelector("span[id='invalidMCubeSpan']"));
//
//            //get that text
//            String textli= li.getText();
//            System.out.println("Verify Text: "+textli);
//
//            //verify
//            if(textli.equals("You have successfully logged out of MCube")) {
//                flag = true;
//                System.out.println("Logged out from Mcube");
//            }else {
//                System.out.println("fail");
//            }
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return  flag;
//    }
//    public static boolean checkpagesize_twentyfive(WebDriver driver) {
////        WebDriver driver = DriverFactory.getWebDriver()
//        boolean flag = false;
//        try {
//            WebElement li = driver.findElement(By.xpath("//indexed-fields//paginated-table//paginate//paginate-controls/form/div/select/option[2]"));
//            String textli = li.getText();
//            System.out.println("Page size is: "+textli);
//            if(textli.equals("25")){
//                flag = true;
//                System.out.println("It is the page size");
//            }else {
//                System.out.println("It is not the page size");
//            }
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return flag;
//    }
//
//    public static boolean chkWrkspace(WebDriver driver,String Wrkspace){
//        boolean flag = false;
//        try{
//            if(Wrkspace.equals("Default_group")){
//                flag = true;
//
//            }
//            else
//                flag= false;
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return flag;
//    }
//
//    public static boolean chkChngePasswrd(WebDriver driver,String chngepassword){
//        boolean flag = false;
//        try{
//            if(chngepassword.contains("Change Password")){
//                flag = true;
//
//            }
//            else
//                flag= false;
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return flag;
//    }
//
//    public static boolean chkUserName(WebDriver driver,String userName,String username){
//        boolean flag = false;
//        try{
//            if(userName.contains(username)){
//                flag = true;
//
//            }
//            else
//                flag= false;
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return flag;
//    }
//
////    public static boolean verifyThreedots(WebDriver driver, String appname){
////        try{
////            if(appname.equals("AI")){
////
////            }
////        }
////    }
//
//    public static boolean chkUserMail(WebDriver driver,String userMail){
//        boolean flag = false;
//        try{
//            if(userMail.contains("@...") || userMail.contains(".com") || userMail.contains("@")){
//                flag = true;
//
//            }
//            else
//                flag= false;
//
//        }
//        catch (Exception e) {
//            e.toString();
//            e.getMessage();
//            flag = false;
//            return flag;
//
//        }
//        return flag;
//    }
//
//
//    public static boolean checkVersion(WebDriver driver, WebDriverWait wait, List<Records> listOb, String className,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
//
//        Records record = new Records();
//        List<File> screenShot = new ArrayList<>();
//
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HelpglobalTitleID")));
//            driver.findElement(By.id("HelpglobalTitleID")).click();
//            Thread.sleep(3000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appVersionHelpPageID")));
//            String version = driver.findElement(By.id("appVersionHelpPageID")).getText().trim();
//            System.out.println("Version name : "+version);
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//
//            if(className.contains("4540") && version.equals("Version: 4.5.3.0"))
//                actualOutcome=true;
//            else if(className.contains("4531") && version.equals("Version: 4.5.3.1"))
//                actualOutcome=true;
//            else if(className.contains("4530") && version.equals("Version: 4.5.3.0"))
//                actualOutcome=true;
//            else if(className.contains("4520") && version.equals("Version: 4.5.2.0"))
//                actualOutcome=true;
//            else if(className.contains("4510") && version.equals("Version: 4.5.1.1"))
//                actualOutcome=true;
//            else if(className.contains("4500") && version.equals("Version: 4.5.0.0"))
//                actualOutcome=true;
//            else if(className.contains("ipds") && version.equals("Version: 3.2.0.0"))
//                actualOutcome=true;
//            else actualOutcome= className.contains("ad4300") && version.equals("Version: 4.3");
//        } catch (InterruptedException e) {
//            screenShot.add(SeleniumUtils23.takeScreenShot(driver));
//            actualOutcome = false;
//            log.error("",e);
//            //throw new RuntimeException(e);
//        }
//        finally {
//            Records.setSan_aut_id(san_aut_id);
//            record.setTestCaseName("VERSION CHECK");
//            record.setOutcome(actualOutcome);
//            record.setName("Version Check");
//            record.setScreenShot(screenShot);
//            record.setExpectedResult("Version check completed successfully.");
//            clientVersionDao.setRecordDetails(record);
//
//            listOb.add(record);
//            if (!actualOutcome) {
//                //throw new Exception("Data Upload creation fail");
//                log.info("Version check failed");
//                return actualOutcome;
//            }
//        }
//        return actualOutcome;
//    }
//}
