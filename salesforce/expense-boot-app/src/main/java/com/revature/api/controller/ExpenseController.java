package com.revature.api.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

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
	private DecimalFormat df = new DecimalFormat("0.00");

	HttpServletResponse response;
	
	@Autowired
	ExpenseService expenseService;

	@GetMapping("/{organization}")
	public List<Expense> getByOrganization(@PathVariable("organization") String organization,
			@RequestParam("startDate") Optional<String> startDate,
			@RequestParam("endDate") Optional<String> endDate) throws IOException {
		List<Expense> list = expenseService.findByOrganization(organization);
		Collections.sort(list);
		if (!startDate.isPresent() && !endDate.isPresent()){
			return list;
		}

		List<Expense> filtered = new ArrayList<Expense>();
		if (!startDate.isPresent()){
			for (Expense e : list){

				if (getDate(e.getDate()).compareTo(endDate.get()) <= 0)
					filtered.add(e);
			}
		}
		else {
			if (!endDate.isPresent()){
				for (Expense e : list){
					int i = getDate(e.getDate()).compareTo(startDate.get());
					if (getDate(e.getDate()).compareTo(startDate.get()) >= 0)
						filtered.add(e);
				}
			} else {
				for (Expense e : list){
					if (getDate(e.getDate()).compareTo(startDate.get()) >= 0 && getDate(e.getDate()).compareTo(endDate.get()) <= 0)
						filtered.add(e);
				}
			}			
		}
		return filtered;
	}
	
	private String getDate(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = cal.getTime();
		return sdf.format(date);
	}

	@GetMapping("/{organization}/summary")
	public List<ExpenseAbrev> getByOrganizationSummary(@PathVariable("organization") String organization,
			@RequestParam("startDate") Optional<String> startDate,
			@RequestParam("endDate") Optional<String> endDate) throws IOException {
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
				if (getDate(e.getDate()).compareTo(endDate.get()) <= 0){
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
					if (getDate(e.getDate()).compareTo(startDate.get()) >= 0){
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
					if (getDate(e.getDate()).compareTo(startDate.get()) >= 0 && getDate(e.getDate()).compareTo(endDate.get()) <= 0){
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
	public HttpServletResponse addExpense(@RequestBody Map<String, Object> payload) throws IOException {
		Expense expense = new Expense();
		expense.setOrganization((String) payload.get("organization"));
		switch (payload.get("amount").getClass().getName()){
			case ("java.lang.Integer"): {
				Double d = 0.0;
				d += ((Integer) payload.get("amount"));
				expense.setAmount(df.format(d));
				break;
		}
			case ("java.lang.Double"): {
				expense.setAmount(df.format((Double) payload.get("amount")));
				break;
		}
			case ("java.lang.String"): {
				expense.setAmount(df.format(Double.valueOf((String) payload.get("amount"))));
				break;
			}
		}		
		expense.setDate((String) payload.get("date"));
		expense.setDescription((String) payload.get("description"));
		expense.setQuantity((Integer) payload.get("quantity"));
		expenseService.save(expense);
		return response;
	}



	@PutMapping("/{id}")
	public HttpServletResponse updateExpense(@PathVariable("id") Integer id, @RequestBody Map<String, Object> payload) {
		Expense expense = new Expense();
		expense.setId(id);
		expense.setOrganization((String) payload.get("organization"));
		switch (payload.get("amount").getClass().getName()){
			case ("java.lang.Integer"): {
				Double d = 0.0;
				d += ((Integer) payload.get("amount"));
				expense.setAmount(df.format(d));
				break;
		}
			case ("java.lang.Double"): {
				expense.setAmount(df.format((Double) payload.get("amount")));
				break;
		}
			case ("java.lang.String"): {
				expense.setAmount(df.format(Double.valueOf((String) payload.get("amount"))));
				break;
			}
		}		
		expense.setDate((String) payload.get("date"));
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
