package com.revature.fundsbootapp;

import java.sql.Date;

public class Revenue {
	
	String name;
	double cost;
	Date date;
	String item;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString()
	{
		return "{ \"name\":" + this.name + ","+ 
				"\"funds\":"+ this.cost + "," +
				"\"item\":"+ this.item + "," +
				" \"created\":" + this.date+"}"; 
	}
	
}
