package com.example.quotingservice.domain;

import java.util.HashMap;

public class HospitalQuotes extends Quotes {
	private double quote;
	private HashMap<String, Double> hashmap=new HashMap<String, Double>();
	public HospitalQuotes(Integer id, String org_name, double budget, double funds, String stock) {
		super(id, org_name, budget, funds, stock);
		hashmap.put("Xray", (double)4700000);
		hashmap.put("UltraSound", (double)3000000);
		hashmap.put("ScreeningUnit", (double)12000000);
		hashmap.put("AnaestheticMachine", (double)2650991);
		hashmap.put("Vital", (double)500000);
	}
	public double getEquipmentQuote(String equipmentType,int count){
		double equipment;
		equipment=hashmap.get(equipmentType);
		quote=equipment*count;
		return quote;
	}

}
