package com.example.quotingservice.domain;

import java.util.HashMap;

public class HospitalQuotes extends Quotes {
	private double quote;
	private HashMap<String, Double> equipment=new HashMap<String, Double>();
	public HospitalQuotes(Integer id, String org_name, double budget, double funds, String stock) {
		super(id, org_name, budget, funds, stock);
		equipment.put("Xray", (double)4700000);
		equipment.put("UltraSound", (double)3000000);
		equipment.put("ScreeningUnit", (double)12000000);
		equipment.put("AnaestheticMachine", (double)2650991);
		equipment.put("Vital", (double)500000);
	}
	public double getEquipmentQuote(String equipmentType,int count){
		double equip;
		equip=equipment.get(equipmentType);
		quote=equip*count;
		return quote;
	}

}
