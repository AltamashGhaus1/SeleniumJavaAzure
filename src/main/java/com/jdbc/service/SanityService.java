package com.jdbc.service;

import com.jdbc.automation.executor.AA_Clone_70_Users.Common.MakeCloneThreads;
import com.jdbc.automation.executor.AA_Clone_70_Users.Common.MakeNewWFThreads;
import com.jdbc.automation.executor.AA_Clone_70_Users.com.mcube.qa.sanity.AACloneConcurrency;
import com.jdbc.automation.executor.ad4300.com.mcube.qa.sanity.ADSanity4_3;
import com.jdbc.automation.executor.cigna.com.mcube.qa.sanity.CignaSanity4_0;
import com.jdbc.automation.executor.ipds.com.mcube.qa.sanity.IpdsSanity3_2;
import com.jdbc.automation.executor.lummus4300.com.mcube.qa.sanity.Lummus4_3;
import com.jdbc.automation.executor.maxfed4200.com.mcube.qa.sanity.MaxFedSanity_4200;
import com.jdbc.automation.executor.mcube4500.com.mcube.qa.sanity.McubeSanity_4500;
import com.jdbc.automation.executor.mcube4510.com.mcube.qa.sanity.McubeSanity_4510;
import com.jdbc.automation.executor.mcube4520.com.mcube.qa.sanity.McubeSanity_4520;
import com.jdbc.automation.executor.mcube4530.com.mcube.qa.sanity.McubeSanity_4530;
import com.jdbc.automation.executor.mcube4540.com.mcube.qa.sanity.McubeSanity_4540;
import com.jdbc.automation.executor.mcube4550.com.mcube.qa.sanity.McubeSanity_4550;
import com.jdbc.automation.executor.mcube510.com.mcube.qa.sanity.McubeSanity_510;
import com.jdbc.automation.executor.mdi4531.com.mcube.qa.sanity.MdiSanity_4531;
import com.jdbc.dao.ClientVersionDao;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class SanityService {

    @Autowired
    ClientVersionDao clientVersionDao;

    public int master_id;
    public int idd;
    public JSONArray getClients(){
        return clientVersionDao.getClients();
    }
    public JSONArray getFeatures(){
        return clientVersionDao.getFeatures();
    }
    public JSONArray getRegressions(){
        return clientVersionDao.getRegressions();
    }

    public JSONArray getVersions(String client) {
        return clientVersionDao.getVersions(client);
    }

    public int getPercentage(String creator_name) {
        return clientVersionDao.getPercent(creator_name);
    }
    public JSONObject getVersionDetails(int versionId) {
        return clientVersionDao.getVersionDetails(versionId);
    }

    public JSONObject setVersionDetails(String url, String username, String password, String dataset, String mailto, String client, String version, String createdBy, int sanityDetailsId, String createdByName) throws Exception {

        System.out.println("Client AG : "+client);
        File reportFile=null;

        JSONObject jObj = new JSONObject();
        jObj= clientVersionDao.setVersionDetails(url, username, password, dataset, mailto, createdBy, sanityDetailsId, reportFile, createdByName,"EXECUTING");
        master_id = jObj.getInt("master_id");
        idd = jObj.getInt("idd");
        System.out.println("idd final : "+idd+" and master id final : "+master_id);


        if(client.equalsIgnoreCase("MCUBE")){
            if(version.equalsIgnoreCase("4.3.0.0")){
                //execute automation
            }else if(version.equalsIgnoreCase("4.5.0.0")){
                    //reportFile= McubeSanity_4500.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version);
            }
        }else if(client.equalsIgnoreCase("LVA")){
            if(version.equalsIgnoreCase("4.0.1.0")){
                //execute automation
            }else if(version.equalsIgnoreCase("4.1.0.0")){
                //execute automation
            }
        }else if(client.equalsIgnoreCase("TAGIC")){
            if(version.equalsIgnoreCase("3.2.0.0")){
                //execute automation
            }else if(version.equalsIgnoreCase("4.3.0.0")){
               //JSON obj to receive id from HAsh data
                //clientVersionDao.setVersionDetails(url,username,password,dataset,mailto,createdBy,sanityDetailsId,null,createdByName,"EXECUTING");
                reportFile= ADSanity4_3.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
        }else if(client.equalsIgnoreCase("CIGNA")){
            if(version.equalsIgnoreCase("4.0.0.0")){
                //execute automationreportFile= CignaSanity4_0.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);

            }
        }
        else if(client.equalsIgnoreCase("LUMMUS")){
            if(version.equalsIgnoreCase("4.3.0.0")){
                //execute automation
                reportFile= Lummus4_3.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);

            }
        }
        else if(client.equalsIgnoreCase("IPDS")){
            if(version.equalsIgnoreCase("3.2.0.0")){
                reportFile=IpdsSanity3_2.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
        }
        else if(client.equalsIgnoreCase("CUSTOM")){
            if(url.equalsIgnoreCase("https://mcubeinqa454.tcgdigital.com/nxtgen")) {
                McubeSanity_4540.executeAutomation(url, username, password, dataset, mailto, createdBy, createdByName, client, version, clientVersionDao, idd);
            } else if (url.equalsIgnoreCase("https://mcubeinqa455.tcgdigital.com/nxtgen")) {
                reportFile= McubeSanity_4550.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }else if (url.equalsIgnoreCase("https://mcubetagic_ipds.tcgdigital.com/tagic")) {
                reportFile=IpdsSanity3_2.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            } else if (url.equalsIgnoreCase("https://tagicqa4300.tcgdigital.com/nxtgen")) {
                reportFile= ADSanity4_3.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            } else if (url.equalsIgnoreCase("https://cignamcubeqa.tcgdigital.com/nxtgen")) {
                reportFile= CignaSanity4_0.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }else if (url.equalsIgnoreCase("https://fedramp124.tcgdigital.com/nxtgen")) {
                reportFile= MaxFedSanity_4200.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }else if (url.equalsIgnoreCase("https://ldtrainingqa.tcgdigital.com/nxtgen")) {
                reportFile= Lummus4_3.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
        }
        else if(client.equalsIgnoreCase("CTEC")){
            if(version.equalsIgnoreCase("AI concurrent workflow automation")){
                reportFile= MakeNewWFThreads.main(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("AI clone workflow automation")) {
                //reportFile= McubeSanity_4530_Production.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
                reportFile= MakeCloneThreads.main(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
        }
        else if(client.equalsIgnoreCase("CORE")){
            if(version.equalsIgnoreCase("4.3.0.0")){

                } else if (version.equalsIgnoreCase("4.5.0.0")) {
                reportFile= McubeSanity_4500.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("4.5.1.0")) {
                reportFile= McubeSanity_4510.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("4.5.2.0")) {
                //JSON obj to receive id from HAsh data

                /*JSONObject jObj = new JSONObject();
                jObj= clientVersionDao.setVersionDetails(url, username, password, dataset, mailto, createdBy, sanityDetailsId, reportFile, createdByName,"EXECUTING");
                master_id = jObj.getInt("master_id");
                idd = jObj.getInt("idd");
                System.out.println("idd final : "+idd+" and master id final : "+master_id);*/
                //int idd= jObj.getInt(String.valueOf(id));
                reportFile= McubeSanity_4520.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("4.5.3.0")) {
                reportFile= McubeSanity_4530.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("4.5.4.0")) {
                reportFile= McubeSanity_4540.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("4.5.5.0")) {
                reportFile= McubeSanity_4550.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("5.1.0.0")) {
                reportFile= McubeSanity_510.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("MDI_4531")) {
                reportFile= MdiSanity_4531.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("AI 20 important templates")) {
                //reportFile= makeThreads.main(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
                reportFile= AACloneConcurrency.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd,0);
            }
            else if(version.equalsIgnoreCase("AI concurrent workflow automation")){
                reportFile= MakeNewWFThreads.main(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
            else if (version.equalsIgnoreCase("AI clone workflow automation")) {
                //reportFile= McubeSanity_4530_Production.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
                reportFile= MakeCloneThreads.main(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
        }
        else if(client.equalsIgnoreCase("INSTALLER")){
            if (version.equalsIgnoreCase("4.2.0.0")) {
                reportFile= MaxFedSanity_4200.executeAutomation(url,username,password,dataset,mailto,createdBy,createdByName,client,version,clientVersionDao,idd);
            }
        }


        // update report file, STATUS based on id -> Update Status column as FINISHED
        System.out.println("Completing updateVersionDetails | Moving to updateVersionDetails for returning to Console");

        //Update in sanity_automation_master table -> Update only pdf report and status from executing to finished
        return clientVersionDao.updateVersionDetails(idd,reportFile, "FINISHEDD");

        //How to return version detail to the calling Controller as url,etc are required to be printed in console of UI
        //return clientVersionDao.setVersionDetails(url,username,password,dataset,mailto,createdBy,sanityDetailsId,reportFile,createdByName,"FINISHED");


    }

    public JSONObject getReportDetails(String creatorMail) throws Exception {

        File reportFile = null;

        ArrayList<JSONObject> reportList = new ArrayList<JSONObject>();
        JSONObject jsobObj = new JSONObject();
        reportList = clientVersionDao.getReportDetails(creatorMail);
        jsobObj.put("reportDetails", reportList);
//        master_id = jsobObj.getInt("master_id");
//        idd = jsobObj.getInt("idd");
//        System.out.println("idd final : "+idd+" and master id final : "+master_id);

        //System.out.println("ag_name" + jsobObj);

        return jsobObj;
    }
    public JSONObject getClientDetails(String clientName,String clientVer) throws Exception {

        File reportFile = null;

//        ArrayList<JSONObject> reportList = new ArrayList<JSONObject>();
        JSONObject clientDetails = new JSONObject();
//        String clientDetails = clientVersionDao.getReportDetails(clientInfo);
        clientDetails = clientVersionDao.clientInfoDetails(clientName,clientVer);

        //jsobObj.put("reportDetails", reportList);
//        master_id = jsobObj.getInt("master_id");
//        idd = jsobObj.getInt("idd");
//        System.out.println("idd final : "+idd+" and master id final : "+master_id);

        System.out.println("ag_clientDetails : " + clientDetails);

        return clientDetails;
    }

    public JSONObject getReportDetailsAll() {
        File reportFile = null;

        ArrayList<JSONObject> reportList = new ArrayList<JSONObject>();
        JSONObject jsobObj = new JSONObject();
        reportList = clientVersionDao.getReportDetailsAll();
        jsobObj.put("reportDetails", reportList);
        //System.out.println("ag_name" + jsobObj);

        return jsobObj;
    }

//    public JSONObject getClientDetailsNew(String clientName, String clientVer) {
//        File reportFile = null;
//
////        ArrayList<JSONObject> reportList = new ArrayList<JSONObject>();
//        JSONObject clientDetails = new JSONObject();
////        String clientDetails = clientVersionDao.getReportDetails(clientInfo);
//        clientDetails = clientVersionDao.clientInfoDetailsNew(clientName,clientVer);
//
//        //jsobObj.put("reportDetails", reportList);
////        master_id = jsobObj.getInt("master_id");
////        idd = jsobObj.getInt("idd");
////        System.out.println("idd final : "+idd+" and master id final : "+master_id);
//
//        System.out.println("ag_clientDetails : " + clientDetails);
//
//        return clientDetails;
//    }
}
