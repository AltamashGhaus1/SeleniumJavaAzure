//package com.jdbc.automation.executor.mcube510.Miscellaneous;
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
//import java.io.File;
//import java.time.Duration;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//import static com.jdbc.automation.executor.Common.Records.actualOutcome;
//
//public class SeleniumUtils {
//    private static ArrayUtils rgb;
//
//    private static final Logger log= LoggerFactory.getLogger(SeleniumUtils.class);
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
//            String str = "stroke: rgb" +rgb.get(index-1);
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
//            String str = "stroke: rgb" +rgb.get(index-1);
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
//            String str = "fill: rgb" +rgb.get(index-1);
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
//        SeleniumUtils.waitForAlert(driver);
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
//        SeleniumUtils.waitForAlert(driver);
//        Thread.sleep(8000);
//    }
//    public static void loginBIInValid(WebDriver driver, List<Records> listOb,String username,String password,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
//        Records record = new Records();
//        Boolean actualOutcome = false;
//        List<File> screenShot = new ArrayList<File>();
//
//        try {
//
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//
//            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();
//
//            driver.findElement(By.id("username")).sendKeys(username);
//            driver.findElement(By.id("password")).sendKeys(password+"123");
//
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//
//            driver.findElement(By.name("submit")).click();
//            Thread.sleep(2000);
//
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//
//            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();
//
//            driver.findElement(By.id("username")).sendKeys(username);
//            driver.findElement(By.id("password")).sendKeys(password);
//
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//
//            driver.findElement(By.name("submit")).click();
//
//            Thread.sleep(4000);
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//            driver.findElement(By.id("login")).click();
//            Thread.sleep(5000);
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//        } catch (Exception e) {
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//           driver.findElement(By.cssSelector("i[class='fa fa-arrow-up']")).click();
//            System.out.println("Arrow is clicked");
//           // driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[1]/i")).click();
//
//
//        } catch (Exception e) {
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//                    screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
//            Thread.sleep(1000);
//            driver.findElement(By.cssSelector("button[class='btn btn-blue ng-scope']")).click();
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//        screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//
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
//            return flag;
//
//        }
//        return flag;
//    }
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
//            screenShot.add(SeleniumUtils.takeScreenShot(driver));
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
