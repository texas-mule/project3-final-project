package com.revature.total.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class RevenueTest {

	BigDecimal cost, costT;
	String name, nameT, item, itemT;
	Date date, dateT;
	
	Revenue revenue;
	
	@Before
	public void setUp () {
		cost = new BigDecimal(3.00);
		name = "Police";
		costT = new BigDecimal(9.00);
		name = "Fire";
		item = "Pencil";
		itemT = "Pen";
		date = new Date(2019-01-01);
		dateT = new Date(2019-02-02);
		
		revenue = new Revenue(name, item, cost, date);
	}
	
	@Test
	public void testGetName() {
		assertEquals(name, revenue.getName());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		revenue.setName(nameT);
		assertEquals(nameT, revenue.getName());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetItem() {
		assertEquals(item, revenue.getItem());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetItem() {
		revenue.setItem(itemT);
		assertEquals(itemT, revenue.getItem());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCost() {
		assertEquals(cost, revenue.getCost());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetCost() {
		revenue.setCost(costT);
		assertEquals(costT, revenue.getCost());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetDate() {
		assertEquals(date, revenue.getDate());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		revenue.setDate(dateT);
		assertEquals(dateT, revenue.getDate());
		//fail("Not yet implemented");
	}

}
