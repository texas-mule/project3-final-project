package com.revature.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.api.domain.Expense;
import com.revature.api.domain.ExpenseAbrev;
import com.revature.api.domain.ExpenseAbrevList;
import com.revature.api.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public void setExpenseRepository(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	@Transactional
	public List<Expense> findByOrganization(String organization, String start, String end) {
		List<Expense> list = expenseRepository.findByOrganization(organization);
		try {
			if (start != null)
				list.removeIf(e -> LocalDate.parse(e.getDate()).compareTo(LocalDate.parse(start)) < 0);
			if (end != null)
				list.removeIf(e -> LocalDate.parse(e.getDate()).compareTo(LocalDate.parse(end)) > 0);
		} catch (DateTimeParseException e) {
			return null;
		}
		return list;
	}

	@Transactional
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	@Transactional
	public void save(Expense e) {
		expenseRepository.save(e);
	}

	@Transactional
	public void delete(Integer id) {
		expenseRepository.deleteById(id);
	}

	public List<ExpenseAbrev> findSummaryByOrganization(String organization, String start, String end) {
		List<Expense> list = findByOrganization(organization, start, end);
		Collections.sort(list);
		ExpenseAbrevList transformedList = new ExpenseAbrevList();
		for (Expense e : list) {
			transformedList.add(ExpenseAbrev.from(e));
		}
		return transformedList.get();
	}

	public List<Expense> findByOrganizationAndDescription(String organization, String description, String start,
			String end) {
		List<Expense> list = findByOrganization(organization, start, end);
		Collections.sort(list);
		list.removeIf(e -> !e.getDescription().equals(description));
		return list;
	}

	public Expense getById(String organization, Integer id) {
		Optional<Expense> oe = expenseRepository.findById(id);
		if (oe.isPresent()) {
			Expense e = oe.get();
			if (!e.getOrganization().equals(organization))
				return null;
			return e;
		}
		return null;
	}

}
