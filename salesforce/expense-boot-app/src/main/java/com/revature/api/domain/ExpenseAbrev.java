package com.revature.api.domain;

import com.google.gson.Gson;

/**
 * @author sweinhart
 *
 */
public class ExpenseAbrev {

	/**
	 * Organization Name
	 */
	private String organization;
	
	/**
	 * Expense Amount in US Dollars
	 */
	private String amount;
	
	/**
	 * Expense Description
	 */
	private String description;
	
	/**
	 * Quantity if items purchased
	 */
	private Integer quantity;

	/**
	 * Empty Constructor
	 */
	public ExpenseAbrev() {
		super();
	}

	/**
	 * Get Expense Item Quantity
	 * 
	 * @return quantity : Integer
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Set Expense Item Quantity
	 * 
	 * @param quantity : Integer
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get Organization Name
	 * 
	 * @return organization : String
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Set Organization Name
	 * 
	 * @param organization : String
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * Get Expense Amount
	 * 
	 * @return amount : String
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * Set Expense Amount
	 * 
	 * @param amount : String
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * Get Expense Description
	 * 
	 * @return description : String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set Expense Description
	 * 
	 * @param description : String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	/**
	 * Returns an expense summary object from Expense object
	 * 
	 * @param e : Expense object
	 * @return ExpenseAbrev object
	 */
	public static ExpenseAbrev from(Expense e) {
		ExpenseAbrev ea = new ExpenseAbrev();
		ea.setOrganization(e.getOrganization());
		ea.setAmount(e.getAmount());
		ea.setDescription(e.getDescription());
		ea.setQuantity(e.getQuantity());
		return ea;
	}

}
