//package com.jdbc.controllers;
//
//import com.jdbc.service.BlobService;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class BlobController {
//
//    @Autowired
//    private BlobService blobService;
//
//    @RequestMapping(value = "/downloadBlob", method = RequestMethod.POST)
//    public ResponseEntity<ByteArrayResource> downloadBlob(@RequestBody String data) throws Exception {
//
//        JSONObject jsonObject = new JSONObject(data);
//        String creatorMail = jsonObject.getString("creatorMail");
//
//        byte[] blobData = blobService.getBlobData(creatorMail);
//        ByteArrayResource resource = new ByteArrayResource(blobData);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=blob.txt")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .contentLength(blobData.length)
//                .body(resource);
//    }
//}
