package framework.account.entry;

import java.time.LocalDate;

public class Entry implements IEntry {
	private String name;
	private double amount;
	private LocalDate date;
	
	public Entry(double amount, LocalDate date, String name) {
		this.name = name;
		this.amount = amount;
		this.date = date;
	}

	@Override
	public String toString() {
		return getName() + " " + getDate() + " " + getAmount();
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getAmount() {
		return amount;
	}
}
