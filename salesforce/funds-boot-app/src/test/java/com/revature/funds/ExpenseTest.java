package com.revature.funds;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.revature.fundsbootapp.Expense;

public class ExpenseTest {

	@Test
	public void testGetId() {
		Expense expense = new Expense();
		expense.setId(1);
		int id = 1;
		Assert.assertTrue(id == expense.getId());
	}

	@Test
	public void testSetId() {
		Expense expense = new Expense();
		expense.setId(1);
		int id = 1;
		Assert.assertTrue(id == expense.getId());
	}

	@Test
	public void testGetOrganization() {
		Expense expense = new Expense();
		expense.setOrganization("fire");
		String org = "fire";
		Assert.assertEquals(org, expense.getOrganization());
	}

	@Test
	public void testSetOrganization() {
		Expense expense = new Expense();
		expense.setOrganization("fire");
		String org = "fire";
		Assert.assertEquals(org, expense.getOrganization());
	}

	@Test
	public void testGetAmount() {
		Expense expense = new Expense();
		expense.setAmount("1234");
		String amount = "1234";
		Assert.assertEquals(amount, expense.getAmount());
	}

	@Test
	public void testSetAmount() {
		Expense expense = new Expense();
		expense.setAmount("1234");
		String amount = "1234";
		Assert.assertEquals(amount, expense.getAmount());
	}

	@Test
	public void testGetDescription() {
		Expense expense = new Expense();
		expense.setDescription("test description");
		String description = "test description";
		Assert.assertEquals(description, expense.getDescription());
	}

	@Test
	public void testSetDescription() {
		Expense expense = new Expense();
		expense.setDescription("test description");
		String description = "test description";
		Assert.assertEquals(description, expense.getDescription());
	}


	@Test
	public void testGetQuantity() {
		Expense expense = new Expense();
		expense.setQuantity(2);
		int quantity = 2;
		Assert.assertTrue(quantity == expense.getQuantity());
	}

	@Test
	public void testSetQuantity() {
		Expense expense = new Expense();
		expense.setQuantity(2);
		int quantity = 2;
		Assert.assertTrue(quantity == expense.getQuantity());
	}


}
