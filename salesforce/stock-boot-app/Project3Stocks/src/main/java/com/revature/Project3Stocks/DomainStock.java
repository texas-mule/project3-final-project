package com.revature.Project3Stocks;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Associate
 *
 */
@Entity
@Table(name = "stock")
public class DomainStock {

	@Id
	private String id;

	private String tickerSymbol;
	private String companyName;
	private String organizationName;
	private BigDecimal amountSpent;
	private BigDecimal shares;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DomainStock [tickerSymbol=" + tickerSymbol + ", companyName=" + companyName + ", organizationName="
				+ organizationName + ", amountSpent=" + amountSpent + ", shares=" + shares + ", id=" + id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountSpent == null) ? 0 : amountSpent.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((organizationName == null) ? 0 : organizationName.hashCode());
		result = prime * result + ((shares == null) ? 0 : shares.hashCode());
		result = prime * result + ((tickerSymbol == null) ? 0 : tickerSymbol.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainStock other = (DomainStock) obj;
		if (amountSpent == null) {
			if (other.amountSpent != null)
				return false;
		} else if (!amountSpent.equals(other.amountSpent))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (organizationName == null) {
			if (other.organizationName != null)
				return false;
		} else if (!organizationName.equals(other.organizationName))
			return false;
		if (shares == null) {
			if (other.shares != null)
				return false;
		} else if (!shares.equals(other.shares))
			return false;
		if (tickerSymbol == null) {
			if (other.tickerSymbol != null)
				return false;
		} else if (!tickerSymbol.equals(other.tickerSymbol))
			return false;
		return true;
	}

	/**
	 * @return
	 */
	public String getTickerSymbol() {
		return tickerSymbol;
	}

	/**
	 * @param tickerSymbol
	 */
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	/**
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return
	 */
	public BigDecimal getAmountSpent() {
		return amountSpent;
	}

	/**
	 * @param amountSpent
	 */
	public void setAmountSpent(BigDecimal amountSpent) {
		this.amountSpent = amountSpent;
	}

	/**
	 * @return
	 */
	public BigDecimal getShares() {
		return shares;
	}

	/**
	 * @param shares
	 */
	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param tickerSymbol
	 * @param companyName
	 * @param organizationName
	 * @param amountSpent
	 * @param shares
	 * @param id
	 */
	public DomainStock(String tickerSymbol, String companyName, String organizationName, BigDecimal amountSpent,
			BigDecimal shares, String id) {
		super();
		this.tickerSymbol = tickerSymbol;
		this.companyName = companyName;
		this.organizationName = organizationName;
		this.amountSpent = amountSpent;
		this.shares = shares;
		this.id = id;
	}

	/**
	 * 
	 */
	public DomainStock() {
		super();
	}

}
