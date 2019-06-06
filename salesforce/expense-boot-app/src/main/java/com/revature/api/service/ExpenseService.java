package com.revature.api.service;


import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.api.domain.Expense;
import com.revature.api.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	public void setExpenseRepository(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	@Transactional
	public List<Expense> findByOrganization(String organization) {
		return expenseRepository.findByOrganization(organization);
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
}
