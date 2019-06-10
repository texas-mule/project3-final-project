package com.example.quotingservice.domain;

public class Quotes {
	private Integer id;

    private String org_name;
    private double budget;
    private double funds;
    private String stock;
    public Quotes(Integer id, String org_name, double budget, double funds, String stock)
    {
		this.id = id;
		this.org_name = org_name;
		this.budget = budget;
		this.funds = funds;
		this.stock = stock;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public double getFunds() {
		return funds;
	}
	public void setFunds(double funds) {
		this.funds = funds;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
    
    

}
