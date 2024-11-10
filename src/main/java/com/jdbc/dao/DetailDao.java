package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.automation.SanityDataRest.model.Detail;

@Repository
public class DetailDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	 public void insertDetail(Detail detail)
	 {
		 String sql = "INSERT INTO sanitydetails " + "(url, username, password, dataset, mailto) VALUES (?,?,?,?,?)";
		 KeyHolder holder = new GeneratedKeyHolder();
		 jdbcTemplate.update(new PreparedStatementCreator()
				 {
			 
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, detail.getUrl());
						ps.setString(2, detail.getUsername());
						ps.setString(3, detail.getPassword());
						ps.setString(4, detail.getDataset());
						ps.setString(5, detail.getMailto());
						
						return ps;
					}
				 }, holder);
		 
		 int generatedDetailId = holder.getKey().intValue();
		 System.out.println("generatedDetailId : "+generatedDetailId);
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
	 
	 public void readDetail() throws SQLException, ClassNotFoundException
	 {
		 
		 			String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		 			String DB_URL = "jdbc:mysql://127.0.0.1:3306/seleniumsanity";
		 			String DB_USER = "root";
		 			String DB_PASSWORD = "root123";
		 			
		 				Connection connection = null;
		 				
		 				Class.forName(JDBC_DRIVER);
		 				
		 				connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		 				String sql = "Select * from sanitydetails";
		 
						PreparedStatement ps = connection.prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next())
						{
							int id = rs.getInt(1);
							String url = rs.getString(2);
							String username = rs.getString(3);
							String password = rs.getString(4);
							String dataset = rs.getString(5);
							String mailto = rs.getString(6);	
							
							System.out.println("ID :"+id);
							System.out.println("URL :"+url);
							System.out.println("USERNAME :"+username);
							System.out.println("PASSWORD :"+password);
							System.out.println("DATASET :"+dataset);
							System.out.println("MAILTO :"+mailto);
							System.out.println();
							
						}
					
						rs.close();
					
	 }
	 
	//Table creation
	/*
	 * public int createTable() { String query=
	 * "CREATE TABLE IF NOT EXISTS id Detail(id int primary key, url varchar(200), username varchar(200), password varchar(200), dataset varchar(200), mailto varchar(200))"
	 * ; int update = this.jdbcTemplate.update(query); return update; }
	 */
	
	/*
	 * public int insertUser(Integer id, String url, String username, String
	 * password, String dataset, String mailto) { String
	 * query="insert into sanitydetails(id,url,username,password,dataset,mailto) values(?,?,?,?,?,?)"
	 * ; int update = this.jdbcTemplate.update(query, new Object[]
	 * {id,url,username,password,dataset,mailto});
	 * 
	 * return update; }
	 */

}
