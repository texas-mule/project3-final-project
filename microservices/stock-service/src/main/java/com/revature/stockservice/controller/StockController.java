package com.revature.stockservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/stock")
public class StockController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{symbol}")
	public String getStockPrice(@PathVariable("symbol") final String symbol){
		
		ResponseEntity<String> response = restTemplate.exchange("https://financialmodelingprep.com/api/v3/stock/real-time-price/"+symbol, HttpMethod.GET, null,
				  new ParameterizedTypeReference<String>(){});
		String stock = response.getBody();
		return stock;
       
	}
	
}
