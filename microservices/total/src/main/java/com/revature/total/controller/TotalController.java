package com.revature.total.controller;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.total.dto.Expense;
import com.revature.total.dto.Revenue;
import com.revature.total.dto.Group;

/**
 * 
 * @author david
 * The TotalController is used as a RestController
 */
@RestController
@RequestMapping("/total")
public class TotalController {
	
	/**
	 * Calls RestTemplate
	 */
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * The operations.restURL_1 in the application.properties
	 * is set to string value serviceURL_1
	 */
	@Value("${operations.restURL_1}")
	String serviceURL_1;
	/**
	 * The operations.restURL_2 in the application.properties
	 * is set to string value serviceURL_2
	 */
	@Value("${operations.restURL_2}")
	String serviceURL_2;
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @param date1: Given date to begin at, the beginning of the quarter
	 * @param date2: Given date to end at, the ending of the quarter
	 * @return a BigDecimal value of the total expenses of that quarter
	 */
	@GetMapping("/expenses/{organization}/{date1}/{date2}")
	public Group totalExpensesByDates
	(@PathVariable String organization, @PathVariable Date date1, @PathVariable Date date2) {
		Expense[] list = restTemplate.getForObject(serviceURL_1 + "/" 
				+ organization, Expense[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		for (int i = 0; i < listsize; i++){
			datewant = list[i].getDate();
			if(organization.equals(list[i].getOrganization())){
				if(date1.compareTo(datewant) * datewant.compareTo(date2) >= 0){
					total = total.add(list[i].getAmount());
				}
			}
		}
		output = total.toPlainString();
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
		//return restTemplate.getForObject(serviceURL + "/" + organization, Expense[].class);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @return a BigDecmial value of the total expenses for that organization
	 */
	@GetMapping("/expenses/all/{organization}")
	public Group totalExpensesAll
	(@PathVariable String organization) {
		Expense[] list = restTemplate.getForObject(serviceURL_1 + "/" 
				+ organization, Expense[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		for (int i = 0; i < listsize; i++){
			total = total.add(list[i].getAmount());
		}
		output = total.toPlainString();
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
		//return restTemplate.getForObject(serviceURL + "/" + organization, Expense[].class);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @param date1: Given date to begin at, the beginning of the quarter
	 * @param date2: Given date to end at, the ending of the quarter
	 * @return a String value of the total revenues of that quarter
	 */
	@GetMapping("/revenues/{organization}/{date1}/{date2}")
	public Group totalRevenuesByDates
	(@PathVariable String organization, @PathVariable Date date1, @PathVariable Date date2) {
		Revenue[] list = restTemplate.getForObject(serviceURL_2 + "/" 
				+ organization, Revenue[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		for (int i = 0; i < listsize; i++){
			datewant = list[i].getDate();
			if(organization.equals(list[i].getName())){
				if(date1.compareTo(datewant) * datewant.compareTo(date2) >= 0){
					total = total.add(list[i].getCost());
				}
			}
		}
		output = total.toPlainString();
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
		//return restTemplate.getForObject(serviceURL + "/" + organization, Expense[].class);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @return a String value of the total revenues for that organization
	 */
	@GetMapping("/revenues/all/{organization}")
	public Group totalRevenuesAll
	(@PathVariable String organization) {
		Revenue[] list = restTemplate.getForObject(serviceURL_2 + "/" 
				+ organization, Revenue[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		for (int i = 0; i < listsize; i++){
			total = total.add(list[i].getCost());
		}
		output = total.toPlainString();
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
		//return restTemplate.getForObject(serviceURL + "/" + organization, Expense[].class);
	}
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/expenses/byquarter/{organization}/{date}/{quarter}")
	public String totalExpensesByQuarter
	(@PathVariable String organization, @PathVariable String date, @PathVariable String quarter) {
		Expense[] list = restTemplate.getForObject(serviceURL_1 + "/" 
				+ organization, Expense[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant, date1 = null, date2 = null;
		long newdate =  Long.parseLong(date);
		
		if(quarter.equals("Q1")){
			date1 = new Date(newdate-01-01);
			date2 = new Date(newdate-03-31);
		} else if (quarter.equals("Q2")){
			date1 = new Date(newdate-04-01);
			date2 = new Date(newdate-06-30);
			System.out.println(date1 + " " + date2);
		} else if (quarter.equals("Q3")){
			date1 = new Date(newdate-07-01);
			date2 = new Date(newdate-9-30);
		} else if (quarter.equals("Q4")){
			date1 = new Date(newdate-10-01);
			date2 = new Date(newdate-12-31);
		}
		
		
		for (int i = 0; i < listsize; i++){
			datewant = list[i].getDate();
			if(organization.equals(list[i].getOrganization())){
				if(date1.compareTo(datewant) * datewant.compareTo(date2) >= 0){
					total = total.add(list[i].getAmount());
				}
			}
		}
		output = total.toPlainString();
		
		return output;
		//return restTemplate.getForObject(serviceURL + "/" + organization, Expense[].class);
	}
	*/
	
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	
}
