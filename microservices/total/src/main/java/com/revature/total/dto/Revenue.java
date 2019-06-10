package com.revature.total.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author david
 *
 */
@XmlRootElement	
@JsonIgnoreProperties(ignoreUnknown = true)
public class Revenue {
	/**
	 * The String variable name is the Revenue's name for the transaction,
	 * example: Fire Department
	 */
	@JsonProperty("name") 
	private String name;
	
	/**
	 * The String variable item is the Revenue's item for the transaction
	 * example: Pencil
	 */
	@JsonProperty("item") 
	private String item;
	
	/**
	 * The BigDecimal variable item is the Revenue's cost for the transaction
	 * example: 20.00
	 */
	@JsonProperty("cost") 
	private BigDecimal cost;
	
	/**
	 * The Date variable date is the Expense's date for the transaction
	 * example: 2019-09-12
	 */
	@JsonProperty("date") 
	private Date date;
	
	/**
	 * The Revenue method is a constructor for setting the variables
	 * @param name
	 * @param item
	 * @param cost
	 * @param date
	 */
	public Revenue(String name, String item, BigDecimal cost, Date date) {
		super();
		this.name = name;
		this.item = item;
		this.cost = cost;
		this.date = date;
	}
	
	public Revenue() {
		super();
	}

	@Override
	public String toString() {
		return "Revenue [name=" + name + ", item=" + item + ", cost=" + cost + ", date=" + date + "]";
	}
	
	/**
	 * The getName returns the String name value
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The setName sets the String name value given a value
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The getItem returns the String item value
	 * @return String item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * The setItem sets the String item value given a item
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * The getCost returns the BigDecimal cost value
	 * @return BigDecimal cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * The setCost sets the BigDecimal cost value given a cost
	 * @param cost
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
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
	
}
