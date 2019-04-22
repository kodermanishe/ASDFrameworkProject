package framework.account;

import framework.account.entry.IEntry;
import framework.party.ICompany;

import java.util.List;

public interface IAccount {
	public String getAccountNumber();
	public double getBalance();
	public void depositMoney(double money);
	public void withdrawMoney(double money);
	public ICompany getOwner();
	public void addInterest();
	public List<IEntry> getEntries();
	public void sendNotification();
}
