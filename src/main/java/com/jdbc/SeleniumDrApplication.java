package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.automation.SanityDataRest.model.Detail;
import com.jdbc.dao.DetailDao;

@SpringBootApplication
public class SeleniumDrApplication {

	
//	@Autowired
//	private DetailDao detailDao; // Repository
	
	public static void main(String[] args) {
		
		SpringApplication.run(SeleniumDrApplication.class, args);
		
	}


	//int i = this.detailDao.insertUser(2, "https://mcubeinqa4300.tcgdigital.com/", "admin", "Mcube@123!", "trend", "altamash@tcgdigital.com");

//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println("Inside run..");
//		Detail detail = new Detail("https://tagicqa4300.tcgdigital.com/nxtgen/", "admin","Mcube@123!", "supstore","altamash.ghaus@tcgdigital.com");
//
////		//Insert Table
////		detailDao.insertDetail(detail);
////		System.out.println("Details entered successfully !!! ");
////
////		//Update Table
////		detailDao.updateDetail(detail,2); // 2 should be dynamic id no from the frontend
////		System.out.println("Details updated successfully for 2 !!! ");
//
//		//Update Table
//		detailDao.readDetail(); // 2 should be dynamic id no from the frontend
//		System.out.println("Details read successfully !!! ");
//	}

	
	
}
