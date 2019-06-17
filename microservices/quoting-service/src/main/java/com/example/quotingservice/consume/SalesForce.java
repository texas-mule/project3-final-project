package com.example.quotingservice.consume;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
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
	//String urlParameters  = 
	//URL url = new URL("");
	//String request        = "";
	public void call_me(String name, double quote, int sqFeet, double labor) throws Exception {
		
		//String data = "name="+name+"&quote="+Double.toString(quote)+"&sqFeet="+Double.toString(sqFeet)+"&labor="+Double.toString(labor);
	       URL url = new URL("http://buildingsmylife.k9grpmjmya.us-east-2.elasticbeanstalk.com/buildings/building?"+"name="+name+"&quote="+Double.toString(quote)+"&sqFeet="+Integer.toString(sqFeet)+"&labor="+Double.toString(labor));
	       HttpURLConnection con = (HttpURLConnection) url.openConnection();
	       con.setRequestMethod("POST");
	       con.setDoOutput(true);
	       //con.getOutputStream().write(data.getBytes("UTF-8"));
	       con.getInputStream();  
	       //name=fire&quote=22.00&sqFeet=100&labor=22.00
}
}
