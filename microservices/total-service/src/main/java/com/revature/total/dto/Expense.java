package com.revature.total.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author david
 * The Expense object is used for setting json to object
 * Data Transfer Object
 */
@XmlRootElement	
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expense {
	/**
	 * The String variable organization is the Organization's name for the transaction,
	 * example: Fire Department
	 */
	//@Id
	@JsonProperty("organization") 
	private String organization;
	
	/**
	 * The Date variable date is the date for the transaction, 
	 * example: 1999-04-23
	 */
	@JsonProperty("date") 
	private Date date;
	
	/**
	 * The BigDecimal variable amount is the cost for the transaction
	 * example: 89.99
	 */
	@JsonProperty("amount") 
	private BigDecimal amount;
	
	/**
	 * The String variable description is the description for the item
	 * example: Pencil
	 */
	@JsonProperty("description") 
	private String description;
	
	/**
	 * The int variable quantity is the amount of items ordered
	 * example: 2
	 */
	@JsonProperty("quantity") 
	private int quantity;
	
	/**
	 * The int variable id is the entry id for the item
	 * example: 3
	 */
	@JsonProperty("id") 
	private int id;
	

	/**
	 * The Expense method is a constructor
	 * @param id
	 * @param organization
	 * @param description
	 * @param amount
	 * @param date
	 * @param quantity
	 */
	public Expense(int id, String organization, String description, BigDecimal amount, 
			Date date, int quantity) {
		super();
		this.organization = organization;
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.quantity = quantity;
	}
	
	public Expense() {
		super();
	}
	
	/**
	 * The toString method is used for listing out the given paramerters in String
	 * format. There is no input.
	 * @return String of Expense paramters
	 */
	@Override
	public String toString() {
		return "Expense [organization=" + organization + ", date=" + date + ", amount=" + amount 
				+ ", description=" + description + ", quantity=" + quantity + "]";
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
	 * The getDate returns the Date date value
	 * @return Date date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * The setDate sets the Date date value given a date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * The getDescription returns the String description value
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * The setDescription sets the String description given a description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * The getQuantity returns the int description value
	 * @return int quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * The setQuantity sets the int quantity given a quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * The getId returns the int id value
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * The setId sets the int id given an id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
