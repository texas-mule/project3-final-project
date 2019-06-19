package com.revature.total.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class ExpenseTest {
	
	BigDecimal total, totalT;
	Date date, dateT;
	String organization, organizationT;
	String description, descriptionT;
	int id, idT;
	int quantity, quantityT;
	Expense expense, expenseT;
	
	@Before
	public void setUp () {
		total = new BigDecimal(3.00);
		date = new Date(2019-01-01);
		organization = "Police";
		description = "Pencil";
		id = 0;
		quantity = 4;
		
		totalT = new BigDecimal(9.00);
		dateT = new Date(2019-02-01);
		organizationT = "Fire";
		descriptionT = "Pen";
		idT = 2;
		quantityT = 16;
		
		expense = new Expense(id, organization, description, total, date, quantity);
	}
	
	@Test
	public void testGetAmount() {
		assertEquals(total, expense.getAmount());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetAmount() {
		expense.setAmount(totalT);
		assertEquals(totalT, expense.getAmount());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetOrganization() {
		assertEquals(organization, expense.getOrganization());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetOrganization() {
		expense.setOrganization(organizationT);
		assertEquals(organizationT, expense.getOrganization());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetDate() {
		assertEquals(date, expense.getDate());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		expense.setDate(dateT);
		assertEquals(dateT, expense.getDate());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		assertEquals(description, expense.getDescription());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		expense.setDescription(descriptionT);
		assertEquals(descriptionT, expense.getDescription());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetQuantity() {
		assertEquals(quantity, expense.getQuantity());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetQuantity() {
		expense.setQuantity(quantityT);
		assertEquals(quantityT, expense.getQuantity());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		assertEquals(id, expense.getId());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		expense.setId(idT);
		assertEquals(idT, expense.getId());
		//fail("Not yet implemented");
	}

}
