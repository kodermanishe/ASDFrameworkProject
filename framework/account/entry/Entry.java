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
		return name() + " " + date() + " " + amount();
	}

	@Override
	public LocalDate date() {
		return date;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public double amount() {
		return amount;
	}
}
