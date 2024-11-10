package com.jdbc.automation.executor.AA_Clone_70_Users.Common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FetchData {
    public static String fetch_Data(WebDriver driver, WebDriverWait wait, int rowIndex, int columnIndex) throws InterruptedException, IOException, IOException {

        System.out.println("Fetching Values..in output.xls");
        File file = new File("D:\\Gurukul_test\\output.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);
        String data = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
        System.out.println("Data: "+data);
        System.out.println("Done fetching..in output.xls");
        return data;
    }
}
