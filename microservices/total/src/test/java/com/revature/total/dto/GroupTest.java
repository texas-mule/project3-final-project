package com.revature.total.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {
	
	BigDecimal amount, amountT;
	String organization, organizationT;
	Group group;
	
	@Before
	public void setUp () {
		amount = new BigDecimal(3.00);
		organization = "Police";
		amountT = new BigDecimal(9.00);
		organizationT = "Fire";
		
		group = new Group(organization, amount);
	}

	@Test
	public void testGetOrganization() {
		assertEquals(organization, group.getOrganization());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetOrganization() {
		group.setOrganization(organizationT);
		assertEquals(organizationT, group.getOrganization());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAmount() {
		assertEquals(amount, group.getAmount());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetAmount() {
		group.setAmount(amountT);
		assertEquals(amountT, group.getAmount());
		//fail("Not yet implemented");
	}

}
