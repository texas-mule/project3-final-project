package com.revature.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.api.domain.Expense;

/**
 * @author swein
 *
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	
	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	List<Expense> findAll();

	/**
	 * Return a list of Expense objects by organization
	 * 
	 * @param organization : String
	 * @return List of Expense objects
	 */
	List<Expense> findByOrganization(String organization);
}
