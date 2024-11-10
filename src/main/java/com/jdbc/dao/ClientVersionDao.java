package com.jdbc.dao;

import com.automation.SanityDataRest.model.Detail;
import com.jdbc.automation.executor.Common.Records;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

@Repository
public class ClientVersionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public  JSONObject clientInfoDetails(String clientName, String clientVer) {

		JSONObject jsonObject=new JSONObject();
		Connection con=null;
		System.out.println("clientName inside clientInfoDetails page : "+clientName);

		try{

			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT product_information from sanity_selenium.product_info where product_name=? and product_version=?");

			ps.setString(1,clientName);
			ps.setString(2,clientVer);

			ResultSet rs=ps.executeQuery();
			System.out.println("clientName---"+clientName);
			System.out.println("clientVer---"+clientVer);

			while(rs.next()){


				jsonObject.put("product_info",rs.getString("product_information"));


			}
			System.out.println("jsonobject---"+jsonObject);
			//System.out.println(reportDetails.get(0));

		}catch (Exception e){
			e.printStackTrace();
//			reportDetails=new JSONObject();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObject;

	}

	public JSONObject setVersionDetails(String url, String username, String password, String dataset, String mailto, String createdBy, int sanityDetailsId, File reportFile, String createdByName, String STATUS)
	{
		JSONObject insertStatus=new JSONObject();

		//---------------------
		Connection con=null;
		InputStream is = null;
		JSONObject versionDetails=new JSONObject();

		try{

			con=jdbcTemplate.getDataSource().getConnection();
			String sql = "INSERT INTO sanity_automation_master " + "(url, username, password, dataset, mailto, sanity_details_id,hash,CREATED_BY,REPORT,CREATOR,STATUS) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps= con.prepareStatement(sql);
			String hash= Calendar.getInstance().getTimeInMillis()+"";


			ps.setString(1,url);
			ps.setString(2,username);
			ps.setString(3,password);
			ps.setString(4,dataset);
			ps.setString(5,mailto);
			ps.setInt(6,sanityDetailsId);
			ps.setString(7,hash);
			ps.setString(8,createdBy);
			if(null!=reportFile){
				is = new FileInputStream(reportFile);
				ps.setBlob(9,is);
			}else{
				ps.setNull(9, Types.BLOB);
			}
			ps.setString(10,createdByName);
			ps.setString(11,STATUS);

			//ResultSet rs=ps.executeQuery();
			int rs=ps.executeUpdate();
			System.out.println("rs : "+rs);

//			if(rs.next()){
			if(rs==1){
				versionDetails.put("status", "pass");
				//id = DB call to fetch id from hash -> and put in json obj. (prepared statement)
				//versionDetails.put("id", "23");
				versionDetails.put("master_id", getMasterIdViaHash(hash));
				versionDetails.put("idd",getIdViaHash(hash));
			}
			else{
				versionDetails.put("status", "fail");
			}

		}catch (Exception e){
			e.printStackTrace();
			versionDetails=new JSONObject();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(null!=is){
				try {
					is.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		return versionDetails;
	}

//Joins -> inner,outer,self cross
//Delete from bottom, top via % and values

	public JSONObject updateVersionDetails(int idd,File reportFile, String STATUS)
	{
		//url,username,password,dataset,mailto,createdBy,sanityDetailsId,reportFile,createdByName,
		//idd is 243/244/235 sanity_autonation_master_id of sanity_automation_details table
		JSONObject insertStatus=new JSONObject();

		//---------------------
		Connection con=null;
		InputStream is = null;
		JSONObject versionDetails=new JSONObject();

		try{

			con=jdbcTemplate.getDataSource().getConnection();
			String sql = "UPDATE sanity_automation_master set STATUS = ?, REPORT = ? where id = ?";

			PreparedStatement ps= con.prepareStatement(sql);

			ps.setString(1,STATUS);

			if(null!=reportFile){
				is = new FileInputStream(reportFile);
				ps.setBlob(2,is);
			}else{
				ps.setNull(2, Types.BLOB);
			}

			ps.setInt(3,idd);

			//ResultSet rs=ps.executeQuery();
			int rs=ps.executeUpdate();
			System.out.println("rs inside updateVersionDetails : "+rs);

//			if(rs.next()){
			if(rs==1){
				versionDetails.put("status", "pass");

			}
			else{
				versionDetails.put("status", "fail");
			}

		}catch (Exception e){
			e.printStackTrace();
			versionDetails=new JSONObject();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(null!=is){
				try {
					is.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		return versionDetails;
	}


	 public void updateDetail(Detail detail, int idd)
	 {
		 String sql = "UPDATE sanitydetails set dataset= ? where id in(?);";
		 jdbcTemplate.update(new PreparedStatementCreator()
				 {
			 
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setString(1, "trend");
						ps.setInt(2, idd);
						
						return ps;
					}
				 });
	 }
	 
	 public JSONArray getClients(){
		 Connection con=null;
		 JSONArray clients=new JSONArray();

		 try{
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("select distinct client from client_version " +
					"where client not in('MCUBE','LVA','INSTALLER') and IS_ACTIVE=1");
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				clients.put(rs.getString(1));
			}

		 }catch (Exception e){
			e.printStackTrace();
			 clients=new JSONArray();
		 }finally {
			 if(null!=con){
				 try {
					 con.close();
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 }
		 return clients;
	 }

	public JSONArray getVersions(String client) {
		Connection con=null;
		JSONArray versions=new JSONArray();

		try{
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("select id,version from client_version " +
					"where client = ? and IS_ACTIVE=1");

			ps.setString(1,client);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				JSONObject version=new JSONObject();
				version.put("id",rs.getInt(1));
				version.put("version",rs.getString(2));
				versions.put(version);
			}
		}catch (Exception e){
			e.printStackTrace();
			versions=new JSONArray();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return versions;
	}

	public JSONArray getFeatures(){
		Connection con=null;
		JSONArray features=new JSONArray();

		try{
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("select distinct client from client_version " +
					"where client not in('MCUBE','LVA','INSTALLER','IPDS','TAGIC','CTEC','CIGNA','LUMMUS','') and IS_ACTIVE=1");

//			PreparedStatement ps= con.prepareStatement("select distinct client from client_version " +
//					"where client=FEATURE and IS_ACTIVE=1");

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				features.put(rs.getString(1));
			}

		}catch (Exception e){
			e.printStackTrace();
			features=new JSONArray();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return features;
	}

	public JSONArray getRegressions(){
		Connection con=null;
		JSONArray features=new JSONArray();

		try{
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("select distinct client from client_version " +
					"where client not in('MCUBE','LVA','INSTALLER','IPDS','TAGIC','CTEC','CIGNA','LUMMUS','', " +
					"'FEATURES' ,'Dashboard Calendar Filter', " +
					"'Calendar Filter') and IS_ACTIVE=1");

//			PreparedStatement ps= con.prepareStatement("select distinct client from client_version " +
//					"where client=FEATURE and IS_ACTIVE=1");

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				features.put(rs.getString(1));
			}

		}catch (Exception e){
			e.printStackTrace();
			features=new JSONArray();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return features;
	}
	public JSONObject getVersionDetails(int versionId) {
		Connection con=null;
		JSONObject versionDetails=new JSONObject();

		try{

			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("select url,username,password,dataset,mailto from sanity_details " +
					"where CLIENT_ID = ? and IS_ACTIVE=1");

			ps.setInt(1,versionId);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				versionDetails.put("url",rs.getString("url"));
				versionDetails.put("username",rs.getString("username"));
				versionDetails.put("password",rs.getString("password"));
				versionDetails.put("dataset",rs.getString("dataset"));
				versionDetails.put("mailto",rs.getString("mailto"));
			}

		}catch (Exception e){
			e.printStackTrace();
			versionDetails=new JSONObject();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return versionDetails;
	}

	public int getMasterIdViaHash(String hash_value) {
		Connection con=null;
		//JSONObject percentDetails=new JSONObject();
		Integer master_id = null;
		try{

			con=jdbcTemplate.getDataSource().getConnection();

			PreparedStatement ps= con.prepareStatement("Select SANITY_DETAILS_ID from sanity_automation_master where HASH = ?");
			ps.setString(1,hash_value);

			ResultSet rs=ps.executeQuery();
			//idd = rs.getInt(1);
			if(rs.next()) {
				master_id = rs.getInt("SANITY_DETAILS_ID");
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return master_id;
	}

	public int getIdViaHash(String hash_value) {
		Connection con=null;
		//JSONObject percentDetails=new JSONObject();
		Integer idd = null;
		try{

			con=jdbcTemplate.getDataSource().getConnection();

			PreparedStatement ps= con.prepareStatement("Select id from sanity_automation_master where HASH = ?");
			ps.setString(1,hash_value);

			ResultSet rs=ps.executeQuery();
			//idd = rs.getInt(1);

			if (rs.next()) {
				idd = rs.getInt("id"); //Returns 0 even if the value should be null
				System.out.println("idd inside getIdViaHash : "+idd+" hash : "+hash_value);
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return idd;
	}

	public void setRecordDetails(Records record)
	{
		JSONObject insertStatus=new JSONObject();
		String OUTCOME = "";

		int SANITY_AUTOMATION_MASTER_ID = record.getSan_aut_id();
		String TEST_CASE_ID = record.getTestCaseName();
		Boolean is_outcome = record.isOutcome();
		if(is_outcome.equals(true))
		{
			OUTCOME = "PASS";
		}
		else {
			OUTCOME = "FAIL";
		}
		//---------------------
		Connection con=null;
		InputStream is = null;
		JSONObject versionDetails=new JSONObject();

		try{

			con=jdbcTemplate.getDataSource().getConnection();
			String sql = "INSERT INTO sanity_automation_details " + "(SANITY_AUTOMATION_MASTER_ID, TEST_CASE_ID, OUTCOME, EXECUTED_ON) VALUES (?,?,?,NOW())";

			PreparedStatement ps= con.prepareStatement(sql);

			ps.setInt(1,SANITY_AUTOMATION_MASTER_ID);
			ps.setString(2,TEST_CASE_ID);
			ps.setString(3,OUTCOME);

			//ResultSet rs=ps.executeQuery();
			int rs=ps.executeUpdate();
			System.out.println("rs inside setRecordDetails : "+rs);

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(null!=is){
				try {
					is.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	//GetPercent
	public int getPercent(String creator_name) {
		Connection con=null;
		//float percentage = 0.0f;
		int percentage = 0;
		try{
			//SELECT COUNT(ProductID) AS NumberOfProducts FROM Products;
			con=jdbcTemplate.getDataSource().getConnection();


			int last_id = getLastID(creator_name);

			PreparedStatement ps= con.prepareStatement("select COUNT(SANITY_AUTOMATION_MASTER_ID) AS tc_exec from sanity_automation_details " +
					"where SANITY_AUTOMATION_MASTER_ID = ? ");

			ps.setInt(1,last_id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				float exec_count = Float.valueOf(rs.getInt("tc_exec"));
				float total_count = Float.valueOf(18);

				percentage = (int)((exec_count/total_count)*100f);
				System.out.println("Percentage : "+percentage);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return percentage;
	}

	public int getLastID(String user) {
		Connection con=null;
		//JSONObject percentDetails=new JSONObject();
		Integer last_ID = null;
		try{

			con=jdbcTemplate.getDataSource().getConnection();

			PreparedStatement ps_lastId = con.prepareStatement("SELECT MAX(id) as LAST_ID FROM sanity_automation_master where CREATOR = ? ORDER BY ID DESC");
			ps_lastId.setString(1,user);
			ResultSet rs_lastId=ps_lastId.executeQuery();

			if(rs_lastId.next()) {
				last_ID = rs_lastId.getInt("LAST_ID");
				System.out.println("Last Id : "+last_ID);
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return last_ID;
	}

//	public ArrayList<JSONObject> getReportDetails(String creatorMail) {
//		Connection con=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//
//		ArrayList<JSONObject> reportDetails = new ArrayList<JSONObject>();
//
//		try {
//			con = jdbcTemplate.getDataSource().getConnection();
//
//			if (!creatorMail.equalsIgnoreCase("mcubeqa@tcgdigital.com")) {
////				ps = con.prepareStatement("Select id, CREATED_ON,CREATED_BY,REPORT,CREATOR FROM sanity_selenium.sanity_automation_master WHERE CREATED_BY = ? ORDER BY id DESC LIMIT 10 ");
//				ps = con.prepareStatement("Select id, CREATED_ON,CREATED_BY,REPORT,CREATOR FROM sanity_selenium.sanity_automation_master WHERE CREATED_BY = ? ORDER BY id DESC");
//				ps.setString(1, creatorMail);
//				rs = ps.executeQuery();
//
//			} else {
//				ps = con.prepareStatement("Select id, CREATED_ON,CREATED_BY,REPORT,CREATOR FROM sanity_selenium.sanity_automation_master ORDER BY id DESC");
//				rs = ps.executeQuery();
//
//			}
//			while(rs.next()){
//				JSONObject reports=new JSONObject();
//				reports.put("repId",rs.getString("id"));
//				reports.put("username",rs.getString("CREATOR"));
//				reports.put("creatorMail",rs.getString("CREATED_BY"));
//				reports.put("creatorTime",rs.getString("CREATED_ON"));
//				reports.put("report",rs.getString("REPORT"));
//
//				reportDetails.add(reports);
//				System.out.println(reportDetails.get(0));
//
//			}
//		}
//
//		catch (Exception e){
//			e.printStackTrace();
////			reportDetails=new JSONObject();
//		}finally {
//			if(null!=con){
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return reportDetails;
//	}
	public ArrayList<JSONObject> getReportDetails(String creatorMail) {
	Connection con=null;

	ArrayList<JSONObject> reportDetails = new ArrayList<JSONObject>();

	try{

		con=jdbcTemplate.getDataSource().getConnection();
		PreparedStatement ps= con.prepareStatement("Select id, CREATED_ON,REPORT,CREATOR,mailto FROM sanity_selenium.sanity_automation_master WHERE CREATED_BY = ? ORDER BY id DESC");

		ps.setString(1,creatorMail);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			JSONObject reports=new JSONObject();
			reports.put("repId",rs.getString("id"));
			reports.put("username",rs.getString("CREATOR"));
//			reports.put("creatorMail",rs.getString("CREATED_BY"));
			reports.put("mailto",rs.getString("mailto"));
			reports.put("creatorTime",rs.getString("CREATED_ON"));
			reports.put("report",rs.getString("REPORT"));


			reportDetails.add(reports);


		}
		//System.out.println(reportDetails.get(0));

	}catch (Exception e){
		e.printStackTrace();
//			reportDetails=new JSONObject();
	}finally {
		if(null!=con){
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	return reportDetails;
}
//	public void writeBlobToFile(Long entityId, String filePath) {
//		YourEntity entity = repository.findById(entityId).orElse(null);
//
//		if (entity != null) {
//			try (FileOutputStream fos = new FileOutputStream(filePath)) {
//				fos.write(entity.getBlobData());
//			} catch (IOException e) {
//				e.printStackTrace();
//				// Handle the exception appropriately
//			}
//		} else {
//			// Handle the case where the entity with the given ID is not found
//		}
//	}
public boolean getReportBlob(String idBlob, String creatorTime) {
	Connection con = null;
	File file = null;
	boolean flag= true;
	//file=new File(folderPath+"Sanity Report.pdf");
	try {
// Specify the SQL query to retrieve the BLOB data
		//String sql = "Select REPORT FROM sanity_selenium.sanity_automation_master WHERE CREATED_BY = ? ORDER BY id DESC LIMIT 10 ";
		con = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement ps = con.prepareStatement("Select REPORT FROM sanity_selenium.sanity_automation_master WHERE id = ? ");

//			ps.setString(1,creatorMail);
		ps.setString(1, idBlob);
		ResultSet resultSet = ps.executeQuery();

		if (resultSet.next()) {
			// Retrieve the BLOB data
			InputStream blobInputStream = resultSet.getBinaryStream("REPORT");
			if (blobInputStream == null) {
				flag = false;
			} else {
				creatorTime = creatorTime.replaceAll(" ", "").replaceAll("-", "_").replaceAll(":", "_");
				// Specify the file path where you want to save the BLOB data
				String filePath = "D:\\sanity_automation_" + creatorTime + ".pdf";
				//Folder banao -> Sanity.pdf
				System.currentTimeMillis();


				// Create a FileOutputStream to write the BLOB data to a file
				try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
					byte[] buffer = new byte[4096];
					int bytesRead;

					// Read the BLOB data and write it to the file
					while ((bytesRead = blobInputStream.read(buffer)) != -1) {
						fileOutputStream.write(buffer, 0, bytesRead);
					}
				}

				System.out.println("BLOB data retrieved and saved to: " + filePath);
			}
		}else {
			System.out.println("No data found for the specified condition.");
		}


	} catch (Exception e) {
		e.printStackTrace();
//			reportDetails=new JSONObject();
	} finally {
		if (null != con) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	return flag;
}

public byte[] getReportBlobGet(int idBlob) {
		Connection con = null;
		File file = null;
		byte[] fileData = null;
		boolean flag= true;
		//file=new File(folderPath+"Sanity Report.pdf");
		try {
// Specify the SQL query  retrieve the BLOB data
			//String sql = "Select REPORT FROM sanity_selenium.sanity_automation_master WHERE CREATED_BY = ? ORDER BY id DESC LIMIT 10 ";
			con = jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps = con.prepareStatement("Select REPORT FROM sanity_selenium.sanity_automation_master WHERE id = ? ");
			String idBlobString  = String.valueOf(idBlob);
//			ps.setString(1,creatorMail);
			ps.setString(1, idBlobString);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				// Retrieve the BLOB data
				InputStream blobInputStream = resultSet.getBinaryStream("REPORT");
				if (blobInputStream == null) {
					flag = false;
				} else {
					String creatorTime = "_"+System.currentTimeMillis()/1000;
					creatorTime.replaceAll(" ", "").replaceAll("-", "_").replaceAll(":", "_");

					if (blobInputStream != null) {
						// Convert InputStream to byte array
						fileData = blobInputStream.readAllBytes();
					}

				}
			}else {
				System.out.println("No data found for the specified condition.");
			}


		} catch (Exception e) {
			e.printStackTrace();
//			reportDetails=new JSONObject();
		} finally {
			if (null != con) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return fileData;
	}

	public ArrayList<JSONObject> getReportDetailsAll() {
		Connection con=null;

		ArrayList<JSONObject> reportDetails = new ArrayList<JSONObject>();

		try{

			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps= con.prepareStatement("Select id, CREATED_ON,REPORT,CREATOR,mailto FROM sanity_selenium.sanity_automation_master");

			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				JSONObject reports=new JSONObject();
				reports.put("repId",rs.getString("id"));
				reports.put("username",rs.getString("CREATOR"));
				reports.put("mailto",rs.getString("mailto"));
				//reports.put("creatorMail",rs.getString("CREATED_BY"));
				reports.put("creatorTime",rs.getString("CREATED_ON"));
				reports.put("report",rs.getString("REPORT"));


				reportDetails.add(reports);
			}
			//System.out.println(reportDetails.get(0));

		}catch (Exception e){
			e.printStackTrace();
//			reportDetails=new JSONObject();
		}finally {
			if(null!=con){
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return reportDetails;
	}
}
