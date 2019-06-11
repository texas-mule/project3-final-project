package com.revature.funds;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RevenueTest {

	@Test
	public void testGetItem() {
		Revenue revenue = new Revenue();
		String item = "item";
		revenue.setItem(item);
		assertEquals("item", revenue.getItem());
		// fail("Not yet implemented");
	}

	@Test
	public void testSetItem() {
		Revenue revenue = new Revenue();
		String item = "item";
		revenue.setItem(item);
		assertEquals("item", revenue.getItem());
		// fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		Revenue revenue = new Revenue();
		String name = "name";
		revenue.setName(name);
		assertEquals("name", revenue.getName());
		// fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		Revenue revenue = new Revenue();
		String name = "name";
		revenue.setName(name);
		assertEquals("name", revenue.getName());
		// fail("Not yet implemented");
	}

	@Test
	public void testGetCost() {
		Revenue revenue = new Revenue();
		double cost = 2.2;
		revenue.setCost(cost);
		double actual = revenue.getCost();
		Assert.assertTrue(cost == actual);
	}

	@Test
	public void testSetCost() {
		Revenue revenue = new Revenue();
		double cost = 2.2;
		revenue.setCost(cost);
		double actual = revenue.getCost();
		Assert.assertTrue(cost == actual);
	}

	@Test
	public void testGetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
