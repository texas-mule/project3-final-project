package com.example.quotingservice.domain;

import java.util.HashMap;

public class HospitalQuotes  {
	private Long quote;
	private HashMap<String, Long> equipment=new HashMap<String, Long>();
	public HospitalQuotes() {
		
		equipment.put("Xray",  (long) 4700000);
		equipment.put("UltraSound", (long)3000000.00);
		equipment.put("ScreeningUnit", (long)12000000.00);
		equipment.put("AnaestheticMachine", (long)2650991.00);
		equipment.put("Vital", (long)500000.00);
	}
	public Long getQuote() {
		return quote;
	}
	public void setQuote(Long quote) {
		this.quote = quote;
	}
	public HashMap<String, Long> getEquipment() {
		return equipment;
	}
	public void setEquipment(HashMap<String, Long> equipment) {
		this.equipment = equipment;
	}
	public Long getEquipmentQuote(String equipmentType,int count){
		Long equip;
		equip=equipment.get(equipmentType);
		quote=equip*count;
		return quote;
	}

}
