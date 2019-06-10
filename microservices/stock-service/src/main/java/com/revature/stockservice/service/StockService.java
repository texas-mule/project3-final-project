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
	 * response back organization total profit or loss
	 * @param organization
	 * @return
	 */
	public HashMap<String, Department> aggregateOrgStock(String organization) {
		
		HashMap<String, Department> orgStockDetails = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    
	    ResponseEntity<String> response = restTemplate.exchange("http://stockcity-env.smf6wveb2h.us-east-2.elasticbeanstalk.com/stock/"+organization, HttpMethod.GET, entity, new ParameterizedTypeReference<String>() {});
	    String tickerSymbols = response.getBody();
	    
	    if(tickerSymbols.isEmpty()) {
	    	
	    	return null;
	    	
	    }else {
	 
	    JSONObject jobj_tickerSymbols =  new JSONObject(tickerSymbols);
	    JSONArray jarr_tickerSymbols = jobj_tickerSymbols.getJSONArray("stockList");
	    
	    double profitOrLoss = 0;
	    List<Stock> stock = new ArrayList<>();
	    
	    for(int i=0;i<jarr_tickerSymbols.length();i++) {
	    	JSONObject obj=jarr_tickerSymbols.getJSONObject(i);
	    	
            String name = obj.getString("companyName");		
    		String symbol = obj.getString("tickerSymbol");
    		double shares = obj.getDouble("shares");
    		double amountSpent = obj.getDouble("amountSpent");
//          double currentPrice = obj.getDouble("price");
            double currentPrice = this.getStockPrice(symbol);
            
            double profits = this.profitCalculator(shares, amountSpent, currentPrice);
            profitOrLoss = profitOrLoss + profits;
            
            stock.add(new Stock(symbol, name, amountSpent, shares, currentPrice, profits));
            
	    }
	    orgStockDetails.put(organization, new Department(profitOrLoss, stock));
	    
//		String name = obj.getString("companyName");		
//		String symbol = obj.getString("tickerSymbol");
//		double shares = obj.getDouble("shares");
//		double amountSpent = obj.getDouble("amountSpent");
	    
		return orgStockDetails;
		}
	    
	}
	
	/**
	 * Calculate profit per stock
	 * @param noOfShare
	 * @param stockpp
	 * @param stocksp
	 * @return
	 */
	public double profitCalculator(double noOfShare, double stockpp, double stocksp) {
		
		double profit;
		profit = (noOfShare * stocksp) - (noOfShare * stockpp);
		return profit;
		
	}
	
	/**
	 * get real time stock price
	 * @param symbol
	 * @return
	 */
	public double getStockPrice(String symbol) {
		
		ResponseEntity<String> response = restTemplate.exchange("https://financialmodelingprep.com/api/v3/stock/real-time-price/"+symbol, HttpMethod.GET, null,
				  new ParameterizedTypeReference<String>(){});
		String stock = response.getBody();
		
		if(stock.isEmpty()) {
			return 0;
		}
		
		JSONObject obj = new JSONObject(stock);
		return obj.getDouble("price");
	}
	
}
