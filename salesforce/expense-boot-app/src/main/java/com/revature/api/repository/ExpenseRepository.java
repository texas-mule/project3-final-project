package com.revature.api.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.api.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{
	List<Expense> findAll();
	List<Expense> findByOrganization(String organization);
}
