package com.jdbc.service;

import com.jdbc.dao.ClientVersionDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class BlobServiceImpl {

    @Autowired
    ClientVersionDao clientVersionDao;
    //public byte[] getBlobData(String creatorMail) {
    public boolean getBlobData(String idBlob, String creatorTime) {
        // Implement logic to retrieve blob data (e.g., from a database)
        // Replace this with your actual implementation
        File reportFile = null;

        ArrayList<JSONObject> reportListBlob = new ArrayList<JSONObject>();
        //JSONObject jsobObj = new JSONObject();
        //reportListBlob = clientVersionDao.getReportBlob(creatorMail);
        return clientVersionDao.getReportBlob(idBlob,creatorTime);
        //jsobObj.put("reportDetails",   reportListBlob);
//        master_id = jsobObj.getInt("master_id");
//        idd = jsobObj.getInt("idd");
//        System.out.println("idd final : "+idd+" and master id final : "+master_id);

        //System.out.println("ag_name" + jsobObj);

        //return jsobObj.get(0).getBytes();

        //return "This is a sample blob content.".getBytes();
    }

    public byte[] getBlobDataGet(int idBlob) {
        // Implement logic to retrieve blob data (e.g., from a database)
        // Replace this with your actual implementation
        File reportFile = null;

        ArrayList<JSONObject> reportListBlob = new ArrayList<JSONObject>();
        //JSONObject jsobObj = new JSONObject();
        //reportListBlob = clientVersionDao.getReportBlob(creatorMail);
        return clientVersionDao.getReportBlobGet(idBlob);
        //jsobObj.put("reportDetails",   reportListBlob);
//        master_id = jsobObj.getInt("master_id");
//        idd = jsobObj.getInt("idd");
//        System.out.println("idd final : "+idd+" and master id final : "+master_id);

        //System.out.println("ag_name" + jsobObj);

        //return jsobObj.get(0).getBytes();

        //return "This is a sample blob content.".getBytes();
    }
}
