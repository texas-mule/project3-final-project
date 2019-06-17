package com.example.quotingservice.domain;

import java.util.HashMap;

public class FireQuote  {
	private double quote;
	private HashMap<String, Double> equipment=new HashMap<String, Double>();
	public FireQuote() {
		equipment.put("HoodHelmet" , (double)25);
		equipment.put("Gloves",(double) 75);
		equipment.put("Boots",(double) 215);
		equipment.put("Helmet",(double) 265);
		equipment.put("HelmetLight", (double)50);
		equipment.put("Pants",(double) 1900);
		equipment.put("Mask",(double) 486);
		equipment.put("FireShelter",(double) 1097);
		equipment.put("WildBoots",(double)350);
		equipment.put("Coat",(double)250);
		equipment.put("trainning_equippment", (double)14333);
		equipment.put("truck", (double)120000);
		
	}
	public double getQuote() {
		return quote;
	}
	public void setQuote(double quote) {
		this.quote = quote;
	}
	public HashMap<String, Double> getEquipment() {
		return equipment;
	}
	public void setEquipment(HashMap<String, Double> equipment) {
		this.equipment = equipment;
	}
	
	public double newHires(int count){
		double newHire=equipment.get("trainning_equippment");
		quote=newHire*count;
		return quote;
	}
	public double newEquipment(String equipmentType,int count){
		double newEquipment=equipment.get(equipmentType);
		quote=newEquipment*count;
		return quote;
	}
}
