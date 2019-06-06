package com.revature.api.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.api.domain.Expense;
import com.revature.api.domain.ExpenseAbrev;
import com.revature.api.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	HttpServletResponse response;
	
	@Autowired
	ExpenseService expenseService;

	@GetMapping("/{organization}")
	public List<Expense> getByOrganization(@PathVariable("organization") String organization,
			@RequestParam("startDate") Optional<Calendar> startDate,
			@RequestParam("endDate") Optional<Calendar> endDate) throws IOException {
		List<Expense> list = expenseService.findByOrganization(organization);
		Collections.sort(list);
		if (!startDate.isPresent() && !endDate.isPresent()){
			return list;
		}

		List<Expense> filtered = new ArrayList<Expense>();
		if (!startDate.isPresent()){
			for (Expense e : list){
				if (e.getDate().compareTo(endDate.get()) <= 0)
					filtered.add(e);
			}
		}
		else {
			if (!endDate.isPresent()){
				for (Expense e : list){
					if (e.getDate().compareTo(startDate.get()) >= 0)
						filtered.add(e);
				}
			} else {
				for (Expense e : list){
					if (e.getDate().compareTo(startDate.get()) >= 0 && e.getDate().compareTo(endDate.get()) <= 0)
						filtered.add(e);
				}
			}			
		}
		return filtered;
	}
	
	@GetMapping("/{organization}/summary")
	public List<ExpenseAbrev> getByOrganizationSummary(@PathVariable("organization") String organization,
			@RequestParam("startDate") Optional<Calendar> startDate,
			@RequestParam("endDate") Optional<Calendar> endDate) throws IOException {
		List<Expense> list = expenseService.findByOrganization(organization);
		Collections.sort(list);
		List<ExpenseAbrev> filtered = new ArrayList<ExpenseAbrev>();
		if (!startDate.isPresent() && !endDate.isPresent()){
			for (Expense e : list){
				ExpenseAbrev abrev = new ExpenseAbrev();
				abrev.setOrganization(e.getOrganization());
				abrev.setAmount(e.getAmount());
				abrev.setDescription(e.getDescription());
				abrev.setQuantity(e.getQuantity());
				filtered.add(abrev);
			}
			return filtered;
		}

		if (!startDate.isPresent()){
			for (Expense e : list){
				if (e.getDate().compareTo(endDate.get()) <= 0){
					ExpenseAbrev abrev = new ExpenseAbrev();
					abrev.setOrganization(e.getOrganization());
					abrev.setAmount(e.getAmount());
					abrev.setDescription(e.getDescription());
					abrev.setQuantity(e.getQuantity());
					filtered.add(abrev);
				}
				return filtered;
			}
		}
		else {
			if (!endDate.isPresent()){
				for (Expense e : list){
					if (e.getDate().compareTo(startDate.get()) >= 0){
						ExpenseAbrev abrev = new ExpenseAbrev();
						abrev.setOrganization(e.getOrganization());
						abrev.setAmount(e.getAmount());
						abrev.setDescription(e.getDescription());
						abrev.setQuantity(e.getQuantity());
						filtered.add(abrev);
					}
				}
			} else {
				for (Expense e : list){
					if (e.getDate().compareTo(startDate.get()) >= 0 && e.getDate().compareTo(endDate.get()) <= 0){
						ExpenseAbrev abrev = new ExpenseAbrev();
						abrev.setOrganization(e.getOrganization());
						abrev.setAmount(e.getAmount());
						abrev.setDescription(e.getDescription());
						abrev.setQuantity(e.getQuantity());
						filtered.add(abrev);
					}						
				}
			}			
		}
		return filtered;
	}
	
	@GetMapping("/{organization}/{date}")
	public Expense getExpenseByDate(@PathVariable("organization") String organization,
			@PathVariable("date") Calendar date) throws IOException {
		List<Expense> list = expenseService.findByOrganization(organization);
		Collections.sort(list);
		for (Expense e : list){
			if (e.getDate().compareTo(date) == 0)
				return e;
		}
		throw new IOException();
	}

	@PostMapping()
	public HttpServletResponse addExpense(@RequestBody Map<String, Object> payload) {
		System.out.println(payload.toString());
		Expense expense = new Expense();
		expense.setOrganization((String) payload.get("organization"));
		Double d = 0.0;
		if (payload.get("amount").getClass().isInstance(Integer.class)){
			d += (Integer) payload.get("amount");
			expense.setAmount(BigDecimal.valueOf(d));
		} else
			expense.setAmount(BigDecimal.valueOf((Double) payload.get("amount")));
		
		expense.setDate(getDate(payload.get("date").toString()));
		expense.setDescription((String) payload.get("description"));
		expense.setQuantity((Integer) payload.get("quantity"));
		expenseService.save(expense);
		return response;
	}

	private Calendar getDate(String object) {
		String [] date = object.split("-");
		Integer year = Integer.valueOf(date[0]);
		Integer month = Integer.valueOf(date[1]);
		Integer day = Integer.valueOf(date[2]);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal;
	}

	@PutMapping("/{id}")
	public HttpServletResponse updateExpense(@PathVariable("id") Integer id, @RequestBody Map<String, Object> payload) {
		Expense expense = new Expense();
		expense.setId(id);
		expense.setOrganization((String) payload.get("organization"));
		Double d = 0.0;
		if (payload.get("amount").getClass().isInstance(Integer.class)){
			d += (Integer) payload.get("amount");
			expense.setAmount(BigDecimal.valueOf(d));
		} else
			expense.setAmount(BigDecimal.valueOf((Double) payload.get("amount")));
		
		expense.setDate(getDate(payload.get("date").toString()));
		expense.setDescription((String) payload.get("description"));
		expense.setQuantity((Integer) payload.get("quantity"));
		expenseService.save(expense);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public HttpServletResponse deleteExpense(@PathVariable("id") Integer id) {
		expenseService.delete(id);
		return response;
	}
}
