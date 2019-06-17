package com.revature.fundsbootapp;


import java.util.Calendar;
import com.google.gson.Gson;

public class Expense implements Comparable<Expense>{

	private Integer id;
	private String organization;
	private String amount;
	private String description;
	private String date;
	private Integer quantity;

	public Expense() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Calendar getDate() {
		String [] date = this.date.split("-");
		Integer year = Integer.valueOf(date[0]);
		Integer month = Integer.valueOf(date[1]);
		Integer day = Integer.valueOf(date[2]);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	public void setDate(String object) {
		this.date = object;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@Override
	public int compareTo(Expense o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}