package com.test;

public class Try3Domain {

	private String name;
	private String item;
	private float cost;
	private String date;
	
	public Try3Domain(String name, String item, float cost, String date) {
		super();
		this.name = name;
		this.item = item;
		this.cost = cost;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString()
	{
		return "{name: "+this.name+"," +
				"revenue: "+this.cost+","+
				"item: " + this.item+"}";
	}

}
