package com.jdbc.automation.executor.mcube4550.Common;

import com.jdbc.automation.executor.Common.Records;
import com.jdbc.dao.ClientVersionDao;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.jdbc.automation.executor.Common.Records.actualOutcome;

public class SeleniumUtils {

    private static final Logger log= LoggerFactory.getLogger(SeleniumUtils.class);
//    private static ArrayUtils rgb;
    static List<String> rgb = List.of("(126, 178, 109)",
            "(132, 142, 150)",
            "(63, 104, 51)",
            "(80, 134, 66)",
            "(98, 158, 81)",
            "(154, 196, 138)",
            "(183, 219, 171)",
            "(224, 249, 215)",
            "(150, 115, 2)",
            "(204, 163, 0)",
            "(255, 192, 16)",
            "(234, 184, 57)",
            "(242, 201, 109)",
            "(244, 213, 152)",
            "(252, 234, 202)",
            "(47, 87, 94)",
            "(68, 126, 188)",
            "(100, 176, 200)",
            "(110, 208, 224)",
            "(101, 197, 219)",
            "(112, 219, 237)",
            "(207, 250, 255)",
            "(153, 68, 10)",
            "(193, 92, 23)",
            "(224, 117, 45)",
            "(239, 132, 60)",
            "(249, 147, 78)",
            "(249, 179, 131)",
            "(249, 226, 210)",
            "(88, 20, 12)",
            "(137, 15, 2)",
            "(191, 27, 0)",
            "(226, 77, 66)",
            "(234, 100, 96)",
            "(242, 145, 145)",
            "(252, 226, 222)",
            "(5, 43, 81)",
            "(10, 67, 124)",
            "(10, 80, 161)",
            "(31, 120, 193)",
            "(81, 149, 206)",
            "(130, 181, 216)",
            "(186, 223, 244)",
            "(0, 0, 0)",
            "(83, 88, 95)",
            "(114, 114, 114)",
            "(166, 170, 169)",
            "(220 222, 224)",
            "(238, 233, 233)",
            "(255, 255, 255)"
    );


    static List<String> hexCode = List.of(
            "#3f6833",
            "#508642",
            "#629e51",
            "#7eb26d",
            "#9ac48a",
            "#b7dbab",
            "#e0f9d7",
            "#967302",
            "#cca300",
            "#ffc010",
            "#eab839",
            "#f2c96d",
            "#f4d598",
            "#fceaca",
            "#2f575e",
            "#447ebc",
            "#64b0c8",
            "#6ed0e0",
            "#65c5db",
            "#70dbed",
            "#cffaff",
            "#99440a",
            "#c15c17",
            "#e0752d",
            "#ef843c",
            "#f9934e",
            "#f9b383",
            "#f9e2d2",
            "#58140c",
            "#890f02",
            "#bf1b00",
            "#e24d42",
            "#ea6460",
            "#f29191",
            "#fce2de",
            "#052b51",
            "#0a437c",
            "#0a50a1",
            "#1f78c1",
            "#5195ce",
            "#82b5d8",
            "#badff4",
            "#000000",
            "#53585f",
            "#727272",
            "#a6aaa9",
            "#dcdee0",
            "#eee9e9",
            "#ffffff"
    );

    public static void yDataFill(WebDriver driver, WebDriverWait wait, String widget) {
        //Add Metric click
        driver.findElement(By.id("bucketAddButtonID")).click();
        //Y Axis click
        driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
        int y1Count = 3, y2Count = 3;
        int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
        System.out.println("lenY : " + lenY);

        //Y Data entry
        new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
        System.out.println("Here");
        new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
        //Y arrow button close
        driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

        /*for(int i=2;i<lenX-4;i++)
        {
            //Y Data entry
            new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            //Y arrow button close
            driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //X Data entry
            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByIndex(x1Count);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();

        }*/
    }

