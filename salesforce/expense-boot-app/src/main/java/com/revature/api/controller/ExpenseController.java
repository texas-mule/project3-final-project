package com.revature.api.controller;

import java.io.IOException;
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
@RequestMapping("/")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	HttpServletResponse response;

	@PostMapping()
	public String addExpense(@RequestBody Map<String, Object> payload, HttpServletResponse res) throws IOException {
		try {
			expenseService.save(Expense.from(payload));
			res.setStatus(HttpServletResponse.SC_CREATED);
			return "record saved";
		} catch (RuntimeException e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			res.setContentType("application/json");
			return "{\r\n" + "  \"message\": \"Bad request. The post body format is as follows:\",\r\n"
					+ "  \"format\": {\r\n" + "    \"organization\": \"<Organization name>\",\r\n"
					+ "    \"amount\": \"<Amount spent as a number>\",\r\n"
					+ "    \"date\": \"<Date string in yyyy-mm-dd format>\",\r\n"
					+ "    \"description\": \"<Brief description>\",\r\n"
					+ "    \"quantity\": \"<How many were purchased as a number>\"\r\n" + "  }\r\n" + "}";
		}
	}

	@GetMapping("/{organization}")
	public List<Expense> getByOrganization(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate)
			throws IOException {
		String start = startDate.orElse(null);
		String end = endDate.orElse(null);
		List<Expense> list = expenseService.findByOrganization(organization, start, end);
		Collections.sort(list);
		return list;
	}

	@GetMapping("/{organization}/summary")
	public List<ExpenseAbrev> getByOrganizationSummary(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate)
			throws IOException {
		String start = startDate.orElse(null);
		String end = endDate.orElse(null);
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

	@GetMapping("/{organization}/description/{description}")
	public List<Expense> getExpenseByDescription(@PathVariable("organization") String organization,
			@PathVariable("description") String description, @RequestParam("start") Optional<String> startDate,
			@RequestParam("end") Optional<String> endDate) {
		String start = startDate.orElse(null);
		String end = endDate.orElse(null);
		return expenseService.findByOrganizationAndDescription(organization, description, start, end);
	}

	@PutMapping("/{organization}/id/{id}")
	public String updateExpense(@PathVariable("organization") String organization, @PathVariable("id") Integer id,
			@RequestBody Map<String, Object> payload, HttpServletResponse res) throws IOException {
		if (expenseService.getById(organization, id) == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return "Not found";
		}
		return addExpense(payload, res);
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
