package com.revature.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.revature.api.domain.Expense;

public class ExpenseTest {

	Expense expense;

	/**
	 * Create a new Expense object
	 * Test setters
	 */
	@Before
	public void setup() {
		expense = new Expense();
		expense.setId(1);
		expense.setAmount("500.00");
		expense.setDescription("Test");
		expense.setDate("2019-06-07");
		expense.setOrganization("Test");
		expense.setQuantity(5);
	}

	/**
	 * Test getId
	 */
	@Test
	public void testGetId() {
		assertEquals((Integer) 1, expense.getId());
	}

	/**
	 * Test getOrganization
	 */
	@Test
	public void testGetOrganization() {
		assertEquals("Test", expense.getOrganization());
	}

	/**
	 * Test getAmount
	 */
	@Test
	public void testGetAmount() {
		assertEquals("500.00", expense.getAmount());
	}

	/**
	 * Test getDescription
	 */
	@Test
	public void testGetDescription() {
		assertEquals("Test", expense.getDescription());
	}

	/**
	 * Test getQuantity
	 */
	@Test
	public void testGetQuantity() {
		assertEquals((Integer) 5, expense.getQuantity());
	}
	
	/**
	 * Test getDate
	 */
	@Test
	public void testGetDate() {
		assertEquals("2019-06-07", expense.getDate());
	}

}
