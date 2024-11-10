package com.jdbc.automation.executor.mcube4530_Production.Common;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class WriteData {
    public static boolean setData(String fileName9, int sheetIndex, Label label) {
        Workbook wBook9 = null;

        try {
            wBook9 = Workbook.getWorkbook(new File(fileName9));
        } catch (Exception e) {
            e.printStackTrace();
        }

        WritableWorkbook wbook10 = null;
        WritableSheet sheet10 = null;

        try {
            File out = new File(fileName9);
            wbook10 = Workbook.createWorkbook(out,wBook9);
            try {
                sheet10 = wbook10.getSheet(sheetIndex);
                sheet10.addCell(label);
                wbook10.write();
                //wbook10.close();
                System.out.println("File not closed");
            } catch (Exception e) {
                //wbook10.close();
                e.printStackTrace();
                System.out.println("File not closed Exception 1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Write successfull");
        return true;
    }
}
