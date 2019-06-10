package revenue;

import java.math.BigDecimal;
import java.sql.Date;

public class RevenueDomain {

	private String name;
	private String item;
	private BigDecimal cost;
	private Date date;

	public RevenueDomain() {
	}

	public RevenueDomain(String name, String item, BigDecimal cost, Date date) {
		super();
		this.name = name;
		this.item = item;
		this.cost = cost;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "{name: " + this.name + ",revenue: " + this.cost + ",item: " + this.item + "}";
	}

}
