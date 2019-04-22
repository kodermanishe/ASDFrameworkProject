package framework.account.entry;

import java.time.LocalDate;

public interface IEntry {
	LocalDate date();
	String name();
	double amount();
}
