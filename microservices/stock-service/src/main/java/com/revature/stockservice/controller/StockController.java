package com.revature.stockservice.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockservice.model.Department;
import com.revature.stockservice.service.StockService;

@RestController
@RequestMapping("/rest/stock")
public class StockController {
	
	@Autowired 
	StockService stockService;
	
	@GetMapping("/{symbol}")
	public String getStockPrice(@PathVariable("symbol") final String symbol){
		
		return stockService.getStockPrice(symbol);
	}
	
	@GetMapping("/aggregate/{department}")
	public HashMap<String, Department> aggregatePortfolio(@PathVariable("department") final String organization){
	
		return stockService.aggregateOrgStock(organization);
	}
	
}
