package revenue;

import java.math.BigDecimal;

public class RevenueNoDate {

	private String name;
	private String item;
	private BigDecimal cost;
	private int quantity;

	public RevenueNoDate() {
		super();
	}

	public RevenueNoDate(String name, String item, BigDecimal cost, int quantity) {
		super();
		this.name = name;
		this.item = item;
		this.cost = cost;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "RevenueNoDate [name=" + name + ", item=" + item + ", cost=" + cost + ", quantity=" + quantity + "]";
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
