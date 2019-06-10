package com.revature.stockservice.model;

public class Stock {
	
	private String tickerSymbol;
	private String name;
	private double stockPurchasePrice;
	private double sharesOwned;
	private double currentPrice;
	private double profitOrLoss;
	
	public Stock(String tickerSymbol, String name, double stockPurchasePrice, double sharesOwned, double currentPrice, double profitOrLoss) {
		
		this.tickerSymbol = tickerSymbol;
		this.name = name;
		this.stockPurchasePrice = stockPurchasePrice;
		this.sharesOwned = sharesOwned;
		this.currentPrice = currentPrice;
		this.profitOrLoss = profitOrLoss;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getstockPurchasePrice() {
		return stockPurchasePrice;
	}

	public void setstockPurchasePrice(double stockPurchasePrice) {
		this.stockPurchasePrice = stockPurchasePrice;
	}

	public double getSharesOwned() {
		return sharesOwned;
	}

	public void setSharesOwned(double sharesOwned) {
		this.sharesOwned = sharesOwned;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getProfitOrLoss() {
		return profitOrLoss;
	}

	public void setProfitOrLoss(double profitOrLoss) {
		this.profitOrLoss = profitOrLoss;
	}
	
	
	
}
