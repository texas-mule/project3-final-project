package com.test;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import com.test.RevenueDomain;
public class RevenueDomainTest {

	
	
	@Test
	public void testRevenueDomain() {
		RevenueDomain meme = new RevenueDomain();
		meme.setName("hello");
		Assert.assertEquals(meme.getName(), "hello");
	}

	@Test
	public void testGetName() {
		RevenueDomain meme = new RevenueDomain();
		meme.setName("hello");
		Assert.assertEquals(meme.getName(), "hello");
	}

	@Test
	public void testSetName() {
		RevenueDomain meme = new RevenueDomain();
		meme.setName("hello");
		Assert.assertEquals(meme.getName(), "hello");
	}

	@Test
	public void testGetItem() {
		RevenueDomain meme = new RevenueDomain();
		meme.setItem("hello");
		Assert.assertEquals(meme.getItem(), "hello");
	}

	@Test
	public void testSetItem() {
		RevenueDomain meme = new RevenueDomain();
		meme.setItem("hello");
		Assert.assertEquals(meme.getItem(), "hello");
	}

	@Test
	public void testGetCost() {
		RevenueDomain meme = new RevenueDomain();
		meme.setCost(new BigDecimal(123456.75));
		Assert.assertEquals(meme.getCost(), new BigDecimal(123456.75));
	}

	@Test
	public void testSetCost() {
		RevenueDomain meme = new RevenueDomain();
		meme.setCost(new BigDecimal(123456.75));
		Assert.assertEquals(meme.getCost(), new BigDecimal(123456.75));
	}

	@Test
	public void testGetDate() {
		RevenueDomain meme = new RevenueDomain();
		meme.setDate(new Date(2020-12-02));
		Assert.assertEquals(meme.getDate(), new Date(2020-12-02));
	}

	@Test
	public void testSetDate() {
		
	}

	@Test
	public void testToString() {
		RevenueDomain meme = new RevenueDomain();
		meme.setName("hello");
		Assert.assertEquals(meme.getName(), "hello");
	}

}
