package com.example.quotingservice.domain;

public class Mykeys {
private String quote;

public String getKey() {
	return quote;
}

public void setKey(String quote) {
	this.quote = quote;
}

public Mykeys(String quote) {
	super();
	this.quote = quote;
}

}
