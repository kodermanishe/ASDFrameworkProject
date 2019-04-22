package framework.account;

import framework.account.entry.IEntry;
import framework.party.ICompany;

import java.util.List;

public interface IAccount {
	double getCurrentBalance();
	void addEntry(IEntry entry);
	void notifyCustomer();
	void addInterest();
	int getAccNumber();
}
