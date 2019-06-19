package com.revature.stockservice.model;

import java.util.List;

public class Department {

	private double totalProfit;
	private List<Stock> stockList;
	
	public Department(double totalProfit, List<Stock> stock) {
		this.totalProfit = totalProfit;
		this.stockList = stock;
	}
	
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
}
