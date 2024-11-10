package com.jdbc.automation.executor.AA_Clone_70_Users.Common;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class SetData {

    public static void setData(String fileName9, int sheetIndex, Label label){
        /******Defining XL to update Regression Report *********/
        Workbook wBook9 = null;
        try{
            wBook9 = Workbook.getWorkbook(new File(fileName9));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        WritableWorkbook wbook10 = null;
        WritableSheet sheet10 = null;
        try{
            try{
                File out = new File(fileName9);
                wbook10 = Workbook.createWorkbook(out, wBook9);
                try{
                    sheet10 = wbook10.getSheet(sheetIndex);
                    sheet10.addCell(label);
                    wbook10.write();
                    wbook10.close();
                    System.out.println("File Closed");

                }
                catch (Exception e){
                    wbook10.close();
                    e.printStackTrace();;
                    System.out.println("File Closed Exception");
                }
            }
            catch (Exception e){
                wbook10.close();
                System.out.println("File Closed Exception");
                e.printStackTrace();

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        /********* End of Defining XL to Update Regression Report ***********/

        /********* Write Data *********/

        System.out.println("Write sucessfull");

    }

}
