package com.revature.fundsbootapp;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/projections")
public class FundsController {

	@Autowired
	ExpenseService expenseService;
	@Autowired
	RevenueService revenueService;

	/**
	 * Returns a welcome for the route.
	 * @return
	 */
	@GetMapping("/")
	public String hello() {
		return "Welcome to the funds page";
	}

	@GetMapping("/all")
	public String allFunds() {
		return "";
	}

	/**
	 * Returns current funds for the department you pass in.
	 * @param department
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GetMapping("/funds/{department}")
	public String getFundsForDepartment(@PathVariable String department) throws JsonParseException, JsonMappingException, IOException{
		
		double expenses = expenseService.sumExpensesByDepartment(department); //returns sum of expenses as a negative value
		double revenue = revenueService.sumRevenueByDepartment(department); // returns sum of revenue as a postive value
	
		double sum = revenue+expenses; // gets sum from values
		
		return "{\"department\":\""+department+"\",\"funds\":"+sum+"}";
	}
	
	/**
	 * Returns funds for department based on dates provided
	 * @param department
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GetMapping("/funds/{department}/byDates")
	public String getFundsForDepartment(@PathVariable String department, @RequestParam(value="start") Date startDate, @RequestParam(value="end") Date endDate) throws JsonParseException, JsonMappingException, IOException{

		double expenses = expenseService.expensesByDate(department, startDate, endDate); //returns sum of expenses as a negative value
		double revenue = revenueService.revenueByDate(department, startDate, endDate); // returns sum of revenue as a postive value
		
		double sum = revenue+expenses; //gets sum from values
		
		return "{\"department\":\""+department+"\",\"funds\":"+sum+",\"between dates\":\""+startDate+"-"+endDate+"\"}";
	}
	
	/**
	 * Gets expense projections by Department URI for the following year after given two previous years
	 * @param department
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GetMapping("/{department}/expense")
	public String getExpensesByYears(@PathVariable String department, @RequestParam(value="startYear") String startDate, @RequestParam(value="endYear") String endDate) throws JsonParseException, JsonMappingException, IOException{

		double expenses = expenseService.expensesByDateYear(department, startDate, endDate); //returns sum of expenses by years and provides a projection for the following year
		
		return "{\"department\":\""+department+"\",\"Expense Projection\":"+expenses+"}";
	}

	/**
	 * Gets revenue projections by Department URI for the following year after given two previous years
	 * @param department
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GetMapping("/{department}/revenue")
	public String getRevenueByYears(@PathVariable String department, @RequestParam(value="startYear") String startDate, @RequestParam(value="endYear") String endDate) throws JsonParseException, JsonMappingException, IOException{

		double revenue = revenueService.revenueByDateYear(department, startDate, endDate); //returns sum of revenue  by years and provides a projection for the following year
		
		return "{\"department\":\""+department+"\",\"Revenue Projection\":"+revenue+"}";
	}	





}