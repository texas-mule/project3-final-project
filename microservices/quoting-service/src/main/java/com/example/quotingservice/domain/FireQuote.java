package com.example.quotingservice.domain;

import java.util.HashMap;

public class FireQuote extends Quotes {
	private double quote;
	private HashMap<String, Double> hashmap=new HashMap<String, Double>();
	public FireQuote(Integer id, String org_name, double budget, double funds, String stock) {
		super(id, org_name, budget, funds, stock);
		hashmap.put("HoodHelmet" , (double)25);
		hashmap.put("Gloves",(double) 75);
		hashmap.put("Boots",(double) 215);
		hashmap.put("Helmet",(double) 265);
		hashmap.put("HelmetLight", (double)50);
		hashmap.put("Pants",(double) 1900);
		hashmap.put("Mask",(double) 486);
		hashmap.put("FireShelter",(double) 1097);
		hashmap.put("WildBoots",(double)350);
		hashmap.put("Coat",(double)250);
		hashmap.put("traing_equipping", (double)14333);
		hashmap.put("truck", (double)120000);
		
	}
	public double newHires(int count){
		double newHire=hashmap.get("trainning_equiping");
		quote=newHire*count;
		return quote;
	}
	public double newEquipment(String equipmentType,int count){
		double newEquipment=hashmap.get(equipmentType);
		quote=newEquipment*count;
		return quote;
	}
}
