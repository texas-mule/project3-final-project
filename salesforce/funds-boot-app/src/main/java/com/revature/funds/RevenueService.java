package com.revature.fundsbootapp;

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
public class RevenueService {

	String revenueLink = "http://revenue-env.fbxttwvwiv.us-east-2.elasticbeanstalk.com/revenue";

	/**
	 * Returns sum of all revenue of a department as a positive value
	 * @param department
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public double sumRevenueByDepartment(String department) throws JsonParseException, JsonMappingException, IOException{

		HttpHeaders headers = new HttpHeaders(); // create header object for request
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); // accept json for header
		HttpEntity <String> entity = new HttpEntity<String>(headers); // set headers into entity list

		String url = this.revenueLink+"/"+department; // set url
		RestTemplate restTemplate = new RestTemplate(); //set template for rest service consumption
		String revenuearr = (String) restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody(); // get response body from request

		double sum = 0; // instantiate sum
		ObjectMapper mapper = new ObjectMapper(); // instantiate object mapper
		Revenue[] revenues = mapper.readValue(revenuearr, Revenue[].class); // define mapper to revanue class


		for(Revenue item: revenues){sum+=item.getCost();} // calculate sum of revenue

		return sum;
	}

	/**
	 * Returns sum of revenue between dates for a department
	 * @param department
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public double revenueByDate(String department, Date startDate, Date endDate) throws JsonParseException, JsonMappingException, IOException{

		HttpHeaders headers = new HttpHeaders(); // create header object for request
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); // accept json for header
		HttpEntity <String> entity = new HttpEntity<String>(headers); // set headers into entity list

		String url = this.revenueLink+"/"+department+"?start="+startDate+"&end="+endDate; // set url
		RestTemplate restTemplate = new RestTemplate(); //set template for rest service consumption
		String revenuearr = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody(); // get response body from request

		double sum = 0; // instantiate sum
		ObjectMapper mapper = new ObjectMapper(); // instantiate object mapper
		Revenue[] revenues = mapper.readValue(revenuearr, Revenue[].class); // define mapper to revanue class


		for(Revenue item: revenues){sum+=item.getCost();} //calculate sum of revenue

		return sum;
	}

	/**
	 * Gets projections, Revenue of URI department, for the following year after given two previous years
	 * @param department
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public double revenueByDateYear(String department, String startDate, String endDate) throws JsonParseException, JsonMappingException, IOException{
		String yearOneStart = startDate+"-01-01"; // sets start date for year one
		String yearOneEnd = startDate+"-12-31"; // sets end date for year one
		String yearTwoStart = endDate+"-01-01"; // sets start date for year two
		String yearTwoEnd = endDate+"-12-31"; // sets end date for year two
		double sumOne = 0; // instantiate sum for year one
		double sumTwo = 0; // instantiates sum for year two

		RestTemplate restTemplate = new RestTemplate(); //set template for rest service consumption


		String url = this.revenueLink+"/"+department+"?start="+yearOneStart+"&end="+yearOneEnd; // set url for start and end first year
		Revenue[] revenuesObjects = restTemplate.getForObject(url, Revenue[].class); //Gets and maps response to an array of revenue objects

		for(Revenue item: revenuesObjects){sumOne+=item.getCost();} //calculate sum of revenue for the first year

		url = this.revenueLink+"/"+department+"?start="+yearTwoStart+"&end="+yearTwoEnd; // set url for start and end of second year
		revenuesObjects = restTemplate.getForObject(url, Revenue[].class); //Gets and maps response to an array of revenue objects

		for(Revenue item: revenuesObjects){sumTwo+=item.getCost();} //calculate sum of expenses

		return ((sumTwo - sumOne)+sumTwo)*1.03;
	}
}