package com.jdbc.controllers;

import com.automation.SanityDataRest.model.Detail;
import com.jdbc.dao.DetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayController {
	
	@Autowired
	private DetailDao detailDao; // Repository
	
	@RequestMapping("/")
	public String index()
	{
		
		return "index";
	}
	
	
	@RequestMapping("/addDetails")
	public Detail getDetail(@RequestParam("url") String url, @RequestParam("username") String username, 
	  @RequestParam("password") String password, @RequestParam("dataset") String dataset, @RequestParam("mailrec") String mailto)
	{
		Detail detailResponse = new Detail(url, username, password, dataset, mailto);
		
		detailDao.insertDetail(detailResponse);
		System.out.println("Details entered successfully inside Controller !!! ");
		
		//Write Code to start automation triggering

		return detailResponse;
	}

}
