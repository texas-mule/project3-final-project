package com.revature.api.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.google.gson.Gson;

@Entity
@Table(name = "expenses")
public class Expense implements Comparable<Expense> {

	@Id
	@GeneratedValue(generator = "clients_id_seq", strategy = GenerationType.IDENTITY)
	private Integer id;

	@Pattern(regexp = "[a-zA-Z\\s]+")
	@javax.validation.constraints.Size(min = 2, max = 20)
	@NotBlank
	private String organization;

	@Pattern(regexp = "[a-zA-Z\\s]+")
	@javax.validation.constraints.Size(min = 2, max = 20)
	@NotBlank
	private String description;

	private BigDecimal amount;
	private Date date;
	private Integer quantity;

	public Expense() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date object) {
		this.date = object;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@Override
	public int compareTo(Expense o) {
		return date.compareTo(o.date);
	}

	public static Expense from(Map<String, Object> payload) throws RuntimeException {
		Expense expense = new Expense();
		expense.setOrganization((String) payload.get("organization"));
		Object amount = payload.get("amount");
		String amountClass = amount.getClass().getName();
		switch (amountClass) {
		case ("java.lang.Integer"): {
			expense.setAmount(BigDecimal.valueOf((Integer)amount));
			break;
		}
		case ("java.lang.Double"): {
			expense.setAmount(BigDecimal.valueOf((Double)amount));
			break;
		}
		case ("java.lang.String"): {
			expense.setAmount(BigDecimal.valueOf(Double.parseDouble((String) amount)));
			break;
		}
		}
		expense.setDate(Date.valueOf((String) payload.get("date")));
		expense.setDescription((String) payload.get("description"));
		expense.setQuantity((Integer) payload.get("quantity"));
		return expense;
	}

}
