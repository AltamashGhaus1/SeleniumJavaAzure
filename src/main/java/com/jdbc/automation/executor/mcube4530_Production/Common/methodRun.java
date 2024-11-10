package com.jdbc.automation.executor.mcube4530_Production.Common;

import com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity.AACloneConcurrency;
import com.jdbc.dao.ClientVersionDao;

public class methodRun extends Thread{

    public String url,username,password,dataset,mailto,createdBy,createdByName,client,version;
    ClientVersionDao clientVersionDao;
    int san_aut_id,rows;
    AACloneConcurrency obj;
    public methodRun(String url, String username, String password, String dataset, String mailto, String createdBy, String createdByName, String client, String version, ClientVersionDao clientVersionDao, int san_aut_id, int rows)
    {
        super();
        //obj = new McubeSanity_4530_Production();
        obj = new AACloneConcurrency();
        this.url=url;
        this.username=username;
        this.password=password;
        this.dataset=dataset;
        this.mailto=mailto;
        this.createdBy=createdBy;
        this.createdByName=createdByName;
        this.client=client;
        this.version=version;
        this.clientVersionDao=clientVersionDao;
        this.san_aut_id=san_aut_id;
        this.rows=rows;
    }

    @Override
    public void run()
    {
        try {
            obj.executeAutomation(this.url, this.username, this.password, this.dataset, this.mailto, this.createdBy, this.createdByName, this.client, this.version,this.clientVersionDao,this.san_aut_id,this.rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
