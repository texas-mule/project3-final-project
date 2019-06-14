package com.example.quotingservice.consume;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class SalesForce {
	URL url=null;
	HttpURLConnection con=null;
	String inline="";
	
	public String getInline() {
		return inline;
	}

	public void setInline(String inline) {
		this.inline = inline;
	}

	public SalesForce(){
		try {
			 url=new URL ("http://stockcity-env.smf6wveb2h.us-east-2.elasticbeanstalk.com/stock/Fire%20Department");
	      } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=(HttpURLConnection)url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int responsecode=0;
		try {
			responsecode = con.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc=null;
		
		try {
			 sc = new Scanner(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(responsecode!=200){
			throw new RuntimeException("HTTPResponseCode:"+responsecode);
		}
		else{
			while(sc.hasNext()){
				inline+=sc.nextLine();
			}
			
			
		}
	}
}