    public static void xDataFill(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
        int x1Count = 1, x2Count = 1;

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@id=\"bucketButtonAddLabelID\"])[2]")).click();

        int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
        System.out.println("lenX : " + lenX);

        new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
        Thread.sleep(3000);
        //X Axis Field fill
        new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
        Thread.sleep(3000);
        //X arrow button close
        driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();


        if (widget.equalsIgnoreCase("Area")) {
            driver.findElement(By.id("bucketAddSubButtonID")).click();
            //X Axis click                            //*[@id="bucketButtonAddLabelID"][2]
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][2]")).click();

            new Select(driver.findElement(By.xpath("//*[@id=\"4bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"4fieldSelectID\"]"))).selectByVisibleText("Discount");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"4metricExpandButtonIID\"]")).click();
        }


    }


   /* public static void yDataFill(WebDriver driver, WebDriverWait wait, String widget) {
        //Add Metric click
        driver.findElement(By.id("bucketAddButtonID")).click();
        //Y Axis click
        driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
        int y1Count = 3, y2Count = 3;
        int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
        System.out.println("lenY : " + lenY);

        //Y Data entry
        new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
        System.out.println("Here");
        new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
        //Y arrow button close
        driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

        *//*for(int i=2;i<lenX-4;i++)
        {
            //Y Data entry
            new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            //Y arrow button close
            driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //X Data entry
            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByIndex(x1Count);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();

        }*//*
    }*/
   public static boolean validateData(List<String> chartData, String select,WebDriver driver) {

       boolean flag = true;

       try {

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));

           List<WebElement> spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

           int l = chartData.size();

           System.out.println("Chart Size: " + l);

           for(int i = 0; i < l; i++) {

               System.out.println(chartData.get(i));
           }

           switch(select) {

               case "Both":
                   for(int i = 0; i < chartData.size()/2; i++) {

                       System.out.println("X Chart Data: " + chartData.get(i*2));
                       System.out.println("X Spy Data: " + spyData.get(i*2).getAttribute("textContent"));

                       boolean xResult = chartData.get(i*2).equals(spyData.get(i*2).getAttribute("textContent"));
                       System.out.println("X Result " + i + " : " + xResult);

                       System.out.println("Y Chart Data: " + chartData.get((i*2)+1));
                       System.out.println("Y Spy Data: " + spyData.get((i*2)+1).getAttribute("textContent"));
                       String dum = chartData.get((i*2)+1);
                       System.out.println("Dum  : "+dum);
                       boolean yResult = true;
                       if(!chartData.get((i*2)+1).equalsIgnoreCase("0.00"))
                       {
                           yResult = chartData.get((i*2)+1).equals(spyData.get((i*2)+1).getAttribute("textContent"));
                           System.out.println("yResult inside if : "+yResult);
                       }
                       //	println("Y Result " + i + " : " + yResult)

                       if(!xResult || !yResult) {
                           flag = false;
                           System.out.println("FALSEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                           //System.exit(0)
                           return flag;
                       }
                   }
                   break;
               case "Only Y":
                   for(int i = 0; i < chartData.size()/2; i++) {

                       System.out.println("Y Chart Data: " + chartData.get((i*2)+1));
                       System.out.println("Y Spy Data: " + spyData.get((i*2)+1).getAttribute("textContent"));

                       boolean yResult = chartData.get((i*2)+1).equals(spyData.get((i*2)+1).getAttribute("textContent"));


                       if(!yResult) {
                           flag = false;
                           return flag;
                       }
                   }
                   break;
           }
       }
       catch (Exception ex) {
           System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
           flag = false;
           return flag;
       } //end of catch block
       return flag;
   }

    public static boolean validateMetrics(WebDriver driver) {

        System.out.println("Inside validateMetrics");

        String lhsY, lhsX, spyX, spyY, chartY, chartX;

        boolean r1, r2, r3, r4, flag = true;

//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='agg-table-paginated']")));

            List<WebElement> spyLabels = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("thead")).findElements(By.tagName("th"));
            // Left header of Spy Mode example : Region or State/Province
            spyX = spyLabels.get(0).findElement(By.tagName("span")).getAttribute("textContent");

            spyX = spyX.trim();
            // Right header of Spy Mode example : Count or Sum of Profits
            spyY = spyLabels.get(1).findElement(By.tagName("span")).getAttribute("textContent");

            spyY = spyY.trim();
            // Name of metric of left panel
            lhsY = driver.findElement(By.cssSelector("span[id='1metricDescriptionID']")).getAttribute("textContent");

            lhsY = lhsY.trim();
            // Name of buckets of left panel
            lhsX = driver.findElement(By.cssSelector("span[id='2metricDescriptionID']")).getAttribute("textContent");

            lhsX = lhsX.trim();

            List<WebElement> chartMetrics = driver.findElement(By.tagName("tree-table-vis-headers")).findElements(By.cssSelector("div[ng-class^='metaData']"));

            chartX = chartMetrics.get(0).findElement(By.tagName("span")).getText();

            chartX = chartX.trim();

            chartY = chartMetrics.get(1).getAttribute("textContent");

            chartY = chartY.trim();

            System.out.println("lhsY	: " + lhsY + "lhsY");
            System.out.println("lhsX	: " + lhsX + "lhsX");
            System.out.println("spyX	: " + spyX + "spyX");
            System.out.println("spyY	: " + spyY + "spyY");
            System.out.println("chartY	: " + chartY + "chartY");
            System.out.println("chartX	: " + chartX + "chartX");

            if(lhsY.startsWith("Median")) {
                r1 = true;

                r2 = lhsY.equals(chartY);
                System.out.println("lhsY.equals(chartY): " + r2);
            }

            else {
                r1 = lhsY.equals(spyY);

                System.out.println("lhsY.equals(spyY): " + r1);

                r2 = lhsY.equals(chartY);

                System.out.println("lhsY.equals(chartY): " + r2);
            }

            r3 = lhsX.equals(spyX);

            System.out.println("lhsX.equals(spyX): " + r3);

            r4 = lhsX.equals(chartX);

            System.out.println("lhsX.equals(chartX): " + r4);

            if(!r1 || !r2 || !r3 || !r4) {

                return flag;
            }
        }
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }

    public static int noOfXFields(WebDriver driver){
        int field_size = 0;
        try {
//     WebDriver driver = DriverFactory.getWebDriver();

            List<WebElement> fields = driver.findElement(By.cssSelector("select[id='2fieldSelectID']")).findElements(By.tagName("option"));

            int size = fields.size();

            for(int i = 0; i < size; i++) {

                String text = fields.get(i).getText();

                if(text != "") {
                    field_size++;
                }
            }
            System.out.println("No of Y fields returned : "+field_size);
            return field_size;
        } catch (Exception e) {
            System.out.println("Non of y field error :" + e);
        }
        return field_size;
    }

    public static int noOfYFields( WebDriver driver){
        int field_size = 0;

//

        List<WebElement> fields = driver.findElement(By.cssSelector("select[id='1fieldSelectID']")).findElements(By.tagName("option"));

        int size = fields.size();

        for(int i = 0; i < size; i++) {

            String text = fields.get(i).getText();

            if(text != "") {
                field_size++;
            }
        }
        System.out.println("No of y fields : "+field_size);
        return field_size;
    }

    public static List<String> collectChartData(WebDriver driver){
        int counter = 0;
        List tableData = new ArrayList();
        int k = 0;
        boolean sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='tree-rows']")));

            List<WebElement> chartData = driver.findElement(By.tagName("tree-table-vis-rows")).findElements(By.cssSelector("div[class*='tree-rows']"));

            for(int i = 0; i < chartData.size(); i++) {

                List<WebElement> divs = chartData.get(i).findElements(By.tagName("div"));

                int divslength = divs.size();
                System.out.println("divslength"+divslength);
                //String tempX = divs.get(0).text

                String tempX = divs.get(0).getAttribute("textContent");
                System.out.println("tempX : "+tempX);

                tableData.add(tempX.trim());
                System.out.println("tableData : "+tableData);

                //String tempY = divs.get(divslength-1).getText()

                String tempY = divs.get(divslength-1).getAttribute("textContent");
                System.out.println("tempY : "+tempY);

                tableData.add(tempY.trim());
            }
        }
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
			/*flag = false;
			 return flag;*/
        } //end of catch block
        return tableData;
    }


    public static int noOfXStringFields(WebDriver driver) {

        int field_size = 0;

//        WebDriver driver = DriverFactory.getWebDriver();

        List<WebElement> fields = driver.findElement(By.cssSelector("select[id='2fieldSelectID']")).findElements(By.tagName("optgroup"));

        List<WebElement> stringFields = fields.get(2).findElements(By.tagName("option"));

        int size = stringFields.size();

        for(int i = 0; i < size; i++) {

            String text = stringFields.get(i).getText();

            if(text != "") {
                field_size++;
            }
        }
        return field_size;
    }



    public static void yDataFillTree(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
        //Add Metric click
        int j=0;
        for (int i = 2; i <= 13; i++) {

            driver.findElement(By.id("bucketAddButtonID")).click();
            //Y Axis click
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][1]")).click();
            int y1Count = 2, y2Count = 2;

            int lenYY = new Select(driver.findElement(By.id(i+"bucketSelectButtonID"))).getOptions().size();
            System.out.println("lenY : " + lenYY);

           /* int lenY = new Select(driver.findElement(By.id("2bucketSelectButtonID"))).getOptions().size();
            System.out.println("lenY : " + lenY);*/

            //Y Data entry
            /* new Select(driver.findElement(By.id("2bucketSelectButtonID"))).selectByIndex(y1Count);
            System.out.println("Here");*/

            if(i<7) {

                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i);
                System.out.println("Here");
             new Select(driver.findElement(By.id(+i+"fieldSelectID"))).selectByIndex(i);

            }
            else if(i>=7){
                new Select(driver.findElement(By.id(i + "bucketSelectButtonID"))).selectByIndex(i-5);
                System.out.println("Here");
                new Select(driver.findElement(By.id(+i+"fieldSelectID"))).selectByIndex(i-6);
            }

            // new Select(driver.findElement(By.xpath("//*[@id=\"2fieldSelectID\"]"))).selectByIndex(y2Count);
            // Y arrow button close
            //driver.findElement(By.xpath("//*[@id=\"2metricExpandButtonIID\"]")).click();

            //To minimize
            driver.findElement(By.id(+i+"metricExpandButtonIID")).click();

            String selectedMetric = driver.findElement(By.id(+i+"metricDescriptionID")).getText().trim();
            if(selectedMetric.equalsIgnoreCase("Median date")
                    || selectedMetric.equalsIgnoreCase("Max date"))
            {
                driver.findElement(By.id(+i+"metricDisableAggregationIID")).click();
                Thread.sleep(2000);
            }
        }
    }

    public static void xDataFillCombo(WebDriver driver, WebDriverWait wait, String widget) throws InterruptedException {
        int x1Count = 1, x2Count = 1;

        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.cssSelector("li[id='bucketButtonAddLabelID']"));
        int size = list.size();
        System.out.println("Size Info" + size);

        for (int i = 0; i < size; i++) {

            String str = list.get(i).getText().trim();
            System.out.println("string" + str);
            if (str.equalsIgnoreCase("X-Axis") || str.equalsIgnoreCase("Split Rows")) {
                list.get(i).click();
                break;
            } else {
                continue;
            }
        }
        //list.get(1).click();
        //driver.findElement(By.xpath("(//li[@id='bucketButtonAddLabelID'])[2]")).click();
        if(widget.equalsIgnoreCase("Combo")) {
            int lenX = new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).getOptions().size();
            System.out.println("lenX : " + lenX);

            new Select(driver.findElement(By.xpath("//*[@id=\"3bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"3fieldSelectID\"]"))).selectByVisibleText("City");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"3metricExpandButtonIID\"]")).click();
        }
        else if(widget.equalsIgnoreCase("Area")) {
            driver.findElement(By.id("bucketAddSubButtonID")).click();
            //X Axis click                            //*[@id="bucketButtonAddLabelID"][2]
            driver.findElement(By.xpath("//*[@id=\"bucketButtonAddLabelID\"][2]")).click();

            new Select(driver.findElement(By.xpath("//*[@id=\"4bucketSelectButtonID\"]"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            new Select(driver.findElement(By.xpath("//*[@id=\"4fieldSelectID\"]"))).selectByVisibleText("Discount");
            Thread.sleep(3000);
            //X arrow button close
            driver.findElement(By.xpath("//*[@id=\"4metricExpandButtonIID\"]")).click();
        }

    }

    public static void xDataFillTree(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        int x1Count = 1, x2Count = 1;

        Thread.sleep(2000);


        for(int i=14;i<=15;i++) {
            List<WebElement> list = driver.findElements(By.cssSelector("li[id='bucketButtonAddLabelID']"));
            int size = list.size();
            System.out.println("Size Info" + size);
            String str = list.get(1).getText().trim();
            System.out.println("string" + str);
            if (str.equalsIgnoreCase("Split Rows")) {
                list.get(1).click();
            }

            driver.findElement(By.id("bucketAddSubButtonID")).click();
            //X Axis click
            new Select(driver.findElement(By.id(i+"bucketSelectButtonID"))).selectByVisibleText("Terms");
            Thread.sleep(3000);
            //X Axis Field fill
            if(i==14) {
                new Select(driver.findElement(By.id(i +"fieldSelectID"))).selectByVisibleText("Region");
                Thread.sleep(3000);
                driver.findElement(By.id(i+"metricExpandButtonIID")).click();
            }
            else {
                //X arrow button close
                new Select(driver.findElement(By.id(i +"fieldSelectID"))).selectByVisibleText("City");
                Thread.sleep(3000);
                driver.findElement(By.id(i + "metricExpandButtonIID")).click();

            }
        }
    }


    /*public static void afterStepsSavedObjects(WebDriver driver, WebDriverWait wait, String dsw) throws InterruptedException {

        List<WebElement> webEl = new ArrayList<WebElement>();

        int k = 0, j = 0;
        if (dsw.equals("Dashboards")) {
            j = 2;
        } else if (dsw.equals("Searches")) {
            j = 3;
            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/ul/li[2]/a")).click();
        } else if (dsw.equals("Widgets")) {
            driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/ul/li[3]/a")).click();
            j = 4;
        }
        Thread.sleep(3000);

        for (int i = 1; i < 5; i++) {
            try {                                                        //*[@id="kibana-body"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[3]/ul/li[1]/div[2]/input
                //System.out.println("i=" + i);                           //*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[3]/ul/li[2]/div[2]/input
                webEl.add(k, driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[" + j + "]/ul/li[" + i + "]/div[2]/input")));
                //System.out.println("j:" + j);
                //System.out.println("WebEl : " + webEl.get(k));
                //System.out.println("WebEl Size: " + webEl.size());
                k = k + 1;
            } catch (Exception e) {
                log.error("",e);
            }
        }
        System.out.println("Size of Dashboards : " + webEl.size());
        Thread.sleep(2000);

        //Checkbox is clicked
        List<WebElement> checkBox = webEl;
        for (int i = 0; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }
        //Export                                  //*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[2]
        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[2]")).click();
        Thread.sleep(20000);
        //Uncheck
        for (int i = 1; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }
        driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[1]/a[1]")).click();

        SeleniumUtils.waitForAlert(driver);
    }*/

    public static void afterStepsSavedObjects(WebDriver driver, WebDriverWait wait, String dsw) throws InterruptedException {

        List<WebElement> webEl = new ArrayList<WebElement>();

        int k = 0, j = 0;
        if (dsw.equals("Dashboards")) {
            j = 2;
        } else if (dsw.equals("Searches")) {
            j = 3;
            driver.findElement(By.cssSelector("a[title='searches']")).click();
        } else if (dsw.equals("Widgets")) {
            driver.findElement(By.cssSelector("a[title='widgets']")).click();
            j = 4;
        }
        Thread.sleep(3000);

        try {
            // webEl.add(k, driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/kbn-management-app/div/div/kbn-management-objects/div[2]/div[" + j + "]/ul/li[" + i + "]/div[2]/input")));
            List<WebElement> list = driver.findElement(By.cssSelector("div[class='tab-pane active']")).findElements(By.cssSelector("li[class='item']"));
            System.out.println(list.size());
            for (int i = 1; i < 5; i++) {
                WebElement el = list.get(i).findElement(By.cssSelector("div[class='pull-left checkbox-margin']")).findElement(By.tagName("input"));
                webEl.add(k, el);

                //System.out.println("j:" + j);
                //System.out.println("WebEl : " + webEl.get(k));
                //System.out.println("WebEl Size: " + webEl.size());

                k = k + 1;
            }
        } catch (Exception e) {
            log.error("", e);
        }

        System.out.println("Size of Dashboards : " + webEl.size());
        Thread.sleep(2000);

        //Checkbox is clicked
        List<WebElement> checkBox = webEl;
        for (int i = 0; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }

        //Export
        driver.findElement(By.cssSelector("a[class='btn btn-xs btn-default']")).click();
        Thread.sleep(13000);
        //Uncheck
        for (int i = 1; i < webEl.size(); i++) {
            checkBox.get(i).click();
        }

        driver.findElement(By.cssSelector("a[class='btn btn-xs btn-danger']")).click();
        Thread.sleep(2000);
        SeleniumUtils.waitForAlert(driver);
        Thread.sleep(8000);
    }
    public static void loginBIInValid(WebDriver driver, List<Records> listOb,String username,String password,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
        Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<File>();

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password+"123");

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();
            Thread.sleep(2000);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            try{
                driver.findElement(By.id("casErrorDiv"));
                actualOutcome=true;
            }
            catch(Exception e){
                actualOutcome=false;
                log.error("",e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LOGIN-01");
            record.setOutcome(actualOutcome);
            record.setName("INVALID LOGIN");
            record.setScreenShot(screenShot);
            record.setExpectedResult("INVALID LOGIN MESSAGE APPEARS");
            clientVersionDao.setRecordDetails(record);
        }
        /*record1.setOutcome(actualOutcome);
        record1.setName("LOGIN");
        record1.setScreenShot(screenShot);
        record1.setExpectedResult("");*/

        listOb.add(record);
        //listOb.add(record1);
    }

    //Add Client version dao for every method, aut_master_id as parameter too
    public static void loginBIValid(WebDriver driver, List<Records> listOb, String username, String password, String url, ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
      Records record = new Records();
        Boolean actualOutcome = false;
        List<File> screenShot = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.get(url);
        Thread.sleep(5000);

        try {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            //driver.findElement(By.xpath("//button[@id='closePopupbtn']")).click();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);

            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            driver.findElement(By.name("submit")).click();

            Thread.sleep(4000);

//            System.out.println("Waiting for classname: section-title-modules mb-0");
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Applications")));
//            System.out.println("Completed waiting");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(3000);


            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Widget")));
            try{
                driver.findElement(By.id("casErrorDiv")); //No Error message will be shown on screen
                actualOutcome=false;
            }
            catch(Exception e){
                actualOutcome=true;
                log.error("",e);
            }

        } catch (Exception e) {

            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
        }
        finally {

            //record.setSanityAutomationMasterID()
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("SAN-LOGIN-02");
            record.setOutcome(actualOutcome);
            record.setName("LOGIN");
            record.setScreenShot(screenShot);
            record.setExpectedResult("LOGGED IN");

            //SAN_LOG_1, PASS, Sanity_Aut_Master_ID
            //ClientVersionDao. insertSanityTCOutcome(record)
            clientVersionDao.setRecordDetails(record);
        }
       /* record1.setOutcome(actualOutcome);
        record1.setName("LOGIN");
        record1.setScreenShot(screenShot);
        record1.setExpectedResult("");*/

        listOb.add(record);
        if(!actualOutcome)
        {
            throw new Exception("Login failed.");
        }
        // listOb.add(record1);
    }

    public static void loginWB(WebDriver driver,List<File> screenShot,String username,String password) throws Exception {

        Boolean actualOutcome = false;
        try {
            driver.findElement(By.id("usr")).sendKeys(username);
            driver.findElement(By.id("pwd")).sendKeys(password);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            driver.findElement(By.id("login")).click();
            Thread.sleep(5000);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static void switchToWindow(int index, WebDriver driver) {
        String windowId = null;
        System.out.println("Present Window : " + driver.getWindowHandle());
        Set<String> allWin = driver.getWindowHandles();
        System.out.println("All windows : " + driver.getWindowHandles());
        Iterator<String> iter = allWin.iterator();

        for (int i = 0; i <= index; i++) {
            windowId = iter.next();
        }
        driver.switchTo().window(windowId);
        System.out.println("Switched to Window : " + windowId);
    }

    public static void changeDate(WebDriver driver, WebDriverWait wait, List<File> screenShot) throws Exception {

        Boolean actualOutcome = false;

        try {
            //driver.findElement(By.xpath("//*[@id=\"KGTPTimePickerBtnID\"]/pretty-duration")).click();
            driver.findElement(By.cssSelector("div[id='KGTPTimePickerBtnID']")).findElement(By.tagName("pretty-duration")).click();
            driver.findElement(By.linkText("Relative")).click();

            List<WebElement> yearDDList = driver.findElements(By.cssSelector("div[class='kbn-timepicker-section']"));
            System.out.println("yearDDList Size :"+yearDDList);
            List<WebElement> yearDDSubList = yearDDList.get(0).findElements(By.cssSelector("div[class='form-group']"));
            System.out.println("yearDDSubList Size :"+yearDDSubList);
            WebElement yearDDWeb = yearDDSubList.get(1).findElement(By.tagName("select"));
            Select yearDD = new Select(yearDDWeb);
            yearDD.selectByIndex(6);
            //GO is clicked
            yearDDList.get(2).findElement(By.cssSelector("div")).findElement(By.tagName("button")).click();

            //driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[2]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/button")).click();
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
           driver.findElement(By.cssSelector("i[class='fa fa-arrow-up']")).click();
            System.out.println("Arrow is clicked");
           // driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/kbn-timepicker/div/div[1]/i")).click();


        } catch (Exception e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static String saveByName(WebDriver driver, String saveName) {
        try {
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).click();
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(Keys.chord(Keys.BACK_SPACE));

            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/input")).sendKeys(saveName);
            driver.findElement(By.xpath("//*[@id=\"template_wrapper\"]/form/button")).click();
        } catch (Exception e) {
            System.out.println("Returning False for Save name");
           return "false";
        }
        System.out.println("Returning True for Save name");
        return "true";
    }

    public static void addClick(WebDriver driver, WebElement webElem) {
        try {
            Actions action = new Actions(driver);
            //String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[3]/div")).getText();
            //System.out.println("Alert message : "+str);
            action.moveToElement(webElem).build().perform();

            WebElement add = webElem.findElement(By.cssSelector("button[class=\"btn btn-xs btn-primary discover-field-toggle\"]"));
            add.click();
            System.out.println("Add is clicked..");
        } catch (Exception e) {
            System.out.println("Modal clicked failed inside catch..");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("OK")));
            log.error("",e);
        }
    }

    public static void clickModal(WebDriver driver, WebElement webElem) {
        try {
            Actions action = new Actions(driver);
            //String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[3]/div[2]/div/div[3]/div")).getText();
            //System.out.println("Alert message : "+str);
            action.moveToElement(webElem).click().build().perform();
            System.out.println("Modal clicked successfully..");
        } catch (Exception e) {
            System.out.println("Modal clicked failed inside catch..");
            log.error("",e);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("OK")));
            throw new RuntimeException(e);
        }
    }

    public static void waitForAlert(WebDriver driver) throws InterruptedException {
        int i = 0;
        while (i++ < 10) {
            try {
                Thread.sleep(5000);
                //Status
                System.out.println("Inside waitforalert and i : " + i);
                driver.switchTo().alert().accept();
                //Alert alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(2000);
                continue;
            }
        }
    }

    public static File takeScreenShot(WebDriver driver) throws Exception {

        Thread.sleep(2000);
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//        OutputStream out = new FileOutputStream((SrcFile));
        //File DestFile=new File(fileWithPath);
        //FileUtils.copyFile(SrcFile, DestFile);

        return SrcFile;
    }

    public static String firstWord(String str) {
        int len = str.length();
        String s = "";
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                s = str.substring(0, i);
                break;
            }
        }
        // System.out.println("Substring is : "+s+".");
        return s;
    }

    public static boolean verifyResult(WebDriver driver, String name, String expResult, Records rec, String className)
    {
        /* rec.setName(className);
            rec.setOutcome(true);
            rec.setExpectedResult(className+" Creation Pass named "+name);
            rec.setScreenShot(rec.screenShot);

            System.out.println("Name is : "+rec.getName());
            System.out.println("Outcome is : "+rec.isOutcome());
            System.out.println("Expected Result is : "+rec.getExpectedResult());
            System.out.println("Screenshot is : "+rec.getScreenShot());*/
        /* System.out.println(name+"."+" | NOT EQUALS | "+expResult+"."+" | FOR | "+className);
            rec.setName(className);
            rec.setOutcome(false);
            rec.setExpectedResult(className+" Creation Fail named "+name);
            rec.setScreenShot(rec.screenShot);*/
        return expResult.equalsIgnoreCase(name);
    }

    public static void clickLogo(WebDriver driver, WebDriverWait wait, String name) throws InterruptedException {
        System.out.println(name + " is prepared, clicking on mcube logo");
        driver.findElement(By.cssSelector("div[class='global-nav__logo']")).findElement(By.tagName("li")).click();
        //driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div[1]/nav/div[1]/li")).click();
        System.out.println("Waiting for Home Text on screen");
        Thread.sleep(6000);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/div/kbn-top-nav/div/div/div/div[3]/div[1]/div/div")));
        //wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mid-stack']"))));
        //div[id='mCubeSSPLogicID']
    }

    public static String randomStringGenerate() {

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // create random string builders
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        int length = 5;
        for (int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphabet.length());
            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
    }

    public static boolean selectIndices(WebDriver driver, WebDriverWait wait, String index) {

        boolean flag = true;
        try {
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='inputpart']")));
            Thread.sleep(1000);

            List<WebElement> list = driver.findElements(By.cssSelector("div[class='scroll-box']"));
            int size = list.size();
            System.out.println("SIZE of scroll box list: " + size);
            List<WebElement> list1 = list.get(0).findElements(By.cssSelector("li[class='control-group']"));
            int size1 = list1.size();
            System.out.println("SIZE of li list: " + size1);

            for (int i = 0; i < size1; i++) {
                //String str=list.get(i).findElement(By.cssSelector("label[class='control control--checkbox']")).getText();

                WebElement el = list1.get(i).findElement(By.tagName("label"));
                String str = el.getText();
                str = str.trim();
                Thread.sleep(1000);
                System.out.println("Index name: " + str);
                System.out.println("Index name: " + index);

                if (str.equalsIgnoreCase(index)) {
                    System.out.println("str :"+str+" and index :"+index);
                    Thread.sleep(1000);
                    list1.get(i).click();
                    break;
                } else {
                    System.out.println("continue");
                    continue;
                }
            }
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            log.error("", e);
            flag = false;
            return flag;
        }
        return flag;
    }

    public static boolean query(WebDriver driver, WebDriverWait wait) {

        boolean flag = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='dropdown-menu scrollable-menu']")));

            List<WebElement> list = driver.findElement(By.cssSelector("ul[class='dropdown-menu scrollable-menu']")).findElements(By.tagName("li"));
            int size = list.size();
            System.out.println("SIZE of Query List : " + size);
            WebElement text = driver.findElement(By.cssSelector("form[class='ng-dirty ng-valid-parse ng-valid ng-valid-required']")).findElement(By.tagName("textarea"));
            System.out.println("About to click");
            list.get(1).click();
            System.out.println("Cliocked");
            text.sendKeys(", @");

            list.get(3).click();

            text.sendKeys(" from @");
            //text.sendKeys(" from @")

            list.get(0).click();
            //text.sendKeys(","+index);
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            log.error("", e);
            flag = false;
            return flag;
        }
        return flag;
    }

    public static boolean isRoleCreated(WebDriver driver, WebDriverWait wait, String roleName) {

        boolean flag = false;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"userlist\"]")));

            List<WebElement> list = driver.findElement(By.cssSelector("div[class=\"userlist\"]")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
            int size = list.size();
            System.out.println("SIZE of Role List : " + size);

            for (int i = 0; i < size; i++) {
                if (list.get(i).getText().equals(roleName)) {
                    System.out.println(roleName + " is present");
                    flag = true;
                    list.get(i).click();
                    Thread.sleep(3000);
                    break;
                } else {
                    flag = false;
                }
            }
        } catch (Exception e) {
            e.toString();
            e.getMessage();
            log.error("",e);
            flag = false;
            return flag;
        }
        return flag;
    }

    public static void scrollByVisibleElement(WebDriver driver, WebElement webEl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webEl);
    }

    //-----------------------------------------------------------------

    public static boolean clickOkButton1(WebDriver driver,WebDriverWait wait,List<File> screenShot) throws Exception {

        String str=null;
        Boolean actualOutcome = false;

        try {

            Thread.sleep(2000);
            List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-danger']"));
            int size=list.size();
            System.out.println(size);
            for(int i=0;i<size;i++) {
                str=list.get(i).getText();
                if (str.equalsIgnoreCase("OK")||str.equalsIgnoreCase("Add Dataset")) {
                    screenShot.add(SeleniumUtils.takeScreenShot(driver));
                    list.get(i).click();
                    Thread.sleep(1000);
                }
                else{
                    continue;
                }
            }
        }
        catch (Exception e) {
            actualOutcome = false;
            Thread.sleep(5000);
            Keys.chord(Keys.ENTER);
            log.error("",e);
            throw new RuntimeException(e);
        }
        return actualOutcome;
    }

    public static String validateProfile(WebDriver driver, WebDriverWait wait,String value) {

        boolean flag=true;
        String str=null;
        //WebDriver driver = DriverFactory.getWebDriver()
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));

            List<WebElement> list =driver.findElement(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            int size=list.size();
            System.out.println(size);
            for(int i=1;i<size;i++) {
                List<WebElement> list1 =list.get(i).findElements(By.tagName("td"));
                int size1=list1.size();
                System.out.println(size1);
                str=list1.get(1).getText().trim();

                System.out.println(str);

                if (str.equals(value)){
                    System.out.println("Successful profile creation");
                    break;
                }
                else{
                    continue;
                }
            }
        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return str;
            //end of catch block
        }//end of method
        return str;
    }

    public static boolean clickData(WebDriver driver, WebDriverWait wait) {

        boolean flag= true;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-bordered']")));

            List<WebElement>  list=driver.findElement(By.cssSelector("tbody[class='highlight']")).findElements(By.cssSelector("tr[ng-repeat='tableDetails in tableMetaData']"));
            int size=list.size();
            System.out.println("SIZE: "+size);

            for(int j=0; j<size;j++){

                String rowName=list.get(j).findElement(By.cssSelector("td[class='highlighted-name']")).getText();
                System.out.println("ROW NAME: "+rowName);

                List<WebElement>  el = list.get(j).findElements(By.cssSelector("td[ng-repeat='functions in tableDetails.functionDetails ']"));
                int Size=el.size();

                for(int i=0; i<Size; i++){

                    String str=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span")).getAttribute("class");

                    if(str.contains("checkmark-disabled")){
                        continue;
                    }

                    else{
                        WebElement elem=el.get(i).findElement(By.cssSelector("label[class='container']")).findElement(By.tagName("span"));
                        js.executeScript("arguments[0].click();", elem);

                        System.out.println(i+". CHECKED");
                    }
                }
            }
        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }	//end of method


    public static boolean clickAddNew(WebDriver driver, WebDriverWait wait) {

        boolean flag=true;
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")));

            WebElement we =driver.findElement(By.cssSelector("div[class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-fade']")).findElement(By.cssSelector("div[class='ajs-body']")).findElement(By.tagName("input"));

            String str=we.getAttribute("class");
            System.out.println(str);

            if(str.equals("form-control")){
                System.out.println("Element is Visible");
            }

        }//end of try block

        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }	//end of method
        return flag;
    }

    public static boolean clickDb(WebDriver driver, WebDriverWait wait, String value, String value1) {

        boolean flag = true;
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='a db-set']")));

            List<WebElement> list = driver.findElement(By.cssSelector("div[class='a db-set']")).findElement(By.cssSelector("div[class='db-set-inner']")).findElements(By.tagName("db-list"));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).getAttribute("textContent");
                System.out.println("DB NAME: " + str);
                if (str.equals(value)) {
                    Thread.sleep(1000);
                    list.get(i).findElement(By.cssSelector("label[class='dbLabel']")).click();

                    Thread.sleep(2000);
                    List<WebElement> list1 = list.get(i).findElement(By.cssSelector("ul[class='subList']")).findElements(By.cssSelector("li[class='tableLabel']"));
                    int Size = list1.size();
                    System.out.println("Li Size "+Size);

                    for (int j = 0; j < Size; j++) {

                        String str1 = list1.get(j).getText();
                        System.out.println("Dataset Name:" + str1);

                        if (str1.equals(value1)) {
                            Thread.sleep(2000);
                            list1.get(j).click();
                            break;
                        }
                    }
                    break;
                }
            }
        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }

    public static void switchToWindow1(String title, WebDriver driver) {

        boolean foundWindow = false;

        for(String handle:driver.getWindowHandles()) {

            if (driver.switchTo().window(handle).getTitle().contains(title)) {
                System.out.println("Switched to window with title:" + title);
                foundWindow = true;
                break;
            }
            if (foundWindow) {
                System.out.println("Couldn't find the window with title -> " + title);
            }
        }
    }

    public static void dbConnection(WebDriver driver,String database,int index,String connectionName, List<File> screenShot) {

        //  Boolean actualOutcome=false;
        String str=null;

        try {

            //datasource click, database click, select jdbc and jpfdist and create a wf and run the workflow and validate green tick
            driver.findElement(By.cssSelector("div[class='model-navigator']")).findElement(By.cssSelector("li[ng-click='$ctrl.openDatasources()']")).click();
            Thread.sleep(4000);
            driver.findElement(By.cssSelector("span[class='btn-modal__icon sa sa-database']")).click();

            Select databaseDropdown = new Select(driver.findElement(By.cssSelector("select[class='select-drive select-dataserver ng-pristine ng-untouched ng-valid ng-empty']")));
            System.out.println("databaseDropdown: " + databaseDropdown);

            databaseDropdown.selectByIndex(index);

            Thread.sleep(5000);

            driver.findElement(By.cssSelector("input[id='DATABASE']")).sendKeys("gpadmin");

            driver.findElement(By.cssSelector("input[id='host']")).sendKeys("192.112.200.16");

            driver.findElement(By.cssSelector("input[id='port']")).sendKeys("5432");

            driver.findElement(By.cssSelector("input[id='username']")).sendKeys("gpadmin");

            driver.findElement(By.cssSelector("input[id='password']")).sendKeys("gpadmin");

            driver.findElement(By.cssSelector("button[class='btnstyle align-right']")).click();

            Thread.sleep(3000);

            str = driver.findElement(By.cssSelector("div[class='error-mgs ng-binding ng-scope']")).getText().trim();

            System.out.println(str);

            Thread.sleep(3000);

            Select databaseDropdown1 = new Select(driver.findElement(By.cssSelector("select[id='tables']")));

            System.out.println("databaseDropdown: " + databaseDropdown1);

            databaseDropdown1.selectByVisibleText("sales_all_details_11");

            if(database.equals("Greenplum-JDBC")) {

                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);

            }
            else if(database.equals("Greenplum-GPFDIST")) {

                Thread.sleep(3000);

                Select partitionDropdown = new Select(driver.findElement(By.cssSelector("select[id='PARTITIONCOL']")));

                partitionDropdown.selectByVisibleText("gp_segment_id");

                driver.findElement(By.cssSelector("input[id='PARTITIONNUM']")).sendKeys("100");

                driver.findElement(By.cssSelector("input[id='SPARKPORT']")).sendKeys("12005");

                driver.findElement(By.cssSelector("input[name='datasourceName']")).sendKeys(connectionName);

            }
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("button[class='btn btn-blue ng-scope']")).click();
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("div[class='cross']")).click();
        }
        catch (Exception e) {
            log.error("", e);
        }
    }

    public static boolean addReadNode(WebDriver driver, WebDriverWait wait,String value, List<File> screenShot) throws Exception {

        boolean flag=true;
        Actions actions = new Actions(driver);
        String str=null;

        //WebDriver driver = DriverFactory.getWebDriver()
        try {

            WebElement elementLocator = driver.findElement(By.cssSelector("div[class='new-node-container']"));
            actions.contextClick(elementLocator).perform();
            Thread.sleep(3000);

            WebElement inputOutput=driver.findElement(By.cssSelector("operation-catalogue[class='new-node__catalogue ng-isolate-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
            actions.moveToElement(inputOutput).perform();
            Thread.sleep(3000);

            WebElement readData=driver.findElement(By.cssSelector("div[class='operations-list__next-level ng-scope']")).findElement(By.cssSelector("div[class='operations-list__name ng-binding']"));
            actions.moveToElement(readData).click().build().perform();
            Thread.sleep(3000);
            if(value.contains("Greenplum-GPFDIST")) {

                List<WebElement> list1 = driver.findElements(By.cssSelector("div[class='custom-name ng-binding ng-scope']"));
                list1.get(1).findElement(By.cssSelector("span[class='ng-binding']")).click();

            }
            else{
                driver.findElement(By.cssSelector("div[class='custom-name ng-binding ng-scope']")).findElement(By.cssSelector("span[class='ng-binding']")).click();
            }

            List<WebElement> list= driver.findElement(By.cssSelector("div[class='datasources-list']")).findElements(By.cssSelector("div[class='datasources-element__name-wrapper']"));
            int size=list.size();

            System.out.println(size);

            for(int i=0;i<size;i++){

                WebElement we=list.get(i).findElement(By.cssSelector("div[class='datasources-element__name ng-binding']"));
                str=we.getAttribute("title").trim();
                Thread.sleep(3000);
                System.out.println(str);
                System.out.println(value);

                if(value.equals(str)){
                    Thread.sleep(2000);
                    we.click();
                    break;
                }
                else{
                    continue;
                }
            }

            Thread.sleep(2000);
            Select reportType = new Select(driver.findElement(By.cssSelector("select[ng-model='choice']")));
            reportType.selectByIndex(1);
            Thread.sleep(4000);
            clickMenuItems(driver,"Run");
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            Thread.sleep(10000);

        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }//end of method
        return flag;
    }

    public static void clickMenuItems(WebDriver driver,String usage) {

        Boolean actualOutcome=false;
        String str=null;
        try {
            Thread.sleep(2000);
            List<WebElement> list=driver.findElement(By.cssSelector("div[class='pull-right workflow-navbar__top-menu-options']")).findElements(By.cssSelector("span[class='workflow-navbar__text-label ng-binding']"));
            int size=list.size();
            System.out.println("Menu Items: "+size);
            for(int i=0;i<size;i++){

                str=list.get(i).getText().trim();
                System.out.println("str"+str);
                if(usage.equals(str))
                {
                    list.get(i).click();
                    break;
                }
                else{
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Click Failed");
            log.error("", e);
        }
    }

    public static boolean validateSuccess(WebDriver driver, WebDriverWait wait,String value) {

        boolean flag=true;
        //WebDriver driver = DriverFactory.getWebDriver()
        try {
            // WebDriverWait wait = new WebDriverWait(driver, 2, 1000);
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=' tableFixHead2 intro-page-table full-width-table']")));

            List<WebElement> list =driver.findElements(By.cssSelector("div[class='graph-node__content']"));
            int size=list.size();
            System.out.println(size);
            for(int i=0;i<size;i++) {

                WebElement we =list.get(i).findElement(By.cssSelector("status-icon[class='graph-node__status-icon ng-scope ng-isolate-scope']")).findElement(By.cssSelector("div[popover-placement='right']"));

                String str=we.getAttribute("class").trim();

                System.out.println(str);

                if (str.equals(value)){
                    System.out.println("Read Node Executed Successfully");
                    flag=true;
                }
                else{
                    continue;
                }
            }
        }//end of try block
        catch (Exception e) {

            e.toString();
            e.getMessage();
            flag = false;
            return flag;
            //end of catch block
        }//end of method
        return flag;
    }
    public static void clickOkButton(WebDriver driver,WebDriverWait wait) throws Exception {

        Boolean actualOutcome = false;

        try {

            Thread.sleep(2000);
            List<WebElement> list= driver.findElements(By.cssSelector("button[class='ajs-button btn btn-primary']"));
            int size=list.size();
            System.out.println(size);
            if(size==1) {
                list.get(0).click();
                Thread.sleep(1000);
            }
            else{
                list.get(1).click();
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            actualOutcome = false;
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyAAWorkflow2(WebDriver driver) {
        boolean flag=true;
        int counter = 0;
        try
        {
            List<WebElement> Weblist = driver.findElement(By.cssSelector("div[class='c-dynamic-part ng-scope']")).findElement(By.cssSelector("div[class='editor']")).findElement(By.cssSelector("div[class='flowchart-paint-area']")).findElements(By.cssSelector("graph-node[class='graph-node-component ng-scope ng-isolate-scope jtk-draggable jtk-endpoint-anchor jtk-connected']"));
            int size = Weblist.size();
            System.out.println("No. of nodes " +size);
            for(int i =0; i < size; i++) {
                List<WebElement> we = Weblist.get(i).findElement(By.tagName("status-icon")).findElements(By.tagName("div"));
                //WebElement we1 = we.get(0)
                String sText1 = we.get(0).getAttribute("class");
                sText1=sText1.trim();
                System.out.println(sText1);

                if(sText1.contains("status-icon completed"))
                {
                    counter+=1;
                    //flag=true
                    System.out.println("pass");
                }
                else
                {
                    flag=false;
                    System.out.println("continue");
                }

            }//end of for loop
            if(counter==size)
            {
                System.out.println("No. of nodes having checked status " +counter);
                System.out.println("pass:- No. of nodes and checked status are equal");
            }
            else {
                System.out.println("fail:- No. of nodes and checked status are not equal");
            }
        }//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //End of catch block
        return flag;
    } //end of method
    public static void dashboardFailure(WebDriver driver, List<Records> listOb,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {
        Records record = new Records();
        List<File> screenShot = new ArrayList<>();
        screenShot.add(SeleniumUtils.takeScreenShot(driver));

        Records.setSan_aut_id(san_aut_id);
        record.setTestCaseName("SAN-DASHBOARD-01");
        record.setOutcome(actualOutcome);
        record.setName("Dashboard.");
        record.setScreenShot(screenShot);
        record.setExpectedResult("Dashboard completed successfully.");
        clientVersionDao.setRecordDetails(record);

        listOb.add(record);
        System.out.println("Dashboard creation failed due to null widgetlist.");
    }
    public static int checkNull(List<String> widgetList)
    {
        int flag=0;
        for(String name : widgetList) {
            if(name.contains("Mcube_")) {
                flag = 1;
                break;
            }
            else {
                flag=0;
            }
        }
        return flag;
    }

    public static boolean checkVersion(WebDriver driver, WebDriverWait wait, List<Records> listOb, String className,ClientVersionDao clientVersionDao,int san_aut_id) throws Exception {

        Records record = new Records();
        List<File> screenShot = new ArrayList<>();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HelpglobalTitleID")));
            driver.findElement(By.id("HelpglobalTitleID")).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appVersionHelpPageID")));
            String version = driver.findElement(By.id("appVersionHelpPageID")).getText().trim();
            System.out.println("Version name : "+version);
            screenShot.add(SeleniumUtils.takeScreenShot(driver));

            if(className.contains("4550") || version.equals("Version: 4.5.5.0") || version.equals("Version: 4.5.3.0"))
                actualOutcome=true;
            else if(className.contains("4540") && version.equals("Version: 4.5.4.0"))
                actualOutcome=true;
            else if(className.contains("4531") && version.equals("Version: 4.5.3.1"))
                actualOutcome=true;
            else if(className.contains("4530") && version.equals("Version: 4.5.3.0"))
                actualOutcome=true;
            else if(className.contains("4520") && version.equals("Version: 4.5.2.0"))
                actualOutcome=true;
            else if(className.contains("4510") && version.equals("Version: 4.5.1.1"))
                actualOutcome=true;
            else if(className.contains("4500") && version.equals("Version: 4.5.0.0"))
                actualOutcome=true;
            else if(className.contains("ipds") && version.equals("Version: 3.2.0.0"))
                actualOutcome=true;
            else actualOutcome= className.contains("ad4300") && version.equals("Version: 4.3");
        } catch (InterruptedException e) {
            screenShot.add(SeleniumUtils.takeScreenShot(driver));
            actualOutcome = false;
            log.error("",e);
            //throw new RuntimeException(e);
        }
        finally {
            Records.setSan_aut_id(san_aut_id);
            record.setTestCaseName("VERSION CHECK");
            record.setOutcome(actualOutcome);
            record.setName("Version Check");
            record.setScreenShot(screenShot);
            record.setExpectedResult("Version check completed successfully.");
            clientVersionDao.setRecordDetails(record);

            listOb.add(record);
            if (!actualOutcome) {
                //throw new Exception("Data Upload creation fail");
                System.out.println("Version check failed");
                return actualOutcome;
            }
        }
        return actualOutcome;
    }



    //------------------Jayisha Validations
    public static boolean validateMetrics_combo(WebDriver driver, String className) {

        System.out.println("Inside validateMetrics_combo");
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            System.out.println("Hi");

            //driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click()

//            Thread.sleep(2000);-------------Error

            //driver.findElement(By.xpath("//*[@id='kibana-body']/div[1]/div/div/div[2]/visualize-app/div/div[2]/visualize/visualize-spy/div[1]/div/i")).click()

//            Thread.sleep(2000)-------------Error

            String lhsY = driver.findElement(By.cssSelector("span[id='1metricDescriptionID']")).getText();

            lhsY = lhsY.trim();

            String lhsX = driver.findElement(By.cssSelector("span[id='2metricDescriptionID']")).getText();

            lhsX = lhsX.trim();

            //driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click()

            if (counter % 2 == 1 && className.equals("Combo 1")) // this is because in Combo-1, screen in spy mode, custom label added for metric/bucket and ok is clikcked no changes seen in spy header - JIRA needs to be raised
            {
                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                System.out.println("CLicked Spy inside if block");
                Thread.sleep(3000);
                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                Thread.sleep(3000);
            }
            counter = counter + 1;
            System.out.println("Countt : " + counter);


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-condensed']")));

            List<WebElement> spyMetrics = driver.findElement(By.cssSelector("table[class='table table-condensed']")).findElements(By.tagName("th"));

            int l = spyMetrics.size();

            String spyX = spyMetrics.get(0).findElement(By.tagName("span")).getText();
            spyX = spyX.trim();

            String spyY = spyMetrics.get(1).findElement(By.tagName("span")).getText();

            if ((lhsY.startsWith("Median")) && (spyY.startsWith("50th percentile of"))) {
                lhsY = lhsY.replace("Median", "50th percentile of");
            } else if ((spyY.startsWith("50th percentile of"))) {
                lhsY = "50th percentile of " + lhsY;
            }
            System.out.println("LHS X : " + lhsX);
            System.out.println("SPY X : " + spyX);
            System.out.println("LHS Y : " + lhsY);
            System.out.println("SPY Y : " + spyY);

            boolean r1 = lhsY.equals(spyY);
            boolean r2 = lhsX.equals(spyX);

            System.out.println("R1: " + r1 + " AND R2 :" + r2);

            if (!(r1) || !(r2)) {
                System.out.println("You FAILEDD Metric Validation");
                flag = false;
                return flag;
            } else if ((r1) && (r2)) {
                System.out.println("You PASSED Metric Validation");
                flag = true;
                return flag;
            }
        }    //end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateMetrics_combo(driver, "Combo 1");
            } else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }    //end of method

    public static boolean validateYData_combo(WebDriver driver) {

        boolean flag = true;
        int counter = 0;

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Inside validateYData_combo");
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-condensed']")));


            //Datas of each spy row
            List<WebElement> spyData = driver.findElement(By.cssSelector("table[class='table table-condensed']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

            //----------
            int spyLength = spyData.size();
            System.out.println("Spy Length of X Axis : " + spyLength);

            List<String> spyYContent = new ArrayList<>();
            for (int i = 0; i < spyLength; i++) {
                String temp = spyData.get(i).getAttribute("textContent");
                spyYContent.add(temp);
                System.out.println("spyYContent " + temp);
            }

            //----------

            //To chart mode
            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-chart']")));

            List<WebElement> chartData = driver.findElement(By.cssSelector("g[class='c3-chart']")).findElement(By.cssSelector("g[class='c3-chart-texts']")).findElements(By.tagName("text"));

            //-----------------
            //int xAxisLength = xAxisData.size()
            int chartLength = chartData.size();
            System.out.println("Chart Length of Y axis : " + chartLength);

            List<String> yAxisContent = new ArrayList<>();
            for (int i = 0; i < chartLength; i++) {
                String temp1 = chartData.get(i).getAttribute("textContent");
                yAxisContent.add(temp1);
                System.out.println("yAxisContent " + temp1);
            }

            //-----------------xAxisContent.size();


            System.out.println("Chart Size : " + chartLength);
            //Wait for Chart x axis data
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-x']")));

            //for(int i = chartLength - 1; i >= 0; i--) {
            for (int i = yAxisContent.size() - 1; i >= 0; i--) {
                //println('Waiting for (i*2)+1 : '+spyData.get((i*2)+1))

                //String temp = spyData.get((i*2)+1).getAttribute("textContent")
                String temp = spyYContent.get((i * 2) + 1);

                temp = temp.replace(",", "");

                double d = Double.parseDouble(temp);

                temp = String.valueOf(df.format(d));

                //String temp1 = chartData.get(i).getAttribute("textContent")
                String temp1 = yAxisContent.get(i);

                temp1 = temp1.replace(",", "");

                System.out.println("Chart Data	: " + temp1);

                System.out.println("Spy Data	: " + temp);

                boolean r = temp1.equals(temp) || temp1.equals(temp + "0") || temp1.equals(temp + ".00");

                System.out.println("Interim result: " + r);

                if (!(r)) {
                    flag = false;
                    //to spy mode
                    driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                    System.out.println("R1 Spy Chart switch is click inside validateYData and Flag : " + flag);
                    //driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                    return flag;
                } else if ((r)) {
                    flag = true;
                    //to spy mode
                    driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                    System.out.println("R2 Spy Chart switch is click inside validateYData and Flag : " + flag);
                    return flag;
                }
            }    //end of chart for loop
        }    //end of try block
        catch (StaleElementReferenceException ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }

    public static boolean validateXData_combo(WebDriver driver) {

        boolean flag = true;
        int counter = 0;

        DecimalFormat df = new DecimalFormat("#.##");

//        WebDriver driver = DriverFactory.getWebDriver()

        try {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-condensed']")));

            List<WebElement> spyData = driver.findElement(By.cssSelector("table[class='table table-condensed']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

            int spyLength = spyData.size();
            System.out.println("Spy Length of X Axiss : "+spyLength);

            List<String> spyXContent= new ArrayList<>();
            for(int i = 0; i < spyLength; i++) {
                String temp = spyData.get(i).getAttribute("textContent");
                spyXContent.add(temp);
                System.out.println("spy row Content " + temp);
            }

            //To chart mode
            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-chart']")));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-x']")));

            List<WebElement> xAxisData = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("tspan"));

            int xAxisLength = xAxisData.size();
            System.out.println("Chart Length of X axis : "+xAxisLength);

            List<String> xAxisContent=new ArrayList<>();
            for(int i = 0; i < xAxisLength; i++) {
                String temp1 = xAxisData.get(i).getAttribute("textContent");
                xAxisContent.add(temp1);
                System.out.println("xAxisContent " + temp1);
            }

            //Clicking on spy mode arrow
            //driver.findElement(By.xpath("//*[@id='kibana-body']/div[1]/div/div/div[2]/visualize-app/div/div[2]/visualize/visualize-spy/div[1]/div/i")).click()

            System.out.println("xAxisContent Size :  " + xAxisContent.size());

            for(int i = 0; i < xAxisContent.size(); i++) {

                //--------------
                String temp = spyXContent.get(i*2);
                System.out.println("Spy Datae	: " + temp);

                String temp1 = xAxisContent.get(i);
                temp1=temp1.replaceAll(",", "");
                System.out.println("X Axis Datae	: " + temp1);

                boolean r = temp.equals(temp1);
                if(!r) {
                    System.out.println("Inside validateXData_combo r : "+r);
                    flag = false;
                    return flag;
                }

                //--------------
                //				String temp = spyData.get(i*2).getAttribute("textContent")
                //				println("Spy Data	: " + temp)
                //
                //				String temp1 = xAxisData.get(i).getAttribute("textContent")
                //				println("X Axis Data	: " + temp1)
                //
                //				boolean r = temp.equals(temp1)
                //				if(!r) {
                //					flag = false
                //					return flag
                //				}
            }	//end of x axis for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateXData_combo(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static void clickSelectButton(WebDriver driver, String colorPicker) {

//        WebDriver driver = DriverFactory.getWebDriver()

        String css = "div[class='" + colorPicker + "']";

        WebElement we = driver.findElement(By.cssSelector(css)).findElement(By.className("select"));

        we.click();
        System.out.println("Seelct of color box is clicked");
    }

    public static boolean validateSeriesColor(int index,WebDriver driver) {

        System.out.println("Validating color start-------------------------->");
        int counter = 0;
        boolean flag = true;

//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-chart-lines']")));

            // Chart dotted path of graph
            List<WebElement> chartPath = driver.findElement(By.cssSelector("g[class='c3-chart-lines']")).findElements(By.tagName("path"));


            //List<WebElement> chartCircle = driver.findElement(By.cssSelector("g[class='c3-chart-lines']")).findElements(By.tagName("cirlce"))

            //No Option to color circle with different color
            int lengthPath = chartPath.size();
            //int lengthCircle = chartCircle.size()

            for(int i = 0; i < lengthPath; i++) {

//                String ColorStroke = "stroke: rgb" +rgb.get(index-1);
//                String FillColor = "fill: rgb" +rgb.get(index-1);
                String ColorStroke = "stroke: rgb" + rgb.get(index-1);
                String FillColor = "fill: rgb" + rgb.get(index-1);

                String style = chartPath.get(i).getAttribute("style");

                if((style.contains(ColorStroke)) || (style.contains(FillColor))) {
                    System.out.println("true: path");
                }
                else {
                    flag = false;
                    return flag;
                }
            }

            List<WebElement> chartCircle = driver.findElement(By.cssSelector("g[class='c3-chart-lines']")).findElements(By.tagName("cirlce"));
            int lengthCircle = chartCircle.size();

            for(int i = 0; i < lengthCircle; i++) {

//                String FillColor = "fill: rgb" +rgb.get(index-1);
                String FillColor = "fill: rgb" + rgb.get(index-1);

                String style = chartCircle.get(i).getAttribute("style");

                if(style.contains(FillColor)) {
                    System.out.println("true: circle");
                }
                else {
                    flag = false;
                    return flag;
                }
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateSeriesColor(index,driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        System.out.println("Valiudaring color ends-------------------------->");
        return flag;
    }

    public static boolean validateDLPreSuff(WebDriver driver,String prefix, String suffix) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-chart']")));

            //List<WebElement> chartData = driver.findElement(By.cssSelector("g[class='c3-chart']")).findElement(By.cssSelector("g[class='c3-chart-texts']")).findElements(By.tagName("text"))
            List<WebElement> chartData = driver.findElement(By.cssSelector("g[class='c3-chart']")).findElement(By.cssSelector("g[class='c3-chart-texts']")).findElements(By.tagName("text"));

            int chartLength = chartData.size();
            System.out.println("chartLength : "+chartLength);

            for(int i = 0; i < chartLength; i++) {
                //String temp = chartData.get(i).getAttribute("textContent")
                String temp = chartData.get(i).getAttribute("innerHTML");
                //String temp = chartData.get(i)

                System.out.println("Data Label: " + temp);
                boolean p = temp.startsWith(prefix);
                System.out.println("p: " + p);

                boolean s = temp.endsWith(suffix);
                System.out.println("s: " + s);

                flag = p && s;

                if (flag == false) {
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateDLPreSuff(driver,prefix, suffix);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateTTPreSuff(WebDriver driver,String prefix, String suffix) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-chart']")));

            List<WebElement> chartCircles = driver.findElement(By.cssSelector("g[class='c3-chart']")).findElement(By.cssSelector("g[class='c3-chart-lines']")).findElements(By.tagName("circle"));

            int chartLength = chartCircles.size();

            for(int i = 0; i < chartLength; i++) {

                WebElement a = chartCircles.get(i);
                Actions builder = new Actions(driver);
                Action mouseOver = builder.moveToElement(a).build();
                mouseOver.perform();

                List<WebElement> ttData = driver.findElement(By.cssSelector("div[class='c3-tooltip-container']")).findElements(By.tagName("td"));

                String tt_text = ttData.get(1).getAttribute("textContent");

                System.out.println("Text: " + tt_text);

                boolean p = tt_text.startsWith(prefix);
                boolean s = tt_text.endsWith(suffix);

                flag = p && s;
            }	//end of outer for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateTTPreSuff(driver,prefix, suffix);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean legendValidations(WebDriver driver,String property, String value) {
        int counter = 0;
        boolean flag = true;
        boolean r = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-chart']")));

            List<WebElement> legends = driver.findElements(By.cssSelector("g[class^='c3-legend-item']"));
            int legendLength = legends.size();

            for(int i = 0; i < legendLength; i++) {
                WebElement we = legends.get(i).findElement(By.tagName("text"));

                String style = we.getAttribute("style");

                System.out.println("Legend Style: " + style);

                switch(property) {
                    case "Font Size":
                        String fontsize = "font-size: " + value + "pt";
                        System.out.println("fontsize: " + fontsize);
                        System.out.println("style: " + style);
                        r = style.contains(fontsize);
                        System.out.println("r: " + r);
                        if(!r) {
                            flag = false;
                            return false;
                        }
                        break;

                    case "Bold":
                        String bold = "font-weight: bold";
                        r = style.contains(bold);
                        if(!r) {
                            flag = false;
                            return flag;
                        }
                        break;

                    case "Italics":
                        String italic = "font-style: italic";
                        r = style.contains(italic);
                        if(!r) {
                            flag = false;
                            return flag;
                        }
                        break;

                    case "Font Color":
                        int index = Integer.parseInt(value);
//                        String color =rgb.get(index-1);
                        String color = rgb.get(index-1);
                        String fontcolor = "fill: rgb" + color;
                        r = style.contains(fontcolor);
                        if(!r) {
                            flag = false;
                            return flag;
                        }
                        break;

                    case "Font Family":
                        if(value.equals("Sans-Serif")) {
                            value = "sans-serif";
                        }
                        if(value.equals("Times New Roman")) {
                            value = "Times New Roman";
                        }
                        if(value.equals("Verdana")) {
                            value = "Verdana";
                        }
                        String fontfamily = "font-family: " + value;
                        r = style.contains(fontfamily);
                        if(!r) {
                            flag = false;
                            return flag;
                        }
                        break;
                }	//end of switch-case
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                legendValidations(driver,property, value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }

    public static boolean validateTitlePosition(WebDriver driver,String value) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()
        try {

            String newstr=driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElement(By.tagName("text")).getAttribute("style");


            if(value.endsWith("TOP")) {

                if(newstr.contains("text-anchor: end")){

                    System.out.println("Title position: " +value );
                }
            }
            else if(value.endsWith("BOTTOM")){

                if(newstr.contains("text-anchor: start")){

                    System.out.println("Title position: " +value );
                }
                else if(value.endsWith("MIDDLE")){

                    if(newstr.contains("text-anchor: middle")){

                        System.out.println("Title position: " +value );
                    }


                    else {
                        flag = false;
                        return flag;
                    }
                }
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateTitlePosition(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateItalicsFontY(WebDriver driver) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
            int s = list.size();
            System.out.println("validateItalicsFont Size s Y axis: "+s);

            for(int i = 0; i < s; i++) {

                String str="font-style: italic";
                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");
                System.out.println("str : "+str+" dis : "+dis);

                if(dis.contains(str)) {
                    System.out.println("Italics-Font: " +str);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateItalicsFontY(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }

    public static boolean validateItalicsFontY2(WebDriver driver) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));
            int s = list.size();
            System.out.println("validateItalicsFont Size s Y axis: "+s);

            for(int i = 0; i < s; i++) {

                String str="font-style: italic";
                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");


                if(dis.contains(str)) {
                    System.out.println("Italics-Font: " +str);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateItalicsFontY2(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }

    public static boolean validateMaxXLabels(WebDriver driver,int num) {

        int c = 0;

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.cssSelector("g[class='tick']"));
            int s = list.size();

            for(int i = 0; i < s; i++) {

                String dis = list.get(i).getAttribute("style");

                if(dis.contains("display: block"))
                {
                    c++;
                }
            }	//end of for loop

            if(c<=num) {
                System.out.println(c + "<=" + num);
            }
            else {
                flag = false;
                return flag;
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateMaxXLabels(driver,num);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateRotateXTicks(WebDriver driver,String value) {

        String rotvalue = "rotate("+ value + ")";

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("text"));

            int s = list.size();

            for(int i = 1; i < s; i++) {
                String rot=list.get(i).getAttribute("transform");

                System.out.println("Transform: " + rot);

                if( rotvalue.equals(rot)) {

                    System.out.println("Tick label rotated by " + value + "degrees");
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateRotateXTicks(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateMaxXTickLength(WebDriver driver,int value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()
        System.out.println("Inside Max length ");
        try {
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("text"));
//            System.out.println("List : "+list.);
            int s = list.size();
            System.out.println("Tick lengths : "+s);

            Thread.sleep(20000);
//            for(int i = 1; i < s; i++) {
            for(int i = 0; i < s; i++) {

                System.out.println("Inside i: "+i);
                String str=list.get(i).findElement(By.tagName("tspan")).getText();
                int len=str.length();
                System.out.println("str tick:"+ str);
                System.out.println("len tick:"+ len);
                if(len <= value) {
                    System.out.println(len + "<=" + value);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateMaxXTickLength(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }	//end of method

    public static boolean validateMaxY2TickLength(WebDriver driver,int value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()
        System.out.println("Inside validateMaxY2TickLength ");
        try {
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.tagName("text"));
//            System.out.println("List : "+list.);
            int s = list.size();
            System.out.println("Tick lengths : "+s);

            Thread.sleep(20000);
//            for(int i = 1; i < s; i++) {
            for(int i = 1; i < s; i++) {

                System.out.println("Inside i: "+i);
                String str=list.get(i).findElement(By.tagName("tspan")).getText();
                int len=str.length();
                System.out.println("str tick:"+ str);
                System.out.println("len tick:"+ len);
                if(len <= value) {
                    System.out.println(len + "<=" + value);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateMaxY2TickLength(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }	//end of method

    public static boolean validateMaxYTickLength(WebDriver driver,int value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.tagName("text"));

            int s = list.size();

            for(int i = 1; i < s; i++) {

                String str=list.get(i).findElement(By.tagName("tspan")).getText();

                int len=str.length();

                if(len <= value) {

                    System.out.println(len + "<=" + value);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateMaxXTickLength(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateFontSizeX(WebDriver driver,String value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.tagName("text"));

            int s = list.size();

            for(int i = 1; i < s; i++) {

                String str=list.get(i).getAttribute("style");
                String newstr="font-size: "+ value +"pt";

                if(str.contains(newstr)){

                    System.out.println("FONT-SIZE: " + value);
                }

                else {
                    flag = false;
                    return flag;
                }
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateFontSizeX(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateFontSizeY(WebDriver driver,String value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.tagName("text"));

            int s = list.size();

            for(int i = 1; i < s; i++) {

                String str=list.get(i).getAttribute("style");
                String newstr="font-size: "+ value +"pt";

                if(str.contains(newstr)){

                    System.out.println("FONT-SIZE: " + value);
                }

                else {
                    flag = false;
                    return flag;
                }
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateFontSizeY(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }

    public static boolean validateFontSizeY2(WebDriver driver,String value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.tagName("text"));

            int s = list.size();

            for(int i = 1; i < s; i++) {

                String str=list.get(i).getAttribute("style");
                String newstr="font-size: "+ value +"pt";

                if(str.contains(newstr)){

                    System.out.println("FONT-SIZE: " + value);
                }

                else {
                    flag = false;
                    return flag;
                }
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateFontSizeY2(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }
    public static boolean validateBoldFontX(WebDriver driver) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-x']")).findElements(By.cssSelector("g[class='tick']"));
            int s = list.size();


            for(int i = 0; i < s; i++) {

                String str= "font-weight: bold";
                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");
                System.out.println("string" +dis);
                if(dis.contains(str)) {
                    System.out.println("Bold-Font: " +str);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateBoldFontX(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateBoldFontY(WebDriver driver) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
            int s = list.size();


            for(int i = 0; i < s; i++) {

                String str= "font-weight: bold";
                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");
                System.out.println("string" +dis);
                if(dis.contains(str)) {
                    System.out.println("Bold-Font: " +str);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateBoldFontY(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateBoldFontY2(WebDriver driver) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));
            int s = list.size();


            for(int i = 0; i < s; i++) {

                String str= "font-weight: bold";
                String dis = list.get(i).findElement(By.tagName("text")).getAttribute("style");
                System.out.println("string" +dis);
                if(dis.contains(str)) {
                    System.out.println("Bold-Font: " +str);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateBoldFontY(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateTitleText(WebDriver driver,String value) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            String newstr	= driver.findElement(By.cssSelector("text[class='c3-axis-y-label']")).getText();


            if(value.equals(newstr)) {
                System.out.println("Title text: " + newstr);
            }
            else {
                flag = false;
                return flag;
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateTitleText(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of

    public static boolean validateTitleText(WebDriver driver) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            String str = driver.findElement(By.cssSelector("span[id='2metricDescriptionID']")).getText();
            String newstr	= driver.findElement(By.cssSelector("text[class='c3-axis-x-label']")).getText();

            System.out.println("STR: " + str);
            if(str.startsWith(newstr)) {
                System.out.println("Title text: " + newstr);
            }
            else {
                flag = false;
                return flag;
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateTitleText(driver);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateLineColor(WebDriver driver,int index) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()
        System.out.println("Inside validateLineColor");
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-y']")));

            String newstr	= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElement(By.cssSelector("path[class='domain']")).getAttribute("style");

//            String str = "stroke: rgb" +rgb.get(index-1);
            String str = "stroke: rgb" + rgb.get(index-1);
            System.out.println("str2 : "+str);
            System.out.println("newstr2 : "+newstr);

            if(newstr.contains(str)) {
                System.out.println("LINE-8COLOR:" +newstr);
            }
            else {
                flag = false;
                return flag;
            }

        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateLineColor(driver,index);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateYExtent(WebDriver driver,int max, int min){


        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));

            int s = list.size();
            for(int i = 0; i < s; i++) {

                int value=Integer.valueOf(list.get(i).findElement(By.tagName("tspan")).getText());

                if(value<= max && value >= min ) {

                    System.out.println("Yextent: " +value);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateYExtent(driver,max,min);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validatePrefixSuffixY2(WebDriver driver,String prefix, String suffix){


        System.out.println("Inside validatePrefixSuffix");
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));

            int s = list.size();
            System.out.println("last size : "+s);

            for(int i = 0; i < s; i++) {

                String value=list.get(i).findElement(By.tagName("tspan")).getText();

                boolean first = value.startsWith(prefix);
                boolean last = value.endsWith(suffix);

                System.out.println("First : "+first);
                System.out.println("last : "+last);
                System.out.println("value : "+value);
                if(first && last ) {
                    //if( value.startsWith(prefix) && value.endsWith(suffix) ){

                    System.out.println("Prefix-Suffix: " +value);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validatePrefixSuffixY2(driver,prefix,suffix);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE value!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validatePrefixSuffixY(WebDriver driver,String prefix, String suffix){


        System.out.println("Inside validatePrefixSuffix");
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
//            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));
            List<WebElement> list = driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));

            int s = list.size();
            System.out.println("last size : "+s);

            for(int i = 0; i < s; i++) {

                String value=list.get(i).findElement(By.tagName("tspan")).getText();

                boolean first = value.startsWith(prefix);
                boolean last = value.endsWith(suffix);

                System.out.println("First : "+first);
                System.out.println("last : "+last);
                System.out.println("value : "+value);
                if(first && last ) {
                    //if( value.startsWith(prefix) && value.endsWith(suffix) ){

                    System.out.println("Prefix-Suffix: " +value);
                }
                else {
                    flag = false;
                    return flag;
                }
            }	//end of for loop
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validatePrefixSuffixY(driver,prefix,suffix);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE value!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }
    public static boolean validateTickColor(WebDriver driver,int index) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {
            System.out.println("Inside validateTickColor PP");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-y']")));

            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));

            int s=list.size();
            System.out.println("Ss list is : "+s);
//            String str = "stroke: rgb" +rgb.get(index-1);
            String str = "stroke: rgb" + rgb.get(index-1);
            System.out.println("strrr: "+str);

            for(int i=0; i< s;i++){

                String newstr=list.get(i).findElement(By.tagName("line")).getAttribute("style");
                System.out.println("newstr : "+newstr);

                if(newstr.contains(str)) {
                    System.out.println("TICCK-COLOR:" +newstr);
                }
                else {
                    flag = false;
                    return flag;
                }
            }//end of for loop
        }//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateTickColor(driver,index);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    public static boolean validateFontColor(WebDriver driver,int index) {

        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='c3-axis c3-axis-y']")));

            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y']")).findElements(By.cssSelector("g[class='tick']"));

            int s=list.size();
//            String str = "fill: rgb" +rgb.get(index-1);
            String str = "fill: rgb" + rgb.get(index-1);

            for(int i=0; i< s;i++){

                String newstr=list.get(i).findElement(By.tagName("text")).getAttribute("style");

                if(newstr.contains(str)) {
                    System.out.println("FONT-COLOR:" +str);
                }
                else {
                    flag = false;
                    return flag;
                }
            }//end of for loop
        }//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateFontColor(driver,index);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method



    public static boolean validateFontFamily(WebDriver driver,String  value) {
        int counter = 0;
        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()
        System.out.println("Inside validateFontFamily...");
        try {

            List<WebElement> list= driver.findElement(By.cssSelector("g[class='c3-axis c3-axis-y2']")).findElements(By.cssSelector("g[class='tick']"));

            int s=list.size();
            System.out.println("Size s fontFamilyy : "+s);
            String str="font-family: " +value+";";

            System.out.println("Str s: "+str);
            for(int i = 0; i < s;i++)
            {
                String newstr = list.get(i).findElement(By.tagName("text")).getAttribute("style");
                System.out.println("Newstrr : "+newstr);
                if(newstr.contains(str))
                {
                    System.out.println("PASS Font-Family values : "+value);
                }

                else {
                    flag = false;
                    return flag;
                }
            }
        }	//end of try block
        catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
            counter++;
            if (counter < 3) {
                validateFontFamily(driver,value);
            }
            else {
                System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
                flag = false;
                return flag;
            } //end of inner if-else
        } //end of catch block
        return flag;
    }	//end of method

    //Scripted Field
    public static boolean verifylogout(WebDriver driver) {
//        WebDriver driver = DriverFactory.getWebDriver()
        System.out.println("Verify end");
        //wait for 6second
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean flag = false;
        //path for text
        try {
            WebElement li = driver.findElement(By.cssSelector("div[id='login']")).findElement(By.cssSelector("span[id='invalidMCubeSpan']"));

            //get that text
            String textli= li.getText();
            System.out.println("Verify Text: "+textli);

            //verify
            if(textli.equals("You have successfully logged out of MCube")) {
                flag = true;
                System.out.println("Logged out from Mcube");
            }else {
                System.out.println("fail");
            }
        }
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;

        }
        return  flag;
    }

    public static boolean checkpagesize_twentyfive(WebDriver driver) {
//        WebDriver driver = DriverFactory.getWebDriver()
        boolean flag = false;
        try {
            WebElement li = driver.findElement(By.xpath("//indexed-fields//paginated-table//paginate//paginate-controls/form/div/select/option[2]"));
            String textli = li.getText();
            System.out.println("Page size is: "+textli);
            if(textli.equals("25")){
                flag = true;
                System.out.println("It is the page size");
            }else {
                System.out.println("It is not the page size");
            }

        }
        catch (Exception e) {
            e.toString();
            e.getMessage();
            return flag;

        }
        return flag;
    }
    public static boolean clickAdd(WebDriver driver,String value){

        boolean flag = true;
//        WebDriver driver = DriverFactory.getWebDriver()
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='sidebar-list']")));

            List<WebElement> list = driver.findElement(By.cssSelector("div[class='sidebar-list']")).findElement(By.cssSelector("ul[class='list-unstyled discover-unpopular-fields hidden-sm hidden-xs']")).findElements(By.tagName("li"));
            int size = list.size();
            System.out.println(size);
            for(int i = 1; i <size; i++) {

                String str=list.get(i).findElement(By.tagName("span")).getAttribute("textContent");
                str = str.trim();
                //println(str)

                if(value.equals(str)){

                    WebElement we = list.get(i);

                    Actions builder = new Actions(driver);

                    Action mouseOver = builder.moveToElement(we).build();

                    mouseOver.perform();

                    WebElement add=list.get(i).findElement(By.tagName("button"));

                    add.click();

                    break;
                }

                else{
                    System.out.println("continue");
                }
            }//end of for loop
        }	//end of try block
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;
        } //end of catch block
        return flag;
    }
    //end of method

    public static boolean verifyssname(WebDriver driver,String ssname) {
//        WebDriver driver = DriverFactory.getWebDriver()
        boolean flag = true;
        WebElement li = driver.findElement(By.cssSelector("div[class='localNavRow']"));//.findElement(By.cssSelector("div[class='breadcrumbconainer col-sm-4']"))//.findElement(By.cssSelector("li[id='KTNvisualization:New-Widget__2LabelID']"))
        String textli= li.getText();
        //WebElement lu = driver.findElement(By.xpath("//div[@class='breadcrumbconainer col-sm-4']/ol//li[4]"))
        String textlu = li.getText();
        System.out.println("SS"+ textli);
        if(textli.equalsIgnoreCase(textlu)) {
            flag = true;
            System.out.println("It is the save search's name");
        }
        else {
            System.out.println("It is not the save search's name ");
            flag = false;
        }

        return flag;

    }

    public static boolean verifywidgetname(WebDriver driver,String widgetname) {
//        WebDriver driver = DriverFactory.getWebDriver()
        boolean flag = true;
        try {
            WebElement li = driver.findElement(By.cssSelector("div[class='localNavRow']")).findElement(By.cssSelector("div[class='breadcrumbconainer col-sm-4']"));//.findElement(By.cssSelector("li[id='KTNvisualization:New-Widget__2LabelID']"))
            String textli= li.getText();
            WebElement lu = driver.findElement(By.xpath("//div[@class='breadcrumbconainer col-sm-4']/ol//li[4]"));
            String textlu = lu.getText();
            System.out.println("Area"+ textli);
            if(textlu.equalsIgnoreCase(widgetname)) {
                flag = true;
                System.out.println("It is the widget's name");}
            else {
                System.out.println("fail");
                flag = false;
            }

            return flag;

        }
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;

        }
    }

    public static boolean verifydashboardname(WebDriver driver,String dashname) {
//        WebDriver driver = DriverFactory.getWebDriver()
        boolean flag = true;
        try {
            WebElement li = driver.findElement(By.cssSelector("div[class='localNavRow']")).findElement(By.cssSelector("div[class='dashboardname ']"));//.findElement(By.cssSelector("span[id='KTNdashboard:dnBreadCrumbID']"))
            String textli= li.getText();
            System.out.println("ND"+ textli);
            if(textli.equalsIgnoreCase(dashname)) {
                flag = true;
                System.out.println("It is dashboard's name");}
            else {
                System.out.println("fail");
                flag = false;
            }

            return flag;

        }
        catch (Exception e) {
            e.toString();
            e.getMessage();
            flag = false;
            return flag;

        }
    }

    public static boolean validateDataLabels(WebDriver driver) {

        System.out.println("Inside validateDataLabels..");

//        WebDriver driver = DriverFactory.getWebDriver();
        int count = 0;
        boolean sFlag = true;

        try {

            List<WebElement> spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

            int spySize = spyData.size();
            System.out.println("Spy size : "+spySize);
            List<WebElement> dataLabels = driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='series 0']")).findElements(By.tagName("text"));

            int dataSize = dataLabels.size();
            System.out.println("data size : "+dataSize);
            for(int i = 0; i < dataSize; i++) {

                String tempD = dataLabels.get(i).getText();

                System.out.println("Data label: " + tempD);

                String tempSpy = spyData.get((i*2)+1).getText();

                System.out.println("Spy Data: " + tempSpy);

                if(tempD.equalsIgnoreCase(tempSpy)) {
                    count++;
                    System.out.println("i ------> : "+i);
                }
            }
            if(count != dataSize) {
                sFlag = false;
                return sFlag;
            }
        }
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }

    public static boolean validateChartFormation(WebDriver driver) {

        boolean height = true, sFlag = true;
        int count = 0;
        System.out.println("Inside validateChartFormation");
//        WebDriver driver = DriverFactory.getWebDriver();

        try {

            List<WebElement> rect= driver.findElement(By.cssSelector("div[class='chart']")).findElement(By.cssSelector("g[class='series 0']")).findElements(By.tagName("rect"));

            int size = rect.size();
            System.out.println("Size validateChartFormation : "+size);
            for(int i = 0; i < size; i++) {

                WebElement we = rect.get(i);

                String h = we.getAttribute("height");
                System.out.println("Height : "+h);
                if(h.equals("0")) {
                    count++;
                }
            }
            if(count == size) {
                sFlag = false;
                return sFlag;
            }
        }
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }

    public static boolean validateXAxisLabels(WebDriver driver) {

//        WebDriver driver = DriverFactory.getWebDriver();
        int count = 0;
        boolean sFlag = true;

        System.out.println("Inside validateXAxisLabels");
        try {
            List<WebElement> spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

            int spySize = spyData.size();
            System.out. println("SpySize validateXAxisLabels: "+spySize);
            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
            System.out.println("CLicked Spy inside validateXAxisLabels block");
            driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
            System.out.println("CLicked Spy inside validateXAxisLabels block2");
            List<WebElement> xaxisData = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));
            //.findElement(By.cssSelector("g[class='x-axis']"))
            int xaxisSize = xaxisData.size();
            System.out.println("xaxis size : "+xaxisSize);

            for(int i = 0; i < xaxisSize; i++) {

                String tempX = xaxisData.get(i).getText();

                System.out.println("X Tick: " + tempX);

                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                System.out.println("CLicked Spy inside validateXAxisLabels block3");
                driver.findElement(By.xpath("//i[@class='fa fa-chevron-circle-up' or @class='fa fa-chevron-circle-down']")).click();
                System.out.println("CLicked Spy inside validateXAxisLabels block4");

                spyData = driver.findElement(By.cssSelector("div[class='agg-table-paginated']")).findElement(By.tagName("tbody")).findElements(By.tagName("td"));

                String tempSpy = spyData.get(i*2).getText();

                System.out.println("Spy Data: " + tempSpy);

                boolean r = tempX.equalsIgnoreCase(tempSpy) || tempX.equalsIgnoreCase(tempSpy + "0") || tempX.equalsIgnoreCase(tempSpy + ".00");
                System.out.println("r : "+r);
                if(r) {
                    count++;
                }
            }
            if(count != xaxisSize) {
                sFlag = false;
                return sFlag;
            }
        }
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }

    public static boolean validateYTickFontColor(WebDriver driver,int index) {

        boolean sFlag=true;

//        String sActualColor =rgb.get(index-1);
        String sActualColor = rgb.get(index-1);

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div']")));
            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='y-axis-div']")).findElements(By.tagName("text"));
            //List<WebElement> weSvg = driver.findElement(By.className("y-axis-div")).findElements(By.tagName("text"))
            int listSize = weSvg.size();

            for (int iCount = 0; iCount < listSize; iCount++) {

                WebElement we = weSvg.get(iCount);

                String sText = we.getText();

                if (sText.equals("")) {

                    String sFontColor = we.getAttribute("style");

                    if(sFontColor.contains(sActualColor)) {
                        //System.out.println("The font color for Y-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font color for Y-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }
                }	//end of outer if
            }	//end of for loop
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block

        return sFlag;
    }	//end of keyword

    public static boolean validateYTitleFontColor(WebDriver driver,int index) {

        boolean sFlag=true;
        String sActualColor =rgb.get(index-1);

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div']")));
            WebElement weSvg = driver.findElement(By.cssSelector("div[class='y-axis-div']")).findElement(By.tagName("text"));
            String sText = weSvg.getText();
            if (sText.equals("")) {

                String sFontColor = weSvg.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //	System.out.println("The font color for Y-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for Y-Title: "+weSvg.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block

        return sFlag;
    }	//end of keyword


    public static boolean validateYAxisColor(WebDriver driver,int index) {

        boolean sFlag=true;
        String sActualColor =rgb.get(index-1);

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='y-axis-div']")));
            WebElement weSvg = driver.findElement(By.cssSelector("div[class='y-axis-div']")).findElement(By.cssSelector("path[class='domain']"));
            //WebElement we = driver.findElement(By.className("y-axis-div")).findElement(By.className("domain"))

            String sText = weSvg.getText();

            if (sText.equals("")) {

                String sFontColor = weSvg.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //System.out.println("The font color for Y-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for Y-Axis: "+weSvg.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block

        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }	//end of keyword

    public static boolean validateFontSizeXTick(WebDriver driver,String sExpectedFontValue) {


        String actualFont = sExpectedFontValue + "pt";
        boolean sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));

            int linkSize =  weSvg.size();

            for (int iCount = 0; iCount < linkSize; iCount++) {
                WebElement we = weSvg.get(iCount);

                String sText = we.getText();

                if (sText.equals("")) {
                    String sFont = we.getAttribute("style");
                    if(sFont.contains(actualFont)) {
                        //	System.out.println("The font size of X-axis ticks: "+we.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font size of X-axis ticks: "+we.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }   //End of inner if-else
                } //End of outer if
            }   //End of for loop
        }   //End of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }    //End of catch block
        return sFlag;
    }// End of keyword

    public static boolean validateXTickFontColor(WebDriver driver,int index) {

        boolean sFlag=true;
        String sActualColor =rgb.get(index-1);

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));

            int listSize = weSvg.size();
            for (int iCount = 0; iCount < listSize; iCount++) {

                WebElement we = weSvg.get(iCount);

                String sText = we.getText();

                if (sText.equals("")) {

                    String sFontColor = we.getAttribute("style");

                    if(sFontColor.contains(sActualColor)) {
                        //System.out.println("The font color for X-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The font color for X-Tick: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }
                }	//end of outer if
            }	//end of for loop
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block

        return sFlag;
    }	//end of keyword

    public static boolean validateFontSizeXTitle(WebDriver driver,String sExpectedFontValue) {


        String actualFont = sExpectedFontValue + "pt";
        boolean sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            WebElement weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElement(By.tagName("text"));

            String sText = weSvg.getText();

            if (sText.equals("")) {
                String sFont = weSvg.getAttribute("style");
                if(sFont.contains(actualFont)) {
                    //System.out.println("The font size of X-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font size of X-axis title: "+weSvg.getText()+" is "+sExpectedFontValue+"--------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;

                }   //End of inner if-else
            }   //End of outer if
        } //End of try block

        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        } //End of catch clock
        return sFlag;
    } //End of keyword

    public static boolean validateXAxisColor(WebDriver driver,int index) {

        boolean sFlag=true;
        String sActualColor =rgb.get(index-1);

//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            WebElement weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElement(By.cssSelector("path[class='domain']"));

            String sText = weSvg.getText();

            if (sText.equals("")) {

                String sFontColor = weSvg.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //System.out.println("The font color for X-Axis: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for X-Axis: "+sText+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block

        return sFlag;
    }	//end of keyword
    public static boolean validateXTitleFontColor(WebDriver driver,int index) {

        boolean sFlag=true;
        String sActualColor =rgb.get(index-1);
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            WebElement weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElement(By.tagName("text"));

            String sText = weSvg.getText();

            if (sText.equals("")) {

                String sFontColor = weSvg.getAttribute("style");

                if(sFontColor.contains(sActualColor)) {
                    //System.out.println("The font color for X-Title: "+we.getText()+" is "+sFontColor+" ------> TEST CASE IS PASSED");
                }
                else {
                    System.out.println("The font color for X-Title: "+weSvg.getText()+" is "+sFontColor+" ------> TEST CASE IS FAILED");
                    sFlag = false;
                    return sFlag;
                }
            }	//end of outer if
        }	//end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }	//end of catch block
        return sFlag;
    }	//end of keyword
    public static boolean validatePrefixXTick(WebDriver driver,String sExpectedPrefix) {

        boolean sFlag=true;
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));

            int listSize = weSvg.size();

            for (int iCount = 1; iCount < listSize; iCount++) {

                WebElement we = weSvg.get(iCount);
                String Xaxis_labels= we.getText();

                if (Xaxis_labels.equals("")) {
                    if(Xaxis_labels.startsWith(sExpectedPrefix)) {
                        //	System.out.println("The prefix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The prefix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedPrefix+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }	//end of inner if-else
                }	//end of outer if
            }   //end of for loop
        }   //end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }   //end of catch block
        return sFlag;
    }  //end of method

    public static boolean validateSuffixXTick(WebDriver driver,String sExpectedSuffix) {

        boolean    sFlag  = true;
//        WebDriver driver  = DriverFactory.getWebDriver()

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='x-axis-div']")));
            List<WebElement> weSvg = driver.findElement(By.cssSelector("div[class='x-axis-div']")).findElements(By.tagName("text"));

            int listSize = weSvg.size();

            for (int iCount = 1; iCount < listSize; iCount++) {

                WebElement we = weSvg.get(iCount);
                String Xaxis_labels= we.getText();

                if (Xaxis_labels.equals("")) {
                    if(Xaxis_labels.endsWith(sExpectedSuffix)) {
                        //	System.out.println("The suffix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS PASSED");
                    }
                    else {
                        System.out.println("The suffix for X-axis ticks: "+Xaxis_labels+" is "+sExpectedSuffix+"--------> TEST CASE IS FAILED");
                        sFlag = false;
                        return sFlag;
                    }   //end of inner if-else
                }    //end of outer if
            }    //end of for loop
        }    //end of try block
        catch (Exception ex) {
            System.out.println("STALE ELEMENT REFERENCE MORE THAN TWICE!!");
            sFlag = false;
            return sFlag;
        }    //end of catch block
        return sFlag;
    }// end of method


    public static void waitForPageLoad(WebDriver driver) {
    }
}
