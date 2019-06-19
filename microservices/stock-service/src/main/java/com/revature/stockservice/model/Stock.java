package com.revature.stockservice.model;

public class Stock {
	
	private String tickerSymbol;
	private String companyName;
	private double amountSpent;
	private double sharesOwned;
	private double currentPrice;
	private double profitOrLoss;
	
	public Stock(String tickerSymbol, String companyName, double amountSpent, double sharesOwned, double currentPrice, double profitOrLoss) {
		
		this.tickerSymbol = tickerSymbol;
		this.companyName = companyName;
		this.amountSpent = amountSpent;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
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
