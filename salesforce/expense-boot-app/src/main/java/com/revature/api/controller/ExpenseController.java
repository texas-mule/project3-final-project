package com.revature.api.controller;

import java.io.IOException;
import java.text.DecimalFormat;
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

	@Autowired
	ExpenseService expenseService;

	private DecimalFormat df = new DecimalFormat("0.00");
	HttpServletResponse response;

	@PostMapping()
	public HttpServletResponse addExpense(@RequestBody Map<String, Object> payload) throws IOException {
		Expense expense = new Expense();
		expense.setOrganization((String) payload.get("organization"));
		switch (payload.get("amount").getClass().getName()) {
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

	@GetMapping("/{organization}")
	public List<Expense> getByOrganization(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate)
			throws IOException {
		String start = startDate.isPresent() ? startDate.get() : null;
		String end = endDate.isPresent() ? endDate.get() : null;
		List<Expense> list = expenseService.findByOrganization(organization, start, end);
		Collections.sort(list);
		return list;
	}

	@GetMapping("/{organization}/summary")
	public List<ExpenseAbrev> getByOrganizationSummary(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate)
			throws IOException {
		String start = startDate.isPresent() ? startDate.get() : null;
		String end = endDate.isPresent() ? endDate.get() : null;
		List<ExpenseAbrev> list = expenseService.findSummaryByOrganization(organization, start, end);
		return list;
	}

	@GetMapping("/{organization}/date/{date}")
	public List<Expense> getExpenseByDate(@PathVariable("organization") String organization,
			@PathVariable("date") String date) throws IOException {
		List<Expense> list = expenseService.findByOrganization(organization, date, date);
		Collections.sort(list);
		return list;
	}

	@GetMapping("/{organization}/description/{description")
	public List<Expense> getExpenseByDescription(@PathVariable("organization") String organization,
			@PathVariable("description") String description, @RequestParam("start") Optional<String> startDate,
			@RequestParam("end") Optional<String> endDate) {
		String start = startDate.isPresent() ? startDate.get() : null;
		String end = endDate.isPresent() ? endDate.get() : null;
		return expenseService.findByOrganizationAndDescription(organization, description, start, end);
	}

	@PutMapping("/{organization}/id/{id}")
	public HttpServletResponse updateExpense(@PathVariable("organization") String organization,
			@PathVariable("id") Integer id, @RequestBody Map<String, Object> payload) {
		if (expenseService.getById(organization, id) == null)
			return response;
		Expense expense = new Expense();
		expense.setId(id);
		expense.setOrganization((String) payload.get("organization"));
		switch (payload.get("amount").getClass().getName()) {
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

	@DeleteMapping("/{organization}/id/{id}")
	public HttpServletResponse deleteExpense(@PathVariable("organization") String organization,
			@PathVariable("id") Integer id) {
		if (expenseService.getById(organization, id) == null)
			return response;
		expenseService.delete(id);
		return response;
	}

	@GetMapping("/{organization}/id/{id}")
	public Expense getById(@PathVariable("organization") String organization, @PathVariable("id") Integer id) {
		return expenseService.getById(organization, id);
	}

}
