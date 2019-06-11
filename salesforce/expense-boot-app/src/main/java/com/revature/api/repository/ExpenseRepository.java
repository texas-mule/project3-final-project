package com.revature.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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

/**
 * @author sweinhart
 * @author jparker
 *
 */
@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	/**
	 * Set the Expense Repository
	 * 
	 * @param expenseRepository : ExpenseRepository
	 */
	public void setExpenseRepository(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	/**
	 * Returns a list of Expenses by organization name,
	 * filtered by optional start and end dates.
	 * 
	 * @param organization : String
	 * @param start : String yyyy-MM-dd
	 * @param end : String yyyy-MM-dd
	 * @return List of Expense objects
	 */
	@Transactional
	public List<Expense> findByOrganization(String organization, String start, String end) {
		List<Expense> list = expenseRepository.findByOrganization(organization);
		try {
			if (start != null)
				list.removeIf(e -> LocalDate.parse(e.getDate()).compareTo(LocalDate.parse(start)) < 0);
			if (end != null)
				list.removeIf(e -> LocalDate.parse(e.getDate()).compareTo(LocalDate.parse(end)) > 0);
		} catch (DateTimeParseException e) {
			list = new ArrayList<>();
			return list;
		}
		return list;
	}

	/**
	 * Return all Expense objects in database
	 * 
	 * @return List of Expense objects
	 */
	@Transactional
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	/**
	 * Add or Update an Expense object
	 * 
	 * @param e : Expense object
	 */
	@Transactional
	public void save(Expense e) {
		expenseRepository.save(e);
	}

	/**
	 * Delete an Expense object by Id
	 * 
	 * @param id : Integer
	 */
	@Transactional
	public void delete(Integer id) {
		expenseRepository.deleteById(id);
	}

	/**
	 * Returns a List of Expense Summary objects
	 * filtered by optional start and end dates
	 * 
	 * @param organization : String
	 * @param start : String yyyy-MM-dd
	 * @param end : String yyyy-MM-dd
	 * @return List of ExpenseAbrev objects
	 */
	@Transactional
	public List<ExpenseAbrev> findSummaryByOrganization(String organization, String start, String end) {
		List<Expense> list = findByOrganization(organization, start, end);
		Collections.sort(list);
		ExpenseAbrevList transformedList = new ExpenseAbrevList();
		for (Expense e : list) {
			transformedList.add(ExpenseAbrev.from(e));
		}
		return transformedList.get();
	}

	/**
	 * Returns a List of Expense Summary objects
	 * filtered description and by optional start and end dates
	 * 
	 * @param organization : String
	 * @param description : String
	 * @param start : String yyyy-MM-dd
	 * @param end : String yyyy-MM-dd
	 * @return List of Expense objects
	 */
	@Transactional
	public List<Expense> findByOrganizationAndDescription(String organization, String description, String start,
			String end) {
		List<Expense> list = findByOrganization(organization, start, end);
		Collections.sort(list);
		list.removeIf(e -> !e.getDescription().equals(description));
		return list;
	}

	/**
	 * Returns an Expense object by Organization and Id
	 * 
	 * @param organization : String
	 * @param id : Integer
	 * @return Expense object
	 */
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
