package framework.account;

import framework.account.entry.IEntry;
import framework.party.Customer;
import framework.party.ICompany;

import java.util.List;

public interface IAccount {
	double getCurrentBalance();
	void addEntry(IEntry entry);
	void notifyCustomer();
	void addInterest();
	String getAccNumber();
	Customer getCustomer();
	double getLastAmountTransaction();
	List<IEntry> getEntries();
	String getType();
	double getInterest();
}
