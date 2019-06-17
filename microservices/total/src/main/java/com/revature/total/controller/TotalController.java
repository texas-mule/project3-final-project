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
		//Calls an Expense array for the given expenses you get
		//serviceURL_1 is the rest service called upon
		//used for setting the endpoint for the organization
		Expense[] list = restTemplate.getForObject(serviceURL_1 + "/" 
				+ organization, Expense[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		
		//goes over the dates set and checks for the given inputs if the dates
		// are between them, returns the date if they are and add to total
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
		
		//goes overall all entries and adds the amount up
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
	
	@GetMapping("/expenses/after/{organization}/{date1}")
	public Group totalExpensesAfterDate
	(@PathVariable String organization, @PathVariable Date date1) {
		//Calls an Expense array for the given expenses you get
		//serviceURL_1 is the rest service called upon
		//used for setting the endpoint for the organization
		Expense[] list = restTemplate.getForObject(serviceURL_1 + "/" 
				+ organization, Expense[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		
		//checks to see if the dates called are after date1 if they are
		//returns datewant corresponding amount and add to total
		for (int i = 0; i < listsize; i++){
			datewant = list[i].getDate();
			if(organization.equals(list[i].getOrganization())){
				System.out.println(datewant.compareTo(date1));
				if(datewant.compareTo(date1) > 0){
					total = total.add(list[i].getAmount());
					System.out.println(total);
				}
			}
		}
		output = total.toPlainString();
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
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
	
	@GetMapping("/revenue/after/{organization}/{date1}")
	public Group totalRevenuesAfterDate
	(@PathVariable String organization, @PathVariable Date date1) {
		//Calls an Expense array for the given expenses you get
		//serviceURL_1 is the rest service called upon
		//used for setting the endpoint for the organization
		Revenue[] list = restTemplate.getForObject(serviceURL_1 + "/" 
				+ organization, Revenue[].class);
		
		String output = "output";
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		
		//checks to see if the dates called are after date1 if they are
		//returns datewant corresponding amount and add to total
		for (int i = 0; i < listsize; i++){
			datewant = list[i].getDate();
			if(organization.equals(list[i].getName())){
				System.out.println(datewant.compareTo(date1));
				if(datewant.compareTo(date1) > 0){
					total = total.add(list[i].getCost());
					System.out.println(total);
				}
			}
		}
		output = total.toPlainString();
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
	}
	
	/**
	 * Synchronous client to perform HTTP requests, exposing a simple, 
	 * template method API over underlying HTTP client libraries
	 * @return
	 */
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	
}
