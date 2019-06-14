package com.revature.funds;

import java.io.IOException;
import java.util.Arrays;
import java.sql.Date;

import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@ImportResource({"classpath*:applicationContext.xml"})
public class ExpenseService {
	
	String expensesLink = "http://expensecity-env.dfhpkbxgyn.us-east-2.elasticbeanstalk.com";
	
	
	/**
	 * Returns sum of all expenses of a department as a negative value
	 * @param department
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public double sumExpensesByDepartment(String department) throws JsonParseException, JsonMappingException, IOException{
		HttpHeaders headers = new HttpHeaders(); // set headers into entity list
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));  // accept json for header
		HttpEntity <String> entity = new HttpEntity<String>(headers); // set headers into entity list
		
		String url = this.expensesLink+"/"+department; // set url
		RestTemplate restTemplate = new RestTemplate(); //set template for rest service consumption
		String expensearr = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody(); // get response body from request

		double sum = 0; // instantiate sum
		ObjectMapper mapper = new ObjectMapper(); // instantiate object mapper
		Expense[] expenses = mapper.readValue(expensearr, Expense[].class); // define mapper to revanue class

		
		for(Expense item: expenses){sum-=Double.parseDouble(item.getAmount());} //calculate sum of expense
		
		return sum;
	}
	
	/**
	 * Returns sum of expenses between dates for a department as a negative value
	 * @param department
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public double expensesByDate(String department, Date startDate, Date endDate) throws JsonParseException, JsonMappingException, IOException{
		HttpHeaders headers = new HttpHeaders(); // set headers into entity list
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); // accept json for header
		HttpEntity <String> entity = new HttpEntity<String>(headers); // set headers into entity list

		String url = this.expensesLink+"/"+department+"?start="+startDate+"&end="+endDate; // set url
		RestTemplate restTemplate = new RestTemplate(); //set template for rest service consumption
		String expensearr = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody(); // get response body from request
		
		double sum = 0; // instantiate sum
		ObjectMapper mapper = new ObjectMapper(); // instantiate object mapper
		Expense[] expenses = mapper.readValue(expensearr, Expense[].class); // define mapper to revanue class
		
		
		for(Expense item: expenses){sum-=Double.parseDouble(item.getAmount());} //calculate sum of expenses
		
		return sum;
	}
	
}
