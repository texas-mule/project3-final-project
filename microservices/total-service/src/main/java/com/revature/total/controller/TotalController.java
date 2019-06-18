package com.revature.total.controller;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.total.dto.Group;
import com.revature.total.service.TotalService;

/**
 * 
 * @author david
 * The TotalController is used as a RestController
 */
@RestController
@RequestMapping("/total")
public class TotalController {
	
	@Autowired
	TotalService totalService;
	
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @param date1: Given date to begin at, the beginning of the quarter
	 * @param date2: Given date to end at, the ending of the quarter
	 * @return a BigDecimal value of the total expenses of that quarter
	 * @throws Exception 
	 */
	@GetMapping("/expenses/{organization}/{date1}/{date2}")
	@Produces("application/json")
	public Group totalExpensesByDates
	(@PathVariable String organization, 
		@PathVariable("date1") @DateTimeFormat(iso=ISO.DATE) String date1, 
		@PathVariable("date2") @DateTimeFormat(iso=ISO.DATE) String date2) throws Exception {
		return totalService.getExpenseByDates(organization, date1, date2);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @return a BigDecmial value of the total expenses for that organization
	 * @throws Exception 
	 */
	@GetMapping("/expenses/all/{organization}")
	@Produces("application/json")
	public Group totalExpensesAll
	(@PathVariable String organization) throws Exception {
		return totalService.getExpenseByAll(organization);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @param date1: Given date to begin at
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/expenses/after/{organization}/{date1}")
	@Produces("application/json")
	public Group totalExpensesAfterDate
	(@PathVariable String organization, 
		@PathVariable("date1") @DateTimeFormat(iso=ISO.DATE) String date1) throws Exception {
		
		return totalService.getExpenseByDate(organization, date1);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @param date1: Given date to begin at, the beginning of the quarter
	 * @param date2: Given date to end at, the ending of the quarter
	 * @return a String value of the total revenues of that quarter
	 */
	@GetMapping("/revenues/{organization}/{date1}/{date2}")
	@Produces("application/json")
	public Group totalRevenuesByDates
	(@PathVariable String organization, 
	@PathVariable("date1") @DateTimeFormat(iso=ISO.DATE) String date1, 
	@PathVariable("date2") @DateTimeFormat(iso=ISO.DATE) String date2) throws Exception {
		return totalService.getRevenueByDates(organization, date1, date2);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @return a String value of the total revenues for that organization
	 * @throws Exception 
	 */
	@GetMapping("/revenues/all/{organization}")
	@Produces("application/json")
	public Group totalRevenuesAll
	(@PathVariable String organization) throws Exception {
		return totalService.getRevenueByAll(organization);
	}
	
	/**
	 * 
	 * @param organization: Given organization looking for
	 * @param date1: Given date to begin at
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/revenues/after/{organization}/{date1}")
	@Produces("application/json")
	public Group totalRevenuesAfterDate
	(@PathVariable String organization, 
		@PathVariable("date1") @DateTimeFormat(iso=ISO.DATE) String date1) throws Exception {
		return totalService.getRevenueByDate(organization, date1);
	}
	
}
