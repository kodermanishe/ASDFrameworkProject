package framework.account.entry;

import java.time.LocalDate;

public interface IEntry {
	LocalDate getDate();
	String getName();
	double getAmount();
}
