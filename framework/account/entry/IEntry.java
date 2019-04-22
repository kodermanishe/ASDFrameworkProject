package framework.account.entry;

import java.time.LocalDate;

public interface IEntry {
	public LocalDate getDate();
	
	public String getName();
	
	public double getAmount();
}
