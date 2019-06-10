package com.revature.api;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import com.revature.api.domain.Expense;

public class ExpenseTest {

	Expense expense;

	@Before
	public void setup() {
		expense = new Expense();
		expense.setId(1);
		expense.setAmount(new BigDecimal(500.00));
		expense.setDescription("Test");
		expense.setDate(Date.valueOf("2019-06-07"));
		expense.setOrganization("Test");
		expense.setQuantity(5);
	}

	@Test
	public void testGetId() {
		assertEquals((Integer) 1, expense.getId());
	}

	@Test
	public void testGetOrganization() {
		assertEquals("Test", expense.getOrganization());
	}

	@Test
	public void testGetAmount() {
		assertTrue(new Double(500.0).equals(expense.getAmount().doubleValue()));
	}

	@Test
	public void testGetDescription() {
		assertEquals("Test", expense.getDescription());
	}

	@Test
	public void testGetQuantity() {
		assertEquals((Integer) 5, expense.getQuantity());
	}

}
