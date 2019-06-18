package com.revature.Project3Stocks;

import java.io.Serializable;

public class StockKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7539621008083919468L;
	private String organizationName;
	private String tickerSymbol;

	public StockKey() {
		super();
	}

	public StockKey(String organization, String tickersymbol2) {
		organizationName = organization;
		tickerSymbol = tickersymbol2;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public static StockKey from(String organization, String tickersymbol2) {
		return new StockKey(organization, tickersymbol2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((organizationName == null) ? 0 : organizationName.hashCode());
		result = prime * result + ((tickerSymbol == null) ? 0 : tickerSymbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockKey other = (StockKey) obj;
		if (organizationName == null) {
			if (other.organizationName != null)
				return false;
		} else if (!organizationName.equals(other.organizationName))
			return false;
		if (tickerSymbol == null) {
			if (other.tickerSymbol != null)
				return false;
		} else if (!tickerSymbol.equals(other.tickerSymbol))
			return false;
		return true;
	}

}
