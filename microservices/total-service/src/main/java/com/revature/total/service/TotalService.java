package com.revature.total.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;  

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.total.dto.Expense;
import com.revature.total.dto.Group;
import com.revature.total.dto.Revenue;

@Service
public class TotalService {
	
	/**
	 * Calls RestTemplate
	 * 
	 * 
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
	 * @param organization: The Organization that the user is looking for
	 * @return group object
	 * @throws Exception
	 */
	@Transactional
	public Group getExpenseByAll(String organization) throws Exception{
		
		return getGroupExpense(organization, "02-02-2002", "01-01-2001", "all");
		
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @param date1: Given date to begin at
	 * @return group object
	 * @throws Exception
	 */
	@Transactional
	public Group getExpenseByDate(String organization, String date1) throws Exception{
		
		return getGroupExpense(organization, date1, "01-01-2001", "one");
		
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @param date1: Given date to begin at
	 * @param date2: Given date to end at
	 * @return group object
	 * @throws Exception
	 */
	@Transactional
	public Group getExpenseByDates(String organization, String date1, String date2) throws Exception{
		
		return getGroupExpense(organization, date1, date2, "both");
		
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @param date1: Given date to begin at
	 * @param date2: Given date to end at
	 * @param type
	 * @return group object
	 * @throws Exception
	 */
	public Group getGroupExpense(String organization, String date1, String date2, String type) throws Exception{
		//Calls an Expense array for the given expenses you get
		//serviceURL_1 is the rest service called upon
		//used for setting the endpoint for the organization
		Expense[] list = restTemplate.getForObject(serviceURL_1 + "/" 
						+ organization, Expense[].class);
		
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		
		java.util.Date date11 = new SimpleDateFormat("MM-dd-yyyy").parse(date1); 
		java.util.Date date22 = new SimpleDateFormat("MM-dd-yyyy").parse(date2); 
		
		if(type.equals("all")){
			//goes overall all entries and adds the amount up
			for (int i = 0; i < listsize; i++){
				total = total.add(list[i].getAmount());
			}
		}
		else if(type.equals("one")){
			//checks to see if the dates called are after date1 if they are
			//returns datewant corresponding amount and add to total
			for (int i = 0; i < listsize; i++){
				datewant = list[i].getDate();
				if(organization.equals(list[i].getOrganization())){
					if(datewant.compareTo(date11) > 0){
						total = total.add(list[i].getAmount());
					}
				}
			}
		}
		else if (type.equals("both")){
			//goes over the dates set and checks for the given inputs if the dates
			// are between them, returns the date if they are and add to total
			for (int i = 0; i < listsize; i++){
				datewant = list[i].getDate();
				if(organization.equals(list[i].getOrganization())){
					if(date11.compareTo(datewant) * datewant.compareTo(date22) >= 0){
						total = total.add(list[i].getAmount());
					}
				}
			}
		}
		
		Group group = new Group();
		group.setAmount(total);
		group.setOrganization(organization);
		return group;
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @return group object
	 * @throws Exception
	 */
	public Group getRevenueByAll(String organization) throws Exception{
		
		return getGroupRevenue(organization, "02-02-2002", "01-01-2001", "all");
		
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @param date1: Given date to begin at
	 * @return group object
	 * @throws Exception
	 */
	@Transactional
	public Group getRevenueByDate(String organization, String date1) throws Exception{
		
		return getGroupRevenue(organization, date1, "01-01-2001", "one");
		
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @param date1: Given date to begin at
	 * @param date2: Given date to end at
	 * @return group object
	 * @throws Exception
	 */
	@Transactional
	public Group getRevenueByDates(String organization, String date1, String date2) throws Exception{
		
		return getGroupRevenue(organization, date1, date2, "both");
		
	}
	
	/**
	 * 
	 * @param organization: The Organization that the user is looking for
	 * @param date1: Given date to begin at
	 * @param date2: Given date to end at
	 * @param type
	 * @return group object
	 * @throws Exception
	 */
	public Group getGroupRevenue(String organization, String date1, String date2, String type) throws Exception{
		//Calls an Revenues array for the given revenues you get
		//serviceURL_2 is the rest service called upon
		//used for setting the endpoint for the organization
		Revenue[] list = restTemplate.getForObject(serviceURL_2 + "/" 
				+ organization, Revenue[].class);
		
		BigDecimal total = new BigDecimal(0.00);
		int listsize = list.length;
		Date datewant;
		
		java.util.Date date11 = new SimpleDateFormat("MM-dd-yyyy").parse(date1); 
		java.util.Date date22 = new SimpleDateFormat("MM-dd-yyyy").parse(date2); 
		
		if(type.equals("all")){
			//goes overall all entries and adds the amount up
			for (int i = 0; i < listsize; i++){
				total = total.add(list[i].getCost());
			}
		}
		else if(type.equals("one")){
			//checks to see if the dates called are after date1 if they are
			//returns datewant corresponding amount and add to total
			for (int i = 0; i < listsize; i++){
				datewant = list[i].getDate();
				if(organization.equals(list[i].getName())){
					System.out.println(datewant.compareTo(date11));
					if(datewant.compareTo(date11) > 0){
						total = total.add(list[i].getCost());
						System.out.println(total);
					}
				}
			}
		}
		else if (type.equals("both")){
			//goes over the dates set and checks for the given inputs if the dates
			// are between them, returns the date if they are and add to total
			for (int i = 0; i < listsize; i++){
				datewant = list[i].getDate();
				if(organization.equals(list[i].getName())){
					if(date11.compareTo(datewant) * datewant.compareTo(date22) >= 0){
						total = total.add(list[i].getCost());
					}
				}
			}
		}
		
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
	public RestTemplate rest1() {
		return new RestTemplate();
	}

}
