package com.revature.api.domain;


import java.util.Calendar;
import java.util.TimeZone;
import java.text.DecimalFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.google.gson.Gson;

@Entity
@Table(name = "expenses")
public class Expense implements Comparable<Expense>{
	
	@Id @GeneratedValue(generator="clients_id_seq", strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Pattern(regexp="[a-zA-Z\\s]+")
	@javax.validation.constraints.Size(min=2, max=20)
	@NotBlank
	private String organization;
	
	private String amount;
	
	@Pattern(regexp="[a-zA-Z\\s]+")
	@javax.validation.constraints.Size(min=2, max=20)
	@NotBlank
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
		return date.compareTo(o.date);
	}
	
}
