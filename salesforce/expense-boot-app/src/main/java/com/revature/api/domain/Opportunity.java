package com.revature.api.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Opportunity {
	private String id;
	private BigDecimal expenseAmount;
	private Date closeDate;
	private final String name = "Expense Report";
	
	public Opportunity(String id, BigDecimal expenseAmount, Date closeDate) {
		super();
		this.id = id;
		this.expenseAmount = expenseAmount;
		this.closeDate = closeDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", expenseAmount=" + expenseAmount + ", closeDate=" + closeDate + ", name="
				+ name + "]";
	}
	
	
}
