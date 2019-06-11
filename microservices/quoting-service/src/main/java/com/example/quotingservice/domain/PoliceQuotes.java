package com.example.quotingservice.domain;

import java.util.HashMap;

public class PoliceQuotes  {
private double quote;
	private HashMap<String, Double> hashmap=new HashMap<String, Double>();
	public PoliceQuotes(){
		hashmap.put("fullUniform",(double) 1500);
		hashmap.put("boots",(double) 200);
		hashmap.put("salary",(double) 45000);
		hashmap.put("coat",(double) 250);
		hashmap.put("vest", (double)700);
		hashmap.put("radio",(double) 700);
		hashmap.put("glock",(double) 600);
		hashmap.put("taser",(double) 850);
		hashmap.put("duty",(double)700);
		hashmap.put("car", (double)105960);
		
		// TODO Auto-generated constructor stub
	}
	//type of equipment and the number of items needed
	public double getEquipmentQuote(String equipmentType,int count){
		double equipment;
		equipment=hashmap.get(equipmentType);
		quote=equipment*count;
		return quote;
	}
	//yearly salary for each cop
	public double getLaborQuote(int newOfficers){
		double equipment;
		equipment=hashmap.get("salary")+hashmap.get("fullUniform");
		return equipment*newOfficers;
		
		
	}
	public double getQuote() {
		return quote;
	}
	public void setQuote(double quote) {
		this.quote = quote;
	}
	public HashMap<String, Double> getHashmap() {
		return hashmap;
	}
	public void setHashmap(HashMap<String, Double> hashmap) {
		this.hashmap = hashmap;
	}

}
