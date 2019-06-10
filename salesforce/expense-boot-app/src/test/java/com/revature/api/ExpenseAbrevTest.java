package com.revature.api;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.revature.api.domain.ExpenseAbrev;

public class ExpenseAbrevTest {

	ExpenseAbrev expense;

	/**
	 * Create a new expense summary object.
	 * Test the setters.
	 */
	@Before
	public void setup() {
		expense = new ExpenseAbrev();
		expense.setAmount("500.00");
		expense.setDescription("Test");
		expense.setOrganization("Test");
		expense.setQuantity(5);
	}

	/**
	 * Test getOrganzation
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

}
