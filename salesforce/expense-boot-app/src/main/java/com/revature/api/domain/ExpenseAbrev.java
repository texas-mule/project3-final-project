package com.revature.api.domain;

import com.google.gson.Gson;

public class ExpenseAbrev {

	private String organization;
	private String amount;
	private String description;
	private Integer quantity;

	public ExpenseAbrev() {
		super();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static ExpenseAbrev from(Expense e) {
		ExpenseAbrev ea = new ExpenseAbrev();
		ea.setOrganization(e.getOrganization());
		ea.setAmount(e.getAmount());
		ea.setDescription(e.getDescription());
		ea.setQuantity(e.getQuantity());
		return ea;
	}

}
