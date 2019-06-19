package com.revature.api.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sweinhart
 * @author jparker
 *
 */
public class ExpenseAbrevList {

	List<ExpenseAbrev> list;

	/**
	 * Empty Constructor
	 */
	public ExpenseAbrevList() {
		list = new LinkedList<>();
	}

	/**
	 * Combines Expense Summary objects that have the 
	 * same organization and description
	 * 
	 * @param ea : ExpenseAbrev object
	 */
	public void add(ExpenseAbrev ea) {
		for (ExpenseAbrev e : list) {
			if (e.getOrganization().equals(ea.getOrganization()) && e.getDescription().equals(ea.getDescription())) {
				e.setAmount(
						((Double) (Double.parseDouble(e.getAmount()) + Double.parseDouble(ea.getAmount()))).toString());
				e.setQuantity(e.getQuantity() + ea.getQuantity());
				return;
			}
		}
		list.add(ea);
	}

	/**
	 * @return ExpenseAbrev list
	 */
	public List<ExpenseAbrev> get() {
		return list;
	}

}
