package com.revature.stockservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.stockservice.model.Department;
import com.revature.stockservice.model.Stock;

@Service
public class StockService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * response back department total profit or loss
	 * @param organization
	 * @return
	 */
	public HashMap<String, Department> aggregateOrgStock(String department) {
		
		HashMap<String, Department> orgStockDetails = new HashMap<>();
		List<Stock> stock = new ArrayList<>();
		
		double profitOrLoss= 0;
		double shares = 0; 
		double amountSpent = 0; 
		double currentPrice = 0;
	    String name = null;
	    String symbol = null;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    
	    ResponseEntity<String> response = restTemplate.exchange("http://stockcity-env.smf6wveb2h.us-east-2.elasticbeanstalk.com/stock/"+department, HttpMethod.GET, entity, new ParameterizedTypeReference<String>() {});
	    String tickerSymbols = response.getBody();
	    
	    if(tickerSymbols.isEmpty()) {
	    	
	    	return null;
	    	
	    }else {
	    	
	    	JSONArray tickerSymbols_arr = new JSONArray(tickerSymbols);
	    	
		    for(int i=0;i<tickerSymbols_arr.length();i++) {
		    	
		    	JSONObject obj=tickerSymbols_arr.getJSONObject(i);
		    	
		    	if(obj.has("companyName")) {
		    		name = obj.getString("companyName");
	    		}
		    	
		    	if(obj.has("shares")) {
	    			shares = obj.getDouble("shares");
	    		}
	    		
	    		if(obj.has("amountSpent")) {
	    			amountSpent = obj.getDouble("amountSpent");
	    		}
		    
		    	if(obj.has("tickerSymbol")) {
		    		
		    		symbol = obj.getString("tickerSymbol");
		    		JSONObject stockPrice_obj = new JSONObject(this.getStockPrice(symbol));
		    		
		    		if(stockPrice_obj.has("price")) {
			    			currentPrice = stockPrice_obj.getDouble("price");	    		
			    	}
	    		}
	    			            
	        	double profits = this.profitCalculator(shares, amountSpent, currentPrice);
	            profitOrLoss = profitOrLoss + profits;
	            
	            stock.add(new Stock(symbol, name, amountSpent, shares, currentPrice, profits));
		    }
	    	orgStockDetails.put(department, new Department(profitOrLoss, stock));
	    
	    	return orgStockDetails;
		
		}
	}
	
	/**
	 * Calculate profit per stock
	 * @param noOfShare
	 * @param stockpp purchase price
	 * @param stocksp current price
	 * @return
	 */
	public double profitCalculator(double noOfShare, double amountSpent, double stocksp) {
		
		double profit = (noOfShare * stocksp) - amountSpent;
		return profit;
	}
	
	/**
	 * get real time stock price
	 * @param symbol
	 * @return
	 */
	public String getStockPrice(String symbol) {
		
		ResponseEntity<String> response = restTemplate.exchange("https://financialmodelingprep.com/api/v3/stock/real-time-price/"+symbol, HttpMethod.GET, null,
				  new ParameterizedTypeReference<String>(){});
		String stock = response.getBody();
		
		if(stock.isEmpty()) {
			return null;
		}
		return stock;
	}
	
}
