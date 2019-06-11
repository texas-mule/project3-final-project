package com.revature.api.controller;

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


/**
 * @author sweinhart
 *
 */
@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	private static final String AMOUNT = "amount";

	@Autowired
	ExpenseService expenseService;

	private DecimalFormat df = new DecimalFormat("0.00");
	HttpServletResponse response;

	/**
	 * Adds a new Expense object to the database.
	 * Required fields are Organization, Expense description, 
	 * Expense amount, Date in yyyy-MM-dd, and quantity of items in expenditure
	 * 
	 * @param payload : HTTP request body in json
	 * @return : HTTP response
	 */
	@PostMapping()
	public HttpServletResponse addExpense(@RequestBody Map<String, Object> payload) {
		Expense expense = new Expense();
		expense.setOrganization((String) payload.get("organization"));
		switch (payload.get(AMOUNT).getClass().getName()) {
			case ("java.lang.Integer"): {
				Double d = 0.0;
				d += ((Integer) payload.get(AMOUNT));
				expense.setAmount(df.format(d));
				break;
				}
			case ("java.lang.Double"): {
				expense.setAmount(df.format((Double) payload.get(AMOUNT)));
				break;
				}
			case ("java.lang.String"): {
				expense.setAmount(df.format(Double.valueOf((String) payload.get(AMOUNT))));
				break;
				}
			default:
				expense.setAmount(df.format(Double.valueOf((String) payload.get(AMOUNT))));
		}
		expense.setDate((String) payload.get("date"));
		expense.setDescription((String) payload.get("description"));
		expense.setQuantity((Integer) payload.get("quantity"));
		expenseService.save(expense);
		return response;
	}

	/**
	 * Returns a list of Expense objects by Organization optionally filtered by dates
	 * 
	 * @param organization : Path Variable - Organization Name (String)
	 * @param startDate : (Optional) yyyy-MM-dd
	 * @param endDate : (Optional) yyyy-MM-dd
	 * @return List of Expense objects optionally filtered by dates
	 */
	@GetMapping("/{organization}")
	public List<Expense> getByOrganization(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate){
		String start = startDate.isPresent() ? startDate.get() : null;
		String end = endDate.isPresent() ? endDate.get() : null;
		List<Expense> list = expenseService.findByOrganization(organization, start, end);
		Collections.sort(list);
		return list;
	}

	/**
	 * Returns a list of Expense summary objects by Organization optionally filtered by dates
	 * 
	 * @param organization : Path Variable - Organization Name (String)
	 * @param startDate : (Optional) yyyy-MM-dd
	 * @param endDate : (Optional) yyyy-MM-dd
	 * @return List of Expense objects optionally filtered by dates
	 */
	@GetMapping("/{organization}/summary")
	public List<ExpenseAbrev> getByOrganizationSummary(@PathVariable("organization") String organization,
			@RequestParam("start") Optional<String> startDate, @RequestParam("end") Optional<String> endDate){
		String start = startDate.isPresent() ? startDate.get() : null;
		String end = endDate.isPresent() ? endDate.get() : null;
		return expenseService.findSummaryByOrganization(organization, start, end);
	}

	/**
	 * Returns a list of Expense objects by Organization on a specified date
	 * 
	 * @param organization : Path Variable - Organization Name (String)
	 * @param date : Path Variable - yyyy-MM-dd (String)
	 * @return List of Expense filtered by dates
	 */
	@GetMapping("/{organization}/date/{date}")
	public List<Expense> getExpenseByDate(@PathVariable("organization") String organization,
			@PathVariable("date") String date) {
		List<Expense> list = expenseService.findByOrganization(organization, date, date);
		Collections.sort(list);
		return list;
	}

	/**
	 * Returns a list of Expense objects by Organization 
	 * and Expense description optionally filtered by dates
	 * 
	 * @param organization : Path Variable - Organization Name (String)
	 * @param description : Path Variable - Expense Description (String)
	 * @param startDate : (Optional) yyyy-MM-dd
	 * @param endDate : (Optional) yyyy-MM-dd
	 * @return List of Expense objects optionally filtered by dates
	 */
	@GetMapping("/{organization}/description/{description")
	public List<Expense> getExpenseByDescription(@PathVariable("organization") String organization,
			@PathVariable("description") String description, @RequestParam("start") Optional<String> startDate,
			@RequestParam("end") Optional<String> endDate) {
		String start = startDate.isPresent() ? startDate.get() : null;
		String end = endDate.isPresent() ? endDate.get() : null;
		return expenseService.findByOrganizationAndDescription(organization, description, start, end);
	}

	/**
	 * Updates an existing Expense object in the database.
	 * Required fields are Organization, Expense Id, Expense description, 
	 * Expense amount, Date in yyyy-MM-dd, and quantity of items in expenditure
	 * 
	 * @param payload : HTTP request body in json
	 * @param organization : Path Variable - Organization Name (String)
	 * @param id : Path Variable - Expense id (Integer)
	 * @return : HTTP response
	 */
	@PutMapping("/{organization}/id/{id}")
	public HttpServletResponse updateExpense(@PathVariable("organization") String organization,
			@PathVariable("id") Integer id, @RequestBody Map<String, Object> payload) {
		if (expenseService.getById(organization, id) == null)
			return response;
		Expense expense = new Expense();
		expense.setId(id);
		expense.setOrganization((String) payload.get("organization"));
		switch (payload.get(AMOUNT).getClass().getName()) {
			case ("java.lang.Integer"): {
				Double d = 0.0;
				d += ((Integer) payload.get(AMOUNT));
				expense.setAmount(df.format(d));
				break;
			}
			case ("java.lang.Double"): {
				expense.setAmount(df.format((Double) payload.get(AMOUNT)));
				break;
			}
			case ("java.lang.String"): {
				expense.setAmount(df.format(Double.valueOf((String) payload.get(AMOUNT))));
				break;
			}
			default:
				expense.setAmount(df.format(Double.valueOf((String) payload.get(AMOUNT))));
		}
		expense.setDate((String) payload.get("date"));
		expense.setDescription((String) payload.get("description"));
		expense.setQuantity((Integer) payload.get("quantity"));
		expenseService.save(expense);
		return response;
	}

	/**
	 * Deletes an Expense object in the database
	 * 
	 * @param organization : Path Variable - Organization Name (String)
	 * @param id : Path Variable - Expense id (Integer)
	 * @return HTTP response
	 */
	@DeleteMapping("/{organization}/id/{id}")
	public HttpServletResponse deleteExpense(@PathVariable("organization") String organization,
			@PathVariable("id") Integer id) {
		if (expenseService.getById(organization, id) == null)
			return response;
		expenseService.delete(id);
		return response;
	}

	/**
	 * Returns an Expense object specified by id
	 * @param organization : Path Variable - Organization Name (String)
	 * @param id : Path Variable - Expense id (Integer)
	 * @return Expense
	 */
	@GetMapping("/{organization}/id/{id}")
	public Expense getById(@PathVariable("organization") String organization, @PathVariable("id") Integer id) {
		return expenseService.getById(organization, id);
	}

}
