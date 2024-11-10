package com.jdbc.automation.executor.mcube4530_Production.Common;

import com.jdbc.dao.ClientVersionDao;
import jxl.write.Label;

import java.io.File;
import java.sql.Timestamp;

import static com.jdbc.automation.executor.mcube4530_Production.com.mcube.qa.sanity.McubeSanity_4530_Production.fileName;

public class MakeNewWFThreads {

    public static File main(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id) throws InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        String timedate = timestamp.toString();

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //List<String> listUsers = Arrays.asList("admin","whoami","rohan");
        //List<String> listUsers = Arrays.asList("user1","user2","user3");
        //List<String> listUsers = Arrays.asList("admin");

        //Thread t1 = new methodRun(url, username, password, dataset, mailto, createdBy, createdByName, client, version,clientVersionDao,san_aut_id);
        //Thread t2 = new methodRun(url, username, password, dataset, mailto, createdBy, createdByName, client, version,clientVersionDao,san_aut_id);
        SeleniumUtils.setBlankInExcelForHeader(fileName);

        /*SeleniumUtils.setBlankInExcelForRows(rows,fileName);
        WriteData.setData(fileName,0,new Label(0,rows,threadCount));
        WriteData.setData(fileName,0,new Label(1,rows,username));*/

        Label l_url = new Label(1,0,url);
        Label l_createdBy = new Label(1,1,createdByName);
        Label l_client = new Label(1,2,client);
        Label l_timestamp = new Label(1,3,timedate);

        WriteData.setData(fileName,0,l_url);
        WriteData.setData(fileName,0,l_createdBy);
        WriteData.setData(fileName,0,l_client);
        WriteData.setData(fileName,0,l_timestamp);

        int rows=5;
        Thread t1;
        for(int i=1;i<=30;i++)
        {
            String threadCount = String.valueOf(i);
            //username = listUsers.get(i-1);
            //username = "user"+i;

            t1= new methodRun(url, username, password, dataset, mailto, createdBy, createdByName, client, version,clientVersionDao,san_aut_id,rows);
            //WriteData.setData("D://output.xls",0,new Label(0,rows,threadCount));
           /* SeleniumUtils.setBlankInExcelForRows(rows,fileName);
            WriteData.setData(fileName,0,new Label(0,rows,threadCount));
            WriteData.setData(fileName,0,new Label(1,rows,username));*/
            rows=rows+1;
            t1.start();
            Thread.sleep(3000);
            System.out.println("Thread :"+i+" is created and initialised with user id :"+username);
        }

        return null;
    }
}
