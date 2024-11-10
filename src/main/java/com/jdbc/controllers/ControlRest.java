package com.jdbc.controllers;

import com.jdbc.service.BlobServiceImpl;
import com.jdbc.service.SanityService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlRest {

	// GET JSON with return type string

	@Autowired
	SanityService sanityService;
	@Autowired
	private BlobServiceImpl blobServiceImpl;

	@RequestMapping(value = "/mailids", method = RequestMethod.POST)
	public String getMail(@RequestBody String data) {

		// print json received

		System.out.println("Data : " + data);

		/*
		 * String clients[] = {"TAGIC", "CIGNA", "LVA", "NOVOLIN"}; String
		 * objectToReturn = "{ key1: 'value1', key2: 'value2' }";
		 */

		JSONObject jsonObject = new JSONObject(data);
		jsonObject.put("url", "https://mcubeqa4500.tcgdigital.com/nxtgen");
		jsonObject.put("name", "admin");
		jsonObject.put("password", "Mcube@123!");
		jsonObject.put("dataset", "supstore");
		System.out.println(jsonObject.toString());

		//System.out.println(jsonObject.getString("mailrecCore"));

		return jsonObject.toString();

	}

	@RequestMapping(value = "/course")
	public String getCourse() {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("url", "https://mcubeqa4500.tcgdigital.com/nxtgen");
		jsonObj.put("name", "admin");
		jsonObj.put("password", "Mcube@123!");
		jsonObj.put("dataset", "supstore");
		jsonObj.put("mailto", "altamash.ghaus@tcgdigital.com");

		return jsonObj.toString();

	}


	@RequestMapping(value = "/clientoption")
	public String getClients() {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("url", "https://mcubeqa4500.tcgdigital.com/nxtgen");
		jsonObj.put("name", "admin");
		jsonObj.put("password", "Mcube@123!");
		jsonObj.put("dataset", "supstore");
		jsonObj.put("mailto", "altamash.ghaus@tcgdigital.com");

		return jsonObj.toString();

	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getClient() {
		System.out.println("Inside Client");
		return sanityService.getClients().toString(); // select distinct client from client_version where client not in('MCUBE','LVA')
	}

	@RequestMapping(value = "/features", method = RequestMethod.GET)
	public String getFeatures() {
		System.out.println("Inside Features");
		return sanityService.getFeatures().toString(); // select distinct client from client_version where client not in('MCUBE','LVA')
	}

	@RequestMapping(value = "/regressions", method = RequestMethod.GET)
	public String getRegressions() {
		System.out.println("Inside Regressions");
		return sanityService.getRegressions().toString(); // select distinct client from client_version where client not in('MCUBE','LVA')
	}

	@RequestMapping(value = "/versions", method = RequestMethod.GET)
	public String getVersion(@RequestParam String client) {
		System.out.println("Inside Version: "+client); // MCUBE, LVA, TAGIC is client

		return sanityService.getVersions(client).toString(); // returns id and versions from client_version table
	}

	@RequestMapping(value = "/versionDetails", method = RequestMethod.GET)
	public String getVersionDetails(@RequestParam int versionId) {
		System.out.println("Inside Version Details: "+versionId);


		JSONObject jsonArr = new JSONObject();
		jsonArr=sanityService.getVersionDetails(versionId);


		return jsonArr.toString(); // url,username,password,dataset,mailto from sanity_details will be returned as JSON Object
	}



	/*@RequestMapping(value = "/setVersionDetails", method = RequestMethod.POST)*/
	/*public String setVersionDetails(@RequestParam String url,@RequestParam String username,@RequestParam String password,
									@RequestParam String dataset,@RequestParam String mailto) {*/
	@RequestMapping(value = "/setVersionDetails", method = RequestMethod.POST)
	public String setVersionDetails(@RequestBody String data) throws Exception {

		String version = "";
		System.out.println("Data inside setVersionDetails: " + data);

		JSONObject jsonObject = new JSONObject(data);

		String url = jsonObject.getString("url");
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String dataset = jsonObject.getString("dataset");
		String mailrec = jsonObject.getString("mailrec");

		String client = jsonObject.getString("client");
		if(!client.equalsIgnoreCase("custom"))
		{
			version = jsonObject.getString("version");
			System.out.println("version of custom : "+version);
		}
		else {
			version = "";
			System.out.println("AG version of custom : "+version);
		}

		String createdBy = jsonObject.has("createdBy")?jsonObject.getString("createdBy"):"NA"; // Ternary Operation
		String createdByName = jsonObject.has("createdByName")?jsonObject.getString("createdByName"):"NA";
		int sanityDetailsId = jsonObject.getInt("sanityDetailsId");

		jsonObject=sanityService.setVersionDetails(url,
				username,password,
				dataset, mailrec,client,version,createdBy,sanityDetailsId,createdByName);
		//INSERT INTO sanity_automation_master " + "(url, username, password, dataset, mailto, sanity_details_id,hash,CREATED_BY,REPORT,CREATOR)

		System.out.println(jsonObject.toString());

		return jsonObject.toString();

	}

	@RequestMapping(value = "/getPercentage", method = RequestMethod.POST)
	public int getPercentage(@RequestBody String data) throws Exception {

		System.out.println("Inside getPercentage");
		System.out.println("Data : " + data);

		JSONObject jsonObject = new JSONObject(data);

		String creator_name = jsonObject.getString("creator");

		return sanityService.getPercentage(creator_name);
	}

	@RequestMapping(value = "/repIds", method = RequestMethod.POST)
	public String getReportDetails(@RequestBody String data) throws Exception {

		JSONObject jsonObject = new JSONObject(data);
		String creatorMail = jsonObject.getString("creatorMail");
//
		jsonObject=sanityService.getReportDetails(creatorMail);
		//INSERT INTO sanity_automation_master " + "(url, username, password, dataset, mailto, sanity_details_id,hash,CREATED_BY,REPORT,CREATOR)

		//System.out.println(jsonObject.toString());

		return jsonObject.toString();

	}
	@RequestMapping(value = "/clientinfoDetails", method = RequestMethod.POST)
	public String getClientinfoDetails(@RequestBody String data) throws Exception {

		JSONObject clientDetails = new JSONObject(data);
		String clientName = clientDetails.getString("clientName");
		String clientVer = clientDetails.getString("clientVer");
		System.out.println("clientInfo is : "+clientName);
//
		clientDetails = sanityService.getClientDetails(clientName,clientVer);
		System.out.println("ClientDetails is : "+clientDetails);
		//INSERT INTO sanity_automation_master " + "(url, username, password, dataset, mailto, sanity_details_id,hash,CREATED_BY,REPORT,CREATOR)

		//System.out.println(jsonObject.toString());

		//return jsonObject.toString();
		return clientDetails.toString();

	}

	@RequestMapping(value = "/downloadBlobPost", method = RequestMethod.POST)
	public boolean downloadBlobPost(@RequestBody String data) throws Exception {
		//public ResponseEntity<ByteArrayResource> downloadBlob(@RequestBody String data) throws Exception {

		JSONObject jsonObject = new JSONObject(data);
		System.out.println("JSON Object :: "+jsonObject);

//		String creatorMail = jsonObject.getString("creatorMail");
		String idBlob = jsonObject.getString("idBlob");
		String creatorTime = jsonObject.getString("creatorTime");


		//byte[] blobData = blobService.getBlobData(creatorMail);
		return blobServiceImpl.getBlobData(idBlob,creatorTime);

//		ByteArrayResource resource = new ByteArrayResource(blobData);
//
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=blob.txt")
//				.contentType(MediaType.APPLICATION_OCTET_STREAM)
//				.contentLength(blobData.length)
//				.body(resource);
	}


	@RequestMapping(value = "/downloadBlob", method = RequestMethod.GET)
	public byte[] downloadBlob(@RequestParam int repId)  {
		//public ResponseEntity<ByteArrayResource> downloadBlob(@RequestBody String data) throws Exception {

		System.out.println("Param id  :: "+repId);
		return blobServiceImpl.getBlobDataGet(repId);

//		ByteArrayResource resource = new ByteArrayResource(blobData);
//
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=blob.txt")
//				.contentType(MediaType.APPLICATION_OCTET_STREAM)
//				.contentLength(blobData.length)
//				.body(resource);
	}


	@RequestMapping(value = "/repIdsAll", method = RequestMethod.GET)
	public String getReportDetailsAll() throws Exception {

		JSONObject jsonObject = new JSONObject();

		jsonObject=sanityService.getReportDetailsAll();

		return jsonObject.toString();

	}

}
