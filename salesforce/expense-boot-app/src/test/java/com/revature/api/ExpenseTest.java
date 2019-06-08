package com.revature.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.api.domain.Expense;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExpenseTest {
	
	Expense expense;
	
	@Before
	public void setup(){
	expense = new Expense();
	expense.setId(1);
	expense.setAmount("500.00");
	expense.setDescription("Test");
	expense.setDate("2019-06-07");
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
		assertEquals("500.00" , expense.getAmount());
	}


	@Test
	public void testGetDescription() {
		assertEquals("Test", expense.getDescription());
	}


	@Test
	public void testGetDate() {
		assertEquals("2019-06-07", getDate(expense.getDate()));
	}


	@Test
	public void testGetQuantity() {
		assertEquals((Integer) 5, expense.getQuantity());
	}
	
	private String getDate(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = cal.getTime();
		System.out.println(sdf.format(date));
		return sdf.format(date);
	}
}
