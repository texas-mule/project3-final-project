package com.revature.api;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.revature.api.domain.ExpenseAbrev;
import com.revature.api.domain.ExpenseAbrevList;

public class ExpenseAbrevListTest {

	ExpenseAbrevList expenseList;
	ExpenseAbrev expense1;
	ExpenseAbrev expense2;

	/**
	 * Create two expense objects and add to list
	 */
	@Before
	public void setup() {
		expenseList = new ExpenseAbrevList();
		expense1 = new ExpenseAbrev();
		expense2 = new ExpenseAbrev();
		expense1.setAmount("20.00");
		expense1.setDescription("pens");
		expense1.setOrganization("test");
		expense1.setQuantity(5);
		expense2.setAmount("20.00");
		expense2.setDescription("pens");
		expense2.setOrganization("test");
		expense2.setQuantity(5);
		expenseList.add(expense1);
		expenseList.add(expense2);
	}

	/**
	 * Verify list is size 1 and amount field is combined
	 * from the two expenses.
	 * Add another expense object with a different description
	 * and verify list size is now two.
	 */
	@Test
	public void testGetListSize() {
		List<ExpenseAbrev> newList = expenseList.get();
		assertEquals(1, newList.size());
		assertEquals("40.0" , newList.get(0).getAmount());
		expense2.setDescription("pencils");
		expenseList.add(expense2);
		newList = expenseList.get();
		assertEquals(2, newList.size());
	}

}
