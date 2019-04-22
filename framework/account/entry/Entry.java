package framework.account.entry;

import java.time.LocalDate;

public class Entry implements IEntry {
	private String name;
	private double amount;
	private LocalDate date;
	
	public Entry(double amount, LocalDate date, String name) {
		this.setName(name);
		this.setAmount(amount);
		this.setDate(date);
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getDate() + " " + getAmount();
	}
}
