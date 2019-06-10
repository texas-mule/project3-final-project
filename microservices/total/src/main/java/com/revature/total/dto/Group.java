package com.revature.total.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author david
 * Group Object
 */
@Entity
@Table(name = "expense")
public class Group {
	
	/**
	 * The String variable organization is the Organization's name for the transaction,
	 * example: Fire Department
	 */
	@Id
	@JsonProperty("organization") 
	private String organization;
	
	/**
	 * The BigDecimal variable amount is the cost for the transaction
	 * example: 89.99
	 */
	@JsonProperty("amount") 
	private BigDecimal amount;
	
	/**
	 * The Group method is a constructor
	 * @param organization
	 * @param amount
	 */
	public Group(String organization, BigDecimal amount) {
		super();
		this.organization = organization;
		this.amount = amount;
	}
	
	public Group() {
		super();
	}

	/**
	 * The toString method is used for listing out the given paramerters in String
	 * format. There is no input.
	 * @return String of Group paramters
	 */
	@Override
	public String toString() {
		return "Group [organization=" + organization + ", amount=" + amount + "]";
	}

	/**
	 * The getOrganization returns the String organization value
	 * @return String organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * The setOrganization sets the String organization value given an organization
	 * @param organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * The getAmount returns the BigDecimal amount value
	 * @return BigDecimal amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * The setAmount sets the BigDecimal amount value given an amount
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
