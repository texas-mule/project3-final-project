package com.example.quotingservice.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quotingservice.domain.*;
@RestController
@RequestMapping("/quote-service")
public class QuotesController{
	@GetMapping("/building/{squarefeet}")
    public BuildingQuotes newBuilding(@PathVariable("squarefeet") int squareFootage){
    	BuildingQuotes buildingQuotes=new BuildingQuotes();
    	buildingQuotes.BuildingEstimate(squareFootage);
    	return buildingQuotes;
	}
	@GetMapping("Equipment/fire/{name}/{count}")
	public HashMap<String,Double> newFirePurchase(@PathVariable("name") String equipmentType,@PathVariable("count") int count){
		FireQuote firequotes=new FireQuote();
		
		double temp=firequotes.newEquipment(equipmentType, count);
		HashMap<String,Double> hashmap=new HashMap<String,Double>();
		hashmap.put(equipmentType,temp);
		return hashmap;
		
	}
	@GetMapping("newhire/fire/{count}")
	public HashMap<String,Double> newFireHires(@PathVariable("count") int count){
		FireQuote firequotes=new FireQuote();
		
		double temp=firequotes.newHires(count);
		HashMap<String,Double> hashmap=new HashMap<String,Double>();
		hashmap.put("new hire quote",temp);
		return hashmap;
		
	}
	@GetMapping("Equipment/law-enforcement/{name}/{count}")
	public HashMap<String,Double> newPolicePurchase(@PathVariable("name") String equipmentType,@PathVariable("count") int count){
		PoliceQuotes policeQuotes=new PoliceQuotes();
		
		double temp=policeQuotes.getEquipmentQuote(equipmentType, count);
		HashMap<String,Double> hashmap=new HashMap<String,Double>();
		hashmap.put(equipmentType,temp);
		return hashmap;
		
	}
	@GetMapping("newhire/law-enforcement/{count}")
	public HashMap<String,Double> newPolicePurchase(@PathVariable("count") int count){
		PoliceQuotes policeQuotes=new PoliceQuotes();
		
		double temp=policeQuotes.getLaborQuote(count);
		HashMap<String,Double> hashmap=new HashMap<String,Double>();
		hashmap.put("new Police Hire",temp);
		return hashmap;
		
	}
	@GetMapping("newhire/fire/itemized")
	public HashMap<String,Double> fitemizedHire(){
		FireQuote fireQuote=new FireQuote();
		return fireQuote.getEquipment();
	}
	@GetMapping("newhire/law-enforcement/itemized")
	public HashMap<String,Double> pitemizedHire(){
		PoliceQuotes policeQuotes=new PoliceQuotes();
		return policeQuotes.getHashmap();
	}
		
	
}
