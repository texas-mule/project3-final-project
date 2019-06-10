package com.revature.api.domain;

import java.util.LinkedList;
import java.util.List;

public class ExpenseAbrevList {

	List<ExpenseAbrev> list;

	public ExpenseAbrevList() {
		list = new LinkedList<ExpenseAbrev>();
	}

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

	public List<ExpenseAbrev> get() {
		return list;
	}

}
