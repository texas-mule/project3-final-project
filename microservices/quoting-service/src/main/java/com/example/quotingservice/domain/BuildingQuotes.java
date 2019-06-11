package com.example.quotingservice.domain;

import java.util.HashMap;
import java.util.Map;

public class BuildingQuotes {
	private double quote;
	private HashMap<String,Double> matrial=new HashMap<String, Double>();
	public BuildingQuotes(){
		matrial.put("StudFrame-total", (double)34);
		matrial.put("StudFrame-matrials", (double)15);
		matrial.put("StudFrame-labor", (double)19);
		matrial.put("tilt-total", (double)27);
		matrial.put("tilt-matrials", (double)12);
		matrial.put("tilt-labor", (double)15);
		matrial.put("SteelFrames-total", (double)18);
		matrial.put("SteelFrames-labor", (double)8);
		matrial.put("SteelFrames-matrials", (double)10);
		matrial.put("foundataion",(double)8);
		matrial.put("contruction", (double)8);
	}
	public double BuildingEstimate(int squareFootage){
		HashMap<String,Double> itemized=new HashMap<String, Double>();
		for (Map.Entry<String, Double> entry : matrial.entrySet()) {
		    String key = entry.getKey();
		    double value = entry.getValue();
		    matrial.put(key, value*squareFootage);
		    quote+=value*squareFootage;
		   
		}
		return quote;
	}
	public HashMap<String,Double> itemized(int squareFootage){
		HashMap<String,Double> itemized=new HashMap<String, Double>();
		for (Map.Entry<String, Double> entry : matrial.entrySet()) {
		    String key = entry.getKey();
		    double value = entry.getValue();
		    itemized.put(key, value*squareFootage);
		    quote+=value*squareFootage;
		    
		   
		}
		return itemized;
		
	}
	public double getQuote() {
		return quote;
	}
	public void setQuote(double quote) {
		this.quote = quote;
	}
	public HashMap<String, Double> getMatrial() {
		return matrial;
	}
	public void setMatrial(HashMap<String, Double> matrial) {
		this.matrial = matrial;
	}

}
